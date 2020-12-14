/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.util.CustomJsonDateDeserializer;
import com.nsw.annotations.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"success"})
public class Tbdhoso6 extends AbstractEntity {

    @Mandatory
    @Maxlength(maxLength = 20)  
    @FieldName(name="fiSovanban")
    //@FilterXSS
    private String fiSovanban;
    
    @Mandatory
    @Maxlength(maxLength = 20)  
    @FieldName(name="fiMadv")
    private String fiMadv;
    
    @Mandatory
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiTendv")
    private String fiTendv;
    
    @Mandatory
    @Maxlength(maxLength = 20)  
    @FieldName(name="fiMst")
    //@FilterXSS
    private String fiMst;
    
    @Mandatory
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiTendn")
    //@FilterXSS
    private String fiTendn;
    
    @Mandatory
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiDiachidn")
    //@FilterXSS
    private String fiDiachidn;
    
    @Mandatory
    @Maxlength(maxLength = 10)  
    @FieldName(name="fiMatinh")
    private String fiMatinh;
    
    @Mandatory
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiTentinh")
    private String fiTentinh;
    
    @Mandatory
    @Maxlength(maxLength = 10)  
    @FieldName(name="fiMaquanhuyen")
    private String fiMaquanhuyen;
    
    @Mandatory
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiTenquanhuyen")
    private String fiTenquanhuyen;
    
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiLoaihinhdn")
    private String fiLoaihinhdn;
    
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiPhongbanquanly")
    private String fiPhongbanquanly;
    
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiTentienganhdn")
    private String fiTentienganhdn;
    
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiTenviettatdn")
    private String fiTenviettatdn;
    
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiSodkkd")
    private String fiSodkkd;
    
    @Maxlength(maxLength = 10)  
    @FieldName(name="fiNamthanhlap")
    private Long fiNamthanhlap;
    
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiWebsite")
    private String fiWebsite;
    
    @Mandatory
    @Maxlength(maxLength = 50)  
    @FieldName(name="fiSodtdn")
    //@FilterXSS
    private String fiSodtdn;
    
    @Mandatory
    @Maxlength(maxLength = 50)  
    @FieldName(name="fiFaxdn")
    //@FilterXSS
    private String fiFaxdn;
    
    @Mandatory
    @Maxlength(maxLength = 50)  
    @FieldName(name="fiEmaildn")
    //@FilterXSS
    private String fiEmaildn;
    
    @Mandatory
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiTennguoidaidien")
    //@FilterXSS
    private String fiTennguoidaidien;
    
    @Mandatory
    @Maxlength(maxLength = 50)  
    @FieldName(name="fiCmnd")
    //@FilterXSS
    private String fiCmnd;
    
    @Mandatory
    @FieldName(name="fiNgaycap")
    private Date fiNgaycap;
    
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiNoicap")
    //@FilterXSS
    private String fiNoicap;
    
    @Maxlength(maxLength = 50)  
    @FieldName(name="fiDienthoaicd")
    //@FilterXSS
    private String fiDienthoaicd;
    
    @Maxlength(maxLength = 50)  
    @FieldName(name="fiDienthoaidd")
    //@FilterXSS
    private String fiDienthoaidd;    
    
    private Long fiHoatdong;

    private Date fiNgaygui;
    
    @Mandatory
    @Maxlength(maxLength = 50)  
    @FieldName(name="fiTrangthai")
    private Long fiTrangthai;
    
    @Mandatory
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiTentrangthai")
    private String fiTentrangthai;

    private Long fiIdHoso;
    @Mandatory
    @Maxlength(maxLength = 50)  
    @FieldName(name="fiMaHoso")
    private String fiMaHoso;
    
    @Mandatory
    @Maxlength(maxLength = 250)  
    @FieldName(name="fiNguoitao")
    private String fiNguoitao;
    
    private Date fiNgaytao;
    private List<Tbdthanhtoan> listOfTbdthanhtoan;

