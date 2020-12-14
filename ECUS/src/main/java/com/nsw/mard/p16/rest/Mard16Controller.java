package com.nsw.mard.p16.rest;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p16.model.TbdDinhKem16;
import com.nsw.mard.p16.model.TbdHoSo16;
import com.nsw.mard.p16.model.TbdThuoc16;
import com.nsw.mard.p16.model.TbdToKhaiKyThuat16;
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
@RequestMapping(value = "/mard/16")
public class Mard16Controller extends Mard16CallBack {

    public static final Logger LOGGER = LoggerFactory.getLogger(Mard16Controller.class);

    private static final String REDIRECT_HOME_INDEX = "redirect:/mard/16/home";

    private static final String IS_SIGN_KEY = "mard.16.sign";

    @Autowired
    protected RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    private Mard16TbdHoSo16Resource fldMard16TbdHoSo16Resource;

    @Autowired
    private Mard16TbdDinhKem16Resource fldMard16TbdDinhKem16Resource;

    @Autowired
    private Mard16TbdThuoc16Resource fldMard16TbdThuoc16Resource;

    @Autowired
    private Mard16TbdToKhaiKyThuat16Reource fldMard16TbdToKhaiKyThuat16Reource;



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

        return "mard.16.home";
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
            return "mard.16.edit";
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

        return "mard.16.edit";
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
                return "mard.16.edit";
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
                return "mard.16.edit";
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return REDIRECT_HOME_INDEX;
    }

    private long cloneHoSo(final long id) {
        TbdHoSo16 tbdHoSo16 = fldMard16TbdHoSo16Resource.getTbdHoSo16(id).getBody();
        Assert.notNull(tbdHoSo16, "KHONG TIM THAY HO SO ID = " + id);
        if (tbdHoSo16.getFiSended() == null || tbdHoSo16.getFiSended().intValue() == 0) return id;
        List<TbdHoSo16> tbdHoSo16List = fldMard16TbdHoSo16Resource.findByFiDocumentName(tbdHoSo16.getFiDocumentName()).getBody();
        if (Objects.nonNull(tbdHoSo16List)) {
            Optional<TbdHoSo16> find = tbdHoSo16List.stream().filter(p-> Objects.equals(p.getFiSended(), 0)).findFirst();
            if (find.isPresent()) return find.get().getFiIdHoSo();
        }
        tbdHoSo16.setFiActive(0);
        fldMard16TbdHoSo16Resource.updateTbdHoSo16(id, tbdHoSo16);
        tbdHoSo16.setFiIdHoSo(null);
        tbdHoSo16.setFiActive(1);
        tbdHoSo16.setFiSended(0);
        tbdHoSo16.setFiVersion((int)id);
        final TbdHoSo16 copyTbdHoSo161 = fldMard16TbdHoSo16Resource.createTbdHoSo16(tbdHoSo16).getBody();
        LOGGER.info("Clone TbdHoSo16: {}", copyTbdHoSo161);
        List<TbdThuoc16> tbdThuoc16s = fldMard16TbdThuoc16Resource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdThuoc16s)) {
            tbdThuoc16s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo161.getFiIdHoSo());
                p = fldMard16TbdThuoc16Resource.createTbdThuoc16(p).getBody();
                LOGGER.info("Clone TbdThuoc16: {}", p);
            });
        }

        List<TbdDinhKem16> tbdDinhKem16s = fldMard16TbdDinhKem16Resource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdDinhKem16s)) {
            tbdDinhKem16s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo161.getFiIdHoSo());
                p = fldMard16TbdDinhKem16Resource.createTbdDinhKem16(p).getBody();
                LOGGER.info("Clone TbdDinhKem16: {}", p);
            });
        }

        List<TbdToKhaiKyThuat16> tbdToKhaiKyThuat16s = fldMard16TbdToKhaiKyThuat16Reource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdToKhaiKyThuat16s)) {
            tbdToKhaiKyThuat16s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo161.getFiIdHoSo());
                p = fldMard16TbdToKhaiKyThuat16Reource.createTbdToKhaiKyThuat16(p).getBody();
                LOGGER.info("Clone TbdToKhaiKyThuat16: {}", p);
            });
        }

        return copyTbdHoSo161.getFiIdHoSo();
    }


    private void addAttribute(ModelMap model, long idHoSo, int action) {
        boolean isSign = Objects.equals(environment.getProperty(IS_SIGN_KEY), "true");
        model.addAttribute("idHoSo", idHoSo);
        model.addAttribute("isSign", isSign);
        model.addAttribute("isDevTest", "dev".equals(environment.getProperty("mard.14.profile")));
        model.addAttribute("isView", false);
        model.addAttribute("action", action);
        model.addAttribute("locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("documentType", Mard16Api.DOCUMENT_TYPE);
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
        Breadcrumb nav = new Breadcrumb("/mard/16/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
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
            TbdHoSo16 tbdHoSo16 = fldMard16TbdHoSo16Resource.getTbdHoSo16(id).getBody();
            if (ObjectUtils.isEmpty(tbdHoSo16)) {
                LOGGER.info("KHONG TIM THAY HO SO: {}", id);
                return false;
            }

            String createrName = SecurityUtil.getTaxCode();
            if (StringUtils.hasText(createrName) && !Objects.equals(createrName, tbdHoSo16.getFiTaxCode())) {
                LOGGER.info("BAN KHONG PHAI LA NGUOI TAO RA HO SO: {} - NGUOI TAO: {} - USER: {}", tbdHoSo16.getFiIdHoSo(), tbdHoSo16.getFiTaxCode(), createrName);
                return false;
            }
            int status = tbdHoSo16.getFiStatus().intValue();
            for (int item : statusShows) {
                if (item == status) return true;
            }

         } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }




}
