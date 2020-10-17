package com.nsw.sbv.api;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.sbv.p01.model.ChiNhanhNganHang1;
import com.nsw.sbv.p01.model.ChiTietGiayPhep;
import com.nsw.sbv.p01.model.CuaKhau1;
import com.nsw.sbv.p01.model.GiayPhep1;
import com.nsw.sbv.p01.model.HoSoNgoaiTe1;
import com.nsw.sbv.p01.model.HoSoNgoaiTe1SearchItem;
import com.nsw.sbv.p01.model.HoSoNgoaiTeEditForm;
import com.nsw.sbv.p01.model.HoSoNgoaiTeSearchForm;
import com.nsw.sbv.p01.model.HuyHoSoForm;
import com.nsw.sbv.p01.model.KetQuaXuLyHoSo1;
import com.nsw.sbv.p01.model.KetQuaXuLyHoSoModel;
import com.nsw.sbv.p01.model.KySoModel;
import com.nsw.sbv.p01.model.LoaiTienTe1;
import com.nsw.sbv.p01.model.SendMessage;
import com.nsw.sbv.p01.model.TbsTepDinhKem1;
import com.nsw.sbv.p01.model.TepDinhKemHoSo1;
import com.nsw.sbv.p01.model.TienTe1;
import com.nsw.sbv.p01.model.TienTeEditForm;
import com.nsw.sbv.p01.model.TrangThai1;
import com.nsw.sbv.p01.model.YeuCauHuyHoSo1;
import com.nsw.sbv.p01.util.CertificateUtils;
import com.nsw.sbv.p01.util.ConvertToObjectUtil;
import com.nsw.sbv.p01.util.DateUtil;
import com.nsw.sbv.p01.util.SBV01ChiNhanhNganHang1BackendUtil;
import com.nsw.sbv.p01.util.SBV01Constants;
import com.nsw.sbv.p01.util.SBV01Constants.MessageFunction;
import com.nsw.sbv.p01.util.SBV01Constants.MessageType;
import com.nsw.sbv.p01.util.SBV01CuaKhau1BackendUtil;
import com.nsw.sbv.p01.util.SBV01GiayPhep1BackendUtil;
import com.nsw.sbv.p01.util.SBV01HoSoNgoaiTe1BackendUtil;
import com.nsw.sbv.p01.util.SBV01HoSoNgoaiTeCustomUtil;
import com.nsw.sbv.p01.util.SBV01KetQuaXuLyHoSo1BackendUtil;
import com.nsw.sbv.p01.util.SBV01LoaiTienTe1BackendUtil;
import com.nsw.sbv.p01.util.SBV01TbsTepDinhKem1BackendUtil;
import com.nsw.sbv.p01.util.SBV01TepDinhKemHoSo1BackendUtil;
import com.nsw.sbv.p01.util.SBV01TienTe1BackendUtil;
import com.nsw.sbv.p01.util.SBV01TrangThai1BackendUtil;
import com.nsw.sbv.p01.util.SBV01YeuCauHuyHoSo1BackendUtil;
import com.nsw.sbv.p01.util.TrangThaiHoSo;
import com.nsw.security.UserCustom;

/**
 * @author Quang
 *
 */
@Controller
@RequestMapping(value = SBV01Constants.ApiUrls.ROOT)
public class SBV01ApiController extends SBV01BaseController {

	public static final Logger LOGGER = LoggerFactory.getLogger(SBV01ApiController.class);

	private static final String DATE_PATTERN = "dd/MM/yyyy";
	
	@Autowired
	private SBV01TbsTepDinhKem1BackendUtil tepDinhKem1BackendUtil;

