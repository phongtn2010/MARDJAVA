package com.nsw.moit.api;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.util.FileCopyUtils;
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
import com.nsw.moit.p07.model.ContentChangeRoot7DTO;
import com.nsw.moit.p07.model.TbdKQXL7;
import com.nsw.moit.p07.util.Moit07BackendConstants;
import com.nsw.moit.p07.util.Moit07TbdHoSo7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdKQXL7BackendUtil;
import com.nsw.moit.p07.model.TbdHangHoa7;
import com.nsw.moit.p07.model.TbdHangHoa7DTO;
import com.nsw.moit.p07.util.Moit07TbdHangHoa7BackendUtil;
import com.nsw.moit.p07.model.TbdHoSo7;
import com.nsw.moit.p07.util.Moit07Constants;
import com.nsw.moit.common.CertificateUtils;
import com.nsw.moit.common.ResponseMessage;
import com.nsw.moit.common.SendUtil;
import com.nsw.moit.p06.model.TbsCuaKhau6;
import com.nsw.moit.p06.model.TbsProvince6;
import com.nsw.moit.p06.model.TbsTepDinhKem6;
import com.nsw.moit.p06.util.Moit06BackendConstants;
import com.nsw.moit.p06.util.Moit06Constants;
import com.nsw.moit.p06.util.Moit06TbsCuaKhau6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsProvince6BackendUtil;
import com.nsw.moit.p06.util.Moit06TbsTepDinhKem6BackendUtil;
import com.nsw.moit.p07.model.ContentChange7DTO;
import com.nsw.moit.p07.model.HoSo7EditForm;
import com.nsw.moit.p07.model.HuyHoSo7Form;
import com.nsw.moit.p07.model.KetQuaXuLy7Model;
import com.nsw.moit.p07.model.Send7Message;
import com.nsw.moit.p07.model.TbdCuaKhau7;
import com.nsw.moit.p07.model.TbdDinhKem7;
import com.nsw.moit.p07.model.TbdGPCuaKhau7;
import com.nsw.moit.p07.model.TbdGPHangHoa7;
import com.nsw.moit.p07.model.TbdGPHangHoa7DTO;
import com.nsw.moit.p07.model.TbdGiayPhep7;
import com.nsw.moit.p07.model.TbdGiayPhep7DTO;
import com.nsw.moit.p07.model.TbdHaiQuan7;
import com.nsw.moit.p07.model.TbdHoSo7SearchItem;
import com.nsw.moit.p07.model.TbdKQXL7DTO;
import com.nsw.moit.p07.model.TbdHoSo7SearchDTO;
import com.nsw.moit.p07.model.TbdTTPT7;
import com.nsw.moit.p07.model.TbdGPTTPT7DTO;
import com.nsw.moit.p07.model.TbsHaiQuan7;
import com.nsw.moit.p07.model.TbsPhuongTien7;
import com.nsw.moit.p07.model.TbsTienChat7;
import com.nsw.moit.p07.model.TbsTienChat7DTO;
import com.nsw.moit.p07.model.TbsTrangThai7;
import com.nsw.moit.p07.util.Moit07Constants.MessageFunction;
import com.nsw.moit.p07.util.Moit07TbdCuaKhau7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdDinhKem7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdGPCuaKhau7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdGPHangHoa7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdGiayPhep7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdHaiQuan7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbdTTPT7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsHaiQuan7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsPhuongTien7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsTienChat7BackendUtil;
import com.nsw.moit.p07.util.Moit07TbsTrangThai7BackendUtil;
import com.nsw.moit.p07.util.Moit07ValidUtil;
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
			ResponseJson data = Moit07TbdHoSo7BackendUtil.page(getURL(Moit07BackendConstants.TbdHoSo7Constants.SEARCH), dHoSoDTO6);
			
			return createResponseEntity(data.getData(), data.getTotal(), getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachHoSo]", e);
			pushLog(e);
		}
		
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
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
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_THONG_TIN_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getChiTietHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {

			TbdHoSo7 hoSoNgoaiTe1 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);

			if (hoSoNgoaiTe1 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			
			LOGGER.info("LAY THONG TIN HO SO: {}", hoSoNgoaiTe1);

			return createResponseEntity(hoSoNgoaiTe1, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getChiTietHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_TRANG_THAI, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTrangThais(HttpServletRequest request) {
		try {
			Object data = Moit07TbsTrangThai7BackendUtil.findByIdTrangThaiIsNotNullOrderByIdTrangThai(getURL(Moit07BackendConstants.TbsTrangThai7Constants.FIND_BY_ID_TRANG_THAI_IS_NOT_NULL_ORDER_BY_ID_TRANG_THAI));

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachTrangThai]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_HAI_QUAN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhMucHaiQuan(HttpServletRequest request) {
		try {
			Object data = Moit07TbsHaiQuan7BackendUtil.getAll(getURL(Moit07BackendConstants.TbsHaiQuan7.GET_ALL));

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhMucHaiQuan]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.SUA_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> editHoSo(@PathVariable("idHoSo") long idHoSo) {

		try {

			System.out.println(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE));
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

				//if (!StringUtils.hasText(editForm.getSoGiayChungNhanDKKD())) editForm.setSoGiayChungNhanDKKD(user.getUsername());
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
				editForm.setSoGiayChungNhanDKKD(hoSo.getSoGiayChungNhanDKKD());
			}
			editForm.setSign(isSign());
			editForm.setTienChats(Moit07TbsTienChat7BackendUtil.findByIdTienChatIsNotNullOrderByTenTienChat(getURL(Moit07BackendConstants.TbsTienChat7Constants.FIND_BY_ID_TIEN_CHAT_IS_NOT_NULL_ORDER_BY_TEN_TIEN_CHAT)));

			return createResponseEntity(editForm, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[editHoSo]", e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_CUA_KHAU, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getCuaKhaus(HttpServletRequest request) {

		try {
			Object data = Moit06TbsCuaKhau6BackendUtil.findByIdCuaKhauIsNotNullOrderByTenCuaKhauAsc(getURL(Moit06BackendConstants.TbsCuaKhau6Constants.FIND_BY_ID_CUA_KHAU_IS_NOT_NULL_ORDER_BY_TEN_CUA_KHAU_ASC));

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[layDanhSachCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_PHUONG_TIEN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getPhuongTiens(HttpServletRequest request) {

		try {
			Object data = Moit07TbsPhuongTien7BackendUtil.findByIdPhuongTienIsNotNullOrderByTenPhuongTienAsc(getURL(Moit07BackendConstants.TbsPhuongTien7Constants.FIND_BY_ID_PHUONG_TIEN_IS_NOT_NULL_ORDER_BY_TEN_PHUONG_TIEN_ASC));

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getPhuongTiens]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_TIEN_CHAT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTienChats(@RequestParam(value = "maSoGP", required = false)String maSoGP) {

		try {
			Object data = null;
			if (StringUtils.hasText(maSoGP) && !Objects.equals(maSoGP, "null")) {
				LOGGER.info("Tim theo maSoGP: {}", maSoGP);
				TbdGiayPhep7 tbdGiayPhep7 = Moit07TbdGiayPhep7BackendUtil.findByMaSoGP(getURL(Moit07BackendConstants.TbdGiayPhep7Constants.FIND_BY_MA_SO_G_P), maSoGP);
				if (!Objects.isNull(tbdGiayPhep7)) {
					List<TbdGPHangHoa7> gpHangHoa7s = Moit07TbdGPHangHoa7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdGPHangHoa7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), tbdGiayPhep7.getIdHoSo(), 1);
					if (!Objects.isNull(gpHangHoa7s) && !gpHangHoa7s.isEmpty()) {
						List<TbsTienChat7DTO> gpHangHoa7DTOs = new ArrayList<>();
						gpHangHoa7s.stream().forEach(p-> {
							TbsTienChat7DTO gpHangHoa7DTO = new TbsTienChat7DTO();
							gpHangHoa7DTO.setMaHS(p.getMaHoSoChat());
							gpHangHoa7DTO.setMaCAS(p.getIdHangHoa() + "");
							gpHangHoa7DTO.setTenKhoaHoc(p.getTenIUPAC());
							gpHangHoa7DTO.setTenTiengAnh(p.getTenChatTiengAnh());
							gpHangHoa7DTO.setTenTiengViet(p.getTenChatTiengViet());
							gpHangHoa7DTO.setMaHS(p.getMaHoSoChat());
							gpHangHoa7DTO.setTenKhoaHoc(p.getTenIUPAC());
							gpHangHoa7DTO.setCongThucHoaHoc(p.getCongThucHoaHoc());
							TbdGPHangHoa7DTO hangHoa7DTO = new TbdGPHangHoa7DTO();
							BeanUtils.copyProperties(p, hangHoa7DTO);
							gpHangHoa7DTO.setHangHoa(hangHoa7DTO);
							gpHangHoa7DTOs.add(gpHangHoa7DTO);
						});
						
						data = gpHangHoa7DTOs;
					}
				}
			} else {
				data = Moit07TbsTienChat7BackendUtil.findByIdTienChatIsNotNullOrderByTenTienChat(getURL(Moit07BackendConstants.TbsTienChat7Constants.FIND_BY_ID_TIEN_CHAT_IS_NOT_NULL_ORDER_BY_TEN_TIEN_CHAT));
			}
			 
			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getTienChats]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
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
	@RequestMapping(value = Moit07Constants.ApiUrls.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> saveHoSo(HttpServletRequest request, @RequestBody HoSo7EditForm editForm) {

		LOGGER.info("Form data: {}", editForm);

		try {
			TbdHoSo7 tbdHoSo7 = new TbdHoSo7();
			TbdHoSo7 findOld = new TbdHoSo7();
			if (editForm.getIdHoSo() != null && editForm.getIdHoSo() > 0) {
				tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), editForm.getIdHoSo());
				BeanUtils.copyProperties(tbdHoSo7, findOld);
			} else {
				tbdHoSo7.setSoGiayChungNhanDKKD(editForm.getSoGiayChungNhanDKKD());
				tbdHoSo7.setMaSoThue(editForm.getMaSoThue());
				tbdHoSo7.setTenDoanhNghiep(editForm.getTenDoanhNghiep());
				tbdHoSo7.setDiaChiDoanhNghiep(editForm.getDiaChiDoanhNghiep());
				tbdHoSo7.setDienThoai(editForm.getDienThoai());
				tbdHoSo7.setSoGiayChungNhanDKKD(editForm.getSoGiayChungNhanDKKD());
				tbdHoSo7.setNgayTao(new Date());
				tbdHoSo7.setNguoiTao(editForm.getMaSoThue());
				tbdHoSo7.setTrangThai(0);
				tbdHoSo7.setHoatDong(1);
				tbdHoSo7.setHoSoTam(0);
				tbdHoSo7.setSend(false);
			}

			LOGGER.info("CHINH SUA HO SO: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {}", tbdHoSo7.getIdHoSo(), tbdHoSo7.getMaHoSo(), tbdHoSo7.getHoSoTam(), tbdHoSo7.getTrangThai());
			
			// set cac truong du lieu co the thay doi
			tbdHoSo7.setFax(editForm.getFax());
			tbdHoSo7.setEmail(editForm.getEmail());
			tbdHoSo7.setLoaiHinh(editForm.getLoaiHinh());
			tbdHoSo7.setNgayCapGiayChungNhan(editForm.getNgayCapGiayChungNhan());
			tbdHoSo7.setDiaChiSanXuat(editForm.getDiaChiSanXuat());
			tbdHoSo7.setMucDich(editForm.getMucDich());
			tbdHoSo7.setLyDoSua(editForm.getLyDoSua());
			tbdHoSo7.setXuatNhapKhauTuNgay(editForm.getXuatNhapKhauTuNgay());
			tbdHoSo7.setXuatNhapKhauDenNgay(editForm.getXuatNhapKhauDenNgay());
			tbdHoSo7.setSoLanThucHien(editForm.getSoLanThucHien());
			tbdHoSo7.setLyDoGiaHan(editForm.getLyDoGiaHan());
			tbdHoSo7.setSoGiayPhepDaCap(editForm.getSoGiayPhepDaCap());
			tbdHoSo7.setLoaiHoSo(editForm.getLoaiGiayPhep());
			tbdHoSo7.setDienThoaiNoiSanXuat(editForm.getDienThoaiNoiSanXuat());
			tbdHoSo7.setFaxNoiSanXuat(editForm.getFaxNoiSanXuat());
			tbdHoSo7.setHinhThucXNK(editForm.getHinhThucXNK());
			tbdHoSo7.setTenNguoiDaiDien(editForm.getTenNguoiDaiDien());
			tbdHoSo7.setTenNguoiLienHe(editForm.getTenNguoiLienHe());
			tbdHoSo7.setDienThoaiNguoiLienHe(editForm.getDienThoaiNguoiLienHe());
			tbdHoSo7.setEmailNguoiLienHe(editForm.getEmailNguoiLienHe());
			tbdHoSo7.setNoiCapGDKKD(editForm.getNoiCapGDKKD());
			tbdHoSo7.setSoGiayChungNhanDKKD(editForm.getSoGiayChungNhanDKKD());
			TbsProvince6 tbsProvince6 = Moit06TbsProvince6BackendUtil.geTbsProvince6(getURL(Moit06BackendConstants.TbsProvince6Constants.FIND_BY_CODE), editForm.getMaTinhTP());
			if (tbsProvince6 != null) {
				tbdHoSo7.setMaTinhTP(tbsProvince6.getProvinceCode());
				tbdHoSo7.setTinhTP(tbsProvince6.getProvinceName());
			} else {
				return createResponseEntity(editForm, 0L, getMessage(Moit06Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			if (!isHasEdit(tbdHoSo7) || !Moit07ValidUtil.validThongTinChung(tbdHoSo7)) {
				return createResponseEntity(editForm, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			if (tbdHoSo7.getIdHoSo() != null && tbdHoSo7.getIdHoSo() > 0) {
				LOGGER.info("TBDHOSO7: {}", tbdHoSo7);
				tbdHoSo7 = Moit07TbdHoSo7BackendUtil.updateTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.UPDATE), tbdHoSo7.getIdHoSo(), tbdHoSo7);
				saveLichSuHoSo(tbdHoSo7, getMessage(LICH_SUA_HO_SO_KEY, tbdHoSo7.getMaHoSo()));
			} else {
				tbdHoSo7.setHoSoTam(0);
				tbdHoSo7 = Moit07TbdHoSo7BackendUtil.createTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.CREATE), tbdHoSo7);
				saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.taohoso", tbdHoSo7.getMaHoSo()));
			}
			debugLog("Luu thong tin ho so: {}", tbdHoSo7);
			Moit07TbdHoSo7BackendUtil.remove(environment.getRequiredProperty(Moit07BackendConstants.ROOT_URL), tbdHoSo7.getIdHoSo());
			saveCuaKhau(tbdHoSo7, editForm);
			savePhuongTien(tbdHoSo7, editForm);
			saveHangHoa(tbdHoSo7, editForm);
			saveHaiQuan(tbdHoSo7, editForm);
			saveTepTin(tbdHoSo7, editForm);

			editForm.setIdHoSo(tbdHoSo7.getIdHoSo());

			if (editForm.isGuiHoSo() && isSign()) {
				ResponseJson responseJson = getXmlContent(tbdHoSo7);
				X509Certificate x509Cert = CertificateUtils.getX509Cert(editForm.getSerialNumber());
				if (!ObjectUtils.isEmpty(x509Cert) && responseJson.getData() != null) {
					String sn = x509Cert.getSerialNumber().toString(16);
					editForm.setSerialNumber(sn);
					editForm.setXmlEnvelop(responseJson.getData().toString());
					editForm.setXmlContent(responseJson.getMessage());
					LOGGER.info("BAN TIN LAY NEN: ENVELOP = {}, BODY = {}", editForm.getXmlEnvelop(), editForm.getXmlContent());
				}
			}
			return createResponseEntity(editForm, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("[saveHoSo]", e);
			e.printStackTrace();
		}
		return createResponseEntity(editForm, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}


	private void saveCuaKhau(TbdHoSo7 tbdHoSo7, HoSo7EditForm editForm) {

		if (editForm.getCuaKhaus() != null) {
			editForm.getCuaKhaus().stream().filter(p -> !Objects.equals("-1", p.getMaCuaKhau())).forEach(p -> {
				LOGGER.info("saveCuaKhau {}", p);
				TbdCuaKhau7 tbdCuaKhau7 = new TbdCuaKhau7();
				tbdCuaKhau7.setIdHoSo(tbdHoSo7.getIdHoSo());
				tbdCuaKhau7.setMaCuaKhau(p.getMaCuaKhau());
				tbdCuaKhau7.setTenCuaKhau(p.getTenCuaKhau());
				tbdCuaKhau7.setIdHoSo(tbdHoSo7.getIdHoSo());
				tbdCuaKhau7.setIdCuaKhau(p.getIdCuaKhau());
				tbdCuaKhau7.setHoatDong(1);

				Moit07TbdCuaKhau7BackendUtil.createTbdCuaKhau7(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.CREATE), tbdCuaKhau7);
			});
		}
	}

	private void savePhuongTien(TbdHoSo7 tbdHoSo7, HoSo7EditForm editForm) {


		if (editForm.getPhuongTiens() != null) {
			editForm.getPhuongTiens().stream().filter(p -> -1 != p.getLoaiPhuongTien()).forEach(p -> {
				LOGGER.info("savePhuongTien {}", p);
				TbdTTPT7 tbdTTPT7 = new TbdTTPT7();
				tbdTTPT7.setIdHoSo(tbdHoSo7.getIdHoSo());
				tbdTTPT7.setLoaiPhuongTien(p.getLoaiPhuongTien());
				tbdTTPT7.setIdPhuongTien(p.getIdPhuongTien());
				tbdTTPT7.setHoatDong(1);
				Moit07TbdTTPT7BackendUtil.createTbdTTPT7(getURL(Moit07BackendConstants.TbdTTPT7Constants.CREATE), tbdTTPT7);
			});
		}
	}

	private void saveHaiQuan(TbdHoSo7 tbdHoSo7, HoSo7EditForm editForm) {

		if (editForm.getHaiQuans() != null) {
			editForm.getHaiQuans().stream().filter(p -> !Objects.equals("-1", p.getMaHaiQuan())).forEach(p -> {
				LOGGER.info("saveHaiQuan {}", p);

				TbdHaiQuan7 tbdHaiQuan7 = new TbdHaiQuan7();
				tbdHaiQuan7.setIdHoSo(tbdHoSo7.getIdHoSo());
				tbdHaiQuan7.setHoatDong(1);
				tbdHaiQuan7.setMaHaiQuan(p.getMaHaiQuan());
				tbdHaiQuan7.setTenHaiQuan(p.getTenHaiQuan());

				Moit07TbdHaiQuan7BackendUtil.createTbdHaiQuan7(getURL(Moit07BackendConstants.TbdHaiQuan7.CREATE), tbdHaiQuan7);
			});
		}
	}

	private void saveHangHoa(TbdHoSo7 tbdHoSo7, HoSo7EditForm editForm) {

		if (editForm.getHangHoa7DTOs() != null) {
			editForm.getHangHoa7DTOs().stream().forEach(p -> {
				if (Moit07ValidUtil.validHangHoa(p, tbdHoSo7.getLoaiHoSo())) {
					saveMotHangHoa(tbdHoSo7.getIdHoSo(), p);
				}
			});
		}
	}

	private TbdHangHoa7DTO saveMotHangHoa(Long idHoSo, TbdHangHoa7DTO p) {
		LOGGER.info("Thong tin nhap hang hoa: {}", p);
		TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);
		String[] maCASs = p.getMaCAS().split(";");
		String[] hamLuongs = p.getHamLuong().split(";");
		TbdHangHoa7 tbdHangHoa7 = new TbdHangHoa7();
		tbdHangHoa7.setMaCAS("");
		tbdHangHoa7.setTenKhoaHoc("");
		tbdHangHoa7.setTenTiengAnh("");
		tbdHangHoa7.setTenTiengViet("");
		tbdHangHoa7.setHamLuong("");
		tbdHangHoa7.setMaHS("");
		tbdHangHoa7.setLoaiTienChat("");
		tbdHangHoa7.setCongThucHoaHoc("");
		for (int i = 0; i < maCASs.length && !Objects.equals(maCASs[i], p.getXoaMaCAS()); i++) {
			TbsTienChat7 tbsTienChat7 = Moit07TbsTienChat7BackendUtil.findTop1ByMaCAS(getURL(Moit07BackendConstants.TbsTienChat7Constants.FIND_BY_MACAS), maCASs[i].trim());
			if (tbsTienChat7 != null) {
				tbdHangHoa7.setMaCAS(tbdHangHoa7.getMaCAS() + ";" + tbsTienChat7.getMaCAS());
				tbdHangHoa7.setTenTiengViet(tbdHangHoa7.getTenTiengViet() + ";" + tbsTienChat7.getTenTiengViet());
				tbdHangHoa7.setTenTiengAnh(tbdHangHoa7.getTenTiengAnh() + ";" + tbsTienChat7.getTenTiengAnh());
				tbdHangHoa7.setTenKhoaHoc(tbdHangHoa7.getTenKhoaHoc() + ";" + tbsTienChat7.getTenKhoaHoc());
				tbdHangHoa7.setHamLuong(tbdHangHoa7.getHamLuong() + ";" + hamLuongs[i]);
				tbdHangHoa7.setMaHS(tbdHangHoa7.getMaHS() + ";" + tbsTienChat7.getMaHS());
				tbdHangHoa7.setCongThucHoaHoc(tbdHangHoa7.getCongThucHoaHoc() + ";" + tbsTienChat7.getCongThucHoaHoc());
				tbdHangHoa7.setLoaiTienChat(tbdHangHoa7.getLoaiTienChat() + ";" + tbsTienChat7.getLoaiTienChat());
			}
		}
		tbdHangHoa7.setMaCAS(tbdHangHoa7.getMaCAS().substring(1));
		tbdHangHoa7.setTenKhoaHoc(tbdHangHoa7.getTenKhoaHoc().substring(1));
		tbdHangHoa7.setTenTiengAnh(tbdHangHoa7.getTenTiengAnh().substring(1));
		tbdHangHoa7.setTenTiengViet(tbdHangHoa7.getTenTiengViet().substring(1));
		tbdHangHoa7.setMaHonHop(p.getMaHonHop());
		tbdHangHoa7.setHamLuong(tbdHangHoa7.getHamLuong().substring(1));
		tbdHangHoa7.setMaHS(tbdHangHoa7.getMaHS().substring(1));
		tbdHangHoa7.setCongThucHoaHoc(tbdHangHoa7.getCongThucHoaHoc().substring(1));
		tbdHangHoa7.setLoaiTienChat(tbdHangHoa7.getLoaiTienChat().substring(1));

		tbdHangHoa7.setTenThuongMai(p.getTenThuongMai());
		tbdHangHoa7.setTrangThaiHangHoa(p.getTrangThaiHangHoa());
		tbdHangHoa7.setDonViTinh(p.getDonViTinh());
		tbdHangHoa7.setMoTa(p.getMoTa());
		tbdHangHoa7.setSoLuong(p.getSoLuong());
		tbdHangHoa7.setSoLuongConLai(p.getSoLuongConLai() == null ? 0F : p.getSoLuongConLai());
		tbdHangHoa7.setSoLuongDaNhap(p.getSoLuongDaNhap() == null ? 0F : p.getSoLuongDaNhap());
		tbdHangHoa7.setSoLuongHonHop(p.getSoLuongHonHop() == null ? 0F : p.getSoLuongHonHop());
		tbdHangHoa7.setIdHoSo(idHoSo);
		tbdHangHoa7.setIdHangHoa(p.getIdHangHoa());
		tbdHangHoa7.setHoatDong(1);
		if (p.getIdHangHoa() != null && p.getIdHangHoa() > 0) {
			tbdHangHoa7.setIdHangHoa(p.getIdHangHoa());
			tbdHangHoa7 = Moit07TbdHangHoa7BackendUtil.updateTbdHangHoa7(getURL(Moit07BackendConstants.TbdHangHoa7Constants.UPDATE), p.getIdHangHoa(), tbdHangHoa7);
			LOGGER.info("Update {}", tbdHangHoa7);
			saveLichSuHoSo(tbdHoSo7, "Chỉnh sửa hàng hóa");
		} else {
			tbdHangHoa7 = Moit07TbdHangHoa7BackendUtil.createTbdHangHoa7(getURL(Moit07BackendConstants.TbdHangHoa7Constants.CREATE), tbdHangHoa7);
			LOGGER.info("Create: {}", tbdHangHoa7);
			saveLichSuHoSo(tbdHoSo7, "Thêm mới hàng hóa ");
		}
		if (tbdHangHoa7 != null) {
			p.setIdHangHoa(tbdHangHoa7.getIdHangHoa());
		}
		
		return p;
	}

	private void saveTepTin(TbdHoSo7 tbdHoSo7, HoSo7EditForm editForm) {

		if (editForm.getTepDinhKems() != null) {
			editForm.getTepDinhKems().stream().forEach(p -> {
				LOGGER.info("Save tep tin: {}", p);
				if (Moit07ValidUtil.validDinhKem(p)) {
					p.setHoatDong(1);
					p.setTenTep(p.getTenTepDinhKem());
					p.setLoaiTep(FilenameUtils.getExtension(p.getTenTepDinhKem()));
					p.setIdHoSo(tbdHoSo7.getIdHoSo());
					p.setIdHoSo(tbdHoSo7.getIdHoSo());
					Moit07TbdDinhKem7BackendUtil.createTbdDinhKem7(getURL(Moit07BackendConstants.TbdDinhKem7Constants.CREATE), p);

				}
			});
		}
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.DELETE_CUA_KHAU_THEO_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteCuaKhauByIdCuaKhau(HttpServletRequest request, @PathVariable("id") long id) {

		try {

			TbdCuaKhau7 tbdCuaKhau7 = Moit07TbdCuaKhau7BackendUtil.getTbdCuaKhau7(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.GET_ONE), id);
			if (id < 1 || tbdCuaKhau7 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), tbdCuaKhau7.getIdHoSo());
			boolean data = Moit07TbdCuaKhau7BackendUtil.deleteTbdCuaKhau7(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.DELETE), tbdCuaKhau7.getIdCuaKhau());
			if (data) {
				saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.xoacuakhau", tbdCuaKhau7.getTenCuaKhau()));
				return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteCuaKhauByIdCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.DELETE_PHUONG_TIEN_THEO_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deletePhuongTienByIdPhuongTien(HttpServletRequest request, @PathVariable("id") long id) {

		try {

			TbdTTPT7 tbdTTPT7 = Moit07TbdTTPT7BackendUtil.getTbdTTPT7(getURL(Moit07BackendConstants.TbdTTPT7Constants.GET_ONE), id);

			if (id < 1 || tbdTTPT7 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), tbdTTPT7.getIdHoSo());
			boolean data = Moit07TbdTTPT7BackendUtil.deleteTbdTTPT7(getURL(Moit07BackendConstants.TbdTTPT7Constants.DELETE), tbdTTPT7.getIdPhuongTien());

			if (data) {

				TbsPhuongTien7 tbsPhuongTien = Moit07TbsPhuongTien7BackendUtil.findByIdPhuongTien(getURL(Moit07BackendConstants.TbsPhuongTien7Constants.FIND_BY_ID_PHUONG_TIEN), tbdTTPT7.getLoaiPhuongTien().longValue());
				saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.xoaphuongtien", tbsPhuongTien.getTenPhuongTien()));

				return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteCuaKhauByIdCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.ADD_HANG_HOA + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addHangHoa(HttpServletRequest request, @PathVariable("id") long id, @RequestBody TbdHangHoa7DTO tbdHangHoa7DTO) {

		try {
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			if (tbdHoSo7 == null ) {
				return createResponseEntity(tbdHangHoa7DTO, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}
			tbdHangHoa7DTO = saveMotHangHoa(id, tbdHangHoa7DTO);
			return createResponseEntity(tbdHangHoa7DTO, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/capNhatLoaiHoSo" + "/{id}/{loaiHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> capNhatLoaiHoSo(HttpServletRequest request, @PathVariable("id") long id, @PathVariable("loaiHoSo") int loaiHoSo) {

		try {
			
			if (loaiHoSo <= 0 || id <= 0) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			tbdHoSo7.setLoaiHoSo(loaiHoSo);
			tbdHoSo7 = Moit07TbdHoSo7BackendUtil.updateTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.UPDATE), id, tbdHoSo7);
			
			return createResponseEntity(tbdHoSo7, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[addHangHoa]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/capNhatSoGiayPhep" + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> capNhatSoGiayPhep(HttpServletRequest request, @PathVariable("id") long id, @RequestParam("soGP") String soGiayPhep) {

		try {
			
			if (id <= 0) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			
			if (tbdHoSo7 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			
			tbdHoSo7.setSoGiayPhepDaCap(soGiayPhep);
			tbdHoSo7 = Moit07TbdHoSo7BackendUtil.updateTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.UPDATE), id, tbdHoSo7);
			
			return createResponseEntity(tbdHoSo7, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[addHangHoa]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}


	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.DELETE_HAI_QUAN_THEO_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteHaiQuan(HttpServletRequest request, @PathVariable("id") long id) {

		try {
			TbdHaiQuan7 tbdHaiQuan7 = Moit07TbdHaiQuan7BackendUtil.getTbdHaiQuan7(getURL(Moit07BackendConstants.TbdHaiQuan7.GET_ONE), id);
			if (id < 1 || tbdHaiQuan7 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), tbdHaiQuan7.getIdHoSo());
			boolean data = Moit07TbdHaiQuan7BackendUtil.deleteTbdHaiQuan7(getURL(Moit07BackendConstants.TbdHaiQuan7.DELETE), tbdHaiQuan7.getIdHaiQuan());

			if (data) {

				saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.xoacuakhau", tbdHaiQuan7.getTenHaiQuan()));

				return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteCuaKhauByIdCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.ADD_CUA_KHAU + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addCuaKhau(HttpServletRequest request, @PathVariable("id") long id, @RequestBody TbdCuaKhau7 form) {

		try {

			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			
			TbsCuaKhau6 tbsCuaKhau = Moit06TbsCuaKhau6BackendUtil.findByIdCuaKhau(getURL(Moit06BackendConstants.TbsCuaKhau6Constants.FIND_BY_ID_CUA_KHAU), form.getMaCuaKhau().trim());
			if (tbsCuaKhau != null) {
				TbdCuaKhau7 tbdCuaKhau7 = new TbdCuaKhau7();
				tbdCuaKhau7.setIdHoSo(id);
				tbdCuaKhau7.setMaCuaKhau(tbsCuaKhau.getMaCuaKhau());
				tbdCuaKhau7.setTenCuaKhau(tbsCuaKhau.getTenCuaKhau());
				tbdCuaKhau7.setHoatDong(1);
				List<TbdCuaKhau7> tbdCuaKhau7s = Moit07TbdCuaKhau7BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), id, 1);
				if (tbdCuaKhau7s != null) {
					Optional<TbdCuaKhau7> optional = tbdCuaKhau7s.stream().filter(p -> p.getMaCuaKhau().equals(form.getMaCuaKhau())).findFirst();
					if (!optional.isPresent()) {
						tbdCuaKhau7 = Moit07TbdCuaKhau7BackendUtil.createTbdCuaKhau7(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.CREATE), tbdCuaKhau7);
						if (tbdCuaKhau7 != null) {
							saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.themcuakhau", tbdCuaKhau7.getTenCuaKhau()));
							return createResponseEntity(tbdCuaKhau7, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
						}
					}
				}

			}

		} catch (Exception e) {

			LOGGER.error("[addCuaKhau]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.ADD_PHUONG_TIEN + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addPhuongTIen(HttpServletRequest request, @PathVariable("id") long id, @RequestBody TbdTTPT7 form) {

		try {

			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			
			TbsPhuongTien7 tbsPhuongTien = Moit07TbsPhuongTien7BackendUtil.findByIdPhuongTien(getURL(Moit07BackendConstants.TbsPhuongTien7Constants.FIND_BY_ID_PHUONG_TIEN), form.getLoaiPhuongTien().longValue());
			if (tbsPhuongTien != null) {
				TbdTTPT7 tbdTTPT7 = new TbdTTPT7();
				tbdTTPT7.setIdHoSo(id);
				tbdTTPT7.setLoaiPhuongTien(tbsPhuongTien.getIdPhuongTien().intValue());
				tbdTTPT7.setHoatDong(1);
				List<TbdTTPT7> tbdTTPT7s = Moit07TbdTTPT7BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit07BackendConstants.TbdTTPT7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), id, 1);
				if (tbdTTPT7s != null) {
					Optional<TbdTTPT7> optional = tbdTTPT7s.stream().filter(p -> p.getLoaiPhuongTien() == form.getLoaiPhuongTien()).findFirst();
					if (!optional.isPresent()) {
						tbdTTPT7 = Moit07TbdTTPT7BackendUtil.createTbdTTPT7(getURL(Moit07BackendConstants.TbdTTPT7Constants.CREATE), tbdTTPT7);
						if (tbdTTPT7 != null) {
							saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.themphuongtien", tbsPhuongTien.getTenPhuongTien()));
							return createResponseEntity(tbdTTPT7, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
						}
					}
				}
			}

		} catch (Exception e) {

			LOGGER.error("[tbdTTPT7]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.ADD_HAI_QUAN + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addHaiQuan(HttpServletRequest request, @PathVariable("id") long id, @RequestBody TbdHaiQuan7 form) {

		try {

			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), id);
			TbsHaiQuan7 tbsHaiQuan7 = Moit07TbsHaiQuan7BackendUtil.findByMaHaiQuang(getURL(Moit07BackendConstants.TbsHaiQuan7.FIND_BY_MA_HAI_QUAN), form.getMaHaiQuan());
			if (tbsHaiQuan7 != null) {
				TbdHaiQuan7 tbdHaiQuan7 = new TbdHaiQuan7();
				tbdHaiQuan7.setIdHoSo(id);
				tbdHaiQuan7.setTenHaiQuan(tbsHaiQuan7.getTenHaiQuan());
				tbdHaiQuan7.setHoatDong(1);
				tbdHaiQuan7.setMaHaiQuan(tbsHaiQuan7.getMaHaiQuan());
				List<TbdHaiQuan7> tbdHaiQuan7s = Moit07TbdHaiQuan7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdHaiQuan7.FIND_BY_ID_HO_SO), id, 1);
				if (tbdHaiQuan7s != null) {
					Optional<TbdHaiQuan7> optional = tbdHaiQuan7s.stream().filter(p -> p.getMaHaiQuan().equals(tbsHaiQuan7.getMaHaiQuan())).findFirst();
					if (!optional.isPresent()) {
						tbdHaiQuan7 = Moit07TbdHaiQuan7BackendUtil.createTbdHaiQuan7(getURL(Moit07BackendConstants.TbdHaiQuan7.CREATE), tbdHaiQuan7);
						if (tbdHaiQuan7 != null) {
							saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.themphuongtien", tbdHaiQuan7.getTenHaiQuan()));
							return createResponseEntity(tbdHaiQuan7, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
						}
					}
				}
			}

		} catch (Exception e) {

			LOGGER.error("[tbdTTPT7]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_TEP_TIN_THEO_HO_SO + "/{idHoSo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getTepDinhKemByIdHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

		try {
			if (idHoSo < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			Object data = Moit07TbdDinhKem7BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit07BackendConstants.TbdDinhKem7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), idHoSo, 1);

			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getTepDinhKemByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.DELETE_TEP_TIN_BY_ID + "/{idTepDK}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteTepDinhKemById(HttpServletRequest request, @PathVariable("idTepDK") long idTepDK) {

		try {
			if (idTepDK < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			TbdDinhKem7 tepDinhKemHoSo1 = Moit07TbdDinhKem7BackendUtil.getTbdDinhKem7(getURL(Moit07BackendConstants.TbdDinhKem7Constants.GET_ONE), idTepDK);

			if (tepDinhKemHoSo1 != null) {
				
				TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), tepDinhKemHoSo1.getIdHoSo());
				tepDinhKemHoSo1.setHoatDong(0);
				Moit07TbdDinhKem7BackendUtil.deleteTbdDinhKem7(getURL(Moit07BackendConstants.TbdDinhKem7Constants.DELETE), idTepDK);
				saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.xoateptin", tepDinhKemHoSo1.getTenTep()));
				return createResponseEntity(tepDinhKemHoSo1, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteTienTeByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/xoaTepDKByIdHoSo/{idTepDK}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteAllTepDinhKemById(HttpServletRequest request, @PathVariable("idTepDK") long idTepDK) {

		boolean isSuccess = false;
		try {
			if (idTepDK < 1) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			isSuccess = Moit07TbdDinhKem7BackendUtil.deleteTbdDinhKem7ByIdHoSo(getHost() + "/moit/07/tepTin/deleteByIdHoSo", idTepDK);

		} catch (Exception e) {

			LOGGER.error("[deleteTienTeByIdHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), isSuccess, HttpStatus.OK);
	}
	private boolean isHasEdit(TbdHoSo7 tbdHoSo7) {
		if (tbdHoSo7 == null)
			return true;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal != null && (principal instanceof UserCustom)) {
			UserCustom user = (UserCustom) principal;
			if (user.getUsername() != null && user.getUsername().equals(tbdHoSo7.getMaSoThue()))
				return true;
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.DELETE_HANG_HOA + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteHangHoaByIdHangHoa(HttpServletRequest request, @PathVariable("id") long id) {

		try {
			TbdHangHoa7 tbdHangHoa7 = Moit07TbdHangHoa7BackendUtil.getTbdHangHoa7(getURL(Moit07BackendConstants.TbdHangHoa7Constants.GET_ONE), id);

			if (id < 1 || tbdHangHoa7 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			boolean data = Moit07TbdHangHoa7BackendUtil.deleteTbdHangHoa7(getURL(Moit07BackendConstants.TbdHangHoa7Constants.DELETE), id);

			if (data) {
				
				TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), tbdHangHoa7.getIdHoSo());

				saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.xoahanghoa", tbdHangHoa7.getTenThuongMai()));
				return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			LOGGER.error("[deleteHangHoaByIdHangHoa]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.DELETE_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deleteHoSo(HttpServletRequest request, @PathVariable("id") long idHoSo) {

		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);
			if (!(principal instanceof UserDetails)
					|| tbdHoSo7 == null
					|| tbdHoSo7.getTrangThai() != 0) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			UserCustom user = (UserCustom) principal;
			
			if (tbdHoSo7 != null) {
				boolean isOwner = tbdHoSo7.getMaSoThue().equals(user.getUsername());
				if (isOwner) {
					tbdHoSo7.setHoatDong(0);
					tbdHoSo7 = Moit07TbdHoSo7BackendUtil.updateTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.UPDATE), idHoSo, tbdHoSo7);
					saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.xoahoso", tbdHoSo7.getMaHoSo()));
					return createResponseEntity(tbdHoSo7, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
				}
			}

		} catch (Exception e) {

			LOGGER.error("[deleteHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.GUI_HO_SO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> sendHoSo(HttpServletRequest request, @RequestBody HoSo7EditForm hoSoEditForm) {

		try {
			
			
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), hoSoEditForm.getIdHoSo());
			if (tbdHoSo7 == null) {
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}
			
			if (!validSend(tbdHoSo7, Objects.equals(hoSoEditForm.getIsChinhSua(), Boolean.TRUE))) {
				return createResponseEntity(null, 0L, "Thông tin chung hoặc thông tin hàng hóa chưa đầy đủ!", false, HttpStatus.OK);
			}

			List<TbdCuaKhau7> tbdCuaKhau7s = Moit07TbdCuaKhau7BackendUtil.findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(getURL(Moit07BackendConstants.TbdCuaKhau7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_CUA_KHAU_ASC), tbdHoSo7.getIdHoSo(), 1);
			if (tbdCuaKhau7s == null || tbdCuaKhau7s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin cửa khẩu chưa có!", false, HttpStatus.OK);
			}
			List<TbdTTPT7> tbdTTPT7s = Moit07TbdTTPT7BackendUtil.findByIdHoSoAndHoatDongOrderByIdPhuongTienAsc(getURL(Moit07BackendConstants.TbdTTPT7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_PHUONG_TIEN_ASC), tbdHoSo7.getIdHoSo(), 1);
			if (tbdTTPT7s == null || tbdTTPT7s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin phương tiện chưa có!", false, HttpStatus.OK);
			}
			
			List<TbdHangHoa7> hangHoa7s = Moit07TbdHangHoa7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdHangHoa7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_HANG_HOA_ASC), tbdHoSo7.getIdHoSo(), 1);
			if (hangHoa7s == null || hangHoa7s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin hàng hóa chưa có!", false, HttpStatus.OK);
			}
			
			List<TbdHaiQuan7> haiQuan7s = Moit07TbdHaiQuan7BackendUtil.findByIdHoSoAndHoatDongOrderByIdHangHoaAsc(getURL(Moit07BackendConstants.TbdHaiQuan7.FIND_BY_ID_HO_SO), tbdHoSo7.getIdHoSo(), 1);
			if (haiQuan7s == null || haiQuan7s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin hải quan chưa có!", false, HttpStatus.OK);
			}
			
			List<TbdDinhKem7> dinhKem7s = Moit07TbdDinhKem7BackendUtil.findByIdHoSoAndHoatDongOrderByIdTepTinAsc(getURL(Moit07BackendConstants.TbdDinhKem7Constants.FIND_BY_ID_HO_SO_AND_HOAT_DONG_ORDER_BY_ID_TEP_TIN_ASC), tbdHoSo7.getIdHoSo(), 1);
			if (dinhKem7s == null || dinhKem7s.isEmpty()) {
				return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin đính kèm chưa có!", false, HttpStatus.OK);
			}
			
			List<TbsTepDinhKem6> tbsTepDinhKem6s = moit06TbsTepDinhKem6BackendUtil.findByLoaiThuTuc("p07");
			final int loaiHoSo = tbdHoSo7.getLoaiHoSo();
			tbsTepDinhKem6s = tbsTepDinhKem6s.stream().filter(p-> Objects.equals(p.getLoaiTep(), loaiHoSo == 2 ? "XNK_TC_MA_TUY_GIAHAN" : "XNK_TC_MA_TUY")).collect(Collectors.toList());
			for (TbsTepDinhKem6 tep : tbsTepDinhKem6s) {
				if (Objects.equals(tep.getRequired(), Boolean.TRUE)) {
					Optional<TbdDinhKem7> find = dinhKem7s.stream().filter(p-> p.getMaLoaiTep().intValue() == tep.getMaLoaiTep().intValue()).findFirst();
					if (!find.isPresent()) {
						return createResponseEntity(null, 0L, "Gửi hồ sơ không thành công. Thông tin đính kèm chưa có! " + tep.getTenTep(), false, HttpStatus.OK);
					}
				}
			}
			debugLog("THONG TIN GUI HO SO: ID = {}, MA HO SO = {}, VERSION = {}, TRANG THAI = {}", tbdHoSo7.getIdHoSo(), tbdHoSo7.getMaHoSo(), tbdHoSo7.getHoSoTam(), tbdHoSo7.getTrangThai());
			
			Send7Message sendMessage = getSendMessage(tbdHoSo7.getIdHoSo(), tbdHoSo7.getTrangThai());
			
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
				tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), hoSoEditForm.getIdHoSo());
				tbdHoSo7.setSend(true);
				tbdHoSo7 = Moit07TbdHoSo7BackendUtil.updateTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.UPDATE), hoSoEditForm.getIdHoSo(), tbdHoSo7);
				if (json.isSuccess()) {
					saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.yeucauguihoso"));
					return createResponseEntity(tbdHoSo7, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
				}
			} 
			updateToVersion(hoSoEditForm.getIdHoSo());
		} catch (Exception e) {
			updateToVersion(hoSoEditForm.getIdHoSo());
			LOGGER.error("[sendHoSo]", e);
		}

		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}
	
	private void updateToVersion(long idHoSo) {
		TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);
		if (tbdHoSo7 == null || tbdHoSo7.getHoSoTam() == null) return;
		tbdHoSo7.setHoSoTam(tbdHoSo7.getHoSoTam() - 1);
		tbdHoSo7.setSend(false);
		if (tbdHoSo7.getHoSoTam() < 0) tbdHoSo7.setHoSoTam(0);
	    tbdHoSo7 = Moit07TbdHoSo7BackendUtil.updateTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.UPDATE), idHoSo, tbdHoSo7);
	    LOGGER.info("Revert version: ID = {}, TRANG THAI = {}, VERSION = {}", tbdHoSo7.getIdHoSo(), tbdHoSo7.getTrangThai(), tbdHoSo7.getHoSoTam());
		
	}
	
	private Send7Message getSendMessage(long idHoSo, int trangThai) {
		Send7Message sendMessage = new Send7Message();
		sendMessage.setFiIdHoso(idHoSo);

		MessageFunction messageFunction = MessageFunction.FUNTION_YC_SUA;

		if (trangThai == Moit07Constants.Status.TAO_MOI) {
			messageFunction = MessageFunction.FUNTION_GUI_MOI;
		} else if (trangThai == Moit07Constants.Status.CHO_TIEP_NHAN) {
			messageFunction = MessageFunction.FUNTION_GUI_SUA;
		} else if (trangThai == Moit07Constants.Status.YEU_CAU_BO_SUNG) {
			messageFunction = MessageFunction.FUNTION_GUI_SDBS;
		} else if (trangThai == Moit06Constants.Status.DA_SDBS) {
			messageFunction = MessageFunction.FUNTION_GUI_SUA;
		}
		
		sendMessage.setFunction(messageFunction.getFunctionName());
		sendMessage.setType(messageFunction.getFunctionType());
		debugLog("sendHoSo: getFunctionName = {}, getFunctionType = {}, sendMessage = {}", messageFunction.getFunctionName(), messageFunction.getFunctionType(), sendMessage);
		return sendMessage;
	}
	
	private ResponseJson getXmlContent(TbdHoSo7 tbdHoSo7) {
		Send7Message send6Message = getSendMessage(tbdHoSo7.getIdHoSo(), tbdHoSo7.getTrangThai());
		send6Message.setGetXmlNotSend("true");
		return callRestTemplate(getURL(SEND_ALL), send6Message, HttpMethod.POST, null);
	}

	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.HUY_HO_SO + "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> huyHoSo(HttpServletRequest request, @PathVariable("id") long idHoSo, @RequestBody HuyHoSo7Form form) {

		try {
			TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);

			List<Integer> status = Arrays.asList(1, 4, 5, 7, 9, 10, 15, 16);
			if (tbdHoSo7 == null 
					|| !StringUtils.hasText(form.getNoiDung())
					|| !status.contains(tbdHoSo7.getTrangThai())) {

				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
			}

			MessageFunction messageFunction = MessageFunction.FUNTION_YC_RUT_CHUA_DUYET;
			if (tbdHoSo7.getTrangThai() != Moit07Constants.Status.CHO_TIEP_NHAN
					&& tbdHoSo7.getTrangThai() != Moit07Constants.Status.YEU_CAU_BO_SUNG
					&& tbdHoSo7.getTrangThai() != Moit07Constants.Status.DA_SDBS) {
				messageFunction = MessageFunction.FUNTION_YC_RUT;
			}
			Send7Message sendMessage = new Send7Message();
			sendMessage.setLyDo(form.getNoiDung());
			sendMessage.setFunction(messageFunction.getFunctionName());
			sendMessage.setType(messageFunction.getFunctionType());
			sendMessage.setFiIdHoso(idHoSo);
			debugLog("huyHoSo: {}", sendMessage);
			LOGGER.info("XIN RUT HO SO VERSION: ID = {} | MA HO SO: {} | VERSION =  {} | STATUS = {} | ACTIVE = {}", tbdHoSo7.getIdHoSo(), tbdHoSo7.getMaHoSo(), tbdHoSo7.getHoSoTam(), tbdHoSo7.getTrangThai(), tbdHoSo7.getHoatDong());
			ResponseJson json = send(sendMessage);
			if (json != null) {
				boolean a = json.isSuccess();
				if (a) {
					tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);
					saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.yeucauruthoso"));
					return createResponseEntity(tbdHoSo7, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
				}
			}

		} catch (Exception e) {

			LOGGER.error("[huyHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
	}

	private boolean isSign() {
		return Boolean.parseBoolean(environment.getProperty(IS_SIGN_KEY));
	}

	private ResponseJson send(Send7Message sendMessage) {
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

	protected void saveLichSuHoSo(TbdHoSo7 tbdHoSo7, String message) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserCustom user = (UserCustom) principal;
		TbdKQXL7 ketQuaXuLyHoSo1 = new TbdKQXL7();
		ketQuaXuLyHoSo1.setIdHoSo(tbdHoSo7.getIdHoSo());
		ketQuaXuLyHoSo1.setTrangThai(tbdHoSo7.getTrangThai());
		ketQuaXuLyHoSo1.setNguoiXuLy(user.getUsername());
		ketQuaXuLyHoSo1.setDonViXuLy(user.getCompanyName());
		ketQuaXuLyHoSo1.setNgayXuLy(new Date());
		ketQuaXuLyHoSo1.setNoiDung(message);
		ketQuaXuLyHoSo1.setMaHoSo(tbdHoSo7.getMaHoSo());
		ketQuaXuLyHoSo1.setNgayTao(new Date());
		Moit07TbdKQXL7BackendUtil.createTbdKQXL7(getURL(Moit07BackendConstants.TbdKQXL7Constants.CREATE), ketQuaXuLyHoSo1);
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = Moit07Constants.ApiUrls.LAY_DANH_SACH_LICH_SU + "/{maHoSo}/{pageIndex}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getLichSuHoSos(HttpServletRequest request,  @PathVariable("maHoSo") String maHoSo, @PathVariable("pageIndex") int pageIndex) {

		try {
			Object data = null;
			ResponseJson kqs = Moit07TbdKQXL7BackendUtil.searchKetQuaXuLys(getURL(Moit07BackendConstants.TbdKQXL7Constants.SEARCH_KET_QUA_XU_LYS), maHoSo, pageIndex - 1, 10);
			Long total = 0L;
			if (kqs != null) {
				total = kqs.getTotal();
				List<TbdKQXL7DTO> ketQuaXuLyHoSoModels = new ArrayList<>();
				List<KetQuaXuLy7Model> ketQuaXuLy7Models = (List<KetQuaXuLy7Model>) kqs.getData();
				if (ketQuaXuLy7Models != null) {
					for (int k = 0; k < ketQuaXuLy7Models.size(); k++) {
						KetQuaXuLy7Model item = ketQuaXuLy7Models.get(k);
						TbdKQXL7DTO tbdLichSu7DTO = new TbdKQXL7DTO();
						tbdLichSu7DTO.setDonVi(item.getDonViXuLy());
						tbdLichSu7DTO.setNguoiXuLy(item.getNguoiXuLy());
						tbdLichSu7DTO.setNgayXyLy(item.getNgayXuLy());
						tbdLichSu7DTO.setNoiDung(item.getNoiDung());
						tbdLichSu7DTO.setTrangThai(item.getTrangThai());
						ContentChangeRoot7DTO contentChangeRoot7DTO = xmlToObject(item.getNoiDung());
						if (contentChangeRoot7DTO != null) {
							tbdLichSu7DTO.setContentChanges(contentChangeRoot7DTO.getContentChange7DTOs());
							tbdLichSu7DTO.setNoiDung(contentChangeRoot7DTO.getName());
						}
						tbdLichSu7DTO.setTenTrangThai(item.getTenTrangThai());
						ketQuaXuLyHoSoModels.add(tbdLichSu7DTO);
					}
				}
				
				data = ketQuaXuLyHoSoModels;
			}
			return createResponseEntity(data, total, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
		} catch (Exception e) {

			LOGGER.error("[layLichSuHoSo]", e);
			pushLog(e);
		}
		return createResponseEntity(Collections.emptyList(), 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
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
				return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
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
			Object data = chiTietGiayPhep;
			return createResponseEntity(data, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("[getGiayPhep]", e);
			pushLog(e);
		}
		return createResponseEntity(null, 0L, getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
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

	protected String getHost() {
		return environment.getRequiredProperty(Moit07BackendConstants.ROOT_URL);
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

	private static final String BACKEND_URL_UPLOAD_KEY = "com.nsw.moit.p07.upload";
	private static final String BACKEND_URL_DOWNLOAD_KEY = "com.nsw.moit.p07.download";
	private static final String BACKEND_URL_KEY = "moit.07.backend";
	private static final String UNDEFINED_INPUT = "undefined,";

	private static final String LICH_SUA_HO_SO_KEY = "moit.07.lichsu.suahoso";

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
		json.setMessage(getMessage(Moit07Constants.MessageKeys.ACTION_ERROR, null, LocaleContextHolder.getLocale()));
		RabbitMQInfo mqInfo = getRabbitMQ();
		try {
			
			if (file.isEmpty() || !StringUtils.hasText(mcode) || !StringUtils.hasText(pcode)) {
				return json;
			}
			
			TbdHoSo7 tbdHoSo7 = null;
			if (idHoSo > 0) {
				tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);
			}

			String tempFolder = environment.getProperty(AppConstant.Download.TemSaveFolder);
			String uri = getFullUri(environment.getRequiredProperty(BACKEND_URL_UPLOAD_KEY));
			ResponseJson responseJson = fileHelper.uploadFile(uri, file, tempFolder, mcode, pcode, mqInfo);
			if (!isUploadSuccess(responseJson))
				return json;
			json = responseJson;
			ResponseUpload responseUpload = readObject(json, ResponseUpload.class);
			if (responseUpload != null) {
				String uuId = FilenameUtils.getBaseName(responseUpload.getFileCode());

				TbdDinhKem7 tepDinhKemHoSo1 = new TbdDinhKem7();
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
				
				if (canClone(idHoSo)) {
					tepDinhKemHoSo1.setIdHoSo(0L);
				}
				if (idHoSo > 0) {
					tepDinhKemHoSo1 = Moit07TbdDinhKem7BackendUtil.createTbdDinhKem7(getURL(Moit07BackendConstants.TbdDinhKem7Constants.CREATE), tepDinhKemHoSo1);
				}
				debugLog("Create tep dinh kem: {}", tepDinhKemHoSo1);
				if (idHoSo > 0 && tepDinhKemHoSo1.getIdHoSo() > 0) {
					saveLichSuHoSo(tbdHoSo7, getMessage("moit.07.lichsu.themteptin", tepDinhKemHoSo1.getTenTep()));
				}

				json.setData(tepDinhKemHoSo1);
				json.setMessage(getMessage(Moit07Constants.MessageKeys.ACTION_SUCCESS, null, LocaleContextHolder.getLocale()));
				json.setSuccess(true);

			}

		} catch (Exception ex) {
			String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

			LOGGER.error(ex.getMessage(), ex);
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
		}

		return json;
	}

	private boolean canClone(long idHoSo) {
		TbdHoSo7 tbdHoSo7 = Moit07TbdHoSo7BackendUtil.getTbdHoSo7(getURL(Moit07BackendConstants.TbdHoSo7Constants.GET_ONE), idHoSo);
		return !Objects.isNull(tbdHoSo7) && Objects.equals( tbdHoSo7.getSend(), Boolean.TRUE);
	}
	private boolean isUploadSuccess(ResponseJson responseJson) {
		boolean isTrue = true;
		if (responseJson == null || !responseJson.isSuccess() || responseJson.getData() == null)
			return false;

		return isTrue;
	}

	@RequestMapping(value = "/download/{idTepDinhKem}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("idTepDinhKem") long idTepDinhKem) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {

				TbdDinhKem7 tepDinhKemHoSo1 = Moit07TbdDinhKem7BackendUtil.getTbdDinhKem7(getURL(Moit07BackendConstants.TbdDinhKem7Constants.GET_ONE), idTepDinhKem);

				if (tepDinhKemHoSo1 != null) {
					String loaiTep = tepDinhKemHoSo1.getLoaiTep();
					if (!StringUtils.hasText(loaiTep))
						loaiTep = FilenameUtils.getExtension(tepDinhKemHoSo1.getTenTepDinhKem());
					String fileCode = tepDinhKemHoSo1.getGuID() + "." + loaiTep;
					try {
						downloadFile(response, fileCode, tepDinhKemHoSo1.getTenTepDinhKem(), fileCode, tepDinhKemHoSo1.getDuongDanFile());
					} catch (IOException e) {
						LOGGER.error(e.getMessage(), e);
					}
				}
		}
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
				try(InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
					FileCopyUtils.copy(inputStream, response.getOutputStream());
				}
				
				
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(),ex);
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

	private ContentChangeRoot7DTO getValueChange(String message, Object old, Object newObj) {
		ContentChangeRoot7DTO contentChangeRoot7DTO = new ContentChangeRoot7DTO();
		contentChangeRoot7DTO.setName(message);
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
					} else
						value1 = String.valueOf(aField);
				}
				if (bField != null) {
					if (a2.getType().equals(Date.class)) {
						value2 = dateFormat.format((Date) bField);
					} else
						value2 = String.valueOf(bField);
				}

				boolean khac = (!value1.isEmpty() || !value2.isEmpty());
				boolean khac2 = (!value1.isEmpty() && !value2.isEmpty() && !value1.equals(value2));
				if (khac && khac2) {
					builder.append(fields[i].getName() + ": [" + value1 + " -> " + value2 + "]");
					ContentChange7DTO change7dto = new ContentChange7DTO();
					change7dto.setName(a1.getName());
					change7dto.setFromValue(value1);
					change7dto.setToValue(value2);
					contentChangeRoot7DTO.getContentChange7DTOs().add(change7dto);
				}

			}

		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
		return contentChangeRoot7DTO;
	}

	private String toXml(ContentChangeRoot7DTO changeRoot7DTO) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ContentChangeRoot7DTO.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(changeRoot7DTO, stringWriter);
			return stringWriter.toString();
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
		return "";
	}

	private ContentChangeRoot7DTO xmlToObject(String xmlString) {
		try {
			if (!StringUtils.hasText(xmlString) || !xmlString.startsWith("<?xml"))
				return null;
			JAXBContext jaxbContext = JAXBContext.newInstance(ContentChangeRoot7DTO.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return (ContentChangeRoot7DTO) unmarshaller.unmarshal(new StringReader(xmlString));
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
	
	private boolean validSend(TbdHoSo7 tbdHoSo7, boolean xinSuaHoSo) {
		
		boolean isTrue = Moit07ValidUtil.validThongTinChung(tbdHoSo7);
		if (!StringUtils.hasText(tbdHoSo7.getMucDich())) return false;
		if (xinSuaHoSo && !StringUtils.hasText(tbdHoSo7.getLyDoSua())) return false;
		
		return isTrue;
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
