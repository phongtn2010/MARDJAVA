package com.nsw.monre.p01.constant;

public class AppViewThuTuc01Constant {

	public class PageView {
		
		
		private PageView() {
		}
		public static final String PAGE_INDEX = "nsw.monre.page.01.index";
		public static final String PAGE_TO_KHAI = "nsw.monre.page.01.khai_ho_so";
		public static final String PAGE_TEST = "nsw.monre.page.01.test";
		public static final String PAGE_ERROR_NOT_FOUND = "nsw.monre.page.01.not_found";
		public static final String THONG_BAO_THU_PHI = "nsw.monre.page.01.thongBaoThuPhi";
		public static final String XEM_GIAY_XAC_NHAN = "nsw.monre.page.01.DN_XemGiayXacNhan";
		public static final String DOCUMENT_HISTORY = "nsw.monre.page.01.dn_lich_su_xu_ly_ho_so";
		public static final String PAGE_CSSX = "nsw.monre.page.01.themmoi_cssx";
		public static final String RUT_HO_SO = "nsw.monre.page.01.donXinRutHoSo";
	}
	
	public class ViewURL {
		
		
		private ViewURL() {
		}

		public static final String URI_THU_TUC_01 = "/monre/01";
		
		public static final String URI_THU_TUC_02 = "/monre/02";
		
		public static final String URI_THU_TUC_03 = "/monre/03";
		
		public static final String URI_THU_TUC_04 = "/monre/04";
		
		public static final String KHAI_HO_SO_MOI_URL = "/edit";
		
		public static final String CHINH_SUA_HO_SO_URL = "/edit/{id}";
		
		public static final String INDEX_URL = "/home";
		
		public static final String XEM_HO_SO_URL = "/view";
		
		public static final String GHI_HO_SO_URL = "/save";
		
		public static final String XOA_HO_SO_URL = "/xoaHoSo";
		
		public static final String XEM_GIAY_XAC_NHAN_URL = "/xemGiayXacNhan/{id}";
		
		public static final String LAY_THONG_TIN_SO_GIAY_XAC_NHAN_URL = "/layThongTinSoGXN/{idHS}/{soGXN}";
		
		public static final String LAY_THONG_TIN_CO_SO_SAN_XUAT_THEO_SO_GIAY_XAC_NHAN_URL = "/layThongTinCoSoSXTheoSoGXN/{idGXN}";
		
		public static final String LAY_THONG_TIN_PHE_LIEU_THEO_SO_GIAY_XAC_NHAN_URL = "/layThongTinPheLieuTheoSoGXN/{idGXN}";
		
		public static final String THONG_BAO_THU_PHI_URL = "/thongBaoThuPhi/{id}";
		
		public static final String DOWNLOAD_GIAY_XAC_NHAN_URL = "/tepDinhKem/{id}";
		
		public static final String DOCUMENT_HISTORY_URL = "/dn_lich_su_xu_ly_ho_so/{id}";
		
		public static final String SEARCH_HO_SO = "/search";
		
		public static final String DANH_SACH_HO_SO = "/danhSachHoSo";
		
		public static final String DANH_SACH_CO_SO_XUAT = "/danhSachCSX/{id}";
		
		public static final String LAY_DANH_SACH_CO_SO_XUAT = "/danhSachCoSoSX";
		
		public static final String LAY_DANH_SACH_KET_QUA_XU_LY = "/danhSachKQXL";
		
		public static final String THEM_MOI_CO_SO_XUAT = "/themMoiCSX";
		
		public static final String CAP_NHAT_CO_SO_XUAT = "/capNhapDanhMucCSSX";
		
		public static final String CAP_NHAT_PHE_LIEU_THEO_HS = "/capNhapPheLieuTheoHS";
		
		public static final String XOA_CO_SO_SAN_XUAT_URL = "/xoaCSSX/{id}";
		
