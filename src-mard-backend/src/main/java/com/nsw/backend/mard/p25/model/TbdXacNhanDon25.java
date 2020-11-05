package com.nsw.backend.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDXACNHANDON25", schema = "MARD")
public class TbdXacNhanDon25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDXACNHANDON25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiNSWFileCode;
    @Column(name = "FI_SO_GXN", length = 50)
    private String fiSoGXN;
    @Column(name = "FI_ID_CQXL", length = 50)
    private String fiIdCqxl;
    @Column(name = "FI_NAME_CQXL", length = 500)
    private String fiNameCqxl;
    @Column(name = "FI_ID_CQCD", length = 50)
    private String fiIdCqcd;
    @Column(name = "FI_NAME_CQCD", length = 500)
    private String fiNameCqcd;
    @Column(name = "FI_DVDG", length = 500)
    private String fiDvdg;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_NGAYXN")
    private Date fiNgayXN;
    @Column(name = "FI_NOIXN", length = 500)
    private String fiNoiXN;
    @Column(name = "FI_NGUOIXN", length = 500)
    private String fiNguoiXN;
    @Column(name = "FI_NOTEGOODS", length = 1000)
    private String fiGhiChu;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_NGAYTHUHOI")
    private Date fiNgayThuHoi;

    @Column(name = "FI_LYDO", length = 1000)
    private String fiLyDoThuHoi;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_NGAYKY")
    private Date fiNgayKy;
    @Column(name = "FI_NGUOIKY", length = 1000)
    private String fiNguoiKy;
}
