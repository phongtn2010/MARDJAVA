package com.nsw.moit.p07.util;


import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.nsw.moit.p07.model.TbdDinhKem7;
import com.nsw.moit.p07.model.TbdHangHoa7DTO;
import com.nsw.moit.p07.model.TbdHoSo7;

public class Moit07ValidUtil {


	
	private Moit07ValidUtil() {
	}

	
	public static boolean validThongTinChung(TbdHoSo7 tbdHoSo7) {
		
		boolean isTrue = true;
		if (!StringUtils.hasText(tbdHoSo7.getTenDoanhNghiep())) return false;
		if (!StringUtils.hasText(tbdHoSo7.getMaSoThue())) return false;
		if (!StringUtils.hasText(tbdHoSo7.getDiaChiDoanhNghiep())) return false;
		if (!StringUtils.hasText(tbdHoSo7.getDienThoai())) return false;
		if (!StringUtils.hasText(tbdHoSo7.getSoGiayChungNhanDKKD())) return false;
		if (ObjectUtils.isEmpty(tbdHoSo7.getNgayCapGiayChungNhan())) return false;
		if (ObjectUtils.isEmpty(tbdHoSo7.getLoaiHinh()) || tbdHoSo7.getLoaiHinh()== -1) return false;
		if (ObjectUtils.isEmpty(tbdHoSo7.getLoaiHoSo()) || tbdHoSo7.getLoaiHoSo()== -1) return false;
		if (tbdHoSo7.getLoaiHoSo() == 2) {
			if (!StringUtils.hasText(tbdHoSo7.getSoGiayPhepDaCap())) return false;
			if (!StringUtils.hasText(tbdHoSo7.getLyDoGiaHan())) return false;
		}
		if (!StringUtils.hasText(tbdHoSo7.getDiaChiSanXuat())) return false;
		
		return isTrue;
	}
	
	public static boolean validHangHoa(TbdHangHoa7DTO tbdHangHoa7, int loaiHoSo) {
		
		boolean isTrue = true;
		if (!StringUtils.hasText(tbdHangHoa7.getMaCAS())) return false;
		if (!StringUtils.hasText(tbdHangHoa7.getMaHS())) return false;
		if (!StringUtils.hasText(tbdHangHoa7.getTenTiengViet())) return false;
		if (!StringUtils.hasText(tbdHangHoa7.getTenTiengAnh())) return false;
		if (!StringUtils.hasText(tbdHangHoa7.getTenThuongMai())) return false;
		if (!StringUtils.hasText(tbdHangHoa7.getTenKhoaHoc())) return false;
		if (!StringUtils.hasText(tbdHangHoa7.getCongThucHoaHoc())) return false;
		if (!StringUtils.hasText(tbdHangHoa7.getHamLuong())) return false;
		if (!StringUtils.hasText(tbdHangHoa7.getMaHonHop())) return false;
		
		if (!StringUtils.hasText(tbdHangHoa7.getDonViTinh())) return false;
		if (ObjectUtils.isEmpty(tbdHangHoa7.getTrangThaiHangHoa())) return false;
		if (ObjectUtils.isEmpty(tbdHangHoa7.getMoTa())) return false;
		
		if (loaiHoSo == 2) {
			if (ObjectUtils.isEmpty(tbdHangHoa7.getSoLuongDaNhap())) return false;
			if (ObjectUtils.isEmpty(tbdHangHoa7.getSoLuongConLai())) return false;
		}
		
		String[] maCASs = tbdHangHoa7.getMaCAS().split(";");
		String[] maHonHops = tbdHangHoa7.getMaHonHop().split(";");
		String[] hamLuong = tbdHangHoa7.getHamLuong().split(";");
		String[] tenKhoaHoc = tbdHangHoa7.getTenKhoaHoc().split(";");
		String[] tenTiengViet = tbdHangHoa7.getTenTiengViet().split(";");
		String[] tenTiengAnh = tbdHangHoa7.getTenTiengAnh().split(";");
		String[] congThucs = tbdHangHoa7.getCongThucHoaHoc().split(";");
		if (maCASs.length != maHonHops.length) return false;
		if (maCASs.length != hamLuong.length) return false;
		if (maCASs.length != tenKhoaHoc.length) return false;
		if (maCASs.length != tenTiengAnh.length) return false;
		if (maCASs.length != tenTiengViet.length) return false;
		if (maCASs.length != congThucs.length) return false;
		
		return isTrue;
	}
	
	public static boolean validDinhKem(TbdDinhKem7 tbdDinhKem7) {
		
		boolean isTrue = true;
		if (!StringUtils.hasText(tbdDinhKem7.getTenTepDinhKem())) return false;
		if (!StringUtils.hasText(tbdDinhKem7.getGuID())) return false;
		if (ObjectUtils.isEmpty(tbdDinhKem7.getMaLoaiTep())) return false;
		if (!StringUtils.hasText(tbdDinhKem7.getDuongDanFile())) return false;
		
		return isTrue;
	}
	
	public static boolean validSend(TbdHoSo7 tbdHoSo7) {
		
		boolean isTrue = validThongTinChung(tbdHoSo7);
		if (!StringUtils.hasText(tbdHoSo7.getMucDich())) return false;
		if (tbdHoSo7.getHoatDong() == 0 && !StringUtils.hasText(tbdHoSo7.getLyDoSua())) return false;
		
		return isTrue;
	}
	
}
