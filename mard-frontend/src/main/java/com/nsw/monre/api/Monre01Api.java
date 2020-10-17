package com.nsw.monre.api;

import java.net.URI;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.common.model.ResponseDownload;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.monre.common.CertificateUtils;
import com.nsw.monre.common.ResponseMessage;
import com.nsw.monre.common.SendUtil;
import com.nsw.monre.p01.constant.AppKeyConstant;
import com.nsw.monre.p01.constant.AppViewThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.model.CoSoSanXuatEditForm;
import com.nsw.monre.p01.model.HoSo1;
import com.nsw.monre.p01.model.HoSoEditForm;
import com.nsw.monre.p01.model.PheLieuEditForm;
import com.nsw.monre.p01.model.ResponseJson;
import com.nsw.monre.p01.model.SendMessage;
import com.nsw.monre.p01.model.TbdCapGiayXacNhan1;
import com.nsw.monre.p01.model.TbdGXNThongTinCoSoSX1;
import com.nsw.monre.p01.model.TbdGXNThongTinPheLieu1;
import com.nsw.monre.p01.model.TbdHSDeNghiCapGiayXn1;
import com.nsw.monre.p01.model.TbdKetQuaXuLy1;
import com.nsw.monre.p01.model.TbdTepTin1;
import com.nsw.monre.p01.model.TbdThanhToan1;
import com.nsw.monre.p01.model.TbdThongTinCoSoSX1;
import com.nsw.monre.p01.model.TbdThongTinPheLieu1;
import com.nsw.monre.p01.model.TbdXemGiayXacNhan;
import com.nsw.monre.p01.model.TbdYeuCauRutHS1;
import com.nsw.monre.p01.model.TbsCoQuanXuLy1;
import com.nsw.monre.p01.model.TbsDistrict1;
import com.nsw.monre.p01.model.TbsPheLieu1;
import com.nsw.monre.p01.model.TbsProvince1;
import com.nsw.monre.p01.model.TbsStatus1;
import com.nsw.monre.p01.model.TbsThongTinCoSoSX1;
import com.nsw.monre.p01.model.TbsWard1;
import com.nsw.monre.p01.model.UserInfo;
import com.nsw.monre.p01.searchitem.TbdHSDeNghiCapGiayXn1SearchItem;
import com.nsw.monre.p01.searchitem.TbdKetQuaXuLy1SearchItem;
import com.nsw.monre.p01.searchitem.TbdTepTin1SearchItem;
import com.nsw.monre.p01.searchitem.TbdThanhToan1SearchItem;
import com.nsw.monre.p01.searchitem.TbdThongTinCoSoSX1SearchItem;
import com.nsw.monre.p01.searchitem.TbsPheLieu1SearchItem;
import com.nsw.monre.p01.searchitem.TbsThongTinCoSoSX1SearchItem;
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
import com.nsw.monre.p01.util.DateUtil;
import com.nsw.monre.p01.util.LoginUtil;
import com.nsw.monre.p01.util.NumberUtil;
import com.nsw.monre.p01.util.UIDUtil;
import com.nsw.security.UserCustom;
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
@RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_01, AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_02, AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_03, AppViewThuTuc01Constant.ViewURL.URI_THU_TUC_04})
public class Monre01Api {

    private static final Logger LOGGER = LoggerFactory.getLogger(Monre01Api.class);

    private static final String CLASS_NAME = "Monre01Api";

    private static final String LICH_SU_XOA_CO_SO_SX_KEY = "monre.01.lich-su-tac-dong-tac-dong.xoa-co-so-san-xuat-theo-ho-so-ho-so";

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

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_SACH_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachHoSo(HttpServletRequest request, @RequestBody TbdHSDeNghiCapGiayXn1 form) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            TbdHSDeNghiCapGiayXn1SearchItem item = new TbdHSDeNghiCapGiayXn1SearchItem();

            item.setFiloaithutuc(AppCommon.getLoaiThuTuc(request));

            item.setFiidhs(-1);

            item.setFixoa(0);

            item.setFitrangthai(-1);

            item.setFimasothue(LoginUtil.getUserInfo().getMaSoThue());

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

