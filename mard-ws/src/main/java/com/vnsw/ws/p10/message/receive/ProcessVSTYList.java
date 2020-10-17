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
@XmlType(name = "ProcessVSTYList")
public class ProcessVSTYList {
    @XmlElement(name = "ProcessVSTY")
    private List<ProcessVSTY> processVSTY;

    public ProcessVSTYList() {
    }

    public ProcessVSTYList(List<ProcessVSTY> processVSTY) {
        this.processVSTY = processVSTY;
    }

    public List<ProcessVSTY> getProcessVSTY() {
        return processVSTY;
    }

    public void setProcessVSTY(List<ProcessVSTY> processVSTY) {
        this.processVSTY = processVSTY;
    }
}
