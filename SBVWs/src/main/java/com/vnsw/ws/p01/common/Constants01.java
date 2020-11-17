package com.vnsw.ws.p01.common;

public class Constants01 {
	private Constants01() {
		throw new IllegalStateException("Utility class");
	}

	public static final Long CQKT_TCKT = 1L; // Tổ chức kiểm tra
	public static final String CQKT_TCKT_STR = "Hồ sơ đăng ký kiểm tra chất lượng";
	public static final Long CQKT_TCGD = 2L; // Tổ chức kiểm tra
	public static final String CQKT_TCGD_STR = "Hồ sơ đăng ký chứng nhận phù hợp/giám định";

	public static final String SBV01_TYPE_10 = "10";
	public static final String SBV01_TYPE_11 = "11";
	public static final String SBV01_TYPE_12 = "12";
	public static final String SBV01_TYPE_13 = "13";
	public static final String SBV01_TYPE_14 = "14";
	public static final String SBV01_TYPE_15 = "15";
	public static final String SBV01_TYPE_16 = "16";
	public static final String SBV01_TYPE_17 = "17";
	public static final String SBV01_TYPE_18 = "18";
	public static final String SBV01_TYPE_19 = "19";
	public static final String SBV01_TYPE_20 = "20";
	public static final String SBV01_TYPE_21 = "21";
	public static final String SBV01_TYPE_22 = "22";
	public static final String SBV01_TYPE_30 = "30";
	public static final String SBV01_TYPE_31 = "31";
	public static final String SBV01_TYPE_32 = "32";
	public static final String SBV01_TYPE_33 = "33";
	public static final String SBV01_TYPE_68 = "68";

	public static final String SBV01_FUNCTION_01 = "01";
	public static final String SBV01_FUNCTION_02 = "02";
	public static final String SBV01_FUNCTION_03 = "03";
	public static final String SBV01_FUNCTION_04 = "04";
	public static final String SBV01_FUNCTION_05 = "05";
	public static final String SBV01_FUNCTION_06 = "06";
	public static final String SBV01_FUNCTION_07 = "07";
	public static final String SBV01_FUNCTION_08 = "08";
	public static final String SBV01_FUNCTION_09 = "09";
	public static final String SBV01_FUNCTION_10 = "10";
	public static final String SBV01_FUNCTION_11 = "11";
	public static final String SBV01_FUNCTION_12 = "12";
	public static final String SBV01_FUNCTION_13 = "13";
	public static final String SBV01_FUNCTION_14 = "14";
	public static final String SBV01_FUNCTION_15 = "15";
	public static final String SBV01_FUNCTION_16 = "16";
	public static final String SBV01_FUNCTION_17 = "17";
	public static final String SBV01_FUNCTION_18 = "18";
	public static final String SBV01_FUNCTION_19 = "19";
	public static final String SBV01_FUNCTION_20 = "20";
	public static final String SBV01_FUNCTION_21 = "21";
	public static final String SBV01_FUNCTION_24 = "24";
	public static final String SBV01_FUNCTION_99 = "99";

	// Tiêp nhận
	public static final String RES_URI_CVTN = "/sbv/01/cvtn/data/";
	// Yêu cầu bổ sung
	public static final String RES_URI_CVYCBS = "/sbv/01/cvycbs/data/";
	// Từ chối
	public static final String RES_URI_CVTC = "/sbv/01/cvtc/data/";

	// Tiêp nhận 12_08 Kết quả đánh giá hàng hóa
	public static final String RES_URI_KQDGHH = "/sbv/01/kqdghh/data/";

	// Tiêp nhận 18_05 Kết quả kiểm tra hàng hóa
	public static final String RES_URI_KQKT = "/sbv/01/kqkthh/data/";

	// Tiêp nhận 16_13 Phản hồi yêu cầu rút hồ sơ
	public static final String RES_URI_YCRUTHS_RESPONSE = "/sbv/01/ycruthsresponse/data/";
	// Tiêp nhận 20_10 Phản hồi yêu cầu lùi hạn
	public static final String RES_URI_LUIHAN_RESPONSE = "/sbv/01/luihanresponse/data/";
	// Tiêp nhận 22_19 Phản hồi yêu cầu Xin sua
	public static final String RES_URI_XINSUA_RESPONSE = "/sbv/01/ycxinsua/data/";
	// Bản tin gửi đi
	// Doanh nghiệp xin lùi hạn
	public static final String RES_URI_LUIHAN = "/sbv/01/luihan/data/";
	public static final String RES_URI_YCRUTHS = "/sbv/01/ycruths/data/";
	public static final String RES_URI_YCXINSUA = "/sbv/01/ycxinsua/data/";
	public static final String RES_URI_SEARCH_HS = "/sbv/01/hoso/searchone/";

