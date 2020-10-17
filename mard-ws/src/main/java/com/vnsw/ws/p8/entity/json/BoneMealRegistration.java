package com.vnsw.ws.p8.entity.json;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p8.entity.BoneMeal;
import com.vnsw.ws.p8.entity.BoneMealCompany;
import com.vnsw.ws.p8.entity.BoneMealManufacture;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "BoneMealRegistration")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BoneMealRegistration {
    @XmlElementWrapper(name = "BoneMealList")
    @XmlElement(name = "BoneMeal")
    private List<BoneMeal> fiBoneMealList;

    @XmlElementWrapper(name = "BoneMealCompanyList")
    @XmlElement(name = "BoneMealCompany")
    private List<BoneMealCompany> fiBoneMealCompanyList;

    @XmlElementWrapper(name = "BoneMealManufactureList")
    @XmlElement(name = "BoneMealManufacture")
    private List<BoneMealManufacture> fiBoneMealManufactureList;

    @XmlElement(name = "BoneMealExecutionTime")
    private String fiBoneMealExecutionTime;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "BoneMealExecutionTimeFrom")
    private Date fiBoneMealExecutionTimeFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "BoneMealExecutionTimeTo")
    private Date fiBoneMealExecutionTimeTo;

    @XmlElement(name = "BoneMealPurpose")
    private String fiBoneMealPurpose;

    @XmlElement(name = "BoneMealOrtherPurpose")
    private String fiBoneMealOtherPurpose;

    @XmlElement(name = "BoneMealAttachedDoc")
    private String fiBoneMealAttachedDoc;

    @XmlElement(name = "BoneMealFactoryName")
    private String fiBoneMealFactoryName;

    @XmlElement(name = "BoneMealFactoryAddress")
    private String fiBoneMealFactoryAddress;
}
