package com.nsw.backend.mard.p09.model;

import com.nsw.backend.mard.p09.dto.receive.Goods;
import com.nsw.backend.mard.p09.dto.receive.QualityResultGoods;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class CmonHh09 {
    @Column(name = "FI_GOOD_CODE", length = 250)
    private String fiProductCode;

    @Column(name = "FI_GOOD_NAME", length = 250)
    private String fiProductName;

    @Column(name = "FI_GOOD_SCIENCE_NAME", length = 250)
    private String fiProductScienceName;

    @Column(name = "FI_QUANTITY_FEMALE")
    private Long fiQuantityFemale;

    @Column(name = "FI_QUANTITY_MALE")
    private Long fiQuantityMale;

    @Column(name = "FI_AGE")
    private Integer fiAge;

    @Column(name = "FI_GENDER")
    private Integer fiGender;

    @Column(name = "FI_INCL_MALE")
    private Integer fiIncludeMale;

    @Column(name = "FI_INCL_FEMALE")
    private Integer fiIncludeFemale;

    @Column(name = "FI_PACKING_WAY", length = 250)
    private String fiPackingWay;

    @Column(name = "FI_QUANTITY")
    private Double fiNumber;

    @Column(name = "FI_QUANTITY_U_CODE", length = 18)
    private String fiUnitCode;

    @Column(name = "FI_QUANTITY_U_NAME", length = 250)
    private String fiUnitName;

    @Column(name = "FI_NET_WEIGHT")

    private Double fiNetWeight;

    @Column(name = "FI_NET_WEIGHT_U_CODE", length = 18)
    private String fiNWUnitCode;

    @Column(name = "FI_NET_WEIGHT_U_NAME", length = 250)
    private String fiNWUnitName;

    @Column(name = "FI_GROSS_WEIGHT")
    private Double fiGrossWeight;

    @Column(name = "FI_GROSS_WEIGHT_U_Code", length = 250)
    private String fiGWUnitCode;

    @Column(name = "FI_GROSS_WEIGHT_U_NAME", length = 250)
    private String fiGWUnitName;

    @Column(name = "FI_PURPOSE_USE", length = 500)
    private String fiPurposeUse;

    @Column(name = "FI_ORIGINATION_CODE", length = 3)
    private String fiCountryOrigin;

    @Column(name = "FI_ORIGINATION_NAME", length = 250)
    private String fiCountryOriginName;

    @Column(name = "FI_IM_PORT_DEST_CODE", length = 250)
    private String fiImportPortDestCode;

    @Column(name = "FI_IM_PORT_DEST_NAME", length = 250)
    private String fiImportPortOfDestName;

    @Column(name = "FI_CIRCULATE_NO")
    private String fiCirculateNo;

    @Column(name = "FI_CRITER_ANALY_NO", length = 50)
    private String fiCriteriaAnalysisNo;

    @Column(name = "FI_GOODS_DESCRIPTION", length = 50)
    private String fiDescriptionOfGoods;

    @Column(name = "FI_RESULT")
    private Long fiResult;

    @Column(name = "FI_REASON")
    private String fiReason;

    public static <T extends CmonHh09> T parse(Goods goods, Class<T> clazz) {
        try {
            T hh = clazz.newInstance();
            hh.setFiProductCode(goods.getFiCodeOfGoods());
            hh.setFiProductName(goods.getFiNameOfGoods());
            hh.setFiAge(goods.getFiAge());
            hh.setFiGender(goods.getFiGender());
            hh.setFiIncludeFemale(goods.getFiIncludeFemale());
            hh.setFiIncludeMale(goods.getFiIncludeMale());
            hh.setFiPackingWay(goods.getFiWayOfPackinglist());
            hh.setFiNumber(goods.getFiQuantityOrVolumn());
            hh.setFiUnitCode(goods.getFiQuantityUnitCode());
            hh.setFiUnitName(goods.getFiQuantityUnitName());
            hh.setFiNetWeight(goods.getFiNetWeight());
            hh.setFiNWUnitCode(goods.getFiNetWeightUnitCode());
            hh.setFiNWUnitName(goods.getFiNetWeightUnitName());
            hh.setFiGrossWeight(goods.getFiGrossWeight());
            hh.setFiGWUnitCode(goods.getFiGrossWeightUnitCode());
            hh.setFiGWUnitName(goods.getFiGrossWeightUnitName());
            hh.setFiPurposeUse(goods.getFiPurposeUse());
            return hh;
        } catch (InstantiationException | IllegalAccessException e) {
            //DO NOTHING
        }
        return null;
    }

    public static <T extends CmonHh09> T parse(QualityResultGoods goods, Class<T> clazz) {
        try {
            T hh = clazz.newInstance();
            hh.setFiProductCode(goods.getFiCodeOfGoods());
            hh.setFiProductName(goods.getFiNameOfGoods());
            hh.setFiNumber(goods.getFiQuantityOrVolumn());
            hh.setFiUnitCode(goods.getFiQuantityOrVolumnUnitCode());
            hh.setFiUnitName(goods.getFiQuantityOrVolumnUnitName());
            hh.setFiCriteriaAnalysisNo(goods.getFiCriteriaAnalysisNo());
            hh.setFiDescriptionOfGoods(goods.getFiDescriptionOfGoods());
            hh.setFiResult(goods.getFiResult());
            hh.setFiReason(goods.getFiReason());
            return hh;
        } catch (InstantiationException | IllegalAccessException e) {
            //DO NOTHING
        }
        return null;
    }
}
