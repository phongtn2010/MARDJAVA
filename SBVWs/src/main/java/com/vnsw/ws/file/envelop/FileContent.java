/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.file.envelop;

import com.vnsw.ws.file.message.FileServer;
import com.vnsw.ws.file.message.wsError;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author QUANGNV18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
public class FileContent {

    public FileContent() {
    }

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    private List<wsError> ErrorList;

    @XmlElement(name = "FileServer")
    private FileServer fileServer;

    public List<wsError> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<wsError> errorList) {
        ErrorList = errorList;
    }

    public FileServer getFileServer() {
        return fileServer;
    }

    public void setFileServer(FileServer fileServer) {
        this.fileServer = fileServer;
    }
}
