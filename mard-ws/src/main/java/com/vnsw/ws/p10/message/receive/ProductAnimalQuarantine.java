/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductAnimalQuarantine")
public class ProductAnimalQuarantine {
    @XmlElement(name = "ReasonEdit")
    private String fiLydoSua;
    
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "UnitProcessing")
    private String fiTenCqkddv;
    
    @XmlElement(name = "DispatchNo")
    private String fiSocv;
    
    @XmlElement(name = "NameOfRegistration")
    private String fiTenCh;
    
    @XmlElement(name = "AddressOfRegistration")
    private String fiDiachiCh;
    
    @XmlElement(name = "Tel")
    private String fiDtCh;
    
    @XmlElement(name = "Fax")
    private String fiFaxCh;
    
    @XmlElement(name = "Email")
    private String fiEmailCh;
    
    @XmlElement(name = "BillofLading")
    private String fiSovandon;
    
    @XmlElement(name = "CustomsDecNo")
    private String fiSotokhai;
    
    @XmlElementWrapper(name = "ProductList")
    @XmlElement(name = "Product")
    private List<Product15B> product;
    
    @XmlElement(name = "TotalQuantity")
    private BigDecimal fiTongSl;
    
    @XmlElement(name = "TotalWeight")
    private BigDecimal fiTongTl;
    
    @XmlElement(name = "TotalChar")
    private String fiNdTongso;
    
    @XmlElement(name = "Exporter")
    private String fiDtXk;
    
    @XmlElement(name = "ProductFrom")
    private String fiNoiSx;
    
    @XmlElement(name = "ExporterStateName")
    private String fiTenqgXk;
    
    @XmlElement(name = "ExporterStateCode")
    private String fiMaqgXk;
    
    @XmlElement(name = "TransitStateName")
    private String fiQgQc;
    
    @XmlElement(name = "PortOfDestinationName")
    private String fiTenckNhap;
    
    @XmlElement(name = "PortOfDestinationCode")
    private String fiMackNhap;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfDestination")
    private Date fiTgNhap;
    
    @XmlElement(name = "Destination")
    private String fiNoichuyen;
    
    @XmlElement(name = "Tool")
    private String fiVdLq;
    
    @XmlElement(name = "File")
    private String fiHosoLq;
    
    @XmlElement(name = "TransportType")
    private String fiPtVc;
    
    @XmlElement(name = "MethodsDisinfect")
    private String fiPptdkt;
    
    @XmlElement(name = "Concentrations")
    private String fiNongdo;
    
    @XmlElement(name = "MethodsDisinfectofTransport")
    private String fiPtvccv;
    
    @XmlElement(name = "ConcentrationsofTransport")
    private String fiNongdovc;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ValidToDate")
    private Date fiCachlyDn;
    
    @XmlElement(name = "Veterinaria")
    private String fiKddv;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayky;
    
    @XmlElement(name = "SignConfirmName")
    private String fiNguoiky;
    
    @XmlElement(name = "SignConfirmAddress")
    private String fiNoiky;

    public ProductAnimalQuarantine() {
    }

    public ProductAnimalQuarantine(String fiLydoSua, String fiMaHoso, String fiTenCqkddv, String fiSocv, String fiTenCh, String fiDiachiCh, String fiDtCh, String fiFaxCh, String fiEmailCh, String fiSovandon, String fiSotokhai, List<Product15B> product, BigDecimal fiTongSl, BigDecimal fiTongTl, String fiNdTongso, String fiDtXk, String fiNoiSx, String fiTenqgXk, String fiMaqgXk, String fiQgQc, String fiTenckNhap, String fiMackNhap, Date fiTgNhap, String fiNoichuyen, String fiVdLq, String fiHosoLq, String fiPtVc, String fiPptdkt, String fiNongdo, String fiPtvccv, String fiNongdovc, Date fiCachlyDn, String fiKddv, Date fiNgayky, String fiNguoiky, String fiNoiky) {
        this.fiLydoSua = fiLydoSua;
        this.fiMaHoso = fiMaHoso;
        this.fiTenCqkddv = fiTenCqkddv;
        this.fiSocv = fiSocv;
        this.fiTenCh = fiTenCh;
        this.fiDiachiCh = fiDiachiCh;
        this.fiDtCh = fiDtCh;
        this.fiFaxCh = fiFaxCh;
        this.fiEmailCh = fiEmailCh;
        this.fiSovandon = fiSovandon;
        this.fiSotokhai = fiSotokhai;
        this.product = product;
        this.fiTongSl = fiTongSl;
        this.fiTongTl = fiTongTl;
        this.fiNdTongso = fiNdTongso;
        this.fiDtXk = fiDtXk;
        this.fiNoiSx = fiNoiSx;
        this.fiTenqgXk = fiTenqgXk;
        this.fiMaqgXk = fiMaqgXk;
        this.fiQgQc = fiQgQc;
        this.fiTenckNhap = fiTenckNhap;
        this.fiMackNhap = fiMackNhap;
        this.fiTgNhap = fiTgNhap;
        this.fiNoichuyen = fiNoichuyen;
        this.fiVdLq = fiVdLq;
        this.fiHosoLq = fiHosoLq;
        this.fiPtVc = fiPtVc;
        this.fiPptdkt = fiPptdkt;
        this.fiNongdo = fiNongdo;
        this.fiPtvccv = fiPtvccv;
        this.fiNongdovc = fiNongdovc;
        this.fiCachlyDn = fiCachlyDn;
        this.fiKddv = fiKddv;
        this.fiNgayky = fiNgayky;
        this.fiNguoiky = fiNguoiky;
        this.fiNoiky = fiNoiky;
    }

    public String getFiLydoSua() {
        return fiLydoSua;
    }

    public void setFiLydoSua(String fiLydoSua) {
        this.fiLydoSua = fiLydoSua;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiTenCqkddv() {
        return fiTenCqkddv;
    }

    public void setFiTenCqkddv(String fiTenCqkddv) {
        this.fiTenCqkddv = fiTenCqkddv;
    }

    public String getFiSocv() {
        return fiSocv;
    }

    public void setFiSocv(String fiSocv) {
        this.fiSocv = fiSocv;
    }

    public String getFiTenCh() {
        return fiTenCh;
    }

    public void setFiTenCh(String fiTenCh) {
        this.fiTenCh = fiTenCh;
    }

    public String getFiDiachiCh() {
        return fiDiachiCh;
    }

    public void setFiDiachiCh(String fiDiachiCh) {
        this.fiDiachiCh = fiDiachiCh;
    }

    public String getFiDtCh() {
        return fiDtCh;
    }

    public void setFiDtCh(String fiDtCh) {
        this.fiDtCh = fiDtCh;
    }

    public String getFiFaxCh() {
        return fiFaxCh;
    }

    public void setFiFaxCh(String fiFaxCh) {
        this.fiFaxCh = fiFaxCh;
    }

    public String getFiEmailCh() {
        return fiEmailCh;
    }

    public void setFiEmailCh(String fiEmailCh) {
        this.fiEmailCh = fiEmailCh;
    }

    public String getFiSovandon() {
        return fiSovandon;
    }

    public void setFiSovandon(String fiSovandon) {
        this.fiSovandon = fiSovandon;
    }

    public String getFiSotokhai() {
        return fiSotokhai;
    }

    public void setFiSotokhai(String fiSotokhai) {
        this.fiSotokhai = fiSotokhai;
    }

    public List<Product15B> getProduct() {
        return product;
    }

    public void setProduct(List<Product15B> product) {
        this.product = product;
    }

    public BigDecimal getFiTongSl() {
        return fiTongSl;
    }

    public void setFiTongSl(BigDecimal fiTongSl) {
        this.fiTongSl = fiTongSl;
    }

    public BigDecimal getFiTongTl() {
        return fiTongTl;
    }

    public void setFiTongTl(BigDecimal fiTongTl) {
        this.fiTongTl = fiTongTl;
    }

    public String getFiNdTongso() {
        return fiNdTongso;
    }

    public void setFiNdTongso(String fiNdTongso) {
        this.fiNdTongso = fiNdTongso;
    }

    public String getFiDtXk() {
        return fiDtXk;
    }

    public void setFiDtXk(String fiDtXk) {
        this.fiDtXk = fiDtXk;
    }

    public String getFiNoiSx() {
        return fiNoiSx;
    }

    public void setFiNoiSx(String fiNoiSx) {
        this.fiNoiSx = fiNoiSx;
    }

    public String getFiTenqgXk() {
        return fiTenqgXk;
    }

    public void setFiTenqgXk(String fiTenqgXk) {
        this.fiTenqgXk = fiTenqgXk;
    }

    public String getFiMaqgXk() {
        return fiMaqgXk;
    }

    public void setFiMaqgXk(String fiMaqgXk) {
        this.fiMaqgXk = fiMaqgXk;
    }

    public String getFiQgQc() {
        return fiQgQc;
    }

    public void setFiQgQc(String fiQgQc) {
        this.fiQgQc = fiQgQc;
    }

    public String getFiTenckNhap() {
        return fiTenckNhap;
    }

    public void setFiTenckNhap(String fiTenckNhap) {
        this.fiTenckNhap = fiTenckNhap;
    }

    public String getFiMackNhap() {
        return fiMackNhap;
    }

    public void setFiMackNhap(String fiMackNhap) {
        this.fiMackNhap = fiMackNhap;
    }

    public Date getFiTgNhap() {
        return fiTgNhap;
    }

    public void setFiTgNhap(Date fiTgNhap) {
        this.fiTgNhap = fiTgNhap;
    }

    public String getFiNoichuyen() {
        return fiNoichuyen;
    }

    public void setFiNoichuyen(String fiNoichuyen) {
        this.fiNoichuyen = fiNoichuyen;
    }

    public String getFiVdLq() {
        return fiVdLq;
    }

    public void setFiVdLq(String fiVdLq) {
        this.fiVdLq = fiVdLq;
    }

    public String getFiHosoLq() {
        return fiHosoLq;
    }

    public void setFiHosoLq(String fiHosoLq) {
        this.fiHosoLq = fiHosoLq;
    }

    public String getFiPtVc() {
        return fiPtVc;
    }

    public void setFiPtVc(String fiPtVc) {
        this.fiPtVc = fiPtVc;
    }

    public String getFiPptdkt() {
        return fiPptdkt;
    }

    public void setFiPptdkt(String fiPptdkt) {
        this.fiPptdkt = fiPptdkt;
    }

    public String getFiNongdo() {
        return fiNongdo;
    }

    public void setFiNongdo(String fiNongdo) {
        this.fiNongdo = fiNongdo;
    }

    public String getFiPtvccv() {
        return fiPtvccv;
    }

    public void setFiPtvccv(String fiPtvccv) {
        this.fiPtvccv = fiPtvccv;
    }

    public String getFiNongdovc() {
        return fiNongdovc;
    }

    public void setFiNongdovc(String fiNongdovc) {
        this.fiNongdovc = fiNongdovc;
    }

    public Date getFiCachlyDn() {
        return fiCachlyDn;
    }

    public void setFiCachlyDn(Date fiCachlyDn) {
        this.fiCachlyDn = fiCachlyDn;
    }

    public String getFiKddv() {
        return fiKddv;
    }

    public void setFiKddv(String fiKddv) {
        this.fiKddv = fiKddv;
    }

    public Date getFiNgayky() {
        return fiNgayky;
    }

    public void setFiNgayky(Date fiNgayky) {
        this.fiNgayky = fiNgayky;
    }

    public String getFiNguoiky() {
        return fiNguoiky;
    }

    public void setFiNguoiky(String fiNguoiky) {
        this.fiNguoiky = fiNguoiky;
    }

    public String getFiNoiky() {
        return fiNoiky;
    }

    public void setFiNoiky(String fiNoiky) {
        this.fiNoiky = fiNoiky;
    }
    
}
