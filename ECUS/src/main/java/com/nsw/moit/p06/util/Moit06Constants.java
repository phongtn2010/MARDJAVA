package com.nsw.moit.p06.util;

public class Moit06Constants {

	public final class PAGE {
		private PAGE() {
		}

		public static final String INDEX = "nsw.moit.page.06.index";
		public static final String EDIT = "nsw.moit.page.06.edit";
	}

	public final class PROPERTIES {
		private PROPERTIES() {
		}

		public static final String BACKEND = "moit.06.backend";
	}

	public static final String PAGE_INDEX = "nsw.MOIT.page.01.index";
	public static final String PAGE_EDIT = "nsw.MOIT.page.01.edit";

	public static final String URL_MOIT_01 = "/moit/06";
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

		public static final String ROOT = "/moit/api/06";
		public static final String LAY_DANH_SACH_TRANG_THAI = "/layDsTrangThai";
		public static final String LAY_DANH_SACH_HO_SO = "/layDsHoSo";
		public static final String LAY_DANH_SACH_CUA_KHAU = "/layDsCuaKhau";
		public static final String LAY_DANH_SACH_PHUONG_TIEN = "/layDsPhuongTien";
		public static final String LAY_DANH_SACH_TIEN_CHAT = "/layDsTienChat";
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
		public static final String DELETE_CUA_KHAU_THEO_HO_SO = "/deleteCuaKhau";
		public static final String DELETE_PHUONG_TIEN_THEO_HO_SO = "/deletePhuongTien";
		public static final String DELETE_HO_SO = "/deleteHoSo";
		public static final String DELETE_TEP_TIN_BY_ID = "/xoaTepDK";
		public static final String DELETE_HANG_HOA = "/xoaHangHoa";
		public static final String UPDATE_HANG_HOA = "/updateHangHoa";
		public static final String SAVE = "/save";
		public static final String LAY_THONG_TIN_GIAY_PHEP = "/layThongTinGP";
		public static final String LAY_THONG_TIN_HO_SO = "/layThongTinHoSo";
		public static final String SUA_HO_SO = "/suaHoSo";
		public static final String LAY_GIAY_XAC_NHAN = "/findGiayXN";
		public static final String ADD_HANG_HOA = "/addHangHoa";
		public static final String ADD_CUA_KHAU = "/addCuaKhau";
		public static final String ADD_PHUONG_TIEN = "/addPhuongTien";
	}

	public class MessageKeys {

		private MessageKeys() {
		}

		public static final String ACTION_SUCCESS = "moit.06.action.success";
		public static final String ACTION_SEND_SUCCESS = "moit.06.action.send.success";
		public static final String ACTION_SEND_EROROR = "moit.06.action.send.error";
		public static final String ACTION_SEND_EROROR_VALID = "moit.06.action.send.error.valid";
		public static final String ACTION_ERROR = "moit.06.action.error";
		public static final String ACTION_SEND_ERROR = "moit.06.guihoso.error.3";
		public static final String MESSAGE_DEFAULT_KEY = "moit.06.message.chon";
		public static final String TOKEN_ERROR = "moit.06.guihoso.token";
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
		public static final int YEU_CAU_BO_SUNG = 7;
		public static final int DANG_XU_LY = 5;
		public static final int DONG_Y_YEU_CAU_SUA = 9;
		public static final int TU_CHOI_YEU_CAU_SUA = 10;
		public static final int DA_SDBS = 4;
		
	}

	public class TepDinhKems {

		private TepDinhKems() {
		}

		public static final int TEP_LOAI_1 = 1;
		public static final int TEP_LOAI_2 = 2;
		public static final int TEP_LOAI_3 = 3;

	}
	

	public enum MessageFunction {

		FUNTION_GUI_MOI("01", "10", 1),
		FUNTION_GUI_SUA("02", "10", 1),
		FUNTION_GUI_SDBS("04", "10", 4),
		FUNTION_YC_SUA("08", "12", 8),
		FUNTION_YC_RUT_CHUA_DUYET("03", "15", 3),
		FUNTION_YC_RUT("12", "15", 12);
		
		private String functionName;
		private String functionType;
		private int statusAfterSend;
		
		private MessageFunction(String functionName, String functionType, int statusAfterSend) {
			this.functionName = functionName;
			this.functionType = functionType;
			this.statusAfterSend = statusAfterSend;
		}
		public String getFunctionName() {
			return functionName;
		}
		
		public String getFunctionType() {
			return functionType;
		}
		public int getStatusAfterSend() {
			return statusAfterSend;
		}
		
		
		
	}

}
