package com.nsw.monre.p01.util;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsw.monre.p01.constant.AppKeyConstant;
import com.nsw.monre.p01.constant.AppViewThuTuc01Constant;
import com.nsw.monre.p05.constant.AppViewThuTuc05Constant;

public class AppCommon {

	public static final Logger LOGGER = LoggerFactory.getLogger(AppCommon.class);

	
	private AppCommon() {
	}

	

	public static boolean visiableByStatus( int trangThai, int[] trangThaiChecks) {

		try {

			if (trangThaiChecks != null) {

				for (int item : trangThaiChecks)
					if (item == trangThai)
						return true;
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return false;
	}

	public static String getUri(HttpServletRequest request) {

		String maThuTuc = getLoaiThuTuc(request);

		if (maThuTuc == null) return "";
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_01;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_02;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC))
			return AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_03;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC))
			return AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_04;
		
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_05_QUY_TRINH_CAP_LAI_GIAY_XN_DA_MAT_CON_THOI_HAN))
			return AppViewThuTuc05Constant.ViewURL.URI_THU_TUC_05;

		return "";
	}

	
	public static String getLoaiThuTuc(HttpServletRequest request) {

		String url = (String) request.getAttribute("javax.servlet.forward.request_uri");

		if (url == null) {

			url = request.getRequestURL().toString();

		}

		if (url.contains(AppKeyConstant.LoaiThuTuc.URL_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return AppKeyConstant.LoaiThuTuc.MA_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP;


		if (url.contains(AppKeyConstant.LoaiThuTuc.URL_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return AppKeyConstant.LoaiThuTuc.MA_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP;


		if (url.contains(AppKeyConstant.LoaiThuTuc.URL_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC))
			return AppKeyConstant.LoaiThuTuc.MA_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC;


		if (url.contains(AppKeyConstant.LoaiThuTuc.URL_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC))
			return AppKeyConstant.LoaiThuTuc.MA_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC;
		
		if (url.contains(AppKeyConstant.LoaiThuTuc.URL_THU_TUC_05_QUY_TRINH_CAP_LAI_GIAY_XN_DA_MAT_CON_THOI_HAN))
			return AppKeyConstant.LoaiThuTuc.MA_THU_TUC_05_QUY_TRINH_CAP_LAI_GIAY_XN_DA_MAT_CON_THOI_HAN;

		return null;
	}

	public static int getHinhThuc(HttpServletRequest request) {

		String maThuTuc = getLoaiThuTuc(request);

		if (maThuTuc == null) return 0;
		
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return 0;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return 0;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC))
			return 1;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC))
			return 1;
		
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_05_QUY_TRINH_CAP_LAI_GIAY_XN_DA_MAT_CON_THOI_HAN))
			return 1;

		return 0;
	}
	
	public static int getLoaiHoSo(HttpServletRequest request) {

		String maThuTuc = getLoaiThuTuc(request);

		if (maThuTuc == null) return 0;
		
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return 1;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return 2;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC))
			return 1;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC))
			return 2;

		return 1;
	}

	public static int getLoaiThuTucHienTai(HttpServletRequest request) {

		String maThuTuc = getLoaiThuTuc(request);

		if (maThuTuc == null) return 0;
		
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return AppKeyConstant.LoaiThuTuc.THU_TUC_01;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return AppKeyConstant.LoaiThuTuc.THU_TUC_02;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC))
			return AppKeyConstant.LoaiThuTuc.THU_TUC_03;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC))
			return AppKeyConstant.LoaiThuTuc.THU_TUC_04;
		
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_05_QUY_TRINH_CAP_LAI_GIAY_XN_DA_MAT_CON_THOI_HAN))
			return AppKeyConstant.LoaiThuTuc.THU_TUC_05;

		return 0;
	}

	public static String getMonreContextPath(HttpServletRequest request) {

		String maThuTuc = getLoaiThuTuc(request);

		if (maThuTuc == null) return "";
		
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return request.getContextPath() + AppKeyConstant.LoaiThuTuc.URL_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP))
			return request.getContextPath()
					+ AppKeyConstant.LoaiThuTuc.URL_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC))
			return request.getContextPath() + AppKeyConstant.LoaiThuTuc.URL_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC;

		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC))
			return request.getContextPath()
					+ AppKeyConstant.LoaiThuTuc.URL_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC;
		
		if (maThuTuc.equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_05_QUY_TRINH_CAP_LAI_GIAY_XN_DA_MAT_CON_THOI_HAN))
			return request.getContextPath()
					+ AppKeyConstant.LoaiThuTuc.URL_THU_TUC_05_QUY_TRINH_CAP_LAI_GIAY_XN_DA_MAT_CON_THOI_HAN;

		return "";
	}

	
	
	
	public static String redirectPage(HttpServletRequest request, String pageURL) {
		
		
		return "redirect:" + getUri(request) + pageURL;
	}


}
