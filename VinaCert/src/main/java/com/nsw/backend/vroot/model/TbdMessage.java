package com.nsw.backend.vroot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBD_MESSAGE")
public class TbdMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYNCHRONIZEMESSAGE_MA")
    @SequenceGenerator(sequenceName = "SYNCHRONIZEMESSAGE_MA", schema = "MARD", initialValue = 1, allocationSize = 1, name = "SYNCHRONIZEMESSAGE_MA")
    @Column(name = "FI_ID", nullable = false)
    private Long fiId;

    @Column(name = "FI_MAHOSO")
    private String fiMahoso;

    @Column(name = "FI_YEUCAU")
    private String fiYeucau;

    @Column(name = "FI_TRANGTHAI")
    private Long fiTrangthai;

    @Column(name = "FI_NGAYDONGBO")
    private Date fiNgaydongbo;

    @Column(name="FI_NGAYTAO")
    private Date fiNgayTao;

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiMahoso(String fiMahoso) {
        this.fiMahoso = fiMahoso;
    }

    public String getFiMahoso() {
        return fiMahoso;
    }

    public void setFiYeucau(String fiYeucau) {
        this.fiYeucau = fiYeucau;
    }

    public String getFiYeucau() {
        return fiYeucau;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiNgaydongbo(Date fiNgaydongbo) {
        this.fiNgaydongbo = fiNgaydongbo;
    }

    public Date getFiNgaydongbo() {
        return fiNgaydongbo;
    }

    public Date getFiNgayTao() {
        return fiNgayTao;
    }

    public void setFiNgayTao(Date fiNgayTao) {
        this.fiNgayTao = fiNgayTao;
    }

    @Override
    public String toString() {
        return "TbdMessage{" +
                "fiId=" + fiId + '\'' +
                "fiMahoso=" + fiMahoso + '\'' +
                "fiYeucau=" + fiYeucau + '\'' +
                "fiTrangthai=" + fiTrangthai + '\'' +
                "fiNgaydongbo=" + fiNgaydongbo + '\'' +
                '}';
    }
}
