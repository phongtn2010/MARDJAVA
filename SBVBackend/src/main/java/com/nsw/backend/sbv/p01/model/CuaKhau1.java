package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBSCUAKHAU1", schema = "SBV")
public class CuaKhau1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBSCUAKHAU1_SEQ")
	@SequenceGenerator(sequenceName = "TBSCUAKHAU1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBSCUAKHAU1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDCUAKHAU")
	private long idCuaKhau;
	public void setIdCuaKhau(long idCuaKhau) {
		this.idCuaKhau = idCuaKhau;
	}
	public long getIdCuaKhau() {
		return this.idCuaKhau;
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("CuaKhau1 { ");
		stringBuilder.append("idCuaKhau=" + idCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("maChiNhanh=" + maChiNhanh); 
		stringBuilder.append(", "); 
		stringBuilder.append("maCuaKhau=" + maCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}