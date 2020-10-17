package com.nsw.sbv.controller;

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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
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
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.sbv.p01.model.HoSoNgoaiTe1;
import com.nsw.sbv.p01.model.HoSoNgoaiTeEditForm;
import com.nsw.sbv.p01.util.SBV01Constants;
import com.nsw.sbv.p01.util.SBV01HoSoNgoaiTe1BackendUtil;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

@Controller
@RequestMapping(value = SBV01Constants.URL_SBV_01)
@PropertySource("classpath:sbv_api.properties")
public class SBV01Controller {

	public static final Logger LOGGER = LoggerFactory.getLogger(SBV01Controller.class);

	private static final String REDIRECT_HOME_INDEX = "redirect:/sbv/01/home";

	private static final String IS_SIGN_KEY = "nsw.sbv.01.sign";

	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	private Environment environment;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	protected MessageSource messageSource;

	@InitBinder
	public void bindData(WebDataBinder binder) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = SBV01Constants.URL_PAGE_INDEX, method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes, Locale locale, ModelMap model) {

		try {

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				UserCustom user = (UserCustom) principal;
				setBreadcrumb(false, model);
				model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
				model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
				model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
				model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
				model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
				boolean isSign = Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
				model.addAttribute("IS_SIGN_KEY", isSign);

			} else {
				return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
			}

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);

			pushLog(e);

		}

		return SBV01Constants.PAGE_INDEX;
	}

	@RequestMapping(value = { SBV01Constants.URL_PAGE_EDIT }, method = RequestMethod.GET)
	public String add(ModelMap model, HttpServletRequest request) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserCustom user = (UserCustom) principal;
			setBreadcrumb(false, model);
			model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
			model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
			model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
			model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
			model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

			try {
				boolean isSign = Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
				HoSoNgoaiTeEditForm editForm = new HoSoNgoaiTeEditForm();
				editForm.setSign(isSign);
				model.addAttribute("form", editForm);
			} catch (Exception e) {

				LOGGER.error(e.getMessage(), e);

				pushLog(e);
			}

		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return SBV01Constants.PAGE_EDIT;
	}

	@RequestMapping(value = { SBV01Constants.URL_PAGE_EDIT + "/{id}" }, method = RequestMethod.GET)
	public String edit(ModelMap model, HttpServletRequest request, @PathVariable("id") long id) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserCustom user = (UserCustom) principal;
			setBreadcrumb(false, model);
			model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
			model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
			model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
			model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
			model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

			try {

				boolean isSign = Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
				HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL("com.nsw.sbv.p01.hoSoNgoaiTe1.get"), id);
				HoSoNgoaiTeEditForm editForm = new HoSoNgoaiTeEditForm();
				BeanUtils.copyProperties(hoSoNgoaiTe1, editForm);
				editForm.setSign(isSign);

				if (hoSoNgoaiTe1 == null || !hoSoNgoaiTe1.getMaSoThue().equals(user.getUsername())) return REDIRECT_HOME_INDEX;

				if (isHasEditPermission(hoSoNgoaiTe1)) {
					model.addAttribute("form", editForm);

					return SBV01Constants.PAGE_EDIT;
				}

			} catch (Exception e) {

				LOGGER.error("[edit][" + e.getMessage() + "]", e);

			}

		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return REDIRECT_HOME_INDEX;
	}

	private String getURL(String uriKey) {
		return environment.getRequiredProperty("sbv.01.backend") + environment.getRequiredProperty(uriKey);
	}

	@SuppressWarnings("unchecked")
	public List<Tab> getMenuData() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Tab> mTabs = null;
		if (principal instanceof UserDetails) {
			UserCustom user = (UserCustom) principal;
			if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
				mTabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
			} else {
				mTabs = AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url"));
				httpSession.setAttribute(Constants.MENU_SESSION, mTabs);
			}
		}
		return mTabs;
	}

	private void setBreadcrumb(boolean isDetail, ModelMap model) {
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		Breadcrumb nav = new Breadcrumb("/sbv/01/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
		breadcrumbs.add(nav);
		if (isDetail) {
			nav = new Breadcrumb("#", environment.getRequiredProperty(AppConstant.Breadcrumb.DETAIL));
			breadcrumbs.add(nav);
		}
		model.addAttribute(AppConstant.Common.BREADCRUMB, breadcrumbs);
	}

	/**
	 * Ghi log nen server
	 * 
	 * @param ex
	 */
	public void pushLog(Exception ex) {

		String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName() + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

		RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

	}

	private boolean isHasEditPermission(HoSoNgoaiTe1 hoSoNgoaiTe1) {

		boolean isFalse = false;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserCustom user = (UserCustom) principal;

		if (user.getUsername().equals(hoSoNgoaiTe1.getMaSoThue())) return true;
		if (hoSoNgoaiTe1.getTrangThai() == SBV01Constants.Status.TAO_MOI) return true;
		if (hoSoNgoaiTe1.getTrangThai() == SBV01Constants.Status.CHO_TIEP_NHAN) return true;
		if (hoSoNgoaiTe1.getTrangThai() == SBV01Constants.Status.YEU_CAU_SDBS) return true;

		return isFalse;
	}

	@RequestMapping(value = { "/share/js/ca/setup.exe", "/edit/share/js/ca/setup.exe" }, method = RequestMethod.GET)
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
				String mimeType = "application/octet-stream";
				response.setContentType(mimeType);
				response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "setup.exe"));
				response.setContentLength((int) file.length());
				FileCopyUtils.copy(Files.readAllBytes(path), response.getOutputStream());

			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}
	}

}
