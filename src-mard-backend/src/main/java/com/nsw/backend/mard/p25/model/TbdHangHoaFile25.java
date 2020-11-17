package com.nsw.backend.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDHANGHOA_FILE25", schema = "MARD")
public class TbdHangHoaFile25  implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOA_FILE25_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false,name = "FIID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;

    @Column(name = "FI_FILE_ID")
    private String fiFileId;
    @Column(name = "FI_FILE_LINK")
    private String fiFileLink;
    @Column(name = "FI_FILE_NAME")
    private String fiFileName;
    @Column(name = "FI_ID_HANGHOA")
    private Integer fiIDHangHoa;
    @Column(name = "FI_LOAIFILE")
    private Integer fiLoaiFile;
    @Column(name = "FI_TENLOAI")
    private String fiTenLoai;
    @Column(name = "FI_TENFILE")
    private String fiTenFile;
    @Column(name = "FI_SOCV")
    private String fiSoCV;
    @Column(name = "FI_NGAY_CAP")
    private Date fiNgayCap;
}
