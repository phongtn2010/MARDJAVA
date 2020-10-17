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
@XmlType(name = "AnimalQuarantine")
public class AnimalQuarantine {
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
    private String fiDienthoaiCh;
    
    @XmlElement(name = "Fax")
    private String fiFaxCh;
    
    @XmlElement(name = "Email")
    private String fiEmailCh;
    
    @XmlElement(name = "IdCard")
    private String fiCmnd;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfCard")
    private Date fiNgaycapCmnd;
    
    @XmlElement(name = "AddressOfCard")
    private String fiNoicapCmnd;
    
    @XmlElement(name = "BillofLading")
    private String fiSovandon;
    
    @XmlElement(name = "CustomsDecNo")
    private String fiSotokhai;
    
    @XmlElementWrapper(name = "ProductList")
    @XmlElement(name = "Product")
    private List<Product15A> product;
    
    @XmlElement(name = "TotalQuantity")
    private BigDecimal fiTongSl;
    
    @XmlElement(name = "TotalChar")
    private String fiNdTongsl;
    
    @XmlElement(name = "Exporter")
    private String fiDtXk;
    
    @XmlElement(name = "ExporterStateName")
    private String fiTenqgXk;
    
    @XmlElement(name = "ExporterStateCode")
    private String fiMaqgXk;
    
    @XmlElement(name = "TransitStateName")
    private String fiQgQc;
    
    @XmlElement(name = "Destination")
    private String fiNoiden;
    
    @XmlElement(name = "Tool")
    private String fiVdLq;
    
    @XmlElement(name = "File")
    private String fiHsLq;
    
    @XmlElement(name = "TransportType")
    private String fiPtVc;
    
    @XmlElement(name = "Immune")
    private String fiBenhMd;
    
    @XmlElement(name = "MethodsDisinfect")
    private String fiPptdkt;
    
    @XmlElement(name = "Concentrations")
    private String fiNongdo;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ValidToDate")
    private Date fiGiatriDn;
    
    @XmlElement(name = "Veterinaria")
    private String fiKddv;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayky;
    
    @XmlElement(name = "SignConfirmName")
    private String fiNguoiky;
    
    @XmlElement(name = "SignConfirmAddress")
    private String fiNoiky;

    public AnimalQuarantine() {
    }

    public AnimalQuarantine(String fiLydoSua, String fiMaHoso, String fiTenCqkddv, String fiSocv, String fiTenCh, String fiDiachiCh, String fiDienthoaiCh, String fiFaxCh, String fiEmailCh, String fiCmnd, Date fiNgaycapCmnd, String fiNoicapCmnd, String fiSovandon, String fiSotokhai, List<Product15A> product, BigDecimal fiTongSl, String fiNdTongsl, String fiDtXk, String fiTenqgXk, String fiMaqgXk, String fiQgQc, String fiNoiden, String fiVdLq, String fiHsLq, String fiPtVc, String fiBenhMd, String fiPptdkt, String fiNongdo, Date fiGiatriDn, String fiKddv, Date fiNgayky, String fiNguoiky, String fiNoiky) {
        this.fiLydoSua = fiLydoSua;
        this.fiMaHoso = fiMaHoso;
        this.fiTenCqkddv = fiTenCqkddv;
        this.fiSocv = fiSocv;
        this.fiTenCh = fiTenCh;
        this.fiDiachiCh = fiDiachiCh;
        this.fiDienthoaiCh = fiDienthoaiCh;
        this.fiFaxCh = fiFaxCh;
        this.fiEmailCh = fiEmailCh;
        this.fiCmnd = fiCmnd;
        this.fiNgaycapCmnd = fiNgaycapCmnd;
        this.fiNoicapCmnd = fiNoicapCmnd;
        this.fiSovandon = fiSovandon;
        this.fiSotokhai = fiSotokhai;
        this.product = product;
        this.fiTongSl = fiTongSl;
        this.fiNdTongsl = fiNdTongsl;
        this.fiDtXk = fiDtXk;
        this.fiTenqgXk = fiTenqgXk;
        this.fiMaqgXk = fiMaqgXk;
        this.fiQgQc = fiQgQc;
        this.fiNoiden = fiNoiden;
        this.fiVdLq = fiVdLq;
        this.fiHsLq = fiHsLq;
        this.fiPtVc = fiPtVc;
        this.fiBenhMd = fiBenhMd;
        this.fiPptdkt = fiPptdkt;
        this.fiNongdo = fiNongdo;
        this.fiGiatriDn = fiGiatriDn;
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

    public String getFiDienthoaiCh() {
        return fiDienthoaiCh;
    }

    public void setFiDienthoaiCh(String fiDienthoaiCh) {
        this.fiDienthoaiCh = fiDienthoaiCh;
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

    public String getFiCmnd() {
        return fiCmnd;
    }

    public void setFiCmnd(String fiCmnd) {
        this.fiCmnd = fiCmnd;
    }

    public Date getFiNgaycapCmnd() {
        return fiNgaycapCmnd;
    }

    public void setFiNgaycapCmnd(Date fiNgaycapCmnd) {
        this.fiNgaycapCmnd = fiNgaycapCmnd;
    }

    public String getFiNoicapCmnd() {
        return fiNoicapCmnd;
    }

    public void setFiNoicapCmnd(String fiNoicapCmnd) {
        this.fiNoicapCmnd = fiNoicapCmnd;
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

    public List<Product15A> getProduct() {
        return product;
    }

    public void setProduct(List<Product15A> product) {
        this.product = product;
    }

    public BigDecimal getFiTongSl() {
        return fiTongSl;
    }

    public void setFiTongSl(BigDecimal fiTongSl) {
        this.fiTongSl = fiTongSl;
    }

    public String getFiNdTongsl() {
        return fiNdTongsl;
    }

    public void setFiNdTongsl(String fiNdTongsl) {
        this.fiNdTongsl = fiNdTongsl;
    }

    public String getFiDtXk() {
        return fiDtXk;
    }

    public void setFiDtXk(String fiDtXk) {
        this.fiDtXk = fiDtXk;
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

    public String getFiNoiden() {
        return fiNoiden;
    }

    public void setFiNoiden(String fiNoiden) {
        this.fiNoiden = fiNoiden;
    }

    public String getFiVdLq() {
        return fiVdLq;
    }

    public void setFiVdLq(String fiVdLq) {
        this.fiVdLq = fiVdLq;
    }

    public String getFiHsLq() {
        return fiHsLq;
    }

    public void setFiHsLq(String fiHsLq) {
        this.fiHsLq = fiHsLq;
    }

    public String getFiPtVc() {
        return fiPtVc;
    }

    public void setFiPtVc(String fiPtVc) {
        this.fiPtVc = fiPtVc;
    }

    public String getFiBenhMd() {
        return fiBenhMd;
    }

    public void setFiBenhMd(String fiBenhMd) {
        this.fiBenhMd = fiBenhMd;
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

    public Date getFiGiatriDn() {
        return fiGiatriDn;
    }

    public void setFiGiatriDn(Date fiGiatriDn) {
        this.fiGiatriDn = fiGiatriDn;
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