		public static final String XOA_BO_PHE_LIEU_THEO_HO_SO = "/xoaPLTheoHS/{id}";
		
		public static final String LUU_THONG_TIN_FILE_DINH_KEM_URL = "/luuThongTinTepDKTheoHS/{id}";
		
		public static final String XOA_CO_SO_SAN_XUAT_THEO_HO_SO_URL = "/xoaCSSXTheoHS/{id}";
		
		public static final String RUT_HO_SO_URL = "/donXinRutHoSo/{id}";
		
		public static final String CHINH_SUA_HO_SO_XOA_CSSX = "/khaiHoSo/{id}/{coSoId}";
		
		public static final String DANH_TINH_THANH_PHO = "/danhSachTTP";
		
		public static final String DANH_XA_PHUONG = "/danhSachXP/{maHuyen}";
		
		public static final String DANH_QUAN_HUYEN = "/danhSachQH/{id}";
		
		public static final String DANH_SACH_TAT_CA_PHE_LIEU = "/danhSachPL";
		
		public static final String DANH_SACH_TAT_CA_CO_QUAN_XU_LY = "/danhSachCQXL";
		
		public static final String LAY_THONG_TIN_HO_SO = "/layThongTinHoSo";
		
		public static final String DANH_SACH_TAT_CA_TRANG_THAI = "/danhSachTrangThai";
		
		public static final String DON_XIN_RUT_HO_SO = "/donXinRutHoSo";
		
		public static final String GUI_HO_SO = "/guiHoSo/{id}";
		
		public static final String BACKEND_SEND_MESSAGE_URL = "/monre/01/sendAll";
		
		public static final String DANH_SACH_PHE_LIEU_THEO_HO_SO = "/danhSachPLTheoHS";
		
		public static final String DANH_SACH_CO_SO_SAN_XUAT_THEO_HO_SO = "/danhSachCssxTheoHS";
		
		public static final String DANH_SACH_TEP_TIN_THEO_HO_SO = "/danhSachTepTinTheoHS/{id}";
		
		public static final String XOA_TEP_TIN_ID_THEO_HO_SO = "/xoaTepTinIdTheoHS/{idHS}/{tepTinId}";
		
		public static final String XOA_TOAN_BO_LOAI_TEP_TIN_THEO_HO_SO = "/xoaLoaiTepTinTheoHS/{idHS}/{loaiTepTin}";
	
	
	}
	

	
	public class MessageKey {
		
		
		private MessageKey() {
		}
		public static final String THU_TUC_01_KHAI_BAO_HO_SO_ERROR = "THU_TUC_01_KHAI_BAO_HO_SO_ERROR";
		
		public static final String THU_TUC_01_KHAI_BAO_HO_SO_SUCCESS = "THU_TUC_01_KHAI_BAO_HO_SO_SUCCESS";
		
		public static final String THU_TUC_01_THONG_BAO_SUCCESS_TU_SERVICE = "THU_TUC_01_THONG_BAO_SUCCESS_TU_SERVICE";
		
		public static final String THU_TUC_01_THONG_BAO_ERROR_TU_SERVICE = "THU_TUC_01_THONG_BAO_ERROR_TU_SERVICE";
		
		public static final String THU_TUC_01_THONG_BAO_EX_TU_SERVICE = "THU_TUC_01_THONG_BAO_EX_TU_SERVICE";
		
		public static final String TO_NAME = "BTNMT";
		public static final String TO_IDENTITY = "BTNMT";
		public static final String TO_COUNTRYCODE = "VN";
		public static final String TO_MINISTRYCODE = "BTNMT";
		public static final String TO_ORGANIZATIONCODE = "06";
		public static final String TO_UNITCODE = "00001";
	}
	
	public class PropertyKey {
		
		
		private PropertyKey() {
		}

		public static final String ACTION_SUCCESS = "monre.action.success";
		
		public static final String ACTION_ERROR = "monre.action.error";
		
	}
	
	
}






