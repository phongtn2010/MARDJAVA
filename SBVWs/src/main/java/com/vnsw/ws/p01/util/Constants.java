package com.vnsw.ws.p01.util;

import java.text.SimpleDateFormat;

public class Constants {

	public static final String SBV = "SBV";
	public static final String APP_NAME = "SBVWs";
	public static final String MESSAGE_SEPARATOR = "\\{}";
	
	public final SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
	String formatString = "{} yyyy-MM-dd HH:mm:ss";
	public final SimpleDateFormat formatterDateTime = new SimpleDateFormat(formatString);

	public static final String FILEFOLDER_TEMPSAVE = "FOLDER_TEMP_FILE_SERVICE";

	public static final String SIGN_ON = "true";
	public static final String SIGN_OFF = "false";

	public static final String FROM_NAME = "NSW";
	public static final String FROM_IDENTITY = "NSW";
	public static final String FROM_COUNTRY_CODE = "VN";
	public static final String FROM_MINISTRY_CODE = "NHNN";
	public static final String FROM_ORAGANIZATION_CODE = "TCHQ";
	public static final String FROM_UNIT_CODE = "NSW";

	public static final String TO_NAME = "SBV";
	public static final String TO_IDENTITY = "SBV";
	public static final String TO_COUNTRY_CODE = "VN";
	public static final String TO_MINISTRY_CODE = "SBV";
	public static final String TO_ORAGANIZATION_CODE = "SBV";
	public static final String TO_UNIT_CODE = "SBV";

	public static final String SEND_VERSION = "01";
	public static final String RECEIVE_VERSION = "01";

	public static final String FUNC_SUCCESS = "99";
	public static final String FUNC_ERROR = "00";

	public static final String SBV1_ERROR = "00";
	public static final String SBV1_PRO = "NHNN.QLNH0001";

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

	public static final String URI_TOKHAI = "/eSBVService/ServiceTCTKHQ.svc?wsdl";

	public static final String URL_FILE_SERVICE = "URI_ADDRESS_FILE_SERVER";
	public static final String URL_UPLOAD = "/file/upload/";
	public static final String URL_DOWNLOAD = "/file/download/";

	public static final String RES_METHOD_POST = "POST";
	public static final String RES_METHOD_PUT = "PUT";
	public static final String RES_METHOD_DELETE = "DELETE";

	public static final String DONVI_NSW = "NSW";
	public static final String DONVI_SBV = "SBV";

	public static final String SCDATA_TART_TAG = "<![CDATA[";
	public static final String CDATA_END_TAG = "]]>";

	public static final String RESPONSETYPE_FUNCTION_01 = "01";
	public static final String RESPONSETYPE_TYPE_SUCCESS = "99";
	public static final String RESPONSETYPE_ERROR = "00";

	public static final String ENVELOP_TAG_ENCODE_OPEN_TAG = "&amp;lt;Envelope&amp;gt;";
	public static final String ENVELOP_TAG_ENCODE_CLOSE_TAG = "&amp;lt;/Envelope&amp;gt;";

	public static final String TAG_ENCODE_OPEN_TAG = "&amp;lt;";
	public static final String TAG_ENCODE_CLOSE_TAG = "&amp;gt;";
	public static final String TAG_ENCODE_UNKNOW_TAG = "";
	public static final String TAG_ENCODE_AND_TAG = "&amp;";

	public static final String TAG_NO_ENCODE_OPEN_TAG = "<";
	public static final String TAG_NO_ENCODE_CLOSE_TAG = ">";
	public static final String TAG_NO_ENCODE_AND_TAG = "&";

	public static final String STATUS_ACTIVE = "1";
	public static final String STATUS_INACTIVE = "0";

	public static final String XSDPREFIX_SBV06 = "SBV06_";
	public static final String XSDPREFIX_SBV01 = "SBV01_";
	public static final String XSDPREFIX_SBV02 = "SBV02_";
	public static final String XSDPREFIX_SBV03 = "SBV03_";
	public static final String XSDPREFIX_SBV04 = "SBV04_";

	public static final String XML_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	
	
}
