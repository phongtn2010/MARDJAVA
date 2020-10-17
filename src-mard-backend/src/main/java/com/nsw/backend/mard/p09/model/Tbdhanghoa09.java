package com.nsw.backend.mard.p09.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import com.nsw.backend.mard.p09.dto.receive.Goods;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDHANGHOA09"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDHANGHOA09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbdhanghoa09.countAll", query = "SELECT COUNT(x) FROM Tbdhanghoa09 x")
})
public class Tbdhanghoa09 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_GOOD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHANGHOA09_SEQ")
    @SequenceGenerator(sequenceName = "TBDHANGHOA09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDHANGHOA09_SEQ")
    private Long fiIdProduct;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_ID_CVXNKD")
    private Long fiIdQualityRejectCer;

    @Column(name = "FI_ID_GIAY_VC")
    private Long fiIdTransportDoc;

    @Column(name = "FI_ID_GIAY_CNKD")
    private Long fiIdQuarantineCer;

    @Column(name = "FI_GOOD_CODE", length = 250)
    private String fiProductCode;

    @Column(name = "FI_GOOD_NAME", length = 250)
    private String fiProductName;

    @Column(name = "FI_GOOD_SCIENCE_NAME", length = 250)
    private String fiProductScienceName;

    @Column(name = "FI_QUANTITY_FEMALE")
    private Long fiQuantityFemale;

    @Column(name = "FI_QUOTED_QTY_FM")
    private Long fiQuotedQuantityFemale;


    @Column(name = "FI_QUANTITY_MALE")
    private Long fiQuantityMale;

    @Column(name = "FI_QUOTED_QTY_M")
    private Long fiQuotedQuantityMale;

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

    @Column(name = "FI_QUOTED_QUANTITY")
    private Double fiQuotedNumber;

    @Column(name = "FI_QUANTITY_U_CODE", length = 18)
    private String fiUnitCode;

    @Column(name = "FI_QUANTITY_U_NAME", length = 250)
    private String fiUnitName;

    @Column(name = "FI_NET_WEIGHT")
    private Double fiNetWeight;

    @Column(name = "FI_QUOTED_NW")
    private Double fiQuotedNetWeight;

    @Column(name = "FI_NET_WEIGHT_U_CODE", length = 18)
    private String fiNWUnitCode;

    @Column(name = "FI_NET_WEIGHT_U_NAME", length = 250)
    private String fiNWUnitName;

    @Column(name = "FI_GROSS_WEIGHT")
    private Double fiGrossWeight;

    @Column(name = "FI_QUOTED_GW")
    private Double fiQuotedGrossWeight;

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

    public Tbdhanghoa09() {
        super();
    }

    public Long getFiQuotedQuantityFemale() {
        return fiQuotedQuantityFemale == null ? 0 : fiQuotedQuantityFemale;
    }

    public Long getFiQuotedQuantityMale() {
        return fiQuotedQuantityMale == null ? 0 : fiQuotedQuantityMale;
    }

    public Double getFiQuotedNumber() {
        return fiQuotedNumber == null ? 0 : fiQuotedNumber;
    }

    public Double getFiQuotedNetWeight() {
        return fiQuotedNetWeight == null ? 0 : fiQuotedNetWeight;
    }

    public Double getFiQuotedGrossWeight() {
        return fiQuotedGrossWeight == null ? 0 : fiQuotedGrossWeight;
    }
}
