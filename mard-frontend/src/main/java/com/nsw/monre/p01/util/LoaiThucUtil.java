package com.nsw.monre.p01.util;

import javax.servlet.http.HttpServletRequest;

import com.nsw.monre.p01.constant.AppKeyConstant;

public class LoaiThucUtil {

	
	private LoaiThucUtil() {
	}

	public static int layLoaiThuTuc(HttpServletRequest request) {
		
		String currentURL = (String)request.getAttribute("javax.servlet.forward.request_uri");
		
		if (currentURL == null) return -1;
		
		String[] items = currentURL.split("/");
		
		if (items != null && items.length >= 4) {
			
			String thuThuc = "/" + items[2] + "/" + items[3];
			
			if (thuThuc.equals(AppKeyConstant.LoaiThuTuc.URL_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP)) return 1;
			
			if (thuThuc.equals(AppKeyConstant.LoaiThuTuc.URL_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP)) return 2;
		}
		
		return -1;
	}
}
