/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.ws.service;

import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.SoapHelper;
import com.nsw.util.LogUtil;
import com.nsw.ws.common.*;
import com.nsw.ws.envelop.*;
import com.nsw.ws.message.send.*;
import com.nsw.ws.util.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author QUANGNV18
 */
@RestController
@RequestMapping("/most/03")
public class Most03FileService extends BaseService {
    public static final SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat formatterDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static final String CLASS_NAME = "Most03FileService";

    public interface FROM {

        public static final String NAME = "NSW";
        public static final String IDENTITY = "NSW";
        public static final String COUNTRY_CODE = "VN";
        public static final String MINISTRY_CODE = "BTC";
        public static final String ORAGANIZATION_CODE = "TCHQ";
        public static final String UNIT_CODE = "NSW";
    }

    public interface TO {

        public static final String NAME = "BKHCN";
        public static final String IDENTITY = "BKHCN";
        public static final String COUNTRY_CODE = "VN";
        public static final String MINISTRY_CODE = "BKHCN";
        public static final String ORAGANIZATION_CODE = "BKHCN";
        public static final String UNIT_CODE = "BKHCN";
    }
    
    public interface MSG_TYPE {
        public static final String MSG_22 = "22";
        public static final String MSG_23 = "23";
    }
    
    public interface MSG_FUNCTION {
        public static final String MSG_23 = "23";
        public static final String MSG_25 = "25";
    }

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public @ResponseBody
//    ResponseJson uploadFile(@RequestParam("file") MultipartFile mfile) {
//        ResponseJson result = new ResponseJson();
//        try {
//            if (getUser() != null) {
//                Most03FileServiceEnvelope envelope = null;
//                Header header = null;
//                Most03FileServiceBody body = null;
//                Most03FileServiceContent content = new Most03FileServiceContent();
//
//                String tempFolder = environment.getProperty(AppConstant.Download.TemSaveFolder);
//                String fileName = mfile.getOriginalFilename();
//                UUID uuid = UUID.randomUUID();
//                String code = uuid.toString();
//                String filePath = tempFolder + code + "." + FilenameUtils.getExtension(fileName);
//
//                Path path = Paths.get(filePath);
//                Files.write(path, mfile.getBytes());
//                File uploadFile = new File(filePath);
//
//                FileServer file = new FileServer();
//                file.setFileByte(encodeFileToBase64Binary(uploadFile));
//                file.setFileName(fileName);
//
//                header = createSendHeader("00000", Constants.GOV.BKHCN, MSG_TYPE.MSG_22, MSG_FUNCTION.MSG_23);
//                content.setFileServer(file);
//                body = createBody(content);
//                envelope = createEnvelope(header, body);
//                Most03FileServiceEnvelope evlReturn = sendMessage(envelope);
//                if (evlReturn != null) {
//                    result.setSuccess(true);
//                    result.setData(evlReturn.getBody().getContent().getFileServer());
//                } else {
//                    result.setSuccess(false);
//                    result.setMessage("Lỗi không thể upload được file, vui lòng thử lại");
//                }
//            } else {
//                result.setSuccess(false);
//                result.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
//            }
//        } catch (Exception ex) {
//            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
//            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
//            result.setSuccess(false);
//            result.setMessage(ex.getMessage());
//            LogUtil.addLog(ex);
//        }
//        return result;
//    }

    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public void downFile(HttpServletResponse response, @PathVariable("id") String id) {
        try {
            if (getUser() != null) {
                Most03FileServiceEnvelope envelope = null;
                Header header = null;
                Most03FileServiceBody body = null;
                Most03FileServiceContent content = new Most03FileServiceContent();

                FileServer file = new FileServer();
                file.setFileId(Long.valueOf(id));

                header = createSendHeader("00000", Constants.GOV.BKHCN, MSG_TYPE.MSG_23, MSG_FUNCTION.MSG_25);
                content.setFileServer(file);
                body = createBody(content);
                envelope = createEnvelope(header, body);
                Most03FileServiceEnvelope evlReturn = sendMessage(envelope);
                if (evlReturn != null) {
                    downloadFile(response, evlReturn.getBody().getContent().getFileServer());
                }
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            LogUtil.addLog(ex);
        }
    }

    private Most03FileServiceEnvelope sendMessage(Most03FileServiceEnvelope envelopeSend) {
        String xml = "";
        Boolean isSuccess = false;
        try {
            xml = ObjectToXml(envelopeSend);
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            String url = environment.getProperty(Constants.GOV.BKHCN + Constants.LOCAL_WEBSERVICE.PREFIX_URI);
            String nameSpace = environment.getProperty(Constants.GOV.BKHCN + Constants.LOCAL_WEBSERVICE.PREFIX_NAMESPACE);
            String nameSpaceKey = environment.getProperty(Constants.GOV.BKHCN + Constants.LOCAL_WEBSERVICE.PREFIX_NAMESPACE_KEY);
            String methodTag = environment.getProperty(Constants.GOV.BKHCN + Constants.LOCAL_WEBSERVICE.PREFIX_METHOD_TAG);
            String payloadTag = environment.getProperty(Constants.GOV.BKHCN + Constants.LOCAL_WEBSERVICE.PREFIX_PAYLOAD_TAG);
            String nameSpaceKeyForMethodTag = environment.getProperty(Constants.GOV.BKHCN + Constants.LOCAL_WEBSERVICE.PREFIX_NAMESPACE_KEY_METHOD_TAG);
            String nameSpaceKeyForPayloadTag = environment.getProperty(Constants.GOV.BKHCN + Constants.LOCAL_WEBSERVICE.PREFIX_NAMESPACE_KEY_PAYLOAD_TAG);
            String soapAction = "";//.NET thi phai co

            SOAPMessage soapMessage = SoapHelper.createSOAPRequest(xml, nameSpace, nameSpaceKey, methodTag, payloadTag,
                    nameSpaceKeyForMethodTag, nameSpaceKeyForPayloadTag, getRabbitMQ(), soapAction);

            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

            xml = SoapHelper.getSOAPResponse(soapResponse);
            //FAKE
            //xml = "<Envelope><Header><Reference><version>1.0</version><messageId>665f6356-026c-4d14-bca9-48d0f25f0c7d</messageId></Reference><From><name>NSW</name><identity>NSW</identity><countryCode>VN</countryCode><ministryCode>BTC</ministryCode><organizationCode>TCHQ</organizationCode><unitCode>NSW</unitCode></From><To><name>BKHCN</name><identity>BKHCN</identity><countryCode>VN</countryCode><ministryCode>BKHCN</ministryCode><organizationCode>BKHCN</organizationCode><unitCode>BKHCN</unitCode></To><Subject><documentType>BKHCN0100001</documentType><type>11</type><function>99</function><reference>QG2017000590</reference><documentYear>2017</documentYear><sendDate>2017-09-11 14:42:48</sendDate></Subject></Header><Body><Content><FileServer><FileId>1</FileId><FileName>test.pdf</FileName><FileByte></FileByte></FileServer></Content><Signature></Signature></Body><SystemSignature></SystemSignature></Envelope>";
            soapConnection.close();
            isSuccess = true;

        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            LogUtil.addLog(ex);
        }

        Most03FileServiceEnvelope envelopeReturn = null;
        if (isSuccess) {
            envelopeReturn = xmlToEnvelope(xml, Most03FileServiceEnvelope.class);
        }

        return envelopeReturn;
    }
    
    private void downloadFile(HttpServletResponse response, FileServer fileInfo) throws IOException {
        String mimeType = "";
        byte[] fileByte = Base64.decodeBase64(fileInfo.getFileByte());

        Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + fileInfo.getFileName());
        Files.write(savePath, fileByte);

        File downloadFile = savePath.toFile();

        mimeType = URLConnection.guessContentTypeFromName(fileInfo.getFileName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + fileInfo.getFileName() + "\""));
        response.setContentLength((int) downloadFile.length());

