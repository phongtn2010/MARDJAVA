package com.nsw.backend.sbv.p01.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBDYEUCAUHUYHOSO1", schema = "SBV")
public class YeuCauHuyHoSo1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDYEUCAUHUYHOSO1_SEQ")
	@SequenceGenerator(sequenceName = "TBDYEUCAUHUYHOSO1_SEQ", schema = "SBV", initialValue = 1, allocationSize = 1, name = "TBDYEUCAUHUYHOSO1_SEQ")
	@NotNull
	@Column(nullable = false, updatable = true, name = "PK_IDYEUCAUHUYHS")
	private long idYCHHoSo;
	public void setIdYCHHoSo(long idYCHHoSo) {
		this.idYCHHoSo = idYCHHoSo;
	}
	public long getIdYCHHoSo() {
		return this.idYCHHoSo;
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
	@Column(nullable = false, updatable = true, name = "FI_NGAYXINHUY")
	private Date ngayXinHuy;
	public void setNgayXinHuy(Date ngayXinHuy) {
		this.ngayXinHuy = ngayXinHuy;
	}
	public Date getNgayXinHuy() {
		return this.ngayXinHuy;
	}

	@NotBlank
	@Size(max = 2000)
	@Column(nullable = false, updatable = true, name = "FI_LYDOHUYHS")
	private String lyDoHuyHoSo;
	public void setLyDoHuyHoSo(String lyDoHuyHoSo) {
		this.lyDoHuyHoSo = lyDoHuyHoSo;
	}
	public String getLyDoHuyHoSo() {
		return this.lyDoHuyHoSo;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("YeuCauHuyHoSo1 { ");
		stringBuilder.append("idYCHHoSo=" + idYCHHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayXinHuy=" + ngayXinHuy); 
		stringBuilder.append(", "); 
		stringBuilder.append("lyDoHuyHoSo=" + lyDoHuyHoSo); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}