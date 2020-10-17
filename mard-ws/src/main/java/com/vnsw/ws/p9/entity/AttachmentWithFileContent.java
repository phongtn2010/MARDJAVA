package com.vnsw.ws.p9.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentWithContent")
public class AttachmentWithFileContent {
    @XmlElement(name = "FileName")
    private String fiFileName;

    @XmlElement(name = "FileByte")
    private String fiFileBytee;

    public AttachmentWithFileContent() {
    }

    public AttachmentWithFileContent(String fiFileName, String fiFileBytee) {
        this.fiFileName = fiFileName;
        this.fiFileBytee = fiFileBytee;
    }

    public String getFiFileName() {
        return fiFileName;
    }

    public void setFiFileName(String fiFileName) {
        this.fiFileName = fiFileName;
    }

    public String getFiFileBytee() {
        return fiFileBytee;
    }

    public void setFiFileBytee(String fiFileBytee) {
        this.fiFileBytee = fiFileBytee;
    }
}
