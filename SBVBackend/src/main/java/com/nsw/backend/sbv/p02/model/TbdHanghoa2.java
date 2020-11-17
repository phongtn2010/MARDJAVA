package com.nsw.backend.sbv.p02.model;


import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDHANGHOA2", schema = "SBV")
public class TbdHanghoa2 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOA2_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "SBV", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdHangHoa;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_ID_HS")
    private Integer fiIdHS;

    @Column(name = "FI_ID_DANHMUCVANG")
    private Integer fiIdDanhMucVang;

    @Column(name = "FI_HAM_LUONG")
    private Integer fiHamLuong;

    @Column(name = "FI_KHOI_LUONG")
    private Float fiKhoiLuong;

    @Column(name = "FI_ID_DON_VI_TINH")
    private Integer fiIdDonViTinh;

    @Column(name = "FI_GIA_TRI_UOC_TINH")
    private Float fiGiaTriUocTinh;
}