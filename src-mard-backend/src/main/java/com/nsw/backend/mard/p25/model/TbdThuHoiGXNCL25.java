package com.nsw.backend.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDTHUHOIGXNCL25", schema = "MARD")
public class TbdThuHoiGXNCL25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDTHUHOIGXNCL25_SEQ";
    @Id
    @Column(nullable = false,name="FI_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;
    @Column(name = "FI_ID_HS")
    private String fiIdHs;
    @Column(name = "FI_MAHOSO")
    private String fiNSWFileCode;
    @Column(name = "FI_NGAYHUY")
    private Date fiNgayHuy;
    @Column(name = "FI_LYDO")
    private String fiLyDo;
    @Column(name = "FI_NGAYKY")
    private Date fiNgayKy;
    @Column(name = "FI_NGUOIKY")
    private String fiNguoiKy;
    @Column(name = "FI_CER_NO")
    private String fiSoGXN;
    @Column(name = "FI_FILE_ID")
    private String fiFileID;
    @Column(name = "FI_FILE_NAME")
    private String fiFileName;
    @Column(name = "FI_FI_LINK")
    private String fiFileLink;
}
