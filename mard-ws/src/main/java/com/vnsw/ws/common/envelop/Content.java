package com.vnsw.ws.common.envelop;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
public class Content {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error> ErrorList;
    
    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;

    public Content() {
    }

    public List<Error> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<Error> ErrorList) {
        this.ErrorList = ErrorList;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

   
    
}
