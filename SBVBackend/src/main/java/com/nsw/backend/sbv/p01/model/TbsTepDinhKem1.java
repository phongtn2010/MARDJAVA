package com.nsw.backend.sbv.p01.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/***
 *
 *
 * @Entity
 * @class TbsTepDinhKem1
 * Created by Nguyen Van Quang
 * 29/10/2018 13:00:07
 *
 */
@Entity
@Table(name = "TBSTEPDINHKEM1")
public class TbsTepDinhKem1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FI_TEPDINHKEMID")
    private Long tepDinhKemId;

    @Column(name = "FI_TENTEP")
    private String tenTep;

    @Column(name = "FI_LOAITEP")
    private String loaiTep;

    @Column(name = "FI_LOAITHUTUC")
    private String loaiThuTuc;

    @Column(name = "FI_REQUIRED")
    private Boolean required;

    @Column(name = "FI_ORDER")
    private Integer order;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Column(name = "FI_MALOAITEP")
    private Integer maLoaiTep;

    public Integer getMaLoaiTep() {
        return maLoaiTep;
    }

    public void setMaLoaiTep(Integer maLoaiTep) {
        this.maLoaiTep = maLoaiTep;
    }

    public Long getTepDinhKemId() {

        return this.tepDinhKemId;
    }

    public void setTepDinhKemId(Long tepDinhKemId) {

        this.tepDinhKemId = tepDinhKemId;
    }

    public String getTenTep() {

        return this.tenTep;
    }

    public void setTenTep(String tenTep) {

        this.tenTep = tenTep;
    }

    public String getLoaiTep() {

        return this.loaiTep;
    }

    public void setLoaiTep(String loaiTep) {

        this.loaiTep = loaiTep;
    }

    public String getLoaiThuTuc() {

        return this.loaiThuTuc;
    }

    public void setLoaiThuTuc(String loaiThuTuc) {

        this.loaiThuTuc = loaiThuTuc;
    }

    public Boolean getRequired() {

        return this.required;
    }

    public void setRequired(Boolean required) {

        this.required = required;
    }

    @Override
    public String toString() {
        return "TbsTepDinhKem1 [" +
                "tepDinhKemId=" + tepDinhKemId + "," +
                "tenTep=" + tenTep + "," +
                "loaiTep=" + loaiTep + "," +
                "loaiThuTuc=" + loaiThuTuc + "," +
                "required=" + required + "]";
    }
}