package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "TBDTHONGTINGP1", schema = "SBV")
public class GiayPhep1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDTHONGTINGP1_SEQ")
	@SequenceGenerator(sequenceName = "TBDTHONGTINGP1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBDTHONGTINGP1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDCAPGXNHS")
	private long idCapGXNHoSo;

	public void setIdCapGXNHoSo(long idCapGXNHoSo) {
		this.idCapGXNHoSo = idCapGXNHoSo;
	}

	public long getIdCapGXNHoSo() {
		return this.idCapGXNHoSo;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_IDHOSO")
	private long idHoSo;

	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}

	public long getIdHoSo() {
		return this.idHoSo;
	}

	@NotBlank
	@Size(max = 20)
	@Column(nullable = false, updatable = true, name = "FI_SOGIAYPHEP")
	private String soGiayPhep;

	public void setSoGiayPhep(String soGiayPhep) {
		this.soGiayPhep = soGiayPhep;
	}

	public String getSoGiayPhep() {
		return this.soGiayPhep;
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

	@Column(updatable = true, name = "FI_XNK_TU_NGAY")
	private Date ngayXuatNhapKhauTu;

	public void setNgayXuatNhapKhauTu(Date ngayXuatNhapKhauTu) {
		this.ngayXuatNhapKhauTu = ngayXuatNhapKhauTu;
	}

	public Date getNgayXuatNhapKhauTu() {
		return this.ngayXuatNhapKhauTu;
	}

	@Column(updatable = true, name = "FI_XNK_DEN_NGAY")
	private Date ngayXuatNhapKhauDen;

	public void setNgayXuatNhapKhauDen(Date ngayXuatNhapKhauDen) {
		this.ngayXuatNhapKhauDen = ngayXuatNhapKhauDen;
	}

	public Date getNgayXuatNhapKhauDen() {
		return ngayXuatNhapKhauDen;
	}

	@Size(max = 20)
	@Column(updatable = true, name = "FI_MALOAITEPDK")
	private String maLoaiTepDinhKem;

	public void setMaLoaiTepDinhKem(String maLoaiTepDinhKem) {
		this.maLoaiTepDinhKem = maLoaiTepDinhKem;
	}

	public String getMaLoaiTepDinhKem() {
		return this.maLoaiTepDinhKem;
	}

	@Size(max = 2000)
	@Column(name = "FI_TENLOAITEPDK")
	private String tenLoaiTepDinhKem;

	public void setTenLoaiTepDinhKem(String tenLoaiTepDinhKem) {
		this.tenLoaiTepDinhKem = tenLoaiTepDinhKem;
	}

	public String getTenLoaiTepDinhKem() {
		return this.tenLoaiTepDinhKem;
	}

	@Size(max = 2000)
	@Column(name = "FI_TENTEPDK")
	private String tenTepDinhKem;

	public void setTenTepDinhKem(String tenTepDinhKem) {
		this.tenTepDinhKem = tenTepDinhKem;
	}

	public String getTenTepDinhKem() {
		return this.tenTepDinhKem;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_NGUOIKY")
	private String nguoiKy;

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public String getNguoiKy() {
		return this.nguoiKy;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_NGAYCAP")
	private Date ngayCap;

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public Date getNgayCap() {
		return this.ngayCap;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_NGAYHETHAN")
	private Date ngayHetHan;

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public Date getNgayHetHan() {
		return this.ngayHetHan;
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

	@Size(max = 255)
	@Column(name = "FI_GUID")
	private String guID;

	public void setGuID(String guID) {
		this.guID = guID;
	}

	public String getGuID() {
		return this.guID;
	}

	@Size(max = 255)
	@Column(name = "FI_DUONGDAN")
	private String duongDanFile;

	public void setDuongDanFile(String duongDanFile) {
		this.duongDanFile = duongDanFile;
	}

	public String getDuongDanFile() {
		return this.duongDanFile;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_MACOQUAN")
	private String maCoQuan;

	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}

	public String getMaCoQuan() {
		return this.maCoQuan;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_TENCOQUAN")
	private String tenCoQuan;

	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}

	public String getTenCoQuan() {
		return this.tenCoQuan;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "FI_IDHOSO", updatable = false, unique = false, insertable = false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private HoSoNgoaiTe1 hoSo;

	public HoSoNgoaiTe1 getHoSo() {
		return hoSo;
	}

	public void setHoSo(HoSoNgoaiTe1 hoSo) {
		this.hoSo = hoSo;
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

		stringBuilder.append("GiayPhep1 { ");
		stringBuilder.append("idCapGXNHoSo=" + idCapGXNHoSo);
		stringBuilder.append(", ");
		stringBuilder.append("idHoSo=" + idHoSo);
		stringBuilder.append(", ");
		stringBuilder.append("soGiayPhep=" + soGiayPhep);
		stringBuilder.append(", ");
		stringBuilder.append("maCuaKhau=" + maCuaKhau);
		stringBuilder.append(", ");
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau);
		stringBuilder.append(", ");
		stringBuilder.append("maLoaiTepDinhKem=" + maLoaiTepDinhKem);
		stringBuilder.append(", ");
		stringBuilder.append("tenLoaiTepDinhKem=" + tenLoaiTepDinhKem);
		stringBuilder.append(", ");
		stringBuilder.append("tenTepDinhKem=" + tenTepDinhKem);
		stringBuilder.append(", ");
		stringBuilder.append("nguoiKy=" + nguoiKy);
		stringBuilder.append(", ");
		stringBuilder.append("ngayCap=" + ngayCap);
		stringBuilder.append(", ");
		stringBuilder.append("ngayHetHan=" + ngayHetHan);
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
		stringBuilder.append("guID=" + guID);
		stringBuilder.append(", ");
		stringBuilder.append("duongDanFile=" + duongDanFile);
		stringBuilder.append(", ");
		stringBuilder.append("maCoQuan=" + maCoQuan);
		stringBuilder.append(", ");
		stringBuilder.append("tenCoQuan=" + tenCoQuan);
		stringBuilder.append(" }");

		return stringBuilder.toString();
	}
}