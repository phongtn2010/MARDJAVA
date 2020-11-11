package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBSCHINHANHNGANHANG1", schema = "SBV")
public class ChiNhanhNganHang1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBSCHINHANHNGANHANG1_SEQ")
	@SequenceGenerator(sequenceName = "TBSCHINHANHNGANHANG1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBSCHINHANHNGANHANG1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDCHINHANHNH")
	private long idChiNhanh;
	public void setIdChiNhanh(long idChiNhanh) {
		this.idChiNhanh = idChiNhanh;
	}
	public long getIdChiNhanh() {
		return this.idChiNhanh;
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("ChiNhanhNganHang1 { ");
		stringBuilder.append("idChiNhanh=" + idChiNhanh); 
		stringBuilder.append(", "); 
		stringBuilder.append("maChiNhanh=" + maChiNhanh); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenChiNhanh=" + tenChiNhanh); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}