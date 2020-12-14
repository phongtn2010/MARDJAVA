package com.nsw.sbv.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.sbv.p01.model.KetQuaXuLyHoSo1;
import com.nsw.sbv.p01.util.SBV01KetQuaXuLyHoSo1BackendUtil;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;

public abstract class SBV01BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SBV01BaseController.class);
	
	@Autowired
	protected Environment environment;
	
	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	protected MessageSource messageSource;

	protected void saveLichSuHoSo(HttpServletRequest request, long idHoSo, int trangThai, int level, Object... objects) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserCustom user = (UserCustom) principal;
		KetQuaXuLyHoSo1 ketQuaXuLyHoSo1 = new KetQuaXuLyHoSo1();
		ketQuaXuLyHoSo1.setIdHoSo(idHoSo);
		ketQuaXuLyHoSo1.setNgayXuLy(new Date());
		ketQuaXuLyHoSo1.setChuyenVienXuLy(user.getUsername());
		ketQuaXuLyHoSo1.setDonViXuLy(user.getCompanyName());
		ketQuaXuLyHoSo1.setTrangThai(trangThai);
		switch (level) {
		case LICH_SU_TAO_MOI_HO_SO:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.taohoso",
					new Object[] { user.getUsername(), objects[0] }, request.getLocale()));
			break;

		case LICH_SU_XOA_HO_SO:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.xoahoso",
					new Object[] { user.getUsername(), objects[0] }, request.getLocale()));
			break;
		case LICH_SU_GUI_HO_SO:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.guihoso",
					new Object[] { user.getUsername(), objects[0] }, request.getLocale()));
			break;
		case LICH_SU_HUY_HO_SO:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.huyhoso",
					new Object[] { user.getUsername(), objects[0] }, request.getLocale()));
			break;
		case LICH_SU_SUA_HO_SO_THEM_TEP_TIN:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.themteptin",
					new Object[] { user.getUsername(), objects[0], objects[1] }, request.getLocale()));
			break;
		case LICH_SU_SUA_HO_SO_XOA_TEP_TIN:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.xoateptin",
					new Object[] { user.getUsername(), objects[0], objects[1] }, request.getLocale()));
			break;
		case LICH_SU_SUA_HO_SO_THEM_TIEN_TE:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.themtiente",
					new Object[] { objects[0] }, request.getLocale()));
			break;
		case LICH_SU_SUA_HO_SO_SUA_TIEN_TE:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.suatiente",
					new Object[] { objects[0], objects[1] }, request.getLocale()));
			break;

		case LICH_SU_SUA_HO_SO_XOA_TIEN_TE:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.xoatiente",
					new Object[] { objects[0] }, request.getLocale()));
			break;
		default:
			ketQuaXuLyHoSo1.setNoiDungXuLy(getMessage("sbv.01.lichsu.suahoso",
					new Object[] { user.getUsername(), objects[0] }, request.getLocale()));
		}
		SBV01KetQuaXuLyHoSo1BackendUtil.createKetQuaXuLyHoSo1(getURL("com.nsw.sbv.p01.ketQuaXuLyHoSo1.create"),
				ketQuaXuLyHoSo1);

	}

	protected void pushLog(Exception ex) {

		try {

			String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName()
					+ AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AppConstant.MESSAGE_SEPARATOR + ex.toString();

			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

		} catch (Exception e) {
			LOGGER.error("[pushLog]", e);
		}

	}
	
	protected ResponseEntity<Object> createResponseEntity(Object data, Long total, String message, boolean success,
			HttpStatus httpStatus) {

		ResponseJson item = new ResponseJson();

		item.setData(data);

		item.setTotal(total);

		item.setMessage(message);

		item.setSuccess(success);

		return new ResponseEntity<>(item, httpStatus);
	}
	
	protected String getURL(String uriKey) {
		return environment.getRequiredProperty("sbv.01.backend") + environment.getRequiredProperty(uriKey);
	}

	protected String getMessage(String messageKey, Object[] objects, Locale locale) {

		try {

			return messageSource.getMessage(messageKey, objects, locale);

		} catch (Exception e) {
			LOGGER.error("[getMessage]", e);
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
	

	
	protected String redirect(String path) {
		return "redirect:" + path;
	}

	
	protected static final int LICH_SU_TAO_MOI_HO_SO = 1;
	protected static final int LICH_SU_SUA_HO_SO = 2;
	protected static final int LICH_SU_XOA_HO_SO = 3;
	protected static final int LICH_SU_GUI_HO_SO = 4;
	protected static final int LICH_SU_HUY_HO_SO = 5;
	protected static final int LICH_SU_SUA_HO_SO_THEM_TEP_TIN = 6;
	protected static final int LICH_SU_SUA_HO_SO_XOA_TEP_TIN = 7;
	protected static final int LICH_SU_SUA_HO_SO_THEM_TIEN_TE = 8;
	protected static final int LICH_SU_SUA_HO_SO_SUA_TIEN_TE = 9;
	protected static final int LICH_SU_SUA_HO_SO_XOA_TIEN_TE = 10;
	protected static final String GET_TIEN_TE = "com.nsw.sbv.p01.tienTe1.get";
	protected static final String GET_HO_SO = "com.nsw.sbv.p01.hoSoNgoaiTe1.get";
	protected static final String UPDATE_HO_SO = "com.nsw.sbv.p01.hoSoNgoaiTe1.update";
	protected static final String GET_GIAY_PHEP_BY_ID_HO_SO = "com.nsw.sbv.p01.giayPhep1.getByIdHoSo";
	protected static final String GET_CUA_KHAU_BY_MA_CHI_NHANH = "com.nsw.sbv.p01.cuaKhau1.getByMaChiNhanhs";
	protected static final String GET_TIEN_TE_BY_ID_HO_SO = "com.nsw.sbv.p01.tienTe1.getByTienTes";
	protected static final String GET_TEP_DINH_KEM_BY_ID_HO_SO = "com.nsw.sbv.p01.tepDinhKemHoSo1.getByTepDinhKems";
	protected static final String GET_GIAY_PHEP_BY_SO_GIAY_PHEP = "com.nsw.sbv.p01.giayPhep1.findBySoGiayPhep";
	protected static final String GET_TRANG_THAIS = "com.nsw.sbv.p01.trangThai1.getAllTrangThai1s";
	protected static final String GET_CHI_NHANH_NGAN_HANGS = "com.nsw.sbv.p01.chiNhanhNganHang1.getAllChiNhanhNganHang1s";
	protected static final String CREATE_TIEN_TE = "com.nsw.sbv.p01.tienTe1.create";
	protected static final String UPDATE_TIEN_TE = "com.nsw.sbv.p01.tienTe1.update";
	protected static final String DELETE_TIEN_TE = "com.nsw.sbv.p01.tienTe1.delete";
	protected static final String CREATE_TEP_DINH_KEM = "com.nsw.sbv.p01.tepDinhKemHoSo1.create";
	protected static final String DELETE_TEP_DINH_KEM = "com.nsw.sbv.p01.tepDinhKemHoSo1.delete";
	protected static final String GET_TEP_DINH_KEM = "com.nsw.sbv.p01.tepDinhKemHoSo1.get";
	protected static final String GET_CUA_KHAUS = "com.nsw.sbv.p01.cuaKhau1.getAllCuaKhaus";
	protected static final String GET_TIEN_TES = "com.nsw.sbv.p01.loaiTienTe1.getAllLoaiTienTe1s";
	protected static final String GET_TRANG_THAI_BY_GIA_TRI = "com.nsw.sbv.p01.trangThai1.findByGiaTri";
	protected static final String SEARCH_KET_QUA_XU_LY= "com.nsw.sbv.p01.ketQuaXuLyHoSo1.searchKetQuaXuLys";
	protected static final String COUNT_KET_QUA_XU_LY= "com.nsw.sbv.p01.ketQuaXuLyHoSo1.countKetQuaXuLys";
	protected static final String SEARCH_HO_SO= "com.nsw.sbv.p01.hoSoNgoaiTe1.searchHoSos";
	protected static final String COUNT_HO_SO= "com.nsw.sbv.p01.hoSoNgoaiTe1.countHoSos";
	protected static final String FIND_BY_MA_CHI_NHANH = "com.nsw.sbv.p01.chiNhanhNganHang1.findByMaChiNhanh";
	protected static final String FIND_BY_MA_CUA_KHAU = "com.nsw.sbv.p01.cuaKhau1.findByMaCuaKhau";
	protected static final String CREATE_HO_SO = "com.nsw.sbv.p01.hoSoNgoaiTe1.create";
	protected static final String GET_KET_QUA_XU_LY = "com.nsw.sbv.p01.ketQuaXuLyHoSo1.get";
	protected static final String GET_SO_GIAY_PHEP = "com.nsw.sbv.p01.giayPhep1.findBySoGiayPhep";
	
	protected static final String SEND_ALL = "com.nsw.sbv.p01.sendAll";
	protected static final String IS_SIGN_KEY = "nsw.sbv.01.sign";
	protected static final String TOKEN_KEY = "sbv.01.guihoso.token";
}