        return item;
    }

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.LAY_DANH_SACH_CO_SO_XUAT}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhMucCoSoSanXuat(HttpServletRequest request, @RequestBody TbsThongTinCoSoSX1 form) {

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            TbsThongTinCoSoSX1SearchItem searchItem = new TbsThongTinCoSoSX1SearchItem();

            searchItem.setFimanguoitao(userInfo.getMaSoThue());
            searchItem.setPageIndex(form.getPageIndex());
            searchItem.setPageSize(AppKeyConstant.Page.PAGE_SIZE_IN_POPUP);

            long total = mTbsThongTinCoSoSX1Service.countSearchTbsThongTinCoSoSX1(searchItem);

            List<TbsThongTinCoSoSX1> coSoSX1s = mTbsThongTinCoSoSX1Service.searchTbsThongTinCoSoSX1s(searchItem);

            if (coSoSX1s != null) {

                int i = 0;
                for (TbsThongTinCoSoSX1 item : coSoSX1s) {
                    item.setSoThuTu((form.getPageIndex() - 1) * AppKeyConstant.Page.PAGE_SIZE_IN_POPUP + i + 1);
                    i++;
                    checkTbsCoSo(form, item);
                }
            }
            Object data = coSoSX1s;

            return createResponseEntity(data, total, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), true, HttpStatus.OK);
    }

    private void checkTbsCoSo(TbsThongTinCoSoSX1 form, TbsThongTinCoSoSX1 item) {

        List<TbdThongTinCoSoSX1> findTbdThongTinCoSoSX1s = mTbdThongTinCoSoSX1Service.findByIdCS(item.getIdCS());

        if (findTbdThongTinCoSoSX1s == null || findTbdThongTinCoSoSX1s.isEmpty()) {
            item.setCanDelete(true);
            item.setCanUpdate(true);
            return;
        }

        int count = 0;
        for (TbdThongTinCoSoSX1 item2 : findTbdThongTinCoSoSX1s) {
            TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(item2.getIdHS());

            if (capGiayXn1 != null && capGiayXn1.getTrangThai() == AppKeyConstant.Status.TAO_MOI) {
                count++;
            }
        }
        if (count == findTbdThongTinCoSoSX1s.size()) {
            item.setCanUpdate(true);
        }
        if (form.getIdHS() > 0 && findTbdThongTinCoSoSX1s.size() == 1) {
            TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(findTbdThongTinCoSoSX1s.get(0).getIdHS());
            if (capGiayXn1 != null && capGiayXn1.getTrangThai() == AppKeyConstant.Status.TAO_MOI && form.getIdHS() == capGiayXn1.getIdHS()) {
                item.setCanDelete(true);
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.LAY_DANH_SACH_KET_QUA_XU_LY}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachKetQuaXuLy(HttpServletRequest request, @RequestBody TbdKetQuaXuLy1 form) {

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            TbdKetQuaXuLy1SearchItem searchItem = new TbdKetQuaXuLy1SearchItem();

            searchItem.setPageIndex(form.getPageIndex());

            searchItem.setFiidhs(form.getIdHS());

            searchItem.setPageSize(AppKeyConstant.Page.PAGE_SIZE_IN_POPUP);

            long total = mTbdKetQuaXuLy1Service.countSearchTbdKetQuaXuLy1(searchItem);

            List<TbdKetQuaXuLy1> ketQuaXuLy1s = mTbdKetQuaXuLy1Service.searchTbdKetQuaXuLy1s(searchItem);

            if (ketQuaXuLy1s != null) {
                int i = 0;
                for (TbdKetQuaXuLy1 item : ketQuaXuLy1s) {
                    item.setTotal((int) total);
                    item.setSoThuTu((form.getPageIndex() - 1) * AppKeyConstant.Page.PAGE_SIZE_IN_POPUP + i + 1);
                    item.setNgayXuLyDateFormat(DateUtil.getFormatDate("dd/MM/yyyy HH:mm:ss", item.getNgayXuLy()));
                    TbsStatus1 pTbsStatus1Id = mTbsStatusService.findByIdTrangThai(item.getTrangThai());
                    if (pTbsStatus1Id != null) {
                        item.setTenTrangThai(pTbsStatus1Id.getTenTrangThai());
                    }
                    i++;
                }
            }

            Object data = ketQuaXuLy1s;

            return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), true, HttpStatus.OK);
    }

    /**
     * Xoa co so san xuat theo id
     *
     * @param idHoSo
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.XOA_CO_SO_SAN_XUAT_URL}, method = RequestMethod.POST)
    public ResponseEntity<Object> xoaDanhMucCoSoSanXuat(@PathVariable("id") long id, @RequestBody TbsThongTinCoSoSX1 form, HttpServletRequest request) {

        UserInfo userInfo = LoginUtil.getUserInfo();

        if (userInfo.getMaSoThue() == null) {

            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
        }

        try {

            List<TbdThongTinCoSoSX1> thongTinCoSoSX1s = mTbdThongTinCoSoSX1Service.findByIdCS(id);

            if (thongTinCoSoSX1s == null || thongTinCoSoSX1s.isEmpty()) {

                Object data = mTbsThongTinCoSoSX1Service.deleteTbsThongTinCoSoSX1ById(id);

                return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
            } else {

                if (thongTinCoSoSX1s.size() == 1) {

                    boolean xoa = xoaDanhMucCoSo(thongTinCoSoSX1s.get(0).getIdHS(), id, form);
                    if (xoa) {
                        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
                    }
                }
            }

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);

    }

    private boolean xoaDanhMucCoSo(Long idHS, Long id, TbsThongTinCoSoSX1 form) {

        boolean xoa = false;
        TbdThongTinCoSoSX1 coSoSX1 = mTbdThongTinCoSoSX1Service.getTbdThongTinCoSoSX1(form.getTbdThongTinCoSoSXId());

        TbdHSDeNghiCapGiayXn1 capGiayXn2 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(idHS);

        if (coSoSX1 != null && capGiayXn2 != null) {

            TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(coSoSX1.getIdHS());

            if (capGiayXn1.getTrangThai() == AppKeyConstant.Status.TAO_MOI && capGiayXn1.getIdHS() == capGiayXn2.getIdHS()) {

                mTbdThongTinCoSoSX1Service.deleteTbdThongTinCoSoSX1ById(coSoSX1.getTbdThongTinCoSoSXId());

                xoa = mTbsThongTinCoSoSX1Service.deleteTbsThongTinCoSoSX1ById(id);
            }
        }
        return xoa;
    }

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.XOA_CO_SO_SAN_XUAT_THEO_HO_SO_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> xoaBoCoSoSanXuatTheoHoSo(@PathVariable("id") long id, HttpServletRequest request) {

        UserInfo userInfo = LoginUtil.getUserInfo();

        if (userInfo.getMaSoThue() == null) {

            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
        }

        try {

            TbdThongTinCoSoSX1 coSoSX1 = mTbdThongTinCoSoSX1Service.getTbdThongTinCoSoSX1(id);

            if (coSoSX1 == null) {
                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            long idHS = coSoSX1.getIdHS();
            boolean data = mTbdThongTinCoSoSX1Service.deleteTbdThongTinCoSoSX1ById(id);

            if (data) {

                TbdHSDeNghiCapGiayXn1 capGiayXn = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                saveHistoryCoSoSanXuat(request, capGiayXn, coSoSX1, LICH_SU_XOA_CO_SO_SX_KEY);
            }

            return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), data, HttpStatus.OK);

        } catch (Exception e) {

            logError(e);
            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);

    }

    private String validTbsThongTinCoSoSanXuat(HttpServletRequest request, TbsThongTinCoSoSX1 form) {

        String error = validRequiredTbsThongTinCoSoSanXuat(request, form);
        if (StringUtils.hasText(error)) {
            return error;
        }
        if (StringUtils.hasText(form.getEmail()) && form.getEmail().length() > 50) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.email.max-length", request.getLocale());
        }
        if (StringUtils.hasText(form.getFax()) && form.getFax().length() > 50) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.fax.max-length", request.getLocale());
        }
        if (StringUtils.hasText(form.getSoDienThoai()) && form.getSoDienThoai().length() > 50) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.soDienThoai.max-length", request.getLocale());
        }

        return "";
    }

    private String validRequiredTbsThongTinCoSoSanXuat(HttpServletRequest request, TbsThongTinCoSoSX1 form) {

        String error = validRequiredTbsThongTinCoSoSanXuat1(request, form);
        if (StringUtils.hasText(error)) {
            return error;
        }

        if (form.getMaXaPhuong().length() > 50) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.maXaPhuong.max-length", request.getLocale());
        }

        if (!StringUtils.hasText(form.getTenTinh())) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.tenTinh.null", request.getLocale());
        }
        if (form.getTenTinh().length() > 255) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.maTinh.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getTenHuyen())) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.tenHuyen.null", request.getLocale());
        }
        if (form.getTenHuyen().length() > 255) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.tenHuyen.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getTenXaPhuong())) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.tenXaPhuong.null", request.getLocale());
        }
        if (form.getTenXaPhuong().length() > 255) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.maXaPhuong.max-length", request.getLocale());
        }
        return "";
    }

    private String validRequiredTbsThongTinCoSoSanXuat1(HttpServletRequest request, TbsThongTinCoSoSX1 form) {
        if (!StringUtils.hasText(form.getTenCoSo())) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.tenCoSo.null", request.getLocale());
        }
        if (form.getTenCoSo().length() > 250) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.tenCoSo.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getDiaChiCoSo())) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.diaChiCoSo.null", request.getLocale());
        }
        if (form.getDiaChiCoSo().length() > 250) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.diaChiCoSo.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getMaTinh()) || "-1".equals(form.getMaTinh())) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.maTinh.null", request.getLocale());
        }
        if (form.getMaTinh().length() > 50) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.maTinh.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getMaHuyen()) || "-1".equals(form.getMaHuyen())) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.maHuyen.null", request.getLocale());
        }
        if (form.getMaHuyen().length() > 50) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.maHuyen.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getMaXaPhuong()) || "-1".equals(form.getMaXaPhuong())) {
            return getMessage("error.monre.01.TbsThongTinCoSoSX1.maXaPhuong.null", request.getLocale());
        }
        return "";
    }

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.CAP_NHAT_CO_SO_XUAT}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> capNhatDanhMuchCoSoSanXuat(@RequestBody TbsThongTinCoSoSX1 form, HttpServletRequest request) {

        UserInfo userInfo = LoginUtil.getUserInfo();

        if (userInfo.getMaSoThue() == null) {

            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
        }
        String error = validTbsThongTinCoSoSanXuat(request, form);

        if (StringUtils.hasText(error)) {
            return createResponseEntity(null, error, false, HttpStatus.OK);
        }

        try {
            form.setMaNguoiTao(userInfo.getMaSoThue());
            TbsProvince1 findTbsProvince1 = mTbsProvince1Service.getTbsProvince1(form.getMaTinh());
            TbsDistrict1 findTbsDistrict1 = mTbsDistrict1Service.getTbsDistrict1(form.getMaHuyen());
            TbsWard1 findTbsWard1 = mTbsWard1Service.getTbsWard1(form.getMaXaPhuong());
            if (findTbsProvince1 == null || findTbsDistrict1 == null || findTbsWard1 == null) {
                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            form.setMaTinh(findTbsProvince1.getProvinceId());
            form.setTenTinh(findTbsProvince1.getProvinceName());
            form.setTenHuyen(findTbsDistrict1.getDistrictName());
            form.setMaHuyen(findTbsDistrict1.getDistrictId());
            form.setMaXaPhuong(findTbsWard1.getWardId());
            form.setTenXaPhuong(findTbsWard1.getWardName());
            boolean canUpdateHoSo = form.isCanUpdate();
            long getTbdThongTinCoSoSXId = form.getTbdThongTinCoSoSXId();
            if (form.getIdCS() > 0) {
                capNhatCoSoSX(form);
            } else {
                form = mTbsThongTinCoSoSX1Service.saveTbsThongTinCoSoSX1(form);
            }

            if (canUpdateHoSo && getTbdThongTinCoSoSXId > 0) {
                capNhatCoSoCuaHoSo(getTbdThongTinCoSoSXId, form);
            }

            return createResponseEntity(form, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

        } catch (Exception e) {

            logError(e);
            pushLog(e);

            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
        }
    }

    private void capNhatCoSoCuaHoSo(long id, TbsThongTinCoSoSX1 form) {

        TbdThongTinCoSoSX1 tbdThongTinCoSoSX1 = mTbdThongTinCoSoSX1Service.getTbdThongTinCoSoSX1(id);

        if (tbdThongTinCoSoSX1 != null) {

            tbdThongTinCoSoSX1.setMaTinh(form.getMaTinh());

            tbdThongTinCoSoSX1.setTenTinh(form.getTenTinh());

            tbdThongTinCoSoSX1.setMaHuyen(form.getMaHuyen());

            tbdThongTinCoSoSX1.setTenHuyen(form.getTenHuyen());

            tbdThongTinCoSoSX1.setTenXaPhuong(form.getTenXaPhuong());

            tbdThongTinCoSoSX1.setMaXaPhuong(form.getMaXaPhuong());

            tbdThongTinCoSoSX1.setEmail(form.getEmail());

            tbdThongTinCoSoSX1.setTenCoSo(form.getTenCoSo());

            tbdThongTinCoSoSX1.setDiaChiCoSo(form.getDiaChiCoSo());

            tbdThongTinCoSoSX1.setSoDienThoai(form.getSoDienThoai());

            tbdThongTinCoSoSX1.setFax(form.getFax());

            mTbdThongTinCoSoSX1Service.updateTbdThongTinCoSoSX1(id, tbdThongTinCoSoSX1);
        }
    }

    private void capNhatCoSoSX(TbsThongTinCoSoSX1 form) {

        boolean canUpdateHoSo = form.isCanUpdate();

        List<TbdThongTinCoSoSX1> findTbdThongTinCoSoSX1s = mTbdThongTinCoSoSX1Service.findByIdCS(form.getIdCS());

        if (findTbdThongTinCoSoSX1s != null) {
            int count = 0;

            for (TbdThongTinCoSoSX1 item2 : findTbdThongTinCoSoSX1s) {

                TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(item2.getIdHS());

                if (capGiayXn1.getTrangThai() == AppKeyConstant.Status.TAO_MOI) {

                    count++;
                }
            }

            canUpdateHoSo = findTbdThongTinCoSoSX1s.size() == count;
        }

        if (!canUpdateHoSo) {

            return;
        }

        form = mTbsThongTinCoSoSX1Service.updateTbsThongTinCoSoSX1(form.getIdCS(), form);

        findTbdThongTinCoSoSX1s = mTbdThongTinCoSoSX1Service.findByIdCS(form.getIdCS());

        if (findTbdThongTinCoSoSX1s != null) {

            for (TbdThongTinCoSoSX1 item : findTbdThongTinCoSoSX1s) {

                item = ConvertToObjectUtil.convertTo(form, item);

                mTbdThongTinCoSoSX1Service.updateTbdThongTinCoSoSX1(item.getTbdThongTinCoSoSXId(), item);
            }
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.CAP_NHAT_PHE_LIEU_THEO_HS}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> capNhatPheLieuTheoHoSo(@RequestBody PheLieuEditForm form, HttpServletRequest request) {

        UserInfo userInfo = LoginUtil.getUserInfo();

        if (userInfo.getMaSoThue() == null || form.getIdHS() < 1) {

            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
        }

        try {

            if (form.getIdHS() > 0) {
                TbdHSDeNghiCapGiayXn1 capGiayXn = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(form.getIdHS());
                List<PheLieuEditForm> pheLieuEditForms = new ArrayList<>();
                pheLieuEditForms.add(form);
                if (capGiayXn != null) {
                    Object errorMesage = savePheLieu(request, capGiayXn, pheLieuEditForms);
                    if (errorMesage != null && errorMesage instanceof String) {
                        return createResponseEntity(null, (String) errorMesage, false, HttpStatus.OK);
                    } else if (errorMesage instanceof List) {
                        List<Object> data = (List) errorMesage;
                        return createResponseEntity(data.get(0), getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

                    }
                }
            }

        } catch (Exception e) {

            logError(e);

            pushLog(e);

        }
        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);

    }

    @SuppressWarnings("unused")
    private ResponseEntity<Object> luuThongTinDanhMucCoSoSX(HttpServletRequest request, TbsThongTinCoSoSX1 form) {

        UserInfo userInfo = LoginUtil.getUserInfo();

        String error = validTbsThongTinCoSoSanXuat(request, form);

        if (StringUtils.hasText(error)) {
            return createResponseEntity(null, error, false, HttpStatus.OK);
        }

        try {

            form.setMaNguoiTao(userInfo.getMaSoThue());

            TbsProvince1 findTbsProvince1 = mTbsProvince1Service.getTbsProvince1(form.getMaTinh());

            TbsDistrict1 findTbsDistrict1 = mTbsDistrict1Service.getTbsDistrict1(form.getMaHuyen());

            TbsWard1 findTbsWard1 = mTbsWard1Service.getTbsWard1(form.getMaXaPhuong());

            if (findTbsProvince1 == null || findTbsDistrict1 == null || findTbsWard1 == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            form.setMaTinh(findTbsProvince1.getProvinceId());

            form.setTenTinh(findTbsProvince1.getProvinceName());

            form.setTenHuyen(findTbsDistrict1.getDistrictName());

            form.setMaHuyen(findTbsDistrict1.getDistrictId());

            form.setMaXaPhuong(findTbsWard1.getWardId());

            form.setTenXaPhuong(findTbsWard1.getWardName());

            boolean canUpdateHoSo = form.isCanUpdate();

            long getTbdThongTinCoSoSXId = form.getTbdThongTinCoSoSXId();

            if (form.getIdCS() > 0) {

                form = mTbsThongTinCoSoSX1Service.updateTbsThongTinCoSoSX1(form.getIdCS(), form);

                List<TbdThongTinCoSoSX1> findTbdThongTinCoSoSX1s = mTbdThongTinCoSoSX1Service.findByIdCS(form.getIdCS());

                if (findTbdThongTinCoSoSX1s != null) {

                    for (TbdThongTinCoSoSX1 item : findTbdThongTinCoSoSX1s) {

                        item = ConvertToObjectUtil.convertTo(form, item);

                        mTbdThongTinCoSoSX1Service.updateTbdThongTinCoSoSX1(item.getTbdThongTinCoSoSXId(), item);
                    }
                }

            } else {

                form = mTbsThongTinCoSoSX1Service.saveTbsThongTinCoSoSX1(form);
            }

            // cap nhat lai co so san xuat theo ho so neu ho so nay dang o trang thai = 0
            // (Tao moi)
            if (canUpdateHoSo && getTbdThongTinCoSoSXId > 0) {

                TbdThongTinCoSoSX1 tbdThongTinCoSoSX1 = mTbdThongTinCoSoSX1Service.getTbdThongTinCoSoSX1(getTbdThongTinCoSoSXId);

                if (tbdThongTinCoSoSX1 != null) {

                    tbdThongTinCoSoSX1.setMaTinh(form.getMaTinh());

                    tbdThongTinCoSoSX1.setTenTinh(form.getTenTinh());

                    tbdThongTinCoSoSX1.setMaHuyen(form.getMaHuyen());

                    tbdThongTinCoSoSX1.setTenHuyen(form.getTenHuyen());

                    tbdThongTinCoSoSX1.setTenXaPhuong(form.getTenXaPhuong());

                    tbdThongTinCoSoSX1.setMaXaPhuong(form.getMaXaPhuong());

                    tbdThongTinCoSoSX1.setEmail(form.getEmail());

                    tbdThongTinCoSoSX1.setTenCoSo(form.getTenCoSo());

                    tbdThongTinCoSoSX1.setDiaChiCoSo(form.getDiaChiCoSo());

                    tbdThongTinCoSoSX1.setSoDienThoai(form.getSoDienThoai());

                    tbdThongTinCoSoSX1.setFax(form.getFax());

                    mTbdThongTinCoSoSX1Service.updateTbdThongTinCoSoSX1(getTbdThongTinCoSoSXId, tbdThongTinCoSoSX1);
                }
            }

            return createResponseEntity(form, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

        } catch (Exception e) {

            logError(e);

            pushLog(e);

            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
        }

    }

    private static final String SELECT_DEFAULT_LABEL_MESSAGE = "monre.01.select.label-default";

    private static final String SELECT_BOX_LABEL_KEY = "monre.01.select.label-default";

    private static final String SEND_NOT_OK = "sendNotOkMessage";

    /**
     * Lay danh sach tat ca trang thai
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_SACH_TAT_CA_TRANG_THAI}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachTrangThai(HttpServletRequest request) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            List<TbsStatus1> dsStatus1s = new ArrayList<>();

            TbsStatus1 pl0 = new TbsStatus1();

            pl0.setTenTrangThai(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

            pl0.setIdTrangThai(-1);

            dsStatus1s.add(pl0);

            List<TbsStatus1> tbsStatus1s = mTbsStatusService.getTbsStatus1s();

            if (tbsStatus1s != null) {
                dsStatus1s.addAll(tbsStatus1s);
            }

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
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_SACH_TAT_CA_PHE_LIEU}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachPheLieu(HttpServletRequest request) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
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
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_SACH_TAT_CA_CO_QUAN_XU_LY}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachCoQuanXuLy(HttpServletRequest request) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
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
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.LAY_THONG_TIN_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layThongTinHoSo(HttpServletRequest request) {

        long idHS = NumberUtil.toLong(request.getParameter("idHS"));

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            TbdHSDeNghiCapGiayXn1 capGiayXn1 = new TbdHSDeNghiCapGiayXn1();

            if (idHS > 0) {

                capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

            }

            ConvertToObjectUtil.convertTo(LoginUtil.getUserInfo(), capGiayXn1);

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
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_QUAN_HUYEN}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhQuanHuyen(HttpServletRequest request, @PathVariable("id") String maTinhThanhPho) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            TbsDistrict1 pl0 = new TbsDistrict1();
            pl0.setDistrictName(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

            pl0.setDistrictId("-1");

            List<TbsDistrict1> district1s = new ArrayList<>();

            district1s.add(pl0);

            if (!"-1".equals(maTinhThanhPho)) {

                List<TbsDistrict1> findAll = mTbsDistrict1Service.findByProvinceId(maTinhThanhPho);

                if (findAll != null) {
                    district1s.addAll(findAll);
                }
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
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_TINH_THANH_PHO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachTinhThanhPho(HttpServletRequest request) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            TbsProvince1 pl0 = new TbsProvince1();

            pl0.setProvinceName(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

            pl0.setProvinceId("-1");

            List<TbsProvince1> tbsProvince1s = new ArrayList<>();

            tbsProvince1s.add(pl0);

            List<TbsProvince1> tbsProvince1s2 = mTbsProvince1Service.getTbsProvince1s();

            if (tbsProvince1s2 != null) {
                tbsProvince1s.addAll(tbsProvince1s2);
            }

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
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_XA_PHUONG}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachXaPhuong(HttpServletRequest request, @PathVariable("maHuyen") String maHuyen) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            List<TbsWard1> tbsWard1s = new ArrayList<>();

            TbsWard1 pl0 = new TbsWard1();
            pl0.setWardName(getMessage(SELECT_DEFAULT_LABEL_MESSAGE, request.getLocale()));

            pl0.setWardId("-1");

            tbsWard1s.add(pl0);

            if (!"-1".equals(maHuyen)) {

                List<TbsWard1> findAll = mTbsWard1Service.findByDistrictId(maHuyen);

                if (findAll != null) {
                    tbsWard1s.addAll(findAll);
                }
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
     * @param idHoSo
     * @return
     */
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.THONG_BAO_THU_PHI_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> layThongBaoThuPhi(@PathVariable("id") long id, HttpServletRequest request) {

        List<TbdThanhToan1> kqXuLy = null;
        DecimalFormat formatter = new DecimalFormat("#,###.###");

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
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
     * @param idHoSo
     * @return
     */
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.XEM_GIAY_XAC_NHAN_URL}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> xemGiayXacNhan(@PathVariable("id") long id) {

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

            if (capGiayXacNhan != null) {
                listCoSoSX = mTbdGXNThongTinCoSoSX1Service.findByIdGXN(capGiayXacNhan.getIdGxn());
            }

            if (capGiayXacNhan != null) {
                listPheLieu = mTbdGXNThongTinPheLieu1Service.findByIdGXN(capGiayXacNhan.getIdGxn());
            }

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
     * @param idHoSoGXN
     * @param request
     * @return
     */
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.LAY_THONG_TIN_CO_SO_SAN_XUAT_THEO_SO_GIAY_XAC_NHAN_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> layThongTinCoSoSanXuatTheoGiayXacNhan(@PathVariable("idGXN") long idGXN, HttpServletRequest request) {

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

    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.LAY_THONG_TIN_PHE_LIEU_THEO_SO_GIAY_XAC_NHAN_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> layThongTinPheLieuTheoGiayXacNhan(@PathVariable("idGXN") long idGXN, HttpServletRequest request) {

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
     * @param idHoSo
     * @return
     */
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.LAY_THONG_TIN_SO_GIAY_XAC_NHAN_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> layThongTinGiayXacNhanTheoSoGXN(@PathVariable("idHS") long idHS, @PathVariable("soGXN") String soGiayXN, HttpServletRequest request) {

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            Object data = null;
            if (idHS > 0) {
                List<TbdCapGiayXacNhan1> listTbdGiayXacNhan = mTbdCapGiayXacNhan1Service.findByIdHSOrderByIdGxnDesc(idHS);
                if (listTbdGiayXacNhan != null && !listTbdGiayXacNhan.isEmpty()) {
                    data = listTbdGiayXacNhan.get(0);
                }
            } else {

                LOGGER.info("Tim kiem So GXN = {} | Hinh thuc = {}", soGiayXN, AppCommon.getHinhThuc(request));

                List<TbdCapGiayXacNhan1> listTbdGiayXacNhan = mTbdCapGiayXacNhan1Service.findBySoGiayXNAndHinhThucAndMaSoThueOrderByIdGxnDesc(soGiayXN, AppCommon.getHinhThuc(request), userInfo.getMaSoThue());
                if (listTbdGiayXacNhan != null && !listTbdGiayXacNhan.isEmpty()) {
                    data = listTbdGiayXacNhan.get(0);
                }
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
     * Gui thong bao xin rut ho so
     *
     * @param request
     * @return
     */
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DON_XIN_RUT_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> yeuCauXinRutHoSo(HttpServletRequest request, @RequestBody TbdYeuCauRutHS1 form) {
        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            TbdHSDeNghiCapGiayXn1 tbdHSDeNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(form.getIdHS());

            int trangThai = tbdHSDeNghiCapGiayXn1.getTrangThai();

            String function = (trangThai == AppKeyConstant.Status.GUI_MOI || trangThai == AppKeyConstant.Status.KHAI_SUA) ? AppKeyConstant.TNMT01FUNCTION.FUNCTION_03 : AppKeyConstant.TNMT01FUNCTION.FUNCTION_11;

            TbdYeuCauRutHS1 tbdYeuCauRutHS1 = new TbdYeuCauRutHS1();

            SendMessage sendMessage = new SendMessage();

            tbdYeuCauRutHS1.setIdHS(form.getIdHS());
            tbdYeuCauRutHS1.setNgayRut(new Date());
            tbdYeuCauRutHS1.setNoiDung(form.getNoiDung());

            tbdYeuCauRutHS1 = mTbdYeuCauRutHS1Service.saveTbdYeuCauRutHS1(tbdYeuCauRutHS1);

            if (tbdYeuCauRutHS1 != null) {

                String uri = AppViewThuTuc01Constant.ViewURL.BACKEND_SEND_MESSAGE_URL;
                sendMessage.setFiIdHoso(tbdHSDeNghiCapGiayXn1.getIdHS());
                sendMessage.setfIdBanTin(tbdYeuCauRutHS1.getId());
                sendMessage.setType(AppKeyConstant.TNMT01TYPE.TYPE_15);
                sendMessage.setFunction(function);
                ResponseJson responseJson = createRestTemplate(uri, sendMessage, HttpMethod.POST, null);

                if (responseJson != null && responseJson.isSuccess()) {

                    if (trangThai != AppKeyConstant.Status.GUI_MOI || trangThai != AppKeyConstant.Status.KHAI_SUA) {

                        tbdHSDeNghiCapGiayXn1.setTrangThai(AppKeyConstant.Status.YEU_CAU_XIN_RUT_HO_SO);

                    } else {

                        tbdHSDeNghiCapGiayXn1.setTrangThai(AppKeyConstant.Status.YEU_CAU_RUT_HO_SO);
                    }
                    tbdHSDeNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.updateTbdHSDeNghiCapGiayXn1(form.getIdHS(), tbdHSDeNghiCapGiayXn1);
                    luuLichSuTacDong(tbdHSDeNghiCapGiayXn1, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.them-moi-yeu-cau-rut-theo-ho-so-ho-so", new Object[]{tbdYeuCauRutHS1.getNoiDung(), tbdHSDeNghiCapGiayXn1.getMaHoSo(), userInfo.getMaSoThue() + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale())}, request.getLocale()));

                    return createResponseEntity(tbdHSDeNghiCapGiayXn1, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), responseJson.isSuccess(), HttpStatus.OK);
                } else {
                    luuLichSuTacDong(tbdHSDeNghiCapGiayXn1, getMessage("monre.01.lichsu.xinhoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()));
                }

            }
        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
    }

    private ResponseJson createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params) {

        String host = environment.getRequiredProperty(ThuTuc01Constant.HOST_NAME);

        uri = host + uri;

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);

        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                builder.queryParam(key, String.valueOf(value));
            }
        }

        uri = builder.build().encode().toString();

        LOGGER.info(uri);

        List<HttpMessageConverter<?>> converters = new ArrayList<>();

        converters.add(new MappingJackson2HttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setMessageConverters(converters);

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));

        HttpEntity<Object> entity = new HttpEntity<>(body, headers);

        ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, httpMethod, entity, ResponseJson.class);

        return response.getBody();

    }

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.XOA_HO_SO_URL + "/{idHS}"}, method = RequestMethod.POST)
    public ResponseEntity<Object> xoaHoSo(@PathVariable("idHS") long idHS, HttpServletRequest request) {

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            TbdHSDeNghiCapGiayXn1 deNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

            if (deNghiCapGiayXn1 != null && userInfo.getMaSoThue().equals(deNghiCapGiayXn1.getMaSoThue())) {

                deNghiCapGiayXn1.setXoa(1);

                Object data = mTbdHSDeNghiCapGiayXn1Service.updateTbdHSDeNghiCapGiayXn1(idHS, deNghiCapGiayXn1);

                deNghiCapGiayXn1.setXoa(1);

                luuLichSuTacDong(deNghiCapGiayXn1, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.xoa-ho-so-ho-so", new Object[]{deNghiCapGiayXn1.getIdHS(), userInfo.getMaSoThue()}, request.getLocale()));

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
     * @param idHoSo
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/getHoSo/{idHS}"}, method = RequestMethod.POST)
    public ResponseEntity<Object> getHoSo(@PathVariable("idHS") long idHS, HttpServletRequest request) {

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            HoSoEditForm form = new HoSoEditForm();
            form.setCoQuanXuLyList(getCoQuanXuLy(request));
            form.setDanhMucPheLieuList(getDanhMucPheLieu(request));
            if (idHS <= 0) {
                form = ConvertToObjectUtil.convertTo(userInfo, form);
                form.setNgayCapGCNDKKD(userInfo.getNgayCapGCNDKKD());
                form.setNgayCapGCNDKKDDateFormat(userInfo.getNgayCapGCNDKKD());

            } else {
                TbdHSDeNghiCapGiayXn1 deNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                if (deNghiCapGiayXn1 != null && userInfo.getMaSoThue().equals(deNghiCapGiayXn1.getMaSoThue())) {

                    form = ConvertToObjectUtil.convertTo(deNghiCapGiayXn1, form);
                    form.setNgayCapDateFormat(deNghiCapGiayXn1.getNgayCap());
                    form.setNgayHetHanDateFormat(deNghiCapGiayXn1.getNgayHetHan());
                    form.setNgayCapGCNDKKDDateFormat(deNghiCapGiayXn1.getNgayCapGCNDKKD());
                    form.setCoQuanXuLyList(getCoQuanXuLy(request));
                    form.setCoSoSanXuatList(getCoSoSanXuat(idHS));
                    form.setDanhMucPheLieuList(getDanhMucPheLieu(request));
                    form.setPheLieuList(layPheLieus(request, idHS));
                    form.setTepDinhKemList(mTbdTepTin1Service.findByIdHSOrderByLoaiTepTinAsc(idHS));

                } else {
                    return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
                }
            }

            return createResponseEntity(form, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

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
     * Luu thong tin ho so
     *
     * @param form
     * @param request
     * @param model
     * @param redirectAttributes
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.GHI_HO_SO_URL}, method = RequestMethod.POST)
    public ResponseEntity<Object> ghiHoSo(@RequestBody HoSoEditForm form, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {

        form.setNgayCap(form.getNgayCapDateFormat());
        form.setNgayHetHan(form.getNgayHetHanDateFormat());
        form.setNgayCapGCNDKKD(form.getNgayCapGCNDKKDDateFormat());
        TbdHSDeNghiCapGiayXn1 capGiayXn = new TbdHSDeNghiCapGiayXn1();

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            BeanUtils.copyProperties(form, capGiayXn);

            String errorMesage2 = validHoSo(form, request);
            if (errorMesage2 != null) {
                return createResponseEntity(null, errorMesage2, false, HttpStatus.OK);
            }

            capGiayXn = luuThongTinHoSo(capGiayXn, request);
            if (capGiayXn == null) {
                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            List<CoSoSanXuatEditForm> coSoSanXuatEditForms = readJsonStringToList(form.getCoSoSanXuatJsonString(), CoSoSanXuatEditForm.class);
            if (coSoSanXuatEditForms != null) {
                String errorMesage = saveCoSoSanXuat(request, capGiayXn, coSoSanXuatEditForms);
                if (StringUtils.hasText(errorMesage)) {
                    return createResponseEntity(null, errorMesage, false, HttpStatus.OK);
                }
            }
            List<PheLieuEditForm> pheLieuEditForms = readJsonStringToList(form.getPheLieuJsonString(), PheLieuEditForm.class);
            if (pheLieuEditForms != null) {
                Object errorMesage = savePheLieu(request, capGiayXn, pheLieuEditForms);
                if (errorMesage != null && errorMesage instanceof String) {
                    return createResponseEntity(null, (String) errorMesage, false, HttpStatus.OK);
                }
            }

            if (form.isGuiHoSo() && isSign()) {
                ResponseJson responseJson = guiHoSo(capGiayXn, null, true);
                X509Certificate x509Cert = CertificateUtils.getX509Cert(form.getSerialNumber());
                if (!ObjectUtils.isEmpty(x509Cert) && !Objects.isNull(responseJson)) {
                    String sn = x509Cert.getSerialNumber().toString(16);
                    form.setSerialNumber(sn);
                    String xmlEnvelop = responseJson.getData().toString();
                    xmlEnvelop = xmlEnvelop.replace("<Body/>", responseJson.getMessage().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", ""));
                    form.setXmlEnvelop(xmlEnvelop);
                }
            }
            form.setIdHS(capGiayXn.getIdHS());
            return createResponseEntity(form, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
        } catch (Exception e) {
            logError(e);
            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
    }

    @RequestMapping(value = {"/send"}, method = RequestMethod.POST)
    public String send(@ModelAttribute("form") TbdHSDeNghiCapGiayXn1 form, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        String time = dateFormat.format(new Date());

        LOGGER.info("SEN HO SO ID = {}, Time = {}", form.getIdHS(), time);
        try {
            TbdHSDeNghiCapGiayXn1 capGiayXn = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(form.getIdHS());
            String error = isValidSend(capGiayXn, AppCommon.getLoaiThuTucHienTai(request), request.getLocale());
            if (StringUtils.hasText(error)) {
                redirectAttributes.addFlashAttribute(SEND_NOT_OK, error);
                return AppCommon.redirectPage(request, AppViewThuTuc01Constant.ViewURL.KHAI_HO_SO_MOI_URL + "/" + form.getIdHS());
            }

            if (isSign()) {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                UserCustom user = (UserCustom) principal;
                ResponseMessage responseMessage = SendUtil.callWs(environment.getRequiredProperty("monre.01.CAService"), user.getUsername(), form.getXmlEnvelop());
                if (!responseMessage.isSuccess()) {
                    redirectAttributes.addFlashAttribute(SEND_NOT_OK, responseMessage.getMessage());
                    return AppCommon.redirectPage(request, AppViewThuTuc01Constant.ViewURL.KHAI_HO_SO_MOI_URL + "/" + form.getIdHS());
                }
            }
            if (guiHoSo(capGiayXn, form.getXmlEnvelop(), false).isSuccess()) {
                luuLichSuTacDong(capGiayXn, getMessage("monre.01.lichsu.guihoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()));
                LOGGER.info("[GUI HO SO THANH CONG][TIME = {}]", time);
                redirectAttributes.addFlashAttribute("sendOkMessage", getMessage("error.monre.01.send.success", request.getLocale()));
                return AppCommon.redirectPage(request, AppViewThuTuc01Constant.ViewURL.INDEX_URL);
            } else {
                luuLichSuTacDong(capGiayXn, getMessage("monre.01.lichsu.guihoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()));
                LOGGER.info("[GUI HO SO KHONG THANH CONG][TIME = {}]", time);
                redirectAttributes.addFlashAttribute(SEND_NOT_OK, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()));
            }
        } catch (Exception e) {
            logError(e);
            pushLog(e);
            redirectAttributes.addFlashAttribute(SEND_NOT_OK, getMessage("error.monre.01.send.error.loihethong", request.getLocale()));
        }

        return AppCommon.redirectPage(request, AppViewThuTuc01Constant.ViewURL.KHAI_HO_SO_MOI_URL + "/" + form.getIdHS());
    }

    @ResponseBody
    @RequestMapping(value = {"/sendHoSo/{idHoSo}"}, method = RequestMethod.POST)
    public ResponseEntity<Object> sendHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        String time = dateFormat.format(new Date());

        LOGGER.info("SEN HO SO ID = {}, Time = {}", idHoSo, time);

        TbdHSDeNghiCapGiayXn1 capGiayXn = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(idHoSo);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;
        if (capGiayXn == null || !Objects.equals(user.getUsername(), capGiayXn.getMaSoThue())) {
            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
        }
        String error = isValidSend(capGiayXn, AppCommon.getLoaiThuTucHienTai(request), request.getLocale());
        if (StringUtils.hasText(error)) {
            return createResponseEntity(null, error, false, HttpStatus.OK);
        }
        if (guiHoSo(capGiayXn, null, false).isSuccess()) {
            luuLichSuTacDong(capGiayXn, getMessage("monre.01.lichsu.guihoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()));
            LOGGER.info("[GUI HO SO THANH CONG][TIME = {}]", time);
            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
        } else {
            luuLichSuTacDong(capGiayXn, getMessage("monre.01.lichsu.guihoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()));
            LOGGER.info("[GUI HO SO KHONG THANH CONG][TIME = {}]", time);
        }
        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
    }

    private boolean isSign() {
        return Boolean.parseBoolean(environment.getRequiredProperty("monre.01.sign"));
    }

    private String validHoSo(HoSoEditForm form, HttpServletRequest request) {
        if (!StringUtils.hasText(form.getMaCoQuan()) || "-1".equals(form.getMaCoQuan())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.maCoQuan.null", request.getLocale());
        }
        if (!StringUtils.hasText(form.getTenCoQuan())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.tenCoQuan.null", request.getLocale());
        }
        if (form.getTenCoQuan().length() > 250) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.tenCoQuan.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getMaSoThue())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.maSoThue.null", request.getLocale());
        }
        if (form.getMaSoThue().length() > 20) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.maSoThue.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getTenDN())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.tenDN.null", request.getLocale());
        }
        if (form.getTenDN().length() > 250) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.tenDN.max-length", request.getLocale());
        }

        String error1 = validHoSo1(form, request);
        if (error1 != null) {
            return error1;
        }
        // not required
        if (StringUtils.hasText(form.getFaxNguoiDaiDien()) && form.getFaxNguoiDaiDien().length() > 20) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.faxNguoiDaiDien.max-length", request.getLocale());
        }
        if (StringUtils.hasText(form.getSoDTNguoiDaiDien()) && form.getSoDTNguoiDaiDien().length() > 20) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.soDTNguoiDaiDien.max-length", request.getLocale());
        }

        return null;
    }

    private String validHoSo1(HoSoEditForm form, HttpServletRequest request) {
        if (!StringUtils.hasText(form.getNguoiDaiDien())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.nguoiDaiDien.null", request.getLocale());
        }
        if (form.getNguoiDaiDien().length() > 250) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.nguoiDaiDien.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getTruSoChinh())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.truSoChinh.null", request.getLocale());
        }
        if (form.getTruSoChinh().length() > 250) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.truSoChinh.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getSoGCNDKKD())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.soGCNDKKD.null", request.getLocale());
        }
        if (form.getSoGCNDKKD().length() > 250) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.soGCNDKKD.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getEmailNguoiDaiDien())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.emailNguoiDaiDien.null", request.getLocale());
        }
        if (form.getEmailNguoiDaiDien().length() > 100) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.emailNguoiDaiDien.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(form.getNoiCapGCNDKKD())) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.noiCapGCNDKKD.null", request.getLocale());
        }
        if (form.getNoiCapGCNDKKD().length() > 250) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.noiCapGCNDKKD.max-length", request.getLocale());
        }
        if (form.getNgayCapGCNDKKD() == null) {
            return getMessage("error.monre.01.TbdHSDeNghiCapGiayXn1.ngayCapGCNDKKD.null", request.getLocale());
        }
        return null;
    }

    private Object savePheLieu(HttpServletRequest request, TbdHSDeNghiCapGiayXn1 capGiayXn, List<PheLieuEditForm> pheLieuEditForms) {

        List<TbdThongTinPheLieu1> pheLieu1s = new ArrayList<>();
        List<TbdThongTinPheLieu1> results = new ArrayList<>();
        if (pheLieuEditForms != null && !pheLieuEditForms.isEmpty()) {
            for (PheLieuEditForm item : pheLieuEditForms) {
                TbdThongTinPheLieu1 tbdThongTinPheLieu1 = new TbdThongTinPheLieu1();
                BeanUtils.copyProperties(item, tbdThongTinPheLieu1);
                String error = validPheLieu(request, tbdThongTinPheLieu1);
                if (StringUtils.hasText(error)) {
                    return error;
                }
                tbdThongTinPheLieu1.setIdHS(capGiayXn.getIdHS());
                if (!"-1".equals(item.getMaHS())) {
                    pheLieu1s.add(tbdThongTinPheLieu1);
                }
            }
            for (TbdThongTinPheLieu1 item : pheLieu1s) {
                if (item.getIdPL() > 0) {
                    item = (TbdThongTinPheLieu1) updateTbdThongTinPheLieu1ByIdHoSo(request, capGiayXn, item);
                    results.add(item);
                    continue;
                }
                item = (TbdThongTinPheLieu1) insertTbdThongTinPheLieu1ByIdHoSo(request, capGiayXn, item);
                results.add(item);
            }
        }
        return results;
    }

    private Object insertTbdThongTinPheLieu1ByIdHoSo(HttpServletRequest request, TbdHSDeNghiCapGiayXn1 capGiayXn, TbdThongTinPheLieu1 item) {
        List<Object> data = new ArrayList<>();
        TbdThongTinPheLieu1 oLieu1 = mTbdThongTinPheLieu1Service.saveTbdThongTinPheLieu1(item);
        String msg1 = "monre.01.lich-su-tac-dong-tac-dong.them-moi-phe-lieu-nhap-khau-theo-ho-so-ho-so";
        if ((AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04)) {
            msg1 = "monre.01.lich-su-tac-dong-tac-dong.them-moi-phe-lieu-nhap-khau-theo-ho-so-ho-so2";
        }
        data.add(item.getTenPheLieu());
        data.add(item.getMaHS());
        data.add(item.getKhoiLuong6());
        data.add(item.getKhoiLuong());
        if ((AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04)) {
            data.add(item.getDonViUyThac());
        }
        data.add(capGiayXn.getMaHoSo());
        data.add(capGiayXn.getMaSoThue());
        luuLichSuTacDong(capGiayXn, mMessageSource.getMessage(msg1, data.toArray(), request.getLocale()));
        return oLieu1;
    }

    private Object updateTbdThongTinPheLieu1ByIdHoSo(HttpServletRequest request, TbdHSDeNghiCapGiayXn1 capGiayXn, TbdThongTinPheLieu1 item) {
        List<Object> data = new ArrayList<>();
        TbdThongTinPheLieu1 old = mTbdThongTinPheLieu1Service.getTbdThongTinPheLieu1(item.getIdPL());

        item = mTbdThongTinPheLieu1Service.updateTbdThongTinPheLieu1(item.getIdPL(), item);
        if (!old.toString().equals(item.toString())) {

            String msg1 = "monre.01.lich-su-tac-dong-tac-dong.cap-nhat-phe-lieu-nhap-khau-theo-ho-so-ho-so";
            if (AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04) {
                msg1 = "monre.01.lich-su-tac-dong-tac-dong.cap-nhat-phe-lieu-nhap-khau-theo-ho-so-ho-so2";
            }
            data.add(old.getTenPheLieu());
            data.add(old.getMaHS());
            data.add(old.getKhoiLuong6());
            data.add(old.getKhoiLuong());
            if ((AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04)) {
                data.add(old.getDonViUyThac());
            }
            data.add(item.getTenPheLieu());
            data.add(item.getMaHS());
            data.add(item.getKhoiLuong6());
            data.add(item.getKhoiLuong());
            if ((AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04)) {
                data.add(item.getDonViUyThac());
            }

            data.add(capGiayXn.getMaHoSo());
            data.add(capGiayXn.getMaSoThue());
            luuLichSuTacDong(capGiayXn, mMessageSource.getMessage(msg1, data.toArray(), request.getLocale()));

        }
        return item;
    }

    private String validPheLieu(HttpServletRequest request, TbdThongTinPheLieu1 tbdThongTinPheLieu1) {
        if ("-1".equals(tbdThongTinPheLieu1.getTenPheLieu()) && "-1".equals(tbdThongTinPheLieu1.getMaHS()) && !StringUtils.hasText(tbdThongTinPheLieu1.getKhoiLuong6Input()) && !StringUtils.hasText(tbdThongTinPheLieu1.getKhoiLuongInput()) && !StringUtils.hasText(tbdThongTinPheLieu1.getDonViUyThac())) {
            return null;
        }

        if (!StringUtils.hasText(tbdThongTinPheLieu1.getTenPheLieu()) || "-1".equals(tbdThongTinPheLieu1.getTenPheLieu())) {
            return getMessage("error.monre.01.TbdThongTinPheLieu1.tenPheLieu.null", request.getLocale());
        }
        if (tbdThongTinPheLieu1.getTenPheLieu().length() > 250) {
            return getMessage("error.monre.01.TbdThongTinPheLieu1.tenPheLieu.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(tbdThongTinPheLieu1.getMaHS()) || "-1".equals(tbdThongTinPheLieu1.getMaHS())) {
            return getMessage("error.monre.01.TbdThongTinPheLieu1.maHS.null", request.getLocale());
        }
        if (tbdThongTinPheLieu1.getMaHS().length() > 250) {
            return getMessage("error.monre.01.TbdThongTinPheLieu1.maHS.max-length", request.getLocale());
        }
        if (tbdThongTinPheLieu1.getKhoiLuong6() < 0.0f) {
            return getMessage("error.monre.01.TbdThongTinPheLieu1.khoiLuong6.null", request.getLocale());
        }
        if (tbdThongTinPheLieu1.getKhoiLuong() <= 0.0f) {
            return getMessage("error.monre.01.TbdThongTinPheLieu1.khoiLuong.null", request.getLocale());
        }
        if ((AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04) && !StringUtils.hasText(tbdThongTinPheLieu1.getDonViUyThac())) {
            return getMessage("error.monre.01.TbdThongTinPheLieu1.donViUyThac.null", request.getLocale());
        }
        return "";
    }

    private String validThongTinCoSoSX(HttpServletRequest request, TbdThongTinCoSoSX1 item) {
        if (!StringUtils.hasText(item.getTenCoSo())) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.tenCoSo.null", request.getLocale());
        }
        if (item.getTenCoSo().length() > 250) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.tenCoSo.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(item.getDiaChiCoSo())) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.diaChiCoSo.null", request.getLocale());
        }
        if (item.getDiaChiCoSo().length() > 250) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.diaChiCoSo.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(item.getMaTinh())) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.maTinh.null", request.getLocale());
        }
        if (item.getTenTinh().length() > 250) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.maTinh.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(item.getMaHuyen())) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.maHuyen.null", request.getLocale());
        }
        if (item.getTenHuyen().length() > 50) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.maHuyen.max-length", request.getLocale());
        }
        if (!StringUtils.hasText(item.getMaXaPhuong())) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.maXaPhuong.null", request.getLocale());
        }
        if (item.getTenXaPhuong().length() > 250) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.maXaPhuong.max-length", request.getLocale());
        }

        return validThongTinCoSoSXNotRequired(request, item);
    }

    private String validThongTinCoSoSXNotRequired(HttpServletRequest request, TbdThongTinCoSoSX1 item) {

        if (StringUtils.hasText(item.getSoDienThoai()) && item.getSoDienThoai().length() > 50) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.soDienThoai.max-length", request.getLocale());
        }
        if (StringUtils.hasText(item.getFax()) && item.getFax().length() > 50) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.fax.max-length", request.getLocale());
        }
        if (StringUtils.hasText(item.getEmail()) && item.getEmail().length() > 50) {
            return getMessage("error.monre.01.TbdThongTinCoSoSX1.email.max-length", request.getLocale());
        }
        return "";
    }

    private String saveCoSoSanXuat(HttpServletRequest request, TbdHSDeNghiCapGiayXn1 capGiayXn, List<CoSoSanXuatEditForm> coSoSanXuatEditForms) {

        List<TbdThongTinCoSoSX1> checkList = new ArrayList<>();
        List<Long> checkIDList = new ArrayList<>();
        if (coSoSanXuatEditForms != null && !coSoSanXuatEditForms.isEmpty()) {
            for (CoSoSanXuatEditForm item : coSoSanXuatEditForms) {
                TbdThongTinCoSoSX1 tbdThongTinCoSoSX1 = new TbdThongTinCoSoSX1();
                BeanUtils.copyProperties(item, tbdThongTinCoSoSX1);
                String error = validThongTinCoSoSX(request, tbdThongTinCoSoSX1);
                if (StringUtils.hasText(error)) {
                    return error;
                }
                tbdThongTinCoSoSX1.setIdHS(capGiayXn.getIdHS());
                tbdThongTinCoSoSX1.setTbdThongTinCoSoSXId(item.getTbdThongTinCoSoSXId());
                checkList.add(tbdThongTinCoSoSX1);
                if (item.getTbdThongTinCoSoSXId() > 0) {
                    checkIDList.add(item.getTbdThongTinCoSoSXId());
                }
            }

            deleteCoSoSXByIdHoSo(capGiayXn, request, checkIDList);

            insertCoSoSX(request, capGiayXn, checkList, checkIDList);
        } else {
            deleteCoSoSXByIdHoSo(capGiayXn, request, null);
        }
        return null;
    }

    private void insertCoSoSX(HttpServletRequest request, TbdHSDeNghiCapGiayXn1 capGiayXn, List<TbdThongTinCoSoSX1> checkList, List<Long> checkIDList) {
        for (TbdThongTinCoSoSX1 item : checkList) {
            mTbdThongTinCoSoSX1Service.saveTbdThongTinCoSoSX1(item);
            if (!checkIDList.contains(item.getTbdThongTinCoSoSXId())) {
                saveHistoryCoSoSanXuat(request, capGiayXn, item, "monre.01.lich-su-tac-dong-tac-dong.them-moi-co-so-san-xuat-theo-ho-so-ho-so");
            }
        }
    }

    private void saveHistoryCoSoSanXuat(HttpServletRequest request, TbdHSDeNghiCapGiayXn1 capGiayXn, TbdThongTinCoSoSX1 item, String messageKey) {
        List<Object> data = new ArrayList<>();
        data.add(item.getTenCoSo());
        data.add(item.getDiaChiCoSo());
        data.add(item.getSoDienThoai());
        data.add(item.getEmail());
        data.add(item.getFax());
        data.add(item.getTenTinh());
        data.add(item.getTenHuyen());
        data.add(item.getTenXaPhuong());
        data.add(capGiayXn.getMaHoSo());
        data.add(capGiayXn.getMaSoThue());

        luuLichSuTacDong(capGiayXn, mMessageSource.getMessage(messageKey, data.toArray(), request.getLocale()));
    }

    private void deleteCoSoSXByIdHoSo(TbdHSDeNghiCapGiayXn1 capGiayXn, HttpServletRequest request, List<Long> ids) {
        List<TbdThongTinCoSoSX1> finds = getCoSoSanXuat(capGiayXn.getIdHS());
        TbdThongTinCoSoSX1SearchItem deleteTbdThongTinCoSoSX1SearchItem = new TbdThongTinCoSoSX1SearchItem();
        deleteTbdThongTinCoSoSX1SearchItem.setFiidhs(capGiayXn.getIdHS());
        mTbdThongTinCoSoSX1Service.deleteBySearchItemTbdThongTinCoSoSX1s(deleteTbdThongTinCoSoSX1SearchItem);
        if (finds != null) {
            for (TbdThongTinCoSoSX1 item : finds) {

                if (!ObjectUtils.isEmpty(ids)) {
                    if (!ids.contains(item.getTbdThongTinCoSoSXId())) {
                        saveHistoryCoSoSanXuat(request, capGiayXn, item, LICH_SU_XOA_CO_SO_SX_KEY);
                    }

                } else {
                    saveHistoryCoSoSanXuat(request, capGiayXn, item, LICH_SU_XOA_CO_SO_SX_KEY);
                }
            }
        }
    }

    private static final String KEY_TEP_TIN = "error.monre.01.monre_01_gui_ho_so_yeu_cau_thong_tin_tep_dinh_kem";

    private String isValidSend(TbdHSDeNghiCapGiayXn1 capGiayXn, Integer loaiThuTuc, Locale locale) {

        if (capGiayXn == null) {
            return mMessageSource.getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, null, locale);
        }
        List<TbdThongTinCoSoSX1> coSoSX1s = mTbdThongTinCoSoSX1Service.findByIdHS(capGiayXn.getIdHS());
        if (coSoSX1s == null || coSoSX1s.isEmpty()) {
            return mMessageSource.getMessage("error.monre.01.monre_01_gui_ho_so_yeu_cau_thong_tin_co_so_san_xuat", null, locale);
        }
        List<TbdThongTinPheLieu1> pheLieu1s = mTbdThongTinPheLieu1Service.findByIdHS(capGiayXn.getIdHS());
        if (pheLieu1s == null || pheLieu1s.isEmpty()) {
            return mMessageSource.getMessage("error.monre.01.monre_01_gui_ho_so_yeu_cau_thong_tin_phe_lieu", null, locale);
        }
        List<TbdTepTin1> tepTin1s = mTbdTepTin1Service.findByIdHSOrderByLoaiTepTinAsc(capGiayXn.getIdHS());
        if (tepTin1s == null || tepTin1s.isEmpty()) {
            return mMessageSource.getMessage(KEY_TEP_TIN, null, locale);
        }

        if (!checkTepTin(tepTin1s, loaiThuTuc)) {
            return mMessageSource.getMessage(KEY_TEP_TIN, null, locale);
        }

        return "";
    }

    private boolean checkTepTin(List<TbdTepTin1> tepTin1s, int loaiThuTuc) {
        if (!checkHasTep(tepTin1s, AppKeyConstant.LoaiTepTin.LOAI_1)) {
            return false;
        }
        if (!checkHasTep(tepTin1s, AppKeyConstant.LoaiTepTin.LOAI_6)) {
            return false;
        }

        if (loaiThuTuc == AppKeyConstant.LoaiThuTuc.THU_TUC_01 || loaiThuTuc == AppKeyConstant.LoaiThuTuc.THU_TUC_03) {
            if (!checkHasTep(tepTin1s, AppKeyConstant.LoaiTepTin.LOAI_2)) {
                return false;
            }
            if (!checkHasTep(tepTin1s, AppKeyConstant.LoaiTepTin.LOAI_3)) {
                return false;
            }
            if (!checkHasTep(tepTin1s, AppKeyConstant.LoaiTepTin.LOAI_4)) {
                return false;
            }
            if (!checkHasTep(tepTin1s, AppKeyConstant.LoaiTepTin.LOAI_5)) {
                return false;
            }
            if (!checkHasTep(tepTin1s, AppKeyConstant.LoaiTepTin.LOAI_7)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkHasTep(List<TbdTepTin1> tbdTepTin1s, int loai) {
        if (tbdTepTin1s == null || tbdTepTin1s.isEmpty()) {
            return false;
        }
        return tbdTepTin1s.stream().filter(p -> p.getLoaiTepTin() == loai).count() > 0;
    }

    /**
     * Gui ho so di
     *
     * @param capGiayXn
     * @throws Exception
     */
    private ResponseJson guiHoSo(TbdHSDeNghiCapGiayXn1 capGiayXn, String envelop, boolean layBanTinXml) {

        String uri = AppViewThuTuc01Constant.ViewURL.BACKEND_SEND_MESSAGE_URL;

        SendMessage sendMessage = new SendMessage();

        int trangThai = capGiayXn.getTrangThai();

        String function = null;

        if (trangThai == AppKeyConstant.Status.TAO_MOI) {
            function = AppKeyConstant.TNMT01FUNCTION.FUNCTION_01;
        } else if (trangThai == AppKeyConstant.Status.GUI_MOI || trangThai == AppKeyConstant.Status.KHAI_SUA) {
            function = AppKeyConstant.TNMT01FUNCTION.FUNCTION_02;
        } else if (trangThai == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG || trangThai == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG_SAU_KIEM_TRA) {
            function = AppKeyConstant.TNMT01FUNCTION.FUNCTION_04;
        }
        sendMessage.setType(AppKeyConstant.TNMT01TYPE.TYPE_10);
        sendMessage.setFiIdHoso(capGiayXn.getIdHS());
        if (function != null) {
            sendMessage.setFunction(function);
        }
        if (isSign() && layBanTinXml) {
            sendMessage.setGetXmlNotSend(Boolean.TRUE.toString());
        }
        if (StringUtils.hasText(envelop)) {
            LOGGER.info("GUI BAN TIN KY SO: {}", envelop);
            sendMessage.setSignedXml(envelop);
        }
        ResponseJson responseJson = createRestTemplate(uri, sendMessage, HttpMethod.POST, null);
        if (layBanTinXml) {
            return responseJson;
        }

        LOGGER.info("KET QUA GUI HO SO: {}", responseJson);

        if (responseJson != null && responseJson.isSuccess()) {

            if (trangThai == AppKeyConstant.Status.TAO_MOI) {
                capGiayXn.setTrangThai(AppKeyConstant.Status.GUI_MOI);
            }
            if (trangThai == AppKeyConstant.Status.GUI_MOI) {
                capGiayXn.setTrangThai(AppKeyConstant.Status.KHAI_SUA);
            } else if (trangThai == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG || trangThai == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG_SAU_KIEM_TRA) {
                capGiayXn.setTrangThai(AppKeyConstant.Status.SUA_DOI_BO_SUNG);
            }
            capGiayXn.setNgayGui(new Date());

            mTbdHSDeNghiCapGiayXn1Service.updateTbdHSDeNghiCapGiayXn1(capGiayXn.getIdHS(), capGiayXn);

            return responseJson;
        }

        return responseJson;
    }

    private boolean isValidHoSo(TbdHSDeNghiCapGiayXn1 form) {
        boolean valid = true;

        if (!StringUtils.hasText(form.getNguoiDaiDien()) || form.getNguoiDaiDien().trim().length() > 250) {
            return false;
        }
        if (!StringUtils.hasText(form.getEmailNguoiDaiDien()) || form.getEmailNguoiDaiDien().trim().length() > 100) {
            return false;
        }
        if (!StringUtils.hasText(form.getNoiCapGCNDKKD()) || form.getNoiCapGCNDKKD().trim().length() > 250) {
            return false;
        }
        if (StringUtils.hasText(form.getFaxNguoiDaiDien()) && form.getFaxNguoiDaiDien().trim().length() > 20) {
            return false;
        }
        if (!StringUtils.hasText(form.getTenCoQuan()) || form.getTenCoQuan().trim().length() > 250) {
            return false;
        }
        if (!StringUtils.hasText(form.getMaCoQuan()) || form.getMaCoQuan().trim().length() > 50) {
            return false;
        }
        if (form.getNgayCapGCNDKKD() == null) {
            return false;
        }
        return valid;
    }

    private TbdHSDeNghiCapGiayXn1 luuThongTinHoSo(TbdHSDeNghiCapGiayXn1 form, HttpServletRequest request) {

        if (!isValidHoSo(form)) {
            return null;
        }

        UserInfo userInfo = LoginUtil.getUserInfo();

        TbdHSDeNghiCapGiayXn1 capGiayXn1 = new TbdHSDeNghiCapGiayXn1();

        if (form.getIdHS() == 0) {

            capGiayXn1.setNgayCap(form.getNgayCap());
            capGiayXn1.setNgayTao(DateUtil.getNowDate());
            capGiayXn1.setHinhThuc(AppCommon.getHinhThuc(request));
            capGiayXn1.setLoaiThuTuc(AppCommon.getLoaiThuTuc(request));
            capGiayXn1.setMaHoSo(getMaHoSo());
            capGiayXn1.setTenDN(userInfo.getTenDN());
            capGiayXn1.setSoGCNDKKD(userInfo.getsoGCNDKKD());
            capGiayXn1.setSoDTNguoiDaiDien(userInfo.getSoDTNguoiDaiDien());
            capGiayXn1.setTruSoChinh(userInfo.getTruSoChinh());
            capGiayXn1.setMaSoThue(form.getMaSoThue());
            capGiayXn1.setLoaiHoSo(AppCommon.getLoaiHoSo(request));

        } else {

            capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(form.getIdHS(), AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());
        }
        capGiayXn1.setSoGXNDaCap(form.getSoGXNDaCap());
        capGiayXn1.setNgayHetHan(form.getNgayHetHan());
        capGiayXn1.setNgayCap(form.getNgayCap());
        capGiayXn1.setLyDo(form.getLyDo());

        capGiayXn1.setNguoiDaiDien(form.getNguoiDaiDien());
        capGiayXn1.setFaxNguoiDaiDien(form.getFaxNguoiDaiDien());
        capGiayXn1.setEmailNguoiDaiDien(form.getEmailNguoiDaiDien());
        capGiayXn1.setNgayCapGCNDKKD(form.getNgayCapGCNDKKD());
        capGiayXn1.setNoiCapGCNDKKD(form.getNoiCapGCNDKKD());
        capGiayXn1.setTenCoQuan(form.getTenCoQuan());
        capGiayXn1.setMaCoQuan(form.getMaCoQuan());
        // end

        if (form.getIdHS() > 0) {
            TbdHSDeNghiCapGiayXn1 olHsDeNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.getTbdHSDeNghiCapGiayXn1(capGiayXn1.getIdHS());
            capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.updateTbdHSDeNghiCapGiayXn1(capGiayXn1.getIdHS(), capGiayXn1);
            if (!olHsDeNghiCapGiayXn1.toString().equals(capGiayXn1.toString())) {
                luuLichSuTacDong(capGiayXn1, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.cap-nhat-ho-so", new Object[]{capGiayXn1.getMaHoSo(), userInfo.getMaSoThue()}, request.getLocale()));
            }
        } else {
            capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.saveTbdHSDeNghiCapGiayXn1(capGiayXn1);
            luuLichSuTacDong(capGiayXn1, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.them-moi-ho-so", new Object[]{capGiayXn1.getMaHoSo(), userInfo.getMaSoThue()}, request.getLocale()));

        }

        return capGiayXn1;
    }

    /**
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_SACH_PHE_LIEU_THEO_HO_SO + "/{idHS}"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachPheLieuTheoHoSo(HttpServletRequest request, @PathVariable("idHS") long idHS) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            Object data = layPheLieus(request, idHS);
            return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
    }

    private List<TbdThongTinPheLieu1> layPheLieus(HttpServletRequest request, long idHS) {
        UserInfo userInfo = LoginUtil.getUserInfo();
        List<TbdThongTinPheLieu1> thongTinPheLieu1s = mTbdThongTinPheLieu1Service.findByIdHSOrderByIdPLAsc(idHS);

        if (thongTinPheLieu1s != null) {
            TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

            boolean check = (capGiayXn1.getTrangThai() == AppKeyConstant.Status.TAO_MOI);
            boolean check2 = (capGiayXn1.getTrangThai() == AppKeyConstant.Status.GUI_MOI);
            boolean check3 = (capGiayXn1.getTrangThai() == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG);
            if (check || check2 || check3) {

                for (TbdThongTinPheLieu1 item : thongTinPheLieu1s) {
                    item.setCanUpdate(true);
                    if (AppCommon.visiableByStatus(capGiayXn1.getTrangThai(), new int[]{AppKeyConstant.Status.TAO_MOI})) {
                        item.setCanDelete(true);
                    }
                }

            }

            return thongTinPheLieu1s;
        }
        return Collections.emptyList();
    }

    /**
     * Lay danh sach co so san xuat theo ho so
     *
     * @param request
     * @param idHoSoHS
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_SACH_CO_SO_SAN_XUAT_THEO_HO_SO + "/{idHS}"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachCoSoSanXuatTheoHoSo(HttpServletRequest request, @PathVariable("idHS") long idHS) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
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

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.DANH_SACH_TEP_TIN_THEO_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachTepTinTheoHoSo(HttpServletRequest request, @PathVariable("id") long idHS) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
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

    /**
     * @param request
     * @param idHoSoHS
     * @param loaiTepTin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.XOA_TOAN_BO_LOAI_TEP_TIN_THEO_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> xoaTepTinTheoHoSo(HttpServletRequest request, @PathVariable("idHS") long idHS, @PathVariable("loaiTepTin") int loaiTepTin) {

        try {

            if (idHS > 0) {

                UserInfo userInfo = LoginUtil.getUserInfo();

                TbdTepTin1SearchItem searchItem = new TbdTepTin1SearchItem();

                searchItem.setFiidhs(idHS);

                searchItem.setFiloaiteptin(loaiTepTin);

                Boolean data = mTbdTepTin1Service.deleteBySearchItemTbdTepTin1s(searchItem);

                LOGGER.info("xoaTepTinTheoHoSo: idHS = {}, loaiTep = {}, status = {}", idHS, loaiTepTin, data);

                if (data) {

                    TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                    luuLichSuTacDong(capGiayXn1, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.xoa-bo-phe-loai-tep-tin-theo-ho-so-ho-so", new Object[]{loaiTepTin, capGiayXn1.getIdHS(), userInfo.getMaSoThue()}, request.getLocale()));
                }

                return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
            }

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.XOA_TEP_TIN_ID_THEO_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> xoaTepTinIdTheoHoSo(HttpServletRequest request, @PathVariable("idHS") long idHS, @PathVariable("tepTinId") long idTepTin) {

        try {

            if (idHS > 0) {

                UserInfo userInfo = LoginUtil.getUserInfo();

                TbdTepTin1 tbdTepTin1 = mTbdTepTin1Service.getTbdTepTin1(idTepTin);

                Boolean data = mTbdTepTin1Service.deleteTbdTepTin1ById(idTepTin);

                LOGGER.info("xoaTepTinIdTheoHoSo: idHS = {}, idTepTin = {}, status = {}", idHS, idTepTin, data);

                if (data) {

                    TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(tbdTepTin1.getIdHS(), AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                    luuLichSuTacDong(capGiayXn1, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.xoa-tep-dinh-kem", new Object[]{tbdTepTin1.getTenTepTin(), capGiayXn1.getMaHoSo(), userInfo.getMaSoThue()}, request.getLocale()));

                    return createResponseEntity(data, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
                }
            }

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc01Constant.ViewURL.XOA_BO_PHE_LIEU_THEO_HO_SO}, method = RequestMethod.POST)
    public ResponseEntity<Object> xoaPheLieuTheoHoSo(@PathVariable("id") long id, HttpServletRequest request) {

        UserInfo userInfo = LoginUtil.getUserInfo();

        try {

            if (id > 0) {

                TbdThongTinPheLieu1 item = mTbdThongTinPheLieu1Service.getTbdThongTinPheLieu1(id);

                Boolean isDelete = mTbdThongTinPheLieu1Service.deleteTbdThongTinPheLieu1ById(id);

                if (isDelete) {

                    TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(item.getIdHS(), AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                    List<Object> data = new ArrayList<>();
                    String msg1 = "monre.01.lich-su-tac-dong-tac-dong.xoa-bo-phe-lieu-nhap-khau-theo-ho-so-ho-so";
                    if ((AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04)) {
                        msg1 = "monre.01.lich-su-tac-dong-tac-dong.xoa-bo-phe-lieu-nhap-khau-theo-ho-so-ho-so2";
                    }
                    data.add(item.getTenPheLieu());
                    data.add(item.getMaHS());
                    data.add(item.getKhoiLuong6());
                    data.add(item.getKhoiLuong());
                    if ((AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04)) {
                        data.add(item.getDonViUyThac());
                    }
                    data.add(capGiayXn1.getMaHoSo());
                    data.add(capGiayXn1.getMaSoThue());
                    luuLichSuTacDong(capGiayXn1, mMessageSource.getMessage(msg1, data.toArray(), request.getLocale()));
                }

                return createResponseEntity(isDelete, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), isDelete, HttpStatus.OK);
            }

        } catch (Exception e) {

            logError(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.CONFLICT);

    }

    @RequestMapping(value = AppViewThuTuc01Constant.ViewURL.LUU_THONG_TIN_FILE_DINH_KEM_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<Object> luuThongTinFileDinhKem(@PathVariable("id") long idHS, @RequestBody TbdTepTin1 tepTin1, HttpServletRequest request) {
        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null || tepTin1 == null || tepTin1.getIdHS() < 1 || idHS < 1) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            if (StringUtils.hasText(tepTin1.getTenLoaiTep())) {
                int endIndex = tepTin1.getTenLoaiTep().length();
                if (endIndex > 250) {
                    endIndex = 250;
                }
                tepTin1.setTenLoaiTep(tepTin1.getTenLoaiTep().substring(0, endIndex));
            }

            tepTin1 = mTbdTepTin1Service.saveTbdTepTin1(tepTin1);

            if (tepTin1 != null) {

                TbdHSDeNghiCapGiayXn1 capGiayXn1 = mTbdHSDeNghiCapGiayXn1Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                luuLichSuTacDong(capGiayXn1, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.them-moi-tep-dinh-kem", new Object[]{tepTin1.getTenTepTin(), capGiayXn1.getMaHoSo(), userInfo.getMaSoThue()}, request.getLocale()));

                return createResponseEntity(tepTin1, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
            }

        } catch (Exception e) {

            logError(e);
            pushLog(e);

        }

        return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);

    }

    private void luuLichSuTacDong(TbdHSDeNghiCapGiayXn1 capGiayXn1, String message) {

        try {

            if (capGiayXn1 == null) {
                return;
            }

            UserInfo userInfo = LoginUtil.getUserInfo();

            TbdKetQuaXuLy1 ketQuaXuLy1 = new TbdKetQuaXuLy1();

            ketQuaXuLy1.setDonViXuLy(userInfo.getTenDN());

            ketQuaXuLy1.setIdHS(capGiayXn1.getIdHS());

            ketQuaXuLy1.setNgayTao(DateUtil.getNowDate());

            ketQuaXuLy1.setNgayXuLy(DateUtil.getNowDate());

            ketQuaXuLy1.setTrangThai(capGiayXn1.getTrangThai());

            ketQuaXuLy1.setNoiDung(message);

            mTbdKetQuaXuLy1Service.saveTbdKetQuaXuLy1(ketQuaXuLy1);

        } catch (Exception e) {

            logError(e);
            pushLog(e);
        }
    }

    private synchronized String getMaHoSo() {

        return UIDUtil.makePK(1L);
    }

    @RequestMapping(value = AppViewThuTuc01Constant.ViewURL.DOWNLOAD_GIAY_XAC_NHAN_URL, method = RequestMethod.GET)
    public void downloadFileGiayXacNhan(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) {

        try {

            List<TbdCapGiayXacNhan1> capGiayXacNhan1s = mTbdCapGiayXacNhan1Service.findByIdHSOrderByIdGxnDesc(id);

            if (capGiayXacNhan1s == null || capGiayXacNhan1s.isEmpty()) {
                return;
            }

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
                if (fileContent == null) {
                    fileContent = new byte[0];
                }
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

    @ResponseBody
    @RequestMapping(value = "/checkCertificateStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> checkCertificateStatus(@RequestBody String body) {

        LOGGER.info("checkCertificateStatus: {}", body);
        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
            }
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;
            ResponseMessage responseMessage = SendUtil.callWs(environment.getRequiredProperty("monre.01.CAService"), user.getUsername(), body);
            return createResponseEntity(responseMessage.getStatus(), 0L, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, LocaleContextHolder.getLocale()), responseMessage.isSuccess(), HttpStatus.OK);

        } catch (Exception e) {

            LOGGER.error("[checkCertificateStatus]", e);
            pushLog(e);
        }
        return createResponseEntity(null, 0L, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
    }

}
