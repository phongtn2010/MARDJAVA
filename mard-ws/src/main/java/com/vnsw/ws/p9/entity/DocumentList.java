package com.vnsw.ws.p9.entity;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "DocumentList")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DocumentList {
    @XmlElement(name = "Document")
    private List<Document> lstDocument;
}
