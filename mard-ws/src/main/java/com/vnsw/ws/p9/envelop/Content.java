package com.vnsw.ws.p9.envelop;

import com.vnsw.ws.p9.message.receive.*;
import com.vnsw.ws.p9.message.send.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
public class Content {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error> ErrorList;
    
    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;
    
    // Ho so moi
    @XmlElement(name = "RegistrationProfile")
    protected HoSo09 hoso;

    @XmlElement(name = "RegistrationComfirm")
    protected XacNhanDon xacNhanDon;
    
    @XmlElement(name = "Result")
    protected KetQuaThamDinh ketQuaThamDinh;

    @XmlElement(name = "RequestEdit")
    protected YCSuaHS yeucauSuaHS;

    @XmlElement(name = "ResponseEdit")
    protected PhanHoiYCSuaHS phanHoiYCSuaHS;

    @XmlElement(name = "RequestCancel")
    protected DNRutHSTruocTiepNhan dnRutHSTruocTiepNhan;

    @XmlElement(name = "RequestCancel")
    protected DNYeuCauRutHSSauTiepNhan dnYeuCauRutHSSauTiepNhan;

    @XmlElement(name = "ResponseCancel")
    protected PhanHoiYCXinRutHS phanHoiYCXinRutHS;

    @XmlElement(name = "AnimalQuarantineResult")
    protected GiayCNKD giayCNKD;

    @XmlElement(name = "TransportResult")
    protected GiayVanChuyen giayVanChuyen;

    @XmlElement(name = "QualityResult")
    protected GiayXNCL giayXNCL;

    @XmlElement(name = "AnimalFee")
    protected ThongBaoApPhi thongBaoApPhi;

    @XmlElement(name = "FeeResponse")
    protected XacNhanPhi xacNhanPhi;

    @XmlElement(name = "RequestUpdate")
    protected ThongBaoApPhiBoXung thongBaoApPhiBoXung;

    @XmlElement(name = "ResponseEditCer")
    protected PhanHoiYCSuaGCN phanHoiYCSuaGCN;

    @XmlElement(name = "QualityFailResult")
    protected CongVanXNCLKhongDat congVanXNCLKhongDat;

    @XmlElement(name = "ResponseQualityResult")
    protected DNPhanHoiKQXNCL dnPhanHoiKQXNCL;

    @XmlElement(name = "QualityNotHaveResult")
    protected ThongBaoKhongCapGCNKD thongBaoKhongCapGCNKD;

    @XmlElement(name = "RequestEditCer")
    protected DNYeuCauSuaGiayPhep dnYeuCauSuaGiayPhep;

    public Content() {
    }

    public Content(List<Error> errorList, String receiveDate, HoSo09 hoso, XacNhanDon xacNhanDon, KetQuaThamDinh ketQuaThamDinh, YCSuaHS yeucauSuaHS, PhanHoiYCSuaHS phanHoiYCSuaHS, DNRutHSTruocTiepNhan dnRutHSTruocTiepNhan, DNYeuCauRutHSSauTiepNhan dnYeuCauRutHSSauTiepNhan, PhanHoiYCXinRutHS phanHoiYCXinRutHS, GiayCNKD giayCNKD, GiayVanChuyen giayVanChuyen, GiayXNCL giayXNCL, ThongBaoApPhi thongBaoApPhi, XacNhanPhi xacNhanPhi, ThongBaoApPhiBoXung thongBaoApPhiBoXung, PhanHoiYCSuaGCN phanHoiYCSuaGCN, CongVanXNCLKhongDat congVanXNCLKhongDat, DNPhanHoiKQXNCL dnPhanHoiKQXNCL, ThongBaoKhongCapGCNKD thongBaoKhongCapGCNKD) {
        ErrorList = errorList;
        this.receiveDate = receiveDate;
        this.hoso = hoso;
        this.xacNhanDon = xacNhanDon;
        this.ketQuaThamDinh = ketQuaThamDinh;
        this.yeucauSuaHS = yeucauSuaHS;
        this.phanHoiYCSuaHS = phanHoiYCSuaHS;
        this.dnRutHSTruocTiepNhan = dnRutHSTruocTiepNhan;
        this.dnYeuCauRutHSSauTiepNhan = dnYeuCauRutHSSauTiepNhan;
        this.phanHoiYCXinRutHS = phanHoiYCXinRutHS;
        this.giayCNKD = giayCNKD;
        this.giayVanChuyen = giayVanChuyen;
        this.giayXNCL = giayXNCL;
        this.thongBaoApPhi = thongBaoApPhi;
        this.xacNhanPhi = xacNhanPhi;
        this.thongBaoApPhiBoXung = thongBaoApPhiBoXung;
        this.phanHoiYCSuaGCN = phanHoiYCSuaGCN;
        this.congVanXNCLKhongDat = congVanXNCLKhongDat;
        this.dnPhanHoiKQXNCL = dnPhanHoiKQXNCL;
        this.thongBaoKhongCapGCNKD = thongBaoKhongCapGCNKD;
    }

