package com.nsw.mard.p03.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class TbdHoSo03 implements Serializable {

	private Long fiIdHoSo;
	private String fiMaHoSo;
	private String fiTrangThai;
	private Date fiNgayTao;
	private String fiSoDonKhaiBao;
	private String fiSoCongVanCap;
	private String fiMaCQ;
	private String fiTenCQ;
	private String fiMaNoiDK;
	private String fiTenNoiDK;
	private String fiTenDn;
	private String fiMstDn;
	private String fiDiaChiDn;
	private String fiSdtDn;
	private String fiFaxDn;
	private String fiEmailDn;
	private String fiNoiKy;
	private Date fiNgayKy;
	private String fiNguoiKy;
	private String fiSoHopDongCt;
	private Long fiGiaTriLoHang;
	private String fiGcnXk;
	private Date fiNgayCapGcnXk;
	private String fiToChucXk;
	private String fiMaNuocXk;
	private String fiTenNuocXk;
	private String fiMaCuaKhauXuat;
	private String fiTenCuaKhauXuat;
	private String fiToChucNk;
	private String fiMaNuocNk;
	private String fiTenNuocNk;
	private String fiPtVanChuyen;
	private String fiMaCuaKhauNhap;
	private String fiTenCuaKhauNhap;
	private String fiMucDichSuDung;
	private String fiVbChapThuanKiemDich;
	private String fiDiaDiemKiemDich;
	private Date fiTgKiemDichTu;
	private Date fiTgKiemDichDen;
	private String fiDiaDiemGs;
	private Date fiTgGsTu;
	private Date fiTgGsDen;
	private String fiSoGcnKiemDich;
	private Long fiTrangThaiMa;
	private Long fiMaLoaiSp;
	private String fiTenLoaiSp;
	private String fiSoGcnKdNk;
	private Long isActive;
	private Date fiNgayGui;
	private List<TbdHangHoa03> lstHangHoa03;
	private List<TbdDinhKem03> lstTepTin03;

	public Long getFiIdHoSo() {
		return fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public String getFiMaHoSo() {
		return fiMaHoSo;
	}

	public void setFiMaHoSo(String fiMaHoSo) {
		this.fiMaHoSo = fiMaHoSo;
	}

	public String getFiTrangThai() {
		return fiTrangThai;
	}

	public void setFiTrangThai(String fiTrangThai) {
		this.fiTrangThai = fiTrangThai;
	}

	public Date getFiNgayTao() {
		return fiNgayTao;
	}

	public void setFiNgayTao(Date fiNgayTao) {
		this.fiNgayTao = fiNgayTao;
	}

	public String getFiSoDonKhaiBao() {
		return fiSoDonKhaiBao;
	}

	public void setFiSoDonKhaiBao(String fiSoDonKhaiBao) {
		this.fiSoDonKhaiBao = fiSoDonKhaiBao;
	}

	public String getFiSoCongVanCap() {
		return fiSoCongVanCap;
	}

	public void setFiSoCongVanCap(String fiSoCongVanCap) {
		this.fiSoCongVanCap = fiSoCongVanCap;
	}

	public String getFiMaCQ() {
		return fiMaCQ;
	}

	public void setFiMaCQ(String fiMaCQ) {
		this.fiMaCQ = fiMaCQ;
	}

	public String getFiTenCQ() {
		return fiTenCQ;
	}

	public void setFiTenCQ(String fiTenCQ) {
		this.fiTenCQ = fiTenCQ;
	}

	public String getFiMaNoiDK() {
		return fiMaNoiDK;
	}

	public void setFiMaNoiDK(String fiMaNoiDK) {
		this.fiMaNoiDK = fiMaNoiDK;
	}

	public String getFiTenNoiDK() {
		return fiTenNoiDK;
	}

	public void setFiTenNoiDK(String fiTenNoiDK) {
		this.fiTenNoiDK = fiTenNoiDK;
	}

	public String getFiTenDn() {
		return fiTenDn;
	}

	public void setFiTenDn(String fiTenDn) {
		this.fiTenDn = fiTenDn;
	}

	public String getFiMstDn() {
		return fiMstDn;
	}

	public void setFiMstDn(String fiMstDn) {
		this.fiMstDn = fiMstDn;
	}

	public String getFiDiaChiDn() {
		return fiDiaChiDn;
	}

	public void setFiDiaChiDn(String fiDiaChiDn) {
		this.fiDiaChiDn = fiDiaChiDn;
	}

	public String getFiSdtDn() {
		return fiSdtDn;
	}

	public void setFiSdtDn(String fiSdtDn) {
		this.fiSdtDn = fiSdtDn;
	}

	public String getFiFaxDn() {
		return fiFaxDn;
	}

	public void setFiFaxDn(String fiFaxDn) {
		this.fiFaxDn = fiFaxDn;
	}

	public String getFiEmailDn() {
		return fiEmailDn;
	}

	public void setFiEmailDn(String fiEmailDn) {
		this.fiEmailDn = fiEmailDn;
	}

	public String getFiNoiKy() {
		return fiNoiKy;
	}

	public void setFiNoiKy(String fiNoiKy) {
		this.fiNoiKy = fiNoiKy;
	}

	public Date getFiNgayKy() {
		return fiNgayKy;
	}

	public void setFiNgayKy(Date fiNgayKy) {
		this.fiNgayKy = fiNgayKy;
	}

	public String getFiNguoiKy() {
		return fiNguoiKy;
	}

	public void setFiNguoiKy(String fiNguoiKy) {
		this.fiNguoiKy = fiNguoiKy;
	}

	public String getFiSoHopDongCt() {
		return fiSoHopDongCt;
	}

	public void setFiSoHopDongCt(String fiSoHopDongCt) {
		this.fiSoHopDongCt = fiSoHopDongCt;
	}

	public Long getFiGiaTriLoHang() {
		return fiGiaTriLoHang;
	}

	public void setFiGiaTriLoHang(Long fiGiaTriLoHang) {
		this.fiGiaTriLoHang = fiGiaTriLoHang;
	}

	public String getFiGcnXk() {
		return fiGcnXk;
	}

	public void setFiGcnXk(String fiGcnXk) {
		this.fiGcnXk = fiGcnXk;
	}

	public Date getFiNgayCapGcnXk() {
		return fiNgayCapGcnXk;
	}

	public void setFiNgayCapGcnXk(Date fiNgayCapGcnXk) {
		this.fiNgayCapGcnXk = fiNgayCapGcnXk;
	}

	public String getFiToChucXk() {
		return fiToChucXk;
	}

	public void setFiToChucXk(String fiToChucXk) {
		this.fiToChucXk = fiToChucXk;
	}

	public String getFiMaNuocXk() {
		return fiMaNuocXk;
	}

	public void setFiMaNuocXk(String fiMaNuocXk) {
		this.fiMaNuocXk = fiMaNuocXk;
	}

	public String getFiTenNuocXk() {
		return fiTenNuocXk;
	}

	public void setFiTenNuocXk(String fiTenNuocXk) {
		this.fiTenNuocXk = fiTenNuocXk;
	}

	public String getFiMaCuaKhauXuat() {
		return fiMaCuaKhauXuat;
	}

	public void setFiMaCuaKhauXuat(String fiMaCuaKhauXuat) {
		this.fiMaCuaKhauXuat = fiMaCuaKhauXuat;
	}

	public String getFiTenCuaKhauXuat() {
		return fiTenCuaKhauXuat;
	}

	public void setFiTenCuaKhauXuat(String fiTenCuaKhauXuat) {
		this.fiTenCuaKhauXuat = fiTenCuaKhauXuat;
	}

	public String getFiToChucNk() {
		return fiToChucNk;
	}

	public void setFiToChucNk(String fiToChucNk) {
		this.fiToChucNk = fiToChucNk;
	}

	public String getFiMaNuocNk() {
		return fiMaNuocNk;
	}

	public void setFiMaNuocNk(String fiMaNuocNk) {
		this.fiMaNuocNk = fiMaNuocNk;
	}

	public String getFiTenNuocNk() {
		return fiTenNuocNk;
	}

	public void setFiTenNuocNk(String fiTenNuocNk) {
		this.fiTenNuocNk = fiTenNuocNk;
	}

	public String getFiPtVanChuyen() {
		return fiPtVanChuyen;
	}

	public void setFiPtVanChuyen(String fiPtVanChuyen) {
		this.fiPtVanChuyen = fiPtVanChuyen;
	}

	public String getFiMaCuaKhauNhap() {
		return fiMaCuaKhauNhap;
	}

	public void setFiMaCuaKhauNhap(String fiMaCuaKhauNhap) {
		this.fiMaCuaKhauNhap = fiMaCuaKhauNhap;
	}

	public String getFiTenCuaKhauNhap() {
		return fiTenCuaKhauNhap;
	}

	public void setFiTenCuaKhauNhap(String fiTenCuaKhauNhap) {
		this.fiTenCuaKhauNhap = fiTenCuaKhauNhap;
	}

	public String getFiMucDichSuDung() {
		return fiMucDichSuDung;
	}

	public void setFiMucDichSuDung(String fiMucDichSuDung) {
		this.fiMucDichSuDung = fiMucDichSuDung;
	}

	public String getFiVbChapThuanKiemDich() {
		return fiVbChapThuanKiemDich;
	}

	public void setFiVbChapThuanKiemDich(String fiVbChapThuanKiemDich) {
		this.fiVbChapThuanKiemDich = fiVbChapThuanKiemDich;
	}

	public String getFiDiaDiemKiemDich() {
		return fiDiaDiemKiemDich;
	}

	public void setFiDiaDiemKiemDich(String fiDiaDiemKiemDich) {
		this.fiDiaDiemKiemDich = fiDiaDiemKiemDich;
	}

	public Date getFiTgKiemDichTu() {
		return fiTgKiemDichTu;
	}

	public void setFiTgKiemDichTu(Date fiTgKiemDichTu) {
		this.fiTgKiemDichTu = fiTgKiemDichTu;
	}

	public Date getFiTgKiemDichDen() {
		return fiTgKiemDichDen;
	}

	public void setFiTgKiemDichDen(Date fiTgKiemDichDen) {
		this.fiTgKiemDichDen = fiTgKiemDichDen;
	}

	public String getFiDiaDiemGs() {
		return fiDiaDiemGs;
	}

	public void setFiDiaDiemGs(String fiDiaDiemGs) {
		this.fiDiaDiemGs = fiDiaDiemGs;
	}

	public Date getFiTgGsTu() {
		return fiTgGsTu;
	}

	public void setFiTgGsTu(Date fiTgGsTu) {
		this.fiTgGsTu = fiTgGsTu;
	}

	public Date getFiTgGsDen() {
		return fiTgGsDen;
	}

	public void setFiTgGsDen(Date fiTgGsDen) {
		this.fiTgGsDen = fiTgGsDen;
	}

	public String getFiSoGcnKiemDich() {
		return fiSoGcnKiemDich;
	}

	public void setFiSoGcnKiemDich(String fiSoGcnKiemDich) {
		this.fiSoGcnKiemDich = fiSoGcnKiemDich;
	}

	public Long getFiTrangThaiMa() {
		return fiTrangThaiMa;
	}

	public void setFiTrangThaiMa(Long fiTrangThaiMa) {
		this.fiTrangThaiMa = fiTrangThaiMa;
	}

	public Long getFiMaLoaiSp() {
		return fiMaLoaiSp;
	}

	public void setFiMaLoaiSp(Long fiMaLoaiSp) {
		this.fiMaLoaiSp = fiMaLoaiSp;
	}

	public String getFiTenLoaiSp() {
		return fiTenLoaiSp;
	}

	public void setFiTenLoaiSp(String fiTenLoaiSp) {
		this.fiTenLoaiSp = fiTenLoaiSp;
	}

	public String getFiSoGcnKdNk() {
		return fiSoGcnKdNk;
	}

	public void setFiSoGcnKdNk(String fiSoGcnKdNk) {
		this.fiSoGcnKdNk = fiSoGcnKdNk;
	}

	public List<TbdHangHoa03> getLstHangHoa03() {
		return lstHangHoa03;
	}

	public void setLstHangHoa03(List<TbdHangHoa03> lstHangHoa03) {
		this.lstHangHoa03 = lstHangHoa03;
	}

	public List<TbdDinhKem03> getLstTepTin03() {
		return lstTepTin03;
	}

	public void setLstTepTin03(List<TbdDinhKem03> lstTepTin03) {
		this.lstTepTin03 = lstTepTin03;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	public Date getFiNgayGui() {
		return fiNgayGui;
	}

	public void setFiNgayGui(Date fiNgayGui) {
		this.fiNgayGui = fiNgayGui;
	}
}