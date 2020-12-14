package com.nsw.monre.api;

import java.net.URI;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.nsw.monre.p01.constant.AppKeyConstant;
import com.nsw.monre.p01.constant.AppViewThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.model.HoSo1;
import com.nsw.monre.p01.model.HoSoEditForm;
import com.nsw.monre.p01.model.ResponseJson;
import com.nsw.monre.p01.model.TbdCapGiayXacNhan1;
import com.nsw.monre.p01.model.TbdGXNThongTinCoSoSX1;
import com.nsw.monre.p01.model.TbdGXNThongTinPheLieu1;
import com.nsw.monre.p01.model.TbdHSDeNghiCapGiayXn1;
import com.nsw.monre.p01.model.TbdThanhToan1;
import com.nsw.monre.p01.model.TbdThongTinCoSoSX1;
import com.nsw.monre.p01.model.TbdThongTinPheLieu1;
import com.nsw.monre.p01.model.TbdXemGiayXacNhan;
import com.nsw.monre.p01.model.TbsCoQuanXuLy1;
import com.nsw.monre.p01.model.TbsDistrict1;
import com.nsw.monre.p01.model.TbsPheLieu1;
import com.nsw.monre.p01.model.TbsProvince1;
import com.nsw.monre.p01.model.TbsStatus1;
import com.nsw.monre.p01.model.TbsWard1;
import com.nsw.monre.p01.model.UserInfo;
import com.nsw.monre.p01.searchitem.TbdHSDeNghiCapGiayXn1SearchItem;
import com.nsw.monre.p01.searchitem.TbdThanhToan1SearchItem;
import com.nsw.monre.p01.searchitem.TbsPheLieu1SearchItem;
import com.nsw.monre.p01.service.TbdCapGiayXacNhan1Service;
import com.nsw.monre.p01.service.TbdGXNThongTinCoSoSX1Service;
import com.nsw.monre.p01.service.TbdGXNThongTinPheLieu1Service;
import com.nsw.monre.p01.service.TbdHSDeNghiCapGiayXn1Service;
import com.nsw.monre.p01.service.TbdKetQuaXuLy1Service;
import com.nsw.monre.p01.service.TbdTepTin1Service;
import com.nsw.monre.p01.service.TbdThanhToan1Service;
import com.nsw.monre.p01.service.TbdThongTinCoSoSX1Service;
import com.nsw.monre.p01.service.TbdThongTinPheLieu1Service;
import com.nsw.monre.p01.service.TbdYeuCauRutHS1Service;
import com.nsw.monre.p01.service.TbsCoQuanXuLy1Service;
import com.nsw.monre.p01.service.TbsDistrict1Service;
import com.nsw.monre.p01.service.TbsPheLieu1Service;
import com.nsw.monre.p01.service.TbsProvince1Service;
import com.nsw.monre.p01.service.TbsStatus1Service;
import com.nsw.monre.p01.service.TbsThongTinCoSoSX1Service;
import com.nsw.monre.p01.service.TbsWard1Service;
import com.nsw.monre.p01.util.AppCommon;
import com.nsw.monre.p01.util.ConvertToObjectUtil;
import com.nsw.monre.p01.util.LoginUtil;
import com.nsw.monre.p01.util.NumberUtil;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

/**
 * @author Quang
 *
 */
/**
 * @author Quang
 *
 */
@Controller
@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_01, AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_02, AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_03, AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_04 })
public class Monre01Api {

	private static final Logger LOGGER = LoggerFactory.getLogger(Monre01Api.class);

	private static final String CLASS_NAME = "Monre01Api";

	@Autowired
	private Environment environment;

	@Autowired
	protected RabbitMQService rabbitMQService;

	@Autowired
	protected MessageSource mMessageSource;

	@Autowired
	protected TbdHSDeNghiCapGiayXn1Service mTbdHSDeNghiCapGiayXn1Service;

	@Autowired
	protected TbdThongTinCoSoSX1Service mTbdThongTinCoSoSX1Service;

