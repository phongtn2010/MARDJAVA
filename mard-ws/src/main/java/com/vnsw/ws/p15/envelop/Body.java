package com.vnsw.ws.p15.envelop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Phongnv9
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class Body {

	@XmlElement(name = "Content")
	private Content content;
	@XmlElement(name = "Signature")
	private String personSignature;

	public String getPersonSignature() {
		return personSignature;
	}

	public void setPersonSignature(String personSignature) {
		this.personSignature = personSignature;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public static final Logger logger = LoggerFactory.getLogger(Content.class);

	public String toXml() throws JAXBException {
		try {
			JAXBContext context = JAXBContext.newInstance(Body.class);
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
		} catch (Exception e) {
			logger.error("ERROR WHILE PARSE TO XML: {}", e);
			return null;
		}
	}

	@Override
	public String toString() {
		return "Body{" +
				"content=" + content +
				", personSignature='" + personSignature + '\'' +
				'}';
	}
}
