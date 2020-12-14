/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.nsw.constant.PropertyConstant;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.moh.constant.ThuTuc06Constant;
import com.nsw.moh.helper.ThuTuc06Helper;
import com.nsw.moh.p06.model.Tbdhoso6;
import com.nsw.moh.p06.model.Tbdlichsu;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.LogUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@Controller
@RequestMapping("/moh/06")
public class Thutuc06Controller {

    private static final int NOPMOI = 1;
    private static final int NOPBOXUNG = 2;
    private static final String CLASS_NAME = "ThuTuc06Controller";

    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    /**
     * index page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ThuTuc06Helper helper = new ThuTuc06Helper();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, helper, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return ThuTuc06Constant.Page.HOME;
    }

    /**
     * view them moi ho so
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/hoso"}, method = RequestMethod.GET)
    public String create(ModelMap model) {
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        ObjectMapper mapper = new ObjectMapper();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ThuTuc06Helper helper = new ThuTuc06Helper();
        ResponseJson dm = helper.getDanhMuc(
                apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.DVNHANHOSO),
                rabbitMQService.getRabbitMQInfo()
        );
        if (principal instanceof UserDetails) {
            Tbdhoso6 hoso = createNewDocument();
            UserCustom user = (UserCustom) principal;
            model.addAttribute("hoso", hoso);

            try {
                model.addAttribute("data", mapper.writeValueAsString(hoso));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(Thutuc06Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.addAttribute(
                    ThuTuc06Constant.DATA_LABLE.DONVINHANHOSO, dm
            );
            model.addAttribute(ThuTuc06Constant.DATA_LABLE.LOAIPHI, NOPMOI);
            initData(model, helper, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return ThuTuc06Constant.Page.CREATE;
    }

    /**
     * view edit ho so
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = {"/hoso/{id}"}, method = RequestMethod.GET)
    public String editHoSo(@PathVariable String id, ModelMap model) {
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ThuTuc06Helper helper = new ThuTuc06Helper();

        ObjectMapper mapper = new ObjectMapper();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;

            initData(model, helper, user);
            //Check Id value
            Tbdhoso6 hoso;
            if (id.equals(ThuTuc06Constant.DefaultValue.VALUE_0S)) {
                hoso = createNewDocument();
            } else {
                hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), Long.parseLong(id));
                if (user.getUsername().equals(hoso.getFiNguoitao())) {
                    model.addAttribute(AppConstant.Display.HideImportName, AppConstant.Display.Hide);
                    model.addAttribute(AppConstant.Display.IsView, AppConstant.Display.Show);
                    model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
                    model.addAttribute(
                            ThuTuc06Constant.DATA_LABLE.DONVINHANHOSO,
                            helper.getDanhMuc(
                                    apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.DVNHANHOSO),
                                    rabbitMQService.getRabbitMQInfo()
                            )
                    );
                    try {
                        model.addAttribute("data", mapper.writeValueAsString(hoso));
                    } catch (JsonProcessingException ex) {
                        Logger.getLogger(Thutuc06Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return AppConstant.Pages.ACCESSDINED;
                }
            }
            model.addAttribute("hoso", hoso);
            if (hoso.getListOfTbdthanhtoan().size() > 0) {
                model.addAttribute(ThuTuc06Constant.DATA_LABLE.LOAIPHI, NOPBOXUNG);
            } else {
                model.addAttribute(ThuTuc06Constant.DATA_LABLE.LOAIPHI, NOPMOI);
            }

        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }

        return ThuTuc06Constant.Page.CREATE;
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
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ThuTuc06Helper helper = new ThuTuc06Helper();
        RabbitMQInfo mqInfo = rabbitMQService.getRabbitMQInfo();
        try {
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;
                //Check Id value
                if (id.equalsIgnoreCase(ThuTuc06Constant.DefaultValue.VALUE_0S)) {
                    return AppConstant.Pages.ACCESSDINED;
                }
                Tbdhoso6 hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), Long.parseLong(id));

                ObjectMapper mapper = new ObjectMapper();

                if (user.getUsername().equals(hoso.getFiNguoitao())) {
                    model.addAttribute(ThuTuc06Constant.DATA_LABLE.HoSo, hoso);
                    model.addAttribute("data", mapper.writeValueAsString(hoso));
                    initData(model, helper, user);
                    model.addAttribute(AppConstant.Display.HideImportName, AppConstant.Display.Hide);
                    model.addAttribute(AppConstant.Display.IsView, AppConstant.Display.Hide);
                    model.addAttribute(
                            ThuTuc06Constant.DATA_LABLE.DONVINHANHOSO,
                            helper.getDanhMuc(
                                    apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.DVNHANHOSO),
                                    rabbitMQService.getRabbitMQInfo()
                            )
                    );

                } else {
                    return AppConstant.Pages.ACCESSDINED;
                }

            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

            return ThuTuc06Constant.Page.CREATE;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);

            return AppConstant.ControllerURI.ERROR;
        }
    }

    @RequestMapping(value = "/phieutiepnhan/{id}/", method = RequestMethod.GET)
    public String viewPhieuTiepNhan(@PathVariable String id, ModelMap model) {
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ThuTuc06Helper helper = new ThuTuc06Helper();
        RabbitMQInfo mqInfo = rabbitMQService.getRabbitMQInfo();
        try {
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;

                //Check Id value
                if (id == null) {
                    return AppConstant.Pages.ACCESSDINED;
                }
                Tbdhoso6 hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc06Constant.API.HOSO)), Long.parseLong(id));

                ObjectMapper mapper = new ObjectMapper();

                if (user.getUsername().equals(hoso.getFiNguoitao())) {
                    ResponseJson history = helper.getDanhMuc(
                            apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.LICHSU) + id,
                            rabbitMQService.getRabbitMQInfo()
                    );

                    String jsonData = mapper.writeValueAsString(history.getData());
                    List<Tbdlichsu> lichsu = mapper.readValue(jsonData, new TypeReference<List<Tbdlichsu>>() {
                    });
                    Tbdlichsu lichsutiepnhan = null;
                    for (Tbdlichsu ls : lichsu) {
                        if (ls.getFiTrangthai() == ThuTuc06Constant.Status.DA_TRA_KET_QUA) {
                            lichsutiepnhan = ls;
                            break;
                        }
                    }
                    String nguoiTiepNhan = "";
                    if (lichsutiepnhan != null) {
                        nguoiTiepNhan = lichsutiepnhan.getFiTenNggui();
                    }
//                        String nguoiTiepNhan = lichsu.get(lichsu.size()-1).getFiTenNggui();
                    model.addAttribute(ThuTuc06Constant.DATA_LABLE.NGUOITIEPNHAN, nguoiTiepNhan);
                    model.addAttribute(ThuTuc06Constant.DATA_LABLE.HoSo, hoso);
                    model.addAttribute("data", mapper.writeValueAsString(hoso));
                    initData(model, helper, user);
                    model.addAttribute(AppConstant.Display.HideImportName, AppConstant.Display.Hide);
                    model.addAttribute(AppConstant.Display.IsView, AppConstant.Display.Hide);
                    model.addAttribute(
                            ThuTuc06Constant.DATA_LABLE.DONVINHANHOSO,
                            helper.getDanhMuc(
                                    apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.DVNHANHOSO),
                                    rabbitMQService.getRabbitMQInfo()
                            )
                    );

                } else {
                    return AppConstant.Pages.ACCESSDINED;
                }

            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

            return ThuTuc06Constant.Page.PHIEUTIEPNHAN;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);

            return AppConstant.ControllerURI.ERROR;
        }
    }

    private void initData(ModelMap model, ThuTuc06Helper helper, UserCustom user) {
        ObjectMapper mapper = new ObjectMapper();
        String apiURI = environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND);
        ResponseJson countries = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.COUNTRIES),
                rabbitMQService.getRabbitMQInfo());

        String mp = "";
        try {
            mp = mapper.writeValueAsString(countries.getData());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Thutuc06Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Menu, API URL, USERNAME, Version
        //model.addAttribute()
        model.addAttribute(
                ThuTuc06Constant.DATA_LABLE.UPLOAD_DIALOG,
                environment.getRequiredProperty(ThuTuc06Constant.API.UPLOAD_DIALOG)
        );
        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
        model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc06Constant.ISSIGN));
        model.addAttribute(
                ThuTuc06Constant.DATA_LABLE.TINHTHANH,
                helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc06Constant.API.TINHTHANHPHO),
                        rabbitMQService.getRabbitMQInfo())
        );

        model.addAttribute(ThuTuc06Constant.DATA_LABLE.COUNTRIES, mp);

    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc06Constant.API.BACKEND) + restUri;
    }

    /**
     * Khoi tao gia tri cho mot ho so moi
     *
     * @return
     */
    private Tbdhoso6 createNewDocument() {
        Tbdhoso6 hoso = new Tbdhoso6();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;

        hoso.setFiIdHoso(ThuTuc06Constant.DefaultValue.VALUE_0L);
        hoso.setFiMst(user.getUsername());
        hoso.setFiTendn(user.getCompanyName());
        hoso.setFiDiachidn(user.getCompanyAddress());
        hoso.setFiSodtdn(user.getCompanyPhoneNumber());
        hoso.setFiFaxdn(user.getCompanyFax());
        hoso.setFiEmaildn(user.getCompanyEmail());
        hoso.setFiTennguoidaidien(user.getRepresenterName());
        hoso.setFiDienthoaidd(user.getRepresenterMobile());
        hoso.setFiDienthoaicd(user.getRepresenterPhone());
        hoso.setFiLoaihinhdn(user.getCompanyType());
        hoso.setFiPhongbanquanly(user.getDepartmentManage());
        hoso.setFiTentienganhdn(user.getEngName());
        hoso.setFiTenviettatdn(user.getShortName());
        hoso.setFiSodkkd(user.getRegistrationNo());
        if (user.getConstitutionYear() != null) {
            hoso.setFiNamthanhlap(Long.parseLong(user.getConstitutionYear()));
        }
        hoso.setFiWebsite("");
        hoso.setFiHoatdong(ThuTuc06Constant.DefaultValue.VALUE_0L);
        hoso.setFiMatinh(ThuTuc06Constant.DefaultValue.VALUE_1S);

        return hoso;
    }
}
