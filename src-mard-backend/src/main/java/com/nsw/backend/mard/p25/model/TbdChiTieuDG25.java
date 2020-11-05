package com.nsw.backend.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDCHITIEUDG25", schema = "MARD")
public class TbdChiTieuDG25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDCHITEUDG25_SEQ";
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiNSWFileCode;
    @Column(name = "FI_ID_HANGHOA")
    private Integer fiIdProduct;
    @Column(name = "FI_TEN_HANGHOA", length = 500)
    private String fiTenHangHoa;
    @Column(name = "FI_TENCHITEU", length = 500)
    private String fiTenChiTieu;
    @Column(name = "FI_HINHTHUC_CB")
    private Integer fiHinhThucCB;
    @Column(name = "FI_HAMLUONG", length = 50)
    private String fiHamLuong;
    @Column(name = "FI_MADVT", length = 50)
    private String fiMaDVT;
    @Column(name = "FI_TENDVT", length = 500)
    private String fiTenDVT;
    @Column(name = "FI_GHICHU", length = 500)
    private String fiGhiChu;
}
