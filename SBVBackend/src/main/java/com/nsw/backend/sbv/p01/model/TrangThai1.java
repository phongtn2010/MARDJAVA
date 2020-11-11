package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBSTRANGTHAI1", schema = "SBV")
@NamedQueries({
	@NamedQuery(name = "FIND_ALL", query = "select a from TrangThai1 a")
})
public class TrangThai1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBSTRANGTHAI1_SEQ")
	@SequenceGenerator(sequenceName = "TBSTRANGTHAI1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBSTRANGTHAI1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDTRANGTHAI")
	private long idTrangThai;
	public void setIdTrangThai(long idTrangThai) {
		this.idTrangThai = idTrangThai;
	}
	public long getIdTrangThai() {
		return this.idTrangThai;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_TENTRANGTHAI")
	private String tenTrangThai;
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public String getTenTrangThai() {
		return this.tenTrangThai;
	}

	@Column(nullable = true, updatable = true, name = "FI_TRANGTHAI")
	private int giaTri;
	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}
	public int getGiaTri() {
		return this.giaTri;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TrangThai1 { ");
		stringBuilder.append("idTrangThai=" + idTrangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTrangThai=" + tenTrangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("giaTri=" + giaTri); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}