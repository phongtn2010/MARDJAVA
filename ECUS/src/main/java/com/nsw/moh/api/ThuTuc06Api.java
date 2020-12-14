/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.annotations.ValidatorUtil;
import com.nsw.common.model.DataPost;
import com.nsw.common.model.json.MessageJson;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.moh.helper.ThuTuc06Helper;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.moh.constant.ThuTuc06Constant;
import com.nsw.moh.p06.model.*;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.LogUtil;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Nhan
 */
@RestController
@RequestMapping("/moh/01")
public class ThuTuc06Api {

    static final Logger logger = LoggerFactory.getLogger(ThuTuc06Api.class);
    private static final String CLASS_NAME = "ThuTuc06Api";
    @Autowired
    Environment environment;
    @Autowired
    RabbitMQService rabbitMQService;
    ThuTuc06Helper helper = new ThuTuc06Helper();
    @Autowired
    MessageSource messageSource;

    /**
     * Tao moi ho so
     *
     * @param hoso
     * @param loc
     * @return
     */
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson createHoSo(@RequestBody Tbdhoso6 hoso, Locale loc) {
        ResponseJson json = new ResponseJson();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;
            hoso.setFiMst(user.getUsername());
            hoso.setFiTendn(user.getCompanyName());
            hoso.setFiDiachidn(user.getCompanyAddress());
            hoso.setFiSodtdn(user.getCompanyPhoneNumber());
            hoso.setFiFaxdn(user.getCompanyFax());
            hoso.setFiEmaildn(user.getCompanyEmail());
            hoso.setFiTennguoidaidien(user.getRepresenterName());
            hoso.setFiDienthoaidd(user.getRepresenterMobile());
            hoso.setFiDienthoaicd(user.getRepresenterPhone());
            hoso.setFiLoaihinhdn(user.getCompanyType());
            hoso.setFiPhongbanquanly(user.getDepartmentManage());
            hoso.setFiTentienganhdn(user.getEngName());
            hoso.setFiTenviettatdn(user.getShortName());
            hoso.setFiSodkkd(user.getRegistrationNo());

            Date today = Calendar.getInstance().getTime();

            if (hoso.getFiIdHoso().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                hoso.setFiNguoitao(user.getUsername());
                hoso.setFiNgaytao(today);
                hoso.setFiTrangthai(ThuTuc06Constant.Status.TAO_MOI);
                hoso.setFiTentrangthai(messageSource.getMessage(ThuTuc06Constant.Status.TAOMOISTRING, null, loc));
                //filter xss
                //ValidatorUtil.xssSanitization(hoso);
                json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso);
            } else {
                Tbdhoso6 oldHoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso.getFiIdHoso());
                hoso.setFiNgaytao(oldHoso.getFiNgaytao());
                //ValidatorUtil.xssSanitization(hoso);
                json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso);
            }

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
        }
        return json;
    }

    @RequestMapping(value = {"/send"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson sendHoSo(@RequestBody Tbdhoso6 hoso, Locale loc) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;
            Long id = 0L;
            if (user != null) {
                Date today = Calendar.getInstance().getTime();
                if (hoso.getFiIdHoso().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                    hoso.setFiNguoitao(user.getUsername());
                    hoso.setFiNgaytao(today);
                    hoso.setFiTrangthai(ThuTuc06Constant.Status.TAO_MOI);
                    hoso.setFiTentrangthai(messageSource.getMessage(ThuTuc06Constant.Status.TAOMOISTRING, null, loc));
                    //filter xss
                    //ValidatorUtil.xssSanitization(hoso);
                    json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso);
                    //get ho so id
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String jsonData = mapper.writeValueAsString(json.getData());
                    hoso = mapper.readValue(jsonData, Tbdhoso6.class);
                    id = hoso.getFiIdHoso();
                } else {
                    Tbdhoso6 oldHoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso.getFiIdHoso());
                    if (hasSendPermission(oldHoso)) {
                        hoso.setFiNgaytao(oldHoso.getFiNgaytao());
                        //filter xss
                        //ValidatorUtil.xssSanitization(hoso);
                        json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso);
                        id = hoso.getFiIdHoso();
                    }
                }
                Object data = json.getData();

                if (json.isSuccess()) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiIdHoso(id);
                    sendMessage.setType(ThuTuc06Constant.BANTIN.BANTINGUI);
                    sendMessage.setFunction(ThuTuc06Constant.RES_FUNTION.TIEPNHAN);
                    json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO_SEND)),
                            sendMessage, mqInfo);
                    boolean canUpdate = json.isSuccess();
                    System.out.println(canUpdate);
                    if (canUpdate) {
                        hoso.setFiNgaygui(new Date());
                        hoso.setFiTrangthai(ThuTuc06Constant.Status.CHO_XAC_NHAN_NOP_PHI);
                        hoso.setFiTentrangthai(messageSource.getMessage(ThuTuc06Constant.Status.CHOXACNHANNOPPHI, null, loc));
//                        json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso);
                    } else {
                        json.setData(data);
                    }
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            logger.error(ex.getMessage());
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
        }
        return json;
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson searchHoSo(@RequestBody SearchForm06 search) {
        ResponseJson json = new ResponseJson();
        String uri = getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO_SEARCH));
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;
            if (search.getNgayTaoDenNgay() != null) {
                Date denngay = search.getNgayTaoDenNgay();
                Calendar cal = Calendar.getInstance();
                cal.setTime(denngay);
                cal.add(Calendar.DATE, 1);
                denngay = cal.getTime();
                search.setNgayTaoDenNgay(denngay);
            }

            if (user != null) {
                //search.setNguoiTao(user.getUsername());
                json = helper.searchHoSo(uri, search);
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            logger.error(ex.getMessage());
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
        }
        return json;
    }

    /**
     * Xoa ho so
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson deleteHoSo(@RequestBody DataPost data) {
        ResponseJson json = new ResponseJson();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;
            if (user != null) {
                json = helper.deleteHoSo(
                        getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)),
                        data.getFiIdHoso()
                );
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
        }
        return json;
    }

    /**
     * generate key hien thi upload dialog
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/key"}, method = RequestMethod.POST)
    public @ResponseBody
    String gegeneratekey(@RequestBody UploadSecretKey data) {
        String frameId = data.getFrameId();
        String tenTaiLieu = data.getTenTaiLieu();
        String maTaiLieu = data.getMaTaiLieu();
        Long currentTime = System.currentTimeMillis();
        String generateStr = frameId + maTaiLieu + tenTaiLieu + currentTime
                + ThuTuc06Constant.UploadAccount.USER + ThuTuc06Constant.UploadAccount.PASSWORD;
        String token = generateMD5(generateStr).toUpperCase();
        String baseString = "frameId=" + frameId + "&matailieu=" + maTaiLieu + "&tentailieu=" + tenTaiLieu + "&thoigian=" + currentTime
                + "&user=" + ThuTuc06Constant.UploadAccount.USER + "&token=" + token;

        String key = "";
        try {
            byte[] bytesEncoded = Base64.encodeBase64(baseString.getBytes("UTF-8"));
            key = new String(bytesEncoded, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(ThuTuc06Api.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    @RequestMapping(value = {"/deleteFile/{id}"}, method = RequestMethod.POST)
    public boolean deleteFile(@PathVariable String id) {
        String url = environment.getRequiredProperty(ThuTuc06Constant.API.FILEDELETE);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(
                BasicScheme.authenticate(new UsernamePasswordCredentials(
                        environment.getRequiredProperty(ThuTuc06Constant.DATA_LABLE.USER),
                        environment.getRequiredProperty(ThuTuc06Constant.DATA_LABLE.PASSWORD)
                ),
                        "UTF-8",
                        false
                )
        );
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("fileId", String.valueOf(id)));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(ThuTuc06Api.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            CloseableHttpClient httpClient =  HttpClients.createDefault();
            httpClient.execute(httpPost);
            httpClient.close();
            return true;
        } catch (Exception e) {
            LogUtil.addLog(e);
            return false;
        }
    }

    @RequestMapping(value = {"/district/{id}"}, method = RequestMethod.POST)
    public ResponseJson getDistrict(@PathVariable String id) {
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        ResponseJson district = helper.getDanhMuc(
                apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.QUANHUYEN) + id,
                rabbitMQService.getRabbitMQInfo()
        );
        return district;
    }

    @RequestMapping(value = {"/history/{id}"}, method = RequestMethod.POST)
    public ResponseJson getHistory(@PathVariable String id) {
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        ResponseJson history = helper.getDanhMuc(
                apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.LICHSU) + id,
                rabbitMQService.getRabbitMQInfo()
        );
        return history;
    }

    @RequestMapping(value = {"/gethoso/{id}"}, method = RequestMethod.POST)
    public ResponseJson getHoso(@PathVariable String id) {
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        ResponseJson hoso = helper.getDanhMuc(
                apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.HOSO) + id,
                rabbitMQService.getRabbitMQInfo()
        );
        return hoso;
    }

    /**
     * gui ho so tu man hinh danh sanh ho so
     *
     * @param str
     * @param loc
     * @return
     */
    @RequestMapping(value = {"/sendOne"}, method = RequestMethod.POST)
    public @ResponseBody
    MessageJson sendOne(@RequestBody String str, Locale loc) {
        String id = (String) str;
        String idHoso = id.split("-")[0];
        boolean isSign = Boolean.parseBoolean(id.split("-")[1]);

        Tbdhoso6 hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), Long.parseLong(idHoso));
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        MessageJson jsonReturn = new MessageJson();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;
            if (user != null) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setFiIdHoso(hoso.getFiIdHoso());
                sendMessage.setType(ThuTuc06Constant.BANTIN.BANTINGUI);
                sendMessage.setFunction(ThuTuc06Constant.RES_FUNTION.TIEPNHAN);
                sendMessage.setGetXmlNotSend(isSign);
                json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO_SEND)),
                        sendMessage, mqInfo);
                jsonReturn.setSuccess(json.getSuccess());
                if (isSign) {
                    jsonReturn.setXmlData(json.getData());
                }
                jsonReturn.setMessage(json.getMessage());
                jsonReturn.setFiIdHoso(hoso.getFiIdHoso());
            } else {
                jsonReturn.setSuccess(false);
                jsonReturn.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            jsonReturn.setSuccess(false);
            jsonReturn.setMessage(ex.getMessage());
        }
        return jsonReturn;
    }

    /**
     * *
     * Luu va lay ban tin xml
     *
     * @param hoso
     * @return
     */
    @RequestMapping(value = {"/xml"}, method = RequestMethod.POST)
    public @ResponseBody
    MessageJson getXmlHoSo(@RequestBody Tbdhoso6 hoso, Locale loc) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        MessageJson jsonReturn = new MessageJson();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                Date today = Calendar.getInstance().getTime();
                if (hoso.getFiIdHoso().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                    hoso.setFiNguoitao(user.getUsername());
                    hoso.setFiNgaytao(today);
                    hoso.setFiTrangthai(ThuTuc06Constant.Status.TAO_MOI);
                    hoso.setFiTentrangthai(messageSource.getMessage(ThuTuc06Constant.Status.TAOMOISTRING, null, loc));
                    json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso);
                } else if (hasSendPermission(hoso)) {
                    json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), hoso);
                }

                if (json.isSuccess()) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiIdHoso(hoso.getFiIdHoso());
                    sendMessage.setType(ThuTuc06Constant.BANTIN.BANTINGUI);
                    sendMessage.setFunction(ThuTuc06Constant.RES_FUNTION.TIEPNHAN);
                    sendMessage.setGetXmlNotSend(true);
                    json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO_SEND)),
                            sendMessage, mqInfo);
                    jsonReturn.setSuccess(json.isSuccess());
                    jsonReturn.setXmlData(json.getData());
                    jsonReturn.setMessage(json.getMessage());
                    jsonReturn.setFiIdHoso(hoso.getFiIdHoso());
                }
            } else {
                jsonReturn.setSuccess(false);
                jsonReturn.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            jsonReturn.setSuccess(false);
            jsonReturn.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return jsonReturn;
    }

    /**
     *
     * @param message
     * @return
     */
    @RequestMapping(value = {"/sendwithsignature"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson guiHoSo(@RequestBody SendMessage message) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {

                SendMessage sendMessage = new SendMessage();
                sendMessage.setSignedXml(message.getSignedXml());
                sendMessage.setFiIdHoso(message.getFiIdHoso());
                sendMessage.setType(ThuTuc06Constant.BANTIN.BANTINGUI);
                sendMessage.setFunction(ThuTuc06Constant.RES_FUNTION.TIEPNHAN);

                sendMessage.setFiIdCqxl(message.getFiIdCqxl());
                sendMessage.setFiIdHoso(message.getFiIdHoso());
                sendMessage.setGetXmlNotSend(false);

                message.setType(ThuTuc06Constant.BANTIN.BANTINGUI);
                message.setFunction(ThuTuc06Constant.RES_FUNTION.TIEPNHAN);
                sendMessage.setGetXmlNotSend(false);
                json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO_SEND)), message, mqInfo);

            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    @RequestMapping(value = {"/findbaohanh"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getBaoHanhByMst(@RequestBody Object mst) {
        LinkedHashMap data = (LinkedHashMap) mst;
        String masothue = (String) data.get("mst");
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        ResponseJson baohanh = helper.getDanhMuc(
                apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.BAOHANH) + masothue,
                rabbitMQService.getRabbitMQInfo()
        );
        return baohanh;
    }

    @RequestMapping(value = {"/dvnhanhs"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getdonvi(@RequestBody DataPost data) {

        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        ResponseJson baohanh = helper.getDanhMuc(
                apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.DVNHANHS) + data.getFiContent(),
                rabbitMQService.getRabbitMQInfo()
        );
        return baohanh;
    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND) + restUri;
    }

    /**
     * tao chuoi md5 cho uploadfile
     *
     * @param generateStr
     * @return
     */
    private String generateMD5(String generateStr) {
        String key = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] msByte = generateStr.getBytes(Charset.forName("UTF-8"));
            byte byteData[] = md.digest(msByte);
            BigInteger number = new BigInteger(1, byteData);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            key = hashtext;
        } catch (NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(ThuTuc06Api.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    public boolean hasSendPermission(Tbdhoso6 hoso) {
        return hoso.getFiTrangthai().equals(ThuTuc06Constant.Status.TAO_MOI)
                || hoso.getFiHoatdong().equals(ThuTuc06Constant.Status.YEU_CAU_NOP_LAI_PHI);
    }

    private RabbitMQInfo getRabbitMQ() {
        return rabbitMQService.getRabbitMQInfo();
    }
}
