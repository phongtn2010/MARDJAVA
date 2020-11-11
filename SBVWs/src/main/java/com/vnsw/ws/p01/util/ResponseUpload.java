/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p01.util;
/**
 *
 * @author phongnv
 */
public class ResponseUpload {
    
    protected String filePath;
    protected String fileName;
    protected String fileCode;
    protected String errorCode;
    protected String errorName;

    public ResponseUpload() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
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

	@Override
	public String toString() {
		return "ResponseUpload [filePath=" + filePath + ", fileName=" + fileName + ", fileCode=" + fileCode
				+ ", errorCode=" + errorCode + ", errorName=" + errorName + "]";
	}
    
    

}
