package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBDKETQUAXULYHOSO1", schema = "SBV")
public class KetQuaXuLyHoSo1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDKETQUAXULYHOSO1_SEQ")
	@SequenceGenerator(sequenceName = "TBDKETQUAXULYHOSO1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBDKETQUAXULYHOSO1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDKQXULYHS")
	private long idKetQuanXuLyHoSo;
	public void setIdKetQuanXuLyHoSo(long idKetQuanXuLyHoSo) {
		this.idKetQuanXuLyHoSo = idKetQuanXuLyHoSo;
	}
	public long getIdKetQuanXuLyHoSo() {
		return this.idKetQuanXuLyHoSo;
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

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_NGAYXULY")
	private Date ngayXuLy;
	public void setNgayXuLy(Date ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}
	public Date getNgayXuLy() {
		return this.ngayXuLy;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_DONVIXULY")
	private String donViXuLy;
	public void setDonViXuLy(String donViXuLy) {
		this.donViXuLy = donViXuLy;
	}
	public String getDonViXuLy() {
		return this.donViXuLy;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_CHUYENVIENXL")
	private String chuyenVienXuLy;
	public void setChuyenVienXuLy(String chuyenVienXuLy) {
		this.chuyenVienXuLy = chuyenVienXuLy;
	}
	public String getChuyenVienXuLy() {
		return this.chuyenVienXuLy;
	}

	@Size(max = 2000)
	@Column(nullable = true, updatable = true, name = "FI_NOIDUNGXULY")
	private String noiDungXuLy;
	public void setNoiDungXuLy(String noiDungXuLy) {
		this.noiDungXuLy = noiDungXuLy;
	}
	public String getNoiDungXuLy() {
		return this.noiDungXuLy;
	}

	@Size(max = 20)
	@Column(nullable = true, updatable = true, name = "FI_MALOAITEPDK")
	private String maLoaiTepDinhKem;
	public void setMaLoaiTepDinhKem(String maLoaiTepDinhKem) {
		this.maLoaiTepDinhKem = maLoaiTepDinhKem;
	}
	public String getMaLoaiTepDinhKem() {
		return this.maLoaiTepDinhKem;
	}

	@Size(max = 255)
	@Column(nullable = true, updatable = true, name = "FI_TENLOAITEPDK")
	private String tenLoaiTepDinhKem;
	public void setTenLoaiTepDinhKem(String tenLoaiTepDinhKem) {
		this.tenLoaiTepDinhKem = tenLoaiTepDinhKem;
	}
	public String getTenLoaiTepDinhKem() {
		return this.tenLoaiTepDinhKem;
	}

	@Size(max = 255)
	@Column(nullable = true, updatable = true, name = "FI_TENTEPDK")
	private String tenTepDinhKem;
	public void setTenTepDinhKem(String tenTepDinhKem) {
		this.tenTepDinhKem = tenTepDinhKem;
	}
	public String getTenTepDinhKem() {
		return this.tenTepDinhKem;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_TRANGTHAI")
	private int trangThai;
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getTrangThai() {
		return this.trangThai;
	}

	@Size(max = 255)
	@Column(nullable = true, updatable = true, name = "FI_GUID")
	private String guID;
	public void setGuID(String guID) {
		this.guID = guID;
	}
	public String getGuID() {
		return this.guID;
	}

	@Size(max = 255)
	@Column(nullable = true, updatable = true, name = "FI_DUONGDAN")
	private String duongDanFile;
	public void setDuongDanFile(String duongDanFile) {
		this.duongDanFile = duongDanFile;
	}
	public String getDuongDanFile() {
		return this.duongDanFile;
	}
	
	@Column(name = "FI_NGAYTAO", columnDefinition = "TIMESTAMP(6)")
	private Date ngayTao;
	

	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("KetQuaXuLyHoSo1 { ");
		stringBuilder.append("idKetQuanXuLyHoSo=" + idKetQuanXuLyHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayXuLy=" + ngayXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("donViXuLy=" + donViXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("chuyenVienXuLy=" + chuyenVienXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("noiDungXuLy=" + noiDungXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTepDinhKem=" + maLoaiTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenLoaiTepDinhKem=" + tenLoaiTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTepDinhKem=" + tenTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThai=" + trangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("guID=" + guID); 
		stringBuilder.append(", "); 
		stringBuilder.append("duongDanFile=" + duongDanFile); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}