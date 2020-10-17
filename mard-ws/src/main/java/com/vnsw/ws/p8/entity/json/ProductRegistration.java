package com.vnsw.ws.p8.entity.json;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p8.entity.Product;
import com.vnsw.ws.p8.entity.ProductCompany;
import com.vnsw.ws.p8.entity.ProductManufacture;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;


@XmlType(name = "ProductRegistration")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ProductRegistration {
    @XmlElementWrapper(name = "ProductList")
    @XmlElement(name = "Product")
    private List<Product> fiProductList;

    @XmlElementWrapper(name = "ProductCompanyList")
    @XmlElement(name = "ProductCompany")
    private List<ProductCompany> fiProductCompanyList;

    @XmlElementWrapper(name = "ProductManufactureList")
    @XmlElement(name = "ProductManufacture")
    private List<ProductManufacture> fiProductManufactureList;

    @XmlElement(name = "ProductExecutionTime")
    private String fiProductExecutionTime;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ProductExecutionTimeFrom")
    private Date fiProductExecutionTimeFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ProductExecutionTimeTo")
    private Date fiProductExecutionTimeTo;


    @XmlElement(name = "ProductPurpose")
    private String fiProductPurpose;

    @XmlElement(name = "ProductAttachedDoc")
    private String fiProductAttachedDoc;


}
