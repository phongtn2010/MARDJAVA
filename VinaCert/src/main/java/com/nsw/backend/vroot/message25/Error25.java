package com.nsw.backend.vroot.message25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement(name = "Error")
@XmlAccessorType(XmlAccessType.FIELD)
public class Error25 implements Serializable{

    @XmlElement(name = "ErrorCode")
    private String ErrorCode;
    @XmlElement(name = "ErrorName")
    private String ErrorName;

    public Error25() {

    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public String getErrorName() {
        return ErrorName;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public void setErrorName(String ErrorName) {
        this.ErrorName = ErrorName;
    }

    @Override
    public String toString() {
        return "Error{" + "ErrorCode=" + ErrorCode + ", ErrorName=" + ErrorName + '}';
    }
}
