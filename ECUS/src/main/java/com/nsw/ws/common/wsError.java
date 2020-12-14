package com.nsw.ws.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Linhdx
 */
@XmlRootElement(name = "Error")
@XmlAccessorType(XmlAccessType.FIELD)
public class wsError {

    @XmlElement(name = "ErrorCode")
    private String ErrorCode;
    @XmlElement(name = "ErrorName")
    private String ErrorName;

    public wsError() {

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

}
