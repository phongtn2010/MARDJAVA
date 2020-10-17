/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.listener;


import com.nsw.common.model.CACheckInfo;
import com.nsw.common.model.XmlMessage;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.helper.RabbitMQHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.service.RabbitMQService;
import com.nsw.service.ReceiveService;
import com.nsw.util.Constants;
import com.nsw.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phong84NV
 */
@Service("signDoneListener")
public class CompletedSignListener {

    private static final Logger log = LoggerFactory.getLogger(CompletedSignListener.class);
    private static final String CLASS_NAME = "CompletedSignListener";
    
    @Autowired
    RabbitMQService rabbitMQService;
    
    @Autowired
    SimpMessagingTemplate template;
    
    @Autowired
    private Environment environment;

    @Autowired
    private ReceiveService receiveService;
    /**
     * Fire when complete sign data and data push back this queue
     * @param message
     */
    
    //@RabbitListener(queues = "Sign_Done_Queue")
    public void receiveMessageSigned(final Message message){
        try {
            String strMessage = new String(message.getBody(), "UTF-8");
            String[] requestResponseMessage = strMessage.split(Constants.MESSAGE_SEPARATOR_WITH_SLASH);
            //"MST{}fiDocumentCode{}fiXml{}fiFunc{}fiMsgType{}fiMinistryCode{}fiDocumentId{}fiDocumentType{}fiData"
            String taxCode = requestResponseMessage[0];
            String fiDocumentCode = requestResponseMessage[1];
            String fiXmlSigned = requestResponseMessage[2];
            String fiFunc = requestResponseMessage[3];
            String fiMsgType = requestResponseMessage[4];
            String fiMinistryCode = requestResponseMessage[5];
            String fiDocumentId = requestResponseMessage[6];
            String fiDocumentType = requestResponseMessage[7];
            String fiData = requestResponseMessage[8];
            // Goi sang common backend de check doanh nghiep nay da dang ky usb token nay voi hai quan chua? chu ky nay co hop le khong?
            ResponseJson responJson = null;
            String returnMessage = "Ký số hồ sơ " + fiDocumentCode + " và gửi thất bại!";
            try {
                CACheckInfo checkInfo = new CACheckInfo();
                checkInfo.setFiTaxCode(taxCode);
                checkInfo.setFiXmlSigned(fiXmlSigned);
                String commonBackendUrl = environment.getProperty("BACKEND_COMMON_URL");
                responJson = receiveService.callResforEntity(commonBackendUrl, checkInfo, Constants.RES_METHOD.POST);
                if(responJson !=null && responJson.isSuccess()){
                    String ministryBackendReceivedSignedXmlUrl = environment.getProperty(fiMinistryCode + "_BACKEND_SIGNDONE_URL");
                    
                    XmlMessage xmlMessage = new XmlMessage();
                    xmlMessage.setFiDocumentCode(fiDocumentCode);
                    xmlMessage.setFiDocumentId(Long.valueOf(fiDocumentId));
                    xmlMessage.setFiDocumentType(fiDocumentType);
                    xmlMessage.setFiFunc(fiFunc);
                    xmlMessage.setFiMinistryCode(fiMinistryCode);
                    xmlMessage.setFiMsgType(fiMsgType);
                    xmlMessage.setFiXml(fiXmlSigned);
                    xmlMessage.setFiData(fiData);
                    // Goi gui du lieu da ky sang backend cua cac bo nganh de luu tru va gui ra ngoai
                    responJson = receiveService.callResforEntity(ministryBackendReceivedSignedXmlUrl, xmlMessage, Constants.RES_METHOD.POST);
                    if(responJson !=null && responJson.isSuccess()){
                        returnMessage = "Ký số hồ sơ " + fiDocumentCode + " và gửi thành công!";
                    }
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                        + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
                RabbitMQHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            }
            // Thong bao cho client ket qua ky
            template.convertAndSend("/topic/showSignResult/" + taxCode, returnMessage);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
    }
}
