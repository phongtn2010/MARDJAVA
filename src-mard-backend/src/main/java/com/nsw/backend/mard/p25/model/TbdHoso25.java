/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p25.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TbdHoso06" - Hồ sơ Đăng ký
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDHOSO25", schema = "MARD")
public class TbdHoso25 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHOSO25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    //Thong tin ho so
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiNSWFileCode;

    @Column(name = "FI_HS_TYPE", nullable = false)
    private Integer fiHSType = 1;

    @Column(name = "FI_HS_STATUS")
    private Integer fiHSStatus;

    @Column(name = "FI_ACTIVE_STATUS")
    private boolean fiActive = true;

    @Column(name = "FI_TAXCODE", length = 50)
    private String fiTaxCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HS_CREATED_DATE")
    private Date fiHSCreatedDate;

    @Column(name = "FI_CONFIRMATION_NO", length = 50)
    private String fiConfirmationNo;

    //Các field phục vụ yêu cầu sửa.
    @Column(name = "FI_MODIFY_REASON", length = 250)
    private String fiReason;

    @Column(name = "FI_REQUEST_DATE")
    private String fiRequestDate;

    @Column(name = "FI_HS_ID_PARENT")
    private Integer fiIdHSParent;

    //Thông tin đăng ky bên Bán Hàng
    @Column(name = "FI_SELL_NAME", nullable = false, length = 250)
    private String fiSellName;

    @Column(name = "FI_SELL_ADDRESS", nullable = false, length = 500)
    private String fiSellAddress;

    @Column(name = "FI_SELL_TEL", nullable = false, length = 15)
    private String fiSellTel;

    @Column(name = "FI_SELL_FAX", length = 15)
    private String fiSellFax;

    @Column(name = "FI_SELL_EMAIL", nullable = false, length = 250)
    private String fiSellEmail;

    @Column(name = "FI_SELL_COUNTRY_CODE")
    private String fiSellCountryCode;

    @Column(name = "FI_SELL_COUNTRY_NAME")
    private String fiSellCountryName;

    @Column(name = "FI_SELL_EXPORT", nullable = false, length = 500)
    private String fiSellExport;

    //Thông tin đăng ky Mua Hàng
    @Column(name = "FI_PURCH_NAME", nullable = false, length = 250)
    private String fiPurchName;

    @Column(name = "FI_PURCH_ADDRESS", nullable = false, length = 500)
    private String fiPurchAddress;

    @Column(name = "FI_PURCH_TEL", nullable = false, length = 15)
    private String fiPurchTel;

    @Column(name = "FI_PURCH_FAX", length = 15)
    private String fiPurchFax;

    @Column(name = "FI_PURCH_EMAIL", nullable = false, length = 250)
    private String fiPurchEmail;

    @Column(name = "FI_PURCH_RECI", nullable = false, length = 500)
    private String fiPurchReci;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_PURCH_FROMDATE")
    private Date fiPurchFromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_PURCH_TODATE")
    private Date fiPurchToDate;

    //Thông tin lấy mẫu kiểm tra
    @Column(name = "FI_ADDRESS_GATH")
    private String fiAddressGath;

    @Column(name = "FI_ADDRESS_REG_SAMPLE")
    private String fiAddressRegSample;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REG_SAM_FROMDATE")
    private Date fiRegSamFromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REG_SAM_TODATE")
    private Date fiRegSamToDate;

    //Thông tin liên hệ
    @Column(name = "FI_CONTACT_NAME", nullable = false, length = 250)
    private String fiContactName;

    @Column(name = "FI_CONTACT_ADDRESS", nullable = false, length = 250)
    private String fiContactAddress;

    @Column(name = "FI_CONTACT_TEL", nullable = false, length = 15)
    private String fiContactTel;

    @Column(name = "FI_CONTACT_EMAIL", nullable = false, length = 250)
    private String fiContactEmail;

    //Thông tin hồ sơ Doanh Nghiệp
    @Column(name = "FI_SIGN_PROVIN_CODE", nullable = false, length = 6)
    private String fiSignProvinCode;

    @Column(name = "FI_SIGN_PROVIN_NAME", nullable = false, length = 250)
    private String fiSignProvinName;

    @Column(name = "FI_SIGN_NAME", nullable = false, length = 250)
    private String fiSignName;

    @Column(name = "FI_SIGN_POSITION", nullable = false, length = 250)
    private String fiSignPosition;

    //Danh sách thông tin kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdHanghoa25> fiProductList;

    // Dinh kem
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdDinhkem25> fiAttachmentList;

    @Transient
    private String fiCertNo;

    public TbdHoso25() {
        super();
        fiProductList = new ArrayList<>();
        fiAttachmentList = new ArrayList<>();
    }
}
