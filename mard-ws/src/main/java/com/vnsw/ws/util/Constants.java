package com.vnsw.ws.util;

public class Constants {

    public static final String BNN = "BNN";
	public static final String BNNPTNT = "BNN";
    public static final String APP_NAME = "MARDWs";
    public static final String MESSAGE_SEPARATOR = "\\{}";
    
    public interface FROM {
    	public static final String NAME = "NSW";
    	public static final String IDENTITY = "NSW";
    	public static final String COUNTRY_CODE = "VN";
    	public static final String MINISTRY_CODE = "BTC";
    	public static final String ORAGANIZATION_CODE = "TCHQ";
    	public static final String UNIT_CODE = "NSW";
    }
    
    public interface TO {
    	public static final String NAME = "BNN";
    	public static final String IDENTITY = "BNN";
    	public static final String COUNTRY_CODE = "VN";
    	public static final String MINISTRY_CODE = "BNN";
    	public static final String ORAGANIZATION_CODE = "BNN";
        public static final String UNIT_CODE = "BNN";
    }
    
    public interface VERSION {
    	public static final String SEND_VERSION = "01";
    	public static final String RECEIVE_VERSION = "01";
    }
    
    public interface FUNCTION {
    	public static final String FUNC_SUCCESS = "99";
    	public static final String FUNC_ERROR = "00";
    }    

    public interface MARD_PRO {
        public static final String ERROR = "00";
        public static final String MARD01 = "BNNPTNT0600004";
        public static final String MARD06 = "BNNPTNT0600009";
        public static final String MARD07 = "BNNPTNT0600010";
        public static final String MARD08 = "BNNPTNT0600011";
        public static final String MARD09 = "BNNPTNT0600012";
        public static final String MARD10 = "BNN&PTNT0600003";
        public static final String MARD11 = "BNN&PTNT0300002";
        public static final String MARD12_01 = "BNN&PTNT0200003";
        public static final String MARD12_02 = "BNN&PTNT0200002";
        public static final String MARD_04 = "BNNPTNT0300004";//File Service
		public static final String MARD_02 = "BNNPTNT0600005";
		public static final String MARD_03 = "BNNPTNT0600006";
        public static final String MARD25 = "BNNPTNT0200025";
    }

    public interface MARD_PRO_RECEIVE {
        public static final String MARD12_01 = "BNN&amp;PTNT0200003";
        public static final String MARD12_02 = "BNN&amp;PTNT0200002";
    }
	    public interface BNNPTNT_PRO {

        public static final String ERROR = "00";
        public static final String BNNPTNT04 = "BNNPTNT0300004";//File Service
    }

    public interface PROCEDURE {

        public static final String MOST05 = "05";
        public static final String MOST06 = "06";
    }

    public interface ERROR {
    	
    	public static final String ERR00_CODE = "ERR00_CODE";
    	public static final String ERR01_CODE = "ERR01_CODE";
        public static final String ERR02_CODE = "ERR02_CODE";
        public static final String ERR03_CODE = "ERR03_CODE";
        public static final String ERR04_CODE = "ERR04_CODE";
        public static final String ERR05_CODE = "ERR05_CODE";
        public static final String ERR06_CODE = "ERR05_CODE";

        public static final String ERR00 = "Bản tin không hợp lệ";
        public static final String ERR01 = "Thủ tục chưa được định nghĩa";
        public static final String ERR02 = "Phân tích xml bị lỗi";
        public static final String ERR03 = "Lỗi phân tích xml: không lấy được thủ tục từ xml";
        public static final String ERR04 = "Message Type: Không tồn tại ";
        public static final String ERR05 = "Nội dung bản tin không có dữ liệu, hoặc không hợp lệ.";


        public static final String BNN06_CODE = "BNN06_CODE";
        public static final String BNN06 = "Không lưu được dữ liệu!";

        public static final String BNN08_CODE = "BNN08_CODE";
        public static final String BNN08 = "Không lưu được dữ liệu!";
        
        public static final String BNN10_CODE = "BNN10_CODE";
        public static final String BNN10 = "Không lưu được dữ liệu!";
        
        public static final String BNN11_CODE = "BNN11_CODE";
        public static final String BNN11 = "Không lưu được dữ liệu!";

        public static final String BNN04_CODE = "BNN04_CODE";
        public static final String BNN04 = "Không lưu được dữ liệu!";
		public static final String BNN_03 = "Không lưu được dữ liệu!";
		public static final String BNN_04 = "Không lưu được dữ liệu!";
    }

    public interface RES_URI {

        public static final String URI_TOKHAI = "/eMoitService/ServiceTCTKHQ.svc?wsdl";

        public static final String URL_UPLOAD = "/file/upload";
        public static final String URL_DOWNLOAD = "/file/download";
    }

    public interface RES_METHOD {

        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }

    public interface DONVI {

        public static final String NSW = "NSW";
        public static final String KHCN = "KHCN";
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
		public static final String MARD04 = "mard04_";
        public static final String BNN12 = "mard12_";
		public static final String MARD02 = "mard02_";
		public static final String MARD03 = "mard03_";
    }
    
    public static final String XML_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
