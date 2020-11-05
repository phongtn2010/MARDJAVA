package com.vnsw.ws.p25.entity.send;

import com.vnsw.ws.p25.entity.receive.Ananytical;
import com.vnsw.ws.p25.entity.send.QualityCriteria;
import com.vnsw.ws.p25.entity.send.QuantityVolume;
import com.vnsw.ws.p25.entity.send.SafetyCriteria;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "Goods")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Product {

    @XmlElement(name = "GoodsId")
    private String fiIdProduct;

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
    @XmlElementWrapper(name = "QualityCriteriaList")
    @XmlElement(name = "QualityCriteria")
    private List<QualityCriteria> fiProCLList;

    @XmlElementWrapper(name = "SafetyCriteriaList")
    @XmlElement(name = "SafetyCriteria")
    private List<SafetyCriteria> fiProATList;
    @XmlElement(name = "GoodsValue")
    private Float fiProValueVN;
    @XmlElement(name = "GoodsValueUnitCode")
    private String fiPackageUnitCode;
    @XmlElement(name = "GoodsValueUnitName")
    private String fiPackageUnitName;
    @XmlElement(name = "GoodsValueUSD")
    private Float fiProValueUSD;

    @XmlElement(name = "NoteGoods")
    private String fiNoteGoods;

    @XmlElementWrapper(name = "AnanyticalRequiredList")
    @XmlElement(name = "Ananytical")
    private List<Ananytical> fiListChiTieu;
}
