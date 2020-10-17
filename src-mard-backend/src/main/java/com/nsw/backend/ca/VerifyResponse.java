package com.nsw.backend.ca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyResponse")
public class VerifyResponse {

    @XmlElement(name = "VerifyResult")
    private String VerifyResult;

    public String getVerifyResult() {
        return VerifyResult;
    }

    public void setVerifyResult(String verifyResult) {
        VerifyResult = verifyResult;
    }
}
