package com.nsw.backend.mard.p25.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "TBDHOSO_TCCD25")
@Data
public class TbdhosoTccd25 implements Serializable {

    private static final long serialVersionUID = 1L;


    public static final String SEQUENCE_NAME = "TBDHOSO_TCCD25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false,name = "FIID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;

    @Column(name = "FI_MA_CQKT")
    private String fiMaCqkt;

    @Column(name = "FI_TEN_CQKT")
    private String fiTenCqkt;

    @Column(name = "FI_HS_CODE")
    private String fiHsCode;

    @Column(name = "FI_LOAI_DANHGIA")
    private Integer fiLoaiDanhgia;

    @Column(name = "FI_SO_GCN")
    private String fiSoGcn;

    @Column(name = "FI_NGAYCAP")
    private Date fiNgaycap;

    @Column(name = "FI_ID_FILE_GCN")
    private String fiIdFileGcn;

    @Column(name = "FI_NAME_FILE_GCN")
    private String fiNameFileGcn;

    @Column(name = "FI_LINK_GCN")
    private String fiLinkGcn;

    @Column(name = "FI_ID_HANGHOA")
    private Integer fiIdHangHoa;

    @Column(name = "FI_TEN_HANGHOA")
    private String fiTenHangHoa;

}
