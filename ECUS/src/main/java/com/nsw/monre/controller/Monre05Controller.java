package com.nsw.monre.controller;

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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.monre.p05.constant.AppViewThuTuc05Constant;
import com.nsw.monre.p05.model.TbdHSDeNghiCapGiayXn5;
import com.nsw.monre.p01.model.TbsCoQuanXuLy1;
import com.nsw.monre.p05.service.TbdHSDeNghiCapGiayXn5Service;
import com.nsw.monre.p01.service.TbsCoQuanXuLy1Service;
import com.nsw.monre.p01.util.AppCommon;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.URI_THU_TUC_05 })
public class Monre05Controller {

	public static final Logger LOGGER = LoggerFactory.getLogger(Monre01Controller.class);

	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	protected MessageSource mMessageSource;

	@Autowired
	private TbdHSDeNghiCapGiayXn5Service mTbdHSDeNghiCapGiayXn5Service;

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

	@RequestMapping(value = AppViewThuTuc05Constant.ViewURL.INDEX_URL, method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes,
			Locale locale, ModelMap model) {

		try {

			model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
			model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
			model.addAttribute(AppConstant.DanhMuc.Applet,
					environment.getRequiredProperty(AppConstant.Common.APPLET));
			model.addAttribute(AppConstant.DanhMuc.Sign,
					environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

			layThongTinLoaiThuTuc(request, model);
		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e.getCause());

			pushLog(e);

		}

		return AppViewThuTuc05Constant.PageView.PAGE_INDEX;
	}

	@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.XEM_HO_SO_URL + "/{id}" }, method = RequestMethod.GET)
	public String xemHoSo(@PathVariable("id") long id, HttpServletRequest request, ModelMap model) {

		try {

			model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
			model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
			model.addAttribute(AppConstant.DanhMuc.Applet,
					environment.getRequiredProperty(AppConstant.Common.APPLET));
			model.addAttribute(AppConstant.DanhMuc.Sign,
					environment.getRequiredProperty(ThuTuc01Constant.EnableSign));


			TbdHSDeNghiCapGiayXn5 capGiayXn1 = mTbdHSDeNghiCapGiayXn5Service.getTbdHSDeNghiCapGiayXn5(id);

			if (capGiayXn1 == null) {

				return AppCommon.redirectPage(request, AppViewThuTuc05Constant.ViewURL.INDEX_URL);
			}

			capGiayXn1.setXemHoSo(true);

			layThongTinLoaiThuTuc(request, model);

			layThongTinHoSo(model, request, capGiayXn1);

		} catch (Exception e) {

			pushLog(e);
		}

		return AppViewThuTuc05Constant.PageView.PAGE_TO_KHAI;
	}


	private void layThongTinHoSo(ModelMap model, HttpServletRequest request, TbdHSDeNghiCapGiayXn5 capGiayXn1){

		try {

			String messageSuccess = (String) model
					.get(AppViewThuTuc05Constant.MessageKey.THU_TUC_05_KHAI_BAO_HO_SO_SUCCESS);

			String messageError = (String) model
					.get(AppViewThuTuc05Constant.MessageKey.THU_TUC_05_KHAI_BAO_HO_SO_ERROR);

			if (messageSuccess != null) {

				model.addAttribute(
						com.nsw.monre.p05.constant.AppViewThuTuc05Constant.MessageKey.THU_TUC_05_KHAI_BAO_HO_SO_SUCCESS,
						messageSuccess);
			}

			if (messageError != null) {

				model.addAttribute(AppViewThuTuc05Constant.MessageKey.THU_TUC_05_KHAI_BAO_HO_SO_ERROR, messageError);
			}

			List<TbsCoQuanXuLy1> dsTbsCoQuanXuLy1 = new ArrayList<>();

			TbsCoQuanXuLy1 pl0 = new TbsCoQuanXuLy1();

			pl0.setMaCoQuan("-1");

			pl0.setTenCoQuan(mMessageSource.getMessage("monre.01.select.label-default", null, request.getLocale()));

			dsTbsCoQuanXuLy1.add(pl0);

			List<TbsCoQuanXuLy1> tbsPheLieu1s = mTbsCoQuanXuLy1Service.getTbsCoQuanXuLy1s();

			if (tbsPheLieu1s != null) {

				dsTbsCoQuanXuLy1.addAll(tbsPheLieu1s);
			}

			model.addAttribute("dsCoQuanXuLy", dsTbsCoQuanXuLy1);

			capGiayXn1.setTaoMoiHoSo(false);

			capGiayXn1.setCapNhatHoSo(true);

			model.addAttribute("form", capGiayXn1);

		} catch (Exception e) {

			pushLog(e);
		}

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

		model.put("TEN_THU_TUC", mMessageSource.getMessage("monre.01.tt05.ten-thu-tuc", null, request.getLocale()));
	}


}