	@Autowired
	protected TbsDistrict1Service mTbsDistrict1Service;

	@Autowired
	protected TbdGXNThongTinCoSoSX1Service mTbdGXNThongTinCoSoSX1Service;

	@Autowired
	protected TbdGXNThongTinPheLieu1Service mTbdGXNThongTinPheLieu1Service;

	@Autowired
	protected TbdKetQuaXuLy1Service mTbdKetQuaXuLy1Service;

	@Autowired
	protected TbdCapGiayXacNhan1Service mTbdCapGiayXacNhan1Service;

	@Autowired
	protected TbdYeuCauRutHS1Service mTbdYeuCauRutHS1Service;

	@Autowired
	protected TbsProvince1Service mTbsProvince1Service;

	@Autowired
	protected TbsWard1Service mTbsWard1Service;

	@Autowired
	protected TbsThongTinCoSoSX1Service mTbsThongTinCoSoSX1Service;

	@Autowired
	protected TbsStatus1Service mTbsStatusService;

	@Autowired
	protected TbsPheLieu1Service mTbsPheLieu1Service;

	@Autowired
	protected TbdThanhToan1Service mTbdThanhToan1Service;

	@Autowired
	protected TbdThongTinPheLieu1Service mTbdThongTinPheLieu1Service;

	@Autowired
	protected TbsCoQuanXuLy1Service mTbsCoQuanXuLy1Service;

