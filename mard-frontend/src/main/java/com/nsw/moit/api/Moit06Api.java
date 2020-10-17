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
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nsw.moit.p07.util.Moit07Constants;
import com.nsw.moit.p07.util.Moit07TbdDinhKem7BackendUtil;
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
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.ResponseUpload;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.moit.common.CertificateUtils;
import com.nsw.moit.common.ResponseMessage;
import com.nsw.moit.common.SendUtil;
import com.nsw.moit.p06.model.ContentChange6DTO;
import com.nsw.moit.p06.model.ContentChangeRoot6DTO;
import com.nsw.moit.p06.model.HoSo6EditForm;
import com.nsw.moit.p06.model.HuyHoSo6Form;
import com.nsw.moit.p06.model.KetQuaXuLy6Model;
import com.nsw.moit.p06.model.Send6Message;
import com.nsw.moit.p06.model.TbdCuaKhau6;
import com.nsw.moit.p06.model.TbdCuaKhau6Search;
import com.nsw.moit.p06.model.TbdDinhKem6;
import com.nsw.moit.p06.model.TbdGPCuaKhau6;
import com.nsw.moit.p06.model.TbdGPHangHoa6;
import com.nsw.moit.p06.model.TbdGiayPhep6;
import com.nsw.moit.p06.model.TbdGiayPhep6DTO;
import com.nsw.moit.p06.model.TbdHangHoa6;
import com.nsw.moit.p06.model.TbdHoSo6;
import com.nsw.moit.p06.model.TbdHoSo6SearchDTO;
import com.nsw.moit.p06.model.TbdHoSo6SearchItem;
import com.nsw.moit.p06.model.TbdKQXL6;
import com.nsw.moit.p06.model.TbdKQXL6DTO;
import com.nsw.moit.p06.model.TbdTTPT6;
import com.nsw.moit.p06.model.TbdGPTTPT6DTO;
import com.nsw.moit.p06.model.TbsCuaKhau6;
import com.nsw.moit.p06.model.TbsPhuongTien6;
import com.nsw.moit.p06.model.TbsProvince6;
import com.nsw.moit.p06.model.TbsTepDinhKem6;
import com.nsw.moit.p06.model.TbsTrangThai6;
import com.nsw.moit.p06.util.Moit06BackendConstants;
import com.nsw.moit.p06.util.Moit06Constants;
import com.nsw.moit.p06.util.Moit06Constants.MessageFunction;
import com.nsw.moit.p06.util.Moit06TbdCuaKhau6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdDinhKem6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdGPCuaKhau6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdGPHangHoa6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdGiayPhep6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdHangHoa6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdHoSo6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdKQXL6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbdTTPT6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsCuaKhau6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsPhuongTien6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsProvince6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsTepDinhKem6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsTienChat6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsTrangThai6BackendUtil;
import com.nsw.moit.p06.util.Moit06ValidUtil;
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
	
	@Autowired
	private Moit06TbsTepDinhKem6BackendUtil moit06TbsTepDinhKem6BackendUtil;

	private static final String CLASS_NAME = "Moit06Api";

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

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal != null && (principal instanceof UserDetails)) {
				UserCustom user = (UserCustom) principal;
				dHoSoDTO6.setMaSoThue(user.getUsername());
			}

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

			return createResponseEntity(data.getData(), data.getTotal(), getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {

			LOGGER.error("[layDanhSachHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@SuppressWarnings({ "unused", "deprecation" })
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
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			LOGGER.info("LAY THONG TIN HO SO: {}", hoSoNgoaiTe1);

			return createResponseEntity(hoSoNgoaiTe1, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getChiTietHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_TRANG_THAI, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTrangThais(HttpServletRequest request) {
		try {
			Object data = Moit06TbsTrangThai6BackendUtil.findByIdTrangThaiIsNotNullOrderByIdTrangThai(getURL(Moit06BackendConstants.TbsTrangThai6Constants.FIND_BY_ID_TRANG_THAI_IS_NOT_NULL_ORDER_BY_ID_TRANG_THAI));

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachTrangThai]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
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

			return createResponseEntity(editForm, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[editHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	
	
	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_CUA_KHAU, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getCuaKhaus(HttpServletRequest request) {

		try {
			Object data = Moit06TbsCuaKhau6BackendUtil.findByIdCuaKhauIsNotNullOrderByTenCuaKhauAsc(getURL(Moit06BackendConstants.TbsCuaKhau6Constants.FIND_BY_ID_CUA_KHAU_IS_NOT_NULL_ORDER_BY_TEN_CUA_KHAU_ASC));

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/findByNameAndCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> findByNameAndCode(HttpServletRequest request, @Valid @RequestBody TbdCuaKhau6Search form) {	
		
		try {
			TbdCuaKhau6Search tbdCuaKhau = new TbdCuaKhau6Search();
			tbdCuaKhau.setMaCuaKhau(form.getMaCuaKhau());		
			tbdCuaKhau.setTenCuaKhau(form.getTenCuaKhau());
			tbdCuaKhau.setPageIndex(form.getPageIndex() - 1);
			//tbdCuaKhau.setPageIndex(form.getPageIndex());
			tbdCuaKhau.setPageSize(10);
			
			ResponseJson data = (ResponseJson) Moit06TbsCuaKhau6BackendUtil.findByNameAndCode(getURL(Moit06BackendConstants.TbsCuaKhau6Constants.SEARCH_CUAKHAU), tbdCuaKhau);

			return createResponseEntity(data.getData(), data.getTotal(), getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {

			LOGGER.error("[layDanhSachCK]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}
	
	

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_PHUONG_TIEN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getPhuongTiens(HttpServletRequest request) {

		try {
			Object data = Moit06TbsPhuongTien6BackendUtil.findByIdPhuongTienIsNotNullOrderByTenPhuongTienAsc(getURL(Moit06BackendConstants.TbsPhuongTien6Constants.FIND_BY_ID_PHUONG_TIEN_IS_NOT_NULL_ORDER_BY_TEN_PHUONG_TIEN_ASC));

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getPhuongTiens]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_TIEN_CHAT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTienChats(HttpServletRequest request) {

		try {
			Object data = Moit06TbsTienChat6BackendUtil.findByIdTienChatIsNotNullOrderByTenTienChat(getURL(Moit06BackendConstants.TbsTienChat6Constants.FIND_BY_ID_TIEN_CHAT_IS_NOT_NULL_ORDER_BY_TEN_TIEN_CHAT));

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getTienChats]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> saveHoSo(HttpServletRequest request, @RequestBody HoSo6EditForm editForm) {

		try {
			TbdHoSo6 tbdHoSo6 = new TbdHoSo6();
			TbdHoSo6 findOld = new TbdHoSo6();
			if (editForm.getIdHoSo() != null && editForm.getIdHoSo() > 0) {
				tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), editForm.getIdHoSo());
				BeanUtils.copyProperties(tbdHoSo6, findOld);
			} else {
				tbdHoSo6.setMaSoThue(editForm.getMaSoThue());
				tbdHoSo6.setTenDoanhNghiep(editForm.getTenDoanhNghiep());
				tbdHoSo6.setDiaChiDoanhNghiep(editForm.getDiaChiDoanhNghiep());
				tbdHoSo6.setDienThoai(editForm.getDienThoai());
				tbdHoSo6.setSoGiayChungNhanDKKD(editForm.getSoGiayChungNhanDKKD());
				tbdHoSo6.setNgayTao(new Date());
				tbdHoSo6.setNguoiTao(editForm.getMaSoThue());
				tbdHoSo6.setTrangThai(0);
				tbdHoSo6.setHoatDong(1);
				tbdHoSo6.setIsTemp(0);
				tbdHoSo6.setSend(false);
			}

			if (Objects.isNull(tbdHoSo6)) {
				return createResponseEntity(editForm, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			LOGGER.info("CHINH SUA HO SO: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {}", tbdHoSo6.getIdHoSo(), tbdHoSo6.getMaHoSo(), tbdHoSo6.getIsTemp(), tbdHoSo6.getTrangThai());

			tbdHoSo6.setFax(editForm.getFax());
			tbdHoSo6.setEmail(editForm.getEmail());
			tbdHoSo6.setLoaiHinh(editForm.getLoaiHinh());
			tbdHoSo6.setNgayCapGiayChungNhan(editForm.getNgayCapGiayChungNhan());
			tbdHoSo6.setDiaChiSanXuat(editForm.getDiaChiSanXuat());
			tbdHoSo6.setSoGiayPhepTCTN(editForm.getSoGiayPhepTCTN());
			tbdHoSo6.setNgayCapGiayPhepTCTN(editForm.getNgayCapGiayPhepTCTN());
			tbdHoSo6.setLoaiGiayPhep(editForm.getLoaiGiayPhep());
			tbdHoSo6.setMucDich(editForm.getMucDich());
			tbdHoSo6.setLyDoSua(editForm.getLyDoSua());
			tbdHoSo6.setNoiCapGiayChungNhanDKKD(editForm.getNoiCapGiayChungNhanDKKD());
			tbdHoSo6.setTenNguoiDaiDien(editForm.getTenNguoiDaiDien());
			tbdHoSo6.setDaiDienChucVu(editForm.getDaiDienChucVu());
			tbdHoSo6.setDaiDienNamSinh(editForm.getDaiDienNamSinh());
			tbdHoSo6.setDaiDienDiaChi(editForm.getDaiDienDiaChi());
			tbdHoSo6.setDaiDienGioiTinh(editForm.getDaiDienGioiTinh());
			TbsProvince6 tbsProvince6 = Moit06TbsProvince6BackendUtil.geTbsProvince6(getURL(Moit06BackendConstants.TbsProvince6Constants.FIND_BY_CODE), editForm.getMaTinhTP());
			if (tbsProvince6 != null) {
				tbdHoSo6.setMaTinhTP(tbsProvince6.getProvinceCode());
				tbdHoSo6.setTinhTP(tbsProvince6.getProvinceName());
			} else {
				return createResponseEntity(editForm, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			

			if (!isHasEdit(tbdHoSo6) || !Moit06ValidUtil.validThongTinChung(tbdHoSo6)) {
				return createResponseEntity(editForm, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			if (tbdHoSo6.getIdHoSo() != null && tbdHoSo6.getIdHoSo() > 0) {

				tbdHoSo6 = Moit06TbdHoSo6BackendUtil.updateTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.UPDATE), tbdHoSo6.getIdHoSo(), tbdHoSo6);
				saveLichSuHoSo(tbdHoSo6, getMessage(LICH_SUA_HO_SO_KEY, tbdHoSo6.getMaHoSo()));
			} else {
				tbdHoSo6.setIsTemp(0);
				tbdHoSo6 = Moit06TbdHoSo6BackendUtil.createTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.CREATE), tbdHoSo6);
				ContentChangeRoot6DTO contentChangeRoot6DTO = getValueChange(getMessage("moit.06.lichsu.taohoso", tbdHoSo6.getMaHoSo()), findOld, tbdHoSo6);
				saveLichSuHoSo(tbdHoSo6, toXml(contentChangeRoot6DTO));
			}

			Moit06TbdHoSo6BackendUtil.remove(environment.getRequiredProperty(Moit06BackendConstants.ROOT_URL), tbdHoSo6.getIdHoSo());
			editForm.setIdHoSo(tbdHoSo6.getIdHoSo());
			saveCuaKhau(tbdHoSo6, editForm);
			savePhuongTien(tbdHoSo6, editForm);
			saveHangHoa(tbdHoSo6, editForm);
			saveTepTin(tbdHoSo6, editForm);

			editForm.setIdHoSo(tbdHoSo6.getIdHoSo());

			return createResponseEntity(editForm, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("[saveHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(editForm, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	private void saveCuaKhau(TbdHoSo6 tbdHoSo6, HoSo6EditForm editForm) {

		if (editForm.getCuaKhaus() != null) {
			editForm.getCuaKhaus().stream().filter(p -> !Objects.equals("-1", p.getMaCuaKhau())).forEach(p -> {
				TbdCuaKhau6 tbdCuaKhau6 = new TbdCuaKhau6();
				tbdCuaKhau6.setIdHoSo(tbdHoSo6.getIdHoSo());
				tbdCuaKhau6.setMaCuaKhau(p.getMaCuaKhau());
				tbdCuaKhau6.setTenCuaKhau(p.getTenCuaKhau());
				tbdCuaKhau6.setIdHoSo(tbdHoSo6.getIdHoSo());
				tbdCuaKhau6.setIdCuaKhau(p.getIdCuaKhau());
				tbdCuaKhau6.setHoatDong(1);
				tbdCuaKhau6 = Moit06TbdCuaKhau6BackendUtil.createTbdCuaKhau6(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.CREATE), tbdCuaKhau6);
				LOGGER.info("saveCuaKhau: CREATE | {}", tbdCuaKhau6);
			});
		}
	}

	private void savePhuongTien(TbdHoSo6 tbdHoSo6, HoSo6EditForm editForm) {

		if (editForm.getPhuongTiens() != null) {
			editForm.getPhuongTiens().stream().filter(p -> p.getLoaiPhuongTien() != -1).forEach(p -> {
				TbdTTPT6 tbdTTPT6 = new TbdTTPT6();
				tbdTTPT6.setIdHoSo(tbdHoSo6.getIdHoSo());
				tbdTTPT6.setLoaiPhuongTien(p.getLoaiPhuongTien());
				tbdTTPT6.setIdPhuongTien(p.getIdPhuongTien());
				tbdTTPT6.setHoatDong(1);
				tbdTTPT6 = Moit06TbdTTPT6BackendUtil.createTbdTTPT6(getURL(Moit06BackendConstants.TbdTTPT6Constants.CREATE), tbdTTPT6);
				LOGGER.info("savePhuongTien: CREATE  | {}", tbdTTPT6);
			});
		}
	}

	private void saveHangHoa(TbdHoSo6 tbdHoSo6, HoSo6EditForm editForm) {

		if (editForm.getHangHoas() != null) {
			editForm.getHangHoas().stream().filter(p-> p.getTrangThai() != -1 && !"-1".equals(p.getDonViTinh())).forEach(p -> {
				
				if (Moit06ValidUtil.validHangHoa(p)) {
					if (p.getIdHangHoa() == null || p.getIdHangHoa() == 0) {
						p.setIdHoSo(tbdHoSo6.getIdHoSo());
						p.setHoatDong(1);
						p.setIdHangHoa(null);
						p = Moit06TbdHangHoa6BackendUtil.createTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.CREATE), p);
						LOGGER.info("saveHangHoa: CREATE | {}", p);
					} else if (Objects.equals(p.getIdHoSo(), tbdHoSo6.getIdHoSo())) {
						p.setHoatDong(1);
						TbdHangHoa6 find = Moit06TbdHangHoa6BackendUtil.getTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.GET_ONE), p.getIdHangHoa());
						p = Moit06TbdHangHoa6BackendUtil.updateTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.UPDATE), p.getIdHangHoa(), p);
						LOGGER.info("saveHangHoa: UPDATE  | {}", p);
						saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.suahanghoa", p.getTenHangHoa()));
					}
				}
			});
		}
	}

	private void saveTepTin(TbdHoSo6 tbdHoSo6, HoSo6EditForm editForm) {

		if (editForm.getTepDinhKems() != null) {
			editForm.getTepDinhKems().stream().forEach(p -> {
				if (Moit06ValidUtil.validDinhKem(p) && (p.getIdHoSo() == null || p.getIdHoSo() == 0)) {
					p.setIdHoSo(tbdHoSo6.getIdHoSo());
					p.setHoatDong(1);
					p.setTenTep(p.getTenTepDinhKem());
					p.setLoaiTep(FilenameUtils.getExtension(p.getTenTepDinhKem()));
					p.setIdHoSo(tbdHoSo6.getIdHoSo());
					p = Moit06TbdDinhKem6BackendUtil.createTbdDinhKem6(getURL(Moit06BackendConstants.TbdDinhKem6Constants.CREATE), p);
					LOGGER.info("saveTepTin: CREATE | {}", p);

				}
			});
		}
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.DELETE_CUA_KHAU_THEO_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteCuaKhauByIdCuaKhau(HttpServletRequest request, @PathVariable("id") long id) {

		try {
			TbdCuaKhau6 tbdCuaKhau6 = Moit06TbdCuaKhau6BackendUtil.getTbdCuaKhau6(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.GET_ONE), id);
			if (id < 1 || tbdCuaKhau6 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), tbdCuaKhau6.getIdHoSo());

			tbdCuaKhau6.setHoatDong(0);
			boolean data = Moit06TbdCuaKhau6BackendUtil.deleteTbdCuaKhau6(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.DELETE), tbdCuaKhau6.getIdCuaKhau());
			if (data) {
				saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.xoacuakhau", tbdCuaKhau6.getTenCuaKhau()));

				return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteCuaKhauByIdCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.DELETE_PHUONG_TIEN_THEO_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deletePhuongTienByIdPhuongTien(HttpServletRequest request, @PathVariable("id") long id) {

		try {

			TbdTTPT6 tbdTTPT6 = Moit06TbdTTPT6BackendUtil.getTbdTTPT6(getURL(Moit06BackendConstants.TbdTTPT6Constants.GET_ONE), id);
			if (id < 1 || tbdTTPT6 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), tbdTTPT6.getIdHoSo());
			boolean data = Moit06TbdTTPT6BackendUtil.deleteTbdTTPT6(getURL(Moit06BackendConstants.TbdTTPT6Constants.DELETE), tbdTTPT6.getIdPhuongTien());
			if (data) {
				saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.xoaphuongtien", id));
				return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteCuaKhauByIdCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.ADD_HANG_HOA + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addHangHoa(HttpServletRequest request, @PathVariable("id") long id, @RequestBody TbdHangHoa6 tbdHangHoa6) {

		try {
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), id);
			if (tbdHoSo6 == null) {
				return createResponseEntity(tbdHangHoa6, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

			if (Moit06ValidUtil.validHangHoa(tbdHangHoa6)) {
				tbdHangHoa6.setHoatDong(1);
				tbdHangHoa6.setIdHoSo(id);

				tbdHangHoa6 = Moit06TbdHangHoa6BackendUtil.createTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.CREATE), tbdHangHoa6);
				if (tbdHangHoa6 != null) {
					saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.themhanghoa", tbdHangHoa6.getTenHangHoa()));

					return createResponseEntity(tbdHangHoa6, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
				}

			}

		} catch (Exception e) {

			LOGGER.error("[addHangHoa]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.ADD_CUA_KHAU + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addCuaKhau(HttpServletRequest request, @PathVariable("id") long id, @RequestBody TbdCuaKhau6 form) {

		System.out.println("Moit06Api.addCuaKhau()" + form.toString());
		try {
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), id);

			TbsCuaKhau6 tbsCuaKhau = Moit06TbsCuaKhau6BackendUtil.findByIdCuaKhau(getURL(Moit06BackendConstants.TbsCuaKhau6Constants.FIND_BY_ID_CUA_KHAU), form.getMaCuaKhau().trim());
			if (tbsCuaKhau != null) {
				TbdCuaKhau6 tbdCuaKhau6 = new TbdCuaKhau6();
				tbdCuaKhau6.setIdHoSo(id);
				tbdCuaKhau6.setMaCuaKhau(tbsCuaKhau.getMaCuaKhau());
				tbdCuaKhau6.setTenCuaKhau(tbsCuaKhau.getTenCuaKhau());
				tbdCuaKhau6.setHoatDong(1);
				List<TbdCuaKhau6> tbdCuaKhau6s = Moit06TbdCuaKhau6BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), id, 1);
				if (tbdCuaKhau6s != null) {
					Optional<TbdCuaKhau6> optional = tbdCuaKhau6s.stream().filter(p -> p.getMaCuaKhau().equals(form.getMaCuaKhau())).findFirst();
					if (!optional.isPresent()) {
						tbdCuaKhau6 = Moit06TbdCuaKhau6BackendUtil.createTbdCuaKhau6(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.CREATE), tbdCuaKhau6);
						if (tbdCuaKhau6 != null) {

							saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.themcuakhau", tbdCuaKhau6.getTenCuaKhau()));
							return createResponseEntity(tbdCuaKhau6, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
						}
					}
				}

			}

		} catch (Exception e) {

			LOGGER.error("[addCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.ADD_PHUONG_TIEN + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addPhuongTIen(HttpServletRequest request, @PathVariable("id") long id, @RequestBody TbdTTPT6 form) {

		try {
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), id);
			if (tbdHoSo6 == null) {
				return createResponseEntity(form, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}
			TbsPhuongTien6 tbsPhuongTien = Moit06TbsPhuongTien6BackendUtil.findByIdPhuongTien(getURL(Moit06BackendConstants.TbsPhuongTien6Constants.FIND_BY_ID_PHUONG_TIEN), form.getLoaiPhuongTien().longValue());
			if (tbsPhuongTien != null) {
				TbdTTPT6 tbdTTPT6 = new TbdTTPT6();
				tbdTTPT6.setIdHoSo(id);
				tbdTTPT6.setLoaiPhuongTien(tbsPhuongTien.getIdPhuongTien().intValue());
				tbdTTPT6.setHoatDong(1);
				List<TbdTTPT6> tbdTTPT6s = Moit06TbdTTPT6BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit06BackendConstants.TbdTTPT6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), id, 1);
				if (tbdTTPT6s != null) {
					Optional<TbdTTPT6> optional = tbdTTPT6s.stream().filter(p -> p.getLoaiPhuongTien() == form.getLoaiPhuongTien()).findFirst();
					if (!optional.isPresent()) {
						tbdTTPT6 = Moit06TbdTTPT6BackendUtil.createTbdTTPT6(getURL(Moit06BackendConstants.TbdTTPT6Constants.CREATE), tbdTTPT6);
						if (tbdTTPT6 != null) {

							saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.themphuongtien", tbsPhuongTien.getTenPhuongTien()));
							return createResponseEntity(tbdTTPT6, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
						}
					}
				}
			}

		} catch (Exception e) {

			LOGGER.error("[tbdTTPT6]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_TEP_TIN_THEO_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTepDinhKemByIdHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			if (idHoSo < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			Object data = Moit06TbdDinhKem6BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit06BackendConstants.TbdDinhKem6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), idHoSo, 1);

			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getTepDinhKemByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.DELETE_TEP_TIN_BY_ID + "/{idTepDK}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteTepDinhKemById(HttpServletRequest request, @PathVariable("idTepDK") long idTepDK) {

		try {
			if (idTepDK < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			TbdDinhKem6 tepDinhKemHoSo1 = Moit06TbdDinhKem6BackendUtil.getTbdDinhKem6(getURL(Moit06BackendConstants.TbdDinhKem6Constants.GET_ONE), idTepDK);

			if (tepDinhKemHoSo1 != null) {

				TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), tepDinhKemHoSo1.getIdHoSo());

				tepDinhKemHoSo1.setHoatDong(0);
				Moit06TbdDinhKem6BackendUtil.deleteTbdDinhKem6(getURL(Moit06BackendConstants.TbdDinhKem6Constants.DELETE), idTepDK);

				saveLichSuHoSo(tbdHoSo6,getMessage("moit.06.lichsu.xoateptin", tepDinhKemHoSo1.getTenTep()));
				return createResponseEntity(tepDinhKemHoSo1, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteTienTeByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/xoaTepDKByIdHoSo/{idTepDK}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteAllTepDinhKemById(HttpServletRequest request, @PathVariable("idTepDK") long idTepDK) {

		boolean isSuccess = false;
		try {
			if (idTepDK < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			isSuccess = Moit07TbdDinhKem7BackendUtil.deleteTbdDinhKem7ByIdHoSo(getHost() + "/moit/06/tepTin/deleteByIdHoSo", idTepDK);
		} catch (Exception e) {

			LOGGER.error("[deleteTienTeByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), isSuccess, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/capNhatLoaiGiayPhep/{idHoSo}/{loaiGP}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> capNhatLoaiGiayPhep(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo, @PathVariable("loaiGP") int loaiGP) {

		boolean isSuccess = false;
		try {
			if (idHoSo < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), idHoSo);
			if (tbdHoSo6 != null && (loaiGP == 1 || loaiGP == 2)) {
				tbdHoSo6.setLoaiGiayPhep(loaiGP);
				Moit06TbdHoSo6BackendUtil.updateTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.UPDATE), idHoSo, tbdHoSo6);
				isSuccess = true;
			}

		} catch (Exception e) {

			LOGGER.error("[capNhatLoaiGiayPhep]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), isSuccess, HttpStatus.OK);
	}


	private boolean isHasEdit(TbdHoSo6 tbdHoSo6) {
		if (tbdHoSo6 == null) return true;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal != null && (principal instanceof UserCustom)) {
			UserCustom user = (UserCustom) principal;
			if (user.getUsername() != null && user.getUsername().equals(tbdHoSo6.getMaSoThue())) return true;
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.DELETE_HANG_HOA + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteHangHoaByIdHangHoa(HttpServletRequest request, @PathVariable("id") long id) {

		try {
			TbdHangHoa6 tbdHangHoa6 = Moit06TbdHangHoa6BackendUtil.getTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.GET_ONE), id);
			if (id < 1 || tbdHangHoa6 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), tbdHangHoa6.getIdHoSo());

			boolean data = Moit06TbdHangHoa6BackendUtil.deleteTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.DELETE), id);

			if (data) {
				saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.xoahanghoa", tbdHangHoa6.getTenHangHoa()));
				return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteHangHoaByIdHangHoa]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.UPDATE_HANG_HOA, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> updateHangHoa(HttpServletRequest request, @RequestBody TbdHangHoa6 tbdHangHoa6) {

		debugLog("updateHangHoaBy: {}", tbdHangHoa6);
		try {

			if (tbdHangHoa6.getIdHangHoa() < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			tbdHangHoa6.setHoatDong(1);
			TbdHangHoa6 old = Moit06TbdHangHoa6BackendUtil.getTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.GET_ONE), tbdHangHoa6.getIdHangHoa());
			TbdHangHoa6 data = Moit06TbdHangHoa6BackendUtil.updateTbdHangHoa6(getURL(Moit06BackendConstants.TbdHangHoa6Constants.UPDATE), tbdHangHoa6.getIdHangHoa(), tbdHangHoa6);

			if (data != null) {
				TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), tbdHangHoa6.getIdHoSo());

				saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.suahanghoa", tbdHangHoa6.getTenHangHoa()));
				return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[updateHangHoa]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.DELETE_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteHoSo(HttpServletRequest request, @PathVariable("id") long idHoSo) {

		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), idHoSo);
			if (!(principal instanceof UserDetails)
					|| tbdHoSo6 == null
					|| tbdHoSo6.getTrangThai() != 0) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			UserCustom user = (UserCustom) principal;
			
			if (tbdHoSo6 != null) {
				boolean isOwner = tbdHoSo6.getMaSoThue().equals(user.getUsername());
				if (isOwner) {
					tbdHoSo6.setHoatDong(0);
					tbdHoSo6 = Moit06TbdHoSo6BackendUtil.updateTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.UPDATE), idHoSo, tbdHoSo6);
					saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.xoahoso", tbdHoSo6.getMaHoSo()));
					return createResponseEntity(tbdHoSo6, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
				}
			}

		} catch (Exception e) {

			LOGGER.error("[deleteHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.GUI_HO_SO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> sendHoSo(HttpServletRequest request, @RequestBody HoSo6EditForm hoSoEditForm) {
			System.out.println("CuaKhau------------------------------------"+hoSoEditForm.getCuaKhaus().size());
		try {
			
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), hoSoEditForm.getIdHoSo());
			if (tbdHoSo6 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			//validate
			if (!validSend(tbdHoSo6, Objects.equals(hoSoEditForm.getIsChinhSua(), Boolean.TRUE))) {
				return createResponseEntity(null, 0L, "Thông tin chung hoặc thông tin hàng hóa chưa đầy đủ!", false, HttpStatus.OK);
			}
			
			List<TbdCuaKhau6> pTbdCuaKhau6s = Moit06TbdCuaKhau6BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit06BackendConstants.TbdCuaKhau6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), tbdHoSo6.getIdHoSo(), 1);
			if (pTbdCuaKhau6s == null || pTbdCuaKhau6s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin cửa khẩu chưa có!", false, HttpStatus.OK);
			}
			
			List<TbdTTPT6> pTbdTTPT6s = Moit06TbdTTPT6BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit06BackendConstants.TbdTTPT6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), tbdHoSo6.getIdHoSo(), 1);
			if (pTbdTTPT6s == null || pTbdTTPT6s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin phương tiện chưa có!", false, HttpStatus.OK);
			}
			List<TbdHangHoa6> hangHoa6s = Moit06TbdHangHoa6BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit06BackendConstants.TbdHangHoa6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), tbdHoSo6.getIdHoSo(), 1);
			if (hangHoa6s == null || hangHoa6s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin hàng hóa chưa có!", false, HttpStatus.OK);
			}
			
			List<TbdDinhKem6> dinhKem6s = Moit06TbdDinhKem6BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit06BackendConstants.TbdDinhKem6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), tbdHoSo6.getIdHoSo(), 1);
			if (dinhKem6s == null || dinhKem6s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin đính kèm chưa có!", false, HttpStatus.OK);
			}
			final String loaiTep = tbdHoSo6.getLoaiGiayPhep().intValue() == 1 ? "XUAT_KHAU" : "NHAP_KHAU";

			List<TbsTepDinhKem6> tbsTepDinhKem6s = moit06TbsTepDinhKem6BackendUtil.findByLoaiThuTuc("p06");
			tbsTepDinhKem6s = tbsTepDinhKem6s.stream().filter(p-> Objects.equals(p.getLoaiTep(),loaiTep)).collect(Collectors.toList());

			for (TbsTepDinhKem6 tep : tbsTepDinhKem6s) {
				if (Objects.equals(tep.getRequired(), Boolean.TRUE) && loaiTep.equals(tep.getLoaiTep())) {
					Optional<TbdDinhKem6> find = dinhKem6s.stream().filter(p-> p.getMaLoaiTep().intValue() == tep.getMaLoaiTep().intValue()).findFirst();
					if (!find.isPresent()) {
						return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin đính kèm chưa có! " + tep.getTenTep(), false, HttpStatus.OK);
					}
				}
			}
			
			debugLog("THONG TIN GUI HO SO: ID = {}, MA HO SO = {}, VERSION = {}, TRANG THAI = {}", tbdHoSo6.getIdHoSo(), tbdHoSo6.getMaHoSo(), tbdHoSo6.getIsTemp(), tbdHoSo6.getTrangThai());
			
			Send6Message sendMessage = getSendMessage(tbdHoSo6.getIdHoSo(), tbdHoSo6.getTrangThai());
			if (isSign()) {
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String xmlEnvelop = hoSoEditForm.getXmlEnvelop();
				UserCustom user = (UserCustom) principal;
				ResponseMessage responseMessage = SendUtil.callWs(environment.getRequiredProperty("moit.06.CAService"), user.getUsername(), xmlEnvelop);
				if (!responseMessage.isSuccess()) {
					return createResponseEntity(hoSoEditForm, 0L, responseMessage.getMessage(), false, HttpStatus.OK);
				}
				sendMessage.setSignedXml(xmlEnvelop);
			}
			ResponseJson json = send(sendMessage);
			debugLog("KET QUA GUI HO SO: {}", json);
			if (json != null) {
				if (json.isSuccess()) {
					tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), hoSoEditForm.getIdHoSo());
					tbdHoSo6.setSend(true);
					tbdHoSo6 = Moit06TbdHoSo6BackendUtil.updateTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.UPDATE), hoSoEditForm.getIdHoSo(), tbdHoSo6);
					saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.yeucauguihoso"));
					return createResponseEntity(tbdHoSo6, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
				}
			}
			updateToVersion(hoSoEditForm.getIdHoSo());
		} catch (Exception e) {

			updateToVersion(hoSoEditForm.getIdHoSo());
			LOGGER.error("[sendHoSo]", e);
		}

		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	private Send6Message getSendMessage(long idHoSo, int trangThai) {
		Send6Message sendMessage = new Send6Message();
		sendMessage.setFiIdHoso(idHoSo);

		MessageFunction messageFunction = MessageFunction.FUNTION_YC_SUA;

		if (trangThai == Moit06Constants.Status.TAO_MOI) {
			messageFunction = MessageFunction.FUNTION_GUI_MOI;
		} else if (trangThai == Moit06Constants.Status.CHO_TIEP_NHAN) {
			messageFunction = MessageFunction.FUNTION_GUI_SUA;
		} else if (trangThai == Moit06Constants.Status.YEU_CAU_BO_SUNG) {
			messageFunction = MessageFunction.FUNTION_GUI_SDBS;
		} else if (trangThai == Moit06Constants.Status.DA_SDBS) {
			messageFunction = MessageFunction.FUNTION_GUI_SUA;
		}
		sendMessage.setFunction(messageFunction.getFunctionName());
		sendMessage.setType(messageFunction.getFunctionType());

		debugLog("sendHoSo: getFunctionName = {}, getFunctionType = {}, sendMessage = {}", messageFunction.getFunctionName(), messageFunction.getFunctionType(), sendMessage);
		return sendMessage;
	}
	
	private ResponseJson getXmlContent(TbdHoSo6 tbdHoSo6) {
		Send6Message send6Message = getSendMessage(tbdHoSo6.getIdHoSo(), tbdHoSo6.getTrangThai());
		send6Message.setGetXmlNotSend("true");
		return callRestTemplate(getURL(SEND_ALL), send6Message, HttpMethod.POST, null);
	}

	private void updateToVersion(long idHoSo) {
		TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), idHoSo);
		if (tbdHoSo6 == null || tbdHoSo6.getIsTemp() == null) return;
		tbdHoSo6.setIsTemp(tbdHoSo6.getIsTemp() - 1);
		tbdHoSo6.setSend(false);
		if (tbdHoSo6.getIsTemp() < 0) tbdHoSo6.setIsTemp(0);
		tbdHoSo6 = Moit06TbdHoSo6BackendUtil.updateTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.UPDATE), idHoSo, tbdHoSo6);
		LOGGER.info("Revert version: ID = {}, TRANG THAI = {}, VERSION = {}", tbdHoSo6.getIdHoSo(), tbdHoSo6.getTrangThai(), tbdHoSo6.getIsTemp());

	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.HUY_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> huyHoSo(HttpServletRequest request, @PathVariable("id") long idHoSo, @RequestBody HuyHoSo6Form form) {

		try {
			TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), idHoSo);

			List<Integer> status = Arrays.asList(1, 4, 5, 7, 9, 10, 15, 16);
			if (tbdHoSo6 == null 
					|| !StringUtils.hasText(form.getNoiDung())
					|| !status.contains(tbdHoSo6.getTrangThai())) {

				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			MessageFunction messageFunction = MessageFunction.FUNTION_YC_RUT_CHUA_DUYET;
			if (tbdHoSo6.getTrangThai() != Moit06Constants.Status.CHO_TIEP_NHAN 
					&& tbdHoSo6.getTrangThai() != Moit06Constants.Status.YEU_CAU_BO_SUNG
					&& tbdHoSo6.getTrangThai() != Moit06Constants.Status.DA_SDBS) {
				messageFunction = MessageFunction.FUNTION_YC_RUT;
			}
			Send6Message sendMessage = new Send6Message();
			sendMessage.setLyDo(form.getNoiDung());
			sendMessage.setFunction(messageFunction.getFunctionName());
			sendMessage.setType(messageFunction.getFunctionType());
			sendMessage.setFiIdHoso(idHoSo);
			debugLog("huyHoSo: {}", sendMessage);
			LOGGER.info("XIN RUT HO SO VERSION: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo6.getIdHoSo(), tbdHoSo6.getMaHoSo(), tbdHoSo6.getIsTemp(), tbdHoSo6.getTrangThai(), tbdHoSo6.getHoatDong());
			ResponseJson json = send(sendMessage);
			if (json != null) {
				boolean a = json.isSuccess();
				if (a) {
					tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), idHoSo);
					saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.yeucauruthoso"));
					return createResponseEntity(tbdHoSo6, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
				}
			}

		} catch (Exception e) {

			LOGGER.error("[huyHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	private boolean isSign() {
		return Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
	}

	private ResponseJson send(Send6Message sendMessage) {
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

	protected void saveLichSuHoSo(TbdHoSo6 tbdHoSo6, String message) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserCustom user = (UserCustom) principal;
		TbdKQXL6 ketQuaXuLyHoSo1 = new TbdKQXL6();
		ketQuaXuLyHoSo1.setIdHoSo(tbdHoSo6.getIdHoSo());
		ketQuaXuLyHoSo1.setTrangThai(tbdHoSo6.getTrangThai());
		ketQuaXuLyHoSo1.setNguoiXuLy(user.getUsername());
		ketQuaXuLyHoSo1.setDonVi(user.getCompanyName());
		ketQuaXuLyHoSo1.setNgayXyLy(new Date());
		ketQuaXuLyHoSo1.setNoiDung(message);
		ketQuaXuLyHoSo1.setMaHoSo(tbdHoSo6.getMaHoSo());
		Moit06TbdKQXL6BackendUtil.createTbdKQXL6(getURL(Moit06BackendConstants.TbdKQXL6Constants.CREATE), ketQuaXuLyHoSo1);
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_DANH_SACH_LICH_SU + "/{maHoSo}/{pageIndex}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getLichSuHoSos(HttpServletRequest request, @PathVariable("maHoSo") String maHoSo, @PathVariable("pageIndex") int pageIndex) {

		try {
			Object data = null;
			ResponseJson kqs = Moit06TbdKQXL6BackendUtil.searchKetQuaXuLys(getURL(Moit06BackendConstants.TbdKQXL6Constants.SEARCH_KET_QUA_XU_LYS), maHoSo, pageIndex - 1, 10);
			Long total = 0L;
			if (kqs != null) {
				total = kqs.getTotal();
				List<TbdKQXL6DTO> ketQuaXuLyHoSoModels = new ArrayList<>();
				List<KetQuaXuLy6Model> ketQuaXuLy6Models = (List<KetQuaXuLy6Model>) kqs.getData();

				if (ketQuaXuLy6Models != null) {
					for (int k = 0; k < ketQuaXuLy6Models.size(); k++) {
						KetQuaXuLy6Model item = ketQuaXuLy6Models.get(k);
						TbdKQXL6DTO tbdLichSu6DTO = new TbdKQXL6DTO();
						BeanUtils.copyProperties(item, tbdLichSu6DTO);
						ContentChangeRoot6DTO contentChangeRoot6DTO = xmlToObject(item.getNoiDung());
						if (contentChangeRoot6DTO != null) {
							tbdLichSu6DTO.setContentChanges(contentChangeRoot6DTO.getContentChange6DTOs());
							tbdLichSu6DTO.setNoiDung(contentChangeRoot6DTO.getName());
						}
						tbdLichSu6DTO.setTenTrangThai(item.getTenTrangThai());

						ketQuaXuLyHoSoModels.add(tbdLichSu6DTO);
					}
				}
				data = ketQuaXuLyHoSoModels;
			}
			return createResponseEntity(data, total, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {

			LOGGER.error("[layLichSuHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit06Constants.ApiUrls.LAY_THONG_TIN_GIAY_PHEP + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getGiayPhep(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			TbdGiayPhep6 giayPhep6 = Moit06TbdGiayPhep6BackendUtil.findByIdHoSo(getURL(Moit06BackendConstants.TbdGiayPhep6Constants.FIND_BY_ID_HO_SO), idHoSo);

			TbdHoSo6 hoSo6 = Moit06TbdHoSo6BackendUtil.findByIdHoSo(getURL(Moit06BackendConstants.TbdHoSo6Constants.FIND_BY_ID_HO_SO), idHoSo);
			List<TbdGPHangHoa6> hangHoa6 = Moit06TbdGPHangHoa6BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit06BackendConstants.TbdGPHangHoa6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), idHoSo, 1);
			List<TbdGPCuaKhau6> cuaKhau6 = Moit06TbdGPCuaKhau6BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit06BackendConstants.TbdGPCuaKhau6Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), idHoSo, 1);
			List<Integer> status = Arrays.asList(15, 16);
			if (giayPhep6 == null || hoSo6 == null || hangHoa6.isEmpty() || cuaKhau6.isEmpty()
					|| !status.contains(hoSo6.getTrangThai())) {
				debugLog("Khong tim thay giay phep theo id ho so:  {}, giay phe[: {}, hang hoa: {}, cua khau: {} ", idHoSo, giayPhep6, hangHoa6, cuaKhau6);
				return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
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
			return createResponseEntity(data, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getGiayPhep]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/checkCertificateStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> checkCertificateStatus() {

		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserCustom user = (UserCustom) principal;
			String signatureXml = "";
			ResponseMessage responseMessage = SendUtil.callWs(environment.getRequiredProperty("moit.06.CAService"), user.getUsername(), signatureXml);
			return createResponseEntity(responseMessage.getStatus(), 0L, getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), responseMessage.isSuccess(), HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getGiayPhep]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
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

	protected String getHost() {
		return environment.getRequiredProperty(Moit06BackendConstants.ROOT_URL);
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

	private static final int BUFFER_SIZE = 4096;
	FileServiceHelper fileHelper = new FileServiceHelper();

	private static final String BACKEND_URL_UPLOAD_KEY = "com.nsw.moit.p06.upload";
	private static final String BACKEND_URL_DOWNLOAD_KEY = "com.nsw.moit.p06.download";
	private static final String BACKEND_URL_KEY = "moit.06.backend";
	private static final String UNDEFINED_INPUT = "undefined,";

	private static final String LICH_SUA_HO_SO_KEY = "moit.06.lichsu.suahoso";

	@RequestMapping(value = "/upload/{idHoSo}/{maLoaiTepTin}", method = RequestMethod.POST)
	public @ResponseBody ResponseJson uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("mcode") String mcode, @RequestParam("pcode") String pcode, HttpServletRequest request, @PathVariable("idHoSo") long idHoSo, @PathVariable("maLoaiTepTin") int maLoaiTepTin) {
		if (StringUtils.hasText(mcode) && mcode.startsWith(UNDEFINED_INPUT)) {
			mcode = mcode.replace(UNDEFINED_INPUT, "");
		}
		if (StringUtils.hasText(pcode) && pcode.startsWith(UNDEFINED_INPUT)) {
			pcode = pcode.replace(UNDEFINED_INPUT, "");
		}
		debugLog("Upload file: {}, size: {}", file.getOriginalFilename(), file.getSize());

		ResponseJson json = new ResponseJson();
		json.setSuccess(false);
		json.setMessage(getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()));

		RabbitMQInfo mqInfo = getRabbitMQ();
		try {
			if (file.isEmpty() || !StringUtils.hasText(mcode) || !StringUtils.hasText(pcode)) {
				return json;
			}

			String tempFolder = environment.getProperty(AppConstant.Download.TemSaveFolder);
			String uri = getFullUri(environment.getRequiredProperty(BACKEND_URL_UPLOAD_KEY));
			ResponseJson responseJson = fileHelper.uploadFile(uri, file, tempFolder, mcode, pcode, mqInfo);
			if (!isUploadSuccess(responseJson)) return json;
			json = responseJson;
			ResponseUpload responseUpload = readObject(json, ResponseUpload.class);
			if (responseUpload != null) {
				String uuId = FilenameUtils.getBaseName(responseUpload.getFileCode());

				TbdDinhKem6 tepDinhKemHoSo1 = new TbdDinhKem6();
				tepDinhKemHoSo1.setIdTepTin(0L);
				tepDinhKemHoSo1.setGuID(uuId);
				tepDinhKemHoSo1.setDuongDanFile(responseUpload.getFilePath());
				tepDinhKemHoSo1.setIdHoSo(idHoSo);
				tepDinhKemHoSo1.setTenTepDinhKem(responseUpload.getFileName());
				tepDinhKemHoSo1.setTenTep(responseUpload.getFileName());
				tepDinhKemHoSo1.setMaLoaiTep(maLoaiTepTin);
				tepDinhKemHoSo1.setLoaiTep(FilenameUtils.getExtension(responseUpload.getFileCode()));
				tepDinhKemHoSo1.setHoatDong(1);
				tepDinhKemHoSo1.setSize(file.getSize());

				debugLog("Create tep dinh kem: {}", tepDinhKemHoSo1);
				if (idHoSo > 0) {
					TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), idHoSo);
					tepDinhKemHoSo1 = Moit06TbdDinhKem6BackendUtil.createTbdDinhKem6(getURL(Moit06BackendConstants.TbdDinhKem6Constants.CREATE), tepDinhKemHoSo1);
					saveLichSuHoSo(tbdHoSo6, getMessage("moit.06.lichsu.themteptin", tepDinhKemHoSo1.getTenTep()));
				}

				json.setData(tepDinhKemHoSo1);
				json.setMessage(getMessage(Moit06Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()));
				json.setSuccess(true);

			}

		} catch (Exception ex) {
			String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

			LOGGER.error(ex.getMessage(), ex);
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
		}

		return json;
	}

	private boolean isUploadSuccess(ResponseJson responseJson) {
		boolean isTrue = true;
		if (responseJson == null || !responseJson.isSuccess() || responseJson.getData() == null) return false;

		return isTrue;
	}

	@RequestMapping(value = "/download/{idTepDinhKem}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("idTepDinhKem") long idTepDinhKem) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {

				TbdDinhKem6 tepDinhKemHoSo1 = Moit06TbdDinhKem6BackendUtil.getTbdDinhKem6(getURL(Moit06BackendConstants.TbdDinhKem6Constants.GET_ONE), idTepDinhKem);

				if (tepDinhKemHoSo1 != null) {
					String loaiTep = tepDinhKemHoSo1.getLoaiTep();
					if (!StringUtils.hasText(loaiTep)) loaiTep = FilenameUtils.getExtension(tepDinhKemHoSo1.getTenTepDinhKem());
					String fileCode = tepDinhKemHoSo1.getGuID() + "." + loaiTep;
					try {
						downloadFile(response, fileCode, tepDinhKemHoSo1.getTenTepDinhKem(), fileCode, tepDinhKemHoSo1.getDuongDanFile());
					} catch (IOException e) {
						LOGGER.error(e.getMessage(), e);
					}
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
			if (!StringUtils.hasText(xmlString) || !xmlString.startsWith("<?xml")) return null;
			JAXBContext jaxbContext = JAXBContext.newInstance(ContentChangeRoot6DTO.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return (ContentChangeRoot6DTO) unmarshaller.unmarshal(new StringReader(xmlString));
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
	
	private boolean validSend(TbdHoSo6 tbdHoSo6, boolean xinSuaHoSo) {
		boolean isTrue = Moit06ValidUtil.validThongTinChung(tbdHoSo6);
		if (!StringUtils.hasText(tbdHoSo6.getMucDich())) return false;
		if (xinSuaHoSo && !StringUtils.hasText(tbdHoSo6.getLyDoSua())) return false;
		return isTrue;
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
