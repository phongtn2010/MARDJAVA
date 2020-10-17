package com.nsw.monre.p01.constant;




public class ThuTuc01Constant {

	
	private ThuTuc01Constant() {
	}
	public static final int RESTTEMPLATE_TIMEOUT = 60000;

	public static final String HOST_NAME = "monre.01.backend";

    public class API {
    	
        private API() {
		}
		public static final String BACKEND = "monre.01.backend";
        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String SERVICE = "monre.01.service";
    }
	public class FileUpload {
		
	    private FileUpload() {
		}

		public static final int FILESIZETHRESHOLD = 20971520;
	}
	
    
}