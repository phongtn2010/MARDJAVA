package com.nsw.mt.model;
import javax.persistence.*;
import java.util.Date;

public class Tbddangky {
    private Long fiDangkyId;
    private Long fiTenBophanId;
    private String fiTenBophan;
    private String fiTenDoanhnghiep;
    private String fiMatinh;
    private String fiMahuyen;
    private String fiMaphuong;
    private String fiDiachi;
    private String fiDienthoai;
    private String fiFax;
    private String fiGiayphepkinhdoanh;
    private Date fiNgaydangky;
    private String fiCoquancapphep;
    private String fiSochungchi;
    private Date fiNgaycapchungchi;
    private String fiCoquancapchungchi;
    @Basic
    @Column(name = "FI_MUCDICH")
    private String fiMucdich;
    @Basic
    @Column(name = "FI_LOAIKINHDOANH")
    private String fiLoaikinhdoanh;
    @Basic
    @Column(name = "FI_TINHDI")
    private String fiTinhdi;
    @Basic
    @Column(name = "FI_GADI")
    private String fiGadi;
    @Basic
    @Column(name = "FI_TINHDEN")
    private String fiTinhden;
    @Basic
    @Column(name = "FI_GADEN")
    private String fiGaden;
    @Basic
    @Column(name = "FI_QUANGDUONG")
    private String fiQuangduong;
    @Basic
    @Column(name = "FI_MATUYEN")
    private String fiMatuyen;
    @Basic
    @Column(name = "FI_MOTATUYEN")
    private String fiMotatuyen;
    @Basic
    @Column(name = "FI_SOGIAYTOCHAPTHUAN")
    private String fiSogiaytochapthuan;
    @Basic
    @Column(name = "FI_NGAYCHAPTHUAN")
    private Date fiNgaychapthuan;
    @Basic
    @Column(name = "FI_NGAYKETTHUC")
    private Date fiNgayketthuc;
    @Basic
    @Column(name = "FI_THUTUC_ID")
    private Integer fiThutucId;
    @Basic
    @Column(name = "FI_TEN_THUTUC")
    private String fiTenThutuc;
    @Basic
    @Column(name = "FI_NGUOITAO")

    private String fiNguoitao;
    @Basic
    @Column(name = "FI_MANGUOITAO")
    private String fiManguoitao;
    @Basic
    @Column(name = "FI_TRANGTHAI")
    private Integer fiTrangthai;
    @Basic
    @Column(name = "FI_TEN_TRANGTHAI")
    private String fiTenTrangthai;
    @Basic
    @Column(name = "FI_NGAYTAO")
    private Date fiNgaytao;
    @Basic
    @Column(name = "FI_NGAYCAPPHEP")
    private Date fiNgaycapphep;
    @Basic
    @Column(name = "FI_NGAYGUI")
    private Date fiNgaygui;
    @Basic
    @Column(name = "FI_NGAYNHAN")
    private Date fiNgaynhan;
    @Basic
    @Column(name = "FI_MA_HOSO")
    private String fiMaHoSo;
    @Basic
    @Column(name = "fi_giayphep_id")
    private Long fiGiayPhepId;
    @Column(name = "FI_LYDORUT")
    private String fiLydorut;
    @Column(name = "fi_loaihinh")
    private String fiLoaiHinh;
    @Column(name = "fi_lydocaplai")
    private String fiLyDoCap;

    public Long getFiDangkyId() {
        return fiDangkyId;
    }

    public void setFiDangkyId(Long fiDangkyId) {
        this.fiDangkyId = fiDangkyId;
    }

    public Long getFiTenBophanId() {
        return fiTenBophanId;
    }

    public void setFiTenBophanId(Long fiTenBophanId) {
        this.fiTenBophanId = fiTenBophanId;
    }

    public String getFiTenBophan() {
        return fiTenBophan;
    }

    public void setFiTenBophan(String fiTenBophan) {
        this.fiTenBophan = fiTenBophan;
    }

    public String getFiTenDoanhnghiep() {
        return fiTenDoanhnghiep;
    }

    public void setFiTenDoanhnghiep(String fiTenDoanhnghiep) {
        this.fiTenDoanhnghiep = fiTenDoanhnghiep;
    }

    public String getFiMatinh() {
        return fiMatinh;
    }

    public void setFiMatinh(String fiMatinh) {
        this.fiMatinh = fiMatinh;
    }

    public String getFiMahuyen() {
        return fiMahuyen;
    }

    public void setFiMahuyen(String fiMahuyen) {
        this.fiMahuyen = fiMahuyen;
    }

    public String getFiMaphuong() {
        return fiMaphuong;
    }

    public void setFiMaphuong(String fiMaphuong) {
        this.fiMaphuong = fiMaphuong;
    }

    public String getFiDiachi() {
        return fiDiachi;
    }

    public void setFiDiachi(String fiDiachi) {
        this.fiDiachi = fiDiachi;
    }

    public String getFiDienthoai() {
        return fiDienthoai;
    }

    public void setFiDienthoai(String fiDienthoai) {
        this.fiDienthoai = fiDienthoai;
    }

    public String getFiFax() {
        return fiFax;
    }

    public void setFiFax(String fiFax) {
        this.fiFax = fiFax;
    }

    public String getFiGiayphepkinhdoanh() {
        return fiGiayphepkinhdoanh;
    }

    public void setFiGiayphepkinhdoanh(String fiGiayphepkinhdoanh) {
        this.fiGiayphepkinhdoanh = fiGiayphepkinhdoanh;
    }