    public List<Error> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<Error> errorList) {
        ErrorList = errorList;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public HoSo09 getHoso() {
        return hoso;
    }

    public void setHoso(HoSo09 hoso) {
        this.hoso = hoso;
    }

    public XacNhanDon getXacNhanDon() {
        return xacNhanDon;
    }

    public void setXacNhanDon(XacNhanDon xacNhanDon) {
        this.xacNhanDon = xacNhanDon;
    }

    public KetQuaThamDinh getKetQuaThamDinh() {
        return ketQuaThamDinh;
    }

    public void setKetQuaThamDinh(KetQuaThamDinh ketQuaThamDinh) {
        this.ketQuaThamDinh = ketQuaThamDinh;
    }

    public YCSuaHS getYeucauSuaHS() {
        return yeucauSuaHS;
    }

    public void setYeucauSuaHS(YCSuaHS yeucauSuaHS) {
        this.yeucauSuaHS = yeucauSuaHS;
    }

    public PhanHoiYCSuaHS getPhanHoiYCSuaHS() {
        return phanHoiYCSuaHS;
    }

    public void setPhanHoiYCSuaHS(PhanHoiYCSuaHS phanHoiYCSuaHS) {
        this.phanHoiYCSuaHS = phanHoiYCSuaHS;
    }

    public DNRutHSTruocTiepNhan getDnRutHSTruocTiepNhan() {
        return dnRutHSTruocTiepNhan;
    }

    public void setDnRutHSTruocTiepNhan(DNRutHSTruocTiepNhan dnRutHSTruocTiepNhan) {
        this.dnRutHSTruocTiepNhan = dnRutHSTruocTiepNhan;
    }

    public DNYeuCauRutHSSauTiepNhan getDnYeuCauRutHSSauTiepNhan() {
        return dnYeuCauRutHSSauTiepNhan;
    }

    public void setDnYeuCauRutHSSauTiepNhan(DNYeuCauRutHSSauTiepNhan dnYeuCauRutHSSauTiepNhan) {
        this.dnYeuCauRutHSSauTiepNhan = dnYeuCauRutHSSauTiepNhan;
    }

    public PhanHoiYCXinRutHS getPhanHoiYCXinRutHS() {
        return phanHoiYCXinRutHS;
    }

    public void setPhanHoiYCXinRutHS(PhanHoiYCXinRutHS phanHoiYCXinRutHS) {
        this.phanHoiYCXinRutHS = phanHoiYCXinRutHS;
    }

    public GiayCNKD getGiayCNKD() {
        return giayCNKD;
    }

    public void setGiayCNKD(GiayCNKD giayCNKD) {
        this.giayCNKD = giayCNKD;
    }

    public GiayVanChuyen getGiayVanChuyen() {
        return giayVanChuyen;
    }

    public void setGiayVanChuyen(GiayVanChuyen giayVanChuyen) {
        this.giayVanChuyen = giayVanChuyen;
    }

    public GiayXNCL getGiayXNCL() {
        return giayXNCL;
    }

    public void setGiayXNCL(GiayXNCL giayXNCL) {
        this.giayXNCL = giayXNCL;
    }

    public ThongBaoApPhi getThongBaoApPhi() {
        return thongBaoApPhi;
    }

    public void setThongBaoApPhi(ThongBaoApPhi thongBaoApPhi) {
        this.thongBaoApPhi = thongBaoApPhi;
    }

    public XacNhanPhi getXacNhanPhi() {
        return xacNhanPhi;
    }

    public void setXacNhanPhi(XacNhanPhi xacNhanPhi) {
        this.xacNhanPhi = xacNhanPhi;
    }

    public ThongBaoApPhiBoXung getThongBaoApPhiBoXung() {
        return thongBaoApPhiBoXung;
    }

    public void setThongBaoApPhiBoXung(ThongBaoApPhiBoXung thongBaoApPhiBoXung) {
        this.thongBaoApPhiBoXung = thongBaoApPhiBoXung;
    }

    public PhanHoiYCSuaGCN getPhanHoiYCSuaGCN() {
        return phanHoiYCSuaGCN;
    }

    public void setPhanHoiYCSuaGCN(PhanHoiYCSuaGCN phanHoiYCSuaGCN) {
        this.phanHoiYCSuaGCN = phanHoiYCSuaGCN;
    }

    public CongVanXNCLKhongDat getCongVanXNCLKhongDat() {
        return congVanXNCLKhongDat;
    }

    public void setCongVanXNCLKhongDat(CongVanXNCLKhongDat congVanXNCLKhongDat) {
        this.congVanXNCLKhongDat = congVanXNCLKhongDat;
    }

    public DNPhanHoiKQXNCL getDnPhanHoiKQXNCL() {
        return dnPhanHoiKQXNCL;
    }

    public void setDnPhanHoiKQXNCL(DNPhanHoiKQXNCL dnPhanHoiKQXNCL) {
        this.dnPhanHoiKQXNCL = dnPhanHoiKQXNCL;
    }

    public ThongBaoKhongCapGCNKD getThongBaoKhongCapGCNKD() {
        return thongBaoKhongCapGCNKD;
    }

    public void setThongBaoKhongCapGCNKD(ThongBaoKhongCapGCNKD thongBaoKhongCapGCNKD) {
        this.thongBaoKhongCapGCNKD = thongBaoKhongCapGCNKD;
    }

    public DNYeuCauSuaGiayPhep getDnYeuCauSuaGiayPhep() {
        return dnYeuCauSuaGiayPhep;
    }

    public void setDnYeuCauSuaGiayPhep(DNYeuCauSuaGiayPhep dnYeuCauSuaGiayPhep) {
        this.dnYeuCauSuaGiayPhep = dnYeuCauSuaGiayPhep;
    }
}
