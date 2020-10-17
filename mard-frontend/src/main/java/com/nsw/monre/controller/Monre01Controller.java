package com.nsw.monre.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.monre.p01.constant.AppKeyConstant;
import com.nsw.monre.p01.constant.AppViewThuTuc01Constant;
import com.nsw.monre.p01.model.TbdHSDeNghiCapGiayXn1;
import com.nsw.monre.p01.model.UserInfo;
import com.nsw.monre.p01.service.TbdHSDeNghiCapGiayXn1Service;
import com.nsw.monre.p01.service.TbsCoQuanXuLy1Service;
import com.nsw.monre.p01.util.AppCommon;
import com.nsw.monre.p01.util.ConvertToObjectUtil;
import com.nsw.monre.p01.util.LoginUtil;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_01,
		AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_02, AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_03,
		AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_04 })
public class Monre01Controller {

	public static final Logger LOGGER = LoggerFactory.getLogger(Monre01Controller.class);

	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	protected MessageSource mMessageSource;

	@Autowired
	private TbdHSDeNghiCapGiayXn1Service mTbdHSDeNghiCapGiayXn1Service;

	@Autowired
	protected TbsCoQuanXuLy1Service mTbsCoQuanXuLy1Service;

	@Autowired
	private Environment environment;

	@Autowired
	private HttpSession httpSession;

