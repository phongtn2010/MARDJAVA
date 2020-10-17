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
@XmlType(name = "ProductAnimalQuarantineList")
public class ProductAnimalQuarantineList {
    @XmlElement(name = "ProductAnimalQuarantine")
    private List<ProductAnimalQuarantine> productAnimalQuarantine;

    public ProductAnimalQuarantineList() {
    }

    public ProductAnimalQuarantineList(List<ProductAnimalQuarantine> productAnimalQuarantine) {
        this.productAnimalQuarantine = productAnimalQuarantine;
    }

    public List<ProductAnimalQuarantine> getProductAnimalQuarantine() {
        return productAnimalQuarantine;
    }

    public void setProductAnimalQuarantine(List<ProductAnimalQuarantine> productAnimalQuarantine) {
        this.productAnimalQuarantine = productAnimalQuarantine;
    }
    
}
