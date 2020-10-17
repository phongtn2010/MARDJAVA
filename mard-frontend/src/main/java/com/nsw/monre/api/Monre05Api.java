package com.nsw.monre.api;

import java.net.URI;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.common.model.ResponseDownload;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.monre.p05.constant.*;
import com.nsw.monre.p05.model.*;
import com.nsw.monre.p01.model.ResponseJson;
import com.nsw.monre.p01.model.SendMessage;
import com.nsw.monre.p01.model.TbdCapGiayXacNhan1;
import com.nsw.monre.p01.model.TbsCoQuanXuLy1;
import com.nsw.monre.p01.model.TbsStatus1;
import com.nsw.monre.p05.searchitem.*;
import com.nsw.monre.p05.service.*;
import com.nsw.security.UserCustom;
import com.nsw.monre.common.CertificateUtils;
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
@RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.URI_THU_TUC_05})
public class Monre05Api {

    private static final Logger LOGGER = LoggerFactory.getLogger(Monre05Api.class);

    private static final String CLASS_NAME = "Monre05Api";

    private static final String SELECT_BOX_LABEL_KEY = "monre.01.select.label-default";

    private static final String SEND_NOT_OK = "sendNotOkMessage";

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
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.DANH_SACH_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

            item.setFimasothue(LoginUtil.getUserInfo().getMaSoThue());

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

