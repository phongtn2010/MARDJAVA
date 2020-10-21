package com.vnsw.ws.p25.entity;

import com.vnsw.ws.annotations.DoubleSerialization;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "Goods")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Product {

    @XmlElement(name = "GoodsId")
    private String fiId;

    @XmlElement(name = "NameOfGoods")
    private String fiProName;

    @XmlElement(name = "NoticeOfExemptionFromInspectionNo")
    private String fiProCVMienGiam;

    @XmlElement(name = "NoticeDate")
    private String fiProCVMienGiamNgay;

    @XmlElement(name = "GroupFoodOfGoods")
    private String fiProIdNhom;

    @XmlElement(name = "GroupGoodId")
    private String fiProIdPhanNhom;

    @XmlElement(name = "GroupGoodName")
    private String fiProNamePhanNhom;

    @XmlElement(name = "GoodTypeId")
    private String fiProIdLoai;

    @XmlElement(name = "GoodTypeName")
    private String fiProNameLoai;

    @XmlElement(name = "GroupTypeId")
    private String fiProIdPhanLoai;

    @XmlElement(name = "GroupTypeName")
    private String fiProNamePhanLoai;

    @XmlElement(name = "Nature")
    private String fiBanChat;

    @XmlElement(name = "RegistrationNumber")
    private String fiProCode;

    @XmlElement(name = "Manufacture")
    private String fiProMadeIn;

    @XmlElement(name = "ManufactureStateCode")
    private String fiProCountryCode;

    @XmlElement(name = "ManufactureState")
    private String fiProCountryName;

    @XmlElement(name = "Material")
    private String fiProThanhPhan;

    @XmlElement(name = "FormColorOfProducts")
    private String fiProColor;

    @XmlElement(name = "StandardBase")
    private String fiProSoHieu;

    @XmlElement(name = "TechnicalRegulations")
    private String fiProQuyChuan;

    @XmlElementWrapper(name = "QuantityVolumeList")
    @XmlElement(name = "QuantityVolume")
    private List<QuantityVolume> fiProSLKLList;

    @XmlElementWrapper(name = "SafetyCriteriaList")
    @XmlElement(name = "SafetyCriteria")
    private List<SafetyCriteria> fiProATList;

    @XmlElementWrapper(name = "QualityCriteriaList")
    @XmlElement(name = "QualityCriteria")
    private List<QualityCriteria> fiProCLList;


}
