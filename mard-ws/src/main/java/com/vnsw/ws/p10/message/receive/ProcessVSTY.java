/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessVSTY")
public class ProcessVSTY {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "ReasonEdit")
    private String fiLydoSua;
    
    @XmlElement(name = "UnitProcessing")
    private String fiTenCqkddv;
    
    @XmlElement(name = "DispatchNo")
    private String fiSocvDi;
    
    @XmlElement(name = "DecidedNo")
    private String fiCancuQd;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DecidedDate")
    private Date fiNgayQd;
    
    @XmlElement(name = "DecidedName")
    private String fiDonviQd;
    
    @XmlElement(name = "ReportNumber")
    private String foSoBb;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ReportDate")
    private Date fiNgayBb;
    
    @XmlElement(name = "ReportUnitName")
    private String fiDonviBb;
    
    @XmlElement(name = "BillofLading")
    private String fiSoVandon;
    
    @XmlElement(name = "CustomsDecNo")
    private String fiSoTokhai;
    
    @XmlElementWrapper(name = "ProductList")
    @XmlElement(name = "Product")
    private List<Product9A> product;
    
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
    private String fiCmndCh;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfCard")
    private Date fiNgaycapCmnd;
    
    @XmlElement(name = "AddressOfCard")
    private String fiNoicapCmnd;
    
    @XmlElement(name = "NoVSTYContent")
    private String fiNoidungVs;
    
    @XmlElement(name = "Tool")
    private String fiVatdungLq;
    
    @XmlElement(name = "MeasuresHandle")
    private String fiDieu2;
    
    @XmlElement(name = "AddressVSTY")
    private String fiDieu3;
    
    @XmlElement(name = "ImplementerVSTY")
    private String fiDieu4;
    
    @XmlElement(name = "TimeVSTY")
    private String fiDieu5;
    
    @XmlElement(name = "AssignUse")
    private String fiDieu7;
    
    @XmlElement(name = "Recipients")
    private String fiNoinhan;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayky;
    
    @XmlElement(name = "SignConfirmName")
    private String fiNguoiky;
    
    @XmlElement(name = "SignConfirmAddress")
    private String fiNoiky;

    public ProcessVSTY() {
    }

    public ProcessVSTY(String fiMaHoso, String fiLydoSua, String fiTenCqkddv, String fiSocvDi, String fiCancuQd, Date fiNgayQd, String fiDonviQd, String foSoBb, Date fiNgayBb, String fiDonviBb, String fiSoVandon, String fiSoTokhai, List<Product9A> product, String fiTenCh, String fiDiachiCh, String fiDienthoaiCh, String fiFaxCh, String fiEmailCh, String fiCmndCh, Date fiNgaycapCmnd, String fiNoicapCmnd, String fiNoidungVs, String fiVatdungLq, String fiDieu2, String fiDieu3, String fiDieu4, String fiDieu5, String fiDieu7, String fiNoinhan, Date fiNgayky, String fiNguoiky, String fiNoiky) {
        this.fiMaHoso = fiMaHoso;
        this.fiLydoSua = fiLydoSua;
        this.fiTenCqkddv = fiTenCqkddv;
        this.fiSocvDi = fiSocvDi;
        this.fiCancuQd = fiCancuQd;
        this.fiNgayQd = fiNgayQd;
        this.fiDonviQd = fiDonviQd;
        this.foSoBb = foSoBb;
        this.fiNgayBb = fiNgayBb;
        this.fiDonviBb = fiDonviBb;
        this.fiSoVandon = fiSoVandon;
        this.fiSoTokhai = fiSoTokhai;
        this.product = product;
        this.fiTenCh = fiTenCh;
        this.fiDiachiCh = fiDiachiCh;
        this.fiDienthoaiCh = fiDienthoaiCh;
        this.fiFaxCh = fiFaxCh;
        this.fiEmailCh = fiEmailCh;
        this.fiCmndCh = fiCmndCh;
        this.fiNgaycapCmnd = fiNgaycapCmnd;
        this.fiNoicapCmnd = fiNoicapCmnd;
        this.fiNoidungVs = fiNoidungVs;
        this.fiVatdungLq = fiVatdungLq;
        this.fiDieu2 = fiDieu2;
        this.fiDieu3 = fiDieu3;
        this.fiDieu4 = fiDieu4;
        this.fiDieu5 = fiDieu5;
        this.fiDieu7 = fiDieu7;
        this.fiNoinhan = fiNoinhan;
        this.fiNgayky = fiNgayky;
        this.fiNguoiky = fiNguoiky;
        this.fiNoiky = fiNoiky;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiLydoSua() {
        return fiLydoSua;
    }

    public void setFiLydoSua(String fiLydoSua) {
        this.fiLydoSua = fiLydoSua;
    }

    public String getFiTenCqkddv() {
        return fiTenCqkddv;
    }

    public void setFiTenCqkddv(String fiTenCqkddv) {
        this.fiTenCqkddv = fiTenCqkddv;
    }

    public String getFiSocvDi() {
        return fiSocvDi;
    }

    public void setFiSocvDi(String fiSocvDi) {
        this.fiSocvDi = fiSocvDi;
    }

    public String getFiCancuQd() {
        return fiCancuQd;
    }

    public void setFiCancuQd(String fiCancuQd) {
        this.fiCancuQd = fiCancuQd;
    }

    public Date getFiNgayQd() {
        return fiNgayQd;
    }

    public void setFiNgayQd(Date fiNgayQd) {
        this.fiNgayQd = fiNgayQd;
    }

    public String getFiDonviQd() {
        return fiDonviQd;
    }

    public void setFiDonviQd(String fiDonviQd) {
        this.fiDonviQd = fiDonviQd;
    }

    public String getFoSoBb() {
        return foSoBb;
    }

    public void setFoSoBb(String foSoBb) {
        this.foSoBb = foSoBb;
    }

    public Date getFiNgayBb() {
        return fiNgayBb;
    }

    public void setFiNgayBb(Date fiNgayBb) {
        this.fiNgayBb = fiNgayBb;
    }

    public String getFiDonviBb() {
        return fiDonviBb;
    }

    public void setFiDonviBb(String fiDonviBb) {
        this.fiDonviBb = fiDonviBb;
    }

    public String getFiSoVandon() {
        return fiSoVandon;
    }

    public void setFiSoVandon(String fiSoVandon) {
        this.fiSoVandon = fiSoVandon;
    }

    public String getFiSoTokhai() {
        return fiSoTokhai;
    }

    public void setFiSoTokhai(String fiSoTokhai) {
        this.fiSoTokhai = fiSoTokhai;
    }

    public List<Product9A> getProduct() {
        return product;
    }

    public void setProduct(List<Product9A> product) {
        this.product = product;
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

    public String getFiCmndCh() {
        return fiCmndCh;
    }

    public void setFiCmndCh(String fiCmndCh) {
        this.fiCmndCh = fiCmndCh;
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

    public String getFiNoidungVs() {
        return fiNoidungVs;
    }

    public void setFiNoidungVs(String fiNoidungVs) {
        this.fiNoidungVs = fiNoidungVs;
    }

    public String getFiVatdungLq() {
        return fiVatdungLq;
    }

    public void setFiVatdungLq(String fiVatdungLq) {
        this.fiVatdungLq = fiVatdungLq;
    }

    public String getFiDieu2() {
        return fiDieu2;
    }

    public void setFiDieu2(String fiDieu2) {
        this.fiDieu2 = fiDieu2;
    }

    public String getFiDieu3() {
        return fiDieu3;
    }

    public void setFiDieu3(String fiDieu3) {
        this.fiDieu3 = fiDieu3;
    }

    public String getFiDieu4() {
        return fiDieu4;
    }

    public void setFiDieu4(String fiDieu4) {
        this.fiDieu4 = fiDieu4;
    }

    public String getFiDieu5() {
        return fiDieu5;
    }

    public void setFiDieu5(String fiDieu5) {
        this.fiDieu5 = fiDieu5;
    }

    public String getFiDieu7() {
        return fiDieu7;
    }

    public void setFiDieu7(String fiDieu7) {
        this.fiDieu7 = fiDieu7;
    }

    public String getFiNoinhan() {
        return fiNoinhan;
    }

    public void setFiNoinhan(String fiNoinhan) {
        this.fiNoinhan = fiNoinhan;
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
