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
@XmlType(name = "AnimalProductsIsolationList")
public class AnimalProductsIsolationList {
    @XmlElement(name = "AnimalProductsIsolation")
    private List<AnimalProductsIsolation> animalProductsIsolation;

    public AnimalProductsIsolationList() {
    }

    public AnimalProductsIsolationList(List<AnimalProductsIsolation> animalProductsIsolation) {
        this.animalProductsIsolation = animalProductsIsolation;
    }
    
    public List<AnimalProductsIsolation> getAnimalProductsIsolation() {
        return animalProductsIsolation;
    }

    public void setAnimalProductsIsolation(List<AnimalProductsIsolation> animalProductsIsolation) {
        this.animalProductsIsolation = animalProductsIsolation;
    }

    
}
