package com.vnsw.ws.helper;

import com.vnsw.ws.util.LogUtil;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class ValidateXSDHelper {

    public String validate(String xmlFile, String schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        String errorMsg = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File scFile = new File(classLoader.getResource(schemaFile).getFile());

            Schema schema = schemaFactory.newSchema(scFile);

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
            errorMsg = null;
        } catch (SAXException | IOException e) {
            errorMsg = e.toString();
            LogUtil.addLog(e);
        }
        return errorMsg;
    }

    public String validateWithStringXML(String xml, String schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        String errorMsg = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File scFile = new File(classLoader.getResource(schemaFile).getFile());

            Schema schema = schemaFactory.newSchema(scFile);

            Validator validator = schema.newValidator();
            Source source = new StreamSource(new StringReader(xml));

            validator.validate(source);
            errorMsg = null;

        } catch (SAXException | IOException e) {
            errorMsg = e.toString();
            LogUtil.addLog(e);
        }
        return errorMsg;
    }
}
