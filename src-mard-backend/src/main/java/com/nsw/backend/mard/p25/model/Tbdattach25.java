package com.nsw.backend.mard.p25.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBDATTACH_25")
public class Tbdattach25 implements Serializable {

    public static final String SEQUENCE_NAME = "TBDATTACH_25_SEQ";

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiId;

    @Column(name = "FI_HS_ID")
    private Long fiIdHs;

    @Column(name = "FI_LOAIFILE")
    private Long fiLoaifile;

    @Column(name = "FI_TENLOAI")
    private String fiTenloai;

    @Column(name = "FI_TENFILE")
    private String fiTenFile;

    @Column(name = "FI_FILE_ID")
    private Long fiFileId;

    @Column(name = "FI_FILE_NAME")
    private String fiFileName;

    @Column(name = "FI_FILE_LINK")
    private String fiFileLink;

}
