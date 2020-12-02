package com.nsw.backend.mard.p25.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TBDKQXL25", schema = "MARD")
public class TbdKQXL25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDKQXL25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false,name = "FI_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    //Thong tin ho so
    @Column(name = "FI_HS_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_DVXL_CODE")
    private String fiDVXLCode;

    @Column(name = "FI_DVXL_NAME")
    private String fiDVXLName;

    @Column(name = "FI_ID_HANGHOA")
    private Integer fiProId;

    @Column(name = "FI_PRO_NAME")
    private String fiProName;

    @Column(name = "FI_LOAI_KQDG")
    private Integer fiLoaiKQDG;

    @Column(name = "FI_SO_GCN")
    private String fiSoGCN;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_NGAYDG")
    private Date fiNgayDG;

    @Column(name = "FI_ID_FILEGCN")
    private String fiIDFileGCN;

    @Column(name = "FI_LINK_GCN")
    private String fiLinkGCN;

    @Column(name = "FI_NAME_GCN")
    private String fiNameGCN;

    @Column(name = "FI_REASON")
    private String fiLyDo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_NGAYPHANHOI")
    private Date fiNgayPhanHoi;

    @Column(name = "FI_NGUOIXL")
    private String fiNguoiXL;


    @Column(name = "FI_THUHOI", nullable = false)
    private Boolean isThuHoi;
    @Transient
    private List<TbdHangHoaFile25> fiListHangHoaFile;
}
