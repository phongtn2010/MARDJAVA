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
@XmlType(name = "AnimalIsolationList")
public class AnimalIsolationList {
    @XmlElement(name = "AnimalIsolation")
    private List<AnimalIsolation> animalIsolation;

    public AnimalIsolationList() {
    }

    public AnimalIsolationList(List<AnimalIsolation> animalIsolation) {
        this.animalIsolation = animalIsolation;
    }
    
    public List<AnimalIsolation> getAnimalIsolation() {
        return animalIsolation;
    }

    public void setAnimalIsolation(List<AnimalIsolation> animalIsolation) {
        this.animalIsolation = animalIsolation;
    }

    
}
