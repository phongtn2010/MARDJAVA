package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBDTEPDINHKEMHOSO1", schema = "SBV")
public class TepDinhKemHoSo1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDTEPDINHKEMHOSO1_SEQ")
	@SequenceGenerator(sequenceName = "TBDTEPDINHKEMHOSO1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBDTEPDINHKEMHOSO1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDTEPDK")
	private long idTepDK;
	public void setIdTepDK(long idTepDK) {
		this.idTepDK = idTepDK;
	}
	public long getIdTepDK() {
		return this.idTepDK;
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
	@Column(nullable = false, updatable = true, name = "FI_MALOAITEPDK")
	private String maLoaiTepDinhKem;
	public void setMaLoaiTepDinhKem(String maLoaiTepDinhKem) {
		this.maLoaiTepDinhKem = maLoaiTepDinhKem;
	}
	public String getMaLoaiTepDinhKem() {
		return this.maLoaiTepDinhKem;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_TENLOAITEPDK")
	private String tenLoaiTepDinhKem;
	public void setTenLoaiTepDinhKem(String tenLoaiTepDinhKem) {
		this.tenLoaiTepDinhKem = tenLoaiTepDinhKem;
	}
	public String getTenLoaiTepDinhKem() {
		return this.tenLoaiTepDinhKem;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_TENTEPDK")
	private String tenTepDinhKem;
	public void setTenTepDinhKem(String tenTepDinhKem) {
		this.tenTepDinhKem = tenTepDinhKem;
	}
	public String getTenTepDinhKem() {
		return this.tenTepDinhKem;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_GUID")
	private String guID;
	public void setGuID(String guID) {
		this.guID = guID;
	}
	public String getGuID() {
		return this.guID;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, updatable = true, name = "FI_DUONGDAN")
	private String duongDanFile;
	public void setDuongDanFile(String duongDanFile) {
		this.duongDanFile = duongDanFile;
	}
	public String getDuongDanFile() {
		return this.duongDanFile;
	}

	@NotBlank
	@Column(nullable = false, updatable = true, name = "FI_LOAITEP")
	private String loaiTep;
	public void setLoaiTep(String loaiTep) {
		this.loaiTep = loaiTep;
	}
	public String getLoaiTep() {
		return this.loaiTep;
	}
	
	@Column(name = "FI_SIZE")
	private Long size;

	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TepDinhKemHoSo1 { ");
		stringBuilder.append("idTepDK=" + idTepDK); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTepDinhKem=" + maLoaiTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenLoaiTepDinhKem=" + tenLoaiTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTepDinhKem=" + tenTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("guID=" + guID); 
		stringBuilder.append(", "); 
		stringBuilder.append("duongDanFile=" + duongDanFile); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiTep=" + loaiTep); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}