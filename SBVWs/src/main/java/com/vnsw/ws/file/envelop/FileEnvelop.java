/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.file.envelop;

import com.vnsw.ws.common.envelop.Header;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author QUANGNV18
 */
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class FileEnvelop {

    public FileEnvelop() {
    }
    @XmlElement(name = "Header")
    private Header Header;
    @XmlElement(name = "Body")
    private FileBody Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header getHeader() {
        return Header;
    }

    public void setHeader(Header Header) {
        this.Header = Header;
    }

    public FileBody getBody() {
        return Body;
    }

    public void setBody(FileBody Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }
}
