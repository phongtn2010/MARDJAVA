package com.vnsw.ws.p16.message;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "RelatedDocuments")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiDocument", "fiOtherPaperValue"})
public class RelatedDocuments {

    @XmlElement(name = "Documents", required = true)
    private String fiDocument;

    @XmlElement(name = "OtherPaperValue", required = true)
    private String fiOtherPaperValue;

    public String getFiDocument() {
        return fiDocument;
    }

    public void setFiDocument(String fiDocument) {
        this.fiDocument = fiDocument;
    }

    public String getFiOtherPaperValue() {
        return fiOtherPaperValue;
    }

    public void setFiOtherPaperValue(String fiOtherPaperValue) {
        this.fiOtherPaperValue = fiOtherPaperValue;
    }
}
