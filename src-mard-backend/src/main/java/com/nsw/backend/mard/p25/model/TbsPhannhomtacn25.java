package com.nsw.backend.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "TBS_PHANNHOMTACN25")
@EqualsAndHashCode(callSuper = false)
public class TbsPhannhomtacn25 implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBS_PHANNHOMTACN25_SEQ";

    @Id
    @Column(name = "FI_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiId;

    @Column(name = "FI_MAPHANNHOM")
    private String fiMaphannhom;

    @Column(name = "FI_TENPHANNHOM")
    private String fiTenphannhom;

    @Column(name = "FI_NGAYTAO")
    private Date fiNgaytao;

    @Column(name = "FI_TRANGTHAI")
    private String fiTrangthai;

}
