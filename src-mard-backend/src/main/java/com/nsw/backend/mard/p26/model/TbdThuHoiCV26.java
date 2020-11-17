package com.nsw.backend.mard.p26.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBD_THUHOICV26", schema = "MARD")
public class TbdThuHoiCV26 {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBD_THUHOICV26_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false,name = "FI_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;

    @Column(name = "FI_HS_CODE", length = 500)
    private String fiMaHoso;

    @Column(name = "FI_HS_ID")
    private Integer fiIdHoSo26;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_NGAYTHUHOI")
    private Date fiNgayThuHoi;

    @Column(name = "FI_LYDO", length = 500)
    private String fiLyDoThuHoi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_NGAYKY")
    private Date fiNgayKy;

    @Column(name = "FI_NGUOIKY", length = 100)
    private String fiNguoiKy;

    //Thông tin cv mien kiem
    @Column(name = "FI_CONGVAN_MK", length = 250)
    private String fiSoCVMienKiem;

    @Column(name = "FI_FILE_ID", length = 10)
    private String fiFileId;

    @Column(name = "FI_FILE_NAME", length = 250)
    private String fiFileName;

    @Column(name = "FI_FILE_LINK", length = 1000)
    private String fiFileLink;
}
