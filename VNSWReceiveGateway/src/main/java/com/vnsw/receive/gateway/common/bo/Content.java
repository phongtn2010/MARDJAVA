package com.vnsw.receive.gateway.common.bo;

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
public class Content {

    public Content() {

    }

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    private List<Error> ErrorList;

    public List<Error> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<Error> ErrorList) {
        this.ErrorList = ErrorList;
    }
}
