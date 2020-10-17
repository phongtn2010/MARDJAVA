/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.util;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.docx4j.wml.Tc;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;
import javax.xml.transform.stream.StreamResult;
import org.docx4j.convert.out.html.AbstractHtmlExporter;
import org.docx4j.convert.out.html.HtmlExporterNG2;
import org.docx4j.convert.out.html.AbstractHtmlExporter.HtmlSettings;
import org.docx4j.jaxb.Context;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.FooterPart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.FldChar;
import org.docx4j.wml.FooterReference;
import org.docx4j.wml.Ftr;
import org.docx4j.wml.Hdr;
import org.docx4j.wml.HdrFtrRef;
import org.docx4j.wml.HeaderReference;
import org.docx4j.wml.Jc;
import org.docx4j.wml.JcEnumeration;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.R;
import org.docx4j.wml.STFldCharType;
import org.docx4j.wml.SectPr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class WordExportUtils {

    private static final ObjectFactory objectFactory = new ObjectFactory();
    public static final Logger logger = LoggerFactory.getLogger(WordExportUtils.class);

    public static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
        List<Object> result = new ArrayList<>();
        if (obj instanceof JAXBElement) {
            obj = ((JAXBElement<?>) obj).getValue();
        }
        if (obj.getClass().equals(toSearch)) {
            result.add(obj);
        } else if (obj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) obj).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        }
        return result;
    }

    public void replacePlaceholder(WordprocessingMLPackage template, String name, String placeholder) {// xx
        try {
            List<Object> rs = getAllElementFromObject(template.getMainDocumentPart(), P.class);
            ObjectFactory factory = Context.getWmlObjectFactory();
            for (Object r : rs) {
                P run = (P) r;
                List<Object> texts = getAllElementFromObject(run, Text.class);
                boolean bAdd = false;
                String fieldName = "";
                for (Object text : texts) {
                    try {
                        Text textElement = (Text) text;
                        if (textElement.getValue() != null) {
                            if (textElement.getValue().equals(placeholder)) {
                                if (name != null) {
                                    String source = (String) name;
                                    if (name.contains("\n")) {
                                        String[] chars = name.split("\n");
                                        textElement.setValue("");
                                        for (int i = 0; i < chars.length; i++) {
                                            run.getContent().remove(run);
                                            run.getContent().add(App.createR(factory, chars[i].toString() + " "));
                                            if (i < chars.length - 1) {
                                                run.getContent().add(App.createBr(factory));
                                            }
                                        }
                                    } else {
                                        textElement.setValue(name);
                                        String value = SuperScript.convertToSuperScript((String) name);
                                        if (name.contains("^(") == true || name.contains("_(") == true) {
                                            textElement.setValue("");
                                            run.getContent().add(App.createParagraph(factory, name));
                                        } else {
                                            textElement.setValue(value);
                                        }
                                    }
                                } else {
                                    textElement.setValue("");
                                }
                            }
                        }
                    } catch (Exception en) {
                        logger.error(en.getMessage());
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void replacePlaceholder(WordprocessingMLPackage template, Boolean check, String placeholder) {
        try {
            List<Object> rs = getAllElementFromObject(template.getMainDocumentPart(), P.class);
            ObjectFactory factory = Context.getWmlObjectFactory();
            for (Object r : rs) {
                P run = (P) r;
                List<Object> texts = getAllElementFromObject(run, Text.class);
                String fieldName = "";
                boolean bAdd = false;
                for (Object text : texts) {
                    try {
                        Text textElement = (Text) text;
                        if (bAdd) {
                            fieldName += textElement.getValue();
                        } else {
                            fieldName = textElement.getValue();
                        }
                        if (fieldName.startsWith("${")) {
                            if (!fieldName.endsWith("}")) {
                                textElement.setValue("");
                                bAdd = true;
                                continue;
                            }
                        } else {
                            bAdd = false;
                            continue;
                        }

                        if (fieldName != null) {
                            fieldName = fieldName.replace("${", "").replace("}", "");
                            if (fieldName.equals(placeholder)) {
                                textElement.setValue("");
                                run.getContent().remove(textElement);

                                if (check != null) {
                                    if (check == true) {
                                        run.getContent().add(App.createCheckedbox(factory));
                                    } else {
                                        run.getContent().add(App.createUnCheckbox(factory));
                                    }
                                }
                            }
                        }
                    } catch (Exception en) {
                        logger.error(en.getMessage());
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }
    }

    public void createHeaderPart(WordprocessingMLPackage wordprocessingMLPackage, String footerContent)
            throws InvalidFormatException {
        HeaderPart headerPart = new HeaderPart();

        headerPart.setJaxbElement(getHdr(footerContent));
        Relationship relationship = wordprocessingMLPackage.getMainDocumentPart().addTargetPart(headerPart);

        SectPr sectPr = objectFactory.createSectPr();

        HeaderReference headerReference = objectFactory.createHeaderReference();
        headerReference.setId(relationship.getId());
        headerReference.setType(HdrFtrRef.DEFAULT);
        sectPr.getEGHdrFtrReferences().add(headerReference);// add header or

        wordprocessingMLPackage.getMainDocumentPart().addObject(sectPr);
    }

    public void createFooterPart(WordprocessingMLPackage wordprocessingMLPackage, String footerContent)
            throws InvalidFormatException {

        FooterPart footerPart = new FooterPart();

        footerPart.setJaxbElement(getFtrWithPageNumber(footerContent));
        Relationship relationship = wordprocessingMLPackage.getMainDocumentPart().addTargetPart(footerPart);

        SectPr sectPr = objectFactory.createSectPr();

        FooterReference footerReference = objectFactory.createFooterReference();
        footerReference.setId(relationship.getId());
        footerReference.setType(HdrFtrRef.DEFAULT);
        sectPr.getEGHdrFtrReferences().add(footerReference);// add header or

        wordprocessingMLPackage.getMainDocumentPart().addObject(sectPr);
    }

    public Hdr getHdr(String footerContent) {

        Hdr hdr = objectFactory.createHdr();

        hdr.getEGBlockLevelElts().add(getP(footerContent));
        return hdr;

    }

    public Ftr getFtr(String footerContent) {

        Ftr ftr = objectFactory.createFtr();

        ftr.getEGBlockLevelElts().add(getP(footerContent));
        return ftr;

    }

    public Ftr getFtrWithPageNumber(String footerContent) {
        Ftr ftr = objectFactory.createFtr();
        P paragraph = objectFactory.createP();
        P paragraphL = objectFactory.createP();

        addFooterContent(paragraphL, footerContent);
        addFieldBegin(paragraph);
        addPageNumberField(paragraph);
        addFieldEnd(paragraph);

        ftr.getContent().add(paragraphL);
        ftr.getContent().add(paragraph);
        return ftr;
    }

    private static void addFooterContent(P paragraph, String footerContent) {
        R run = objectFactory.createR();
        Text txt = new Text();
        txt.setSpace("preserve");
        txt.setValue(footerContent);
        PPr ppr = objectFactory.createPPr();
        Jc jc = objectFactory.createJc();
        jc.setVal(JcEnumeration.LEFT);
        ppr.setJc(jc);
        paragraph.setPPr(ppr);

        JAXBElement<Text> object = objectFactory.createRInstrText(txt);
        run.getContent().add(object);
        paragraph.getContent().add(run);
    }

    private static void addPageNumberField(P paragraph) {
        R run = objectFactory.createR();
        Text txt = new Text();
        txt.setSpace("preserve");
        txt.setValue(" PAGE   \\* MERGEFORMAT ");
        PPr ppr = objectFactory.createPPr();
        Jc jc = objectFactory.createJc();
        jc.setVal(JcEnumeration.RIGHT);
        ppr.setJc(jc);
        paragraph.setPPr(ppr);

        JAXBElement<Text> object = objectFactory.createRInstrText(txt);
        run.getContent().add(object);

        paragraph.getContent().add(run);

    }

    private static void addFieldBegin(P paragraph) {
        R run = objectFactory.createR();
        FldChar fldchar = objectFactory.createFldChar();
        fldchar.setFldCharType(STFldCharType.BEGIN);
        run.getContent().add(fldchar);
        paragraph.getContent().add(run);
    }

    private static void addFieldEnd(P paragraph) {
        FldChar fldcharend = objectFactory.createFldChar();
        fldcharend.setFldCharType(STFldCharType.END);
        R run3 = objectFactory.createR();
        run3.getContent().add(fldcharend);
        paragraph.getContent().add(run3);
    }

    public P getP(String footerContent) {
        P headerP = objectFactory.createP();
        R run1 = objectFactory.createR();
        Text text = objectFactory.createText();
        text.setValue(footerContent);
        run1.getRunContent().add(text);
        headerP.getParagraphContent().add(run1);
        return headerP;
    }

    public void createFooter(WordprocessingMLPackage wmp) {
        try {
            Relationship relationship = createFooterPart();
            createHeaderReference(wmp, relationship);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public Relationship createFooterPart(WordprocessingMLPackage wordprocessingMLPackage) throws Exception {

        FooterPart footerPart = new FooterPart();
        Relationship rel = wordprocessingMLPackage.getMainDocumentPart().addTargetPart(footerPart);

        // After addTargetPart, so image can be added properly
        footerPart.setJaxbElement(getFtr());

        return rel;
    }

    public void createHeaderReference(WordprocessingMLPackage wordprocessingMLPackage, Relationship relationship)
            throws InvalidFormatException {
        List<SectionWrapper> sections = wordprocessingMLPackage.getDocumentModel().getSections();

        SectPr sectPr = sections.get(sections.size() - 1).getSectPr();
        // There is always a section wrapper, but it might not contain a sectPr
        if (sectPr == null) {
            sectPr = objectFactory.createSectPr();
            wordprocessingMLPackage.getMainDocumentPart().addObject(sectPr);
            sections.get(sections.size() - 1).setSectPr(sectPr);
        }

        HeaderReference headerReference = objectFactory.createHeaderReference();
        headerReference.setId(relationship.getId());
        headerReference.setType(HdrFtrRef.DEFAULT);
        sectPr.getEGHdrFtrReferences().add(headerReference);// add header or
        // footer references

    }

    public Ftr getFtr() throws Exception {

        Ftr hdr = objectFactory.createFtr();

        hdr.getContent().add("sss");
        return hdr;

    }

    public void replacePlaceholder(WordprocessingMLPackage template, HashMap<String, Object> map) {
        try {
            List<Object> rs = getAllElementFromObject(template.getMainDocumentPart(), P.class);
            ObjectFactory factory = Context.getWmlObjectFactory();
            for (Object r : rs) {
                P run = (P) r;
                List<Object> texts = getAllElementFromObject(run, Text.class);
                boolean bAdd = false;
                String fieldName = "";
                for (Object text : texts) {
                    try {
                        Text textElement = (Text) text;
                        if (bAdd) {
                            fieldName += textElement.getValue();
                        } else {
                            fieldName = textElement.getValue();
                        }
                        // if (fieldName.endsWith("${createForm.signDate}")) {
                        // System.out.println("havm debug");
                        // }
                        if (fieldName.startsWith("${")) {
                            if (!fieldName.endsWith("}")) {
                                textElement.setValue("");
                                bAdd = true;
                                continue;
                            }
                        } else {
                            bAdd = false;
                            continue;
                        }
                        if (textElement.getValue() != null) {
                            if (fieldName.startsWith("${") && fieldName.endsWith("}")) {
                                String attribute = fieldName.replace("${", "").replace("}", "");
                                String[] lstAttribute = attribute.split("\\.");
                                Object mainObj = map.get(lstAttribute[0]);
                                for (int i = 1; i < lstAttribute.length; i++) {
                                    mainObj = getAttributeObjByName(mainObj, lstAttribute[i]);
                                }
                                if (mainObj != null) {
                                    String source = String.valueOf(mainObj);
                                    if (mainObj instanceof Date) {
                                        source = DateTimeUtils.convertDateToString((Date) mainObj);
                                    }
                                    if (source.contains("\n")) {
                                        String[] chars = source.split("\n");
                                        textElement.setValue("");
                                        for (int i = 0; i < chars.length; i++) {
                                            String value = SuperScript.convertToSuperScript(chars[i]);
                                            source = value;
                                            if (source.contains("^(") == true || source.contains("_(") == true) {
                                                run.getContent().remove(run);
                                                run.getContent().add(App.createR(factory, source));
                                            } else {
                                                run.getContent().remove(run);
                                                run.getContent().add(App.createR(factory, source));
                                                if (i < chars.length - 1) {
                                                    run.getContent().add(App.createBr(factory));
                                                }
                                                // textElement.setValue(value);
                                            }
                                        }
                                    } else {
                                        String value = SuperScript.convertToSuperScript(source);
                                        if (source.contains("^(") == true || source.contains("_(") == true) {
                                            textElement.setValue("");
                                            run.getContent().remove(run);
                                            run.getContent().add(App.createR(factory, source));
                                        } else {
                                            textElement.setValue(value);
                                        }
                                    }
                                } else {
                                    textElement.setValue("");
                                }
                            }
                        } else {
                            System.out.println("null");
                        }
                    } catch (Exception ex) {
                        logger.error(ex.getMessage());
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void replaceTable(String[] placeholders, List<Map<String, String>> textToAdd,
            WordprocessingMLPackage template) throws Docx4JException, JAXBException {
        List<Object> tables = getAllElementFromObject(template.getMainDocumentPart(), Tbl.class);

        // 1. find the table
        Tbl tempTable = getTemplateTable(tables, placeholders[0]);
        List<Object> rows = getAllElementFromObject(tempTable, Tr.class);

        // first row is header, second row is content
        if (rows.size() == 2) {
            // this is our template row
            Tr templateRow = (Tr) rows.get(1);

            for (Map<String, String> replacements : textToAdd) {
                // 2 and 3 are done in this method
                addRowToTable(tempTable, templateRow, replacements);
            }

            // 4. remove the template row
            tempTable.getContent().remove(templateRow);
        }
    }

    public void replaceTable(WordprocessingMLPackage template, int iTable, List lstReplacement)
            throws Docx4JException, JAXBException {
        List<Object> tables = getAllElementFromObject(template.getMainDocumentPart(), Tbl.class);

        // 1. find the table
        Tbl tempTable = getTemplateTable(tables, iTable);
        List<Object> rows = getAllElementFromObject(tempTable, Tr.class);
        addRowToTable(tempTable, (Tr) rows.get(1), lstReplacement);
    }

    public void deleteTable(WordprocessingMLPackage template, int iTable) throws Docx4JException, JAXBException {
        List<Object> tables = getAllElementFromObject(template.getMainDocumentPart(), Tbl.class);
        Tbl tempTable = getTemplateTable(tables, iTable);
        tempTable.getContent().clear();
        template.getMainDocumentPart().getContent().remove(tempTable);
    }

    public Tbl getTemplateTable(List<Object> tables, int i) throws Docx4JException, JAXBException {
        return (Tbl) tables.get(i);
    }

    public Tbl getTemplateTable(List<Object> tables, String templateKey) throws Docx4JException, JAXBException {
        for (Iterator<Object> iterator = tables.iterator(); iterator.hasNext();) {
            Object tbl = iterator.next();
            List<?> textElements = getAllElementFromObject(tbl, Text.class);
            for (Object text : textElements) {
                Text textElement = (Text) text;
                if (textElement.getValue() != null && textElement.getValue().equals(templateKey)) {
                    return (Tbl) tbl;
                }
            }
        }
        return null;
    }

    public Object getAttributeObjByName(Object obj, String fieldName) {
        Object value = "";
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            value = field.get(obj);
        } catch (Exception ex) {
            /*
			 * bo ghi log loi k quan tam - binhnt53
			 * Logger.getLogger(WordExportUtils.class.getName()).log(Level.
			 * SEVERE, null, ex);
             */
            logger.error(ex.getMessage());
        }
        return value;
    }

    public String getAttributeOfObjByName(Object obj, String fieldName) {
        String value = "";
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object ob = field.get(obj);
            if (ob == null) {
                value = "";
            } else if (ob instanceof String) {
                value = (String) ob;
            } else {
                value = String.valueOf(field.get(obj));
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return value;
    }

    public void addRowToTable(Tbl reviewtable, Tr templateRow, List replacements) throws IllegalArgumentException {
        try {
            if (replacements != null) {
                ObjectFactory factory = Context.getWmlObjectFactory();
                for (int i = 0; i < replacements.size(); i++) {
                    Tr workingRow = (Tr) XmlUtils.deepCopy(templateRow);
                    List<Object> colElements = getAllElementFromObject(workingRow, Tc.class);
                    for (Object ob : colElements) {
                        Tc col = (Tc) ob;
                        List<?> textElements = getAllElementFromObject(col, Text.class);
                        Object obj = replacements.get(i);
                        for (Object object : textElements) {
                            Text text = (Text) object;
                            String attribute = text.getValue();
                            if ("index".equals(attribute)) {
                                text.setValue(String.valueOf(i + 1));
                            } else {
                                String value = getAttributeOfObjByName(obj, attribute);
                                if (value != null) {
                                    if (value.contains("^(") == true || value.contains("_(") == true) {
                                        col.getContent().clear();
                                        col.getContent().add(App.createParagraph(factory, value));
                                    } else if ("true".equals(value)) {
                                        col.getContent().clear();
                                        col.getContent().add(App.createCheckedbox(factory));
                                    } else if ("false".equals(value)) {
                                        col.getContent().clear();
                                        col.getContent().add(App.createUnCheckbox(factory));
                                    } else if (!value.contains("\r\n") && !value.contains("\n\r")
                                            && !value.contains("\n")) {
                                        text.setValue(value);
                                    } else {
                                        String[] lstContents = null;

                                        if (value.contains("\r\n")) {
                                            lstContents = value.split("\r\n");
                                        }
                                        if (value.contains("\n\r")) {
                                            lstContents = value.split("\n\r");
                                        }
                                        if (value.contains("\n")) {
                                            lstContents = value.split("\n");
                                        }

                                        List<?> lstP = getAllElementFromObject(col, P.class);
                                        P oldP = null;
                                        if (lstP != null && !lstP.isEmpty()) {
                                            oldP = (P) lstP.get(0);
                                        }
                                        for (String content : lstContents) {
                                            if (content.length() <= 1) {
                                                content = content + " ";
                                            }
                                            P p = App.createParagraph(factory, content);
                                            if (oldP != null) {
                                                p.setPPr(oldP.getPPr());
                                            }
                                            col.getContent().add(p);
                                        }
                                        col.getContent().remove(oldP);
                                    }
                                } else {
                                    text.setValue("");
                                }
                            }
                        }
                    }
                    reviewtable.getContent().add(workingRow);
                }
            }
            reviewtable.getContent().remove(templateRow);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void addRowToTable(Tbl reviewtable, Tr templateRow, Map<String, String> replacements) {
        Tr workingRow = (Tr) XmlUtils.deepCopy(templateRow);
        List<?> textElements = getAllElementFromObject(workingRow, Text.class);
        for (Object object : textElements) {
            Text text = (Text) object;
            String replacementValue = (String) replacements.get(text.getValue());
            replacementValue = SuperScript.convertToSuperScript(replacementValue);
            if (replacementValue != null) {
                text.setValue(replacementValue);
            }
        }
        reviewtable.getContent().add(workingRow);
    }

    public void toHTML(WordprocessingMLPackage template, HttpServletResponse res)
            throws IOException, Docx4JException, Exception {
        Date newDate = new Date();
        String fileName = newDate.getTime() + ".docx";
        res.setContentType("application/vnd.ms-word");

        res.setHeader("Content-Disposition", "attachment; filename=report_" + fileName);
        res.setHeader("Content-Type", "application/vnd.ms-word");
        AbstractHtmlExporter exporter = new HtmlExporterNG2();
        ResourceBundle rb = ResourceBundle.getBundle("config");
        String inputFilePath = rb.getString("tempDirectory");

        HtmlSettings htmlSettings = new HtmlSettings();
        htmlSettings.setImageDirPath(inputFilePath + "_files");
        htmlSettings.setImageTargetUri(inputFilePath + "_files");
        OutputStream outputStream = res.getOutputStream();

        StreamResult result = new StreamResult(outputStream);
        exporter.html(template, result, htmlSettings);

    }

    public void toHTML(String inputPath, String path) throws IOException, Docx4JException, Exception {
        AbstractHtmlExporter exporter = new HtmlExporterNG2();
        WordprocessingMLPackage wmp = null;
        wmp = WordprocessingMLPackage.load(new FileInputStream(inputPath));
        String inputFilePath = path;

        HtmlSettings htmlSettings = new HtmlSettings();
        htmlSettings.setImageDirPath(inputFilePath + "_files");
        htmlSettings.setImageTargetUri(inputFilePath + "_files");
        OutputStream outputStream = new java.io.FileOutputStream(inputFilePath + ".html");

        StreamResult result = new StreamResult(outputStream);
        exporter.html(wmp, result, htmlSettings);

    }

    public void htmlToDocx(String html, String docXPath) throws InvalidFormatException, JAXBException, Docx4JException {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

        NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
        wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
        ndp.unmarshalDefaultNumbering();
        // linhdx
        wordMLPackage.save(new java.io.File(docXPath));
    }

    private Relationship createFooterPart() {
        throw new UnsupportedOperationException("Not supported yet."); // To
        // change
        // body
        // of
        // generated
        // methods,
        // choose
        // Tools
        // |
        // Templates.
    }

    private String replacePh(String base, String placeHolder, String value) {

        if (value == null) {
            value = "";
        }

        if (!base.contains(placeHolder)) {

            return base;

        }

        return base.replaceAll(placeHolder, value);

    }

    private void replaceHeader(HeaderPart headerPart, String placeholder, String newValue) throws JAXBException {

        if (headerPart != null) {

            String xml = XmlUtils.marshaltoString(headerPart.getJaxbElement(), true);

            xml = replacePh(xml, placeholder, newValue);

            Object obj = XmlUtils.unmarshallFromTemplate(xml, null);

            // change JaxbElement
            headerPart.setJaxbElement((org.docx4j.wml.Hdr) obj);

        }

    }

    private void replaceFooter(FooterPart footerPart, String placeholder, String newValue) throws JAXBException {

        if (footerPart != null) {

            String xml = XmlUtils.marshaltoString(footerPart.getJaxbElement(), true);

            xml = replacePh(xml, placeholder, newValue);

            Object obj = XmlUtils.unmarshallFromTemplate(xml, null);

            // change JaxbElement
            footerPart.setJaxbElement((org.docx4j.wml.Ftr) obj);

        }

    }

    /**
     * The different epochs.
     */
    public final static String[] EPOCH = {"Forties", "Fifties", "Sixties", "Seventies", "Eighties", "Nineties",
        "Twenty-first Century"};

    public static void resolveFragmentText(WordprocessingMLPackage wmp) throws Docx4JException {
        List<Object> rs = getAllElementFromObject(wmp.getMainDocumentPart(), P.class);
        for (Object r : rs) {
            P run = (P) r;
            List<Object> texts = getAllElementFromObject(run, Text.class);
            int i = 0;
            while (i < texts.size()) {
                Object text = texts.get(i);
                i++;
                try {
                    Text textElement = (Text) text;
                    String content = textElement.getValue();
                    if (content != null) {
                        int start = content.indexOf("${");
                        if (start < 0) {
                            //
                            // Khong co dau ngoac trong nay nen bo qua
                            //
                            continue;
                        }
                        int end = content.indexOf("}", start);
                        if (end >= 0) {
                            //
                            // co du bo ngoac trong text nay, bo qua
                            //
                            continue;
                        }
                        do {
                            Text nextText = (Text) texts.get(i);
                            i++;
                            content = content + nextText.getValue();
                            nextText.setValue("");
                            if (content.indexOf("}", start) > 0) {
                                textElement.setValue(content);
                                break;
                            }
                        } while (true);
                    } else {
                        System.out.println("null");
                    }
                } catch (Exception en) {
                    logger.error(en.getMessage());
                }
            }
        }
    }
}
