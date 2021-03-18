package com.nsw.backend.vroot.controller;

import com.nsw.backend.model.SendVNC;
import com.nsw.backend.util.ResponseJson;
import com.nsw.backend.vroot.dto.TbsDanhMucDto;
import com.nsw.backend.vroot.message25.Content25;
import com.nsw.backend.vroot.message25.EnvelopXmlService;
import com.nsw.backend.vroot.model.SynchronizeMessage;
import com.nsw.backend.vroot.model.TBSDANHMUC25;
import com.nsw.backend.vroot.model.TbdMessage;
import com.nsw.backend.vroot.service.SynchronizeMessageService;
import com.nsw.backend.vroot.service.TbdMessageService;
import com.nsw.backend.vroot.service.TbsDanhmuc25Service;
import com.nsw.backend.vroot.util.Helper;
import com.nsw.backend.ws.client.ResponseDownload;
import org.json.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/controller")
public class VROOTController extends BaseController{
    public static final Logger logger = LoggerFactory.getLogger(VROOTController.class);

    @Autowired
    private Environment environment;
    @Autowired
    private SynchronizeMessageService synchronizeMessageService;
    @Autowired
    private TbdMessageService tbdMessageService;
    @Autowired
    EnvelopXmlService envelopXmlService;
    @Autowired
    private TbsDanhmuc25Service tbsDanhmuc25Service;
    //xem file
    @RequestMapping(value = "/viewfile/", method = RequestMethod.GET)
    public HttpEntity<byte[]> fileDownload(@RequestParam("filePath") String filePath,
                                           @RequestParam("fileName") String fileName) throws IOException {

        StringBuilder fullPathBuilder= new StringBuilder();
        if(filePath.endsWith("/")){
            fullPathBuilder.append(filePath).append(fileName);
        }else {
            fullPathBuilder.append(filePath).append("/").append(fileName);
        }
        File file = new File(fullPathBuilder.toString());

        FileInputStream fileInputStream = null;
        byte[] content = new byte[(int) file.length()];

        fileInputStream = new FileInputStream(file);
        fileInputStream.read(content);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + fileName.replace(" ", "_"));
        header.setContentLength(content.length);