    public Date getFiNgaydangky() {
        return fiNgaydangky;
    }

    public void setFiNgaydangky(Date fiNgaydangky) {
        this.fiNgaydangky = fiNgaydangky;
    }

    public String getFiCoquancapphep() {
        return fiCoquancapphep;
    }

    public void setFiCoquancapphep(String fiCoquancapphep) {
        this.fiCoquancapphep = fiCoquancapphep;
    }

    public String getFiSochungchi() {
        return fiSochungchi;
    }

    public void setFiSochungchi(String fiSochungchi) {
        this.fiSochungchi = fiSochungchi;
    }

    public Date getFiNgaycapchungchi() {
        return fiNgaycapchungchi;
    }

    public void setFiNgaycapchungchi(Date fiNgaycapchungchi) {
        this.fiNgaycapchungchi = fiNgaycapchungchi;
    }

    public String getFiCoquancapchungchi() {
        return fiCoquancapchungchi;
    }

    public void setFiCoquancapchungchi(String fiCoquancapchungchi) {
        this.fiCoquancapchungchi = fiCoquancapchungchi;
    }

    public String getFiMucdich() {
        return fiMucdich;
    }

    public void setFiMucdich(String fiMucdich) {
        this.fiMucdich = fiMucdich;
    }

    public String getFiLoaikinhdoanh() {
        return fiLoaikinhdoanh;
    }

    public void setFiLoaikinhdoanh(String fiLoaikinhdoanh) {
        this.fiLoaikinhdoanh = fiLoaikinhdoanh;
    }

    public String getFiTinhdi() {
        return fiTinhdi;
    }

    public void setFiTinhdi(String fiTinhdi) {
        this.fiTinhdi = fiTinhdi;
    }

    public String getFiGadi() {
        return fiGadi;
    }

    public void setFiGadi(String fiGadi) {
        this.fiGadi = fiGadi;
    }

    public String getFiTinhden() {
        return fiTinhden;
    }

    public void setFiTinhden(String fiTinhden) {
        this.fiTinhden = fiTinhden;
    }

    public String getFiGaden() {
        return fiGaden;
    }

    public void setFiGaden(String fiGaden) {
        this.fiGaden = fiGaden;
    }

    public String getFiQuangduong() {
        return fiQuangduong;
    }

    public void setFiQuangduong(String fiQuangduong) {
        this.fiQuangduong = fiQuangduong;
    }

    public String getFiMatuyen() {
        return fiMatuyen;
    }

    public void setFiMatuyen(String fiMatuyen) {
        this.fiMatuyen = fiMatuyen;
    }

    public String getFiMotatuyen() {
        return fiMotatuyen;
    }

    public void setFiMotatuyen(String fiMotatuyen) {
        this.fiMotatuyen = fiMotatuyen;
    }

    public String getFiSogiaytochapthuan() {
        return fiSogiaytochapthuan;
    }

    public void setFiSogiaytochapthuan(String fiSogiaytochapthuan) {
        this.fiSogiaytochapthuan = fiSogiaytochapthuan;
    }

    public Date getFiNgaychapthuan() {
        return fiNgaychapthuan;
    }

    public void setFiNgaychapthuan(Date fiNgaychapthuan) {
        this.fiNgaychapthuan = fiNgaychapthuan;
    }

    public Date getFiNgayketthuc() {
        return fiNgayketthuc;
    }

    public void setFiNgayketthuc(Date fiNgayketthuc) {
        this.fiNgayketthuc = fiNgayketthuc;
    }

    public Integer getFiThutucId() {
        return fiThutucId;
    }

    public void setFiThutucId(Integer fiThutucId) {
        this.fiThutucId = fiThutucId;
    }

    public String getFiTenThutuc() {
        return fiTenThutuc;
    }

    public void setFiTenThutuc(String fiTenThutuc) {
        this.fiTenThutuc = fiTenThutuc;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiManguoitao() {
        return fiManguoitao;
    }

    public void setFiManguoitao(String fiManguoitao) {
        this.fiManguoitao = fiManguoitao;
    }

    public Integer getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Integer fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTrangthai() {
        return fiTenTrangthai;
    }

    public void setFiTenTrangthai(String fiTenTrangthai) {
        this.fiTenTrangthai = fiTenTrangthai;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaycapphep() {
        return fiNgaycapphep;
    }

    public void setFiNgaycapphep(Date fiNgaycapphep) {
        this.fiNgaycapphep = fiNgaycapphep;
    }

    public Date getFiNgaygui() {
        return fiNgaygui;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    public Date getFiNgaynhan() {
        return fiNgaynhan;
    }

    public void setFiNgaynhan(Date fiNgaynhan) {
        this.fiNgaynhan = fiNgaynhan;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
    }

    public Long getFiGiayPhepId() {
        return fiGiayPhepId;
    }

    public void setFiGiayPhepId(Long fiGiayPhepId) {
        this.fiGiayPhepId = fiGiayPhepId;
    }

    public String getFiLydorut() {
        return fiLydorut;
    }

    public void setFiLydorut(String fiLydorut) {
        this.fiLydorut = fiLydorut;
    }

    public String getFiLoaiHinh() {
        return fiLoaiHinh;
    }

    public void setFiLoaiHinh(String fiLoaiHinh) {
        this.fiLoaiHinh = fiLoaiHinh;
    }

    public String getFiLyDoCap() {
        return fiLyDoCap;
    }

    public void setFiLyDoCap(String fiLyDoCap) {
        this.fiLyDoCap = fiLyDoCap;
    }
}
