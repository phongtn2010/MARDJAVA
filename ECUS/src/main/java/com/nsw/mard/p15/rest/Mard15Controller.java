package com.nsw.mard.p15.rest;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p15.model.TbdDinhKem15;
import com.nsw.mard.p15.model.TbdHoSo15;
import com.nsw.mard.p15.model.TbdThuoc15;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(value = "/mard/15")
public class Mard15Controller extends Mard15CallBack {

    public static final Logger LOGGER = LoggerFactory.getLogger(Mard15Controller.class);

    private static final String REDIRECT_HOME_INDEX = "redirect:/mard/15/home";

    private static final String IS_SIGN_KEY = "mard.15.sign";

    @Autowired
    protected RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    private Mard15TbdHoSo15Resource fldMard15TbdHoSo15Resource;

    @Autowired
    private Mard15TbdDinhKem15Resource fldMard15TbdDinhKem15Resource;

    @Autowired
    private Mard15TbdThuoc15Resource fldMard15TbdThuoc15Resource;




    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes, Locale locale, ModelMap model) {

        try {
            if (gotoLogin()) {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }
            setBreadcrumb(false, model);
            model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
            model.addAttribute(AppConstant.DanhMuc.UserName, SecurityUtil.getTaxName());
            model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
            addAttribute(model, 0, -1);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return "mard.15.home";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String xemHoSo(ModelMap model, HttpServletRequest request, @PathVariable("id") long id) {

        try {
            if (gotoLogin()) {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }
            setBreadcrumb(false, model);
            model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
            model.addAttribute(AppConstant.DanhMuc.UserName, SecurityUtil.getTaxName());
            model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
            addAttribute(model, id, 1);
            model.addAttribute("isView", true);
            return "mard.15.edit";
        }  catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }



        return REDIRECT_HOME_INDEX;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String add(ModelMap model, HttpServletRequest request) {

        try {
            if (gotoLogin() || isFcap()) {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }
            model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
            model.addAttribute(AppConstant.DanhMuc.UserName, SecurityUtil.getTaxName());
            model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
            addAttribute(model, 0, 1);
        }  catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return "mard.15.edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(ModelMap model, HttpServletRequest request, @PathVariable("id") long id) {

        try {
            if (gotoLogin() || isFcap()) {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }
            setBreadcrumb(false, model);
            model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
            model.addAttribute(AppConstant.DanhMuc.UserName, SecurityUtil.getTaxName());
            model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
            addAttribute(model, id, 1);
            if (isHasEditPermission(id, new int[]{ 0, 1, 5, 6})) {
                return "mard.15.edit";
            }
        }  catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }



        return REDIRECT_HOME_INDEX;
    }

    @RequestMapping(value = "/ycs/{id}", method = RequestMethod.GET)
    public String view(ModelMap model, HttpServletRequest request, @PathVariable("id") long id) {

        try {
            if (gotoLogin() || isFcap()) {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }
            setBreadcrumb(false, model);
            model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
            model.addAttribute(AppConstant.DanhMuc.UserName, SecurityUtil.getTaxName());
            model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

            if (isHasEditPermission(id, new int[]{ 3, 7, 8, 9})) {
                id = cloneHoSo(id);
                addAttribute(model, id, 2);
                return "mard.15.edit";
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return REDIRECT_HOME_INDEX;
    }

    private long cloneHoSo(final long id) {
        TbdHoSo15 tbdHoSo15 = fldMard15TbdHoSo15Resource.getTbdHoSo15(id).getBody();
        Assert.notNull(tbdHoSo15, "KHONG TIM THAY HO SO ID = " + id);
        if (tbdHoSo15.getFiSended() == null || tbdHoSo15.getFiSended().intValue() == 0) return id;
        List<TbdHoSo15> tbdHoSo15List = fldMard15TbdHoSo15Resource.findByFiDocumentName(tbdHoSo15.getFiDocumentName()).getBody();
        if (Objects.nonNull(tbdHoSo15List)) {
            Optional<TbdHoSo15> find = tbdHoSo15List.stream().filter(p-> Objects.equals(p.getFiSended(), 0)).findFirst();
            if (find.isPresent()) return find.get().getFiIdHoSo();
        }
        tbdHoSo15.setFiActive(0);
        fldMard15TbdHoSo15Resource.updateTbdHoSo15(id, tbdHoSo15).getBody();
        tbdHoSo15.setFiIdHoSo(null);
        tbdHoSo15.setFiActive(1);
        tbdHoSo15.setFiSended(0);
        tbdHoSo15.setFiVersion((int)id);
        TbdHoSo15 copyTbdHoSo151 = fldMard15TbdHoSo15Resource.createTbdHoSo15(tbdHoSo15).getBody();
        LOGGER.info("Clone TbdHoSo15: {}", copyTbdHoSo151);
        List<TbdThuoc15> tbdThuoc15s = fldMard15TbdThuoc15Resource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdThuoc15s)) {
            tbdThuoc15s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo151.getFiIdHoSo());
                p = fldMard15TbdThuoc15Resource.createTbdThuoc15(p).getBody();
                LOGGER.info("Clone TbdThuoc15: {}", p);
            });
        }

        List<TbdDinhKem15> tbdDinhKem15s = fldMard15TbdDinhKem15Resource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdDinhKem15s)) {
            tbdDinhKem15s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo151.getFiIdHoSo());
                p = fldMard15TbdDinhKem15Resource.createTbdDinhKem15(p).getBody();
                LOGGER.info("Clone TbdDinhKem15: {}", p);
            });
        }

        return copyTbdHoSo151.getFiIdHoSo();
    }


    private void addAttribute(ModelMap model, long idHoSo, int action) {
        boolean isSign = Objects.equals(environment.getProperty(IS_SIGN_KEY), "true");
        model.addAttribute("idHoSo", idHoSo);
        model.addAttribute("isSign", isSign);
        model.addAttribute("isDevTest", "dev".equals(environment.getProperty("mard.14.profile")));
        model.addAttribute("isView", false);
        model.addAttribute("action", action);
        model.addAttribute("locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("documentType", Mard15Api.DOCUMENT_TYPE);
        model.addAttribute("taxCode", SecurityUtil.getTaxCode());
        model.addAttribute("isFcap", isFcap());
    }


    @SuppressWarnings("unchecked")
    public List<Tab> getMenuData() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Tab> mTabs = null;
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
                mTabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
            } else {
                mTabs = AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url"));
                httpSession.setAttribute(Constants.MENU_SESSION, mTabs);
            }
        }
        return mTabs;
    }

    private void setBreadcrumb(boolean isDetail, ModelMap model) {
        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        Breadcrumb nav = new Breadcrumb("/mard/15/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
        breadcrumbs.add(nav);
        if (isDetail) {
            nav = new Breadcrumb("#", environment.getRequiredProperty(AppConstant.Breadcrumb.DETAIL));
            breadcrumbs.add(nav);
        }
        model.addAttribute(AppConstant.Common.BREADCRUMB, breadcrumbs);
    }

    private boolean isHasEditPermission(Long id, int[] statusShows) {

        try {
            if (id <= 0)   return false;
            TbdHoSo15 tbdHoSo15 = fldMard15TbdHoSo15Resource.getTbdHoSo15(id).getBody();
            if (ObjectUtils.isEmpty(tbdHoSo15)) {
                LOGGER.info("KHONG TIM THAY HO SO: {}", id);
                return false;
            }

            String createrName = SecurityUtil.getTaxCode();
            if (StringUtils.hasText(createrName) && !Objects.equals(createrName, tbdHoSo15.getFiTaxCode())) {
                LOGGER.info("BAN KHONG PHAI LA NGUOI TAO RA HO SO: {} - NGUOI TAO: {} - USER: {}", tbdHoSo15.getFiIdHoSo(), tbdHoSo15.getFiTaxCode(), createrName);
                return false;
            }
            int status = tbdHoSo15.getFiStatus().intValue();
            for (int item : statusShows) {
                if (item == status) return true;
            }

         } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }




}
