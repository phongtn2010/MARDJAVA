package com.nsw.mt.p47;

import com.google.gson.Gson;
import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.mt.MTConstants;
import com.nsw.mt.p18.UserUtil;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
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
@RequestMapping(value = "/mt/47")
@PropertySources({
	@PropertySource("classpath:mt_api.properties"),
	@PropertySource("classpath:most_api.properties")
})
public class MT47Controller extends BaseController {
    public static final Logger LOGGER = LoggerFactory.getLogger(MT47Controller.class);

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
        	 	UserCustom user = UserUtil.getUserDefault();
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

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return environment.getProperty("mt.p47.home");
    }

   

    @RequestMapping(value = "/view/{procedureId}/{id}", method = RequestMethod.GET)
    public String view(ModelMap model, HttpServletRequest request, @PathVariable("id") Long id,@PathVariable("procedureId") String procedureId) {
        try {
                UserCustom user = UserUtil.getUserDefault();
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

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return environment.getProperty("mt.p47.edit");
    }

    
    @RequestMapping(value = MTConstants.URL_VIEW_LICENSE + "/{procedureId}/{id}/{type}", method = RequestMethod.GET)
    public String viewLicense(ModelMap model, HttpServletRequest request, @PathVariable("type") Integer type, @PathVariable("procedureId") String procedureId, @PathVariable("id") Long id) {
    	try {
                UserCustom user = UserUtil.getUserDefault();
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

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "nsw.mt.page.47.view.license";
    }
    @ResponseBody
    @RequestMapping(value = MTConstants.URL_XEM_GIAY_PHEP + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getGiayPhep(HttpServletRequest request, @PathVariable("id") long id) {

        try {
            
            Map<String, Object> params = new HashMap<>();
            ResponseJson responseJson = callRestTemplate(environment.getRequiredProperty("mt.backend") + environment.getRequiredProperty("mt.47.xem_giay_phep"), id, HttpMethod.POST, params);
            return createResponseEntity(responseJson.getData(), 1l, "", true, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("[layDanhSachHoSo]", e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/call_service", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> callBackendService(HttpServletRequest request, @RequestBody Map<String, Object> form) {
    	System.out.println("/call_service:");
        try {
            Long total = 0L;
            Gson gson = new Gson();
            
            String urlBackEnd = form.get("URL_BACKEND").toString();
            String method = form.get("METHOD").toString();
            HttpMethod httpMethod = "POST".equals(method) ? HttpMethod.POST
                    : "GET".equals(method) ? HttpMethod.GET : HttpMethod.OPTIONS;
            Object requestObject;
            if(form.get("URL_BACKEND").toString().contains("fullSearchPaging")) {
            	Map<String, String> param = (Map<String, String>) form.get("REQUEST");
            	param.put("model", "47");
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
                total = ((Integer) response.getData()).longValue();
            }
            return createResponseEntity(responseJson.getData(), total, "", responseJson.getSuccess(), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("CALL_SERVICE_ERROR", e);
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
            ResponseJson responseJson = callRestTemplate(environment.getRequiredProperty("mt.backend") + environment.getRequiredProperty("mt.47.tra_giay_phep"), lyDo, HttpMethod.POST, params);
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
                    String uri = environment.getProperty("mt.backend") + environment.getProperty("mt.47.download") + "/" + idDinhKem;
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
            case "BGTVT0600047":
                return "Gia hạn giấy phép vận tải và thời gian lưu hành tại Việt Nam cho phương tiện của Trung Quốc";            
            default:
               	return "";
        }
    }
}
