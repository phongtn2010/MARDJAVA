package com.nsw.backend.mard.p25.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDGIAYXNCL25", schema = "MARD")
public class TbdGiayXNCL25 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDGIAYXNCL25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_HS_CODE", length = 20)
    private String fiNSWFileCode;

    @Column(name = "FI_DP_CODE", length = 12)
    private String fiMaCQKT;

    @Column(name = "FI_DP_NAME", length = 250)
    private String fiTenCQKT;

    @Column(name = "FI_CER_NO")
    private String fiSoGCN;

    @Column(name = "FI_SIGN_CER_PLACE", length = 100)
    private String fiNoiKy;

    @Column(name = "FI_SIGN_CER_DATE")
    private Date fiNgayKy;

    @Column(name = "FI_GOOD_ID", length = 20)
    private Integer fiIdHangHoa;

    @Column(name = "FI_GOOD_NAME", length = 250)
    private String fiTenHangHoa;

    @Column(name = "FI_IMPORT_CER_NO", length = 50)
    private String fiGCNHopQuy;

    @Column(name = "FI_ASSIGN_CODE", length = 12)
    private String fiIDCoQuanDanhGia;

    @Column(name = "FI_ASSIGN_NAME", length = 250)
    private String fiNameCoQuanDanhGia;

    @Column(name = "FI_IMPORT_CER_DATE")
    private Date fiNgayCap;

    @Column(name = "FI_SIGN_CER_NAME", length = 100)
    private String fiNguoiKy;

    @Transient
    private List<TbdHanghoa25> fiProductList;
}
