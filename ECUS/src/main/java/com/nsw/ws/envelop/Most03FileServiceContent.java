package com.nsw.ws.envelop;

import com.nsw.ws.common.wsError;
import com.nsw.ws.message.send.FileServer;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author PhongNV9
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
public class Most03FileServiceContent {

    public Most03FileServiceContent() {

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
