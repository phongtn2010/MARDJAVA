/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.controller;

import com.nsw.common.model.CACheckInfo;
import com.nsw.common.model.SignData;
import com.nsw.common.model.XmlMessage;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.helper.CalcInput;
import com.nsw.helper.RabbitMQHelper;
import com.nsw.helper.Result;
import com.nsw.service.RabbitMQService;
import com.nsw.service.ReceiveService;
import com.nsw.util.Constants;
import com.nsw.util.LogUtil;
import java.security.Principal;
import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 *
 * @author PhongNguyen
 */
@Controller
public class WebSocketController {

    private static final String CLASS_NAME = "WebSocketController";

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    private ReceiveService receiveService;

    //@MessageMapping("/sign")
    public void addNum(Message<Object> message, CalcInput input) throws Exception {
        Thread.sleep(2000);
        Result result = new Result(input.getNum1() + "+" + input.getNum2() + "=" + (input.getNum1() + input.getNum2()));
        Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        String authedSender = principal.getName();
        template.convertAndSend("/topic/showSignResult/" + authedSender, result);
    }

    //For using RabbitMQ
    //@MessageMapping("/sign")
    public void signData(Message<Object> message, SignData signData) throws Exception {
        // Day du lieu vao rabbitMQ. Tao 1 queue theo ma so thue cua doanh nghiep nay
        RabbitMQHelper.pushSignReqToRabbitMQ(signData, rabbitMQService.getRabbitMQInfoForSignReq(signData.getTaxCode()));
    }

    @MessageMapping("/sign.ping/{user}")
    @SendTo("/topic/sign.ping/{user}")
    public String sendOnlineData(@DestinationVariable("user") String user, String data) throws Exception {
        return data;
    }

    @MessageMapping("/sign")
    public void sendSignData(Message<Object> message, SignData signData) throws Exception {
        Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        String authedSender = principal.getName();
        template.convertAndSend("/topic/sign.message/" + authedSender, signData);
    }

    @MessageMapping("/sign.done/{user}")
    @SendTo("/topic/sign.done/{user}")
    public String signDone(@DestinationVariable("user") String user, XmlMessage signData) throws Exception {
        return receiveMessageSigned(signData, user);
    }

    public String receiveMessageSigned(XmlMessage message, String userName) {
        String returnMessage = "Ký số hồ sơ " + message.getFiDocumentCode() + " và gửi thất bại!";

        try {
            // Goi sang common backend de check doanh nghiep nay da dang ky usb token nay voi hai quan chua? chu ky nay co hop le khong?
            ResponseJson responJson = null;
            try {
                CACheckInfo checkInfo = new CACheckInfo();
                checkInfo.setFiTaxCode(userName);
                checkInfo.setFiXmlSigned(message.getFiXml().toString());
                String commonBackendUrl = environment.getProperty("BACKEND_COMMON_URL");
                responJson = receiveService.callResforEntity(commonBackendUrl, checkInfo, Constants.RES_METHOD.POST);
                if (responJson != null && responJson.isSuccess()) {
                    String ministryBackendReceivedSignedXmlUrl = environment.getProperty(message.getFiMinistryCode() + "_BACKEND_SIGNDONE_URL");
                    
                    // Goi gui du lieu da ky sang backend cua cac bo nganh de luu tru va gui ra ngoai
                    responJson = receiveService.callResforEntity(ministryBackendReceivedSignedXmlUrl, message, Constants.RES_METHOD.POST);
                    if (responJson != null && responJson.isSuccess()) {
                        returnMessage = "Ký số hồ sơ " + message.getFiDocumentCode() + " và gửi thành công!";
                    }
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                        + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
                RabbitMQHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }

        return returnMessage;
    }
}
