
package com.nsw.most.p01.model;

import java.util.Date;
import java.util.List;

public class VTbdhoso1 {

    private static final long serialVersionUID = 1L;

    private Long fiIdCqxl;

    private Long fiIdHoso;

    private Long fiIdTckt;

    private String fiMaTckt;

    private String fiMaHoSo;

    private String fiTenTcht;

    private String fiMst;

    private String fiNguoiNk;

    private String fiDiachiNnk;

    private String fiDtNnk;

    private String fiFaxNnk;

    private String fiEmailNnk;

    private String fiNguoiLh;

    private Date fiTuNgay;

    private Date fiDenNgay;

    private String fiDiachiKho;

    private String fiMaQcvn;

    private String fiTenQcvn;

    private Long fiIdTcdg;

    private String fiMaTcdg;

    private String fiTenTcdg;

    private String fiGhichu;

    private Date fiNgaytao;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Date fiNgayGui;

    private Long fiLoai;

    private String fiTenloai;

    private String fiMaCqkt;

    private String fiTenCqkt;

    private Long fiTrangthai;

    private String fiTenTt;
    
    private Date fiNgayThongBao;    
    
    private String fiSoThongBao;

    private List<Tbdtokhaihq1> toKhaiHQ;

    private List<Tbddinhkem1> tepDinhKem;

    private List<Tbdhanghoa1> hangHoa1;

