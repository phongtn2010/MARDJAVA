package com.nsw.sbv.p01.util;

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

	public static final String ACTION_SUCCESS = "ACTION_SUCCESS";
	public static final String ACTION_ERROR = "ACTION_ERROR";

	public class ApiUrls {

		private ApiUrls() {
		}

		public static final String ROOT = "/sbv/api/01";
		public static final String LAY_DANH_SACH_TRANG_THAI = "/layDsTrangThai";
		public static final String LAY_DANH_SACH_HO_SO = "/layDsHoSo";
		public static final String LAY_DANH_SACH_CUA_KHAU = "/layDsCuaKhau";
		public static final String LAY_DANH_SACH_LICH_SU = "/layDsLichSuHS";
		public static final String XEM_GIAY_XAC_NHAN = "/xemGXN";
		public static final String LAY_DANH_SACH_CUA_KHAU_THEO_CHI_NHANH = "/layDsCuaKhauTheoCNNH";
		public static final String LAY_DANH_SACH_CHI_NHANH_NGAN_HANG = "/layDsCNNH";
		public static final String LAY_DANH_SACH_LOAI_TIEN_TE = "/layDsLoaiTT";
		public static final String LAY_DANH_SACH_TIEN_TE_THEO_HO_SO = "/layDsTTHS";
		public static final String LAY_DANH_SACH_TEP_TIN_THEO_HO_SO = "/layDsTepTinHS";
		public static final String HUY_HO_SO = "/huyHS";
		public static final String GUI_HO_SO = "/guiHS";
		public static final String SAVE_TIEN_TE_THEO_HO_SO = "/saveTTHS";
		public static final String DELETE_TIEN_TE_THEO_HO_SO = "/deleteTTHS";
		public static final String DELETE_HO_SO = "/deleteHoSo";
		public static final String DELETE_TEP_TIN_BY_ID = "/xoaTepDK";
		public static final String SAVE = "/save";
		public static final String LAY_THONG_TIN_GIAY_PHEP = "/layThongTinGP";
		public static final String LAY_THONG_TIN_HO_SO = "/layThongTinHoSo";
		public static final String SUA_HO_SO = "/suaHoSo";
		public static final String LAY_GIAY_XAC_NHAN = "/findGiayXN";
	}

	public class MessageKeys {

		private MessageKeys() {
		}

		public static final String ACTION_SUCCESS = "sbv.01.action.success";
		public static final String ACTION_ERROR = "sbv.01.action.error";
		public static final String ACTION_SEND_ERROR = "sbv.01.guihoso.error.3";
		public static final String MESSAGE_DEFAULT_KEY = "sbv.01.message.chon";
		public static final String TOKEN_ERROR = "sbv.01.guihoso.token";
	}

	/**
	 * @author Quang
	 *
	 */
	public class Status {

		private Status() {
		}

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

	public class TepDinhKems {

		private TepDinhKems() {
		}

		public static final int TEP_LOAI_1 = 1;
		public static final int TEP_LOAI_2 = 2;
		public static final int TEP_LOAI_3 = 3;

	}

	public class MessageFunction {

		private MessageFunction() {
		}

		public static final String FUN_01 = "01";
		public static final String FUN_02 = "02";
		public static final String FUN_03 = "03";
		public static final String FUN_04 = "04";
		public static final String FUN_05 = "05";
		public static final String FUN_06 = "06";
		public static final String FUN_07 = "07";
	}

	public class MessageType {

		private MessageType() {
		}

		public static final String TYPE_11 = "11";
		public static final String TYPE_12 = "12";
	}
}
