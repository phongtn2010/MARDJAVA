package com.vnsw.receive.gateway.util;

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

        public static final String COMMON_NAMESPACE = "http://com/vnsw/ws/generated";
        public static final String NAMESPACE_URI = "http://com/vnsw/receive/gateway/generated";
        public static final String COMMON_NAMESPACE_KEY = "gen";
        public static final String COMMON_METHOD_TAG = "receiveRequest";
        public static final String COMMON_PAYLOAD_TAG = "requestPayload";
    }
    
    
    public interface ENVELOP_TAG_ENCODE {

        public static final String OPEN_TAG = "&lt;Envelope&gt;";
        public static final String CLOSE_TAG = "&lt;/Envelope&gt;";
    }
    
    public static final String APP_NAME = "RECEIVE_GATEWAY";
    public static final String MESSAGE_SEPARATOR = "\\{}";
    
    public interface TAG_ENCODE {

        public final static String OPEN_TAG = "&lt;";
        public static final String CLOSE_TAG = "&gt;";
    }
    
    public interface TAG_NO_ENCODE {

        public final static String OPEN_TAG = "<";
        public static final String CLOSE_TAG = ">";
    }
}