        return new HttpEntity<byte[]>(content, header);
    }

    //dong bo trong ngay
    @RequestMapping(value = "/syncmessage/", method = RequestMethod.GET)
    public ResponseEntity<ResponseJson> synchronizeMessage(@RequestParam("ngay") int ngay,@RequestParam("thang") int thang,@RequestParam("nam") int nam){

        try {
            Calendar from =Calendar.getInstance();
            from.set(Calendar.HOUR_OF_DAY,0);
            from.set(Calendar.MINUTE,0);
            from.set(Calendar.SECOND,0);

            from.set(Calendar.DAY_OF_MONTH,ngay);
            from.set(Calendar.MONTH,thang-1);
            from.set(Calendar.YEAR,nam);

            Calendar to =Calendar.getInstance();
            to.set(Calendar.HOUR_OF_DAY,0);
            to.set(Calendar.MINUTE,0);
            to.set(Calendar.SECOND,0);

            to.set(Calendar.DAY_OF_MONTH,ngay+1);
            to.set(Calendar.MONTH,thang-1);
            to.set(Calendar.YEAR,nam);

            List<SynchronizeMessage> synchronizeMessageList = synchronizeMessageService.findByCreatedDateToDate(from.getTime(),to.getTime());
            if(synchronizeMessageList!=null&&!synchronizeMessageList.isEmpty()){
                logger.info("size synchronizeMessageList: "+synchronizeMessageList.size());
                List<TbdMessage> messageList = new ArrayList<>();
                for (SynchronizeMessage synchronizeMessage:synchronizeMessageList){
                    TbdMessage tbdMessage = new TbdMessage();
                    tbdMessage.setFiMahoso(synchronizeMessage.getReference());
                    tbdMessage.setFiYeucau(synchronizeMessage.getContent());
                    tbdMessage.setFiNgayTao(synchronizeMessage.getCreatedDate());
                    messageList.add(tbdMessage);
                }
                tbdMessageService.updateAll(messageList);
            }
            return createResponse(synchronizeMessageList,true, "size"+synchronizeMessageList.size());
        }catch (Exception e){
            return createResponse("",false,e.getMessage());
        }
    }

    //gui sang VNC


    @PostMapping(value = "/get-message")
    public ResponseEntity<ResponseJson> getMessage(@RequestBody Content25 content25){
        try {
            logger.info("vao ham");
            String xml = envelopXmlService.ObjectToXml(content25);
            logger.info("===========================> Message toi: "+xml);
            return createResponse("",sendToVNC(xml),"success");
        }catch (Exception e){
            logger.info(e.getMessage());
            return createResponse("",false,e.getMessage());
        }
    }

    public ResponseDownload downloadFile(String url, String filePath, String fileName) throws Exception {
        URI uri;
        try {
            uri = new URI(url);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
            parts.add("filePath", filePath);
            parts.add("fileName", fileName);
            ResponseDownload res = restTemplate.postForObject(uri, parts, ResponseDownload.class);
            return res;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return null;
    }
    public ResponseEntity<ResponseJson> createResponse(ResponseDownload res, boolean isSuccess, String errorMessage,
                                                       HttpStatus httpStatus) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(res);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
        logger.info("response = " + objResponse.toString());
        return new ResponseEntity<>(objResponse, httpStatus);
    }

    private boolean sendToVNC(String message){
        String token = environment.getProperty("TOKEN");
        String url = environment.getProperty("URL_SERVICE");
        try {
            logger.info("Bat dau gui toi: "+url);
            String response = executePost(url, "token=" + token + "&data=" + encodeValue(message));
            logger.info("Response: "+response);
            if(!response.equals("Error")){
                return true;
            }else{
                return  false;
            }
        }catch (Exception e){
            logger.info(e.getMessage());
            return  false;
        }
    }

    public String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection

            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return "Error";
    }

    private static String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    @PostMapping(value = "/mard/category")
    public ResponseEntity<ResponseJson> themDanhMucDVT(@RequestBody TbsDanhMucDto tbsdanhmuc25){
        try {
            boolean isEnd=false;
            String message="success";
            String catName=Helper.switchCategoryTypeByCatNo(tbsdanhmuc25.getFiCatNo());
            switch (tbsdanhmuc25.getAction()){
                case 1:
                    boolean checkExists = checkExists(tbsdanhmuc25);
                    if (checkExists){
                        isEnd = false;
                        message="Da ton tai danh muc";
                        break;
                    }
                    //insert
                    Long fiCatTypeMax = tbsDanhmuc25Service.findFiMaxCatTypeByFiCatNo(tbsdanhmuc25.getFiCatNo());
                    TBSDANHMUC25 tbsdanhmuc25Entity = new TBSDANHMUC25();
                    BeanUtils.copyProperties(tbsdanhmuc25,tbsdanhmuc25Entity);
                    tbsdanhmuc25Entity.setFiCatName(catName);
                    tbsdanhmuc25Entity.setFiCreatedBy("API Service");
                    tbsdanhmuc25Entity.setFiCreatedDate(new Date());
                    tbsdanhmuc25Entity.setFiCatType(fiCatTypeMax+1L);
                    tbsDanhmuc25Service.save(tbsdanhmuc25Entity);
                    isEnd=true;
                    break;
                case 0:
                    //update
                    isEnd=true;
                    break;
                case -1:
                    //delete
                    List<TBSDANHMUC25> tbsdanhmuc25List= tbsDanhmuc25Service.findByFiCatNoAndFiCatNote(tbsdanhmuc25.getFiCatNo(),tbsdanhmuc25.getFiCatNote());
                    for (TBSDANHMUC25 entity: tbsdanhmuc25List){
                        tbsDanhmuc25Service.delete(entity);
                    }
                    isEnd=true;
                    break;
                default:
                    isEnd=false;
                    break;
            }
            return createResponse("",isEnd,message);
        }catch (Exception e){
            logger.info(e.getMessage());
            return createResponse("",false,e.getMessage());
        }
    }
    private boolean checkExists(TbsDanhMucDto tbsdanhmuc25){
        List<TBSDANHMUC25> listTbsdanhmuc25s= tbsDanhmuc25Service.findByFiCatNoAndFiCatNote(tbsdanhmuc25.getFiCatNo(),tbsdanhmuc25.getFiCatNote());
        if (listTbsdanhmuc25s==null||listTbsdanhmuc25s.isEmpty()){
            return false;
        }
        return true;
    }
}
