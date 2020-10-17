/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.send;

import com.vnsw.ws.p11.entity.db.Tbdhhgcn11;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "PhytosanitaryCerInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhytosanitaryCerInfo {
    @XmlTransient
    private Long fiIdGcn;
    
    @XmlTransient
    private Long fiIdHoso;
    
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "TypeCer")
    private Long fiLoaiCt;
    
    @XmlElement(name = "CountryExportName")
    private String fiTennuocXk;
    
    @XmlElement(name = "CountryExportCode")
    private String fiManuocXk;
    
    @XmlElement(name = "CountryTransitName")
    private String fiTennuocQc;
    
    @XmlElement(name = "CountryTransitCode")
    private String fiManuocQc;
    
    @XmlElement(name = "DispatchNo")
    private String fiSoGcn;
    
    @XmlElement(name = "ExporterName")
    private String fiNguoiXk;
    
    @XmlElement(name = "ExporterAddress")
    private String fiDiachiXk;
    
    @XmlElement(name = "ConsigneeName")
    private String fiTenNn;
    
    @XmlElement(name = "ConsigneeAddress")
    private String fiDiachiNn;
    
    @XmlElement(name = "TypeOfPackageName")
    private String fiTenbaobi;
    
    @XmlElement(name = "TypeOfPackageCode")
    private String fiMabaobi;
    
    @XmlElement(name = "QuantityDisplay")
    private String fiHienthi;
    
    @XmlElement(name = "LevelOfPackage")
    private Long fiQuycachDg;
    
    @XmlElement(name = "Marks")
    private String fiMakyhieu;
    
    @XmlElement(name = "NameOfProduce")
    private String fiTenNsx;
    
    @XmlElement(name = "NameOfOriginLocation")
    private String fiDiachiNsx;
    
    @XmlElement(name = "NameOfOriginCountry")
    private String fiTennuocSx;
    
    @XmlElement(name = "CodeOfOriginCountry")
    private String fiManuocSx;
    
    @XmlElement(name = "NameOfOriginDistric")
    private String fiTentinh;
    
    @XmlElement(name = "CodeOfOriginDistric")
    private String fiMatinh;
    
    @XmlElement(name = "ModeOfTransport")
    private Long fiHtcc;
    
    @XmlElement(name = "NameOfMeanTransport")
    private String fiPtcc;
    
    @XmlElement(name = "TransportNumber")
    private String fiSohieuPt;
    
    @XmlElement(name = "EntryPoint")
    private String fiCkNhap;
    
    @XmlElementWrapper(name = "ProductList")
    @XmlElement(name = "Product")
    private List<Tbdhhgcn11> tbdhhgcn11;
    
    @XmlElement(name = "TotalNetWeight")
    private Long fiTongkltinh;
    
    @XmlElement(name = "TotalNetWeightUnitCode")
    private String fiMadvKl;
    
    @XmlElement(name = "TotalNetWeightUnitName")
    private String fiTendvKl;
    
    @XmlElement(name = "TotalNetWeightDisplay")
    private String fiHienthiKl;

    @XmlElement(name = "TotalGrossWeight")
    private Long fiTongklbi;
    
    @XmlElement(name = "TotalGrossWeightUnitCode")
    private String fiMadvBi;
    
    @XmlElement(name = "TotalGrossWeightUnitName")
    private String fiTendvBi;
    
    @XmlElement(name = "TotalGrossWeightDisplay")
    private String fiHienthiBi;
    
    @XmlElement(name = "FromCountry")
    private String fiTunuoc;
    
    @XmlElement(name = "PhytoCerNo")
    private String fiSocnkdtv;
    
    @XmlElement(name = "Original")
    private Long fiBangoc;
    
    @XmlElement(name = "Copy")
    private Long fiBansao;
    
    @XmlElement(name = "Packed")
    private Long fiDadonggoi;
    
    @XmlElement(name = "Repacked")
    private Long fiDagoilai;
    
    @XmlElement(name = "InOriginal")
    private Long fiGiunguyengoc;
    
    @XmlElement(name = "NewContainer")
    private Long fiBaobimoi;
    
    @XmlElement(name = "BasedOnOriPhytoCer")
    private Long fiTrencsGoc;
    
    @XmlElement(name = "AddInspection")
    private Long fiKtBosung;
    
    @XmlElement(name = "AddDeclaration")
    private String fiKbBosung;
    
    @XmlElement(name = "Date")
    private String fiNgay;
    
    @XmlElement(name = "TreatmentCode")
    private Long fiMaPpxl;
    
    @XmlElement(name = "TreatmentName")
    private String fiTenPpxl;
    
    @XmlElement(name = "Chemical")
    private String fiTenthuoc;
    
    @XmlElement(name = "Concentration")
    private String fiNongdo;
    
    @XmlElement(name = "Duration")
    private String fiTgNd;
    
    @XmlElement(name = "Information")
    private String fiTtThem;
    
    @XmlElement(name = "PlaceOfIssue")
    private String fiNoicapgiay;
    
    @XmlElement(name = "DateIssue")
    private String fiNgaycap;
    
    @XmlElement(name = "NameOfLocation")
    private String fiChucvuCb;
    
    @XmlElement(name = "NameOfOfficer")
    private String fiTenCb;
    
    @XmlElement(name = "ReasonEdit")
    private String fiLydosua;
    
    @XmlTransient
    private Long fiHoatdong;
    
    @XmlTransient
    private Date fiNgaytao;
    
    @XmlTransient
    private Date fiNgayCn;
    
    @XmlElement(name = "QuantityOfPackage")
    private Long fiSoluong;
    
    

    public PhytosanitaryCerInfo() {
    }

    public Long getFiIdGcn() {
        return fiIdGcn;
    }

    public void setFiIdGcn(Long fiIdGcn) {
        this.fiIdGcn = fiIdGcn;
    }

    

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Long getFiLoaiCt() {
        return fiLoaiCt;
    }

    public void setFiLoaiCt(Long fiLoaiCt) {
        this.fiLoaiCt = fiLoaiCt;
    }

    public String getFiTennuocXk() {
        return fiTennuocXk;
    }

    public void setFiTennuocXk(String fiTennuocXk) {
        this.fiTennuocXk = fiTennuocXk;
    }

    public String getFiManuocXk() {
        return fiManuocXk;
    }

    public void setFiManuocXk(String fiManuocXk) {
        this.fiManuocXk = fiManuocXk;
    }

    public String getFiTennuocQc() {
        return fiTennuocQc;
    }

    public void setFiTennuocQc(String fiTennuocQc) {
        this.fiTennuocQc = fiTennuocQc;
    }

    public String getFiManuocQc() {
        return fiManuocQc;
    }

    public void setFiManuocQc(String fiManuocQc) {
        this.fiManuocQc = fiManuocQc;
    }

    public String getFiSoGcn() {
        return fiSoGcn;
    }

    public void setFiSoGcn(String fiSoGcn) {
        this.fiSoGcn = fiSoGcn;
    }

    public String getFiNguoiXk() {
        return fiNguoiXk;
    }

    public void setFiNguoiXk(String fiNguoiXk) {
        this.fiNguoiXk = fiNguoiXk;
    }

    public String getFiDiachiXk() {
        return fiDiachiXk;
    }

    public void setFiDiachiXk(String fiDiachiXk) {
        this.fiDiachiXk = fiDiachiXk;
    }

    public String getFiTenNn() {
        return fiTenNn;
    }

    public void setFiTenNn(String fiTenNn) {
        this.fiTenNn = fiTenNn;
    }

    public String getFiDiachiNn() {
        return fiDiachiNn;
    }

    public void setFiDiachiNn(String fiDiachiNn) {
        this.fiDiachiNn = fiDiachiNn;
    }

    public String getFiTenbaobi() {
        return fiTenbaobi;
    }

    public void setFiTenbaobi(String fiTenbaobi) {
        this.fiTenbaobi = fiTenbaobi;
    }

    public String getFiMabaobi() {
        return fiMabaobi;
    }

    public void setFiMabaobi(String fiMabaobi) {
        this.fiMabaobi = fiMabaobi;
    }

    public String getFiHienthi() {
        return fiHienthi;
    }

    public void setFiHienthi(String fiHienthi) {
        this.fiHienthi = fiHienthi;
    }

    public Long getFiQuycachDg() {
        return fiQuycachDg;
    }

    public void setFiQuycachDg(Long fiQuycachDg) {
        this.fiQuycachDg = fiQuycachDg;
    }

    public String getFiMakyhieu() {
        return fiMakyhieu;
    }

    public void setFiMakyhieu(String fiMakyhieu) {
        this.fiMakyhieu = fiMakyhieu;
    }

    public String getFiTenNsx() {
        return fiTenNsx;
    }

    public void setFiTenNsx(String fiTenNsx) {
        this.fiTenNsx = fiTenNsx;
    }

    public String getFiDiachiNsx() {
        return fiDiachiNsx;
    }

    public void setFiDiachiNsx(String fiDiachiNsx) {
        this.fiDiachiNsx = fiDiachiNsx;
    }

    public String getFiTennuocSx() {
        return fiTennuocSx;
    }

    public void setFiTennuocSx(String fiTennuocSx) {
        this.fiTennuocSx = fiTennuocSx;
    }

    public String getFiManuocSx() {
        return fiManuocSx;
    }

    public void setFiManuocSx(String fiManuocSx) {
        this.fiManuocSx = fiManuocSx;
    }

    public String getFiTentinh() {
        return fiTentinh;
    }

    public void setFiTentinh(String fiTentinh) {
        this.fiTentinh = fiTentinh;
    }

    public String getFiMatinh() {
        return fiMatinh;
    }

    public void setFiMatinh(String fiMatinh) {
        this.fiMatinh = fiMatinh;
    }

    public Long getFiHtcc() {
        return fiHtcc;
    }

    public void setFiHtcc(Long fiHtcc) {
        this.fiHtcc = fiHtcc;
    }

    public String getFiPtcc() {
        return fiPtcc;
    }

    public void setFiPtcc(String fiPtcc) {
        this.fiPtcc = fiPtcc;
    }

    public String getFiSohieuPt() {
        return fiSohieuPt;
    }

    public void setFiSohieuPt(String fiSohieuPt) {
        this.fiSohieuPt = fiSohieuPt;
    }

    public String getFiCkNhap() {
        return fiCkNhap;
    }

    public void setFiCkNhap(String fiCkNhap) {
        this.fiCkNhap = fiCkNhap;
    }

    public Long getFiTongklbi() {
        return fiTongklbi;
    }

    public void setFiTongklbi(Long fiTongklbi) {
        this.fiTongklbi = fiTongklbi;
    }

    public String getFiMadvKl() {
        return fiMadvKl;
    }

    public void setFiMadvKl(String fiMadvKl) {
        this.fiMadvKl = fiMadvKl;
    }

    public String getFiTendvKl() {
        return fiTendvKl;
    }

    public void setFiTendvKl(String fiTendvKl) {
        this.fiTendvKl = fiTendvKl;
    }

    public String getFiHienthiKl() {
        return fiHienthiKl;
    }

    public void setFiHienthiKl(String fiHienthiKl) {
        this.fiHienthiKl = fiHienthiKl;
    }

    public Long getFiTongkltinh() {
        return fiTongkltinh;
    }

    public void setFiTongkltinh(Long fiTongkltinh) {
        this.fiTongkltinh = fiTongkltinh;
    }

    public String getFiMadvBi() {
        return fiMadvBi;
    }

    public void setFiMadvBi(String fiMadvBi) {
        this.fiMadvBi = fiMadvBi;
    }

    public String getFiTendvBi() {
        return fiTendvBi;
    }

    public void setFiTendvBi(String fiTendvBi) {
        this.fiTendvBi = fiTendvBi;
    }

    public String getFiHienthiBi() {
        return fiHienthiBi;
    }

    public void setFiHienthiBi(String fiHienthiBi) {
        this.fiHienthiBi = fiHienthiBi;
    }

    public String getFiTunuoc() {
        return fiTunuoc;
    }

    public void setFiTunuoc(String fiTunuoc) {
        this.fiTunuoc = fiTunuoc;
    }

    public String getFiSocnkdtv() {
        return fiSocnkdtv;
    }

    public void setFiSocnkdtv(String fiSocnkdtv) {
        this.fiSocnkdtv = fiSocnkdtv;
    }

    public Long getFiBangoc() {
        return fiBangoc;
    }

    public void setFiBangoc(Long fiBangoc) {
        this.fiBangoc = fiBangoc;
    }

    public Long getFiBansao() {
        return fiBansao;
    }

    public void setFiBansao(Long fiBansao) {
        this.fiBansao = fiBansao;
    }

    public Long getFiDadonggoi() {
        return fiDadonggoi;
    }

    public void setFiDadonggoi(Long fiDadonggoi) {
        this.fiDadonggoi = fiDadonggoi;
    }

    public Long getFiDagoilai() {
        return fiDagoilai;
    }

    public void setFiDagoilai(Long fiDagoilai) {
        this.fiDagoilai = fiDagoilai;
    }

    public Long getFiGiunguyengoc() {
        return fiGiunguyengoc;
    }

    public void setFiGiunguyengoc(Long fiGiunguyengoc) {
        this.fiGiunguyengoc = fiGiunguyengoc;
    }

    public Long getFiBaobimoi() {
        return fiBaobimoi;
    }

    public void setFiBaobimoi(Long fiBaobimoi) {
        this.fiBaobimoi = fiBaobimoi;
    }

    public Long getFiTrencsGoc() {
        return fiTrencsGoc;
    }

    public void setFiTrencsGoc(Long fiTrencsGoc) {
        this.fiTrencsGoc = fiTrencsGoc;
    }

    public Long getFiKtBosung() {
        return fiKtBosung;
    }

    public void setFiKtBosung(Long fiKtBosung) {
        this.fiKtBosung = fiKtBosung;
    }

    public String getFiKbBosung() {
        return fiKbBosung;
    }

    public void setFiKbBosung(String fiKbBosung) {
        this.fiKbBosung = fiKbBosung;
    }

    public String getFiNgay() {
        return fiNgay;
    }

    public void setFiNgay(String fiNgay) {
        this.fiNgay = fiNgay;
    }

    public Long getFiMaPpxl() {
        return fiMaPpxl;
    }

    public void setFiMaPpxl(Long fiMaPpxl) {
        this.fiMaPpxl = fiMaPpxl;
    }

    public String getFiTenPpxl() {
        return fiTenPpxl;
    }

    public void setFiTenPpxl(String fiTenPpxl) {
        this.fiTenPpxl = fiTenPpxl;
    }

    public String getFiTenthuoc() {
        return fiTenthuoc;
    }

    public void setFiTenthuoc(String fiTenthuoc) {
        this.fiTenthuoc = fiTenthuoc;
    }

    public String getFiNongdo() {
        return fiNongdo;
    }

    public void setFiNongdo(String fiNongdo) {
        this.fiNongdo = fiNongdo;
    }

    public String getFiTgNd() {
        return fiTgNd;
    }

    public void setFiTgNd(String fiTgNd) {
        this.fiTgNd = fiTgNd;
    }

    public String getFiTtThem() {
        return fiTtThem;
    }

    public void setFiTtThem(String fiTtThem) {
        this.fiTtThem = fiTtThem;
    }

    public String getFiNoicapgiay() {
        return fiNoicapgiay;
    }

    public void setFiNoicapgiay(String fiNoicapgiay) {
        this.fiNoicapgiay = fiNoicapgiay;
    }

    public String getFiNgaycap() {
        return fiNgaycap;
    }

    public void setFiNgaycap(String fiNgaycap) {
        this.fiNgaycap = fiNgaycap;
    }

    public String getFiChucvuCb() {
        return fiChucvuCb;
    }

    public void setFiChucvuCb(String fiChucvuCb) {
        this.fiChucvuCb = fiChucvuCb;
    }

    public String getFiTenCb() {
        return fiTenCb;
    }

    public void setFiTenCb(String fiTenCb) {
        this.fiTenCb = fiTenCb;
    }

    public String getFiLydosua() {
        return fiLydosua;
    }

    public void setFiLydosua(String fiLydosua) {
        this.fiLydosua = fiLydosua;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgayCn() {
        return fiNgayCn;
    }

    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }


    public Long getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(Long fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public List<Tbdhhgcn11> getTbdhhgcn11() {
        return tbdhhgcn11;
    }

    public void setTbdhhgcn11(List<Tbdhhgcn11> tbdhhgcn11) {
        this.tbdhhgcn11 = tbdhhgcn11;
    }
    
}
