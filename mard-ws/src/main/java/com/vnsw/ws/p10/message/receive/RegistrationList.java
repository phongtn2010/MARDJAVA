/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.receive;

import com.vnsw.ws.p10.entity.db.Tbdhoso10;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RegistrationList")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegistrationList {
    @XmlElement(name = "Registration")
    private List<Tbdhoso10> registration;

    public RegistrationList() {
    }

    public RegistrationList(List<Tbdhoso10> registration) {
        this.registration = registration;
    }

    public List<Tbdhoso10> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Tbdhoso10> registration) {
        this.registration = registration;
    }
}
