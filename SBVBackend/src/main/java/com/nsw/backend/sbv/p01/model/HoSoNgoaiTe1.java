package com.nsw.backend.sbv.p01.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "TBDHOSONGOAITE1", schema = "SBV")
public class HoSoNgoaiTe1 {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHOSONGOAITE1_SEQ")
	@SequenceGenerator(sequenceName = "TBDHOSONGOAITE1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBDHOSONGOAITE1_SEQ")
	@Column(nullable = false, updatable = true, name = "PK_IDHOSO")
	private Long idHoSo;

	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}

	public Long getIdHoSo() {
		return this.idHoSo;
	}

	@NotBlank
	@Size(max = 20)
	@Column(nullable = false, updatable = true, name = "FI_MACHINHANH")
	private String maChiNhanh;

	public void setMaChiNhanh(String maChiNhanh) {
		this.maChiNhanh = maChiNhanh;
	}

	public String getMaChiNhanh() {
		return this.maChiNhanh;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_TENCHINHANH")
	private String tenChiNhanh;

	public void setTenChiNhanh(String tenChiNhanh) {
		this.tenChiNhanh = tenChiNhanh;
	}

	public String getTenChiNhanh() {
		return this.tenChiNhanh;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_HINHTHUCXNK")
	private int hinhThucXNK;

	public void setHinhThucXNK(int hinhThucXNK) {
		this.hinhThucXNK = hinhThucXNK;
	}

	public int getHinhThucXNK() {
		return this.hinhThucXNK;
	}

	@NotBlank
	@Size(max = 20)
	@Column(nullable = false, updatable = true, name = "FI_MASOTHUE")
	private String maSoThue;

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getMaSoThue() {
		return this.maSoThue;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_TENNGANHANG")
	private String tenNganHang;

	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}

	public String getTenNganHang() {
		return this.tenNganHang;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_DIACHI")
	private String diaChi;

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	@NotBlank
	@Size(max = 50)
	@Column(nullable = false, updatable = true, name = "FI_DIENTHOAI")
	private String dienThoai;

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getDienThoai() {
		return this.dienThoai;
	}

	@Size(max = 50)
	@Column(nullable = true, updatable = true, name = "FI_FAX")
	private String fax;

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return this.fax;
	}

	@NotBlank
	@Size(max = 20)
	@Column(nullable = false, updatable = true, name = "FI_MACUAKHAU")
	private String maCuaKhau;

	public void setMaCuaKhau(String maCuaKhau) {
		this.maCuaKhau = maCuaKhau;
	}

	public String getMaCuaKhau() {
		return this.maCuaKhau;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_TENCUAKHAU")
	private String tenCuaKhau;

	public void setTenCuaKhau(String tenCuaKhau) {
		this.tenCuaKhau = tenCuaKhau;
	}

	public String getTenCuaKhau() {
		return this.tenCuaKhau;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_XNKTUNGAY")
	private Date xuatNhapKhauTuNgay;

	public void setXuatNhapKhauTuNgay(Date xuatNhapKhauTuNgay) {
		this.xuatNhapKhauTuNgay = xuatNhapKhauTuNgay;
	}

	public Date getXuatNhapKhauTuNgay() {
		return this.xuatNhapKhauTuNgay;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_XNKDENNGAY")
	private Date xuatNhapKhauDenNgay;

	public void setXuatNhapKhauDenNgay(Date xuatNhapKhauDenNgay) {
		this.xuatNhapKhauDenNgay = xuatNhapKhauDenNgay;
	}

	public Date getXuatNhapKhauDenNgay() {
		return this.xuatNhapKhauDenNgay;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_CAPGPLANDAU")
	private boolean capGiayPhepLanDau;

	public void setCapGiayPhepLanDau(boolean capGiayPhepLanDau) {
		this.capGiayPhepLanDau = capGiayPhepLanDau;
	}

	public boolean isCapGiayPhepLanDau() {
		return this.capGiayPhepLanDau;
	}

	@Size(max = 255)
	@Column(nullable = true, updatable = true, name = "FI_SOGPDACAP")
	private String soGiayPhepDaCap;

	public void setSoGiayPhepDaCap(String soGiayPhepDaCap) {
		this.soGiayPhepDaCap = soGiayPhepDaCap;
	}

	public String getSoGiayPhepDaCap() {
		return this.soGiayPhepDaCap;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_DOITACXNK")
	private String doiTacXuatNhapKhau;

	public void setDoiTacXuatNhapKhau(String doiTacXuatNhapKhau) {
		this.doiTacXuatNhapKhau = doiTacXuatNhapKhau;
	}

	public String getDoiTacXuatNhapKhau() {
		return this.doiTacXuatNhapKhau;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_NGAYTAO")
	private Date ngayTao;

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayTao() {
		return this.ngayTao;
	}

	@Column(nullable = true, updatable = true, name = "FI_TRANGTHAI")
	private int trangThai;

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	@Column(nullable = true, updatable = true, name = "FI_XOAHOSO")
	private boolean xoaHoSo;

	public void setXoaHoSo(boolean xoaHoSo) {
		this.xoaHoSo = xoaHoSo;
	}

	public boolean isXoaHoSo() {
		return this.xoaHoSo;
	}

	@Size(max = 20)
	@Column(nullable = false, updatable = true, name = "FI_MAHOSO")
	private String maHoSo;

	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}

	public String getMaHoSo() {
		return this.maHoSo;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "hoSo")
	@JoinColumn(name = "PK_IDHOSO", updatable = false, unique = false, insertable = false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private GiayPhep1 giayPhep;

	public GiayPhep1 getGiayPhep() {
		return giayPhep;
	}

	public void setGiayPhep(GiayPhep1 giayPhep) {
		this.giayPhep = giayPhep;
	}

	@Size(max = 2000)
	@Column(name = "FI_GHICHU")
	private String ghiChu;

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("HoSoNgoaiTe1 { ");
		stringBuilder.append("idHoSo=" + idHoSo);
		stringBuilder.append(", ");
		stringBuilder.append("maChiNhanh=" + maChiNhanh);
		stringBuilder.append(", ");
		stringBuilder.append("tenChiNhanh=" + tenChiNhanh);
		stringBuilder.append(", ");
		stringBuilder.append("hinhThucXNK=" + hinhThucXNK);
		stringBuilder.append(", ");
		stringBuilder.append("maSoThue=" + maSoThue);
		stringBuilder.append(", ");
		stringBuilder.append("tenNganHang=" + tenNganHang);
		stringBuilder.append(", ");
		stringBuilder.append("diaChi=" + diaChi);
		stringBuilder.append(", ");
		stringBuilder.append("dienThoai=" + dienThoai);
		stringBuilder.append(", ");
		stringBuilder.append("fax=" + fax);
		stringBuilder.append(", ");
		stringBuilder.append("maCuaKhau=" + maCuaKhau);
		stringBuilder.append(", ");
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau);
		stringBuilder.append(", ");
		stringBuilder.append("xuatNhapKhauTuNgay=" + xuatNhapKhauTuNgay);
		stringBuilder.append(", ");
		stringBuilder.append("xuatNhapKhauDenNgay=" + xuatNhapKhauDenNgay);
		stringBuilder.append(", ");
		stringBuilder.append("capGiayPhepLanDau=" + capGiayPhepLanDau);
		stringBuilder.append(", ");
		stringBuilder.append("soGiayPhepDaCap=" + soGiayPhepDaCap);
		stringBuilder.append(", ");
		stringBuilder.append("doiTacXuatNhapKhau=" + doiTacXuatNhapKhau);
		stringBuilder.append(", ");
		stringBuilder.append("ngayTao=" + ngayTao);
		stringBuilder.append(", ");
		stringBuilder.append("trangThai=" + trangThai);
		stringBuilder.append(", ");
		stringBuilder.append("xoaHoSo=" + xoaHoSo);
		stringBuilder.append(", ");
		stringBuilder.append("maHoSo=" + maHoSo);
		stringBuilder.append(" }");

		return stringBuilder.toString();
	}
}