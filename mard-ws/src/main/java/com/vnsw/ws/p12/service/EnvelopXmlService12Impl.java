package com.vnsw.ws.p12.service;

/**
 * Xử lý Convert XML <-> Object
 */
import com.vnsw.ws.common.service.RabbitMQService;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p12.envelop.Envelope12;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtil;

/**
 *
 * @author Linhdx
 */
@Service("convertXmlService12")
public class EnvelopXmlService12Impl implements EnvelopXmlService12 {

    private static final String CLASS_NAME = "EnvelopXmlService12Impl";

    @Autowired
    RabbitMQService rabbitMQService;

    /**
     * Convert Object <---> XML
     *
     * @param obj
     * @return
     */
    public String ObjectToXml(Object obj) {

        String result = "";
        StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(obj, sw);
            result = sw.toString();
        } catch (JAXBException ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return result.trim();
    }

    /**
     * Convert xml <---> Object
     *
     * @param xml
     * @return
     */
    public Envelope12 xmlToEnvelope(String xml) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Envelope12.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            return (Envelope12) unmarshaller.unmarshal(reader);
        } catch (JAXBException ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            return null;
        }
    }

}
