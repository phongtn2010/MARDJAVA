package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBSLOAITIENTE1", schema = "SBV")
public class LoaiTienTe1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBSLOAITIENTE1_SEQ")
	@SequenceGenerator(sequenceName = "TBSLOAITIENTE1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBSLOAITIENTE1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDLOAITT")
	private long idLoaiTienTe;
	public void setIdLoaiTienTe(long idLoaiTienTe) {
		this.idLoaiTienTe = idLoaiTienTe;
	}
	public long getIdLoaiTienTe() {
		return this.idLoaiTienTe;
	}

	@NotBlank
	@Size(max = 20)
	@Column(nullable = false, updatable = true, name = "FI_MALOAITT")
	private String maLoaiTienTe;
	public void setMaLoaiTienTe(String maLoaiTienTe) {
		this.maLoaiTienTe = maLoaiTienTe;
	}
	public String getMaLoaiTienTe() {
		return this.maLoaiTienTe;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_TENLOAITT")
	private String tenLoaiTienTe;
	public void setTenLoaiTienTe(String tenLoaiTienTe) {
		this.tenLoaiTienTe = tenLoaiTienTe;
	}
	public String getTenLoaiTienTe() {
		return this.tenLoaiTienTe;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("LoaiTienTe1 { ");
		stringBuilder.append("idLoaiTienTe=" + idLoaiTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTienTe=" + maLoaiTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenLoaiTienTe=" + tenLoaiTienTe); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}