	// Luu thong tin nộp 1 hồ sơ
	public static final String RES_URI_UPDATE_STATUS_NOP_ONE = "/sbv/01/cqxl/updateNopHosoOne/";
	// Lưu thông tin nộp nhiều hồ sơ
	public static final String RES_URI_UPDATE_STATUS_NOP_ALL = "/sbv/01/cqxl/updateNopHosoAll/";

	public static final String RES_URI_LICHSU_RESPONSE = "/sbv/01/lichsu/data/";
	public static final String RES_URI_LICHSU_TOP10_URI = "/sbv/01/lichsu/gettop/";
	public static final String RES_URI_LICHSU_BYCQXL_AND_TRANGTHAI_URI = "/sbv/01/lichsu/getbycqxlandtrangthai/";

	public static final String URL_GET_HOSO = "/sbv/01/getHoso/";
	public static final String URL_GET_CQXL = "/sbv/01/cqxl/data/";

	public static final String URL_HOSO = "/sbv/01/hoso/";

	public static final String RES_URI_SAVE_DINHKEM = "/sbv/01/dinhkem/save/";

	public static final Long FILE_STATUS_TAO_MOI = 0L;
	public static final String FILE_STATUS_TAO_MOI_STR = "Mới tạo";
	public static final Long FILE_STATUS_CHO_TIEP_NHAN = 1L;
	public static final String FILE_STATUS_CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
	public static final Long FILE_STATUS_DA_TIEP_NHAN = 2L;
	public static final String FILE_STATUS_DA_TIEP_NHAN_STR = "Đã tiếp nhận";
	public static final Long FILE_STATUS_TC_TIEP_NHAN = 3L;
	public static final String FILE_STATUS_TC_TIEP_NHAN_STR = "Từ chối tiếp nhận";
	public static final Long FILE_STATUS_DA_RUT = 4L;
	public static final String FILE_STATUS_DA_RUT_STR = "Đã rút hồ sơ";
	public static final Long FILE_STATUS_YC_BO_SUNG = 5L;
	public static final String FILE_STATUS_YC_BO_SUNG_STR = "Yêu cầu bổ sung hồ sơ";
	public static final Long FILE_STATUS_DA_BO_SUNG = 6L;
	public static final String FILE_STATUS_DA_BO_SUNG_STR = "Đã bổ sung hồ sơ theo yêu cầu";
	public static final Long FILE_STATUS_YC_RUT = 7L;
	public static final String FILE_STATUS_YC_RUT_STR = "Yêu cầu xin rút hồ sơ";
	public static final Long FILE_STATUS_DONGY_YC_RUT = 8L;
	public static final String FILE_STATUS_DONGY_YC_RUT_STR = "Đồng ý yêu cầu rút";
	public static final Long FILE_STATUS_XIN_SUA = 9L;
	public static final String FILE_STATUS_XIN_SUA_STR = "Xin sửa hồ sơ";
	public static final Long FILE_STATUS_DONGY_XIN_SUA = 10L;
	public static final String FILE_STATUS_DONGY_XIN_SUA_STR = "Đồng ý yêu cầu xin sửa";
	public static final Long FILE_STATUS_YC_LUIHAN = 11L;
	public static final String FILE_STATUS_YC_LUIHAN_STR = "Yêu cầu xin lùi hạn hoàn thiện hồ sơ";
	public static final Long FILE_STATUS_DONGY_YC_LUIHAN = 12L;
	public static final String FILE_STATUS_DONGY_YC_LUIHAN_STR = "Đồng ý yêu cầu lùi hạn hoàn thiện hồ sơ";
	public static final Long FILE_STATUS_DACO_KQ_KIEMTRA = 13L;
	public static final String FILE_STATUS_DACO_KQ_KIEMTRA_STR = "Đã có kết quả kiểm tra";
	public static final Long FILE_STATUS_DATHUHOI_KQ_KIEMTRA = 14L;
	public static final String FILE_STATUS_DATHUHOI_KQ_KIEMTRA_STR = "Đã thu hồi thông báo kết quả kiểm tra";
	public static final Long FILE_STATUS_DACO_KQ_DANHGIA = 13L;
	public static final String FILE_STATUS_DACO_KQ_DANHGIA_STR = "Đã có kết quả đánh giá";
	public static final Long FILE_STATUS_DATHUHOI_KQ_DANHGIA = 14L;
	public static final String FILE_STATUS_DATHUHOI_KQ_DANHGIA_STR = "Đã thu hồi kết quả đánh giá";
	public static final Long FILE_STATUS_CQKT_DXL = 15L;
	public static final String FILE_STATUS_CQKT_DXL_STR = "Đang xử lý";

