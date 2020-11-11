/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author QUANGNV18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileServer")
public class FileServer {

    @XmlElement(name = "FileId", nillable = true)
    private Long FileId;

    @XmlElement(name = "FileName", nillable = true)
    private String FileName;

    @XmlElement(name = "FileByte", nillable = true)
    private String FileByte;

    public Long getFileId() {
        return FileId;
    }

    public void setFileId(Long FileId) {
        this.FileId = FileId;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public String getFileByte() {
        return FileByte;
    }

    public void setFileByte(String FileByte) {
        this.FileByte = FileByte;
    }
}
