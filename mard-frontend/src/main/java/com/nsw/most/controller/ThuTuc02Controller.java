/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.json.Tab;
import com.nsw.moh.constant.ThuTuc06Constant;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.constant.ThuTuc02Constant;
import com.nsw.most.helper.ThuTuc02Helper;
import com.nsw.most.p02.model.Tbdhoso2;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import com.nsw.util.LogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nhan
 */
@Controller
@RequestMapping(ThuTuc02Constant.ControllerURI.ROOT)
public class ThuTuc02Controller {

    private static final String CLASS_NAME = "ThuTuc02Controller";

    @Autowired
    Environment environment;

    @Autowired
    MessageSource messageSource;

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private HttpSession httpSession;

    public List<Tab> getMenuData() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Tab> Tabs = null;
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            
                if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
                    Tabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
                } else {
                    Tabs = AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url"));
                    httpSession.setAttribute(Constants.MENU_SESSION, Tabs);
                }
        }
        return Tabs;
    }

    private RabbitMQInfo getRabbitMQ() {
        return rabbitMQService.getRabbitMQInfo();
    }

    /**
     * View danh sach ho so
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {ThuTuc02Constant.ControllerURI.HOME}, method = RequestMethod.GET)
    public String indexPage(ModelMap model
    ) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ThuTuc02Helper helper = new ThuTuc02Helper();
//        String apiURI = environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND);
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;

                setBreadcrumb(false, model);
                initData(model, helper, user);
                //model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
                model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
                model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
                model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
                model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
                model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc02Constant.EnableSign));

            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return ThuTuc02Constant.PAGE.HOME;
    }

    /**
     * Man hinh tao moi ho so
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {ThuTuc02Constant.ControllerURI.HOSO + "/{id}"}, method = RequestMethod.GET)
    public String createPage(@PathVariable String id, ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ThuTuc02Helper helper = new ThuTuc02Helper();
        RabbitMQInfo mqInfo = getRabbitMQ();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String apiURI = environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND_COMMON);
            ResponseJson countries = helper.getDanhMuc(apiURI + ThuTuc02Constant.API.GET_STATE,
                    rabbitMQService.getRabbitMQInfo());
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;
                
                    initData(model, helper, user);
                    setBreadcrumb(true, model);
                    Tbdhoso2 hoso;
                    if (id.equals(ThuTuc01Constant.DefaultValue.VALUE_0S)) {
                        hoso = createNewDocument();
                    } else {
                        hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty("most.02.api.gethoso")), Long.parseLong(id), mqInfo);
                        if (user.getUsername().equals(hoso.getFiNguoitao())) {
                            model.addAttribute(AppConstant.Display.HideImportName, AppConstant.Display.Hide);
                            model.addAttribute(AppConstant.Display.IsView, AppConstant.Display.Show);
                            if (!Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.TAO_MOI)
                                    && !Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.CHO_TIEP_NHAN)) {
                                model.addAttribute(ThuTuc02Constant.DATA_LABLE.HAS_REASON, true);
                            }
                        } else {
                            return AppConstant.Pages.ACCESSDINED;
                        }
                    }
                    String getCuaKhauURL = environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(ThuTuc02Constant.API.CUAKHAU);
                    ResponseJson cuakhau = helper.getDanhMuc(getCuaKhauURL, mqInfo);
                    ResponseJson tenPT = helper.getDanhMuc(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.TENPHUONGTIEN)), mqInfo);

                    model.addAttribute(ThuTuc02Constant.DATA_LABLE.CUAKHAU, cuakhau);
                    model.addAttribute(ThuTuc02Constant.DATA_LABLE.HOSODATA, hoso);
                    model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
                    model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc02Constant.EnableSign));
                    String hosoStr = mapper.writeValueAsString(hoso);
                    model.addAttribute(ThuTuc02Constant.DATA_LABLE.HOSOJSON, hosoStr);
                    model.addAttribute(ThuTuc02Constant.DATA_LABLE.COUNTRY, countries);
                    model.addAttribute(ThuTuc02Constant.DATA_LABLE.TENPHUONGTIEN, tenPT);

                }
            

            return ThuTuc02Constant.PAGE.HOSO;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        //Return error
        return AppConstant.ControllerURI.ERROR;
    }

    /**
     * xem chi tiet ho so
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/view/{id}/", method = RequestMethod.GET)
    public String viewPage(@PathVariable String id, ModelMap model) {
        //String apiURI = environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ThuTuc02Helper helper = new ThuTuc02Helper();
        RabbitMQInfo mqInfo = rabbitMQService.getRabbitMQInfo();
        try {
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;

                //Check Id value
                if (id == null || id.equalsIgnoreCase(ThuTuc02Constant.DefaultValue.VALUE_0S)) {
                    return AppConstant.Pages.ACCESSDINED;
                }
                Tbdhoso2 hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty("most.02.api.gethoso")), Long.parseLong(id), mqInfo);

                ObjectMapper mapper = new ObjectMapper();

                if (user.getUsername().equals(hoso.getFiNguoitao())) {
                    model.addAttribute(ThuTuc02Constant.DATA_LABLE.HOSODATA, hoso);
                    model.addAttribute(AppConstant.Display.IsView, AppConstant.Display.Hide);
                    model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
                    model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc02Constant.EnableSign));
                    String hosoStr = mapper.writeValueAsString(hoso);
                    model.addAttribute(ThuTuc02Constant.DATA_LABLE.HOSOJSON, hosoStr);
//                    model.addAttribute(ThuTuc02Constant.DATA_LABLE.COUNTRY, countries);

                } else {
                    return AppConstant.Pages.ACCESSDINED;
                }

            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

            return ThuTuc02Constant.PAGE.VIEW;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);

            return AppConstant.ControllerURI.ERROR;
        }
    }

    private void setBreadcrumb(boolean isDetail, ModelMap model) {
        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        Breadcrumb nav = new Breadcrumb("most/02/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
        breadcrumbs.add(nav);
        if (isDetail) {
            nav = new Breadcrumb("#", environment.getRequiredProperty(AppConstant.Breadcrumb.DETAIL));
            breadcrumbs.add(nav);
        }
        model.addAttribute(AppConstant.Common.BREADCRUMB, breadcrumbs);
    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND) + restUri;
    }

    /**
     * Khoi tao cac gia tri ban dau
     *
     * @param model
     * @param helper
     * @param user
     */
    private void initData(ModelMap model, ThuTuc02Helper helper, UserCustom user) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        //String apiURIBackendCommon = environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND_COMMON);
        String apiURI = environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND);
        model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
        model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
        model.addAttribute(AppConstant.DanhMuc.User, user);
        model.addAttribute(AppConstant.DanhMuc.DonViTinh,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_DVT), mqInfo));
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc02Constant.EnableSign));
        ResponseJson cqxl = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc02Constant.API.COQUANXULY),
                rabbitMQService.getRabbitMQInfo());

        model.addAttribute(
                ThuTuc02Constant.DATA_LABLE.COQUANXULY,
                cqxl
        );
//        model.addAttribute(ThuTuc02Constant.DATA_LABLE.DanhSachDVHaiQuan,
//                helper.getDanhMuc(apiURIBackendCommon + environment.getRequiredProperty(AppConstant.API.NSW_API_DSHQ), mqInfo));
    }

    /**
     * Khoi tao gia tri cho mot ho so moi
     *
     * @return
     */
    private Tbdhoso2 createNewDocument() {
        Tbdhoso2 hoso = new Tbdhoso2();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;

        hoso.setFiIdHoso(ThuTuc01Constant.DefaultValue.VALUE_0L);
        hoso.setFiMstDn(user.getUsername());
        hoso.setFiTenDnNk(user.getCompanyName());
        hoso.setFiDiachiDnNk(user.getCompanyAddress());
        hoso.setFiDtDnNk(user.getCompanyPhoneNumber());
        hoso.setFiFaxDnNk(user.getCompanyFax());
        hoso.setFiNguoiDd(user.getRepresenterName());
        hoso.setFiTrangthai(ThuTuc01Constant.DefaultValue.VALUE_0L);

        return hoso;
    }

}
