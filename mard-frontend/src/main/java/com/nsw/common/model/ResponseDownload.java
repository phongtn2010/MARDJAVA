package com.nsw.common.model;

public class ResponseDownload {

    public ResponseDownload() {

    }

    protected byte[] content;

    protected String errorCode;

    protected String errorName;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

}
