package com.nsw.moit.api;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.moit.p07.util.Moit07BackendConstants;
import com.nsw.moit.p07.util.Moit07TbdHoSo7BackendUtil;
import com.nsw.moit.p07.model.TbdHangHoa7DTO;
import com.nsw.moit.p07.util.Moit07TbdHangHoa7BackendUtil;
import com.nsw.moit.p07.model.TbdHoSo7;
import com.nsw.moit.p07.util.Moit07Constants;
import com.nsw.moit.p06.util.Moit06BackendConstants;
import com.nsw.moit.p06.util.Moit06TbsProvince6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsTepDinhKem6BackendUtil;
import com.nsw.moit.p07.model.HoSo7EditForm;
import com.nsw.moit.p07.model.TbdDinhKem7;
import com.nsw.moit.p07.model.TbdGPCuaKhau7;
import com.nsw.moit.p07.model.TbdGPHangHoa7;
import com.nsw.moit.p07.model.TbdGiayPhep7;
import com.nsw.moit.p07.model.TbdGiayPhep7DTO;
import com.nsw.moit.p07.model.TbdHoSo7SearchItem;
import com.nsw.moit.p07.model.TbdHoSo7SearchDTO;
import com.nsw.moit.p07.model.TbdTTPT7;
import com.nsw.moit.p07.model.TbdGPTTPT7DTO;
import com.nsw.moit.p07.model.TbsPhuongTien7;
import com.nsw.moit.p07.model.TbsTrangThai7;
import com.nsw.moit.p07.util.Moit07TbdCuaKhau7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdDinhKem7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdGPCuaKhau7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdGPHangHoa7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdGiayPhep7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdHaiQuan7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdTTPT7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsCuaKhau7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsHaiQuan7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsPhuongTien7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsTienChat7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsTrangThai7BackendUtil;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;

@RestController
@RequestMapping(value = Moit07Constants.ApiUrls.ROOT)
@PropertySource("classpath:moit_api.properties")
public class Moit07Api {

	public static final Logger LOGGER = LoggerFactory.getLogger(Moit07Api.class);

	@Autowired
	protected Environment environment;

	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	protected MessageSource messageSource;

	private static final String CLASS_NAME = "Moit07Api";
	
	@Autowired
	private Moit06TbsTepDinhKem6BackendUtil moit06TbsTepDinhKem6BackendUtil;
	
	

