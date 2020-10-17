package com.vnsw.ws.common.service;

/**
 * Xử lý Convert XML <-> Object
 */
import com.vnsw.ws.common.envelop.Envelope;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p10.envelop.Envelope10;
import com.vnsw.ws.util.Constants;

/**
 *
 * @author Linhdx
 */
@Service("convertXmlService")
public class EnvelopXmlServiceImpl implements EnvelopXmlService {
	private static final Logger log = LoggerFactory.getLogger(EnvelopXmlServiceImpl.class);
	private static final String CLASS_NAME = "EnvelopXmlServiceImpl";

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
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
		}
		return result.trim();
	}

	@Override
	public <T> T xmlToEnvelope(String xml, Class<T> jaxbClass) {
		try {
			JAXBContext jc = JAXBContext.newInstance(jaxbClass);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			Object obj = unmarshaller.unmarshal(reader);
			return jaxbClass.cast(obj);
		} catch (JAXBException ex) {
			log.error("Error parsing: {} ", xml);
			log.error("JAXBException", ex);
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			return null;
		}
	}

}