	@InitBinder
	public void bindData(WebDataBinder binder) {

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	

	/**
	 * Lay danh sach tat ca trang thai
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_TRANG_THAI, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTrangThais(HttpServletRequest request) {

		try {

			Object data = SBV01TrangThai1BackendUtil.getAllTrangThai1s(getURL(GET_TRANG_THAIS));

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachTrangThai]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tien te theo ho so
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_TIEN_TE_THEO_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTienTeTheoHoSos(HttpServletRequest request, @PathVariable("id") long idHoSo) {

		try {

			Object data = SBV01TienTe1BackendUtil.getByTienTes(getURL(GET_TIEN_TE_BY_ID_HO_SO), idHoSo);

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachTrangThai]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tien te theo ho so
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.SAVE_TIEN_TE_THEO_HO_SO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> saveTienTeByIdHoSo(HttpServletRequest request, @RequestBody TienTe1 tienTe1) {

		try {

			if (tienTe1.getIdHoSo() < 1 || !StringUtils.hasText(tienTe1.getSoLuongNgoaiTeBangChu()) || tienTe1.getSoLuongNgoaiTeBangSo() < 1) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), tienTe1.getIdHoSo());
			Object data = null;

			String t1 = "{ " + tienTe1.getMaLoaiTienTe() + " | " + tienTe1.getSoLuongNgoaiTeBangSo() + " | " + tienTe1.getSoLuongNgoaiTeBangChu() + " }";

			if (tienTe1.getIdTienTe() == 0) {

				data = SBV01TienTe1BackendUtil.createTienTe1(getURL(CREATE_TIEN_TE), tienTe1);
				saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_SUA_HO_SO_THEM_TIEN_TE, t1, hoSoNgoaiTe1.getMaHoSo());

			} else {

				TienTe1 findTienTe = SBV01TienTe1BackendUtil.getTienTe1(getURL(GET_TIEN_TE), tienTe1.getIdTienTe());
				String t2 = "{ " + findTienTe.getMaLoaiTienTe() + " | " + findTienTe.getSoLuongNgoaiTeBangSo() + " | " + findTienTe.getSoLuongNgoaiTeBangChu() + " }";

				data = SBV01TienTe1BackendUtil.updateTienTe1(getURL(UPDATE_TIEN_TE), tienTe1.getIdTienTe(), tienTe1);
				saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_SUA_HO_SO_SUA_TIEN_TE, t2, t1, hoSoNgoaiTe1.getMaHoSo());
			}

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[saveTienTeByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tien te theo ho so
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.DELETE_TIEN_TE_THEO_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteTienTeByIdHoSo(HttpServletRequest request, @PathVariable("id") long idTienTe) {

		try {

			if (idTienTe < 1) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			TienTe1 tienTe1 = SBV01TienTe1BackendUtil.getTienTe1(getURL(GET_TIEN_TE), idTienTe);
			Object data = SBV01TienTe1BackendUtil.deleteTienTe1(getURL(DELETE_TIEN_TE), idTienTe);
			if (data != null) {
				HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), tienTe1.getIdHoSo());

				saveLichSuHoSo(request, tienTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_SUA_HO_SO_XOA_TIEN_TE, buildTienTeMessage(request, tienTe1));
			}
			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[deleteTienTeByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * yeu cau huy ho so
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.HUY_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> huyHoSo(HttpServletRequest request, @PathVariable("id") long idHoSo, @RequestBody HuyHoSoForm form) {

		try {
			HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), idHoSo);
			if (hoSoNgoaiTe1 == null) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			boolean success = callHuyHoSo(hoSoNgoaiTe1, form.getNoiDung());
			return saveHistoryCancel(request, hoSoNgoaiTe1, form, success);

		} catch (Exception e) {

			LOGGER.error("[huyHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	private ResponseEntity<Object> saveHistoryCancel(HttpServletRequest request, HoSoNgoaiTe1 hoSoNgoaiTe1, HuyHoSoForm form, boolean success) {

		YeuCauHuyHoSo1 yeuCauHuyHoSo1 = new YeuCauHuyHoSo1();
		yeuCauHuyHoSo1.setIdHoSo(hoSoNgoaiTe1.getIdHoSo());
		yeuCauHuyHoSo1.setNgayXinHuy(new Date());
		yeuCauHuyHoSo1.setLyDoHuyHoSo(form.getNoiDung());
		SBV01YeuCauHuyHoSo1BackendUtil.createYeuCauHuyHoSo1(getURL("com.nsw.sbv.p01.yeuCauHuyHoSo1.create"), yeuCauHuyHoSo1);

		hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), hoSoNgoaiTe1.getIdHoSo());

		if (success) {
			saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_HUY_HO_SO, hoSoNgoaiTe1.getMaHoSo() + ". " + getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()));
			LOGGER.info("HUY HO SO THANH CONG: {}", yeuCauHuyHoSo1);
			return createResponseEntity(hoSoNgoaiTe1, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
		} else {
			saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_HUY_HO_SO, hoSoNgoaiTe1.getMaHoSo() + ". " + getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()));
			LOGGER.info("HUY HO SO KHONG THANH CONG: {}", yeuCauHuyHoSo1);
			return createResponseEntity(hoSoNgoaiTe1, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
		}

	}

	private boolean callHuyHoSo(HoSoNgoaiTe1 hoSoNgoaiTe1, String lyDo) {

		if (!StringUtils.hasText(lyDo) || hoSoNgoaiTe1 == null || hoSoNgoaiTe1.getIdHoSo() < 0) {
			return false;
		}

		SendMessage sendMessage = setSendMessage12(hoSoNgoaiTe1, MessageType.TYPE_12);

		sendMessage.setLyDo(lyDo);

		ResponseJson json = send(sendMessage);
		if (json != null) {
			return json.isSuccess();
		}

		return false;
	}

	private SendMessage setSendMessage12(HoSoNgoaiTe1 hoSoNgoaiTe1, String messageType) {

		SendMessage sendMessage = new SendMessage();
		sendMessage.setFiIdHoso(hoSoNgoaiTe1.getIdHoSo());
		String function = "";

		if (hoSoNgoaiTe1.getTrangThai() == TrangThaiHoSo.CHO_TIEP_NHAN_1) function = MessageFunction.FUN_01;
		else function = MessageFunction.FUN_02;

		sendMessage.setFunction(function);
		sendMessage.setType(messageType);
		sendMessage.setFunction(function);
		return sendMessage;
	}

	/**
	 * yeu cau huy ho so
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.GUI_HO_SO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> sendHoSo(HttpServletRequest request, @RequestBody KySoModel kySoModel) {

		try {
			HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), kySoModel.getIdHoSo());
			if (hoSoNgoaiTe1 == null) {

				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			ResponseEntity<Object> responseEntity = isValidGuiHoSo(hoSoNgoaiTe1);
			if (!Objects.isNull(responseEntity)) {
				return responseEntity;
			}
			
			boolean isSign = Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
			kySoModel.setRequiredSign(isSign);
			
			boolean success = guiHoSo(hoSoNgoaiTe1, kySoModel);

			return saveHistorySendHoSo(request, hoSoNgoaiTe1, null, success);
		} catch (Exception e) {

			LOGGER.error("[sendHoSo]", e);
		}

		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tat ca cua khau
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_CUA_KHAU, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getCuaKhaus(HttpServletRequest request) {

		try {
			Object data = SBV01CuaKhau1BackendUtil.getAllCuaKhaus(getURL(GET_CUA_KHAUS));

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tat ca cua khau
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_LICH_SU + "/{idHoSo}/{pageIndex}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getLichSuHoSos(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo, @PathVariable("pageIndex") int pageIndex) {

		try {
			Object data = null;
			List<KetQuaXuLyHoSo1> kqs = SBV01KetQuaXuLyHoSo1BackendUtil.searchKetQuaXuLys(getURL(SEARCH_KET_QUA_XU_LY), idHoSo, pageIndex, 10);
			if (kqs != null) {
				List<KetQuaXuLyHoSoModel> ketQuaXuLyHoSoModels = new ArrayList<>();
				for (int k = 0; k < kqs.size(); k++) {
					KetQuaXuLyHoSo1 item = kqs.get(k);
					KetQuaXuLyHoSoModel ketQuaXuLyHoSoModel = new KetQuaXuLyHoSoModel();
					ConvertToObjectUtil.convertTo(item, ketQuaXuLyHoSoModel);

					TrangThai1 trangThai1 = SBV01TrangThai1BackendUtil.findByGiaTri(getURL(GET_TRANG_THAI_BY_GIA_TRI), item.getTrangThai());
					ketQuaXuLyHoSoModel.setNgayTacDongDateFormat(DateUtil.getDateTimeFormat(item.getNgayXuLy()));
					ketQuaXuLyHoSoModel.setSoThuTu((pageIndex - 1) * 10 + (k + 1));
					ketQuaXuLyHoSoModel.setTenTrangThai(trangThai1.getTenTrangThai());
					if (StringUtils.hasText(ketQuaXuLyHoSoModel.getTenTepDinhKem())) {
						String url = request.getRequestURL().toString();
						url = url.replace("/sbv/api/01/layDsLichSuHS/" + idHoSo + "/" + pageIndex, "");
						ketQuaXuLyHoSoModel.setLoaiTep(FilenameUtils.getExtension(ketQuaXuLyHoSoModel.getTenTepDinhKem()));
						ketQuaXuLyHoSoModel.setLink(url + SBV01Constants.ApiUrls.ROOT + "/downloadKQXL/" + item.getIdKetQuanXuLyHoSo());
					}
					ketQuaXuLyHoSoModels.add(ketQuaXuLyHoSoModel);
				}
				data = ketQuaXuLyHoSoModels;
			}
			long total = SBV01KetQuaXuLyHoSo1BackendUtil.countKetQuaXuLys(getURL(COUNT_KET_QUA_XU_LY), idHoSo);
			return createResponseEntity(data, total, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {

			LOGGER.error("[layLichSuHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tat ca cua khau
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.XEM_GIAY_XAC_NHAN + "/{idHoSo}/{pageIndex}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getChiTietGiayXacNhan(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			Object data = null;

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {

			LOGGER.error("[getChiTietGiayXacNhan]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tat ca cua khau
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_CUA_KHAU_THEO_CHI_NHANH + "/{maChiNhanh}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getCuaKhauTheoMaChiNhanhs(HttpServletRequest request, @PathVariable("maChiNhanh") String maChiNhanh) {

		try {
			if (!StringUtils.hasText(maChiNhanh) || "null".equals(maChiNhanh.trim()) || "-1".equals(maChiNhanh.trim())) {
				return createResponseEntity(Collections.emptyList(), 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			Object data = SBV01CuaKhau1BackendUtil.getByMaChiNhanhs(getURL(GET_CUA_KHAU_BY_MA_CHI_NHANH), maChiNhanh);

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachCuaKhauTheoMaChiNhanh]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay thong tin giay phep
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_THONG_TIN_GIAY_PHEP + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getGiayPhep(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), idHoSo);
			if (hoSoNgoaiTe1 == null) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			GiayPhep1 giayPhep1 = SBV01GiayPhep1BackendUtil.getByIdHoSo(getURL(GET_GIAY_PHEP_BY_ID_HO_SO), idHoSo);
			if (giayPhep1 == null) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			ChiTietGiayPhep chiTietGiayPhep = new ChiTietGiayPhep();
			chiTietGiayPhep.setSoGiayPhep(giayPhep1.getSoGiayPhep());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(giayPhep1.getNgayCap());
			chiTietGiayPhep.setNgay(formatDate(calendar.get(Calendar.DATE)));
			chiTietGiayPhep.setThang(formatDate(calendar.get(Calendar.MONTH) + 1));
			chiTietGiayPhep.setNam(String.valueOf(calendar.get(Calendar.YEAR)));
			chiTietGiayPhep.setTenNganHang(giayPhep1.getTenNganHang());
			chiTietGiayPhep.setDiaChi(giayPhep1.getDiaChi());
			chiTietGiayPhep.setDienThoai(giayPhep1.getDienThoai());
			chiTietGiayPhep.setFax(giayPhep1.getFax());
			chiTietGiayPhep.setTenCuaKhau(giayPhep1.getTenCuaKhau());
			chiTietGiayPhep.setNguoiKy(giayPhep1.getNguoiKy());
			chiTietGiayPhep.setDiaDanh(getEndPosition(giayPhep1.getDiaChi()));
			chiTietGiayPhep.setDoiTacXuatNhapKhau(hoSoNgoaiTe1.getDoiTacXuatNhapKhau());
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
			chiTietGiayPhep.setHieuLucDenNgay(dateFormat.format(giayPhep1.getNgayHetHan()));
			chiTietGiayPhep.setHieuLucTuNgay(dateFormat.format(giayPhep1.getNgayCap()));
			chiTietGiayPhep.setTenChiNhanh(hoSoNgoaiTe1.getTenChiNhanh());
			String thoiGian = "từ ngày ";
			thoiGian += dateFormat.format(hoSoNgoaiTe1.getXuatNhapKhauTuNgay());
			thoiGian += " đến ngày ";
			thoiGian += dateFormat.format(hoSoNgoaiTe1.getXuatNhapKhauDenNgay());
			chiTietGiayPhep.setThoiGian(thoiGian);
			chiTietGiayPhep.setGhiChu(giayPhep1.getGhiChu());
			chiTietGiayPhep.setHinhThucNhapKhau(hoSoNgoaiTe1.getHinhThucXNK() == 1);
			chiTietGiayPhep.setHinhThucXuatKhau(hoSoNgoaiTe1.getHinhThucXNK() == 2);
			List<TienTe1> tienTe1s = SBV01TienTe1BackendUtil.getByTienTes(getURL(GET_TIEN_TE_BY_ID_HO_SO), idHoSo);
			if (tienTe1s != null) {
				chiTietGiayPhep.setTienTes(tienTe1s);
			}

			Object data = chiTietGiayPhep;
			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getGiayPhep]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	private String formatDate(int ngayThang) {
		DecimalFormat decimalFormat = new DecimalFormat("00");
		return decimalFormat.format(ngayThang);
	}
	private String getEndPosition(String value) {
		if (StringUtils.hasText(value)) {
			char[] chs = value.toCharArray();
			for (int i = value.length() - 1; i >= 0; i--) {
				if (chs[i] == ',') return value.substring(i, value.length());
			}
		}
		return value;
	}

	/**
	 * Lay thong tin giay phep
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_THONG_TIN_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getChiTietHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {

			HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), idHoSo);
			if (hoSoNgoaiTe1 == null) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			ChiTietGiayPhep chiTietGiayPhep = new ChiTietGiayPhep();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(hoSoNgoaiTe1.getNgayTao());

			chiTietGiayPhep.setNgay(formatDate(calendar.get(Calendar.DATE)));
			chiTietGiayPhep.setThang(formatDate(calendar.get(Calendar.MONTH) + 1));
			chiTietGiayPhep.setNam(String.valueOf(calendar.get(Calendar.YEAR)));
			chiTietGiayPhep.setTenNganHang(hoSoNgoaiTe1.getTenNganHang());
			chiTietGiayPhep.setTenChiNhanh(hoSoNgoaiTe1.getTenChiNhanh());
			chiTietGiayPhep.setDiaChi(hoSoNgoaiTe1.getDiaChi());
			chiTietGiayPhep.setDienThoai(hoSoNgoaiTe1.getDienThoai());
			chiTietGiayPhep.setFax(hoSoNgoaiTe1.getFax());
			chiTietGiayPhep.setTenCuaKhau(hoSoNgoaiTe1.getTenCuaKhau());
			chiTietGiayPhep.setDoiTacXuatNhapKhau(hoSoNgoaiTe1.getDoiTacXuatNhapKhau());
			chiTietGiayPhep.setKinhGui(hoSoNgoaiTe1.getTenChiNhanh());
			chiTietGiayPhep.setDiaDanh(hoSoNgoaiTe1.getTenChiNhanh());
			chiTietGiayPhep.setSoGiayPhep(hoSoNgoaiTe1.getMaHoSo());
			String thoiGian = "từ ngày ";
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
			thoiGian += dateFormat.format(hoSoNgoaiTe1.getXuatNhapKhauTuNgay());
			thoiGian += " đến ngày ";
			thoiGian += dateFormat.format(hoSoNgoaiTe1.getXuatNhapKhauDenNgay());
			chiTietGiayPhep.setThoiGian(thoiGian);
			chiTietGiayPhep.setGhiChu(hoSoNgoaiTe1.getGhiChu());
			chiTietGiayPhep.setHinhThucNhapKhau(hoSoNgoaiTe1.getHinhThucXNK() == 1);
			chiTietGiayPhep.setHinhThucXuatKhau(hoSoNgoaiTe1.getHinhThucXNK() == 2);
			List<TienTe1> tienTe1s = SBV01TienTe1BackendUtil.getByTienTes(getURL(GET_TIEN_TE_BY_ID_HO_SO), idHoSo);
			if (tienTe1s != null) {
				chiTietGiayPhep.setTienTes(tienTe1s);
			}

			Object data = chiTietGiayPhep;

			LOGGER.info("LAY THONG TIN HO SO: {}", chiTietGiayPhep);

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getChiTietHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}
	
	/**
	 * Lay danh sach tat ca loai tien te
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_LOAI_TIEN_TE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getLoaiTienTes(HttpServletRequest request) {

		try {

			Object data = SBV01LoaiTienTe1BackendUtil.getAllLoaiTienTe1s(getURL(GET_TIEN_TES));

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tat ca ho so
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_HO_SO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getHoSos(HttpServletRequest request, @RequestBody HoSoNgoaiTeSearchForm form) {

		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (!(principal instanceof UserDetails)) {

				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			UserCustom user = (UserCustom) principal;

			if (form.getPageIndex() < 1) form.setPageIndex(1);

			HoSoNgoaiTe1SearchItem item = new HoSoNgoaiTe1SearchItem();
			item.setMaSoThue(user.getUsername());
			
			if (StringUtils.hasText(form.getMaHoSo())) {
				item.setMaHoSo(form.getMaHoSo().trim());
			}
			if (!Objects.equals(-1, form.getHinhThucXNK())) {
				item.setHinhThucXNK(form.getHinhThucXNK());
			}
			if (StringUtils.hasText(form.getMaCuaKhau()) && !"-1".equals(form.getMaCuaKhau())) {
				item.setMaCuaKhau(form.getMaCuaKhau().trim());
			}
			if (form.getTrangThai() != null && form.getTrangThai() != -1) {
				item.setTrangThai(form.getTrangThai());
			}
			if (form.getFromNgayTao() != null) {
				Date date = form.getFromNgayTao();
				date.setHours(0);
				date.setMinutes(0);
				date.setSeconds(0);
				item.setFromNgayTao(date);
			}
			if (form.getToNgayTao() != null) {
				Date date = form.getToNgayTao();
				date.setHours(23);
				date.setMinutes(59);
				date.setSeconds(59);
				item.setToNgayTao(date);
			}
			item.setPageIndex(form.getPageIndex() - 1);
			item.setPageSize(15);
			
			item.setXoaHoSo(false);

			LOGGER.info("Tim kiem ho so theo dieu kien: {}", item);
			ResponseJson responseJson = SBV01HoSoNgoaiTeCustomUtil.search(getURL(SEARCH_HO_SO), item);

			return createResponseEntity(responseJson.getData(), responseJson.getTotal(), getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tat ca chi nhanh ngan hang
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_CHI_NHANH_NGAN_HANG, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getChiNhanhNganHangs(HttpServletRequest request) {

		try {

			Object data = SBV01ChiNhanhNganHang1BackendUtil.getAllChiNhanhNganHang1s(getURL(GET_CHI_NHANH_NGAN_HANGS));

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachChiNhanhNganHang]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tat ca chi nhanh ngan hang
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.SUA_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> editHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {

			HoSoNgoaiTeEditForm editForm = new HoSoNgoaiTeEditForm();
			editForm.setChiNhanhNganHang1s(getChiNhanhNganHang1s(request));
			editForm.setLoaiTienTe1s(getAllLoaiTienTes(request));
			editForm.setDanhMucTepDinhKems(tepDinhKem1BackendUtil.findByLoaiThuTuc("sbv01"));
			editForm.setTepDinhKems(SBV01TepDinhKemHoSo1BackendUtil.getByTepDinhKems(getURL(GET_TEP_DINH_KEM_BY_ID_HO_SO), idHoSo));
			if (idHoSo > 0) {
				HoSoNgoaiTe1 form = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), idHoSo);
				if (form == null || !isHasEditPermission(form)) {
					return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
				}
				ConvertToObjectUtil.convertTo(form, editForm);
				editForm.setMaLoaiTepDinhKem(getMaTepDinhKem(idHoSo));
				editForm.setTenTrangThai(getTenTrangThai(form.getTrangThai()));
				editForm.setCuaKhau1s(getCuaKhau1s(request, form.getMaChiNhanh()));
				editForm.setTienTes(getTienTes(form.getIdHoSo()));
				editForm.setXuatNhapKhauTuNgayDateFormat(form.getXuatNhapKhauTuNgay());
				editForm.setXuatNhapKhauDenNgayDateFormat(form.getXuatNhapKhauDenNgay());
				editForm.setTotalFileSize(SBV01TepDinhKemHoSo1BackendUtil.sizeOfFiles(getURL(SIZE_OF_FILE), idHoSo));
			}

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				UserCustom user = (UserCustom) principal;
				editForm.setMaSoThue(user.getUsername());
				editForm.setTenNganHang(user.getCompanyName());
				editForm.setDiaChi(user.getCompanyAddress());
				editForm.setDienThoai(user.getCompanyPhoneNumber());
				editForm.setFax(user.getCompanyFax());
				editForm.setNgayTao(new Date());
				editForm.setTenTrangThai(getTenTrangThai(SBV01Constants.Status.TAO_MOI));
			}

			return createResponseEntity(editForm, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[editHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tat ca chi nhanh ngan hang
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_GIAY_XAC_NHAN + "/{soGiayXN}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getSoGiayXacNhanTheo(HttpServletRequest request, @PathVariable("soGiayXN") String soGiayXN) {

		try {

			Object data = SBV01GiayPhep1BackendUtil.findBySoGiayPhep(getURL(GET_SO_GIAY_PHEP), soGiayXN);
			if (data != null) {
				return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[getSoGiayXacNhanTheo]", e);
			pushLog(e);
		}
		String error = getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()) + ". " + getMessage("sbv.01.giayphep.error.timkiemgx", null, request.getLocale()) + " " + soGiayXN + "!";
		return createResponseEntity(null, 0L, error, false, HttpStatus.OK);
	}

	private List<LoaiTienTe1> getAllLoaiTienTes(HttpServletRequest request) {
		List<LoaiTienTe1> list = new ArrayList<>();
		LoaiTienTe1 itme0 = new LoaiTienTe1();
		itme0.setMaLoaiTienTe("-1");
		itme0.setTenLoaiTienTe(getMessage(SBV01Constants.MessageKeys.MESSAGE_DEFAULT_KEY, null, request.getLocale()));
		list.add(itme0);
		List<LoaiTienTe1> loaiTienTe1s = SBV01LoaiTienTe1BackendUtil.getAllLoaiTienTe1s(getURL(GET_TIEN_TES));
		if (!ObjectUtils.isEmpty(loaiTienTe1s)) {
			loaiTienTe1s.stream().forEach(p-> p.setTenLoaiTienTe(p.getMaLoaiTienTe() + " - " + p.getTenLoaiTienTe()));
			list.addAll(loaiTienTe1s);
		}

		return list;
	}

	/**
	 * Lay danh sach tat ca cua khau
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> saveHoSo(HttpServletRequest request, @RequestBody HoSoNgoaiTeEditForm editForm) {

		try {

			editForm.setXuatNhapKhauTuNgay(editForm.getXuatNhapKhauTuNgayDateFormat());
			editForm.setXuatNhapKhauDenNgay(editForm.getXuatNhapKhauDenNgayDateFormat());
			if (!isValidHoSoNgoaiTe(editForm)) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			HoSoNgoaiTe1 hoSoNgoaiTe1 = saveThongTinHoSo(editForm, request);

			if (hoSoNgoaiTe1 == null) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			System.out.println(hoSoNgoaiTe1.toString());

			List<TienTeEditForm> tienTeEditForms = readJsonStringToList(editForm.getTienTeJsonString(), TienTeEditForm.class);
			tienTeEditForms.stream().forEach(System.out::println);

			editForm.setTienTes(tienTeEditForms);

			if (!editForm.getTienTes().isEmpty()) {
				saveTienTe(editForm, hoSoNgoaiTe1, request);
			}

			if (!editForm.getTepDinhKems().isEmpty()) {
				saveTepTin(request, editForm, hoSoNgoaiTe1.getIdHoSo());
			}
			
			editForm.setIdHoSo(hoSoNgoaiTe1.getIdHoSo());

			if (editForm.isGuiHoSo()) {
				boolean isSign = Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
				if (isSign) {
					return sendRequiredSign(request, hoSoNgoaiTe1, editForm);
				} else {
					ResponseEntity<Object> responseEntity = isValidGuiHoSo(hoSoNgoaiTe1);
					if (!Objects.isNull(responseEntity)) {
						return responseEntity;
					}
					return sendNotRequiredSign(request, hoSoNgoaiTe1, editForm);
				}
			}
			LOGGER.info("SAVE HO SO THANH CONG: {}", editForm);
			System.out.println("SBV01ApiController.saveHoSo() thanh cong");
			return createResponseEntity(editForm, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[saveHoSo]", e);
		}
		System.out.println("SBV01ApiController.saveHoSo() khong thanh cong");
		return createResponseEntity(editForm, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	private ResponseEntity<Object> sendNotRequiredSign(HttpServletRequest request, HoSoNgoaiTe1 hoSoNgoaiTe1, HoSoNgoaiTeEditForm editForm) {
		LOGGER.info("{}", "GUI HO SO KHONG YEU CAU KY SO");
		KySoModel kySoModel = new KySoModel();
		boolean guiHoSo = guiHoSo(hoSoNgoaiTe1, kySoModel);

		return saveHistorySendHoSo(request, hoSoNgoaiTe1, editForm, guiHoSo);

	}

	private ResponseEntity<Object> saveHistorySendHoSo(HttpServletRequest request, HoSoNgoaiTe1 hoSoNgoaiTe1, HoSoNgoaiTeEditForm editForm, boolean guiHoSo) {
		Object data = editForm;
		if (guiHoSo) {
			hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), hoSoNgoaiTe1.getIdHoSo());
			saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_GUI_HO_SO, hoSoNgoaiTe1.getMaHoSo() + ". " + getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()));
			if (data == null) data = hoSoNgoaiTe1;
			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
		} else {
			if (data == null) data = hoSoNgoaiTe1;
			saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_GUI_HO_SO, hoSoNgoaiTe1.getMaHoSo() + ". " + getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()));
			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
		}
	}

	private ResponseEntity<Object> sendRequiredSign(HttpServletRequest request, HoSoNgoaiTe1 hoSoNgoaiTe1, HoSoNgoaiTeEditForm editForm) {
		if (!StringUtils.hasText(editForm.getSerialNumber())) {
			return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()) + ". " + getMessage(SBV01Constants.MessageKeys.TOKEN_ERROR, null, request.getLocale()), false, HttpStatus.OK);
		}

		X509Certificate x509Cert = CertificateUtils.getX509Cert(editForm.getSerialNumber());
		if (!ObjectUtils.isEmpty(x509Cert)) {
			String sn = x509Cert.getSerialNumber().toString(16);
			editForm.setSerialNumber(sn);
			ResponseJson responseJson = getXmlContent(hoSoNgoaiTe1);
			if (responseJson.getData() != null) {
				editForm.setXmlEnvelop(responseJson.getData().toString());
			}
			
			if (responseJson.getMessage() != null) {
				
				editForm.setXmlContent(getFullXML(responseJson.getData().toString(), responseJson.getMessage()));
			}
			return createResponseEntity(editForm, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
		}

		return createResponseEntity(editForm, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}
	
	private String getFullXML(String envelop, String body) {
		String xml = body.replace("<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>", "");
		xml = xml.replace("<Signature></Signature>", "");
		xml = envelop.replace("<Body/>", xml);
		
		return xml;
	}

	private ResponseJson getXmlContent(HoSoNgoaiTe1 hoSoNgoaiTe1) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setGetXmlNotSend("true");
		sendMessage.setFiIdHoso(hoSoNgoaiTe1.getIdHoSo());
		String function = "";
		sendMessage.setFiIdHoso(hoSoNgoaiTe1.getIdHoSo());

		if (hoSoNgoaiTe1.getTrangThai() == TrangThaiHoSo.TAO_MOI_0) function = MessageFunction.FUN_01;
		else if (hoSoNgoaiTe1.getTrangThai() == TrangThaiHoSo.CHO_TIEP_NHAN_1) function = MessageFunction.FUN_02;
		else if (hoSoNgoaiTe1.getTrangThai() == TrangThaiHoSo.YEU_CAU_SUA_DOI_BO_SUNG_5) function = MessageFunction.FUN_03;

		sendMessage.setFunction(function);
		sendMessage.setType(MessageType.TYPE_11);
		sendMessage.setFunction(function);

		return callRestTemplate(getURL(SEND_ALL), sendMessage, HttpMethod.POST, null);
	}


	private void saveTepTin(HttpServletRequest request, HoSoNgoaiTeEditForm form, long idHoSo) {
		if (form.getTepDinhKems() == null) return;
		for (TepDinhKemHoSo1 item : form.getTepDinhKems()) {
			if (item.getIdHoSo() <= 0) {
				item.setIdHoSo(idHoSo);
				SBV01TepDinhKemHoSo1BackendUtil.createTepDinhKemHoSo1(getURL(CREATE_TEP_DINH_KEM), item);
			}

		}
	}

	
	private HoSoNgoaiTe1 saveThongTinHoSo(HoSoNgoaiTeEditForm form, HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserCustom user = (UserCustom) principal;
		HoSoNgoaiTe1 hoSoNgoaiTe1 = new HoSoNgoaiTe1();
		if (form.getIdHoSo() > 0) {
			hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), form.getIdHoSo());
		}

		hoSoNgoaiTe1.setMaSoThue(user.getUsername());
		ChiNhanhNganHang1 chiNhanhNganHang1 = SBV01ChiNhanhNganHang1BackendUtil.findByMaChiNhanh(getURL(FIND_BY_MA_CHI_NHANH), form.getMaChiNhanh());
		if (chiNhanhNganHang1 == null) return null;
		hoSoNgoaiTe1.setTenChiNhanh(chiNhanhNganHang1.getTenChiNhanh());
		hoSoNgoaiTe1.setMaChiNhanh(chiNhanhNganHang1.getMaChiNhanh());

		CuaKhau1 cuaKhau1 = SBV01CuaKhau1BackendUtil.findByMaCuaKhau(getURL(FIND_BY_MA_CUA_KHAU), form.getMaCuaKhau());
		if (cuaKhau1 == null) return null;

		hoSoNgoaiTe1.setTenCuaKhau(cuaKhau1.getTenCuaKhau());
		hoSoNgoaiTe1.setMaCuaKhau(cuaKhau1.getMaCuaKhau());

		hoSoNgoaiTe1.setHinhThucXNK(form.getHinhThucXNK());
		hoSoNgoaiTe1.setXuatNhapKhauTuNgay(form.getXuatNhapKhauTuNgay());
		hoSoNgoaiTe1.setXuatNhapKhauDenNgay(form.getXuatNhapKhauDenNgay());
		hoSoNgoaiTe1.setCapGiayPhepLanDau(form.isCapGiayPhepLanDau());
		hoSoNgoaiTe1.setSoGiayPhepDaCap(form.getSoGiayPhepDaCap());
		hoSoNgoaiTe1.setDoiTacXuatNhapKhau(form.getDoiTacXuatNhapKhau());
		hoSoNgoaiTe1.setCapGiayPhepLanDau(form.isCapGiayPhepLanDau());
		hoSoNgoaiTe1.setSoGiayPhepDaCap(form.getSoGiayPhepDaCap());
		// thong tin chung
		hoSoNgoaiTe1.setTenNganHang(user.getCompanyName());
		hoSoNgoaiTe1.setDiaChi(user.getCompanyAddress());
		hoSoNgoaiTe1.setDienThoai(user.getCompanyPhoneNumber());
		hoSoNgoaiTe1.setFax(user.getCompanyFax());
		hoSoNgoaiTe1.setGhiChu(form.getGhiChu());

		if (hoSoNgoaiTe1.getIdHoSo() > 0) {
			HoSoNgoaiTe1 old = hoSoNgoaiTe1;
			hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.updateHoSoNgoaiTe1(getURL(UPDATE_HO_SO), hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1);
			if (!old.toString().equals(hoSoNgoaiTe1.toString())) {
				saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_SUA_HO_SO, hoSoNgoaiTe1.getMaHoSo());
			}
		} else {
			hoSoNgoaiTe1.setTrangThai(0);
			hoSoNgoaiTe1.setNgayTao(new Date());
			hoSoNgoaiTe1.setMaHoSo("1");
			hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.createHoSoNgoaiTe1(getURL(CREATE_HO_SO), hoSoNgoaiTe1);
			if (hoSoNgoaiTe1 != null) {
				saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_TAO_MOI_HO_SO, hoSoNgoaiTe1.getMaHoSo());
			}

		}
		return hoSoNgoaiTe1;

	}

	private void saveTienTe(HoSoNgoaiTeEditForm form, HoSoNgoaiTe1 hoSoNgoaiTe1, HttpServletRequest request) {

		for (TienTeEditForm item : form.getTienTes()) {

			if (StringUtils.hasText(item.getSoLuongNgoaiTeBangSo()) && StringUtils.hasText(item.getSoLuongNgoaiTeBangChu()) && StringUtils.hasText(item.getMaLoaiTienTe()) && !"-1".equals(item.getMaLoaiTienTe())) {

				TienTe1 tienTe1 = new TienTe1();
				tienTe1.setIdTienTe(item.getIdTienTe());
				tienTe1.setIdHoSo(hoSoNgoaiTe1.getIdHoSo());
				tienTe1.setMaLoaiTienTe(item.getMaLoaiTienTe());
				tienTe1.setSoLuongNgoaiTeBangSo(Long.parseLong(item.getSoLuongNgoaiTeBangSo()));
				tienTe1.setSoLuongNgoaiTeBangChu(item.getSoLuongNgoaiTeBangChu());
				tienTe1.setGhiChu(item.getGhiChu());
				System.out.println("SBV01ApiController.saveTienTe()" + hoSoNgoaiTe1.getIdHoSo() + ": " + item.toString());
				if (tienTe1.getIdTienTe() > 0) {
					TienTe1 oldTienTe1 = SBV01TienTe1BackendUtil.getTienTe1(getURL(GET_TIEN_TE), tienTe1.getIdTienTe());
					tienTe1 = SBV01TienTe1BackendUtil.updateTienTe1(getURL(UPDATE_TIEN_TE), tienTe1.getIdTienTe(), tienTe1);
					if (!oldTienTe1.toString().equals(tienTe1.toString())) {
						saveLichSuHoSo(request, tienTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_SUA_HO_SO_SUA_TIEN_TE, buildTienTeMessage(request, oldTienTe1), buildTienTeMessage(request, tienTe1));
					}
				} else {
					tienTe1 = SBV01TienTe1BackendUtil.createTienTe1(getURL(CREATE_TIEN_TE), tienTe1);
					saveLichSuHoSo(request, tienTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_SUA_HO_SO_THEM_TIEN_TE, buildTienTeMessage(request, tienTe1));
				}

			}
		}
	}

	private String buildTienTeMessage(HttpServletRequest request, TienTe1 tienTe1) {
		StringBuilder builder = new StringBuilder();
		builder.append(getMessage("sbv.01.model.maLoaiTienTe", null, request.getLocale()));
		builder.append(" = ");
		builder.append(tienTe1.getMaLoaiTienTe());
		builder.append(" | ");

		builder.append(getMessage("sbv.01.model.soLuongNgoaiTeBangSo", null, request.getLocale()));
		builder.append(" = ");
		builder.append(tienTe1.getSoLuongNgoaiTeBangSo());
		builder.append(" | ");

		builder.append(getMessage("sbv.01.model.soLuongNgoaiTeBangChu", null, request.getLocale()));
		builder.append(" = ");
		builder.append(tienTe1.getSoLuongNgoaiTeBangChu());

		return builder.toString();
	}

	private boolean isValidHoSoNgoaiTe(HoSoNgoaiTeEditForm form) {

		boolean isValid = true;
		if (!StringUtils.hasText(form.getMaChiNhanh())) {
			return false;
		}
		if (!StringUtils.hasText(form.getMaCuaKhau())) {
			return false;
		}
		if (form.getHinhThucXNK() != SBV01Constants.HINH_THUC_NHAP_KHAU && form.getHinhThucXNK() != SBV01Constants.HINH_THUC_XUAT_KHAU) {
			return false;
		}
		if (form.getXuatNhapKhauTuNgay() == null || form.getXuatNhapKhauDenNgay() == null) {
			return false;
		}
		if (!form.isCapGiayPhepLanDau() && StringUtils.hasText(form.getSoGiayPhepDaCap())) {
			
			GiayPhep1 findGiayPhep1 = SBV01GiayPhep1BackendUtil.findBySoGiayPhep(getURL(GET_GIAY_PHEP_BY_SO_GIAY_PHEP), form.getSoGiayPhepDaCap());
			if (findGiayPhep1 == null) {
				LOGGER.info("------------So giay phep da cap khong ton tai: {}", form.getSoGiayPhepDaCap());
				return false;
			}
		}

		return isValid;
	}

	private ResponseEntity<Object> isValidGuiHoSo(HoSoNgoaiTe1 hoSoNgoaiTe1) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {

		List<TienTe1> tienTe1s = SBV01TienTe1BackendUtil.getByTienTes(getURL(GET_TIEN_TE_BY_ID_HO_SO), hoSoNgoaiTe1.getIdHoSo());
		if (tienTe1s == null || tienTe1s.isEmpty()) {
			return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin tiền tệ chưa !", false, HttpStatus.OK);
		}
		if (hoSoNgoaiTe1.isCapGiayPhepLanDau()) {
			List<TepDinhKemHoSo1> dinhKem1s = SBV01TepDinhKemHoSo1BackendUtil.getByTepDinhKems(getURL(GET_TEP_DINH_KEM_BY_ID_HO_SO), hoSoNgoaiTe1.getIdHoSo());
			if (dinhKem1s == null || dinhKem1s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin đính kèm chưa có!", false, HttpStatus.OK);
			}
			String loaiTep = "XNK_NGOAI_TE";
			List<TbsTepDinhKem1> tbsTepDinhKem1s = tepDinhKem1BackendUtil.findByLoaiThuTuc("sbv01");
			for (TbsTepDinhKem1 tep : tbsTepDinhKem1s) {
				if (Objects.equals(tep.getRequired(), Boolean.TRUE) && loaiTep.equals(tep.getLoaiTep())) {
					Optional<TepDinhKemHoSo1> find = dinhKem1s.stream().filter(p-> Objects.equals(p.getMaLoaiTepDinhKem(), String.valueOf(tep.getMaLoaiTep()))).findFirst();
					if (!find.isPresent()) {
						return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin đính kèm chưa có! " + tep.getTenTep(), false, HttpStatus.OK);
					}
				}
			}
		}
		return null;
	}


	
	private boolean guiHoSo(HoSoNgoaiTe1 hoSoNgoaiTe1, KySoModel kySoModel) {

		LOGGER.info("Noi dung truoc khi gui: {}", kySoModel);
		
		SendMessage sendMessage = setSendMessage11(hoSoNgoaiTe1, MessageType.TYPE_11);

//		if (kySoModel.isRequiredSign()) {
//			sendMessage.setSignedXml(kySoModel.toEnvelop());
//		}

		LOGGER.info("Noi dung gui di: {}", sendMessage);
		ResponseJson json = send(sendMessage);

		if (json != null) {
			return json.isSuccess();
		}
		return false;

	}

	private SendMessage setSendMessage11(HoSoNgoaiTe1 hoSoNgoaiTe1, String messageType) {

		SendMessage sendMessage = new SendMessage();
		sendMessage.setFiIdHoso(hoSoNgoaiTe1.getIdHoSo());
		String function = "";
		sendMessage.setFiIdHoso(hoSoNgoaiTe1.getIdHoSo());

		if (hoSoNgoaiTe1.getTrangThai() == TrangThaiHoSo.TAO_MOI_0) function = MessageFunction.FUN_01;
		else if (hoSoNgoaiTe1.getTrangThai() == TrangThaiHoSo.CHO_TIEP_NHAN_1) function = MessageFunction.FUN_02;
		else if (hoSoNgoaiTe1.getTrangThai() == TrangThaiHoSo.YEU_CAU_SUA_DOI_BO_SUNG_5) function = MessageFunction.FUN_03;

		sendMessage.setFunction(function);
		sendMessage.setType(messageType);
		sendMessage.setFunction(function);

		return sendMessage;
	}

	private ResponseJson send(SendMessage sendMessage) {
		String uri = getURL(SEND_ALL);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		uri = builder.build().encode().toString();
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(converters);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
		HttpEntity<Object> entity = new HttpEntity<>(sendMessage, headers);
		ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseJson.class);
		return response.getBody();
	}

	/**
	 * Lay danh sach tien te theo ho so
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.DELETE_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteHoSo(HttpServletRequest request, @PathVariable("id") long idHoSo) {

		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (!(principal instanceof UserDetails)) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			UserCustom user = (UserCustom) principal;
			HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), idHoSo);
			if (hoSoNgoaiTe1 != null) {
				boolean isOwner = hoSoNgoaiTe1.getMaSoThue().equals(user.getUsername());
				if (isOwner) {
					hoSoNgoaiTe1.setXoaHoSo(true);
					hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.updateHoSoNgoaiTe1(getURL(UPDATE_HO_SO), hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1);
					saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_XOA_HO_SO, hoSoNgoaiTe1.getMaHoSo() + ". " + getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()));
					return createResponseEntity(hoSoNgoaiTe1, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
				} else {
					saveLichSuHoSo(request, hoSoNgoaiTe1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_XOA_HO_SO, hoSoNgoaiTe1.getMaHoSo() + ". " + getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()));
				}
			}

		} catch (Exception e) {

			LOGGER.error("[deleteHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.DELETE_TEP_TIN_BY_ID + "/{idTepDK}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteTepDinhKemById(HttpServletRequest request, @PathVariable("idTepDK") long idTepDK) {

		try {
			if (idTepDK < 1) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			TepDinhKemHoSo1 tepDinhKemHoSo1 = SBV01TepDinhKemHoSo1BackendUtil.getTepDinhKemHoSo1(getURL(GET_TEP_DINH_KEM), idTepDK);
			Object data = SBV01TepDinhKemHoSo1BackendUtil.deleteTepDinhKemHoSo1(getURL(DELETE_TEP_DINH_KEM), idTepDK);
			if (data != null && tepDinhKemHoSo1 != null) {
				HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), tepDinhKemHoSo1.getIdHoSo());
				String tep = "[ ";
				tep += tepDinhKemHoSo1.getTenLoaiTepDinhKem();
				tep += " | " + tepDinhKemHoSo1.getTenTepDinhKem();
				tep += " ]";
				saveLichSuHoSo(request, tepDinhKemHoSo1.getIdHoSo(), hoSoNgoaiTe1.getTrangThai(), LICH_SU_SUA_HO_SO_XOA_TEP_TIN, tep, hoSoNgoaiTe1.getMaHoSo());
				return createResponseEntity(tepDinhKemHoSo1, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteTienTeByIdHoSo]", e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = SBV01Constants.ApiUrls.LAY_DANH_SACH_TEP_TIN_THEO_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTepDinhKemByIdHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {
		try {
			if (idHoSo < 1) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			Object data = SBV01TepDinhKemHoSo1BackendUtil.getByTepDinhKems(getURL(GET_TEP_DINH_KEM_BY_ID_HO_SO), idHoSo);

			return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getTepDinhKemByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * * Luu va lay ban tin xml
	 *
	 * @return
	 */
	@RequestMapping(value = { "/xml" }, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> getXmlHoSo(HttpServletRequest request, @RequestBody KySoModel kySoModel) {
		ResponseJson json = new ResponseJson();
		
		try {
			HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), kySoModel.getIdHoSo());
			if (hoSoNgoaiTe1 == null) {
				return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			KySoModel data = new KySoModel();
			ResponseJson responseJson = getXmlContent(hoSoNgoaiTe1);
			if (responseJson != null) {
				Object xmlKySo = responseJson.getData();
				if (xmlKySo != null) {
					data.setXmlContent(getFullXML(responseJson.getData().toString(), responseJson.getMessage()));
				}
				Object xmlEnvelop = responseJson.getMessage();
				if (xmlEnvelop != null) {
					data.setXmlEnvelop(xmlEnvelop.toString());
				}

				kySoModel.setRequiredSign(true);
				X509Certificate x509Cert = CertificateUtils.getX509Cert(kySoModel.getSerialNumber());
				if (!ObjectUtils.isEmpty(x509Cert)) {
					String sn = x509Cert.getSerialNumber().toString(16);
					data.setSerialNumber(sn);
					return createResponseEntity(data, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
				}
				
			}
			
		} catch (Exception ex) {

			LOGGER.error(ex.getMessage(), ex);
			json.setSuccess(false);
			json.setMessage(ex.getMessage());

			pushLog(ex);
		}
		return createResponseEntity(null, 0L, getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}


	private String getTenTrangThai(int value) {
		TrangThai1 trangThai1 = SBV01TrangThai1BackendUtil.findByGiaTri(getURL("com.nsw.sbv.p01.trangThai1.findByGiaTri"), value);
		return trangThai1.getTenTrangThai();
	}

	private List<TienTeEditForm> getTienTes(long idHoSo) {

		List<TienTeEditForm> list = new ArrayList<>();
		List<TienTe1> finds = SBV01TienTe1BackendUtil.getByTienTes(getURL("com.nsw.sbv.p01.tienTe1.getByTienTes"), idHoSo);
		if (finds != null && !finds.isEmpty()) {
			for (TienTe1 item : finds) {
				TienTeEditForm form = new TienTeEditForm();
				form.setIdTienTe(item.getIdTienTe());
				form.setSoLuongNgoaiTeBangChu(item.getSoLuongNgoaiTeBangChu());
				form.setSoLuongNgoaiTeBangSo(String.valueOf(item.getSoLuongNgoaiTeBangSo()));
				form.setMaLoaiTienTe(item.getMaLoaiTienTe());
				form.setGhiChu(item.getGhiChu());
				list.add(form);
			}
		}
		return list;
	}

	private List<ChiNhanhNganHang1> getChiNhanhNganHang1s(HttpServletRequest request) {

		List<ChiNhanhNganHang1> list = new ArrayList<>();
		ChiNhanhNganHang1 itme0 = new ChiNhanhNganHang1();
		itme0.setMaChiNhanh("-1");
		itme0.setTenChiNhanh(getMessage(SBV01Constants.MessageKeys.MESSAGE_DEFAULT_KEY, null, request.getLocale()));
		list.add(itme0);
		list.addAll(SBV01ChiNhanhNganHang1BackendUtil.getAllChiNhanhNganHang1s(getURL("com.nsw.sbv.p01.chiNhanhNganHang1.getAllChiNhanhNganHang1s")));

		return list;
	}

	private List<CuaKhau1> getCuaKhau1s(HttpServletRequest request, String maChiNhanh) {

		List<CuaKhau1> list = new ArrayList<>();
		CuaKhau1 itme0 = new CuaKhau1();
		itme0.setTenCuaKhau(getMessage(SBV01Constants.MessageKeys.MESSAGE_DEFAULT_KEY, null, request.getLocale()));
		itme0.setMaCuaKhau("-1");
		list.add(itme0);

		if (StringUtils.hasText(maChiNhanh)) {
			list.addAll(SBV01CuaKhau1BackendUtil.getByMaChiNhanhs(getURL("com.nsw.sbv.p01.cuaKhau1.getByMaChiNhanhs"), maChiNhanh));
		}

		return list;
	}

	private String getMaTepDinhKem(long idHoSo) {
		List<TepDinhKemHoSo1> data = SBV01TepDinhKemHoSo1BackendUtil.getByTepDinhKems(getURL("com.nsw.sbv.p01.tepDinhKemHoSo1.getByTepDinhKems"), idHoSo);
		if (data != null && !data.isEmpty()) {
			return data.get(0).getMaLoaiTepDinhKem();
		}
		return "1";
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

	private <T> List<T> readJsonStringToList(String jsonString, Class<T> clz) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clz);
			return mapper.readValue(jsonString, type);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	static class SignatureNode {
		String attr;
		String value;
	}

	protected String getMessage(String messageKey, Locale locale) {

		try {

			return messageSource.getMessage(messageKey, null, locale);

		} catch (Exception e) {
			LOGGER.error("[getMessage]", e);
		}

		return "";
	}
	
	@RequestMapping(value = "/downloadCaPlugin", method = RequestMethod.GET)
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
				try(InputStream inputStream = new BufferedInputStream(new FileInputStream(file))){
					FileCopyUtils.copy(inputStream, response.getOutputStream());
				}
				
				
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(),ex);
			}
		}
	}

}