	@Autowired
	protected TbdTepTin1Service mTbdTepTin1Service;

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
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_SACH_HO_SO }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachHoSo(HttpServletRequest request, @RequestBody TbdHSDeNghiCapGiayXn1 form) {

		try {

			TbdHSDeNghiCapGiayXn1SearchItem item = new TbdHSDeNghiCapGiayXn1SearchItem();

			item.setFiloaithutuc(AppCommon.getLoaiThuTuc(request));

			item.setFiidhs(-1);

			item.setFixoa(0);

			item.setFitrangthai(-1);

			item = makeTbdHSDeNghiCapGiayXn1SearchItem(form, item);

			long totalTbdHSDeNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.count(item);

			int pageIndex = form.getPageIndex() < 1 ? 1 : form.getPageIndex();

			item.setPageIndex(pageIndex);

			item.setPageSize(AppKeyConstant.Page.PAGE_SIZE);

			List<HoSo1> tbdHSDeNghiCapGiayXn1s = mTbdHSDeNghiCapGiayXn1Service.search(item);

			// gan gia tri cho so thu tu cua ban ghi
			if (tbdHSDeNghiCapGiayXn1s != null) {

				for (int i = 0; i < tbdHSDeNghiCapGiayXn1s.size(); i++) {

					HoSo1 capGiayXn1 = tbdHSDeNghiCapGiayXn1s.get(i);

					capGiayXn1.setSoThuTu((pageIndex - 1) * AppKeyConstant.Page.PAGE_SIZE + i + 1);

					capGiayXn1.setTotal((int) totalTbdHSDeNghiCapGiayXn1);

				}
			}

			Object data = tbdHSDeNghiCapGiayXn1s;

			return createResponseEntity(data, totalTbdHSDeNghiCapGiayXn1, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), true, HttpStatus.OK);
	}

	private TbdHSDeNghiCapGiayXn1SearchItem makeTbdHSDeNghiCapGiayXn1SearchItem(TbdHSDeNghiCapGiayXn1 form, TbdHSDeNghiCapGiayXn1SearchItem item) {

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

	private static final String SELECT_DEFAULT_LABEL_MESSAGE = "monre.01.select.label-default";

	private static final String SELECT_BOX_LABEL_KEY = "monre.01.select.label-default";

	/**
	 * Lay danh sach tat ca trang thai
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_SACH_TAT_CA_TRANG_THAI }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachTrangThai(HttpServletRequest request) {

		try {

			List<TbsStatus1> dsStatus1s = new ArrayList<>();

			TbsStatus1 pl0 = new TbsStatus1();

			pl0.setTenTrangThai(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

			pl0.setIdTrangThai(-1);

			dsStatus1s.add(pl0);

			List<TbsStatus1> tbsStatus1s = mTbsStatusService.getTbsStatus1s();

			if (tbsStatus1s != null) dsStatus1s.addAll(tbsStatus1s);

			Object data = dsStatus1s;

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach phe lieu dung chung
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_SACH_TAT_CA_PHE_LIEU }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachPheLieu(HttpServletRequest request) {

		try {

			Object data = getDanhMucPheLieu(request);

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_SACH_TAT_CA_CO_QUAN_XU_LY }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachCoQuanXuLy(HttpServletRequest request) {

		try {

			List<TbsCoQuanXuLy1> dsTbsCoQuanXuLy1 = new ArrayList<>();

			TbsCoQuanXuLy1 pl0 = new TbsCoQuanXuLy1();

			pl0.setMaCoQuan("-1");

			pl0.setTenCoQuan(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

			dsTbsCoQuanXuLy1.add(pl0);

			List<TbsCoQuanXuLy1> tbsPheLieu1s = mTbsCoQuanXuLy1Service.getTbsCoQuanXuLy1s();

			if (tbsPheLieu1s != null) {

				dsTbsCoQuanXuLy1.addAll(tbsPheLieu1s);
			}

			Object data = dsTbsCoQuanXuLy1;

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.LAY_THONG_TIN_HO_SO }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layThongTinHoSo(HttpServletRequest request) {

		long idHS = NumberUtil.toLong(request.getParameter("idHS"));

		try {

			TbdHSDeNghiCapGiayXn1 capGiayXn1 = new TbdHSDeNghiCapGiayXn1();

			if (idHS > 0) {

				capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(idHS);

			}

			Object data = capGiayXn1;

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);

			return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
		}

	}

	/**
	 * Lay danh sach quan huyen theo ma thanh pho
	 * 
	 * @param request
	 * @param maTinhThanhPho
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_QUAN_HUYEN }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhQuanHuyen(HttpServletRequest request, @PathVariable("id") String maTinhThanhPho) {

		try {

			TbsDistrict1 pl0 = new TbsDistrict1();
			pl0.setDistrictName(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

			pl0.setDistrictId("-1");

			List<TbsDistrict1> district1s = new ArrayList<>();

			district1s.add(pl0);

			if (!"-1".equals(maTinhThanhPho)) {

				List<TbsDistrict1> findAll = mTbsDistrict1Service.findByProvinceId(maTinhThanhPho);

				if (findAll != null) district1s.addAll(findAll);
			}

			Object data = district1s;

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tinh thanh pho
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_TINH_THANH_PHO }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachTinhThanhPho(HttpServletRequest request) {

		try {

			TbsProvince1 pl0 = new TbsProvince1();

			pl0.setProvinceName(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

			pl0.setProvinceId("-1");

			List<TbsProvince1> tbsProvince1s = new ArrayList<>();

			tbsProvince1s.add(pl0);

			List<TbsProvince1> tbsProvince1s2 = mTbsProvince1Service.getTbsProvince1s();

			if (tbsProvince1s2 != null) tbsProvince1s.addAll(tbsProvince1s2);

			Object data = tbsProvince1s;

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach cac xa phuong theo ma huyen
	 * 
	 * @param request
	 * @param maHuyen
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_XA_PHUONG }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachXaPhuong(HttpServletRequest request, @PathVariable("maHuyen") String maHuyen) {

		try {

			List<TbsWard1> tbsWard1s = new ArrayList<>();

			TbsWard1 pl0 = new TbsWard1();
			pl0.setWardName(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

			pl0.setWardId("-1");

			tbsWard1s.add(pl0);

			if (!"-1".equals(maHuyen)) {

				List<TbsWard1> findAll = mTbsWard1Service.findByDistrictId(maHuyen);

				if (findAll != null) tbsWard1s.addAll(findAll);
			}

			Object data = tbsWard1s;

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);
			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach thong bao thu phi theo ho so id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.THONG_BAO_THU_PHI_URL }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> layThongBaoThuPhi(@PathVariable("id") long id, HttpServletRequest request) {

		List<TbdThanhToan1> kqXuLy = null;
		DecimalFormat formatter = new DecimalFormat("#,###.###");

		try {
			TbdThanhToan1SearchItem item = new TbdThanhToan1SearchItem();
			item.setFiidhs(id);
			item.setPageSize(1);

			kqXuLy = mTbdThanhToan1Service.searchTbdThanhToan1s(item);

			if (kqXuLy != null && !kqXuLy.isEmpty()) {
				TbdThanhToan1 tt = kqXuLy.get(0);
				tt.setStrLePhi(formatter.format(tt.getLePhi()) + " " + mMessageSource.getMessage("monre.01.vnd", null, request.getLocale()));
				return createResponseEntity(kqXuLy.get(0), getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			logError(e);
			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay thong tin giay xac nhan theo ho so id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.XEM_GIAY_XAC_NHAN_URL }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> xemGiayXacNhan(@PathVariable("id") long id) {

		List<TbdCapGiayXacNhan1> listTbdGiayXacNhan = null;
		TbdCapGiayXacNhan1 capGiayXacNhan = null;

		List<TbdGXNThongTinCoSoSX1> listCoSoSX = null;
		List<TbdGXNThongTinPheLieu1> listPheLieu = null;

		TbdXemGiayXacNhan giayXacNhan = new TbdXemGiayXacNhan();

		try {

			listTbdGiayXacNhan = mTbdCapGiayXacNhan1Service.findByIdHSOrderByIdGxnDesc(id);

			if (listTbdGiayXacNhan != null && !listTbdGiayXacNhan.isEmpty()) {

				capGiayXacNhan = listTbdGiayXacNhan.get(0);
			}

			if (capGiayXacNhan != null) listCoSoSX = mTbdGXNThongTinCoSoSX1Service.findByIdGXN(capGiayXacNhan.getIdGxn());

			if (capGiayXacNhan != null) listPheLieu = mTbdGXNThongTinPheLieu1Service.findByIdGXN(capGiayXacNhan.getIdGxn());

		} catch (Exception e) {

			logError(e);
			pushLog(e);
		}

		giayXacNhan.setTbdCapGiayXacNhan(capGiayXacNhan);
		giayXacNhan.setTbdGXNThongTinCoSoSX(listCoSoSX);
		giayXacNhan.setTbdGXNThongTinPheLieu(listPheLieu);

		return new ResponseEntity<>(giayXacNhan, HttpStatus.OK);
	}

	/**
	 * @param idGXN
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.LAY_THONG_TIN_CO_SO_SAN_XUAT_THEO_SO_GIAY_XAC_NHAN_URL }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> layThongTinCoSoSanXuatTheoGiayXacNhan(@PathVariable("idGXN") long idGXN, HttpServletRequest request) {

		try {

			UserInfo userInfo = LoginUtil.getUserInfo();

			if (userInfo == null) {

				return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
			}

			Object data = mTbdGXNThongTinCoSoSX1Service.findByIdGXN(idGXN);

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
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.LAY_THONG_TIN_PHE_LIEU_THEO_SO_GIAY_XAC_NHAN_URL }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> layThongTinPheLieuTheoGiayXacNhan(@PathVariable("idGXN") long idGXN, HttpServletRequest request) {

		try {

			UserInfo userInfo = LoginUtil.getUserInfo();

			if (userInfo == null) {

				return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
			}

			Object data = mTbdGXNThongTinPheLieu1Service.findByIdGXN(idGXN);

			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay thong tin giay xac nhan cap lai
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.LAY_THONG_TIN_SO_GIAY_XAC_NHAN_URL }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> layThongTinGiayXacNhanTheoSoGXN(@PathVariable("idHS") long idHS, @PathVariable("soGXN") String soGiayXN, HttpServletRequest request) {

		try {

			UserInfo userInfo = LoginUtil.getUserInfo();

			if (userInfo == null) {

				return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
			}

			Object data = null;
			if (idHS > 0) {

				List<TbdCapGiayXacNhan1> listTbdGiayXacNhan = mTbdCapGiayXacNhan1Service.findByIdHSOrderByIdGxnDesc(idHS);

				if (listTbdGiayXacNhan != null && !listTbdGiayXacNhan.isEmpty()) data = listTbdGiayXacNhan.get(0);
			} else {

				LOGGER.info("Hinh thuc = {}", AppCommon.getHinhThuc(request));
				LOGGER.info("So GXN = {}", soGiayXN);

				List<TbdCapGiayXacNhan1> listTbdGiayXacNhan = mTbdCapGiayXacNhan1Service.findBySoGiayXNAndHinhThucAndMaSoThueOrderByIdGxnDesc(soGiayXN, AppCommon.getHinhThuc(request), userInfo.getMaSoThue());
				if (listTbdGiayXacNhan != null && !listTbdGiayXacNhan.isEmpty()) data = listTbdGiayXacNhan.get(0);
			}

			if (data != null) {

				return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
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
			form.setDanhMucPheLieuList(getDanhMucPheLieu(request));
			TbdHSDeNghiCapGiayXn1 deNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(idHS);

			if (deNghiCapGiayXn1 != null) {

				form = ConvertToObjectUtil.convertTo(deNghiCapGiayXn1, form);
				form.setNgayCapDateFormat(deNghiCapGiayXn1.getNgayCap());
				form.setNgayHetHanDateFormat(deNghiCapGiayXn1.getNgayHetHan());
				form.setNgayCapGCNDKKDDateFormat(deNghiCapGiayXn1.getNgayCapGCNDKKD());
				form.setCoQuanXuLyList(getCoQuanXuLy(request));
				form.setCoSoSanXuatList(getCoSoSanXuat(idHS));
				form.setDanhMucPheLieuList(getDanhMucPheLieu(request));
				form.setPheLieuList(layPheLieus(request, idHS));
				form.setTepDinhKemList(mTbdTepTin1Service.findByIdHSOrderByLoaiTepTinAsc(idHS));

				return createResponseEntity(form, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {
			logError(e);
			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	private List<TbsPheLieu1> getDanhMucPheLieu(HttpServletRequest request) {
		List<TbsPheLieu1> dsLieu1s = new ArrayList<>();

		TbsPheLieu1 pl0 = new TbsPheLieu1();

		pl0.setMaHS(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

		pl0.setTenPheLieu(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

		pl0.setTenPheLieu2("-1");

		pl0.setMaHS2("-1");

		dsLieu1s.add(pl0);

		TbsPheLieu1SearchItem pheLieu1SearchItem = new TbsPheLieu1SearchItem();

		pheLieu1SearchItem.setOrderBy("FitenphelieuASC");

		List<TbsPheLieu1> tbsPheLieu1s = mTbsPheLieu1Service.searchTbsPheLieu1s(pheLieu1SearchItem);

		if (tbsPheLieu1s != null) {

			for (TbsPheLieu1 item : tbsPheLieu1s) {

				item.setTenPheLieu2(item.getMaHS());

				item.setMaHS2(item.getMaHS());
			}

			dsLieu1s.addAll(tbsPheLieu1s);
		}

		return dsLieu1s;

	}

	private List<TbdThongTinCoSoSX1> getCoSoSanXuat(long idHS) {
		return mTbdThongTinCoSoSX1Service.findByIdHSOrderByTbdThongTinCoSoSXIdAsc(idHS);
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
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_SACH_PHE_LIEU_THEO_HO_SO + "/{idHS}" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachPheLieuTheoHoSo(HttpServletRequest request, @PathVariable("idHS") long idHS) {

		try {

			Object data = layPheLieus(request, idHS);
			return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	private List<TbdThongTinPheLieu1> layPheLieus(HttpServletRequest request, long idHS) {
		List<TbdThongTinPheLieu1> thongTinPheLieu1s = mTbdThongTinPheLieu1Service.findByIdHSOrderByIdPLAsc(idHS);

		if (thongTinPheLieu1s != null) {
			return thongTinPheLieu1s;
		}
		return Collections.emptyList();
	}

	/**
	 * Lay danh sach co so san xuat theo ho so
	 * 
	 * @param request
	 * @param idHS
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_SACH_CO_SO_SAN_XUAT_THEO_HO_SO + "/{idHS}" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachCoSoSanXuatTheoHoSo(HttpServletRequest request, @PathVariable("idHS") long idHS) {

		try {
			if (idHS > 0) {
				Object data = mTbdThongTinCoSoSX1Service.findByIdHSOrderByTbdThongTinCoSoSXIdAsc(idHS);
				return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
			}
		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	/**
	 * Lay danh sach tep tin theo ho so
	 * 
	 * @param request
	 * @param idHS
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { AppViewThuTuc01Constant.ViewURL.DANH_SACH_TEP_TIN_THEO_HO_SO }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> layDanhSachTepTinTheoHoSo(HttpServletRequest request, @PathVariable("id") long idHS) {

		try {

			if (idHS > 0) {
				Object data = mTbdTepTin1Service.findByIdHSOrderByLoaiTepTinAsc(idHS);
				return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
			}

		} catch (Exception e) {

			logError(e);

			pushLog(e);
		}

		return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
	}

	@RequestMapping(value = AppViewThuTuc01Constant.ViewURL.DOWNLOAD_GIAY_XAC_NHAN_URL, method = RequestMethod.GET)
	public void downloadFileGiayXacNhan(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) {

		try {

			List<TbdCapGiayXacNhan1> capGiayXacNhan1s = mTbdCapGiayXacNhan1Service.findByIdHSOrderByIdGxnDesc(id);

			if (capGiayXacNhan1s == null || capGiayXacNhan1s.isEmpty()) return;

			TbdCapGiayXacNhan1 tbdCapGiayXacNhan1 = capGiayXacNhan1s.get(0);

			if (tbdCapGiayXacNhan1 != null) {
				RabbitMQInfo mqInfo = getRabbitMQ();
				String uri = getFullUri("/monre/01/download2/");

				String tenTapTin = tbdCapGiayXacNhan1.getTenTepTin();
				String fullPath = tbdCapGiayXacNhan1.getLinkGiayXN();
				String filePath;
				String fileName;
				int pos = fullPath.lastIndexOf('/');
				if (pos == 0) {
					filePath = fullPath;
					fileName = tenTapTin;
				} else {
					filePath = fullPath.substring(0, pos);
					fileName = fullPath.substring(pos + 1);
				}
				byte[] fileContent = downloadFile(uri, filePath, fileName, mqInfo);
				if (fileContent == null) fileContent = new byte[0];
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment;filename=" + tenTapTin);
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
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
			b = null;
			logError(ex);
			pushLog(ex);
		}

		return b;
	}

	protected void logInfor(String message) {

		LOGGER.info(message);
	}

	protected void logError(Exception e) {

		StackTraceElement[] stackTrace = e.getStackTrace();
		if ((stackTrace != null) && (stackTrace.length > 1)) {
			StackTraceElement stElement = stackTrace[0];
			String clzName = stElement.getClassName();
			String methodName = stElement.getMethodName();
			String errorTitle = "ERROR:>> [" + clzName + "][" + methodName + "]";
			LOGGER.error(errorTitle, e);
		} else {
			String clzName = Monre01Api.class.getName();
			String methodName = "";
			String errorTitle = "ERROR:>> [" + clzName + "][" + methodName + "]";
			LOGGER.error(errorTitle, e);
		}

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

			String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName() + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

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
