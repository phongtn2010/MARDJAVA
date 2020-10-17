package com.nsw.mard.p14.rest;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.p14.model.TbdDinhKem14;
import com.nsw.mard.p14.model.TbdHoSo14;
import com.nsw.mard.p14.model.TbdThuoc14;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
@RequestMapping(value = "/mard/14")
public class Mard14Controller extends Mard14CallBack {

    public static final Logger LOGGER = LoggerFactory.getLogger(Mard14Controller.class);

    private static final String REDIRECT_HOME_INDEX = "redirect:/mard/14/home";

    private static final String IS_SIGN_KEY = "mard.14.sign";

    @Autowired
    protected RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    private Mard14TbdHoSo14Resource fldMard14TbdHoSo14Resource;

    @Autowired
    private Mard14TbdDinhKem14Resource fldMard14TbdDinhKem14Resource;

    @Autowired
    private Mard14TbdThuoc14Resource fldMard14TbdThuoc14Resource;



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

        return "mard.14.home";
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

        return "mard.14.edit";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewHoSo (ModelMap model, HttpServletRequest request, @PathVariable("id") long id) {

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
            return "mard.14.edit";
        }  catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }



        return REDIRECT_HOME_INDEX;
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
            if (isHasEditPermission(id, new int[]{ 0, 1, 5, 7})) {
                return "mard.14.edit";
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

            if (isHasEditPermission(id, new int[]{ 3, 10, 11})) {
                id = cloneHoSo(id);
                addAttribute(model, id, 2);
                return "mard.14.edit";
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return REDIRECT_HOME_INDEX;
    }

    private long cloneHoSo(final long id) {
        TbdHoSo14 tbdHoSo14 = fldMard14TbdHoSo14Resource.getTbdHoSo14(id).getBody();
        Assert.notNull(tbdHoSo14, "KHONG TIM THAY HO SO ID = " + id);
        if (tbdHoSo14.getFiSended() == null || tbdHoSo14.getFiSended().intValue() == 0) return id;
        List<TbdHoSo14> tbdHoSo14List =  fldMard14TbdHoSo14Resource.findByFiDocumentName(tbdHoSo14.getFiDocumentName()).getBody();
        if (Objects.nonNull(tbdHoSo14List)) {
            Optional<TbdHoSo14> find = tbdHoSo14List.stream().filter(p-> Objects.equals(p.getFiSended(), 0)).findFirst();
            if (find.isPresent()) return find.get().getFiIdHoSo();
        }
        tbdHoSo14.setFiActive(0);
        fldMard14TbdHoSo14Resource.updateTbdHoSo14(id, tbdHoSo14);
        tbdHoSo14.setFiVersion((int)id);
        tbdHoSo14.setFiIdHoSo(null);
        tbdHoSo14.setFiActive(1);
        tbdHoSo14.setFiSended(0);
        final TbdHoSo14 copyTbdHoSo141 = fldMard14TbdHoSo14Resource.createTbdHoSo14(tbdHoSo14).getBody();
        LOGGER.info("Clone TbdHoSo14: {}", copyTbdHoSo141);
        List<TbdThuoc14> tbdThuoc14s = fldMard14TbdThuoc14Resource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdThuoc14s)) {
            tbdThuoc14s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo141.getFiIdHoSo());
                p = fldMard14TbdThuoc14Resource.createTbdThuoc14(p).getBody();
                LOGGER.info("Clone TbdThuoc14: {}", p);
            });
        }

        List<TbdDinhKem14> tbdDinhKem14s = fldMard14TbdDinhKem14Resource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdDinhKem14s)) {
            tbdDinhKem14s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo141.getFiIdHoSo());
                p = fldMard14TbdDinhKem14Resource.createTbdDinhKem14(p).getBody();
                LOGGER.info("Clone TbdDinhKem14: {}", p);
            });
        }

        return copyTbdHoSo141.getFiIdHoSo();
    }

    private void addAttribute(ModelMap model, long idHoSo, int action) {
        boolean isSign = Objects.equals(environment.getProperty(IS_SIGN_KEY), "true");
        model.addAttribute("idHoSo", idHoSo);
        model.addAttribute("isSign", isSign);
        model.addAttribute("isDevTest", "dev".equals(environment.getProperty("mard.14.profile")));
        model.addAttribute("isView", false);
        model.addAttribute("action", action);
        model.addAttribute("locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("documentType", Mard14Api.DOCUMENT_TYPE);
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
        Breadcrumb nav = new Breadcrumb("/mard/14/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
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
            TbdHoSo14 tbdHoSo14 = fldMard14TbdHoSo14Resource.getTbdHoSo14(id).getBody();
            if (ObjectUtils.isEmpty(tbdHoSo14)) {
                LOGGER.info("KHONG TIM THAY HO SO: {}", id);
                return false;
            }

            String createrName = SecurityUtil.getTaxCode();
            if (StringUtils.hasText(createrName) && !Objects.equals(createrName, tbdHoSo14.getFiTaxCode())) {
                LOGGER.info("BAN KHONG PHAI LA NGUOI TAO RA HO SO: {} - NGUOI TAO: {} - USER: {}", tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiTaxCode(), createrName);
                return false;
            }
            int status = tbdHoSo14.getFiStatus().intValue();
            for (int item : statusShows) {
                if (item == status) return true;
            }

         } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }




}