        try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

            byte[] buffer = new byte[Constants.BUFFER_SIZE];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }

        downloadFile.delete();
    }

    Header createSendHeader(String code, String documentType, String msgType, String msgFunc) {
        Header hd = new Header();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();

        try {
            hd.setReference(new Reference(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From(FROM.NAME, FROM.IDENTITY, FROM.COUNTRY_CODE,
                    FROM.MINISTRY_CODE, FROM.ORAGANIZATION_CODE, FROM.UNIT_CODE));
            hd.setTo(new From(TO.NAME, TO.IDENTITY, TO.COUNTRY_CODE,
                    TO.MINISTRY_CODE, TO.ORAGANIZATION_CODE, TO.UNIT_CODE));
            hd.setSubject(new Subject(documentType, msgType, msgFunc, code,
                    formatterYear.format(now), formatterDateTime.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From(FROM.NAME, FROM.IDENTITY, FROM.COUNTRY_CODE,
                    FROM.MINISTRY_CODE, FROM.ORAGANIZATION_CODE, FROM.UNIT_CODE));
            hd.setTo(new From(TO.NAME, TO.IDENTITY, TO.COUNTRY_CODE,
                    TO.MINISTRY_CODE, TO.ORAGANIZATION_CODE, TO.UNIT_CODE));
            hd.setSubject(new Subject(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, code,
                    formatterYear.format(now), formatterDateTime.format(now)));
            LogUtil.addLog(ex);
        }
        return hd;
    }

    Most03FileServiceBody createBody(Most03FileServiceContent content) {
        try {
            Most03FileServiceBody body = new Most03FileServiceBody();
            body.setContent(content);
            body.setSignature("");
            return body;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            LogUtil.addLog(ex);
        }
        return new Most03FileServiceBody();
    }

    Most03FileServiceEnvelope createEnvelope(Header header, Most03FileServiceBody body) {
        try {
            Most03FileServiceEnvelope envl = new Most03FileServiceEnvelope();
            envl.setHeader(header);
            envl.setBody(body);
            envl.setSystemSignature("");
            return envl;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            LogUtil.addLog(ex);
        }
        return new Most03FileServiceEnvelope();
    }

}
