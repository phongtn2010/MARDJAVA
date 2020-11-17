package com.vnsw.send.gateway.common.service;

/**
 * Xử lý Convert XML <-> Object
 */
import com.vnsw.send.gateway.common.bo.Envelope;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Linhdx
 */
@Service("convertXmlService")
public class EnvelopXmlServiceImpl implements EnvelopXmlService {

    private static final String CLASS_NAME = "EnvelopeServiceImpl";
    public static final Logger logger = LoggerFactory.getLogger(EnvelopXmlServiceImpl.class);
    /**
     * Convert Object <---> XML
     *
     * @param obj
     * @return
     */
    public String ObjectToXml(Object obj) {

        String result = "";
        java.io.StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(obj, sw);
            result = sw.toString();
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }
        return result.trim();
    }

    /**
     * Convert xml <---> Object
     *
     * @param xml
     * @return
     */
    public Envelope xmlToEnvelope(String xml) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Envelope.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            return (Envelope) unmarshaller.unmarshal(reader);
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

}
