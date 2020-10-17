package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Product {
    @XmlElement(name = "ProductSort")
    private long fiProductSort;

    @XmlElement(name = "ProductCode")
    private String fiProductCode;

    @XmlElement(name = "ProductName")
    private String fiProductName;

    @XmlElement(name = "ProductQuantity")
    private float fiProductQuantity;

    @XmlElement(name = "ProductQuantityUnitCode")
    private String fiProductQuantityUnitCode;

    @XmlElement(name = "ProductQuantityUnitName")
    private String fiProductQuantityUnitName;

    @XmlElement(name = "ProductExporterStateName")
    private String fiProductExporterStateName;

    @XmlElement(name = "ProductExporterStateCode")
    private String fiProductExporterStateCode;

    @XmlElement(name = "ProductPortOfDestinationName")
    private String fiProductPortOfDestinationName;

    @XmlElement(name = "ProductPortOfDestinationCode")
    private String fiProductPortOfDestinationCode;
}
