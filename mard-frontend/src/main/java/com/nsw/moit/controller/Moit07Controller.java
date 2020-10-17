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
import com.nsw.moit.p07.util.Moit07Constants;
import com.nsw.moit.p07.util.Moit07TbdCuaKhau7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdDinhKem7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdHaiQuan7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdHangHoa7BackendUtil;
import com.nsw.moit.p07.model.HoSo7EditForm;
import com.nsw.moit.p07.model.TbdCuaKhau7;
import com.nsw.moit.p07.model.TbdDinhKem7;
import com.nsw.moit.p07.model.TbdHaiQuan7;
import com.nsw.moit.p07.model.TbdHangHoa7;
import com.nsw.moit.p07.model.TbdHoSo7;
import com.nsw.moit.p07.model.TbdTTPT7;
import com.nsw.moit.p07.util.Moit07BackendConstants;
import com.nsw.moit.p07.util.Moit07TbdHoSo7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdTTPT7BackendUtil;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

@Controller
@RequestMapping("/moit/07")
public class Moit07Controller {

	public static final Logger LOGGER = LoggerFactory.getLogger(Moit07Controller.class);


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

		return Moit07Constants.PAGE.INDEX;
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

			HoSo7EditForm form = new HoSo7EditForm();
			form.setIdHoSo(0L);
			model.addAttribute("form", form);

		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return Moit07Constants.PAGE.EDIT;
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
			
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			
			if (tbdHoSo7 != null && tbdHoSo7.getMaSoThue().equals(user.getUsername()) && tbdHoSo7.getHoatDong() == 1) {
				HoSo7EditForm form = new HoSo7EditForm();
				BeanUtils.copyProperties(tbdHoSo7, form);
				form.setXemHoSo(true);
				form.setSign(isSign());
				model.addAttribute("form",form);
				return Moit07Constants.PAGE.EDIT;
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
			
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			if (isHasEdit(tbdHoSo7, true)) {
				LOGGER.info("CHINH SUA HO SO: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo7.getIdHoSo(), tbdHoSo7.getMaHoSo(), tbdHoSo7.getHoSoTam(), tbdHoSo7.getTrangThai(), tbdHoSo7.getHoatDong());
				HoSo7EditForm form = new HoSo7EditForm();
				form.setIdHoSoGoc(tbdHoSo7.getIdHoSo());
				tbdHoSo7 = cloneHoSo(tbdHoSo7);
				BeanUtils.copyProperties(tbdHoSo7, form);
				form.setSign(isSign());
				model.addAttribute("form",form);
				LOGGER.info("LAY HO SO VERSION: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo7.getIdHoSo(), tbdHoSo7.getMaHoSo(), tbdHoSo7.getHoSoTam(), tbdHoSo7.getTrangThai(), tbdHoSo7.getHoatDong());
				return Moit07Constants.PAGE.EDIT;
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
			
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			HoSo7EditForm form = new HoSo7EditForm();
			if (isHasEdit(tbdHoSo7, false)) {
				LOGGER.info("YEU CAU SUA HO SO: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo7.getIdHoSo(), tbdHoSo7.getMaHoSo(), tbdHoSo7.getHoSoTam(), tbdHoSo7.getTrangThai(), tbdHoSo7.getHoatDong());
				form.setIsChinhSua(true);
				form.setIdHoSoGoc(tbdHoSo7.getIdHoSo());
				tbdHoSo7 = cloneHoSo(tbdHoSo7);
				BeanUtils.copyProperties(tbdHoSo7, form);
				form.setSign(isSign());
				model.addAttribute("form",form);
				LOGGER.info("LAY HO SO VERSION: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo7.getIdHoSo(), tbdHoSo7.getMaHoSo(), tbdHoSo7.getHoSoTam(), tbdHoSo7.getTrangThai(), tbdHoSo7.getHoatDong());
				return Moit07Constants.PAGE.EDIT;
			}
			
		} else {
			return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
		}

		return redirect("home");
	}

	private String getURL(String uriKey) {
		return environment.getRequiredProperty(Moit07Constants.PROPERTIES.BACKEND) + environment.getRequiredProperty(uriKey);
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
		Breadcrumb nav = new Breadcrumb("/moit/07/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
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
	
	private boolean isHasEdit(TbdHoSo7 tbdHoSo7, boolean isEdit) {
		if (tbdHoSo7 == null || tbdHoSo7.getHoatDong() == null || tbdHoSo7.getHoatDong() == 0) return false;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (tbdHoSo7.getHoatDong() == 0) return false;
		if (principal != null && (principal instanceof UserCustom)) {
			UserCustom user = (UserCustom) principal;
			if (user.getUsername() != null && !user.getUsername().equals(tbdHoSo7.getMaSoThue())) return false;
			if (isEdit) {
				return tbdHoSo7.getTrangThai() == Moit07Constants.Status.TAO_MOI 
						|| tbdHoSo7.getTrangThai() == Moit07Constants.Status.CHO_TIEP_NHAN 
						|| tbdHoSo7.getTrangThai() == Moit07Constants.Status.DA_SDBS
						||  tbdHoSo7.getTrangThai() == Moit07Constants.Status.YEU_CAU_BO_SUNG;
			} else {
				return tbdHoSo7.getTrangThai() == Moit07Constants.Status.DANG_XU_LY
						|| tbdHoSo7.getTrangThai() == Moit07Constants.Status.DONG_Y_YEU_CAU_SUA
						|| tbdHoSo7.getTrangThai() == Moit07Constants.Status.TU_CHOI_YEU_CAU_SUA;
			}
		}
		return false;
	}
	
	private String redirect(String url) {
		if (!url.startsWith("/")) url = "/" + url;
		return "redirect:/moit/07" + url;
	}
	
	private TbdHoSo7 cloneHoSo(TbdHoSo7 tbdHoSo7) {
		List<TbdHoSo7> hoSo7s = Moit07TbdHoSo7BackendUtil.findByMaHoSo(getURL(Moit07BackendConstants.TbdHoSo7Constants.FIND_BY_MA_HO_SO), tbdHoSo7.getMaHoSo()).stream().sorted(Comparator.comparing(TbdHoSo7::getHoatDong).reversed()).collect(Collectors.toList());
		TbdHoSo7 end = hoSo7s.get(0);
		Optional<TbdHoSo7> first = hoSo7s.stream().filter(p -> Objects.equals(Boolean.FALSE, p.getSend())).findFirst();
		if (first.isPresent()) {
			return first.get();
		}
		long idHoSo = tbdHoSo7.getIdHoSo();
		tbdHoSo7.setIdHoSo(null);
		tbdHoSo7.setHoatDong(0);
		tbdHoSo7.setSend(false);
		tbdHoSo7.setHoSoTam(end.getHoSoTam() == null ? 0 : end.getHoSoTam() + 1);
		tbdHoSo7 = Moit07TbdHoSo7BackendUtil.createTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.CREATE), tbdHoSo7);
		final long ID = tbdHoSo7.getIdHoSo();
		LOGGER.info("Clone ho so from ID = {} to ID = {}, Ma ho so = {}", idHoSo, tbdHoSo7.getIdHoSo(), tbdHoSo7.getMaHoSo());
		List<TbdCuaKhau7> cuaKhau7s = Moit07TbdCuaKhau7BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), idHoSo, 1);
		if (cuaKhau7s != null) {
			cuaKhau7s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdCuaKhau(null);
				Moit07TbdCuaKhau7BackendUtil.createTbdCuaKhau7(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.CREATE), p);
			});
		}
		List<TbdTTPT7> tbdTTPT7s = Moit07TbdTTPT7BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit07BackendConstants.TbdTTPT7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), idHoSo, 1);
		if (tbdTTPT7s != null) {
			tbdTTPT7s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdPhuongTien(null);
				Moit07TbdTTPT7BackendUtil.createTbdTTPT7(getURL(Moit07BackendConstants.TbdTTPT7Constants.CREATE), p);
			});
		}
		List<TbdDinhKem7> dinhKem7s = Moit07TbdDinhKem7BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit07BackendConstants.TbdDinhKem7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), idHoSo, 1);
		if (dinhKem7s != null) {
			dinhKem7s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdTepTin(null);
				Moit07TbdDinhKem7BackendUtil.createTbdDinhKem7(getURL(Moit07BackendConstants.TbdDinhKem7Constants.CREATE), p);
			});
		}
		List<TbdHangHoa7> hangHoa7s = Moit07TbdHangHoa7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdHangHoa7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), idHoSo, 1);
		if (hangHoa7s != null) {
			hangHoa7s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdHangHoa(null);
				Moit07TbdHangHoa7BackendUtil.createTbdHangHoa7(getURL(Moit07BackendConstants.TbdHangHoa7Constants.CREATE), p);
			});
		}
		List<TbdHaiQuan7> haiQuan7s = Moit07TbdHaiQuan7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdHaiQuan7.FIND_BY_ID_HO_SO), idHoSo, 1);
		if (haiQuan7s != null) {
			haiQuan7s.stream().forEach(p -> {
				p.setIdHoSo(ID);
				p.setIdHaiQuan(null);
				Moit07TbdHaiQuan7BackendUtil.createTbdHaiQuan7(getURL(Moit07BackendConstants.TbdHaiQuan7.CREATE), p);
			});
		}
		return tbdHoSo7;
	}
	
	private boolean isSign() {
		return Boolean.parseBoolean(environment.getRequiredProperty("nsw.moit.07.sign"));
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