	@InitBinder
	public void bindData(WebDataBinder binder) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@SuppressWarnings("unchecked")
	public List<Tab> getMenuData() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Tab> tabs = null;
		if (principal instanceof UserDetails) {
			UserCustom user = (UserCustom) principal;
			if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
				tabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
			} else {
				tabs = AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url"));
				httpSession.setAttribute(Constants.MENU_SESSION, tabs);
			}
		}
		return tabs;
	}

	@RequestMapping(value = AppViewThuTuc01Constant.ViewURL.INDEX_URL, method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes,
			Locale locale, ModelMap model) {

		try {

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				UserCustom user = (UserCustom) principal;
				setBreadcrumb(false, model, request);
				model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
				model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
				model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
				model.addAttribute(AppConstant.DanhMuc.Applet,
						environment.getRequiredProperty(AppConstant.Common.APPLET));
				model.addAttribute(AppConstant.DanhMuc.Sign,
						environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

				layThongTinLoaiThuTuc(request, model);

			} else {
				return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
			}

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e.getCause());

			pushLog(e);

		}

		return AppViewThuTuc01Constant.PageView.PAGE_INDEX;
	}

	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.XEM_HO_SO_URL + "/{id}" }, method = RequestMethod.GET)
	public String xemHoSo(@PathVariable("id") long id, HttpServletRequest request, ModelMap model) {

		try {

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				UserCustom user = (UserCustom) principal;
				setBreadcrumb(false, model, request);
				model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
				model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
				model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
				model.addAttribute(AppConstant.DanhMuc.Applet,
						environment.getRequiredProperty(AppConstant.Common.APPLET));
				model.addAttribute(AppConstant.DanhMuc.Sign,
						environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

				UserInfo userInfo = LoginUtil.getUserInfo();

				TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service
						.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(id, AppCommon.getLoaiThuTuc(request), 0,
								userInfo.getMaSoThue());

				if (capGiayXn1 == null) {

					return AppCommon.redirectPage(request, AppViewThuTuc01Constant.ViewURL.INDEX_URL);
				}

				capGiayXn1.setXemHoSo(true);

				layThongTinLoaiThuTuc(request, model);
				model.addAttribute("form", capGiayXn1);
				model.addAttribute("yeuCauKySo", isSign());

			} else {
				return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
			}

		} catch (Exception e) {

			pushLog(e);
		}

		return AppViewThuTuc01Constant.PageView.PAGE_TO_KHAI;
	}

	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.KHAI_HO_SO_MOI_URL }, method = RequestMethod.GET)
	public String themMoiHoSo(ModelMap model, HttpServletRequest request) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserCustom user = (UserCustom) principal;
			setBreadcrumb(false, model, request);
			model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
			model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
			model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
			model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
			model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

			try {

				layThongTinLoaiThuTuc(request, model);

				UserInfo userInfo = LoginUtil.getUserInfo();
				TbdHSDeNghiCapGiayXn1 capGiayXn1 = ConvertToObjectUtil.convertTo(userInfo, new TbdHSDeNghiCapGiayXn1());
				model.addAttribute("form", capGiayXn1);
				model.addAttribute("yeuCauKySo", isSign());

			} catch (Exception e) {

				pushLog(e);
			}

		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return AppViewThuTuc01Constant.PageView.PAGE_TO_KHAI;
	}

	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.CHINH_SUA_HO_SO_URL, }, method = RequestMethod.GET)
	public String suaHoSo(ModelMap model, @PathVariable("id") long id, HttpServletRequest request) {

		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				UserCustom user = (UserCustom) principal;
				setBreadcrumb(false, model, request);
				model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
				model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
				model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
				model.addAttribute(AppConstant.DanhMuc.Applet,
						environment.getRequiredProperty(AppConstant.Common.APPLET));
				model.addAttribute(AppConstant.DanhMuc.Sign,
						environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

				UserInfo userInfo = LoginUtil.getUserInfo();
				TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service
						.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(id, AppCommon.getLoaiThuTuc(request), 0,
								userInfo.getMaSoThue());

				
				if (capGiayXn1 == null) {

					return AppCommon.redirectPage(request, AppViewThuTuc01Constant.ViewURL.INDEX_URL);
				}

				if (!capGiayXn1.getMaSoThue().equals(userInfo.getMaSoThue())) {

					LOGGER.info("[ Ban khong phai la nguoi tao ra ho so nay " + userInfo.getMaSoThue() + " | "
							+ capGiayXn1.getMaSoThue() + " ]");

					return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
				}
				
				

				if (capGiayXn1.getTrangThai() == AppKeyConstant.Status.TAO_MOI
						|| capGiayXn1.getTrangThai() == AppKeyConstant.Status.GUI_MOI
						|| capGiayXn1.getTrangThai() == AppKeyConstant.Status.KHAI_SUA
						|| capGiayXn1.getTrangThai() == AppKeyConstant.Status.SUA_DOI_BO_SUNG
						|| capGiayXn1.getTrangThai() == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG
						|| capGiayXn1.getTrangThai() == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG_SAU_KIEM_TRA) {

					layThongTinLoaiThuTuc(request, model);

					model.addAttribute("form", capGiayXn1);
					model.addAttribute("yeuCauKySo", isSign());
					
					return AppViewThuTuc01Constant.PageView.PAGE_TO_KHAI;
				}

				


			} else {
				return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
			}
		} catch (Exception e) {

			pushLog(e);
		}
		
		return AppCommon.redirectPage(request, AppViewThuTuc01Constant.ViewURL.INDEX_URL);
	}

	/**
	 * Ghi log nen server
	 * 
	 * @param ex
	 */
	public void pushLog(Exception ex) {

		try {

			String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName()
					+ AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AppConstant.MESSAGE_SEPARATOR + ex.toString();

			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

	/**
	 * Lay ten thu tuc
	 * 
	 * @param request
	 * @param model
	 */
	private void layThongTinLoaiThuTuc(HttpServletRequest request, ModelMap model) {

		int loaiThuTuc = AppCommon.getLoaiThuTucHienTai(request);

		String tenThuTuc = "tenThuTuc";
		switch (loaiThuTuc) {
		case AppKeyConstant.LoaiThuTuc.THU_TUC_01:
			model.put(tenThuTuc, mMessageSource.getMessage("monre.01.tt01.ten-thu-tuc", null, request.getLocale()));
			break;
		case AppKeyConstant.LoaiThuTuc.THU_TUC_02:
			model.put(tenThuTuc, mMessageSource.getMessage("monre.01.tt02.ten-thu-tuc", null, request.getLocale()));
			break;
		case AppKeyConstant.LoaiThuTuc.THU_TUC_03:
			model.put(tenThuTuc, mMessageSource.getMessage("monre.01.tt03.ten-thu-tuc", null, request.getLocale()));
			break;
		default:
			model.put(tenThuTuc, mMessageSource.getMessage("monre.01.tt04.ten-thu-tuc", null, request.getLocale()));
			break;
		}
	}

	private void setBreadcrumb(boolean isDetail, ModelMap model, HttpServletRequest request) {
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		Breadcrumb nav = new Breadcrumb(AppCommon.getUri(request) + "/home",
				environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
		breadcrumbs.add(nav);
		if (isDetail) {
			nav = new Breadcrumb("#", environment.getRequiredProperty(AppConstant.Breadcrumb.DETAIL));
			breadcrumbs.add(nav);
		}
		model.addAttribute(AppConstant.Common.BREADCRUMB, breadcrumbs);
	}
	
	private boolean isSign() {
		return  Boolean.parseBoolean(environment.getRequiredProperty("monre.01.sign"));
	}
	
	@RequestMapping(value = "/edit/share/js/ca/setup.exe", method = RequestMethod.GET)
	public void downloaCaPlugin(HttpServletResponse response, HttpServletRequest request) {
		
		String userAgent = request.getHeader("User-Agent");
		LOGGER.info("userAgent: {}", userAgent);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			try {
				ClassLoader classLoader = getClass().getClassLoader();
				String fileName = "/share/js/ca/setup.exe";
				if (!userAgent.contains("Win64;") && !userAgent.contains("x64")) {
					fileName = "/share/js/ca/setup_32bit.exe";
				}
				Path path = Paths.get(classLoader.getResource(fileName).toURI());
				File file = path.toFile();
				if (file == null) return;
				String mimeType =  "application/octet-stream";
				response.setContentType(mimeType);
				response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "setup.exe"));
				response.setContentLength((int)file.length());
				FileCopyUtils.copy(Files.readAllBytes(path), response.getOutputStream());
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(),ex);
			} 
		}
	}

}
