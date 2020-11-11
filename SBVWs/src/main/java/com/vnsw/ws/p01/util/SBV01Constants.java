package com.vnsw.ws.p01.util;

public class SBV01Constants {

	public static final String PAGE_INDEX = "nsw.sbv.page.01.index";
	public static final String PAGE_EDIT = "nsw.sbv.page.01.edit";
	
	public static final String URL_SBV_01 = "/sbv/01";
	public static final String URL_PAGE_INDEX = "/home";
	public static final String URL_PAGE_EDIT = "/edit";
	public static final String URL_PAGE_VIEW_DETAIL = "/view";
	
	public static final String URL_PAGE_TEST = "/test";
	
	public static final int HINH_THUC_XUAT_KHAU = 2;
	public static final int HINH_THUC_NHAP_KHAU = 1;
	
	
	
	public class API_URL {
		
		public static final String ROOT = "/sbv/api/01";
		public static final String LAY_DANH_SACH_TRANG_THAI = "/layDsTrangThai";
		public static final String LAY_DANH_SACH_HO_SO = "/layDsHoSo";
		public static final String LAY_DANH_SACH_CUA_KHAU = "/layDsCuaKhau";
		public static final String LAY_DANH_SACH_CUA_KHAU_THEO_CHI_NHANH = "/layDsCuaKhauTheoCNNH";
		public static final String LAY_DANH_SACH_CHI_NHANH_NGAN_HANG = "/layDsCNNH";
		public static final String LAY_DANH_SACH_LOAI_TIEN_TE = "/layDsLoaiTT";
		public static final String LAY_DANH_SACH_TIEN_TE_THEO_HO_SO = "/layDsTTHS";
		public static final String SAVE_TIEN_TE_THEO_HO_SO = "/saveTTHS";
		public static final String DELETE_TIEN_TE_THEO_HO_SO = "/deleteTTHS";
		public static final String DELETE_HO_SO = "/deleteHoSo";
		public static final String SAVE = "/save";
	}
	
	public class MESSAGE_KEY {
		
		public static final String ACTION_SUCCESS = "sbv.01.action.success";
		public static final String ACTION_ERROR = "sbv.01.action.error";
	}
	
	public class STATUS {
		
		public static final int TAO_MOI = 0;
		public static final int CHO_TIEP_NHAN = 1;
		public static final int HUY_HO_SO = 2;
		public static final int DA_SUA_DOI_BO_SUNG = 3;
		public static final int DA_TIEP_NHAN = 4;
		public static final int YEU_CAU_SDBS = 5;
		public static final int YEU_CAU_HUY = 6;
		public static final int TU_CHOI_YCH = 7;
		public static final int HOAN_THANH_CAP_PHEP = 8;
		public static final int TU_CHOI_CAP_PHEP = 9;
	}
}

