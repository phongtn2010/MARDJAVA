package com.vnsw.ws.p01.entity.db;


public class TepDinhKemHoSo1 {

	private long idTepDK;
	public void setIdTepDK(long idTepDK) {
		this.idTepDK = idTepDK;
	}
	public long getIdTepDK() {
		return this.idTepDK;
	}

	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	private String maLoaiTepDinhKem;
	public void setMaLoaiTepDinhKem(String maLoaiTepDinhKem) {
		this.maLoaiTepDinhKem = maLoaiTepDinhKem;
	}
	public String getMaLoaiTepDinhKem() {
		return this.maLoaiTepDinhKem;
	}

	private String tenLoaiTepDinhKem = "1";
	public void setTenLoaiTepDinhKem(String tenLoaiTepDinhKem) {
		this.tenLoaiTepDinhKem = tenLoaiTepDinhKem;
	}
	public String getTenLoaiTepDinhKem() {
		return this.tenLoaiTepDinhKem;
	}

	private String tenTepDinhKem;
	public void setTenTepDinhKem(String tenTepDinhKem) {
		this.tenTepDinhKem = tenTepDinhKem;
	}
	public String getTenTepDinhKem() {
		return this.tenTepDinhKem;
	}

	
	private String guID;
	
	private String duongDanFile;

	public String getGuID() {
		return guID;
	}
	public void setGuID(String guID) {
		this.guID = guID;
	}
	public String getDuongDanFile() {
		return duongDanFile;
	}
	public void setDuongDanFile(String duongDanFile) {
		this.duongDanFile = duongDanFile;
	}
	
	private String loaiTep;

	public String getLoaiTep() {
		return loaiTep;
	}
	public void setLoaiTep(String loaiTep) {
		this.loaiTep = loaiTep;
	}
	
	private Long size;
	
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "TepDinhKemHoSo1 [idTepDK=" + idTepDK + ", idHoSo=" + idHoSo + ", maLoaiTepDinhKem=" + maLoaiTepDinhKem
				+ ", tenLoaiTepDinhKem=" + tenLoaiTepDinhKem + ", tenTepDinhKem=" + tenTepDinhKem + ", guID=" + guID
				+ ", duongDanFile=" + duongDanFile + ", loaiTep=" + loaiTep + "]";
	}

	

	
}