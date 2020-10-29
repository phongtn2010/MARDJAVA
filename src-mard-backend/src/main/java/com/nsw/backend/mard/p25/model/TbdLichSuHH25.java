package com.nsw.backend.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDLICHSU_HH25", schema = "MARD")
public class TbdLichSuHH25  implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDLICHSU_HH25_SEQ";

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
    @Column(name = "FI_ID_HANGHOA")
    private Integer fiIDHangHoa; //Cơ quan xử lý

    @Column(name = "FI_NOIDUNG")
    private String fiNoiDung;

    @Column(name = "FI_NGUOIGUI")
    private String fiNguoiGui;

    @Column(name = "FI_NGUOINHAN")
    private String fiNguoiNhan;

    @Column(name = "FI_HOATDONG")
    private Integer fiHoatDong;

    @Column(name = "FI_NGAYGUI")
    private Date fiNgayGui;

    @Column(name = "FI_GHICHU")
    private String fiGhiChu;

}
