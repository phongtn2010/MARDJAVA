/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.annotations.*;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nhan
 */
public class Tbdthietbi {

    private Long fiId;
    
    @Mandatory
    @FieldName(name="fiTen")
    @Maxlength(maxLength = 200)
    @FilterXSS
    private String fiTen;
    
    @Mandatory
    @FieldName(name="fiLoai")
    private String fiLoai;
    
    @Mandatory
    @FieldName(name="fiQuycach")
    @Maxlength(maxLength = 200)
    @FilterXSS
    private String fiQuycach;
    
    @Maxlength(maxLength = 200)
    @FieldName(name="fiHangsx")
    @FilterXSS
    private String fiHangsx;
    
    @Mandatory
    @FieldName(name="fiNhieucssx")
    private Long fiNhieucssx;
    
    @Mandatory
    @FieldName(name="fiDiachisx")
    @Maxlength(maxLength = 200)
    @FilterXSS
    private String fiDiachisx;
    
    @Mandatory
    @FieldName(name="fiQgsx")
    private String fiQgsx;
    
    private String fiMaqgsx;
    private Date fiNgaytao;
    @Mandatory
    @FieldName(name="fiPhannhom")
    private String fiPhannhom;
    
    @Mandatory
    @FieldName(name="fiNhomtb")
    private String fiNhomtb;
    
    @Mandatory
    @FieldName(name="fiTentrangtb")
    @Maxlength(maxLength = 250)
    @FilterXSS
    private String fiTentrangtb;
    
    @Mandatory
    @FieldName(name="fiLoaitb")
    private String fiLoaitb;
    
    @Maxlength(maxLength = 250)
    @Mandatory
    @FieldName(name="fiChusohuu")
    @FilterXSS
    private String fiChusohuu;
    
    @Mandatory
    @FieldName(name="fiDiachicsh")
    @Maxlength(maxLength = 250)
    @FilterXSS
    private String fiDiachicsh;
    
    @Mandatory
    @FieldName(name="fiQuocgiacsh")
    private String fiQuocgiacsh;
    
    private String fiMaqgsch;
    
    @Mandatory
    @FieldName(name="fiTieuchuan")
    @Maxlength(maxLength = 250)
    @FilterXSS
    private String fiTieuchuan;
    
    private Long fiHosoid;
    
    private Tbdtaptin phuluc;

    public Tbdthietbi() {
    }

    public Tbdthietbi(Long fiId, String fiTen, String fiLoai, String fiQuycach, String fiHangsx, Long fiNhieucssx, String fiDiachisx, String fiQgsx, String fiMaqgsx, Date fiNgaytao, String fiPhannhom, String fiNhomtb, String fiTentrangtb, String fiLoaitb, String fiChusohuu, String fiDiachicsh, String fiQuocgiacsh, String fiMaqgsch, String fiTieuchuan, Long fiHosoid, Tbdtaptin phuluc) {
        this.fiId = fiId;
        this.fiTen = fiTen;
        this.fiLoai = fiLoai;
        this.fiQuycach = fiQuycach;
        this.fiHangsx = fiHangsx;
        this.fiNhieucssx = fiNhieucssx;
        this.fiDiachisx = fiDiachisx;
        this.fiQgsx = fiQgsx;
        this.fiMaqgsx = fiMaqgsx;
        this.fiNgaytao = fiNgaytao;
        this.fiPhannhom = fiPhannhom;
        this.fiNhomtb = fiNhomtb;
        this.fiTentrangtb = fiTentrangtb;
        this.fiLoaitb = fiLoaitb;
        this.fiChusohuu = fiChusohuu;
        this.fiDiachicsh = fiDiachicsh;
        this.fiQuocgiacsh = fiQuocgiacsh;
        this.fiMaqgsch = fiMaqgsch;
        this.fiTieuchuan = fiTieuchuan;
        this.fiHosoid = fiHosoid;
        this.phuluc = phuluc;
    }

    public String getFiMaqgsch() {
        return fiMaqgsch;
    }

    public void setFiMaqgsch(String fiMaqgsch) {
        this.fiMaqgsch = fiMaqgsch;
    }
    
    public Tbdtaptin getPhuluc() {
        return phuluc;
    }

    public void setPhuluc(Tbdtaptin phuluc) {
        this.phuluc = phuluc;
    }

    

    public Long getFiHosoid() {
        return fiHosoid;
    }

    public void setFiHosoid(Long fiHosoid) {
        this.fiHosoid = fiHosoid;
    }
    

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }


    public String getFiTen() {
        return fiTen;
    }

    public void setFiTen(String fiTen) {
        this.fiTen = fiTen;
    }

    public String getFiLoai() {
        return fiLoai;
    }

    public void setFiLoai(String fiLoai) {
        this.fiLoai = fiLoai;
    }

    public String getFiQuycach() {
        return fiQuycach;
    }

    public void setFiQuycach(String fiQuycach) {
        this.fiQuycach = fiQuycach;
    }

    public String getFiHangsx() {
        return fiHangsx;
    }

    public void setFiHangsx(String fiHangsx) {
        this.fiHangsx = fiHangsx;
    }

    public Long getFiNhieucssx() {
        return fiNhieucssx;
    }

    public void setFiNhieucssx(Long fiNhieucssx) {
        this.fiNhieucssx = fiNhieucssx;
    }

    public String getFiDiachisx() {
        return fiDiachisx;
    }

    public void setFiDiachisx(String fiDiachisx) {
        this.fiDiachisx = fiDiachisx;
    }

    public String getFiQgsx() {
        return fiQgsx;
    }

    public void setFiQgsx(String fiQgsx) {
        this.fiQgsx = fiQgsx;
    }

    public String getFiMaqgsx() {
        return fiMaqgsx;
    }

    public void setFiMaqgsx(String fiMaqgsx) {
        this.fiMaqgsx = fiMaqgsx;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public String getFiTentrangtb() {
        return fiTentrangtb;
    }

    public void setFiTentrangtb(String fiTentrangtb) {
        this.fiTentrangtb = fiTentrangtb;
    }

    public String getFiLoaitb() {
        return fiLoaitb;
    }

    public void setFiLoaitb(String fiLoaitb) {
        this.fiLoaitb = fiLoaitb;
    }

    public String getFiChusohuu() {
        return fiChusohuu;
    }

    public void setFiChusohuu(String fiChusohuu) {
        this.fiChusohuu = fiChusohuu;
    }

    public String getFiDiachicsh() {
        return fiDiachicsh;
    }

    public void setFiDiachicsh(String fiDiachicsh) {
        this.fiDiachicsh = fiDiachicsh;
    }

    public String getFiQuocgiacsh() {
        return fiQuocgiacsh;
    }

    public void setFiQuocgiacsh(String fiQuocgiacsh) {
        this.fiQuocgiacsh = fiQuocgiacsh;
    }

    public String getFiTieuchuan() {
        return fiTieuchuan;
    }

    public void setFiTieuchuan(String fiTieuchuan) {
        this.fiTieuchuan = fiTieuchuan;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public String getFiPhannhom() {
        return fiPhannhom;
    }

    public void setFiPhannhom(String fiPhannhom) {
        this.fiPhannhom = fiPhannhom;
    }

    public String getFiNhomtb() {
        return fiNhomtb;
    }

    public void setFiNhomtb(String fiNhomtb) {
        this.fiNhomtb = fiNhomtb;
    }

}
