package com.nsw.mard.p19.rest;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.mard.p19.model.TbdDinhKem19;
import com.nsw.mard.p19.model.TbdHoSo19;
import com.nsw.mard.p19.model.TbdThuoc19;
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
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping(value = "/mard/19")
public class Mard19Controller extends Mard19CallBack {

    public static final Logger LOGGER = LoggerFactory.getLogger(Mard19Controller.class);

    private static final String REDIRECT_HOME_INDEX = "redirect:/mard/19/home";

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
    private Mard19TbdHoSo19Resource fldMard19TbdHoSo19Resource;

    @Autowired
    private Mard19TbdDinhKem19Resource fldMard19TbdDinhKem19Resource;

    @Autowired
    private Mard19TbdThuoc19Resource fldMard19TbdThuoc19Resource;

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

        return "mard.19.home";
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

        return "mard.19.edit";
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
            return "mard.19.edit";
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
            if (isHasEditPermission(id, new int[]{ 0, 1, 5, 8})) {
                return "mard.19.edit";
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
                return "mard.19.edit";
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return REDIRECT_HOME_INDEX;
    }

    private long cloneHoSo(final long id) {
        TbdHoSo19 tbdHoSo19 = fldMard19TbdHoSo19Resource.getTbdHoSo19(id).getBody();
        Assert.notNull(tbdHoSo19, "KHONG TIM THAY HO SO ID = " + id);
        if (tbdHoSo19.getFiSended() == null || tbdHoSo19.getFiSended().intValue() == 0) return id;
        List<TbdHoSo19> tbdHoSo19List =  fldMard19TbdHoSo19Resource.findByFiDocumentName(tbdHoSo19.getFiDocumentName()).getBody();
        //List<TbdHoSo19> tbdHoSo19List = fldMard19TbdHoSo19Resource.findByFiDocumentType(Mard19Api.DOCUMENT_TYPE).getBody();
        if (Objects.nonNull(tbdHoSo19List)) {
            Optional<TbdHoSo19> find = tbdHoSo19List.stream().filter(p-> Objects.equals(p.getFiSended(), 0)).findFirst();
            if (find.isPresent()) return find.get().getFiIdHoSo();
        }
        tbdHoSo19.setFiActive(0);
        fldMard19TbdHoSo19Resource.updateTbdHoSo19(id, tbdHoSo19);
       //tbdHoSo19.setFiVersion((int)id);
        tbdHoSo19.setFiVersion(tbdHoSo19.getFiVersion() + 1);
        tbdHoSo19.setFiIdHoSo(null);
        tbdHoSo19.setFiActive(1);
        tbdHoSo19.setFiSended(0);
        final TbdHoSo19 copyTbdHoSo191 = fldMard19TbdHoSo19Resource.createTbdHoSo19(tbdHoSo19).getBody();
        LOGGER.info("Clone TbdHoSo19: {}", copyTbdHoSo191);

        List<TbdThuoc19> tbdThuoc19s = fldMard19TbdThuoc19Resource.findByFiIdHoSo(id).getBody();
        //Hash map tránh trùng lặp dữ liệu qua 2 vòng for của thuốc và của đính kèm
        Map<String, TbdDinhKem19> dinhKemArray = new HashMap<>();
        if (Objects.nonNull(tbdThuoc19s)) {
            tbdThuoc19s.stream().forEach(p->{
                //Lấy list đính kèm cũ theo product
                List<TbdDinhKem19>  tbdDinhKem19sThuoc = fldMard19TbdDinhKem19Resource.findByFiProductId(p.getFiId()).getBody();
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo191.getFiIdHoSo());
                p = fldMard19TbdThuoc19Resource.createTbdThuoc19(p).getBody();
                LOGGER.info("Clone TbdThuoc19: {}", p);
                TbdThuoc19 finalP = p;
                //set lại productId cho list đính kèm mới
                tbdDinhKem19sThuoc.stream().forEach(pDinhKem -> {
                    pDinhKem.setFiId(null);
                    pDinhKem.setFiIdHoSo(copyTbdHoSo191.getFiIdHoSo());
                    if (null != pDinhKem.getFiProductId()) {
                        pDinhKem.setFiProductId(finalP.getFiId());
                    }
                    if (dinhKemArray.get(pDinhKem.getFiPath()) == null) {
                        fldMard19TbdDinhKem19Resource.createTbdDinhKem19(pDinhKem).getBody();
                        dinhKemArray.put(pDinhKem.getFiPath(), pDinhKem);
                    }
                });
            });
        }


        List<TbdDinhKem19> tbdDinhKem19s = fldMard19TbdDinhKem19Resource.findByFiIdHoSo(id).getBody();
                if (Objects.nonNull(tbdDinhKem19s)) {
                    tbdDinhKem19s.stream().forEach(p -> {
                        p.setFiId(null);
                        p.setFiIdHoSo(copyTbdHoSo191.getFiIdHoSo());
                        fldMard19TbdDinhKem19Resource.createTbdDinhKem19(p).getBody();
                        LOGGER.info("Clone TbdDinhKem19: {}", p);
                    });
                }


        return copyTbdHoSo191.getFiIdHoSo();
    }

    private void addAttribute(ModelMap model, long idHoSo, int action) {
        boolean isSign = Objects.equals(environment.getProperty(IS_SIGN_KEY), "true");
        model.addAttribute("idHoSo", idHoSo);
        model.addAttribute("isSign", isSign);
        model.addAttribute("isDevTest", "dev".equals(environment.getProperty("mard.14.profile")));
        model.addAttribute("isView", false);
        model.addAttribute("action", action);
        model.addAttribute("locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("documentType", Mard19Api.DOCUMENT_TYPE);
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
        Breadcrumb nav = new Breadcrumb("/mard/19/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
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
            TbdHoSo19 tbdHoSo19 = fldMard19TbdHoSo19Resource.getTbdHoSo19(id).getBody();
            if (ObjectUtils.isEmpty(tbdHoSo19)) {
                LOGGER.info("KHONG TIM THAY HO SO: {}", id);
                return false;
            }

            String createrName = SecurityUtil.getTaxCode();
            if (StringUtils.hasText(createrName) && !Objects.equals(createrName, tbdHoSo19.getFiTaxCode())) {
                LOGGER.info("BAN KHONG PHAI LA NGUOI TAO RA HO SO: {} - NGUOI TAO: {} - USER: {}", tbdHoSo19.getFiIdHoSo(), tbdHoSo19.getFiTaxCode(), createrName);
                return false;
            }
            int status = tbdHoSo19.getFiStatus().intValue();
            for (int item : statusShows) {
                if (item == status) return true;
            }

         } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }
}