	public static final Long ATTACH_OPERATION_ADD = 1L;
	public static final Long ATTACH_OPERATION_DEL = 2L;
	public static final Long ATTACH_STATUS_ACTIVE = 1L;
	public static final Long ATTACH_STATUS_INACTIVE = 0L;

	public static final String ATTACH_TYPE_GCN_1 = "5";
	public static final String ATTACH_TYPE_GCN_2 = "6";

	public static final String LICHSU_CAP_MOI_GXN = "Cấp mới giấy xác nhận";
	public static final String LICHSU_CAP_NHAT_GXN = "Cập nhật giấy xác nhận";
	public static final String LICHSU_CAP_LAI_GXN = "Cấp lại giấy xác nhận";
	public static final String LICHSU_LE_PHI_THAM_DINH = "Gửi lệ phí thẩm định";
	public static final String LICHSU_XAC_NHAN_DA_THANH_TOAN = "Đã thanh toán";
	public static final String LICHSU_XAC_NHAN_CHUA_THANH_TOAN = "Chưa thanh toán";

	public static final String DATEPARTTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String ERR00_CODE = "ERR00_CODE";
	public static final String ERR01_CODE = "ERR01_CODE";
	public static final String ERR02_CODE = "ERR02_CODE";
	public static final String ERR03_CODE = "ERR03_CODE";
	public static final String ERR04_CODE = "ERR04_CODE";
	public static final String ERR05_CODE = "ERR05_CODE";
	public static final String ERR06_CODE = "ERR06_CODE";

	public static final String ERR00 = "Bản tin không hợp lệ";
	public static final String ERR01 = "Thủ tục chưa được định nghĩa";
	public static final String ERR02 = "Phân tích xml bị lỗi";
	public static final String ERR03 = "Lỗi phân tích xml: không lấy được thủ tục từ xml";
	public static final String ERR04 = "Message Type: Không tồn tại ";
	public static final String ERR05 = "Nội dung bản tin không có dữ liệu, hoặc không hợp lệ.";

	public static final String SBV6_CODE = "SBV6_CODE";
	public static final String SBV6 = "Không lưu được dữ liệu!";

	public static final String SBV01_CODE = "SBV01_CODE";
	public static final String SBV02_CODE = "SBV03_CODE";
	public static final String SBV03_CODE = "SBV03_CODE";
	public static final String SBV04_CODE = "SBV04_CODE";
	public static final String SBV05_CODE = "SBV05_CODE";
	public static final String SBV06_CODE = "SBV06_CODE";
	public static final String SBV07_CODE = "SBV07_CODE";
	public static final String SBV08_CODE = "SBV08_CODE";
	public static final String SBV09_CODE = "SBV09_CODE";
	public static final String SBV10_CODE = "SBV10_CODE";
	public static final String SBV11_CODE = "SBV11_CODE";

	public static final String SBV01 = "Chưa định nghĩa function tiếp nhận";
	public static final String SBV02 = "Function is null";
	public static final String SBV03 = "Lỗi phân tích bản tin";
	public static final String SBV04 = "Lỗi lưu bản tin";
	public static final String SBV05 = "Lưu không thành công";
	public static final String SBV06 = "Không lấy được ID Cơ quan xử lý";
	public static final String SBV07 = "Function không hợp lệ";
	public static final String SBV08 = "Không lưu được dữ liệu file đính kèm";
	public static final String SBV09 = "Không lưu được dữ liệu!";
	public static final String SBV10 = "Lỗi sai quy trình xử lý!";
	public static final String SBV11 = "Lỗi hồ sơ không tồn tại!";
	
	public static final String SBV_01_VALIDATE_FILE = "sbv_01_";
}