    public VTbdhoso1() {
        super();
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MA_TCKT ( VARCHAR2 ) 
    public void setFiMaTckt(String fiMaTckt) {
        this.fiMaTckt = fiMaTckt;
    }

    public String getFiMaTckt() {
        return this.fiMaTckt;
    }

    //--- DATABASE MAPPING : FI_TEN_TCHT ( VARCHAR2 ) 
    public void setFiTenTcht(String fiTenTcht) {
        this.fiTenTcht = fiTenTcht;
    }

    public String getFiTenTcht() {
        return this.fiTenTcht;
    }

    //--- DATABASE MAPPING : FI_MST ( VARCHAR2 ) 
    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

    public String getFiMst() {
        return this.fiMst;
    }

    //--- DATABASE MAPPING : FI_NGUOI_NK ( VARCHAR2 ) 
    public void setFiNguoiNk(String fiNguoiNk) {
        this.fiNguoiNk = fiNguoiNk;
    }

    public String getFiNguoiNk() {
        return this.fiNguoiNk;
    }

    //--- DATABASE MAPPING : FI_DIACHI_NNK ( VARCHAR2 ) 
    public void setFiDiachiNnk(String fiDiachiNnk) {
        this.fiDiachiNnk = fiDiachiNnk;
    }

    public String getFiDiachiNnk() {
        return this.fiDiachiNnk;
    }

    //--- DATABASE MAPPING : FI_DT_NNK ( VARCHAR2 ) 
    public void setFiDtNnk(String fiDtNnk) {
        this.fiDtNnk = fiDtNnk;
    }

    public String getFiDtNnk() {
        return this.fiDtNnk;
    }

    //--- DATABASE MAPPING : FI_FAX_NNK ( VARCHAR2 ) 
    public void setFiFaxNnk(String fiFaxNnk) {
        this.fiFaxNnk = fiFaxNnk;
    }

    public String getFiFaxNnk() {
        return this.fiFaxNnk;
    }

    //--- DATABASE MAPPING : FI_EMAIL_NNK ( VARCHAR2 ) 
    public void setFiEmailNnk(String fiEmailNnk) {
        this.fiEmailNnk = fiEmailNnk;
    }

    public String getFiEmailNnk() {
        return this.fiEmailNnk;
    }

    //--- DATABASE MAPPING : FI_NGUOI_LH ( VARCHAR2 ) 
    public void setFiNguoiLh(String fiNguoiLh) {
        this.fiNguoiLh = fiNguoiLh;
    }

    public String getFiNguoiLh() {
        return this.fiNguoiLh;
    }

    //--- DATABASE MAPPING : FI_TU_NGAY ( DATE ) 
    public void setFiTuNgay(Date fiTuNgay) {
        this.fiTuNgay = fiTuNgay;
    }

    public Date getFiTuNgay() {
        return this.fiTuNgay;
    }

    //--- DATABASE MAPPING : FI_DEN_NGAY ( DATE ) 
    public void setFiDenNgay(Date fiDenNgay) {
        this.fiDenNgay = fiDenNgay;
    }

    public Date getFiDenNgay() {
        return this.fiDenNgay;
    }

    //--- DATABASE MAPPING : FI_DIACHI_KHO ( VARCHAR2 ) 
    public void setFiDiachiKho(String fiDiachiKho) {
        this.fiDiachiKho = fiDiachiKho;
    }

    public String getFiDiachiKho() {
        return this.fiDiachiKho;
    }

    //--- DATABASE MAPPING : FI_MA_QCVN ( VARCHAR2 ) 
    public void setFiMaQcvn(String fiMaQcvn) {
        this.fiMaQcvn = fiMaQcvn;
    }

    public String getFiMaQcvn() {
        return this.fiMaQcvn;
    }

    //--- DATABASE MAPPING : FI_TEN_QCVN ( VARCHAR2 ) 
    public void setFiTenQcvn(String fiTenQcvn) {
        this.fiTenQcvn = fiTenQcvn;
    }

    public String getFiTenQcvn() {
        return this.fiTenQcvn;
    }

    //--- DATABASE MAPPING : FI_MA_TCDG ( VARCHAR2 ) 
    public void setFiMaTcdg(String fiMaTcdg) {
        this.fiMaTcdg = fiMaTcdg;
    }

    public String getFiMaTcdg() {
        return this.fiMaTcdg;
    }

    //--- DATABASE MAPPING : FI_TEN_TCDG ( VARCHAR2 ) 
    public void setFiTenTcdg(String fiTenTcdg) {
        this.fiTenTcdg = fiTenTcdg;
    }

    public String getFiTenTcdg() {
        return this.fiTenTcdg;
    }

    //--- DATABASE MAPPING : FI_GHICHU ( VARCHAR2 ) 
    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

    public String getFiGhichu() {
        return this.fiGhichu;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGUOITAO ( NUMBER ) 
    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public List<Tbdtokhaihq1> getToKhaiHQ() {
        return toKhaiHQ;
    }

    public void setToKhaiHQ(List<Tbdtokhaihq1> toKhaiHQ) {
        this.toKhaiHQ = toKhaiHQ;
    }

    public List<Tbddinhkem1> getTepDinhKem() {
        return tepDinhKem;
    }

    public void setTepDinhKem(List<Tbddinhkem1> tepDinhKem) {
        this.tepDinhKem = tepDinhKem;
    }

    public List<Tbdhanghoa1> getHangHoa1() {
        return hangHoa1;
    }

    public void setHangHoa1(List<Tbdhanghoa1> hangHoa1) {
        this.hangHoa1 = hangHoa1;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
    }

    public Date getFiNgayGui() {
        return fiNgayGui;
    }

    public void setFiNgayGui(Date fiNgayGui) {
        this.fiNgayGui = fiNgayGui;
    }

    public Long getFiIdTckt() {
        return fiIdTckt;
    }

    public void setFiIdTckt(Long fiIdTckt) {
        this.fiIdTckt = fiIdTckt;
    }

    public Long getFiIdTcdg() {
        return fiIdTcdg;
    }

    public void setFiIdTcdg(Long fiIdTcdg) {
        this.fiIdTcdg = fiIdTcdg;
    }

    public Long getFiIdCqxl() {
        return fiIdCqxl;
    }

    public void setFiIdCqxl(Long fiIdCqxl) {
        this.fiIdCqxl = fiIdCqxl;
    }

    public Long getFiLoai() {
        return fiLoai;
    }

    public void setFiLoai(Long fiLoai) {
        this.fiLoai = fiLoai;
    }

    public String getFiTenloai() {
        return fiTenloai;
    }

    public void setFiTenloai(String fiTenloai) {
        this.fiTenloai = fiTenloai;
    }

    public String getFiMaCqkt() {
        return fiMaCqkt;
    }

    public void setFiMaCqkt(String fiMaCqkt) {
        this.fiMaCqkt = fiMaCqkt;
    }

    public String getFiTenCqkt() {
        return fiTenCqkt;
    }

    public void setFiTenCqkt(String fiTenCqkt) {
        this.fiTenCqkt = fiTenCqkt;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Date getFiNgayThongBao() {
        return fiNgayThongBao;
    }

    public void setFiNgayThongBao(Date fiNgayThongBao) {
        this.fiNgayThongBao = fiNgayThongBao;
    }

    public String getFiSoThongBao() {
        return fiSoThongBao;
    }

    public void setFiSoThongBao(String fiSoThongBao) {
        this.fiSoThongBao = fiSoThongBao;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[fiIdHoso:");
        sb.append(fiIdHoso);
        sb.append("]:fiMaTckt:");
        sb.append(fiMaTckt);
        sb.append("|fiTenTcht:");
        sb.append(fiTenTcht);
        sb.append("|fiMst:");
        sb.append(fiMst);
        sb.append("|fiNguoiNk:");
        sb.append(fiNguoiNk);
        sb.append("|fiDiachiNnk:");
        sb.append(fiDiachiNnk);
        sb.append("|fiDtNnk:");
        sb.append(fiDtNnk);
        sb.append("|fiFaxNnk:");
        sb.append(fiFaxNnk);
        sb.append("|fiEmailNnk:");
        sb.append(fiEmailNnk);
        sb.append("|fiNguoiLh:");
        sb.append(fiNguoiLh);
        sb.append("|fiTuNgay:");
        sb.append(fiTuNgay);
        sb.append("|fiDenNgay:");
        sb.append(fiDenNgay);
        sb.append("|fiDiachiKho:");
        sb.append(fiDiachiKho);
        sb.append("|fiMaQcvn:");
        sb.append(fiMaQcvn);
        sb.append("|fiTenQcvn:");
        sb.append(fiTenQcvn);
        sb.append("|fiMaTcdg:");
        sb.append(fiMaTcdg);
        sb.append("|fiTenTcdg:");
        sb.append(fiTenTcdg);
        sb.append("|fiGhichu:");
        sb.append(fiGhichu);
        sb.append("|fiNgaytao:");
        sb.append(fiNgaytao);
        sb.append("|fiHoatdong:");
        sb.append(fiHoatdong);
        sb.append("|fiNguoitao:");
        sb.append(fiNguoitao);
        sb.append("|toKhaiHQ_size:");
        if (toKhaiHQ != null) {
            sb.append(toKhaiHQ.size());
        }

        return sb.toString();
    }

}
