package com.vnsw.ws.p01.message.send;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Gate")
@XmlType(propOrder = { "maCuaKhau","tenCuaKhau"})
public class ThongTinCuaKhau {

	@XmlTransient
	private long idCuaKhau;
	public void setIdCuaKhau(long idCuaKhau) {
		this.idCuaKhau = idCuaKhau;
	}
	public long getIdCuaKhau() {
		return this.idCuaKhau;
	}
	@XmlElement(name = "GateCode")
	private String maCuaKhau;
	public void setMaCuaKhau(String maCuaKhau) {
		this.maCuaKhau = maCuaKhau;
	}
	public String getMaCuaKhau() {
		return this.maCuaKhau;
	}

	@XmlElement(name = "GateName")
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

		stringBuilder.append(ThongTinCuaKhau.class.getSimpleName() + " { ");
		stringBuilder.append("idCuaKhau=" + idCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("maCuaKhau=" + maCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau); 
		stringBuilder.append(" }"); 
		stringBuilder.append("maCuaKhau=" + maCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau); 
		stringBuilder.append(", "); 
		return stringBuilder.toString();
	}
}