        return item;
    }

    /**
     * Lay danh sach lich su xu ly ho so theo id ho so
     *
     * @param request
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.LAY_DANH_SACH_KET_QUA_XU_LY}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachKetQuaXuLy(HttpServletRequest request, @RequestBody TbdKetQuaXuLy5 form) {

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            TbdKetQuaXuLy5SearchItem searchItem = new TbdKetQuaXuLy5SearchItem();

            searchItem.setPageIndex(form.getPageIndex());

            searchItem.setFiidhs(form.getIdHS());

            searchItem.setOrderBy("FiidkqDESC");

            searchItem.setPageSize(AppKeyConstant.Page.PAGE_SIZE_IN_POPUP);

            long total = mTbdKetQuaXuLy5Service.countSearchTbdKetQuaXuLy5(searchItem);

            List<TbdKetQuaXuLy5> ketQuaXuLy5s = mTbdKetQuaXuLy5Service.searchTbdKetQuaXuLy5s(searchItem);

            if (ketQuaXuLy5s != null) {
                int i = 0;
                for (TbdKetQuaXuLy5 item : ketQuaXuLy5s) {
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

            Object data = ketQuaXuLy5s;

            return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), true, HttpStatus.OK);
    }

    /**
     * Lay danh sach tat ca trang thai
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.DANH_SACH_TAT_CA_TRANG_THAI}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachTrangThai(HttpServletRequest request) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            List<TbsStatus1> dsStatus5s = new ArrayList<>();

            TbsStatus1 pl0 = new TbsStatus1();

            pl0.setTenTrangThai(getMessage(SELECT_BOX_LABEL_KEY, request.getLocale()));

            pl0.setIdTrangThai(-5);

            dsStatus5s.add(pl0);
            List<TbsStatus1> tbsStatuss = mTbsStatusService.getTbsStatus1s();

            if (tbsStatuss != null) {
                dsStatus5s.addAll(tbsStatuss);
            }

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
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.DANH_SACH_TAT_CA_CO_QUAN_XU_LY}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachCoQuanXuLy(HttpServletRequest request) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
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
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.LAY_THONG_TIN_SO_GIAY_XAC_NHAN_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> layThongTinGiayXacNhanTheoSoGXN(@PathVariable("idHS") long idHS, @PathVariable("soGXN") String soGiayXN, HttpServletRequest request) {

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
     * Gui thong bao xin rut ho so
     *
     * @param request
     * @return
     */
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.DON_XIN_RUT_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> yeuCauXinRutHoSo(HttpServletRequest request, @RequestBody TbdYeuCauRutHS5 form) {
        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            TbdHSDeNghiCapGiayXn5 pTbdHSDeNghiCapGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.getTbdHSDeNghiCapGiayXn5(form.getIdHS());

            int trangThai = pTbdHSDeNghiCapGiayXn5.getTrangThai();

            String function = (trangThai == AppKeyConstant.Status.GUI_MOI || trangThai == AppKeyConstant.Status.KHAI_SUA) ? AppKeyConstant.TNMT01FUNCTION.FUNCTION_03 : AppKeyConstant.TNMT01FUNCTION.FUNCTION_11;

            TbdYeuCauRutHS5 tbdYeuCauRutHS5 = new TbdYeuCauRutHS5();

            SendMessage sendMessage = new SendMessage();

            tbdYeuCauRutHS5.setIdHS(form.getIdHS());
            tbdYeuCauRutHS5.setNgayRut(new Date());
            tbdYeuCauRutHS5.setNoiDung(form.getNoiDung());

            tbdYeuCauRutHS5 = mTbdYeuCauRutHS5Service.saveTbdYeuCauRutHS5(tbdYeuCauRutHS5);

            if (tbdYeuCauRutHS5 != null) {

                TbdHSDeNghiCapGiayXn5 capGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(form.getIdHS(), AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                String uri = AppViewThuTuc05Constant.ViewURL.BACKEND_SEND_MESSAGE_URL;

                sendMessage.setFiIdHoso(capGiayXn5.getIdHS());
                sendMessage.setfIdBanTin(tbdYeuCauRutHS5.getId());
                sendMessage.setType(AppKeyConstant.TNMT01TYPE.TYPE_15);
                sendMessage.setFunction(function);

                ResponseJson responseJson = createRestTemplate(uri, sendMessage, HttpMethod.POST, null);

                if (responseJson != null && responseJson.isSuccess()) {

                    if (trangThai != AppKeyConstant.Status.GUI_MOI || trangThai != AppKeyConstant.Status.KHAI_SUA) {

                        pTbdHSDeNghiCapGiayXn5.setTrangThai(AppKeyConstant.Status.YEU_CAU_XIN_RUT_HO_SO);

                    } else {

                        pTbdHSDeNghiCapGiayXn5.setTrangThai(AppKeyConstant.Status.YEU_CAU_RUT_HO_SO);
                    }

                    capGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.updateTbdHSDeNghiCapGiayXn5(form.getIdHS(), pTbdHSDeNghiCapGiayXn5);

                    luuLichSuTacDong(capGiayXn5, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.them-moi-yeu-cau-rut-theo-ho-so-ho-so", new Object[]{tbdYeuCauRutHS5.getNoiDung(), capGiayXn5.getMaHoSo(), userInfo.getMaSoThue() + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale())}, request.getLocale()));

                    return createResponseEntity(capGiayXn5, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), responseJson.isSuccess(), HttpStatus.OK);

                } else {
                    luuLichSuTacDong(capGiayXn5, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.them-moi-yeu-cau-rut-theo-ho-so-ho-so", new Object[]{tbdYeuCauRutHS5.getNoiDung(), capGiayXn5.getMaHoSo(), userInfo.getMaSoThue() + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale())}, request.getLocale()));

                }

            }
        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
    }

    private ResponseJson createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params) {

        String host = environment.getRequiredProperty(ThuTuc05Constant.HOST_NAME);

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

    /**
     * Xoa ho so theo ID. Chi thay doi trang thai
     *
     * @param id
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.XOA_HO_SO_URL + "/{idHS}"}, method = RequestMethod.POST)
    public ResponseEntity<Object> xoaHoSo(@PathVariable("idHS") long idHS, HttpServletRequest request) {

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            TbdHSDeNghiCapGiayXn5 deNghiCapGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

            if (deNghiCapGiayXn5 != null && userInfo.getMaSoThue().equals(deNghiCapGiayXn5.getMaSoThue())) {

                deNghiCapGiayXn5.setXoa(1);

                Object data = mTbdHSDeNghiCapGiayXn5Service.updateTbdHSDeNghiCapGiayXn5(idHS, deNghiCapGiayXn5);

                luuLichSuTacDong(deNghiCapGiayXn5, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.xoa-ho-so-ho-so", new Object[]{deNghiCapGiayXn5.getIdHS(), userInfo.getMaSoThue()}, request.getLocale()));

                return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
            }

        } catch (Exception e) {

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
    @RequestMapping(value = {"/getHoSo/{idHS}"}, method = RequestMethod.POST)
    public ResponseEntity<Object> getHoSo(@PathVariable("idHS") long idHS, HttpServletRequest request) {

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
            HoSoEditForm form = new HoSoEditForm();
            form.setCoQuanXuLyList(getCoQuanXuLy(request));
            if (idHS <= 0) {
                form = ConvertToObjectUtil.convertTo(userInfo, form);
                form.setNgayCapGCNDKKD(userInfo.getNgayCapGCNDKKD());
                form.setNgayCapGCNDKKDDateFormat(userInfo.getNgayCapGCNDKKD());

            } else {
                TbdHSDeNghiCapGiayXn5 deNghiCapGiayXn1 = mTbdHSDeNghiCapGiayXn5Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                if (deNghiCapGiayXn1 != null && userInfo.getMaSoThue().equals(deNghiCapGiayXn1.getMaSoThue())) {

                    form = ConvertToObjectUtil.convertTo(deNghiCapGiayXn1, form);
                    form.setNgayCapDateFormat(deNghiCapGiayXn1.getNgayCap());
                    form.setNgayHetHanDateFormat(deNghiCapGiayXn1.getNgayHetHan());
                    form.setNgayCapGCNDKKDDateFormat(deNghiCapGiayXn1.getNgayCapGCNDKKD());
                    form.setCoQuanXuLyList(getCoQuanXuLy(request));
                    form.setTepDinhKemList(mTbdTepTin5Service.findByIdHSOrderByLoaiTepTinAsc(idHS));

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
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.GHI_HO_SO_URL}, method = RequestMethod.POST)
    public ResponseEntity<Object> ghiHoSo(@RequestBody HoSoEditForm form, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {

        form.setNgayCap(form.getNgayCapDateFormat());
        form.setNgayHetHan(form.getNgayHetHanDateFormat());
        form.setNgayCapGCNDKKD(form.getNgayCapGCNDKKDDateFormat());
        TbdHSDeNghiCapGiayXn5 capGiayXn = new TbdHSDeNghiCapGiayXn5();

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

            if (form.isGuiHoSo() && isSign()) {
                ResponseJson responseJson = guiHoSo(capGiayXn, null, true);
                X509Certificate x509Cert = CertificateUtils.getX509Cert(form.getSerialNumber());
                if (!ObjectUtils.isEmpty(x509Cert) && !Objects.isNull(responseJson)) {
                    String sn = x509Cert.getSerialNumber().toString(16);
                    form.setSerialNumber(sn);
                    form.setXmlEnvelop(responseJson.getData().toString());
                    form.setXmlBody(responseJson.getMessage());
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
    public String send(@ModelAttribute("form") TbdHSDeNghiCapGiayXn5 form, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        String time = dateFormat.format(new Date());

        LOGGER.info("SEN HO SO 05 ID = {}, Time = {}", form.getIdHS(), time);
        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }
            TbdHSDeNghiCapGiayXn5 capGiayXn = mTbdHSDeNghiCapGiayXn5Service.getTbdHSDeNghiCapGiayXn5(form.getIdHS());
            if (capGiayXn == null) {
                redirectAttributes.addFlashAttribute(SEND_NOT_OK, getMessage("error.monre.01.send.success", request.getLocale()));
                return AppCommon.redirectPage(request, AppViewThuTuc01Constant.ViewURL.KHAI_HO_SO_MOI_URL + "/" + form.getIdHS());
            }
            if (guiHoSo(capGiayXn, null, false).isSuccess()) {
                luuLichSuTacDong(capGiayXn, getMessage("monre.01.lichsu.guihoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()));
                LOGGER.info("[GUI HO SO THANH CONG][TIME = {}]", time);
                redirectAttributes.addFlashAttribute("sendOkMessage", getMessage("error.monre.01.send.success", request.getLocale()));
                return "redirect:/monre/05/home";
            } else {
                luuLichSuTacDong(capGiayXn, getMessage("monre.01.lichsu.guihoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()));
                LOGGER.info("[GUI HO SO KHONG THANH CONG][TIME = {}]", time);
                redirectAttributes.addFlashAttribute(SEND_NOT_OK, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            redirectAttributes.addFlashAttribute(SEND_NOT_OK, getMessage("error.monre.01.send.error.loihethong", request.getLocale()));
        }

        return "redirect:/monre/05/edit/" + form.getIdHS();
    }

    @ResponseBody
    @RequestMapping(value = {"/sendHoSo/{idHoSo}"}, method = RequestMethod.POST)
    public ResponseEntity<Object> sendHoSo(HttpServletRequest request, @PathVariable("idHoSo") long idHoSo) {
        UserInfo userInfo = LoginUtil.getUserInfo();

        if (userInfo.getMaSoThue() == null) {
            return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        String time = dateFormat.format(new Date());

        LOGGER.info("SEN HO SO ID = {}, Time = {}", idHoSo, time);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;
        TbdHSDeNghiCapGiayXn5 capGiayXn = mTbdHSDeNghiCapGiayXn5Service.getTbdHSDeNghiCapGiayXn5(idHoSo);
        if (capGiayXn == null || !Objects.equals(user.getUsername(), capGiayXn.getMaSoThue())) {
            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
        }

        if (guiHoSo(capGiayXn, null, false).isSuccess()) {
            luuLichSuTacDong(capGiayXn, getMessage("monre.01.lichsu.guihoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()));
            LOGGER.info("[GUI HO SO THANH CONG][TIME = {}]", time);
            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_SUCCESS, LocaleContextHolder.getLocale()), true, HttpStatus.OK);
        } else {
            luuLichSuTacDong(capGiayXn, getMessage("monre.01.lichsu.guihoso", request.getLocale()) + ". " + getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()));
            LOGGER.info("[GUI HO SO KHONG THANH CONG][TIME = {}]", time);
            return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, LocaleContextHolder.getLocale()), false, HttpStatus.OK);
        }
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

    /**
     * Gui ho so di
     *
     * @param hsDeNghiCapGiayXn
     */
    private ResponseJson guiHoSo(TbdHSDeNghiCapGiayXn5 hsDeNghiCapGiayXn, String envelop, boolean layBanTinXml) {
        ResponseJson responseJson = new ResponseJson();
        try {

            String uri = AppViewThuTuc05Constant.ViewURL.BACKEND_SEND_MESSAGE_URL;

            SendMessage sendMessage = new SendMessage();

            int trangThai = hsDeNghiCapGiayXn.getTrangThai();

            String function = null;

            if (trangThai == AppKeyConstant.Status.TAO_MOI) {

                function = AppKeyConstant.TNMT01FUNCTION.FUNCTION_01;

            } else if (trangThai == AppKeyConstant.Status.GUI_MOI || trangThai == AppKeyConstant.Status.KHAI_SUA) {

                function = AppKeyConstant.TNMT01FUNCTION.FUNCTION_02;

            } else if (trangThai == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG || trangThai == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG_SAU_KIEM_TRA) {

                function = AppKeyConstant.TNMT01FUNCTION.FUNCTION_04;
            }

            sendMessage.setType(AppKeyConstant.TNMT01TYPE.TYPE_10);

            sendMessage.setFiIdHoso(hsDeNghiCapGiayXn.getIdHS());

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
            responseJson = createRestTemplate(uri, sendMessage, HttpMethod.POST, null);
            if (layBanTinXml) {
                return responseJson;
            }

            LOGGER.info("GUI HO SO: {}", responseJson);

            if (responseJson != null && responseJson.isSuccess()) {

                if (trangThai == AppKeyConstant.Status.TAO_MOI) {
                    hsDeNghiCapGiayXn.setTrangThai(AppKeyConstant.Status.GUI_MOI);
                }

                if (trangThai == AppKeyConstant.Status.GUI_MOI) {
                    hsDeNghiCapGiayXn.setTrangThai(AppKeyConstant.Status.KHAI_SUA);
                } else if (trangThai == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG || trangThai == AppKeyConstant.Status.YEU_CAU_SUA_DOI_BO_SUNG_SAU_KIEM_TRA) {
                    hsDeNghiCapGiayXn.setTrangThai(AppKeyConstant.Status.SUA_DOI_BO_SUNG);
                }

                hsDeNghiCapGiayXn.setNgayGui(new Date());
                mTbdHSDeNghiCapGiayXn5Service.updateTbdHSDeNghiCapGiayXn5(hsDeNghiCapGiayXn.getIdHS(), hsDeNghiCapGiayXn);
                return responseJson;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            pushLog(e);
        }
        return responseJson;
    }

    private boolean isValidHoSo(TbdHSDeNghiCapGiayXn5 form) {
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

    private TbdHSDeNghiCapGiayXn5 luuThongTinHoSo(TbdHSDeNghiCapGiayXn5 form, HttpServletRequest request) {

        if (!isValidHoSo(form)) {
            return null;
        }

        UserInfo userInfo = LoginUtil.getUserInfo();

        TbdHSDeNghiCapGiayXn5 capGiayXn5 = new TbdHSDeNghiCapGiayXn5();

        if (form.getIdHS() == 0) {

            capGiayXn5.setNgayCap(form.getNgayCap());
            capGiayXn5.setNgayTao(DateUtil.getNowDate());
            capGiayXn5.setHinhThuc(AppCommon.getHinhThuc(request));
            capGiayXn5.setLoaiThuTuc(AppCommon.getLoaiThuTuc(request));
            capGiayXn5.setMaHoSo(getMaHoSo());
            capGiayXn5.setTenDN(userInfo.getTenDN());
            capGiayXn5.setSoGCNDKKD(userInfo.getsoGCNDKKD());
            capGiayXn5.setSoDTNguoiDaiDien(userInfo.getSoDTNguoiDaiDien());
            capGiayXn5.setTruSoChinh(userInfo.getTruSoChinh());
            capGiayXn5.setMaSoThue(form.getMaSoThue());

        } else {

            capGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(form.getIdHS(), AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());
        }

        capGiayXn5.setNguoiDaiDien(form.getNguoiDaiDien());
        capGiayXn5.setFaxNguoiDaiDien(form.getFaxNguoiDaiDien());
        capGiayXn5.setEmailNguoiDaiDien(form.getEmailNguoiDaiDien());
        capGiayXn5.setNgayCapGCNDKKD(form.getNgayCapGCNDKKD());
        capGiayXn5.setNoiCapGCNDKKD(form.getNoiCapGCNDKKD());
        capGiayXn5.setSoGXNDaCap(form.getSoGXNDaCap());
        capGiayXn5.setNgayCap(form.getNgayCap());
        capGiayXn5.setNgayHetHan(form.getNgayHetHan());
        capGiayXn5.setLyDo(form.getLyDo());
        capGiayXn5.setTenCoQuan(form.getTenCoQuan());
        capGiayXn5.setMaCoQuan(form.getMaCoQuan());

        if (!StringUtils.hasText(capGiayXn5.getSoGXNDaCap())) {
            return null;
        }
        if (capGiayXn5.getNgayCap() == null) {
            return null;
        }

        if (capGiayXn5.getNgayHetHan() == null) {
            return null;
        }
        if (!StringUtils.hasText(capGiayXn5.getLyDo())) {
            return null;
        }
        // end

        if (form.getIdHS() > 0) {
            TbdHSDeNghiCapGiayXn5 olDeNghiCapGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.getTbdHSDeNghiCapGiayXn5(capGiayXn5.getIdHS());
            capGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.updateTbdHSDeNghiCapGiayXn5(capGiayXn5.getIdHS(), capGiayXn5);
            if (!olDeNghiCapGiayXn5.toString().equals(capGiayXn5.toString())) {
                luuLichSuTacDong(capGiayXn5, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.cap-nhat-ho-so", new Object[]{capGiayXn5.getMaHoSo(), userInfo.getMaSoThue()}, request.getLocale()));
            }

        } else {
            capGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.saveTbdHSDeNghiCapGiayXn5(capGiayXn5);
            luuLichSuTacDong(capGiayXn5, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.them-moi-ho-so", new Object[]{capGiayXn5.getMaHoSo(), userInfo.getMaSoThue()}, request.getLocale()));
        }

        return capGiayXn5;
    }

    /**
     * Lay danh sach tep tin theo ho so
     *
     * @param request
     * @param idHS
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.DANH_SACH_TEP_TIN_THEO_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> layDanhSachTepTinTheoHoSo(HttpServletRequest request, @PathVariable("id") long idHS) {

        try {
            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null) {

                return createResponseEntity(null, getMessage(AppViewThuTuc01Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }
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
     * @param request
     * @param idHS
     * @param loaiTepTin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.XOA_TOAN_BO_LOAI_TEP_TIN_THEO_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> xoaTepTinTheoHoSo(HttpServletRequest request, @PathVariable("idHS") long idHS, @PathVariable("loaiTepTin") int loaiTepTin) {

        try {

            if (idHS > 0) {

                UserInfo userInfo = LoginUtil.getUserInfo();

                if (userInfo.getMaSoThue() == null) {

                    return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
                }
                TbdTepTin5SearchItem searchItem = new TbdTepTin5SearchItem();

                searchItem.setFiidhs(idHS);

                searchItem.setFiloaiteptin(loaiTepTin);

                Boolean data = mTbdTepTin5Service.deleteBySearchItemTbdTepTin5s(searchItem);

                if (data) {

                    TbdHSDeNghiCapGiayXn5 capGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                    luuLichSuTacDong(capGiayXn5, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.xoa-bo-phe-loai-tep-tin-theo-ho-so-ho-so", new Object[]{loaiTepTin, capGiayXn5.getIdHS(), userInfo.getMaSoThue()}, request.getLocale()));
                }

                return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
            }

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.XOA_TEP_TIN_ID_THEO_HO_SO}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> xoaTepTinIdTheoHoSo(HttpServletRequest request, @PathVariable("idHS") long idHS, @PathVariable("tepTinId") long idTepTin) {

        try {

            if (idHS > 0) {

                UserInfo userInfo = LoginUtil.getUserInfo();

                if (userInfo.getMaSoThue() == null) {

                    return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
                }
                TbdTepTin5 tbdTepTin5 = mTbdTepTin5Service.getTbdTepTin5(idTepTin);

                Boolean data = mTbdTepTin5Service.deleteTbdTepTin5ById(idTepTin);

                if (data) {

                    TbdHSDeNghiCapGiayXn5 capGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(tbdTepTin5.getIdHS(), AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                    luuLichSuTacDong(capGiayXn5, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.xoa-tep-dinh-kem", new Object[]{tbdTepTin5.getTenTepTin(), capGiayXn5.getMaHoSo(), userInfo.getMaSoThue()}, request.getLocale()));

                    return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
                }
            }

        } catch (Exception e) {

            logError(e);

            pushLog(e);
        }

        return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
    }

    @RequestMapping(value = AppViewThuTuc05Constant.ViewURL.LUU_THONG_TIN_FILE_DINH_KEM_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<Object> luuThongTinFileDinhKem(@PathVariable("id") long idHS, @RequestBody TbdTepTin5 tepTin5, HttpServletRequest request) {

        Object data = null;

        try {

            UserInfo userInfo = LoginUtil.getUserInfo();

            if (userInfo.getMaSoThue() == null || tepTin5 == null) {
                return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);
            }

            TbdTepTin5 tbdTepTin5 = mTbdTepTin5Service.saveTbdTepTin5(tepTin5);

            System.out.println("Monre05Api.luuThongTinFileDinhKem()" + tbdTepTin5.toString());
            if (tbdTepTin5 != null) {

                data = new Object[]{tbdTepTin5};

                TbdHSDeNghiCapGiayXn5 capGiayXn5 = mTbdHSDeNghiCapGiayXn5Service.findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(idHS, AppCommon.getLoaiThuTuc(request), 0, userInfo.getMaSoThue());

                luuLichSuTacDong(capGiayXn5, mMessageSource.getMessage("monre.01.lich-su-tac-dong-tac-dong.them-moi-tep-dinh-kem", new Object[]{tbdTepTin5.getTenTepTin(), capGiayXn5.getMaHoSo(), userInfo.getMaSoThue()}, request.getLocale()));

                return createResponseEntity(data, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_SUCCESS, request.getLocale()), true, HttpStatus.OK);
            }

        } catch (Exception e) {

            pushLog(e);

        }

        return createResponseEntity(null, getMessage(AppViewThuTuc05Constant.PropertyKey.ACTION_ERROR, request.getLocale()), false, HttpStatus.OK);

    }

    /**
     * @param idGXN
     * @param request
     * @return
     */
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.LAY_THONG_TIN_CO_SO_SAN_XUAT_THEO_SO_GIAY_XAC_NHAN_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> layThongTinCoSoSanXuatTheoGiayXacNhan(@PathVariable("idGXN") long idGXN, HttpServletRequest request) {

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
    @RequestMapping(value = {AppViewThuTuc05Constant.ViewURL.LAY_THONG_TIN_PHE_LIEU_THEO_SO_GIAY_XAC_NHAN_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<Object> layThongTinPheLieuTheoGiayXacNhan(@PathVariable("idGXN") long idGXN, HttpServletRequest request) {

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

    private void luuLichSuTacDong(TbdHSDeNghiCapGiayXn5 capGiayXn5, String message) {

        try {

            if (capGiayXn5 == null) {
                return;
            }

            UserInfo userInfo = LoginUtil.getUserInfo();

            TbdKetQuaXuLy5 ketQuaXuLy5 = new TbdKetQuaXuLy5();

            ketQuaXuLy5.setDonViXuLy(userInfo.getTenDN());

            ketQuaXuLy5.setIdHS(capGiayXn5.getIdHS());

            ketQuaXuLy5.setNgayTao(DateUtil.getNowDate());

            ketQuaXuLy5.setNgayXuLy(DateUtil.getNowDate());

            ketQuaXuLy5.setTrangThai(capGiayXn5.getTrangThai());

            ketQuaXuLy5.setNoiDung(message);

            mTbdKetQuaXuLy5Service.saveTbdKetQuaXuLy5(ketQuaXuLy5);

        } catch (Exception e) {

            pushLog(e);
        }
    }

    private synchronized String getMaHoSo() {

        return UIDUtil.makePK(1L);
    }

    @RequestMapping(value = AppViewThuTuc05Constant.ViewURL.DOWNLOAD_GIAY_XAC_NHAN_URL, method = RequestMethod.GET)
    public void downloadFileGiayXacNhan(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) {

        try {

            List<TbdCapGiayXacNhan5> tbdCapGiayXacNhan5s = mTbdCapGiayXacNhan5Service.findByIdHSOrderByIdGxnDesc(id);

            if (tbdCapGiayXacNhan5s == null || tbdCapGiayXacNhan5s.isEmpty()) {
                return;
            }

            TbdCapGiayXacNhan5 tbdCapGiayXacNhan5 = tbdCapGiayXacNhan5s.get(0);

            LOGGER.info("downloadFileGiayXacNhan: {}", tbdCapGiayXacNhan5);

            if (tbdCapGiayXacNhan5 != null) {
                RabbitMQInfo mqInfo = getRabbitMQ();
                String uri = getFullUri("/monre/05/download2/");

                String fileName = FilenameUtils.getName(tbdCapGiayXacNhan5.getLinkGiayXN());
                String filePath = FilenameUtils.getFullPathNoEndSeparator(tbdCapGiayXacNhan5.getLinkGiayXN());
                byte[] fileContent = downloadFile(uri, filePath, fileName, mqInfo);
                if (fileContent == null) {
                    fileContent = new byte[0];
                }

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

    private boolean isSign() {
        return Boolean.parseBoolean(environment.getRequiredProperty("monre.05.sign"));
    }
}
