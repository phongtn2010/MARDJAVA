package com.nsw.backend.mard.p25.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "TBDATTACH_DG25")
@Data
public class TbdattachDg25 implements Serializable {
    public static final String SEQUENCE_NAME = "TBDATTACH_DG25_SEQ";

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiId;

    @Column(name = "FI_HS_ID")
    private Long fiIdHs;

    @Column(name = "FI_SO_PHIEU")
    private String fiSoPhieu;

    @Column(name = "FI_NGAY_PHIEU")
    private Date fiNgayPhieu;

    @Column(name = "FI_FILE_ID")
    private Long fiFileId;

    @Column(name = "FI_FILE_NAME")
    private String fiFileName;

    @Column(name = "FI_FILE_LINK")
    private String fiFileLink;

}
