package com.vnsw.send.gateway.util;

public class Constants {

    public interface RESPONSETYPE {

        public static final String FUNCTION_01 = "01";
        public static final String TYPE_SUCCESS = "99";
        public static final String ERROR = "00";
    }
    
    public interface ERROR {
        public static final String ERR01_CODE = "ERR01_CODE";
        public static final String ERR02_CODE = "ERR02_CODE";
        public static final String ERR03_CODE = "ERR03_CODE";
        public static final String ERR01 = "Lỗi trong quá trình xử lý bản tin";
    }

    public interface CDATA {

        public static final String START_TAG = "<![CDATA[";
        public static final String END_TAG = "]]>";
    }

    public interface LOCAL_WEBSERVICE {

        public static final String PREFIX_NAMESPACE_KEY = "_NAMESPACE_KEY";
        public static final String PREFIX_URI = "_LINK";
        public static final String PREFIX_NAMESPACE = "_NAMESPACE";
        public static final String PREFIX_METHOD_TAG = "_MOTHOD_TAG";
        public static final String PREFIX_PAYLOAD_TAG = "_PAYLOAD_TAG";
        public static final String NAMESPACE_URI = "http://com/vnsw/send/gateway/generated";
        public static final String COMMON_METHOD_TAG = "receiveRequest";
        public static final String PREFIX_NAMESPACE_KEY_METHOD_TAG = "_NAMESPACE_KEY_METHOD_TAG";
        public static final String PREFIX_NAMESPACE_KEY_PAYLOAD_TAG = "_NAMESPACE_KEY_PAYLOAD_TAG";
        public static final String PREFIX_SOAP_ACTION = "_ACTION";
        public static final String PREFIX_HEADER_TO = "_HEADER_TO";
    }
    
    
    public interface ENVELOP_TAG_ENCODE {

        public static final String OPEN_TAG = "&lt;Envelope&gt;";
        public static final String CLOSE_TAG = "&lt;/Envelope&gt;";
    }
    
    public static final String MESSAGE_SEPARATOR = "\\{}";
    public static final String APP_NAME = "SEND_GATEWAY";
    public static final String UNDERLINE_SEPARATOR = "_";
    
    public interface TAG_ENCODE {

        public final static String OPEN_TAG = "&lt;";
        public static final String CLOSE_TAG = "&gt;";
    }
    
    public interface TAG_NO_ENCODE {

        public final static String OPEN_TAG = "<";
        public static final String CLOSE_TAG = ">";
    }
    
    public interface MINISTRY_CODE {
        public final static String MARD = "BNN";
        public final static String BTNMT = "BTNMT";
        public final static String BGT = "BGT";
        public final static String NHNN = "NHNN";
    }
}
