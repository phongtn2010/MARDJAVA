package com.nsw.most.p02.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.annotations.*;
import com.nsw.util.CustomJsonDateDeserializer;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class TbdkqktHh2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdKqkthh;

    private String fiSoTb;

    private Date fiNgayKy;

    private String fiNoiKy;

    private String fiNguoiKy;

    private String fiCancuKt;
    
    private String     fiHqCuakhau    ;

    private Date fiNgaytao;

    private Long fiTrangthai;

    private String fiFileName;

    private String fiFileCode;

    private String fiFilePath;

    private String fiMahs;

    private Tbdhoso2 tbdhoso;

    private List<Tbdhanghoa2> lstTbdhanghoa2;

    public TbdkqktHh2() {
        super();
    }

    public TbdkqktHh2(Long fiIdKqkthh, String fiSoTb, Date fiNgayKy, String fiNoiKy, String fiNguoiKy, String fiCancuKt, String fiHqCuakhau, Date fiNgaytao, Long fiTrangthai, String fiFileName, String fiFileCode, String fiFilePath, String fiMahs, Tbdhoso2 tbdhoso) {
        this.fiIdKqkthh = fiIdKqkthh;
        this.fiSoTb = fiSoTb;
        this.fiNgayKy = fiNgayKy;
        this.fiNoiKy = fiNoiKy;
        this.fiNguoiKy = fiNguoiKy;
        this.fiCancuKt = fiCancuKt;
        this.fiHqCuakhau = fiHqCuakhau;
        this.fiNgaytao = fiNgaytao;
        this.fiTrangthai = fiTrangthai;
        this.fiFileName = fiFileName;
        this.fiFileCode = fiFileCode;
        this.fiFilePath = fiFilePath;
        this.fiMahs = fiMahs;
        this.tbdhoso = tbdhoso;
    }

    public void setFiIdKqkthh(Long fiIdKqkthh) {
        this.fiIdKqkthh = fiIdKqkthh;
    }

    public Long getFiIdKqkthh() {
        return this.fiIdKqkthh;
    }

    public void setFiSoTb(String fiSoTb) {
        this.fiSoTb = fiSoTb;
    }

    public String getFiSoTb() {
        return this.fiSoTb;
    }

    //--- DATABASE MAPPING : FI_NGAY_KY ( DATE ) 
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgayKy(Date fiNgayKy) {
        this.fiNgayKy = fiNgayKy;
    }

    public Date getFiNgayKy() {
        return this.fiNgayKy;
    }

    //--- DATABASE MAPPING : FI_NOI_KY ( VARCHAR2 ) 
    public void setFiNoiKy(String fiNoiKy) {
        this.fiNoiKy = fiNoiKy;
    }

    public String getFiNoiKy() {
        return this.fiNoiKy;
    }

    //--- DATABASE MAPPING : FI_NGUOI_KY ( VARCHAR2 ) 
    public void setFiNguoiKy(String fiNguoiKy) {
        this.fiNguoiKy = fiNguoiKy;
    }

    public String getFiNguoiKy() {
        return this.fiNguoiKy;
    }

    //--- DATABASE MAPPING : FI_CANCU_KT ( VARCHAR2 ) 
    public void setFiCancuKt(String fiCancuKt) {
        this.fiCancuKt = fiCancuKt;
    }

    public String getFiCancuKt() {
        return this.fiCancuKt;
    }

    public String getFiHqCuakhau() {
        return fiHqCuakhau;
    }

    public void setFiHqCuakhau(String fiHqCuakhau) {
        this.fiHqCuakhau = fiHqCuakhau;
    }
    
    //--- DATABASE MAPPING : FI_NGAYTAO ( DATE ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_TRANGTHAI ( NUMBER ) 
    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    //--- DATABASE MAPPING : FI_FILE_NAME ( VARCHAR2 ) 
    public void setFiFileName(String fiFileName) {
        this.fiFileName = fiFileName;
    }

    public String getFiFileName() {
        return this.fiFileName;
    }

    //--- DATABASE MAPPING : FI_FILE_CODE ( VARCHAR2 ) 
    public void setFiFileCode(String fiFileCode) {
        this.fiFileCode = fiFileCode;
    }

    public String getFiFileCode() {
        return this.fiFileCode;
    }

    //--- DATABASE MAPPING : FI_FILE_PATH ( VARCHAR2 ) 
    public void setFiFilePath(String fiFilePath) {
        this.fiFilePath = fiFilePath;
    }

    public String getFiFilePath() {
        return this.fiFilePath;
    }

    public String getFiMahs() {
        return fiMahs;
    }

    public void setFiMahs(String fiMahs) {
        this.fiMahs = fiMahs;
    }

    public Tbdhoso2 getTbdhoso() {
        return tbdhoso;
    }

    public void setTbdhoso(Tbdhoso2 tbdhoso) {
        this.tbdhoso = tbdhoso;
    }

    public List<Tbdhanghoa2> getLstTbdhanghoa2() {
        return lstTbdhanghoa2;
    }

    public void setLstTbdhanghoa2(List<Tbdhanghoa2> lstTbdhanghoa2) {
        this.lstTbdhanghoa2 = lstTbdhanghoa2;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdKqkthh);
        sb.append("]:");
        sb.append(fiSoTb);
        sb.append("|");
        sb.append(fiNgayKy);
        sb.append("|");
        sb.append(fiNoiKy);
        sb.append("|");
        sb.append(fiNguoiKy);
        sb.append("|");
        sb.append(fiCancuKt);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiFileName);
        sb.append("|");
        sb.append(fiFileCode);
        sb.append("|");
        sb.append(fiFilePath);
        return sb.toString();
    }

}
