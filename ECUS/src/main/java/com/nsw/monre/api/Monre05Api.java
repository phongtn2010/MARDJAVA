package com.nsw.monre.api;

import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.common.model.ResponseDownload;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.monre.p05.constant.*;
import com.nsw.monre.p05.model.*;
import com.nsw.monre.p01.model.ResponseJson;
import com.nsw.monre.p01.model.TbdCapGiayXacNhan1;
import com.nsw.monre.p01.model.TbsCoQuanXuLy1;
import com.nsw.monre.p01.model.TbsStatus1;
import com.nsw.monre.p05.searchitem.*;
import com.nsw.monre.p05.service.*;
import com.nsw.monre.p01.constant.AppKeyConstant;
import com.nsw.monre.p01.constant.AppViewThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.model.UserInfo;
import com.nsw.monre.p01.searchitem.TbdCapGiayXacNhan1SearchItem;
import com.nsw.monre.p01.service.TbdCapGiayXacNhan1Service;
import com.nsw.monre.p01.service.TbsCoQuanXuLy1Service;
import com.nsw.monre.p01.service.TbsStatus1Service;
import com.nsw.monre.p01.util.*;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

@Controller
@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.URI_THU_TUC_05 })
public class Monre05Api {

	private static final Logger LOGGER = LoggerFactory.getLogger(Monre05Api.class);

	private static final String CLASS_NAME = "Monre05Api";

	private static final String SELECT_BOX_LABEL_KEY = "monre.01.select.label-default";

	
	@Autowired
	private Environment environment;

	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	protected MessageSource mMessageSource;

	@Autowired
	protected TbdHSDeNghiCapGiayXn5Service mTbdHSDeNghiCapGiayXn5Service;

	@Autowired
	protected TbdGXNThongTinCoSoSX5Service mTbdGXNThongTinCoSoSX5Service;

	@Autowired
	protected TbdGXNThongTinPheLieu5Service mTbdGXNThongTinPheLieu5Service;

	@Autowired
	protected TbdKetQuaXuLy5Service mTbdKetQuaXuLy5Service;

	@Autowired
	protected TbdCapGiayXacNhan5Service mTbdCapGiayXacNhan5Service;

	@Autowired
	protected TbdYeuCauRutHS5Service mTbdYeuCauRutHS5Service;

	@Autowired
	protected TbdTepTin5Service mTbdTepTin5Service;

	@Autowired
	protected TbdCapGiayXacNhan1Service mTbdCapGiayXacNhan1Service;

	@Autowired
	protected TbsStatus1Service mTbsStatusService;

	@Autowired
	protected TbsCoQuanXuLy1Service mTbsCoQuanXuLy1Service;

