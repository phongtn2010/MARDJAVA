package com.nsw.mt.p23;

import com.google.gson.Gson;
import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.mt.MTConstants;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/mt/23")
@PropertySource("classpath:mt_api.properties")
public class MT23Controller extends BaseController {
    public static final Logger LOGGER = LoggerFactory.getLogger(MT23Controller.class);

    @Autowired
    protected RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    protected MessageSource messageSource;

    @InitBinder
    public void bindData(WebDataBinder binder) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    public List<Tab> getMenuData() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Tab> mTabs = null;
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
                mTabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
            } else {
                mTabs = AppHelper.GetMenusForUser(user.getTabs(),
                        environment.getRequiredProperty("nsw.fontend.url"));
                httpSession.setAttribute(Constants.MENU_SESSION, mTabs);
            }
        }
        return mTabs;
    }

    private void setBreadcrumb(boolean isDetail, ModelMap model) {
        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        Breadcrumb nav = new Breadcrumb("/", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
        breadcrumbs.add(nav);
        if (isDetail) {
            nav = new Breadcrumb("#", environment.getRequiredProperty(AppConstant.Breadcrumb.DETAIL));
            breadcrumbs.add(nav);
        }
        model.addAttribute(AppConstant.Common.BREADCRUMB, breadcrumbs);
    }

    @RequestMapping(value = "/home/{procedureId}", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes,
                        Locale locale, ModelMap model, @PathVariable("procedureId") String procedureId) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;
                setBreadcrumb(false, model);
                model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
                model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
                model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
                model.addAttribute(AppConstant.DanhMuc.Applet,
                        environment.getRequiredProperty(AppConstant.Common.APPLET));
                model.addAttribute(AppConstant.DanhMuc.Sign,
                        environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
                model.addAttribute("procedureId", procedureId);
                model.addAttribute("titleLabel", getTitleLabel(procedureId));
                Gson gson = new Gson();
                model.addAttribute("userCustom", gson.toJson(user));
            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return environment.getProperty("mt.p23.home");
    }

    @RequestMapping(value = "/edit/{procedureId}/{id}", method = RequestMethod.GET)
    public String edit(ModelMap model, HttpServletRequest request, @PathVariable("id") Long id,@PathVariable("procedureId") String procedureId) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;
                setBreadcrumb(false, model);
                model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
                model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
                model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
                model.addAttribute(AppConstant.DanhMuc.Applet,
                        environment.getRequiredProperty(AppConstant.Common.APPLET));
                model.addAttribute(AppConstant.DanhMuc.Sign,
                        environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
                model.addAttribute("hoSoId", id);
                Gson gson = new Gson();
                model.addAttribute("procedureId", procedureId);
                model.addAttribute("userCustom", gson.toJson(user));
                model.addAttribute("editMode", true);
                model.addAttribute("titleLabel", getTitleLabel(procedureId));
            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return environment.getProperty("mt.p23.edit");
    }

    @RequestMapping(value = "/view/{procedureId}/{id}", method = RequestMethod.GET)
    public String view(ModelMap model, HttpServletRequest request, @PathVariable("id") Long id,@PathVariable("procedureId") String procedureId) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;
                setBreadcrumb(false, model);
                model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
                model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
                model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
                model.addAttribute(AppConstant.DanhMuc.Applet,
                        environment.getRequiredProperty(AppConstant.Common.APPLET));
                model.addAttribute(AppConstant.DanhMuc.Sign,
                        environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
                model.addAttribute("hoSoId", id);
                Gson gson = new Gson();
                model.addAttribute("procedureId", procedureId);
                model.addAttribute("userCustom", gson.toJson(user));
                model.addAttribute("editMode", false);
                model.addAttribute("titleLabel", getTitleLabel(procedureId));
            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return environment.getProperty("mt.p23.edit");
    }

    @RequestMapping(value = "/new/{procedureId}", method = RequestMethod.GET)
    public String edit(ModelMap model, HttpServletRequest request, @PathVariable("procedureId") String procedureId) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;
                setBreadcrumb(false, model);
                model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
                model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
                model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
                model.addAttribute(AppConstant.DanhMuc.Applet,
                        environment.getRequiredProperty(AppConstant.Common.APPLET));
                model.addAttribute(AppConstant.DanhMuc.Sign,
                        environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
                model.addAttribute("hoSoId", "undefined");
                Gson gson = new Gson();
                model.addAttribute("userCustom", gson.toJson(user));
                model.addAttribute("procedureId", procedureId);
                model.addAttribute("editMode", true);
                model.addAttribute("titleLabel", getTitleLabel(procedureId));
            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return environment.getProperty("mt.p23.edit");
    }

    @RequestMapping(value = MTConstants.URL_VIEW_LICENSE + "/{procedureId}/{id}/{type}", method = RequestMethod.GET)
    public String viewLicense(ModelMap model, HttpServletRequest request, @PathVariable("type") Integer type, @PathVariable("procedureId") String procedureId, @PathVariable("id") Long id) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;
                setBreadcrumb(false, model);
                model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
                model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
                model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
                model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
                model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
                model.addAttribute("giayPhepId", id);
                model.addAttribute("type", type);
                model.addAttribute("procedureId", procedureId);
                model.addAttribute("titleLabel", getTitleLabel(procedureId));
            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "nsw.mt.page.23.view.license";
    }
    @ResponseBody
    @RequestMapping(value = MTConstants.URL_XEM_GIAY_PHEP + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getGiayPhep(HttpServletRequest request, @PathVariable("id") long id) {

        try {

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!(principal instanceof UserDetails)) {

                return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
            }
            Map<String, Object> params = new HashMap<>();
            ResponseJson responseJson = callRestTemplate(environment.getRequiredProperty("mt.backend") + environment.getRequiredProperty("mt.23.xem_giay_phep"), id, HttpMethod.POST, params);
            return createResponseEntity(responseJson.getData(), 1l, "", true, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("[layDanhSachHoSo]", e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/call_service", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> callBackendService(HttpServletRequest request, @RequestBody Map<String, Object> form) {

        try {
            Long total = 0L;
            Gson gson = new Gson();
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!(principal instanceof UserDetails)) {

                return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
            }
            String urlBackEnd = form.get("URL_BACKEND").toString();
            String method = form.get("METHOD").toString();
            HttpMethod httpMethod = "POST".equals(method) ? HttpMethod.POST
                    : "GET".equals(method) ? HttpMethod.GET : HttpMethod.OPTIONS;
            Object requestObject;
            if(form.get("URL_BACKEND").toString().contains("fullSearchPaging")) {
            	Map<String, String> param = (Map<String, String>) form.get("REQUEST");
            	param.put("model", "23");
            	requestObject = param;
            }else {
            	requestObject = form.get("REQUEST");
            }
            Map<String, Object> params = new HashMap<>();
            System.out.println("URL:" + environment.getProperty("mt.backend") + urlBackEnd);
            System.out.println("Request: " + gson.toJson(form));
            ResponseJson responseJson = callRestTemplate(environment.getProperty("mt.backend") + urlBackEnd, requestObject, httpMethod, params);
            if (form.containsKey("URL_GET_TOTAL")) {
                String urlGetTotal = form.get("URL_GET_TOTAL").toString();
                ResponseJson response = callRestTemplate(environment.getProperty("mt.backend") + urlGetTotal, requestObject, httpMethod, params);
                total=((Integer)response.getData()).longValue();
            }
            return createResponseEntity(responseJson.getData(), total, "", responseJson.getSuccess(), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("CALL_SERVICE_ERROR", e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveWithFile/{funcType}",
            method = RequestMethod.POST)
    public ResponseEntity<Object> saveWithFile(DefaultMultipartHttpServletRequest request, @PathVariable("funcType") int funcType) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        json.setMessage(getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()));
        try {
            String uri = environment.getProperty("mt.backend") + environment.getProperty("mt.23.save_with_file") + "/" + funcType;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "multipart/form-data");
            headers.set("Accept-Charset", "UTF-8");

            MultiValueMap<String, Object> map = new LinkedMultiValueMap();
            for (String key : request.getParameterMap().keySet()) {
                for (String val : request.getParameterMap().get(key)) {
                    map.add(key, URLEncoder.encode(val, "UTF-8"));
                }
            }

            for (String key : request.getMultiFileMap().keySet()) {
                for (MultipartFile file : request.getMultiFileMap().get(key)) {
                    ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
                        @Override
                        public String getFilename() {
                            return file.getOriginalFilename();
                        }
                    };
                    map.add(key, resource);
                }
            }
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
            ResponseJson responseJson = restTemplate.postForObject(uri, requestEntity, ResponseJson.class);
            if (responseJson == null || !responseJson.isSuccess())
                return createResponseEntity(null, 1l, "", false, HttpStatus.OK);
            return createResponseEntity("", 1l, "", true, HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            return createResponseEntity(null, 1l, "", false, HttpStatus.OK);
        }
    }

    @ResponseBody
    @RequestMapping(value = MTConstants.URL_PAGE_HISTORY + "/{idHoSo}/{currentPage}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getProcessHistory(HttpServletRequest request, @PathVariable("idHoSo") Long fiIdHoso,@PathVariable("currentPage") Long currentPage) {
        try {

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!(principal instanceof UserDetails)) {

                return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
            }

            Map<String, Object> params = new HashMap<>();
            params.put("fiIdHoso",fiIdHoso);
            params.put("currentPage",currentPage);
            params.put("pageSize",10);
            ResponseJson responseJson = callRestTemplate(environment.getRequiredProperty("mt.backend") + environment.getRequiredProperty("mt.23.history"), params, HttpMethod.POST, null);
            List lst = (List) responseJson.getData();
            ResponseJson response = callRestTemplate(environment.getProperty("mt.backend") + environment.getRequiredProperty("mt.23.history_total"),params, HttpMethod.POST, null);
            Long total=((Integer)response.getData()).longValue();
            return createResponseEntity(lst, total, "", true, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("[getProcessHistory]", e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }
    @ResponseBody
    @RequestMapping(value = MTConstants.URL_PAGE_HISTORY + "/giayphep/{soGiayphep}/{currentPage}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getProcessHistoryGP(HttpServletRequest request, @PathVariable("soGiayphep") String fiSoGiayphep, @PathVariable("currentPage") Long currentPage) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!(principal instanceof UserDetails)) {

                return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
            }

            Map<String, Object> params = new HashMap<>();
            params.put("fiSoGiayphep",fiSoGiayphep);
            params.put("currentPage",currentPage);
            params.put("pageSize",10);
            ResponseJson responseJson = callRestTemplate(environment.getRequiredProperty("mt.backend") + environment.getRequiredProperty("mt.23.historyGP"), params, HttpMethod.POST, null);
            List lst = (List) responseJson.getData();
            ResponseJson response = callRestTemplate(environment.getProperty("mt.backend") + environment.getRequiredProperty("mt.23.history_totalGP"),params, HttpMethod.POST, null);
            Long total=((Integer)response.getData()).longValue();
            return createResponseEntity(lst, total, "", true, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("[getProcessHistory]", e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }
    /**
     * yeu cau rút ho so
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = MTConstants.URL_XIN_RUT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> xinRut(HttpServletRequest request, @RequestBody Object lyDo) {
        try {
            LOGGER.error(lyDo.toString());
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!(principal instanceof UserDetails)) {
                return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
            }

            Map<String, Object> params = new HashMap<>();
            ResponseJson responseJson = callRestTemplate(environment.getRequiredProperty("mt.backend") + environment.getRequiredProperty("mt.23.rut_ho_so"), lyDo, HttpMethod.POST, params);
            return createResponseEntity(responseJson.getData(), 1l, "", true, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error("[xinRut]", e);
            //pushLog(e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }

    /**
     * yeu cau rút ho so
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = MTConstants.URL_PAGE_REQUEST_EDIT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> xinSuaGiayPhep(HttpServletRequest request, @RequestBody Object form) {

        try {
            //LOGGER.error(lyDo.toString());
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!(principal instanceof UserDetails)) {
                return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
            }

            Map<String, Object> params = new HashMap<>();

            ResponseJson responseJson = callRestTemplate(environment.getRequiredProperty("mt.backend") + environment.getRequiredProperty("mt.23.xin_sua_giay_phep"), form, HttpMethod.POST, params);
            return createResponseEntity(responseJson.getData(), 1l, "", true, HttpStatus.OK);

        } catch (Exception e) {

            LOGGER.error("[xinSuaGiayPhep]", e);
            //pushLog(e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }

    /**
     * yeu cau rút ho so
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = MTConstants.URL_PAGE_GIVE_BACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> traGiayPhep(HttpServletRequest request, @RequestBody Object lyDo) {

        try {
            LOGGER.error(lyDo.toString());
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!(principal instanceof UserDetails)) {
                return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
            }

            Map<String, Object> params = new HashMap<>();
            ResponseJson responseJson = callRestTemplate(environment.getRequiredProperty("mt.backend") + environment.getRequiredProperty("mt.23.tra_giay_phep"), lyDo, HttpMethod.POST, params);
            return createResponseEntity(responseJson.getData(), 1l, "", true, HttpStatus.OK);

        } catch (Exception e) {

            LOGGER.error("[traGiayPhep]", e);
            //pushLog(e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }

    @RequestMapping(value = "/download/{idDinhKem}", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadNewFile(HttpServletResponse response, @PathVariable("idDinhKem") Long idDinhKem) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                if (idDinhKem != null) {
                    String uri = environment.getProperty("mt.backend") + environment.getProperty("mt.23.download") + "/" + idDinhKem;
                    HttpHeaders headers = new HttpHeaders();
                    headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
                    HttpEntity<String> entity = new HttpEntity<>(headers);
                    RestTemplate restTemplate = new RestTemplate();
                    FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
                    formConverter.setCharset(Charset.forName("UTF8"));
                    restTemplate.getMessageConverters().add(formConverter);
                    restTemplate.getMessageConverters().add(
                            new MappingJackson2HttpMessageConverter());


                    ResponseEntity<byte[]> data = restTemplate
                            .exchange(uri, HttpMethod.POST, entity, byte[].class);
                    return createResponseEntity(data.getBody(), 1l, "", true, HttpStatus.OK);
                }
            } catch (Exception ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }
        return createResponseEntity(null, 1l, "", false, HttpStatus.OK);
    }

    private String getTitleLabel(String procedureId) {
        switch (procedureId) {
            case "BGTVT0600023":
                return "Cấp Giấy phép liên vận Việt Nam - Campuchia đối với phương tiện thương mại";
            case "BGTVT0600024":
                return "Cấp lại Giấy phép liên vận Việt Nam - Campuchia đối với phương tiện thương mại do hết hạn";
            case "BGTVT0600025":
                return "Cấp lại Giấy phép liên vận Việt Nam - Campuchia đối với phương tiện thương mại do hư hỏng";
            case "BGTVT0600026":
                return "Cấp lại Giấy phép liên vận Việt Nam - Campuchia đối với phương tiện thương mại do mất mát";
            default:
                return "Cấp Giấy phép liên vận Việt Nam - Campuchia đối với phương tiện thương mại";
        }
    }
}
