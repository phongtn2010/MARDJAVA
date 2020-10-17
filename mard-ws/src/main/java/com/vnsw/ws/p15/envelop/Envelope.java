package com.vnsw.ws.p15.envelop;

import com.vnsw.ws.common.envelop.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 *
 * @author Phongnv9
 */
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {
	public static final Logger logger = LoggerFactory.getLogger(Envelope.class);
	
	@XmlElement(name = "Header")
	private Header header;
	@XmlElement(name = "Body")
	private Body body;
	@XmlElement(name = "SystemSignature")
	private String systemSignature;

	public Envelope() {
		header = new Header();
		body = new Body();
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public String getSystemSignature() {
		return systemSignature;
	}

	public void setSystemSignature(String systemSignature) {
		this.systemSignature = systemSignature;
	}

	@Override
	public String toString() {
		return "Envelope{" +
				"header=" + header +
				", body=" + body +
				", systemSignature='" + systemSignature + '\'' +
				'}';
	}

	public String toXml() throws Exception {
			JAXBContext context = JAXBContext.newInstance(Envelope.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(this, System.out);
			marshaller.marshal(this, stringWriter);
			return stringWriter.toString();
	}
}
