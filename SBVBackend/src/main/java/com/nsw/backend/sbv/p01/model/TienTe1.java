package com.nsw.backend.sbv.p01.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBDTIENTE1", schema = "SBV")
public class TienTe1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDTIENTE1_SEQ")
	@SequenceGenerator(sequenceName = "TBDTIENTE1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBDTIENTE1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDTIENTE")
	private long idTienTe;
	public void setIdTienTe(long idTienTe) {
		this.idTienTe = idTienTe;
	}
	public long getIdTienTe() {
		return this.idTienTe;
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
	@Column(nullable = false, updatable = true, name = "FI_SLNTBANGSO")
	private long soLuongNgoaiTeBangSo;
	public void setSoLuongNgoaiTeBangSo(long soLuongNgoaiTeBangSo) {
		this.soLuongNgoaiTeBangSo = soLuongNgoaiTeBangSo;
	}
	public long getSoLuongNgoaiTeBangSo() {
		return this.soLuongNgoaiTeBangSo;
	}

	@NotBlank
	@Size(max = 4000)
	@Column(nullable = false, updatable = true, name = "FI_SLNTBANGCHU")
	private String soLuongNgoaiTeBangChu;
	public void setSoLuongNgoaiTeBangChu(String soLuongNgoaiTeBangChu) {
		this.soLuongNgoaiTeBangChu = soLuongNgoaiTeBangChu;
	}
	public String getSoLuongNgoaiTeBangChu() {
		return this.soLuongNgoaiTeBangChu;
	}

	@NotBlank
	@Size(max = 20)
	@Column(nullable = false, updatable = true, name = "FI_MALOAITIENTE")
	private String maLoaiTienTe;
	public void setMaLoaiTienTe(String maLoaiTienTe) {
		this.maLoaiTienTe = maLoaiTienTe;
	}
	public String getMaLoaiTienTe() {
		return this.maLoaiTienTe;
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

		stringBuilder.append("TienTe1 { ");
		stringBuilder.append("idTienTe=" + idTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuongNgoaiTeBangSo=" + soLuongNgoaiTeBangSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuongNgoaiTeBangChu=" + soLuongNgoaiTeBangChu); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTienTe=" + maLoaiTienTe); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}