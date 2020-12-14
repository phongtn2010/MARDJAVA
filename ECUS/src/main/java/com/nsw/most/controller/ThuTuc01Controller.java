/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.Breadcrumb;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.json.Tab;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.helper.ThuTuc01Helper;
import com.nsw.most.p01.model.Tbdhanghoa1;
import com.nsw.most.p01.model.Tbdhoso1;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import java.util.ArrayList;
import java.util.List;
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
 * @author PhongNguyen
 */
@Controller
@RequestMapping(ThuTuc01Constant.ControllerURI.ROOT)
public class ThuTuc01Controller {

    private static final String CLASS_NAME = "ECUS_ThuTuc01Controller";

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
            if (user != null) {
                if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
                    Tabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
                } else {
                    Tabs = AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url"));
                    httpSession.setAttribute(Constants.MENU_SESSION, Tabs);
                }
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
    @RequestMapping(value = {ThuTuc01Constant.ControllerURI.HOME}, method = RequestMethod.GET)
    public String indexPage(ModelMap model
    ) {
        ThuTuc01Helper helper = new ThuTuc01Helper();
        String apiURI = environment.getRequiredProperty(ThuTuc01Constant.API.BACKEND);
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            setBreadcrumb(false, model);

            model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));

            // Lay danh muc
            model.addAttribute(ThuTuc01Constant.DanhMuc.ToChucKiemTra,
                    helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_TCKT), mqInfo));
            model.addAttribute(ThuTuc01Constant.DanhMuc.ToChucChungNhan,
                    helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_TCDG), mqInfo));

        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return ThuTuc01Constant.Page.HOME;
    }

    /**
     * Man hinh tao moi ho so
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {ThuTuc01Constant.ControllerURI.EDIT}, method = RequestMethod.GET)
    public String editPage(ModelMap model
    ) {
        ThuTuc01Helper helper = new ThuTuc01Helper();
        try {

            initData(model, helper);
            setBreadcrumb(true, model);
            //Init Fake user data
            Tbdhoso1 hoso = createNewDocument();
            model.addAttribute(ThuTuc01Constant.DanhMuc.HoSo, hoso);
            model.addAttribute(AppConstant.Display.HideImportName, AppConstant.Display.Show);
            model.addAttribute(AppConstant.Display.IsView, AppConstant.Display.Show);
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

            return ThuTuc01Constant.Page.EDIT;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQInfo mqInfo = getRabbitMQ();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        //Return error
        return AppConstant.ControllerURI.ERROR;
    }

    /**
     * Man hinh cap nhat thong tin ho so
     *
     * @param id
     * @param model
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = {ThuTuc01Constant.ControllerURI.EDIT_DETAIL}, method = RequestMethod.GET)
    public String editDetailPage(@PathVariable String id, ModelMap model
    ) {
        ThuTuc01Helper helper = new ThuTuc01Helper();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            ObjectMapper mapper = new ObjectMapper();

            initData(model, helper);
            setBreadcrumb(true, model);
            //Check Id value
            Tbdhoso1 hoso = null;
            if (id.equals(ThuTuc01Constant.DefaultValue.VALUE_0S)) {
                hoso = createNewDocument();
            } else {
                hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), Long.parseLong(id), mqInfo);

                model.addAttribute(AppConstant.Display.HideImportName, AppConstant.Display.Hide);
                model.addAttribute(AppConstant.Display.IsView, AppConstant.Display.Show);
                model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
                model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

            }

            model.addAttribute(ThuTuc01Constant.DanhMuc.HoSo, hoso);
            model.addAttribute(ThuTuc01Constant.DanhMuc.HoSoJSON, mapper.writeValueAsString(hoso));

            return ThuTuc01Constant.Page.EDIT;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);

            return AppConstant.ControllerURI.ERROR;
        }
    }

    /**
     * Xem chi tiet ho so
     *
     * @param id
     * @param model
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = {ThuTuc01Constant.ControllerURI.VIEW}, method = RequestMethod.GET)
    public String viewPage(@PathVariable String id, ModelMap model
    ) {

        ThuTuc01Helper helper = new ThuTuc01Helper();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {

            //Check Id value
            if (id == null || id.equalsIgnoreCase(ThuTuc01Constant.DefaultValue.VALUE_0S)) {
                return AppConstant.Pages.ACCESSDINED;
            }

            Tbdhoso1 hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), Long.parseLong(id), mqInfo);

            ObjectMapper mapper = new ObjectMapper();

            model.addAttribute(ThuTuc01Constant.DanhMuc.HoSo, hoso);
            model.addAttribute(ThuTuc01Constant.DanhMuc.HoSoJSON, mapper.writeValueAsString(hoso));
            initData(model, helper);
            setBreadcrumb(true, model);
            model.addAttribute(AppConstant.Display.HideImportName, AppConstant.Display.Hide);
            model.addAttribute(AppConstant.Display.IsView, AppConstant.Display.Hide);

            return ThuTuc01Constant.Page.EDIT;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);

            return AppConstant.ControllerURI.ERROR;
        }

    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc01Constant.API.BACKEND) + restUri;
    }

    /**
     * Khoi tao gia tri cho mot ho so moi
     *
     * @return
     */
    private Tbdhoso1 createNewDocument() {
        Tbdhoso1 hoso = new Tbdhoso1();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;

        hoso.setFiIdHoso(ThuTuc01Constant.DefaultValue.VALUE_0L);
        hoso.setFiMst(user.getUsername());
        hoso.setFiNguoiNk(user.getCompanyName());
        hoso.setFiDiachiNnk(user.getCompanyAddress());
        hoso.setFiDtNnk(user.getCompanyPhoneNumber());
        hoso.setFiFaxNnk(user.getCompanyFax());
        hoso.setFiNguoiLh(user.getCompanyName());
        hoso.setFiEmailNnk(user.getCompanyEmail());
        hoso.setFiMaTckt(ThuTuc01Constant.DefaultValue.VALUE_1S);
        hoso.setFiMaTcdg(ThuTuc01Constant.DefaultValue.VALUE_1S);
        hoso.setFiMaQcvn(ThuTuc01Constant.DefaultValue.VALUE_1S);
        hoso.setFiTrangThai(ThuTuc01Constant.DefaultValue.VALUE_0L);

        return hoso;
    }

    /**
     * Khoi tao cac gia tri ban dau
     *
     * @param model
     * @param helper
     * @param user
     */
    private void initData(ModelMap model, ThuTuc01Helper helper) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        String apiURI = environment.getRequiredProperty(ThuTuc01Constant.API.BACKEND);

        //Menu, API URL, USERNAME, Version
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
        // Lay danh muc
        model.addAttribute(ThuTuc01Constant.DanhMuc.ToChucKiemTra,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_TCKT), mqInfo));
        model.addAttribute(ThuTuc01Constant.DanhMuc.ToChucChungNhan,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_TCDG), mqInfo));
        model.addAttribute(AppConstant.DanhMuc.QuyChuanVietNam,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_QCVN), mqInfo));

        model.addAttribute(AppConstant.DanhMuc.DonViTinh,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_DVT), mqInfo));
        model.addAttribute(ThuTuc01Constant.DanhMuc.NhomHangHoa,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_NHH), mqInfo));
        model.addAttribute(AppConstant.DanhMuc.QuocGia,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_QG), mqInfo));
        model.addAttribute(ThuTuc01Constant.DanhMuc.HangHoaMienKiem,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_MIENKIEM), mqInfo));

        model.addAttribute(ThuTuc01Constant.DanhMuc.LoaiDinhKem,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_LOAIDINHKEM), mqInfo));
        model.addAttribute(ThuTuc01Constant.DanhMuc.LoaiGiayChungNhan,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_GCN), mqInfo));

    }

    private void setBreadcrumb(boolean isDetail, ModelMap model) {
        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        Breadcrumb nav = new Breadcrumb("most/01/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
        breadcrumbs.add(nav);
        if (isDetail) {
            nav = new Breadcrumb("#", environment.getRequiredProperty(AppConstant.Breadcrumb.DETAIL));
            breadcrumbs.add(nav);
        }
        model.addAttribute(AppConstant.Common.BREADCRUMB, breadcrumbs);
    }
}
