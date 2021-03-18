package com.nsw.backend.scheduler;

import com.nsw.backend.vroot.model.SynchronizeMessage;
import com.nsw.backend.vroot.model.TbdMessage;
import com.nsw.backend.vroot.service.SynchronizeMessageService;
import com.nsw.backend.vroot.service.TbdMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component
public class VRootScheduler {
    private static final Logger log = LoggerFactory.getLogger(VRootScheduler.class);
    private final String CLASS_NAME = "VRootScheduler";

    @Autowired
    Environment environment;
    @Autowired
    private SynchronizeMessageService synchronizeMessageService;
    @Autowired
    private TbdMessageService tbdMessageService;

//    @Scheduled(cron = "0 59 23 * * *")
    private void synchronizeMessageToTBDMessage(){
        try {
            log.info("SynchronizeMessageToTBDMessage Scheduled");
            log.info("Date Sync: "+Calendar.getInstance().getTime());
            Calendar calendar =Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
//            ResponeXML respone = BackendRequestHelper.getInstance().doPostRequest(urlService,requestJson);
//            System.out.println(respone.toString());

//            List<SynchronizeMessage> synchronizeMessageList = synchronizeMessageService.findByCreatedDate(from,to);
//            if (synchronizeMessageList!=null && !synchronizeMessageList.isEmpty()){
//
//            }

            List<SynchronizeMessage> synchronizeMessageList = synchronizeMessageService.findByCreatedDate(calendar.getTime());
            if(synchronizeMessageList!=null&&!synchronizeMessageList.isEmpty()){
                log.info("size synchronizeMessageList: "+synchronizeMessageList.size());
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
        }catch (Exception e){
            log.error(CLASS_NAME+" "+e.getMessage());
        }
    }

//    @Scheduled(cron = "0 0 9-11 * * *")
//    @Scheduled(fixedRate = 60000)
    private void sendTbdMessage(){
        try {
            log.info("SendTbdMessage Scheduled");
            log.info("Date: "+Calendar.getInstance().getTime());
            List<TbdMessage> tbdMessageList = tbdMessageService.findTOP20ByFiTrangthai(null);
            if(tbdMessageList!=null&&!tbdMessageList.isEmpty()){
                log.info("MessageList size: "+tbdMessageList.size());
                for (TbdMessage tbdMessage : tbdMessageList){
                    boolean check = sendToVNC(tbdMessage);
                    if(check){
                        tbdMessage.setFiTrangthai(1L);
                        tbdMessage.setFiNgaydongbo(new Date());
                        tbdMessageService.update(tbdMessage);
                    }
                }
            }
        }catch (Exception e){
            log.error(CLASS_NAME+" "+e.getMessage());
        }
    }
    private boolean sendToVNC(TbdMessage tbdMessage){
        String token = environment.getProperty("TOKEN");
        String url = environment.getProperty("URL_SERVICE");
        try {
            String response = executePost(url, "token=" + token + "&data=" + encodeValue(tbdMessage.getFiYeucau()));
            log.info(tbdMessage.getFiMahoso()+": "+response);
            if(!response.equals("Error")){
                return true;
            }else{
                return  false;
            }
        }catch (Exception e){
            log.info(e.getMessage());
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
}
