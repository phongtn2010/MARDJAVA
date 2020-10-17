package com.nsw.moit.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.moit.p06.model.HoSo6EditForm;
import com.nsw.moit.p06.model.TbdCuaKhau6;
import com.nsw.moit.p06.model.TbdDinhKem6;
import com.nsw.moit.p06.model.TbdHangHoa6;
import com.nsw.moit.p06.model.TbdHoSo6;
import com.nsw.moit.p06.model.TbdTTPT6;
import com.nsw.moit.p06.util.Moit06BackendConstants;
import com.nsw.moit.p06.util.Moit06Constants;
import com.nsw.moit.p06.util.Moit06TbdCuaKhau6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdDinhKem6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdHangHoa6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdHoSo6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdTTPT6BackendUtil;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

@Controller
@RequestMapping("/moit/06")
public class Moit06Controller {

	public static final Logger LOGGER = LoggerFactory.getLogger(Moit06Controller.class);


	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	private Environment environment;

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	protected MessageSource messageSource;


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes,
			Locale locale, ModelMap model) {

		try {

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				UserCustom user = (UserCustom) principal;
				setBreadcrumb(false, model);
				model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
				model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
				model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
				model.addAttribute(AppConstant.DanhMuc.Applet,
						environment.getRequiredProperty(AppConstant.Common.APPLET));
				model.addAttribute(AppConstant.DanhMuc.Sign,
						environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

			} else {
				return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
			}

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);

			pushLog(e);

		}

		return Moit06Constants.PAGE.INDEX;
	}


	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
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

			HoSo6EditForm form = new HoSo6EditForm();
			form.setIdHoSo(0L);
			form.setSign(isSign());
			model.addAttribute("form", form);

		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return Moit06Constants.PAGE.EDIT;
	}
	
	@RequestMapping(value = { "/view/{id}" }, method = RequestMethod.GET)
	public String view(ModelMap model, HttpServletRequest request, @PathVariable("id") long id) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserCustom user = (UserCustom) principal;
			setBreadcrumb(false, model);
			model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
			model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
			model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
			model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
			model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
			
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), id);
			if (tbdHoSo6 != null && tbdHoSo6.getMaSoThue().equals(user.getUsername()) && tbdHoSo6.getHoatDong() == 1) {
				HoSo6EditForm form = new HoSo6EditForm();
				BeanUtils.copyProperties(tbdHoSo6, form);
				form.setXemHoSo(true);
				model.addAttribute("form",form);
				return Moit06Constants.PAGE.EDIT;
			}
			
		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return redirect("home");
	}
	

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
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
			
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), id);
			if (isHasEdit(tbdHoSo6, true)) {
				LOGGER.info("CHINH SUA HO SO: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo6.getIdHoSo(), tbdHoSo6.getMaHoSo(), tbdHoSo6.getIsTemp(), tbdHoSo6.getTrangThai(), tbdHoSo6.getHoatDong());
				HoSo6EditForm form = new HoSo6EditForm();
				form.setIdHoSoGoc(tbdHoSo6.getIdHoSo());
				tbdHoSo6 = cloneHoSo(tbdHoSo6);
				BeanUtils.copyProperties(tbdHoSo6, form);
				form.setSign(isSign());
				model.addAttribute("form",form);
				LOGGER.info("LAY HO SO VERSION: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo6.getIdHoSo(), tbdHoSo6.getMaHoSo(), tbdHoSo6.getIsTemp(), tbdHoSo6.getTrangThai(), tbdHoSo6.getHoatDong());
				return Moit06Constants.PAGE.EDIT;
			}
			
		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return redirect("home");
	}
	
	
	@RequestMapping(value = { "/edit/{id}/ycs" }, method = RequestMethod.GET)
	public String xinSua(ModelMap model, HttpServletRequest request, @PathVariable("id") long id) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserCustom user = (UserCustom) principal;
			setBreadcrumb(false, model);
			model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
			model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
			model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
			model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
			model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
			
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), id);
			HoSo6EditForm form = new HoSo6EditForm();
			form.setIsChinhSua(true);
			
			if (isHasEdit(tbdHoSo6, false)) {
				LOGGER.info("YEU CAU SUA HO SO: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | SEND = {} | ACTIVE = {}", tbdHoSo6.getIdHoSo(), tbdHoSo6.getMaHoSo(), tbdHoSo6.getIsTemp(), tbdHoSo6.getTrangThai(), tbdHoSo6.getSend(), tbdHoSo6.getHoatDong());
				form.setIsChinhSua(true);
				form.setIdHoSoGoc(tbdHoSo6.getIdHoSo());
				tbdHoSo6 = cloneHoSo(tbdHoSo6);
				BeanUtils.copyProperties(tbdHoSo6, form);
				form.setSign(isSign());
				model.addAttribute("form",form);
				LOGGER.info("LAY HO SO VERSION: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo6.getIdHoSo(), tbdHoSo6.getMaHoSo(), tbdHoSo6.getIsTemp(), tbdHoSo6.getTrangThai(), tbdHoSo6.getHoatDong());
				return Moit06Constants.PAGE.EDIT;
			}
			
		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return redirect("home");
	}

	private String getURL(String uriKey) {
		return environment.getRequiredProperty(Moit06Constants.PROPERTIES.BACKEND) + environment.getRequiredProperty(uriKey);
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
		Breadcrumb nav = new Breadcrumb("/moit/06/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
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

	String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName()
			+ AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
			+ AppConstant.MESSAGE_SEPARATOR + ex.toString();

	 RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo,
	 rabbitMQService.getRabbitMQInfo());

	}
	
	private boolean isHasEdit(TbdHoSo6 tbdHoSo6, boolean isEdit) {
		
		if (tbdHoSo6 == null || tbdHoSo6.getHoatDong() == null || tbdHoSo6.getHoatDong() == 0) return false;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (tbdHoSo6.getHoatDong() == 0) return false;
		if (principal != null && (principal instanceof UserCustom)) {
			UserCustom user = (UserCustom) principal;
			if (user.getUsername() != null && !user.getUsername().equals(tbdHoSo6.getMaSoThue())) return false;
			if (isEdit) {
					return tbdHoSo6.getTrangThai() == Moit06Constants.Status.TAO_MOI 
							|| tbdHoSo6.getTrangThai() == Moit06Constants.Status.CHO_TIEP_NHAN
									|| tbdHoSo6.getTrangThai() == Moit06Constants.Status.DA_SDBS 
							||  tbdHoSo6.getTrangThai() == Moit06Constants.Status.YEU_CAU_BO_SUNG;
			} else {
				return tbdHoSo6.getTrangThai() == Moit06Constants.Status.DANG_XU_LY
						|| tbdHoSo6.getTrangThai() == Moit06Constants.Status.DONG_Y_YEU_CAU_SUA
						|| tbdHoSo6.getTrangThai() == Moit06Constants.Status.TU_CHOI_YEU_CAU_SUA;
			}
		}
		return false;
	}
	
	private String redirect(String url) {
		if (!url.startsWith("/")) url = "/" + url;
		return "redirect:/moit/06" + url;
	}
	
	private TbdHoSo6 cloneHoSo(TbdHoSo6 tbdHoSo6) {
		List<TbdHoSo6> hoSo6s = Moit06TbdHoSo6BackendUtil.findByMaHoSo(getURL(Moit06BackendConstants.TbdHoSo6Constants.FIND_BY_MA_HO_SO), tbdHoSo6.getMaHoSo()).stream().sorted(Comparator.comparing(TbdHoSo6::getIsTemp).reversed()).collect(Collectors.toList());
		TbdHoSo6 end = hoSo6s.get(0);
		Optional<TbdHoSo6> first = hoSo6s.stream().filter(p -> Objects.equals(Boolean.FALSE, p.getSend())).findFirst();
		if (first.isPresent()) {
			return first.get();
		}
		long idHoSo = tbdHoSo6.getIdHoSo();
		tbdHoSo6.setIdHoSo(null);
		tbdHoSo6.setHoatDong(0);
		tbdHoSo6.setSend(false);
		tbdHoSo6.setIsTemp(end.getIsTemp() == null ? 0 : end.getIsTemp() + 1);
		tbdHoSo6 = Moit06TbdHoSo6BackendUtil.createTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.CREATE), tbdHoSo6);
		final long ID = tbdHoSo6.getIdHoSo();
		LOGGER.info("Clone ho so from ID = {} to ID = {}, Ma ho so = {}", idHoSo, tbdHoSo6.getIdHoSo(), tbdHoSo6.getMaHoSo());
		List<TbdCuaKhau6> cuaKhau6s = Moit06TbdCuaKhau6BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), idHoSo, 1);
		if (cuaKhau6s != null) {
			cuaKhau6s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdCuaKhau(null);
				Moit06TbdCuaKhau6BackendUtil.createTbdCuaKhau6(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.CREATE), p);
			});
		}
		List<TbdTTPT6> tbdTTPT6s = Moit06TbdTTPT6BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit06BackendConstants.TbdTTPT6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), idHoSo, 1);
		if (tbdTTPT6s != null) {
			tbdTTPT6s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdPhuongTien(null);
				Moit06TbdTTPT6BackendUtil.createTbdTTPT6(getURL(Moit06BackendConstants.TbdTTPT6Constants.CREATE), p);
			});
		}
		List<TbdDinhKem6> dinhKem6s = Moit06TbdDinhKem6BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit06BackendConstants.TbdDinhKem6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), idHoSo, 1);
		if (dinhKem6s != null) {
			dinhKem6s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdTepTin(null);
				Moit06TbdDinhKem6BackendUtil.createTbdDinhKem6(getURL(Moit06BackendConstants.TbdDinhKem6Constants.CREATE), p);
			});
		}
		List<TbdHangHoa6> hangHoa6s = Moit06TbdHangHoa6BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit06BackendConstants.TbdHangHoa6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), idHoSo, 1);
		if (hangHoa6s != null) {
			hangHoa6s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdHangHoa(null);
				Moit06TbdHangHoa6BackendUtil.createTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.CREATE), p);
			});
		}
		return tbdHoSo6;
	}
	
	private boolean isSign() {
		return Boolean.parseBoolean(environment.getRequiredProperty("nsw.moit.06.sign"));
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
