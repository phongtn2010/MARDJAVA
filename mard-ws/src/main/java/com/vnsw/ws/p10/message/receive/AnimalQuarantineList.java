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
@XmlType(name = "AnimalQuarantineList")
public class AnimalQuarantineList {
    @XmlElement(name = "AnimalQuarantine")
    private List<AnimalQuarantine> animalQuarantine;

    public AnimalQuarantineList() {
    }

    public AnimalQuarantineList(List<AnimalQuarantine> animalQuarantine) {
        this.animalQuarantine = animalQuarantine;
    }

    public List<AnimalQuarantine> getAnimalQuarantine() {
        return animalQuarantine;
    }

    public void setAnimalQuarantine(List<AnimalQuarantine> animalQuarantine) {
        this.animalQuarantine = animalQuarantine;
    }
}