	@InitBinder
	public void bindData(WebDataBinder binder) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	/**
	 * Lay danh sach ho so
	 * 
	 * @param request
	 * @param form
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.DANH_SACH_HO_SO }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layHoSo(HttpServletRequest request, @RequestBody TbdHSDeNghiCapGiayXn5 form) {

		try {

			UserInfo userInfo = LoginUtil.getUserInfo();

			if (userInfo.getMaSoThue() == null) {

				return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
			}

			TbdHSDeNghiCapGiayXn5SearchItem item = new TbdHSDeNghiCapGiayXn5SearchItem();

			item.setFiloaithutuc(AppCommon.getLoaiThuTuc(request));

			item.setFiidhs(-1);

			item.setFixoa(0);

			item.setFitrangthai(-1);

			item = makeTbdHSDeNghiCapGiayXn5SearchItem(form, item);

			long totalTbdHSDeNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn5Service.count(item);

			int pageIndex = form.getPageIndex() < 1 ? 1 : form.getPageIndex();

			item.setPageIndex(pageIndex);

			item.setPageSize(AppKeyConstant.Page.PAGE_SIZE);

			List<HoSo5> tbdHSDeNghiCapGiayXn1s = mTbdHSDeNghiCapGiayXn5Service.search(item);

			// gan gia tri cho so thu tu cua ban ghi
			if (tbdHSDeNghiCapGiayXn1s != null) {

				for (int i = 0; i < tbdHSDeNghiCapGiayXn1s.size(); i++) {

					HoSo5 capGiayXn1 = tbdHSDeNghiCapGiayXn1s.get(i);

					capGiayXn1.setSoThuTu((pageIndex - 1) * AppKeyConstant.Page.PAGE_SIZE + i + 1);

					capGiayXn1.setTotal((int) totalTbdHSDeNghiCapGiayXn1);
				}
			}

			Object data = tbdHSDeNghiCapGiayXn1s;

			return createResponseEntity(data, totalTbdHSDeNghiCapGiayXn1, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), true, HttpStatus.OK);
	}

	private TbdHSDeNghiCapGiayXn5SearchItem makeTbdHSDeNghiCapGiayXn5SearchItem(TbdHSDeNghiCapGiayXn5 form, TbdHSDeNghiCapGiayXn5SearchItem item) {

		if (StringUtils.hasText(form.getMaHoSo())) {

			item.setFimahoso("%" + form.getMaHoSo().trim() + "%");

		}

		if ((form.getNgayCapStart() != null) && (form.getNgayCapEnd() != null)) {

			item.setFingaycapStart(form.getNgayCapStart());
			item.setFingaycapEnd(form.getNgayCapEnd());

		} else if ((form.getNgayCapStart() != null) && (form.getNgayCapEnd() == null)) {

			item.setFingaycapStart(form.getNgayCapStart());

		} else if ((form.getNgayCapStart() == null) && (form.getNgayCapEnd() != null)) {

			item.setFingaycapEnd(form.getNgayCapEnd());
		}

		if ((form.getNgayTaoStart() != null) && (form.getNgayTaoEnd() != null)) {

			item.setFingaytaoStart(form.getNgayTaoStart());
			item.setFingaytaoEnd(form.getNgayTaoEnd());

		} else if ((form.getNgayTaoStart() != null) && (form.getNgayTaoEnd() == null)) {

			item.setFingaytaoStart(form.getNgayTaoStart());

		} else if ((form.getNgayTaoStart() == null) && (form.getNgayTaoEnd() != null)) {

			item.setFingaytaoEnd(form.getNgayTaoEnd());
		}

		if (form.getTrangThai() >= 0) {

			item.setFitrangthai(form.getTrangThai());
		}

		if (StringUtils.hasText(form.getMaSoThue())) {
			item.setFimasothue("%" + form.getMaSoThue().trim() + "%");
		}
		if (StringUtils.hasText(form.getSoGXNDaCap())) {
			item.setFisogiayxn("%" + form.getSoGXNDaCap().trim() + "%");
		}
		return item;
	}

	
	/**
	 * Lay danh sach tat ca trang thai
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.DANH_SACH_TAT_CA_TRANG_THAI }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachTrangThai(HttpServletRequest request) {

		try {

			List<TbsStatus1> dsStatus5s = new ArrayList<>();

			TbsStatus1 pl0 = new TbsStatus1();

			pl0.setTenTrangThai(getMessage(SELECT_BOX_LABEL_KEY, request.getLocale()));

			pl0.setIdTrangThai(-5);

			dsStatus5s.add(pl0);
			List<TbsStatus1> tbsStatuss = mTbsStatusService.getTbsStatus1s();

			if (tbsStatuss != null)
				dsStatus5s.addAll(tbsStatuss);

			Object data = dsStatus5s;

			return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.DANH_SACH_TAT_CA_CO_QUAN_XU_LY }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachCoQuanXuLy(HttpServletRequest request) {

		try {

			List<TbsCoQuanXuLy1> dsTbsCoQuanXuLy1 = new ArrayList<>();

			TbsCoQuanXuLy1 pl0 = new TbsCoQuanXuLy1();

			pl0.setMaCoQuan("-5");

			pl0.setTenCoQuan(getMessage(SELECT_BOX_LABEL_KEY, request.getLocale()));

			dsTbsCoQuanXuLy1.add(pl0);

			List<TbsCoQuanXuLy1> tbsPheLieu5s = mTbsCoQuanXuLy1Service.getTbsCoQuanXuLy1s();

			if (tbsPheLieu5s != null) {

				dsTbsCoQuanXuLy1.addAll(tbsPheLieu5s);
			}

			Object data = dsTbsCoQuanXuLy1;

			return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay thong tin giay xac nhan cap lai
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.LAY_THONG_TIN_SO_GIAY_XAC_NHAN_URL }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> layThongTinGiayXacNhanTheoSoGXN(@PathVariable("idHS") long idHS, @PathVariable("soGXN") String soGiayXN, HttpServletRequest request) {

		try {

			UserInfo userInfo = LoginUtil.getUserInfo();

			if (userInfo == null) {

				return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
			}

			Object data = null;
			if (idHS > 0) {

				List<TbdCapGiayXacNhan5> listTbdGiayXacNhan = mTbdCapGiayXacNhan5Service.findByIdHSOrderByIdGxnDesc(idHS);
				if (listTbdGiayXacNhan != null && !listTbdGiayXacNhan.isEmpty()) {
					data = listTbdGiayXacNhan.get(0);
				}
			} else {
				TbdCapGiayXacNhan1SearchItem capGiayXacNhan1SearchItem = new TbdCapGiayXacNhan1SearchItem();
				capGiayXacNhan1SearchItem.setFimasothue(userInfo.getMaSoThue());
				capGiayXacNhan1SearchItem.setFisogiayxn(soGiayXN);
				capGiayXacNhan1SearchItem.setFihinhthuc(-1);
				List<TbdCapGiayXacNhan1> listTbdGiayXacNhan = mTbdCapGiayXacNhan1Service.searchTbdCapGiayXacNhan1s(capGiayXacNhan1SearchItem);
				if (listTbdGiayXacNhan != null && !listTbdGiayXacNhan.isEmpty()) {
					data = listTbdGiayXacNhan.get(0);
				}
			}

			return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	

	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/getHoSo/{idHS}" }, method = RequestMethod.POST)
	public ResponseEntity<Object> getHoSo(@PathVariable("idHS") long idHS, HttpServletRequest request) {

		try {

			HoSoEditForm form = new HoSoEditForm();
			form.setCoQuanXuLyList(getCoQuanXuLy(request));
			TbdHSDeNghiCapGiayXn5 deNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn5Service.getTbdHSDeNghiCapGiayXn5(idHS);

			if (deNghiCapGiayXn1 != null) {
				form = ConvertToObjectUtil.convertTo(deNghiCapGiayXn1, form);
				form.setNgayCapDateFormat(deNghiCapGiayXn1.getNgayCap());
				form.setNgayHetHanDateFormat(deNghiCapGiayXn1.getNgayHetHan());
				form.setNgayCapGCNDKKDDateFormat(deNghiCapGiayXn1.getNgayCapGCNDKKD());
				form.setCoQuanXuLyList(getCoQuanXuLy(request));
				form.setTepDinhKemList(mTbdTepTin5Service.findByIdHSOrderByLoaiTepTinAsc(idHS));
				return createResponseEntity(form, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

			}
			

		} catch (Exception e) {
			logError(e);
			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	private List<TbsCoQuanXuLy1> getCoQuanXuLy(HttpServletRequest request) {
		List<TbsCoQuanXuLy1> dsTbsCoQuanXuLy1 = new ArrayList<>();
		TbsCoQuanXuLy1 pl0 = new TbsCoQuanXuLy1();
		pl0.setMaCoQuan("-1");
		pl0.setTenCoQuan(mMessageSource.getMessage(SELECT_BOX_LABEL_KEY, null, request.getLocale()));
		dsTbsCoQuanXuLy1.add(pl0);
		List<TbsCoQuanXuLy1> tbsPheLieu1s = mTbsCoQuanXuLy1Service.getTbsCoQuanXuLy1s();
		if (tbsPheLieu1s != null) {
			dsTbsCoQuanXuLy1.addAll(tbsPheLieu1s);
		}
		return dsTbsCoQuanXuLy1;
	}

	
	
	/**
	 * Lay danh sach tep tin theo ho so
	 * 
	 * @param request
	 * @param idHS
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.DANH_SACH_TEP_TIN_THEO_HO_SO }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachTepTinTheoHoSo(HttpServletRequest request, @PathVariable("id") long idHS) {

		try {

			Object data = null;

			if (idHS > 0) {

				data = mTbdTepTin5Service.findByIdHSOrderByLoaiTepTinAsc(idHS);
			}

			return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}


	/**
	 * @param idGXN
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.LAY_THONG_TIN_CO_SO_SAN_XUAT_THEO_SO_GIAY_XAC_NHAN_URL }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> layThongTinCoSoSanXuatTheoGiayXacNhan(@PathVariable("idGXN") long idGXN, HttpServletRequest request) {

		try {

			UserInfo userInfo = LoginUtil.getUserInfo();

			if (userInfo == null) {

				return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
			}

			Object data = mTbdGXNThongTinCoSoSX5Service.findByIdGXN(idGXN);

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * @param idGXN
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { AppViewThuTuc05Constant.ViewURL.LAY_THONG_TIN_PHE_LIEU_THEO_SO_GIAY_XAC_NHAN_URL }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> layThongTinPheLieuTheoGiayXacNhan(@PathVariable("idGXN") long idGXN, HttpServletRequest request) {

		try {

			UserInfo userInfo = LoginUtil.getUserInfo();

			if (userInfo == null) {

				return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
			}

			Object data = mTbdGXNThongTinPheLieu5Service.findByIdGXN(idGXN);

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	

	@RequestMapping(value = AppViewThuTuc05Constant.ViewURL.DOWNLOAD_GIAY_XAC_NHAN_URL, method = RequestMethod.GET)
	public void downloadFileGiayXacNhan(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) {

		try {

			List<TbdCapGiayXacNhan5> tbdCapGiayXacNhan5s = mTbdCapGiayXacNhan5Service.findByIdHSOrderByIdGxnDesc(id);

			if (tbdCapGiayXacNhan5s == null || tbdCapGiayXacNhan5s.isEmpty())
				return;

			TbdCapGiayXacNhan5 tbdCapGiayXacNhan5 = tbdCapGiayXacNhan5s.get(0);

			LOGGER.info("downloadFileGiayXacNhan: {}", tbdCapGiayXacNhan5);
			
			if (tbdCapGiayXacNhan5 != null) {
				RabbitMQInfo mqInfo = getRabbitMQ();
				String uri = getFullUri("/monre/05/download2/");

				String fileName = FilenameUtils.getName(tbdCapGiayXacNhan5.getLinkGiayXN());
				String filePath = FilenameUtils.getFullPathNoEndSeparator(tbdCapGiayXacNhan5.getLinkGiayXN());
				byte[] fileContent = downloadFile(uri, filePath, fileName, mqInfo);
				if (fileContent == null) fileContent = new byte[0];

				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
				response.setContentLength(fileContent.length);

				FileCopyUtils.copy(fileContent, response.getOutputStream());
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}
	}

	public byte[] downloadFile(String restUri, String filePath, String fileName, RabbitMQInfo mqInfo) {
		byte[] b = null;
		try {
			URI uri = new URI(restUri);
			RestTemplate restTemplate = new RestTemplate();
			FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
			formConverter.setCharset(Charset.forName("UTF8"));
			restTemplate.getMessageConverters().add(formConverter);
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
			parts.add("filePath", filePath);
			parts.add("fileName", fileName);
			ResponseJson res = restTemplate.postForObject(uri, parts, ResponseJson.class);

			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			String jsonData = mapper.writeValueAsString(res.getData());
			ResponseDownload downloadInfo = mapper.readValue(jsonData, ResponseDownload.class);
			b = downloadInfo.getContent();
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[5].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
			b = null;
			logError(ex);
		}

		return b;
	}

	protected void logInfor(String message) {

		LOGGER.info(message);
	}

	protected void logError(Exception exception) {

		LOGGER.error(exception.getLocalizedMessage());
	}

	protected void logError(String message) {

		LOGGER.error(message);
	}

	protected String getMessage(String messageKey, Locale locale) {

		try {

			return mMessageSource.getMessage(messageKey, null, locale);

		} catch (Exception e) {
			logError(e);
		}

		return "";
	}

	protected ResponseEntity<Object> createResponseEntity(Object data, String message, boolean success, HttpStatus httpStatus) {

		ResponseJson item = new ResponseJson();

		item.setData(data);

		item.setMessage(message);

		item.setSuccess(success);

		return new ResponseEntity<>(item, httpStatus);
	}

	protected ResponseEntity<Object> createResponseEntity(Object data, Long total, String message, boolean success, HttpStatus httpStatus) {

		ResponseJson item = new ResponseJson();

		item.setData(data);

		item.setTotal(total);

		item.setMessage(message);

		item.setSuccess(success);

		return new ResponseEntity<>(item, httpStatus);
	}

	public void pushLog(Exception ex) {

		try {

			String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName() + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[5].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

		} catch (Exception e) {
			logError(e);
		}

	}

	private String getFullUri(String restUri) {
		return environment.getRequiredProperty(ThuTuc01Constant.API.BACKEND) + restUri;
	}

	private RabbitMQInfo getRabbitMQ() {
		return rabbitMQService.getRabbitMQInfo();
	}
}
