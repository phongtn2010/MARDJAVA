package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBDGPTIENTE1", schema = "SBV")
public class GPTienTe1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDGPTIENTE1_SEQ")
	@SequenceGenerator(sequenceName = "TBDGPTIENTE1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBDGPTIENTE1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDTIENTECGXN")
	private long idCapGXNTienTe;
	public void setIdCapGXNTienTe(long idCapGXNTienTe) {
		this.idCapGXNTienTe = idCapGXNTienTe;
	}
	public long getIdCapGXNTienTe() {
		return this.idCapGXNTienTe;
	}

	@NotNull
	@Column(nullable = false, updatable = true, name = "FI_IDCAPGXNHS")
	private long idCapGXNHoSo;
	public void setIdCapGXNHoSo(long idCapGXNHoSo) {
		this.idCapGXNHoSo = idCapGXNHoSo;
	}
	public long getIdCapGXNHoSo() {
		return this.idCapGXNHoSo;
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("GPTienTe1 { ");
		stringBuilder.append("idCapGXNTienTe=" + idCapGXNTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("idCapGXNHoSo=" + idCapGXNHoSo); 
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