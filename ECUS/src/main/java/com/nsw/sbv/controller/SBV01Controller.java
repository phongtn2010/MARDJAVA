package com.nsw.sbv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.sbv.p01.util.SBV01Constants;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

@Controller
@RequestMapping(value = SBV01Constants.URL_SBV_01)
@PropertySource("classpath:sbv_api.properties")
public class SBV01Controller {

	public static final Logger LOGGER = LoggerFactory.getLogger(SBV01Controller.class);

	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	private Environment environment;

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	protected MessageSource messageSource;


	@RequestMapping(value = SBV01Constants.URL_PAGE_INDEX, method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes,
			Locale locale, ModelMap model) {

		try {

			
				setBreadcrumb(false, model);
				model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
				model.addAttribute(AppConstant.DanhMuc.UserName, "");
				model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
				model.addAttribute(AppConstant.DanhMuc.Applet,
						environment.getRequiredProperty(AppConstant.Common.APPLET));
				model.addAttribute(AppConstant.DanhMuc.Sign,
						environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

			

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);


		}

		return SBV01Constants.PAGE_INDEX;
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
					mTabs = AppHelper.GetMenusForUser(user.getTabs(),
							environment.getRequiredProperty("nsw.fontend.url"));
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

}
