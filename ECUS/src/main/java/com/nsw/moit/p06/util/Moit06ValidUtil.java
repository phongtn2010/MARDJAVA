package com.nsw.moit.p06.util;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.nsw.moit.p06.model.TbdDinhKem6;
import com.nsw.moit.p06.model.TbdHangHoa6;
import com.nsw.moit.p06.model.TbdHoSo6;

public class Moit06ValidUtil {


	
	private Moit06ValidUtil() {
	}

	
	public static boolean validThongTinChung(TbdHoSo6 tbdHoSo6) {
		
		boolean isTrue = true;
		if (!StringUtils.hasText(tbdHoSo6.getTenDoanhNghiep())) return false;
		if (!StringUtils.hasText(tbdHoSo6.getMaSoThue())) return false;
		if (!StringUtils.hasText(tbdHoSo6.getDiaChiDoanhNghiep())) return false;
		if (!StringUtils.hasText(tbdHoSo6.getDienThoai())) return false;
		if (!StringUtils.hasText(tbdHoSo6.getSoGiayChungNhanDKKD())) return false;
		if (ObjectUtils.isEmpty(tbdHoSo6.getNgayCapGiayChungNhan())) return false;
		if (ObjectUtils.isEmpty(tbdHoSo6.getLoaiHinh()) || tbdHoSo6.getLoaiHinh()== -1) return false;
		if (ObjectUtils.isEmpty(tbdHoSo6.getLoaiGiayPhep()) || tbdHoSo6.getLoaiGiayPhep()== -1) return false;
		if (!StringUtils.hasText(tbdHoSo6.getDiaChiSanXuat())) return false;
		if (!StringUtils.hasText(tbdHoSo6.getMaTinhTP()) || "-1".equals(tbdHoSo6.getMaTinhTP())) return false;
		if (!StringUtils.hasText(tbdHoSo6.getNoiCapGiayChungNhanDKKD())) return false;
		if (!StringUtils.hasText(tbdHoSo6.getTenNguoiDaiDien())) return false;
		if (!StringUtils.hasText(tbdHoSo6.getDaiDienChucVu())) return false;
		if (tbdHoSo6.getDaiDienNamSinh() == null) return false;
		if (tbdHoSo6.getDaiDienGioiTinh() == null || tbdHoSo6.getDaiDienGioiTinh() == -1) return false;
		
		return isTrue;
	}
	
	public static boolean validHangHoa(TbdHangHoa6 tbdHangHoa6) {
		
		boolean isTrue = true;
		if (!StringUtils.hasText(tbdHangHoa6.getTenHangHoa())) return false;
		if (!StringUtils.hasText(tbdHangHoa6.getTenTCTN()) || "-1".equals(tbdHangHoa6.getTenTCTN())) return false;
		if (!StringUtils.hasText(tbdHangHoa6.getChiTiet())) return false;
		if (ObjectUtils.isEmpty(tbdHangHoa6.getHamLuong())) return false;
		if (ObjectUtils.isEmpty(tbdHangHoa6.getSoLuong())) return false;
		if (!StringUtils.hasText(tbdHangHoa6.getDonViTinh())) return false;
		if (ObjectUtils.isEmpty(tbdHangHoa6.getTrangThai()) || tbdHangHoa6.getTrangThai() == -1) return false;
		
		return isTrue;
	}
	
	public static boolean validDinhKem(TbdDinhKem6 tbdDinhKem6) {
		
		boolean isTrue = true;
		if (!StringUtils.hasText(tbdDinhKem6.getTenTepDinhKem())) return false;
		if (!StringUtils.hasText(tbdDinhKem6.getGuID())) return false;
		if (ObjectUtils.isEmpty(tbdDinhKem6.getMaLoaiTep())) return false;
		if (!StringUtils.hasText(tbdDinhKem6.getDuongDanFile())) return false;
		
		return isTrue;
	}
	
	public static boolean validSend(TbdHoSo6 tbdHoSo6) {
		
		boolean isTrue = validThongTinChung(tbdHoSo6);
		if (!StringUtils.hasText(tbdHoSo6.getMucDich())) return false;
		if (tbdHoSo6.getHoatDong() == 0 && !StringUtils.hasText(tbdHoSo6.getLyDoSua())) return false;
		return isTrue;
	}
	
}
