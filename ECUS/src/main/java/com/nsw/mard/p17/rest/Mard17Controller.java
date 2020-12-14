package com.nsw.mard.p17.rest;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.mard.p17.model.TbdDinhKem17;
import com.nsw.mard.p17.model.TbdHoSo17;
import com.nsw.mard.p17.model.TbdDinhKem17;
import com.nsw.mard.p17.model.TbdThuoc17;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping(value = "/mard/17")
public class Mard17Controller extends Mard17CallBack {

    public static final Logger LOGGER = LoggerFactory.getLogger(Mard17Controller.class);

    private static final String REDIRECT_HOME_INDEX = "redirect:/mard/17/home";

    private static final String IS_SIGN_KEY = "mard.17.sign";

    @Autowired
    protected RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    private Mard17TbdHoSo17Resource fldMard17TbdHoSo17Resource;

    @Autowired
    private Mard17TbdDinhKem17Resource fldMard17TbdDinhKem17Resource;

    @Autowired
    private Mard17TbdThuoc17Resource fldMard17TbdThuoc17Resource;



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

        return "mard.17.home";
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

        return "mard.17.edit";
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
            return "mard.17.edit";
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
                return "mard.17.edit";
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
                return "mard.17.edit";
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return REDIRECT_HOME_INDEX;
    }

     /*//start copy ho so
    @RequestMapping(value = "/copyhoso/{id}/{newId}", method = RequestMethod.GET)
    public long copyHoSo(@PathVariable(value = "id")Long id, @PathVariable(value = "newId")String newId ){
        return this.cloneHoSoNew(id, newId);
    }
    private long cloneHoSoNew(final long id, String newId) {
        TbdHoSo17 tbdHoSo17 = fldMard17TbdHoSo17Resource.getTbdHoSo17(id).getBody();
        Assert.notNull(tbdHoSo17, "KHONG TIM THAY HO SO ID = " + id);
        if (tbdHoSo17.getFiSended() == null || tbdHoSo17.getFiSended().intValue() == 0) return id;
        List<TbdHoSo17> tbdHoSo17List =  fldMard17TbdHoSo17Resource.findByFiDocumentName(tbdHoSo17.getFiDocumentName()).getBody();
        if (Objects.nonNull(tbdHoSo17List)) {
            Optional<TbdHoSo17> find = tbdHoSo17List.stream().filter(p-> Objects.equals(p.getFiSended(), 0)).findFirst();
            if (find.isPresent()) return find.get().getFiIdHoSo();
        }
        //tbdHoSo17.setFiActive(0);
        //Date fiNgayNop = tbdHoSo17.getFiSendDate();
        //fldMard17TbdHoSo17Resource.updateTbdHoSo17(id, tbdHoSo17);
        //tbdHoSo17.setFiVersion((int)id);
        tbdHoSo17.setFiVersion(0);
        tbdHoSo17.setFiStatus(0);
        tbdHoSo17.setFiIdHoSo(null);
        tbdHoSo17.setFiActive(1);
        tbdHoSo17.setFiSended(0);
        tbdHoSo17.setFiSendDate(new Date());
        tbdHoSo17.setFiDocumentName("AH2020000" + newId);
        final TbdHoSo17 copyTbdHoSo171 = fldMard17TbdHoSo17Resource.createTbdHoSo17(tbdHoSo17).getBody();
        //copyTbdHoSo171.setFiSendDate(fiNgayNop);
        LOGGER.info("Clone TbdHoSo17: {}", copyTbdHoSo171);
        List<TbdThuoc17> tbdThuoc17s = fldMard17TbdThuoc17Resource.findByFiIdHoSo(id).getBody();
        //Hash map tránh trùng lặp dữ liệu qua 2 vòng for của thuốc và của đính kèm
        Map<String, TbdDinhKem17> dinhKemArray = new HashMap<>();
        if (Objects.nonNull(tbdThuoc17s)) {
            tbdThuoc17s.stream().forEach(p->{
                //Lấy list đính kèm cũ theo product
                List<TbdDinhKem17>  tbdDinhKem17sThuoc = fldMard17TbdDinhKem17Resource.findByFiProductId(p.getFiId()).getBody();
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo171.getFiIdHoSo());
                p = fldMard17TbdThuoc17Resource.createTbdThuoc17(p).getBody();
                LOGGER.info("Clone TbdThuoc17: {}", p);
                TbdThuoc17 finalP = p;
                //set lại productId cho list đính kèm mới
                tbdDinhKem17sThuoc.stream().forEach(pDinhKem -> {
                    pDinhKem.setFiId(null);
                    pDinhKem.setFiIdHoSo(copyTbdHoSo171.getFiIdHoSo());
                    if (null != pDinhKem.getFiProductId()) {
                        pDinhKem.setFiProductId(finalP.getFiId());
                    }
                    if (dinhKemArray.get(pDinhKem.getFiPath()) == null) {
                        fldMard17TbdDinhKem17Resource.createTbdDinhKem17(pDinhKem).getBody();
                        dinhKemArray.put(pDinhKem.getFiPath(), pDinhKem);
                    }
                });
            });
        }

        List<TbdDinhKem17> tbdDinhKem17s = fldMard17TbdDinhKem17Resource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdDinhKem17s)) {
            tbdDinhKem17s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo171.getFiIdHoSo());
                p = fldMard17TbdDinhKem17Resource.createTbdDinhKem17(p).getBody();
                LOGGER.info("Clone TbdDinhKem17: {}", p);
            });
        }

        return copyTbdHoSo171.getFiIdHoSo();
    }


    //end copyhoso*/

    private long cloneHoSo(final long id) {
        TbdHoSo17 tbdHoSo17 = fldMard17TbdHoSo17Resource.getTbdHoSo17(id).getBody();
        Assert.notNull(tbdHoSo17, "KHONG TIM THAY HO SO ID = " + id);
        if (tbdHoSo17.getFiSended() == null || tbdHoSo17.getFiSended().intValue() == 0) return id;
        List<TbdHoSo17> tbdHoSo17List =  fldMard17TbdHoSo17Resource.findByFiDocumentName(tbdHoSo17.getFiDocumentName()).getBody();
        if (Objects.nonNull(tbdHoSo17List)) {
            Optional<TbdHoSo17> find = tbdHoSo17List.stream().filter(p-> Objects.equals(p.getFiSended(), 0)).findFirst();
            if (find.isPresent()) return find.get().getFiIdHoSo();
        }
        tbdHoSo17.setFiActive(0);
        fldMard17TbdHoSo17Resource.updateTbdHoSo17(id, tbdHoSo17);
        //tbdHoSo17.setFiVersion((int)id);
        //thay đổi version từ lấy theo idHoSo => version cũ + 1
        tbdHoSo17.setFiVersion(tbdHoSo17.getFiVersion() + 1);
        tbdHoSo17.setFiIdHoSo(null);
        tbdHoSo17.setFiActive(1);
        tbdHoSo17.setFiSended(0);

        final TbdHoSo17 copyTbdHoSo171 = fldMard17TbdHoSo17Resource.createTbdHoSo17(tbdHoSo17).getBody();
        LOGGER.info("Clone TbdHoSo17: {}", copyTbdHoSo171);
        List<TbdThuoc17> tbdThuoc17s = fldMard17TbdThuoc17Resource.findByFiIdHoSo(id).getBody();
        //Hash map tránh trùng lặp dữ liệu qua 2 vòng for của thuốc và của đính kèm
        Map<String, TbdDinhKem17> dinhKemArray = new HashMap<>();
        if (Objects.nonNull(tbdThuoc17s)) {
            tbdThuoc17s.stream().forEach(p->{
                //Lấy list đính kèm cũ theo product
                List<TbdDinhKem17>  tbdDinhKem17sThuoc = fldMard17TbdDinhKem17Resource.findByFiProductId(p.getFiId()).getBody();
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo171.getFiIdHoSo());
                p = fldMard17TbdThuoc17Resource.createTbdThuoc17(p).getBody();
                LOGGER.info("Clone TbdThuoc17: {}", p);
                TbdThuoc17 finalP = p;
                //set lại productId cho list đính kèm mới
                tbdDinhKem17sThuoc.stream().forEach(pDinhKem -> {
                    pDinhKem.setFiId(null);
                    pDinhKem.setFiIdHoSo(copyTbdHoSo171.getFiIdHoSo());
                    if (null != pDinhKem.getFiProductId()) {
                        pDinhKem.setFiProductId(finalP.getFiId());
                    }
                    if (dinhKemArray.get(pDinhKem.getFiPath()) == null) {
                        fldMard17TbdDinhKem17Resource.createTbdDinhKem17(pDinhKem).getBody();
                        dinhKemArray.put(pDinhKem.getFiPath(), pDinhKem);
                    }
                });
            });
        }

        List<TbdDinhKem17> tbdDinhKem17s = fldMard17TbdDinhKem17Resource.findByFiIdHoSo(id).getBody();
        if (Objects.nonNull(tbdDinhKem17s)) {
            tbdDinhKem17s.stream().forEach(p->{
                p.setFiId(null);
                p.setFiIdHoSo(copyTbdHoSo171.getFiIdHoSo());
                p = fldMard17TbdDinhKem17Resource.createTbdDinhKem17(p).getBody();
                LOGGER.info("Clone TbdDinhKem17: {}", p);
            });
        }
        return copyTbdHoSo171.getFiIdHoSo();
    }

    private void addAttribute(ModelMap model, long idHoSo, int action) {
        boolean isSign = Objects.equals(environment.getProperty(IS_SIGN_KEY), "true");
        model.addAttribute("idHoSo", idHoSo);
        model.addAttribute("isSign", isSign);
        model.addAttribute("isDevTest", "dev".equals(environment.getProperty("mard.14.profile")));
        model.addAttribute("isView", false);
        model.addAttribute("action", action);
        model.addAttribute("locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("documentType", Mard17Api.DOCUMENT_TYPE);
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
        Breadcrumb nav = new Breadcrumb("/mard/17/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
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
            TbdHoSo17 tbdHoSo17 = fldMard17TbdHoSo17Resource.getTbdHoSo17(id).getBody();
            if (ObjectUtils.isEmpty(tbdHoSo17)) {
                LOGGER.info("KHONG TIM THAY HO SO: {}", id);
                return false;
            }

            String createrName = SecurityUtil.getTaxCode();
            if (StringUtils.hasText(createrName) && !Objects.equals(createrName, tbdHoSo17.getFiTaxCode())) {
                LOGGER.info("BAN KHONG PHAI LA NGUOI TAO RA HO SO: {} - NGUOI TAO: {} - USER: {}", tbdHoSo17.getFiIdHoSo(), tbdHoSo17.getFiTaxCode(), createrName);
                return false;
            }
            int status = tbdHoSo17.getFiStatus().intValue();
            for (int item : statusShows) {
                if (item == status) return true;
            }

         } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }




}
