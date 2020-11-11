package com.vnsw.ws.p01.message.send;


import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p01.message.receive.HSCongTy;
import com.vnsw.ws.p01.message.receive.HoSoTienTe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "HSDK_GP_XNKngoaite")
@XmlType(propOrder = { "maChiNhanh","tenChiNhanh","hinhThucXNK","hsCongty","currencyList","gate","xuatNhapKhauTuNgay","xuatNhapKhauDenNgay","capGiayPhepLanDau","soGiayPhepDaCap","doiTacXuatNhapKhau", "ghiChu", "attachmentList"})

public class HoSoNgoaiTe {

	@XmlTransient
	private int trangthai;
	public int getTrangThai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	@XmlTransient
	private String loaiThuTuc;
	
	public String getLoaiThuTuc() {
		return loaiThuTuc;
	}
	public void setLoaiThuTuc(String loaiThuTuc) {
		this.loaiThuTuc = loaiThuTuc;
	}

	@XmlTransient
	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}
	
	@XmlTransient
	private String maHoSo;
	public String getMaHoSo() {
		return this.maHoSo;
	}
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	
	@XmlElement(name = "BankBranchCode")
	private String maChiNhanh;
	public void setMaChiNhanh(String maChiNhanh) {
		this.maChiNhanh = maChiNhanh;
	}
	public String getMaChiNhanh() {
		return this.maChiNhanh;
	}

	@XmlElement(name = "StateBankBranch")
	private String tenChiNhanh;
	public void setTenChiNhanh(String tenChiNhanh) {
		this.tenChiNhanh = tenChiNhanh;
	}
	public String getTenChiNhanh() {
		return this.tenChiNhanh;
	}

	@XmlElement(name = "ImportExport")
	private int hinhThucXNK;
	public int getHinhThucXNK() {
		return hinhThucXNK;
	}
	public void setHinhThucXNK(int hinhThucXNK) {
		this.hinhThucXNK = hinhThucXNK;
	}

	@XmlElement(name = "Company")
	private HSCongTy hsCongty;
	public HSCongTy getHsCongty() {
		return hsCongty;
	}
	public void setHsCongty(HSCongTy hsCongty) {
		this.hsCongty = hsCongty;
	}
	
	@XmlElementWrapper(name = "CurrencyList")
    @XmlElement(name = "Currency")
	private List<HoSoTienTe> currencyList;
	public List<HoSoTienTe> getCurrencyList() {
		return currencyList;
	}
	public void setCurrencyList(List<HoSoTienTe> currencyList) {
		this.currencyList = currencyList;
	}

	@XmlElement(name = "Gate")
    ThongTinCuaKhau gate;
	
	public ThongTinCuaKhau getGate() {
		return gate;
	}
	public void setGate(ThongTinCuaKhau gate) {
		this.gate = gate;
	}

	@XmlElement(name = "TimeFrom")
	@XmlJavaTypeAdapter(DateSerialization.class)
	private Date xuatNhapKhauTuNgay;
	public void setXuatNhapKhauTuNgay(Date xuatNhapKhauTuNgay) {
		this.xuatNhapKhauTuNgay = xuatNhapKhauTuNgay;
	}
	public Date getXuatNhapKhauTuNgay() {
		return this.xuatNhapKhauTuNgay;
	}

	@XmlElement(name = "TimeTo")
	@XmlJavaTypeAdapter(DateSerialization.class)
	private Date xuatNhapKhauDenNgay;
	public void setXuatNhapKhauDenNgay(Date xuatNhapKhauDenNgay) {
		this.xuatNhapKhauDenNgay = xuatNhapKhauDenNgay;
	}
	public Date getXuatNhapKhauDenNgay() {
		return this.xuatNhapKhauDenNgay;
	}
	
	@XmlElement(name = "FirstLicense")
	private int capGiayPhepLanDau;
	public void setCapGiayPhepLanDau(int capGiayPhepLanDau) {
		this.capGiayPhepLanDau = capGiayPhepLanDau;
	}
	public int getCapGiayPhepLanDau() {
		return this.capGiayPhepLanDau;
	}

	@XmlElement(name = "LicenseNo")
	private String soGiayPhepDaCap;
	public void setSoGiayPhepDaCap(String soGiayPhepDaCap) {
		this.soGiayPhepDaCap = soGiayPhepDaCap;
	}
	public String getSoGiayPhepDaCap() {
		return this.soGiayPhepDaCap;
	}
	
	@XmlElement(name = "PartnerImEx")
	private String doiTacXuatNhapKhau;
	public void setDoiTacXuatNhapKhau(String doiTacXuatNhapKhau) {
		this.doiTacXuatNhapKhau = doiTacXuatNhapKhau;
	}
	public String getDoiTacXuatNhapKhau() {
		return this.doiTacXuatNhapKhau;
	}
	
	@XmlElement(name = "Remarks")
	private String ghiChu;

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	@XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
	private List<TepDinhKemHoSo> attachmentList;
	public List<TepDinhKemHoSo> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<TepDinhKemHoSo> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@XmlTransient
	private Date ngayTao;
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgayTao() {
		return this.ngayTao;
	}
	
	
	@Override
	public String toString() {
		return "HoSoNgoaiTe [trangthai=" + trangthai + ", loaiThuTuc=" + loaiThuTuc + ", idHoSo=" + idHoSo + ", maHoSo="
				+ maHoSo + ", maChiNhanh=" + maChiNhanh + ", tenChiNhanh=" + tenChiNhanh + ", hinhThucXNK="
				+ hinhThucXNK + ", hsCongty=" + hsCongty + ", currencyList=" + currencyList + ", gate=" + gate
				+ ", xuatNhapKhauTuNgay=" + xuatNhapKhauTuNgay + ", xuatNhapKhauDenNgay=" + xuatNhapKhauDenNgay
				+ ", capGiayPhepLanDau=" + capGiayPhepLanDau + ", soGiayPhepDaCap=" + soGiayPhepDaCap
				+ ", doiTacXuatNhapKhau=" + doiTacXuatNhapKhau + ", attachmentList=" + attachmentList + ", ngayTao="
				+ ngayTao + "]";
	}

	
}