    private List<Tbdketqua> listOfTbdketqua;

    private List<Tbdbaohanh> listOfTbdbaohanh;

    private Tbdthietbi thietBi;

    private List<Tbdtaptin> taptinList;

    public Tbdhoso6() {
        super();
    }

    public Tbdhoso6(String fiSovanban, String fiMadv, String fiTendv, String fiMst, String fiTendn, String fiDiachidn, String fiMatinh, String fiTentinh, String fiMaquanhuyen, String fiTenquanhuyen, String fiLoaihinhdn, String fiPhongbanquanly, String fiTentienganhdn, String fiTenviettatdn, String fiSodkkd, Long fiNamthanhlap, String fiWebsite, String fiSodtdn, String fiFaxdn, String fiEmaildn, String fiTennguoidaidien, String fiCmnd, Date fiNgaycap, String fiNoicap, String fiDienthoaicd, String fiDienthoaidd, Long fiHoatdong, Date fiNgaygui, Long fiTrangthai, String fiTentrangthai, Long fiIdHoso, String fiMaHoso, String fiNguoitao, Date fiNgaytao, List<Tbdthanhtoan> listOfTbdthanhtoan, List<Tbdketqua> listOfTbdketqua, List<Tbdbaohanh> listOfTbdbaohanh, Tbdthietbi thietBi, List<Tbdtaptin> taptinList) {
        this.fiSovanban = fiSovanban;
        this.fiMadv = fiMadv;
        this.fiTendv = fiTendv;
        this.fiMst = fiMst;
        this.fiTendn = fiTendn;
        this.fiDiachidn = fiDiachidn;
        this.fiMatinh = fiMatinh;
        this.fiTentinh = fiTentinh;
        this.fiMaquanhuyen = fiMaquanhuyen;
        this.fiTenquanhuyen = fiTenquanhuyen;
        this.fiLoaihinhdn = fiLoaihinhdn;
        this.fiPhongbanquanly = fiPhongbanquanly;
        this.fiTentienganhdn = fiTentienganhdn;
        this.fiTenviettatdn = fiTenviettatdn;
        this.fiSodkkd = fiSodkkd;
        this.fiNamthanhlap = fiNamthanhlap;
        this.fiWebsite = fiWebsite;
        this.fiSodtdn = fiSodtdn;
        this.fiFaxdn = fiFaxdn;
        this.fiEmaildn = fiEmaildn;
        this.fiTennguoidaidien = fiTennguoidaidien;
        this.fiCmnd = fiCmnd;
        this.fiNgaycap = fiNgaycap;
        this.fiNoicap = fiNoicap;
        this.fiDienthoaicd = fiDienthoaicd;
        this.fiDienthoaidd = fiDienthoaidd;
        this.fiHoatdong = fiHoatdong;
        this.fiNgaygui = fiNgaygui;
        this.fiTrangthai = fiTrangthai;
        this.fiTentrangthai = fiTentrangthai;
        this.fiIdHoso = fiIdHoso;
        this.fiMaHoso = fiMaHoso;
        this.fiNguoitao = fiNguoitao;
        this.fiNgaytao = fiNgaytao;
        this.listOfTbdthanhtoan = listOfTbdthanhtoan;
        this.listOfTbdketqua = listOfTbdketqua;
        this.listOfTbdbaohanh = listOfTbdbaohanh;
        this.thietBi = thietBi;
        this.taptinList = taptinList;
    }

    
    
    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }
    
    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public List<Tbdthanhtoan> getListOfTbdthanhtoan() {
        return listOfTbdthanhtoan;
    }

    public void setListOfTbdthanhtoan(List<Tbdthanhtoan> listOfTbdthanhtoan) {
        this.listOfTbdthanhtoan = listOfTbdthanhtoan;
    }

    public List<Tbdketqua> getListOfTbdketqua() {
        return listOfTbdketqua;
    }

    public void setListOfTbdketqua(List<Tbdketqua> listOfTbdketqua) {
        this.listOfTbdketqua = listOfTbdketqua;
    }

    public List<Tbdbaohanh> getListOfTbdbaohanh() {
        return listOfTbdbaohanh;
    }

    public void setListOfTbdbaohanh(List<Tbdbaohanh> listOfTbdbaohanh) {
        this.listOfTbdbaohanh = listOfTbdbaohanh;
    }

    public Tbdthietbi getThietBi() {
        return thietBi;
    }

    public void setThietBi(Tbdthietbi thietBi) {
        this.thietBi = thietBi;
    }

    public List<Tbdtaptin> getTaptinList() {
        return taptinList;
    }

    public void setTaptinList(List<Tbdtaptin> taptinList) {
        this.taptinList = taptinList;
    }

    public void setFiSovanban(String fiSovanban) {
        this.fiSovanban = fiSovanban;
    }

    public String getFiSovanban() {
        return this.fiSovanban;
    }

    public void setFiMadv(String fiMadv) {
        this.fiMadv = fiMadv;
    }

    public String getFiMadv() {
        return this.fiMadv;
    }

    public void setFiTendv(String fiTendv) {
        this.fiTendv = fiTendv;
    }

    public String getFiTendv() {
        return this.fiTendv;
    }

    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

    public String getFiMst() {
        return this.fiMst;
    }

    public void setFiTendn(String fiTendn) {
        this.fiTendn = fiTendn;
    }

    public String getFiTendn() {
        return this.fiTendn;
    }

    public void setFiDiachidn(String fiDiachidn) {
        this.fiDiachidn = fiDiachidn;
    }

    public String getFiDiachidn() {
        return this.fiDiachidn;
    }

    public void setFiMatinh(String fiMatinh) {
        this.fiMatinh = fiMatinh;
    }

    public String getFiMatinh() {
        return this.fiMatinh;
    }

    public void setFiTentinh(String fiTentinh) {
        this.fiTentinh = fiTentinh;
    }

    public String getFiTentinh() {
        return this.fiTentinh;
    }

    public void setFiMaquanhuyen(String fiMaquanhuyen) {
        this.fiMaquanhuyen = fiMaquanhuyen;
    }

    public String getFiMaquanhuyen() {
        return this.fiMaquanhuyen;
    }

    public void setFiTenquanhuyen(String fiTenquanhuyen) {
        this.fiTenquanhuyen = fiTenquanhuyen;
    }

    public String getFiTenquanhuyen() {
        return this.fiTenquanhuyen;
    }

    public void setFiLoaihinhdn(String fiLoaihinhdn) {
        this.fiLoaihinhdn = fiLoaihinhdn;
    }

    public String getFiLoaihinhdn() {
        return this.fiLoaihinhdn;
    }

    public void setFiPhongbanquanly(String fiPhongbanquanly) {
        this.fiPhongbanquanly = fiPhongbanquanly;
    }

    public String getFiPhongbanquanly() {
        return this.fiPhongbanquanly;
    }

    public void setFiTentienganhdn(String fiTentienganhdn) {
        this.fiTentienganhdn = fiTentienganhdn;
    }

    public String getFiTentienganhdn() {
        return this.fiTentienganhdn;
    }

    public void setFiTenviettatdn(String fiTenviettatdn) {
        this.fiTenviettatdn = fiTenviettatdn;
    }

    public String getFiTenviettatdn() {
        return this.fiTenviettatdn;
    }

    public void setFiSodkkd(String fiSodkkd) {
        this.fiSodkkd = fiSodkkd;
    }

    public String getFiSodkkd() {
        return this.fiSodkkd;
    }

    public void setFiNamthanhlap(Long fiNamthanhlap) {
        this.fiNamthanhlap = fiNamthanhlap;
    }

    public Long getFiNamthanhlap() {
        return this.fiNamthanhlap;
    }

    public void setFiWebsite(String fiWebsite) {
        this.fiWebsite = fiWebsite;
    }

    public String getFiWebsite() {
        return this.fiWebsite;
    }

    public void setFiSodtdn(String fiSodtdn) {
        this.fiSodtdn = fiSodtdn;
    }

    public String getFiSodtdn() {
        return this.fiSodtdn;
    }

    public void setFiFaxdn(String fiFaxdn) {
        this.fiFaxdn = fiFaxdn;
    }

    public String getFiFaxdn() {
        return this.fiFaxdn;
    }

    public void setFiEmaildn(String fiEmaildn) {
        this.fiEmaildn = fiEmaildn;
    }

    public String getFiEmaildn() {
        return this.fiEmaildn;
    }

    public void setFiTennguoidaidien(String fiTennguoidaidien) {
        this.fiTennguoidaidien = fiTennguoidaidien;
    }

    public String getFiTennguoidaidien() {
        return this.fiTennguoidaidien;
    }

    public void setFiCmnd(String fiCmnd) {
        this.fiCmnd = fiCmnd;
    }

    public String getFiCmnd() {
        return this.fiCmnd;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaycap(Date fiNgaycap) {
        this.fiNgaycap = fiNgaycap;
    }

    public Date getFiNgaycap() {
        return this.fiNgaycap;
    }

    public void setFiNoicap(String fiNoicap) {
        this.fiNoicap = fiNoicap;
    }

    public String getFiNoicap() {
        return this.fiNoicap;
    }

    public void setFiDienthoaicd(String fiDienthoaicd) {
        this.fiDienthoaicd = fiDienthoaicd;
    }

    public String getFiDienthoaicd() {
        return this.fiDienthoaicd;
    }

    public void setFiDienthoaidd(String fiDienthoaidd) {
        this.fiDienthoaidd = fiDienthoaidd;
    }

    public String getFiDienthoaidd() {
        return this.fiDienthoaidd;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    public Date getFiNgaygui() {
        return this.fiNgaygui;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public void setFiTentrangthai(String fiTentrangthai) {
        this.fiTentrangthai = fiTentrangthai;
    }

    public String getFiTentrangthai() {
        return this.fiTentrangthai;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("]:");
        sb.append(fiSovanban);
        sb.append("|");
        sb.append(fiMadv);
        sb.append("|");
        sb.append(fiTendv);
        sb.append("|");
        sb.append(fiMst);
        sb.append("|");
        sb.append(fiTendn);
        sb.append("|");
        sb.append(fiDiachidn);
        sb.append("|");
        sb.append(fiMatinh);
        sb.append("|");
        sb.append(fiTentinh);
        sb.append("|");
        sb.append(fiMaquanhuyen);
        sb.append("|");
        sb.append(fiTenquanhuyen);
        sb.append("|");
        sb.append(fiLoaihinhdn);
        sb.append("|");
        sb.append(fiPhongbanquanly);
        sb.append("|");
        sb.append(fiTentienganhdn);
        sb.append("|");
        sb.append(fiTenviettatdn);
        sb.append("|");
        sb.append(fiSodkkd);
        sb.append("|");
        sb.append(fiNamthanhlap);
        sb.append("|");
        sb.append(fiWebsite);
        sb.append("|");
        sb.append(fiSodtdn);
        sb.append("|");
        sb.append(fiFaxdn);
        sb.append("|");
        sb.append(fiEmaildn);
        sb.append("|");
        sb.append(fiTennguoidaidien);
        sb.append("|");
        sb.append(fiCmnd);
        sb.append("|");
        sb.append(fiNgaycap);
        sb.append("|");
        sb.append(fiNoicap);
        sb.append("|");
        sb.append(fiDienthoaicd);
        sb.append("|");
        sb.append(fiDienthoaidd);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaygui);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiTentrangthai);
        sb.append("|");
        sb.append(fiIdHoso);
        return sb.toString();
    }

}
