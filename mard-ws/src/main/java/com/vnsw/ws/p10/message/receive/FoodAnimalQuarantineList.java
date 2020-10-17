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
@XmlType(name = "FoodAnimalQuarantineList")
public class FoodAnimalQuarantineList {
    @XmlElement(name = "FoodAnimalQuarantine")
    private List<FoodAnimalQuarantine> foodAnimalQuarantine;

    public FoodAnimalQuarantineList() {
    }

    public FoodAnimalQuarantineList(List<FoodAnimalQuarantine> foodAnimalQuarantine) {
        this.foodAnimalQuarantine = foodAnimalQuarantine;
    }

    public List<FoodAnimalQuarantine> getFoodAnimalQuarantine() {
        return foodAnimalQuarantine;
    }

    public void setFoodAnimalQuarantine(List<FoodAnimalQuarantine> foodAnimalQuarantine) {
        this.foodAnimalQuarantine = foodAnimalQuarantine;
    }
}
