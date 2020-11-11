package com.vnsw.ws.p01.envelop;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vnsw.ws.common.envelop.Header;

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
	private String systemSignature = "";

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

	public Boolean fromXml(String stringXml) {
		try {
			JAXBContext context = JAXBContext.newInstance(Envelope.class);
			Unmarshaller um = context.createUnmarshaller();
			InputStream inputStream = new ByteArrayInputStream(stringXml.getBytes(StandardCharsets.UTF_8));
			Envelope envelope = (Envelope) um.unmarshal(inputStream);
			this.setHeader(envelope.getHeader());
			this.setBody(envelope.getBody());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	public String toXml() throws JAXBException {
		try {
			JAXBContext context = JAXBContext.newInstance(Envelope.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			OutputStream output = new OutputStream() {
				private StringBuilder string = new StringBuilder();

				@Override
				public void write(int b) throws IOException {
					this.string.append((char) b);
				}

				public String toString() {
					return this.string.toString();
				}
			};
			m.marshal(this, output);
			return output.toString();
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
}
