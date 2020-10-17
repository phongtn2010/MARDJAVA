/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.receive;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuarantineCerEditResponseList")
public class QuarantineCerEditResponseList {
    
    @XmlElement(name = "QuarantineCerEditResponse")
    private List<QuarantineCerEditResponse> quarantineCerEditResponse;

    public QuarantineCerEditResponseList() {
    }

    public List<QuarantineCerEditResponse> getQuarantineCerEditResponse() {
        return quarantineCerEditResponse;
    }

    public void setQuarantineCerEditResponse(List<QuarantineCerEditResponse> quarantineCerEditResponse) {
        this.quarantineCerEditResponse = quarantineCerEditResponse;
    }
}
