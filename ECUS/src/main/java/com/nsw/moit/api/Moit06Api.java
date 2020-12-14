package com.nsw.moit.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
import com.nsw.moit.p06.model.ContentChange6DTO;
import com.nsw.moit.p06.model.ContentChangeRoot6DTO;
import com.nsw.moit.p06.model.HoSo6EditForm;
import com.nsw.moit.p06.model.TbdDinhKem6;
import com.nsw.moit.p06.model.TbdGPCuaKhau6;
import com.nsw.moit.p06.model.TbdGPHangHoa6;
import com.nsw.moit.p06.model.TbdGiayPhep6;
import com.nsw.moit.p06.model.TbdGiayPhep6DTO;
import com.nsw.moit.p06.model.TbdHoSo6;
import com.nsw.moit.p06.model.TbdHoSo6SearchDTO;
import com.nsw.moit.p06.model.TbdHoSo6SearchItem;
import com.nsw.moit.p06.model.TbdTTPT6;
import com.nsw.moit.p06.model.TbdGPTTPT6DTO;
import com.nsw.moit.p06.model.TbsPhuongTien6;
import com.nsw.moit.p06.model.TbsTrangThai6;
import com.nsw.moit.p06.util.Moit06BackendConstants;
import com.nsw.moit.p06.util.Moit06Constants;
import com.nsw.moit.p06.util.Moit06TbdCuaKhau6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdDinhKem6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdGPCuaKhau6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdGPHangHoa6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdGiayPhep6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdHangHoa6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdHoSo6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdTTPT6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsCuaKhau6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsPhuongTien6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsProvince6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsTepDinhKem6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsTienChat6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsTrangThai6BackendUtil;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;

@RestController
@RequestMapping(value = Moit06Constants.ApiUrls.ROOT)
@PropertySource("classpath:moit_api.properties")
public class Moit06Api {

	public static final Logger LOGGER = LoggerFactory.getLogger(Moit06Api.class);

	@Autowired
	protected Environment environment;

	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	protected MessageSource messageSource;

	private static final String CLASS_NAME = "Moit06Api";
	
	@Autowired
	private Moit06TbsTepDinhKem6BackendUtil moit06TbsTepDinhKem6BackendUtil;


