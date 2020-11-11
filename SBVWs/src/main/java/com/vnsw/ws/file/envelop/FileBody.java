/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.file.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author QUANGNV18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class FileBody {
    public FileBody() {
    }
    
    @XmlElement(name = "Content")
    private FileContent Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }

    public FileContent getContent() {
        return Content;
    }

    public void setContent(FileContent Content) {
        this.Content = Content;
    }
}
