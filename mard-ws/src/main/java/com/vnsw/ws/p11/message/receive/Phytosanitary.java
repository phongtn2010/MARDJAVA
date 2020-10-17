/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.receive;

import com.vnsw.ws.p11.entity.db.Tbdhanghoa11;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Phytosanitary")
public class Phytosanitary {
    @XmlTransient
    private Long fiIdHoso;
    
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "NameOfRegistration")
    private String fiDtDangky;
    
    @XmlElement(name = "AddressOfRegistration")
    private String fiDiachi;
    
    @XmlElement(name = "IdentityNumberOfRegistration")
    private String fiSocmnd;
    
    @XmlElement(name = "DateOfIdentityNumber")
    private Date fiNgaycmnd;
    
    @XmlElement(name = "RegistrationPlaceOfIdentityNumber")
    private String fiNoicmnd;
    
    @XmlElement(name = "Phone")
    private String fiSodt;
    
    @XmlElement(name = "Email")
    private String fiEmail;
    
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<Tbdhanghoa11> product;
    
    
    @XmlElement(name = "TransportType")
    private String fiPtCc;
    
    @XmlElement(name = "Exporter")
    private String fiDtXk;
    
    @XmlElement(name = "ExporterAddress")
    private String fiDiachidtxk;
    
    @XmlElement(name = "PortOfDepartureName")
    private String fiTenckXk;
    
    @XmlElement(name = "PortOfDepartureCode")
    private String fiMackXk;
    
    @XmlElement(name = "Importer")
    private String fiDtNk;
    
    @XmlElement(name = "ImporterAddress")
    private String fiDiachidtnk;
    
    @XmlElement(name = "PortOfDestinationName")
    private String fiTenckNk;
    
    @XmlElement(name = "PortOfDestinationCode")
    private String fiMackNk;
    
    @XmlElement(name = "ImporterStateName")
    private String fiTenqgNk;
    
    @XmlElement(name = "ImporterStateCode")
    private String fiMaqgNk;
    
    @XmlElement(name = "Uses")
    private String fiMucdichsd;
    
    @XmlElement(name = "PlaceOfPhytosanitary")
    private String fiDiadiemdk;
    
    @XmlElement(name = "DateOfPhytosanitar")
    private Date fiThoigiandk;
    
    @XmlElement(name = "Monitoring")
    private String fiDdTgGs;
    
    @XmlElement(name = "NumberOfPhyto")
    private String fiSobangcn;
    
    @XmlElement(name = "SignAddress")
    private String fiNoiky;
    
    @XmlElement(name = "SignDate")
    private Date fiNgayky;
    
    @XmlElement(name = "SignName")
    private String fiNguoiky;
    
    @XmlTransient
    private Long fiTrangthai;
    
    @XmlTransient
    private Long fiHoatdong;
    
    @XmlTransient
    private Date fiNgaytao;
    
    @XmlTransient
    private String fiNguoitao;
    
    @XmlTransient
    private Date fiNgayCn;
    
    @XmlTransient
    private String fiNguoiCn;
    
    @XmlTransient
    private Long fiIdHosocha;
    
    @XmlTransient
    private Long fiLahosotam;
    
    @XmlTransient
    private String fiSovaoso;
    
    @XmlTransient
    private Date fiNgaykyBnn;
    
    @XmlTransient
    private String fiNguoikyBnn;

    public Phytosanitary() {
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

    public String getFiDtDangky() {
        return fiDtDangky;
    }

    public void setFiDtDangky(String fiDtDangky) {
        this.fiDtDangky = fiDtDangky;
    }

    public String getFiDiachi() {
        return fiDiachi;
    }

    public void setFiDiachi(String fiDiachi) {
        this.fiDiachi = fiDiachi;
    }

    public String getFiSocmnd() {
        return fiSocmnd;
    }

    public void setFiSocmnd(String fiSocmnd) {
        this.fiSocmnd = fiSocmnd;
    }

    public Date getFiNgaycmnd() {
        return fiNgaycmnd;
    }

    public void setFiNgaycmnd(Date fiNgaycmnd) {
        this.fiNgaycmnd = fiNgaycmnd;
    }

    public String getFiNoicmnd() {
        return fiNoicmnd;
    }

    public void setFiNoicmnd(String fiNoicmnd) {
        this.fiNoicmnd = fiNoicmnd;
    }

    public String getFiSodt() {
        return fiSodt;
    }

    public void setFiSodt(String fiSodt) {
        this.fiSodt = fiSodt;
    }

    public String getFiEmail() {
        return fiEmail;
    }

    public void setFiEmail(String fiEmail) {
        this.fiEmail = fiEmail;
    }

    public List<Tbdhanghoa11> getProduct() {
        return product;
    }

    public void setProduct(List<Tbdhanghoa11> product) {
        this.product = product;
    }

    public String getFiPtCc() {
        return fiPtCc;
    }

    public void setFiPtCc(String fiPtCc) {
        this.fiPtCc = fiPtCc;
    }

    public String getFiDtXk() {
        return fiDtXk;
    }

    public void setFiDtXk(String fiDtXk) {
        this.fiDtXk = fiDtXk;
    }

    public String getFiDiachidtxk() {
        return fiDiachidtxk;
    }

    public void setFiDiachidtxk(String fiDiachidtxk) {
        this.fiDiachidtxk = fiDiachidtxk;
    }

    public String getFiTenckXk() {
        return fiTenckXk;
    }

    public void setFiTenckXk(String fiTenckXk) {
        this.fiTenckXk = fiTenckXk;
    }

    public String getFiMackXk() {
        return fiMackXk;
    }

    public void setFiMackXk(String fiMackXk) {
        this.fiMackXk = fiMackXk;
    }

    public String getFiDtNk() {
        return fiDtNk;
    }

    public void setFiDtNk(String fiDtNk) {
        this.fiDtNk = fiDtNk;
    }

    public String getFiDiachidtnk() {
        return fiDiachidtnk;
    }

    public void setFiDiachidtnk(String fiDiachidtnk) {
        this.fiDiachidtnk = fiDiachidtnk;
    }

    public String getFiTenckNk() {
        return fiTenckNk;
    }

    public void setFiTenckNk(String fiTenckNk) {
        this.fiTenckNk = fiTenckNk;
    }

    public String getFiMackNk() {
        return fiMackNk;
    }

    public void setFiMackNk(String fiMackNk) {
        this.fiMackNk = fiMackNk;
    }

    public String getFiTenqgNk() {
        return fiTenqgNk;
    }

    public void setFiTenqgNk(String fiTenqgNk) {
        this.fiTenqgNk = fiTenqgNk;
    }

    public String getFiMaqgNk() {
        return fiMaqgNk;
    }

    public void setFiMaqgNk(String fiMaqgNk) {
        this.fiMaqgNk = fiMaqgNk;
    }

    public String getFiMucdichsd() {
        return fiMucdichsd;
    }

    public void setFiMucdichsd(String fiMucdichsd) {
        this.fiMucdichsd = fiMucdichsd;
    }

    public String getFiDiadiemdk() {
        return fiDiadiemdk;
    }

    public void setFiDiadiemdk(String fiDiadiemdk) {
        this.fiDiadiemdk = fiDiadiemdk;
    }

    public Date getFiThoigiandk() {
        return fiThoigiandk;
    }

    public void setFiThoigiandk(Date fiThoigiandk) {
        this.fiThoigiandk = fiThoigiandk;
    }

    public String getFiDdTgGs() {
        return fiDdTgGs;
    }

    public void setFiDdTgGs(String fiDdTgGs) {
        this.fiDdTgGs = fiDdTgGs;
    }

    public String getFiSobangcn() {
        return fiSobangcn;
    }

    public void setFiSobangcn(String fiSobangcn) {
        this.fiSobangcn = fiSobangcn;
    }

    public String getFiNoiky() {
        return fiNoiky;
    }

    public void setFiNoiky(String fiNoiky) {
        this.fiNoiky = fiNoiky;
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

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
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

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgayCn() {
        return fiNgayCn;
    }

    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }

    public String getFiNguoiCn() {
        return fiNguoiCn;
    }

    public void setFiNguoiCn(String fiNguoiCn) {
        this.fiNguoiCn = fiNguoiCn;
    }

    public Long getFiIdHosocha() {
        return fiIdHosocha;
    }

    public void setFiIdHosocha(Long fiIdHosocha) {
        this.fiIdHosocha = fiIdHosocha;
    }

    public Long getFiLahosotam() {
        return fiLahosotam;
    }

    public void setFiLahosotam(Long fiLahosotam) {
        this.fiLahosotam = fiLahosotam;
    }

    public String getFiSovaoso() {
        return fiSovaoso;
    }

    public void setFiSovaoso(String fiSovaoso) {
        this.fiSovaoso = fiSovaoso;
    }

    public Date getFiNgaykyBnn() {
        return fiNgaykyBnn;
    }

    public void setFiNgaykyBnn(Date fiNgaykyBnn) {
        this.fiNgaykyBnn = fiNgaykyBnn;
    }

    public String getFiNguoikyBnn() {
        return fiNguoikyBnn;
    }

    public void setFiNguoikyBnn(String fiNguoikyBnn) {
        this.fiNguoikyBnn = fiNguoikyBnn;
    }
    
    
}
