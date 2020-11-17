package com.vnsw.ws.util;

import java.text.SimpleDateFormat;

public class Constants {

    public static final String SBV = "SBV";    
    public static final String APP_NAME = "MONREWs";
    public static final String MESSAGE_SEPARATOR = "\\{}";
    
    public final SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    public final SimpleDateFormat formatterDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public interface FileFolder {
		public static final String TempSaveFolder = "FOLDER_TEMP_FILE_SERVICE";
	}
    
    public interface SBV_PRO {
		public static final String ERROR = "00";
		public static final String SBV1 = "NHNN.QLNH0001";
	}
    
    public interface FROM {
    	public static final String NAME = "NSW";
    	public static final String IDENTITY = "NSW";
    	public static final String COUNTRY_CODE = "VN";
    	public static final String MINISTRY_CODE = "NSW";
    	public static final String ORAGANIZATION_CODE = "TCHQ";
    	public static final String UNIT_CODE = "NSW";
    }
    
    public interface TO {
    	public static final String NAME = "SBV";
    	public static final String IDENTITY = "SBV";
    	public static final String COUNTRY_CODE = "VN";
    	public static final String MINISTRY_CODE = "SBV";
    	public static final String ORAGANIZATION_CODE = "SBV";
        public static final String UNIT_CODE = "SBV";
    }
    
    public interface VERSION {
    	public static final String SEND_VERSION = "01";
    	public static final String RECEIVE_VERSION = "01";
    }
    
    public interface FUNCTION {
    	public static final String FUNC_SUCCESS = "99";
    	public static final String FUNC_ERROR = "00";
    }        
    public interface PROCEDUCE {
    	public static final String ERROR = "00";
        public static final String SBV01 = "NHNN.QLNH0001";
        public static final String SBV02 = "NHNN.QLNH0002";
        public static final String SBV03 = "NHNN.QLNH0003";
        public static final String SBV04 = "NHNN.QLNH0004";
    }

    public interface ERROR {
    	
    	public static final String ERR00_CODE = "ERR00_CODE";
    	public static final String ERR01_CODE = "ERR01_CODE";
        public static final String ERR02_CODE = "ERR02_CODE";
        public static final String ERR03_CODE = "ERR03_CODE";   
        public static final String ERR04_CODE = "ERR04_CODE";   
        public static final String ERR05_CODE = "ERR05_CODE";   
        
        public static final String ERR00 = "Bản tin không hợp lệ";
        public static final String ERR01 = "Thủ tục chưa được định nghĩa";
        public static final String ERR02 = "Phân tích xml bị lỗi";
        public static final String ERR03 = "Lỗi phân tích xml: không lấy được thủ tục từ xml";
        public static final String ERR04 = "Message Type: Không tồn tại ";
        public static final String ERR05 = "Nội dung bản tin không có dữ liệu, hoặc không hợp lệ.";
    }

    public interface RES_URI {
        public static final String URI_TOKHAI = "/eMonreService/ServiceTCTKHQ.svc?wsdl";
        public static final String URL_UPLOAD = "/file/upload";
        public static final String URL_DOWNLOAD = "/file/download";
    }

    public interface RES_METHOD {

        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }

    public interface DONVI {
        public static final String NSW = "NSW";
        public static final String SBV = "SBV";
    }
    
    public interface CDATA {

        public static final String START_TAG = "<![CDATA[";
        public static final String END_TAG = "]]>";
    }
    
    public interface RESPONSETYPE {

        public static final String FUNCTION_01 = "01";
        public static final String TYPE_SUCCESS = "99";
        public static final String ERROR = "00";
    }
            
    public interface ENVELOP_TAG_ENCODE {

        public static final String OPEN_TAG = "&amp;lt;Envelope&amp;gt;";
        public static final String CLOSE_TAG = "&amp;lt;/Envelope&amp;gt;";
    }
    
    public interface TAG_ENCODE {

        public final static String OPEN_TAG = "&amp;lt;";
        public static final String CLOSE_TAG = "&amp;gt;";
        public static final String UNKNOW_TAG = "";
        public static final String AND_TAG = "&amp;";
    }
    
    public interface TAG_NO_ENCODE {

        public final static String OPEN_TAG = "<";
        public static final String CLOSE_TAG = ">";
        public static final String AND_TAG = "&";
    }
    
    public interface STATUS {

        public final static String ACTIVE = "1";
        public static final String INACTIVE = "0";
    }
    
    public interface XSDPREFIX {
        public static final String SBV01 = "snv01_";
        public static final String SBV02 = "sbv02_";
    }
    
    public static final String XML_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