	/**
	 * Lay danh sach tat ca ho so
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_HO_SO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getHoSos(HttpServletRequest request, @RequestBody TbdHoSo7SearchDTO form) {

		try {

			TbdHoSo7SearchItem dHoSoDTO6 = new TbdHoSo7SearchItem();
			
			if (form.getPageIndex() < 1) form.setPageIndex(1);
			
			if (form.getTrangThai() != null && form.getTrangThai() != -1) {
				dHoSoDTO6.setTrangThai(form.getTrangThai());
			}
			if (form.getFromNgayNop() != null) {
				dHoSoDTO6.setFromNgayNop(formatDate(form.getFromNgayNop(), 0, 0, 0));
			}
			if (form.getToNgayNop() != null) {
				dHoSoDTO6.setToNgayNop(formatDate(form.getToNgayNop(), 23, 59, 59));
			}
			if (form.getFromNgayCapGiayPhep() != null) {
				dHoSoDTO6.setFromNgayCapGiayPhep(formatDate(form.getFromNgayCapGiayPhep(), 0, 0, 0));
			}
			if (form.getToNgayCapGiayPhep() != null) {
				dHoSoDTO6.setToNgayCapGiayPhep(formatDate(form.getToNgayCapGiayPhep(), 23, 59, 59));
			}
			if (StringUtils.hasText(form.getMaSoThue())) {
				dHoSoDTO6.setMaSoThue(form.getMaSoThue().trim());
			}
			if (StringUtils.hasText(form.getMaSoGP())) {
				dHoSoDTO6.setMaSoGP(form.getMaSoGP().trim());
			}
			if (StringUtils.hasText(form.getMaHoSo())) {
				dHoSoDTO6.setMaHoSo(form.getMaHoSo().trim());
			}
			dHoSoDTO6.setPageIndex(form.getPageIndex() - 1);
			dHoSoDTO6.setPageSize(15);
			dHoSoDTO6.setHoatDong(1);
			LOGGER.info("Loc theo dieu kien: {}", dHoSoDTO6);
			ResponseJson data = Moit07TbdHoSo7BackendUtil.page(getURL(Moit07BackendConstants.TbdHoSo7Constants.SEARCH), dHoSoDTO6);
			
			return createResponseEntity(data.getData(), data.getTotal(), getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachHoSo]", e);
			pushLog(e);
		}
		
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	private Date formatDate(Date date, int hour, int minute, int second) {
		if (date == null) return date;
		date.setHours(hour);
		date.setMinutes(minute);
		date.setSeconds(second);
		return date;
	}
	
	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_THONG_TIN_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getChiTietHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {

			TbdHoSo7 hoSoNgoaiTe1 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);

			if (hoSoNgoaiTe1 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			LOGGER.info("LAY THONG TIN HO SO: {}", hoSoNgoaiTe1);

			return createResponseEntity(hoSoNgoaiTe1, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getChiTietHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_TRANG_THAI, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTrangThais(HttpServletRequest request) {
		try {
			Object data = Moit07TbsTrangThai7BackendUtil.findByIdTrangThaiIsNotNullOrderByIdTrangThai(getURL(Moit07BackendConstants.TbsTrangThai7Constants.FIND_BY_ID_TRANG_THAI_IS_NOT_NULL_ORDER_BY_ID_TRANG_THAI));

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachTrangThai]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_HAI_QUAN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhMucHaiQuan(HttpServletRequest request) {
		try {
			Object data = Moit07TbsHaiQuan7BackendUtil.getAll(getURL(Moit07BackendConstants.TbsHaiQuan7.GET_ALL));

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhMucHaiQuan]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.SUA_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> editHoSo(@PathVariable("idHoSo") long idHoSo) {

		try {

			HoSo7EditForm editForm = new HoSo7EditForm();
			editForm.setDanhMucTepDinhKems(moit06TbsTepDinhKem6BackendUtil.findByLoaiThuTuc("p07"));
			editForm.setProvinces(Moit06TbsProvince6BackendUtil.findAll(getURL(Moit06BackendConstants.TbsProvince6Constants.FIND_ALL)));
			List<TbsTrangThai7> tbsTrangThai7s = Moit07TbsTrangThai7BackendUtil.findByIdTrangThaiIsNotNullOrderByIdTrangThai(getURL(Moit07BackendConstants.TbsTrangThai7Constants.FIND_BY_ID_TRANG_THAI_IS_NOT_NULL_ORDER_BY_ID_TRANG_THAI));
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (idHoSo <= 0) {
				UserCustom user = (UserCustom) principal;
				editForm.setMaSoThue(user.getUsername());
				editForm.setTenDoanhNghiep(user.getCompanyName());
				editForm.setDiaChiDoanhNghiep(user.getCompanyAddress());
				editForm.setDienThoai(user.getCompanyPhoneNumber());
				editForm.setFax(user.getCompanyFax());
				editForm.setNgayTao(new Date());
				editForm.setSoGiayChungNhanDKKD(user.getRegistrationNo());
				editForm.setNgayCapGiayChungNhan(new Date());
				editForm.setEmail(user.getCompanyEmail());
				editForm.setIdHoSo(0L);
				if (!StringUtils.hasText(editForm.getSoGiayChungNhanDKKD())) editForm.setSoGiayChungNhanDKKD(user.getUsername());
				Optional<TbsTrangThai7> tOptional = tbsTrangThai7s.stream().filter(p-> p.getIdTrangThai() == 0).findFirst();
				if (tOptional.isPresent()) {
					editForm.setTrangThaiHoSo(tOptional.get().getTenTrangThai());
				}
			} else {
				TbdHoSo7 hoSo = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);
				BeanUtils.copyProperties(hoSo, editForm);
				Optional<TbsTrangThai7> tOptional = tbsTrangThai7s.stream().filter(p-> p.getIdTrangThai() == hoSo.getTrangThai().intValue()).findFirst();
				if (tOptional.isPresent()) {
					editForm.setTrangThaiHoSo(tOptional.get().getTenTrangThai());
				}
				editForm.setLoaiGiayPhep(hoSo.getLoaiHoSo());
				editForm.setSoGiayPhepDaCap(hoSo.getSoGiayPhepDaCap());
				editForm.setLyDoGiaHan(hoSo.getLyDoGiaHan());
				editForm.setCuaKhaus(Moit07TbdCuaKhau7BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), idHoSo, 1));
				editForm.setPhuongTiens(Moit07TbdTTPT7BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit07BackendConstants.TbdTTPT7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), idHoSo, 1));
				editForm.setTepDinhKems(Moit07TbdDinhKem7BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit07BackendConstants.TbdDinhKem7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), idHoSo, 1));
				editForm.setHangHoas(Moit07TbdHangHoa7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdHangHoa7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), idHoSo, 1));
				editForm.setTotalFileSize(Moit07TbdDinhKem7BackendUtil.sizeOfFiles(getURL(Moit07BackendConstants.TbdDinhKem7Constants.SIZE_OF_FILE), idHoSo));
				if (editForm.getHangHoas() != null) {
					List<TbdHangHoa7DTO> tbdHangHoa7DTOs = editForm.getHangHoas().stream().map(p -> {
						TbdHangHoa7DTO dtp = new TbdHangHoa7DTO();
						BeanUtils.copyProperties(p, dtp);
						return dtp;
					}).collect(Collectors.toList());

					editForm.setHangHoa7DTOs(tbdHangHoa7DTOs);
				}
				editForm.setHaiQuans(Moit07TbdHaiQuan7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdHaiQuan7.FIND_BY_ID_HO_SO), idHoSo, 1));
			}
			editForm.setSign(isSign());
			editForm.setTienChats(Moit07TbsTienChat7BackendUtil.findByIdTienChatIsNotNullOrderByTenTienChat(getURL(Moit07BackendConstants.TbsTienChat7Constants.FIND_BY_ID_TIEN_CHAT_IS_NOT_NULL_ORDER_BY_TEN_TIEN_CHAT)));

			return createResponseEntity(editForm, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[editHoSo]", e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}
	
	private boolean isSign() {
		return Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_CUA_KHAU, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getCuaKhaus(HttpServletRequest request) {

		try {
			Object data = Moit07TbsCuaKhau7BackendUtil.findByIdCuaKhauIsNotNullOrderByTenCuaKhauAsc(getURL(Moit07BackendConstants.TbsCuaKhau7Constants.FIND_BY_ID_CUA_KHAU_IS_NOT_NULL_ORDER_BY_TEN_CUA_KHAU_ASC));

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_PHUONG_TIEN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getPhuongTiens(HttpServletRequest request) {

		try {
			Object data = Moit07TbsPhuongTien7BackendUtil.findByIdPhuongTienIsNotNullOrderByTenPhuongTienAsc(getURL(Moit07BackendConstants.TbsPhuongTien7Constants.FIND_BY_ID_PHUONG_TIEN_IS_NOT_NULL_ORDER_BY_TEN_PHUONG_TIEN_ASC));

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getPhuongTiens]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/findSoGP", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> findSoGP(@RequestParam(value = "maSoGP", required = false)String maSoGP) {

		try {
			if (!StringUtils.hasText(maSoGP)) maSoGP = "";
			Object data = Moit07TbdGiayPhep7BackendUtil.search(getURL(Moit07BackendConstants.TbdGiayPhep7Constants.SEARCH), maSoGP);
			 
			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[findSoGP]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}
	

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_TEP_TIN_THEO_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTepDinhKemByIdHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			if (idHoSo < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			Object data = Moit07TbdDinhKem7BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit07BackendConstants.TbdDinhKem7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), idHoSo, 1);

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getTepDinhKemByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_THONG_TIN_GIAY_PHEP + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getGiayPhep(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			TbdGiayPhep7 giayPhep7 = Moit07TbdGiayPhep7BackendUtil.findByIdHoSo(getURL(Moit07BackendConstants.TbdGiayPhep7Constants.FIND_BY_ID_HO_SO), idHoSo);
			TbdHoSo7 hoSo7 = Moit07TbdHoSo7BackendUtil.findByIdHoSo(getURL(Moit07BackendConstants.TbdHoSo7Constants.FIND_BY_ID_HO_SO), idHoSo);
			List<TbdGPHangHoa7> hangHoa7 = Moit07TbdGPHangHoa7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdGPHangHoa7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), idHoSo, 1);
			List<TbdGPCuaKhau7> cuaKhau7 = Moit07TbdGPCuaKhau7BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit07BackendConstants.TbdGPCuaKhau7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), idHoSo, 1);
			List<Integer> status = Arrays.asList(15, 16);
			if (giayPhep7 == null || hoSo7 == null || hangHoa7.isEmpty() || cuaKhau7.isEmpty()
					|| !status.contains(hoSo7.getTrangThai())) {
				debugLog("Khong tim thay giay phep theo id ho so:  {}, giay phe[: {}, hang hoa: {}, cua khau: {} ", idHoSo, giayPhep7, hangHoa7, cuaKhau7);
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			TbdGiayPhep7DTO chiTietGiayPhep = new TbdGiayPhep7DTO();
			chiTietGiayPhep.setTenDoanhNghiep(hoSo7.getTenDoanhNghiep());
			chiTietGiayPhep.setIdGiayPhep(giayPhep7.getIdGiayPhep());
			chiTietGiayPhep.setCoQuanCap(giayPhep7.getCoQuanChuQuan());
			chiTietGiayPhep.setMaSoGP(giayPhep7.getMaSoGP());
			chiTietGiayPhep.setNgayKy(giayPhep7.getNgayKy());
			chiTietGiayPhep.setLoaiHinh(giayPhep7.getLoaiHinh());
			chiTietGiayPhep.setLoaiGiayPhep(giayPhep7.getLoaiGiayPhep());
			chiTietGiayPhep.setNguoiKy(giayPhep7.getNguoiKy());
			chiTietGiayPhep.setHangHoas(hangHoa7);
			chiTietGiayPhep.setHamLuong(hangHoa7.get(0).getHamLuong());
			chiTietGiayPhep.setSoLuong(hangHoa7.get(0).getSoLuong());
			chiTietGiayPhep.setMucDich(hoSo7.getMucDich());
			chiTietGiayPhep.setNgayNop(hoSo7.getNgayNop());
			chiTietGiayPhep.setCuaKhaus(cuaKhau7);
			chiTietGiayPhep.setMaHoSo(hoSo7.getMaHoSo());
			chiTietGiayPhep.setPhuongTiens(toThongTinDTOs(idHoSo));
			chiTietGiayPhep.setHangHoas(Moit07TbdGPHangHoa7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdGPHangHoa7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), giayPhep7.getIdHoSo(), 1));
			chiTietGiayPhep.setTruSo(hoSo7.getDiaChiDoanhNghiep());
			chiTietGiayPhep.setDienThoai(hoSo7.getDienThoai());
			chiTietGiayPhep.setFax(hoSo7.getFax());
			chiTietGiayPhep.setCuaKhaus(Moit07TbdGPCuaKhau7BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit07BackendConstants.TbdGPCuaKhau7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), hoSo7.getIdHoSo(), 1));
			chiTietGiayPhep.setMucDich(hoSo7.getMucDich());
			chiTietGiayPhep.setSoLanThucHien(hoSo7.getSoLanThucHien());
			chiTietGiayPhep.setSoGiayChungNhanDKKD(hoSo7.getSoGiayChungNhanDKKD());
			chiTietGiayPhep.setNgayCapGiayChungNhan(hoSo7.getNgayCapGiayChungNhan());
			chiTietGiayPhep.setNoiCapGDKKD(hoSo7.getNoiCapGDKKD());
			chiTietGiayPhep.setNgayHetHan(giayPhep7.getNgayHetHan());
			chiTietGiayPhep.setMaHoSo(hoSo7.getMaHoSo());
			chiTietGiayPhep.setNgayNop(hoSo7.getNgayNop());
			chiTietGiayPhep.setXuatNhapKhauTuNgay(hoSo7.getXuatNhapKhauTuNgay());
			chiTietGiayPhep.setXuatNhapKhauDenNgay(hoSo7.getXuatNhapKhauDenNgay());
			chiTietGiayPhep.setNgayNop(hoSo7.getNgayNop());
			Object data = chiTietGiayPhep;
			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getGiayPhep]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	private List<TbdGPTTPT7DTO> toThongTinDTOs(Long idHoSo) {
		List<TbdGPTTPT7DTO> ls = new ArrayList<>();
		List<TbdTTPT7> tbdTTPT7s = Moit07TbdTTPT7BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit07BackendConstants.TbdTTPT7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), idHoSo, 1);
		if (tbdTTPT7s != null) {
			List<TbsPhuongTien7> tbsPhuongTien7s = Moit07TbsPhuongTien7BackendUtil.findByIdPhuongTienIsNotNullOrderByTenPhuongTienAsc(getURL(Moit07BackendConstants.TbsPhuongTien7Constants.FIND_BY_ID_PHUONG_TIEN_IS_NOT_NULL_ORDER_BY_TEN_PHUONG_TIEN_ASC));
			tbdTTPT7s.stream().forEach(p -> {
				Optional<TbsPhuongTien7> optional = tbsPhuongTien7s.stream().filter(tbs -> tbs.getLoaiPhuongTien() == p.getLoaiPhuongTien()).findFirst();
				if (optional.isPresent()) {
					TbdGPTTPT7DTO tbdTTPT7DTO = new TbdGPTTPT7DTO();
					BeanUtils.copyProperties(p, tbdTTPT7DTO);
					tbdTTPT7DTO.setTenPhuongTien(optional.get().getTenPhuongTien());
					tbdTTPT7DTO.setTenLoaiPhuongTien(optional.get().getTenLoaiPhuongTien());
					debugLog("toThongTinDTOs: {}", tbdTTPT7DTO);
					ls.add(tbdTTPT7DTO);
				}
			});
		}

		return ls;
	}

	protected void pushLog(Exception ex) {

		try {

			String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName() + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

		} catch (Exception e) {
			LOGGER.error("[pushLog]", e);
		}

	}

	protected ResponseEntity<Object> createResponseEntity(Object data, Long total, String message, boolean success, HttpStatus httpStatus) {

		ResponseJson item = new ResponseJson();

		item.setData(data);

		item.setTotal(total);

		item.setMessage(message);

		item.setSuccess(success);

		return new ResponseEntity<>(item, httpStatus);
	}

	protected String getURL(String uriKey) {
		return environment.getRequiredProperty(Moit07BackendConstants.ROOT_URL) + environment.getRequiredProperty(uriKey);
	}

	protected String getMessage(String messageKey, Object[] objects, Locale locale) {

		try {

			return messageSource.getMessage(messageKey, objects, locale);

		} catch (Exception e) {
			LOGGER.error("[getMessage 1]", e);
		}

		return "";
	}

	protected String getMessage(String messageKey) {

		try {
			return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
		} catch (Exception e) {
			LOGGER.error("[getMessage 2]", e);
		}

		return "";
	}

	protected String getMessage(String messageKey, Object... objects) {

		try {
			StringBuilder builder = new StringBuilder();
			builder.append(messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale()));
			if (objects != null) {
				for (Object object : objects)
					builder.append(" " + object);
			}
			return builder.toString();
		} catch (Exception e) {
			LOGGER.error("[getMessage 3]", e);
		}

		return "";
	}

	protected static ResponseJson callRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (params != null) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				builder.queryParam(entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
		uri = builder.build().encode().toString();
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(converters);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<>(body, headers);
		ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, httpMethod, entity, ResponseJson.class);

		ResponseJson responseJson = response.getBody();
		if (!responseJson.isSuccess()) {
			LOGGER.error(responseJson.getMessage());
		}
		return response.getBody();
	}

	protected static <T> T readObject(ResponseJson responseJson, Class<T> clz) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), clz);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	

	private static final int BUFFER_SIZE = 4097;
	FileServiceHelper fileHelper = new FileServiceHelper();

	private static final String BACKEND_URL_DOWNLOAD_KEY = "com.nsw.moit.p07.download";
	private static final String BACKEND_URL_KEY = "moit.07.backend";


	@RequestMapping(value = "/download/{idTepDinhKem}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("idTepDinhKem") long idTepDinhKem) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			try {

				TbdDinhKem7 tepDinhKemHoSo1 = Moit07TbdDinhKem7BackendUtil.getTbdDinhKem7(getURL(Moit07BackendConstants.TbdDinhKem7Constants.GET_ONE), idTepDinhKem);

				if (tepDinhKemHoSo1 != null) {
					String loaiTep = tepDinhKemHoSo1.getLoaiTep();
					if (!StringUtils.hasText(loaiTep))
						loaiTep = FilenameUtils.getExtension(tepDinhKemHoSo1.getTenTepDinhKem());
					String fileCode = tepDinhKemHoSo1.getGuID() + "." + loaiTep;
					downloadFile(response, fileCode, tepDinhKemHoSo1.getTenTepDinhKem(), fileCode, tepDinhKemHoSo1.getDuongDanFile());
				}
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}
	}

	@RequestMapping(value = "/getfile/{mcode}/{pcode}/{code}", method = RequestMethod.GET)
	public void downloadNewFile(HttpServletResponse response, @PathVariable("code") String code, @PathVariable("mcode") String mCode, @PathVariable("pcode") String pCode) {
		RabbitMQInfo mqInfo = getRabbitMQ();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			try {
				if (code != null) {
					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					String spack = "/";
					String filePath = mCode + spack + pCode + spack + dateFormat.format(date);
					downloadFile2(response, code, code, filePath);
				}
			} catch (Exception ex) {

				LOGGER.error(ex.getMessage(), ex);
				String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

				RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
			}
		}
	}

	private void downloadFile(HttpServletResponse response, String fileCode, String fileName, String fileCodeDb, String filePathDb) throws IOException {
		String name = fileName;
		String path = filePathDb;
		String mimeType = "";
		RabbitMQInfo mqInfo = getRabbitMQ();
		if (name == null) {
			name = fileCode;
		}

		if (fileCodeDb.equals(fileCode)) {
			String uri = getFullUri(environment.getProperty(BACKEND_URL_DOWNLOAD_KEY));
			byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

			LOGGER.info("SIZE = {}, {}, {}", fileCode, fileName, fileCodeDb);
			Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
			Files.write(savePath, fileByte);

			File downloadFile = savePath.toFile();

			mimeType = URLConnection.guessContentTypeFromName(name);
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}

			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
			response.setContentLength((int) downloadFile.length());

			try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			}
			Files.delete(savePath);
		}
	}

	private void downloadFile2(HttpServletResponse response, String fileCode, String fileName, String filePathDb) throws IOException {
		String name = fileName;
		String path = filePathDb;
		String mimeType = "";
		RabbitMQInfo mqInfo = getRabbitMQ();
		if (name == null) {
			name = fileCode;
		}

		String uri = getFullUri(environment.getProperty(BACKEND_URL_DOWNLOAD_KEY));
		byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

		Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
		Files.write(savePath, fileByte);

		File downloadFile = savePath.toFile();

		mimeType = URLConnection.guessContentTypeFromName(name);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
		response.setContentLength((int) downloadFile.length());

		try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		}
		Files.delete(savePath);
	}


	String getFullUri(String restUri) {
		return environment.getRequiredProperty(BACKEND_URL_KEY) + restUri;
	}

	private RabbitMQInfo getRabbitMQ() {
		return rabbitMQService.getRabbitMQInfo();
	}

	protected String redirect(String path) {
		return "redirect:" + path;
	}

	protected void debugLog(String message, Object... objects) {
		LOGGER.info(message, objects);
	}

	protected static final int LICH_SU_TAO_MOI_HO_SO = 1;
	protected static final int LICH_SU_SUA_HO_SO = 2;
	protected static final int LICH_SU_XOA_HO_SO = 3;
	protected static final int LICH_SU_GUI_HO_SO = 4;
	protected static final int LICH_SU_HUY_HO_SO = 5;
	protected static final int LICH_SU_SUA_HO_SO_THEM_TEP_TIN = 7;
	protected static final int LICH_SU_SUA_HO_SO_XOA_TEP_TIN = 7;
	protected static final int LICH_SU_SUA_HO_SO_THEM_TIEN_TE = 8;
	protected static final int LICH_SU_SUA_HO_SO_SUA_TIEN_TE = 9;
	protected static final int LICH_SU_SUA_HO_SO_XOA_TIEN_TE = 10;

	protected static final String IS_SIGN_KEY = "nsw.moit.07.sign";
	protected static final String SEND_ALL = "com.nsw.moit.p07.sendAll";

}