	/**
	 * Lay danh sach tat ca ho so
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_HO_SO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getHoSos(HttpServletRequest request, @RequestBody TbdHoSo6SearchDTO form) {

		
		try {
			
			TbdHoSo6SearchItem dHoSoDTO6 = new TbdHoSo6SearchItem();

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
			ResponseJson data = Moit06TbdHoSo6BackendUtil.page(getURL(Moit06BackendConstants.TbdHoSo6Constants.SEARCH), dHoSoDTO6);
			
			return createResponseEntity(data.getData(), data.getTotal(), getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {

			LOGGER.error("[layDanhSachHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	private Date formatDate(Date date, int hour, int minute, int second) {
		if (date == null) return date;
		date.setHours(hour);
		date.setMinutes(minute);
		date.setSeconds(second);
		return date;
	}
	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_THONG_TIN_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getChiTietHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {

			TbdHoSo6 hoSoNgoaiTe1 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), idHoSo);

			if (hoSoNgoaiTe1 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			LOGGER.info("LAY THONG TIN HO SO: {}", hoSoNgoaiTe1);

			return createResponseEntity(hoSoNgoaiTe1, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getChiTietHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_TRANG_THAI, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTrangThais(HttpServletRequest request) {
		try {
			Object data = Moit06TbsTrangThai6BackendUtil.findByIdTrangThaiIsNotNullOrderByIdTrangThai(getURL(Moit06BackendConstants.TbsTrangThai6Constants.FIND_BY_ID_TRANG_THAI_IS_NOT_NULL_ORDER_BY_ID_TRANG_THAI));

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachTrangThai]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.SUA_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> editHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {

			HoSo6EditForm editForm = new HoSo6EditForm();
			List<TbsTrangThai6> tbsTrangThai6s = Moit06TbsTrangThai6BackendUtil.findByIdTrangThaiIsNotNullOrderByIdTrangThai(getURL(Moit06BackendConstants.TbsTrangThai6Constants.FIND_BY_ID_TRANG_THAI_IS_NOT_NULL_ORDER_BY_ID_TRANG_THAI));
			editForm.setProvinces(Moit06TbsProvince6BackendUtil.findAll(getURL(Moit06BackendConstants.TbsProvince6Constants.FIND_ALL)));
			editForm.setDanhMucTepDinhKems(moit06TbsTepDinhKem6BackendUtil.findByLoaiThuTuc("p06"));
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
				Optional<TbsTrangThai6> tOptional = tbsTrangThai6s.stream().filter(p -> p.getIdTrangThai() == 0).findFirst();
				if (tOptional.isPresent()) {
					editForm.setTrangThaiHoSo(tOptional.get().getTenTrangThai());
				}
			} else {
				TbdHoSo6 hoSo = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), idHoSo);
				BeanUtils.copyProperties(hoSo, editForm);
				Optional<TbsTrangThai6> tOptional = tbsTrangThai6s.stream().filter(p -> p.getIdTrangThai() == hoSo.getTrangThai().intValue()).findFirst();
				if (tOptional.isPresent()) {
					editForm.setTrangThaiHoSo(tOptional.get().getTenTrangThai());
				}
				editForm.setCuaKhaus(Moit06TbdCuaKhau6BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), idHoSo, 1));
				editForm.setPhuongTiens(Moit06TbdTTPT6BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit06BackendConstants.TbdTTPT6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), idHoSo, 1));
				editForm.setTepDinhKems(Moit06TbdDinhKem6BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit06BackendConstants.TbdDinhKem6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), idHoSo, 1));
				editForm.setHangHoas(Moit06TbdHangHoa6BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit06BackendConstants.TbdHangHoa6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), idHoSo, 1));
				editForm.setTotalFileSize(Moit06TbdDinhKem6BackendUtil.sizeOfFiles(getURL(Moit06BackendConstants.TbdDinhKem6Constants.SIZE_OF_FILE), idHoSo));
			}
			editForm.setSign(isSign());
			editForm.setTienChats(Moit06TbsTienChat6BackendUtil.findByIdTienChatIsNotNullOrderByTenTienChat(getURL(Moit06BackendConstants.TbsTienChat6Constants.FIND_BY_ID_TIEN_CHAT_IS_NOT_NULL_ORDER_BY_TEN_TIEN_CHAT)));

			return createResponseEntity(editForm, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[editHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}
	
	private boolean isSign() {
		return Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_CUA_KHAU, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getCuaKhaus(HttpServletRequest request) {

		try {
			Object data = Moit06TbsCuaKhau6BackendUtil.findByIdCuaKhauIsNotNullOrderByTenCuaKhauAsc(getURL(Moit06BackendConstants.TbsCuaKhau6Constants.FIND_BY_ID_CUA_KHAU_IS_NOT_NULL_ORDER_BY_TEN_CUA_KHAU_ASC));

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_PHUONG_TIEN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getPhuongTiens(HttpServletRequest request) {

		try {
			Object data = Moit06TbsPhuongTien6BackendUtil.findByIdPhuongTienIsNotNullOrderByTenPhuongTienAsc(getURL(Moit06BackendConstants.TbsPhuongTien6Constants.FIND_BY_ID_PHUONG_TIEN_IS_NOT_NULL_ORDER_BY_TEN_PHUONG_TIEN_ASC));

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getPhuongTiens]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_TIEN_CHAT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTienChats(HttpServletRequest request) {

		try {
			Object data = Moit06TbsTienChat6BackendUtil.findByIdTienChatIsNotNullOrderByTenTienChat(getURL(Moit06BackendConstants.TbsTienChat6Constants.FIND_BY_ID_TIEN_CHAT_IS_NOT_NULL_ORDER_BY_TEN_TIEN_CHAT));

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getTienChats]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}
	
	

	
	


	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_TEP_TIN_THEO_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTepDinhKemByIdHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			if (idHoSo < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}
			Object data = Moit06TbdDinhKem6BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit06BackendConstants.TbdDinhKem6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), idHoSo, 1);

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getTepDinhKemByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}

	

	
	

	
	

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_THONG_TIN_GIAY_PHEP + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getGiayPhep(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			TbdGiayPhep6 giayPhep6 = Moit06TbdGiayPhep6BackendUtil.findByIdHoSo(getURL(Moit06BackendConstants.TbdGiayPhep6Constants.FIND_BY_ID_HO_SO), idHoSo);
			
			TbdHoSo6 hoSo6 = Moit06TbdHoSo6BackendUtil.findByIdHoSo(getURL(Moit06BackendConstants.TbdHoSo6Constants.FIND_BY_ID_HO_SO), idHoSo);
			List<TbdGPHangHoa6> hangHoa6 = Moit06TbdGPHangHoa6BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit06BackendConstants.TbdGPHangHoa6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), idHoSo, 1);
			List<TbdGPCuaKhau6> cuaKhau6 = Moit06TbdGPCuaKhau6BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit06BackendConstants.TbdGPCuaKhau6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), idHoSo, 1);
			if (giayPhep6 == null || hoSo6 == null || hangHoa6.isEmpty() || cuaKhau6.isEmpty()) {
				debugLog("Khong tim thay giay phep theo id ho so:  {}, giay phe[: {}, hang hoa: {}, cua khau: {} ", idHoSo, giayPhep6, hangHoa6, cuaKhau6);
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
			}

			TbdGiayPhep6DTO chiTietGiayPhep = new TbdGiayPhep6DTO();
			chiTietGiayPhep.setTenDoanhNghiep(hoSo6.getTenDoanhNghiep());
			chiTietGiayPhep.setIdGiayPhep(giayPhep6.getIdGiayPhep());
			chiTietGiayPhep.setCoQuanCap(giayPhep6.getCoQuanCap());
			chiTietGiayPhep.setMaSoGP(giayPhep6.getMaSoGP());
			chiTietGiayPhep.setNgayKy(giayPhep6.getNgayKy());
			chiTietGiayPhep.setLoaiHinh(giayPhep6.getLoaiHinh());
			chiTietGiayPhep.setLoaiGiayPhep(giayPhep6.getLoaiGiayPhep());
			chiTietGiayPhep.setNguoiKy(giayPhep6.getNguoiKy());
			chiTietGiayPhep.setHangHoas(hangHoa6);
			chiTietGiayPhep.setHamLuong(hangHoa6.get(0).getHamLuong());
			chiTietGiayPhep.setSoLuong(hangHoa6.get(0).getSoLuong());
			chiTietGiayPhep.setMucDich(hoSo6.getMucDich());
			chiTietGiayPhep.setNgayHetHan(giayPhep6.getNgayHetHan());
			chiTietGiayPhep.setNgayNop(hoSo6.getNgayNop());
			chiTietGiayPhep.setCuaKhaus(cuaKhau6);
			chiTietGiayPhep.setSoGiayPhepTCTN(hoSo6.getSoGiayPhepTCTN());
			chiTietGiayPhep.setMaHoSo(hoSo6.getMaHoSo());
			chiTietGiayPhep.setPhuongTiens(toThongTinDTOs(idHoSo));

			Object data = chiTietGiayPhep;
			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getGiayPhep]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
	}
	


	private List<TbdGPTTPT6DTO> toThongTinDTOs(Long idHoSo) {
		List<TbdGPTTPT6DTO> ls = new ArrayList<>();
		List<TbdTTPT6> tbdTTPT6s = Moit06TbdTTPT6BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit06BackendConstants.TbdTTPT6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), idHoSo, 1);
		if (tbdTTPT6s != null) {
			List<TbsPhuongTien6> tbsPhuongTien6s = Moit06TbsPhuongTien6BackendUtil.findByIdPhuongTienIsNotNullOrderByTenPhuongTienAsc(getURL(Moit06BackendConstants.TbsPhuongTien6Constants.FIND_BY_ID_PHUONG_TIEN_IS_NOT_NULL_ORDER_BY_TEN_PHUONG_TIEN_ASC));
			tbdTTPT6s.stream().forEach(p -> {
				Optional<TbsPhuongTien6> optional = tbsPhuongTien6s.stream().filter(tbs -> tbs.getLoaiPhuongTien() == p.getLoaiPhuongTien()).findFirst();
				if (optional.isPresent()) {
					TbdGPTTPT6DTO tbdTTPT6DTO = new TbdGPTTPT6DTO();
					BeanUtils.copyProperties(p, tbdTTPT6DTO);
					tbdTTPT6DTO.setTenPhuongTien(optional.get().getTenPhuongTien());
					tbdTTPT6DTO.setTenLoaiPhuongTien(optional.get().getTenLoaiPhuongTien());
					debugLog("toThongTinDTOs: {}", tbdTTPT6DTO);
					ls.add(tbdTTPT6DTO);
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
		return environment.getRequiredProperty(Moit06BackendConstants.ROOT_URL) + environment.getRequiredProperty(uriKey);
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
	
	protected String getMessage(String messageKey, Object...objects) {

		try {
			StringBuilder builder = new StringBuilder();
			builder.append( messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale()));
			if (objects != null) {
				for (Object object : objects) builder.append(" " + object);
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

	private static final int BUFFER_SIZE = 4096;
	FileServiceHelper fileHelper = new FileServiceHelper();

	private static final String BACKEND_URL_DOWNLOAD_KEY = "com.nsw.moit.p06.download";
	private static final String BACKEND_URL_KEY = "moit.06.backend";


	


	@RequestMapping(value = "/download/{idTepDinhKem}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("idTepDinhKem") long idTepDinhKem) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			try {

				TbdDinhKem6 tepDinhKemHoSo1 = Moit06TbdDinhKem6BackendUtil.getTbdDinhKem6(getURL(Moit06BackendConstants.TbdDinhKem6Constants.GET_ONE), idTepDinhKem);

				if (tepDinhKemHoSo1 != null) {
					String loaiTep = tepDinhKemHoSo1.getLoaiTep();
					if (!StringUtils.hasText(loaiTep)) loaiTep = FilenameUtils.getExtension(tepDinhKemHoSo1.getTenTepDinhKem());
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

	private ContentChangeRoot6DTO getValueChange(String message, Object old, Object newObj) {
		ContentChangeRoot6DTO contentChangeRoot6DTO = new ContentChangeRoot6DTO();
		contentChangeRoot6DTO.setName(message);
		StringBuilder builder = new StringBuilder();
		try {
			Field[] fields = old.getClass().getDeclaredFields();
			Field[] newFields = newObj.getClass().getDeclaredFields();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (int i = 0; i < fields.length; i++) {
				Field a1 = fields[i];
				a1.setAccessible(true);
				Field a2 = newFields[i];
				a2.setAccessible(true);
				Object aField = a1.get(old);
				Object bField = a2.get(newObj);
				String value1 = "";
				String value2 = "";
				if (aField != null) {
					if (a1.getType().equals(Date.class)) {
						value1 = dateFormat.format((Date) aField);
					} else value1 = String.valueOf(aField);
				} 
				if (bField != null) {
					if (a2.getType().equals(Date.class)) {
						value2 = dateFormat.format((Date) bField);
					} else value2 = String.valueOf(bField);
				} 
				
				boolean khac = (!value1.isEmpty() || !value2.isEmpty());
				boolean khac2 = (!value1.isEmpty() && !value2.isEmpty() && !value1.equals(value2));
				if (khac && khac2) {
					builder.append(fields[i].getName() + ": [" + value1 + " -> " + value2 + "]");
					ContentChange6DTO change6dto = new ContentChange6DTO();
					change6dto.setName(a1.getName());
					change6dto.setFromValue(value1);
					change6dto.setToValue(value2);
					contentChangeRoot6DTO.getContentChange6DTOs().add(change6dto);
				}
				
			}

		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
		return contentChangeRoot6DTO;
	}
	
	private String toXml(ContentChangeRoot6DTO changeRoot6DTO) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ContentChangeRoot6DTO.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(changeRoot6DTO, stringWriter);
			return stringWriter.toString();
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
		return "";
	}
	
	private ContentChangeRoot6DTO xmlToObject(String xmlString) {
		try {
			if (!xmlString.startsWith("<?xml")) return null;
			JAXBContext jaxbContext = JAXBContext.newInstance(ContentChangeRoot6DTO.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return (ContentChangeRoot6DTO)unmarshaller.unmarshal(new StringReader(xmlString));
		} catch (Exception ex) {
			logError(ex);
		}
		return null;
	}
	
	private void logError(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
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
	protected static final int LICH_SU_SUA_HO_SO_THEM_TEP_TIN = 6;
	protected static final int LICH_SU_SUA_HO_SO_XOA_TEP_TIN = 7;
	protected static final int LICH_SU_SUA_HO_SO_THEM_TIEN_TE = 8;
	protected static final int LICH_SU_SUA_HO_SO_SUA_TIEN_TE = 9;
	protected static final int LICH_SU_SUA_HO_SO_XOA_TIEN_TE = 10;

	protected static final String IS_SIGN_KEY = "nsw.moit.06.sign";
	protected static final String SEND_ALL = "com.nsw.moit.p06.sendAll";

}
