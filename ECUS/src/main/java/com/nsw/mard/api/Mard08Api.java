package com.nsw.mard.api;

import com.google.common.util.concurrent.AtomicDouble;
import com.google.gson.Gson;
import com.nsw.api.BaseApi;
import com.nsw.common.model.CmonUnit;
import com.nsw.common.model.Country;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard08Constant;
import com.nsw.mard.p8.model.*;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/mard/08")
public class Mard08Api extends BaseApi {
    static final String TAG = "mard08Api";

    @RequestMapping(value = "/danhmuc/quocgia", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getCountry(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.COUNTRY_GET));
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/danhmuc/tinhthanh", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getProvince(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.PROVINCE_GET));
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/danhmuc/cuakhau", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getPort(
            @RequestParam(name = "countryCode", required = false) String countryCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.PORT_GET) + "?countryCode=" + countryCode);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/danhmuc/unittype", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getUOMType() {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.UOM_TYPE_GET));
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/danhmuc/unit", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getUOMs(
            @RequestParam(name = "unitTypeId", required = false) String unitTypeId,
            @RequestParam(name = "systemId") String systemId
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.UOMS_GET) + "?" + "unitTypeId=" + unitTypeId + "&systemId=" + systemId);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/danhmuc/dinhkem", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getAttachmentType(
            @RequestParam(name = "systemId") String systemId,
            @RequestParam(name = "type", required = true) String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.ATTACHMENT_TYPE_GET) + "?systemId=" + systemId + "&type=" + type);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/danhmuc/statusHoso", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getListStatusHoso(
            @RequestParam(name = "systemId") String systemId
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.LIST_STATUS_HOSO_GET) + "?systemId=" + systemId);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/hoso/type", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getListHosoType() {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.LIST_HOSO_TYPE_GET));
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/hoso/doctype", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getListDocumentType() {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.LIST_DOCUMENT_TYPE_GET));
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.HOSO_GET_BY_FILTER), filter);
        return json;
    }

    @RequestMapping(value = "/hoso/find", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHosoByFilter(@RequestBody FilterForm tbdFindHosoFilter08) {
        ResponseJson responseJson = new ResponseJson();
        try {
            tbdFindHosoFilter08.setFiActive(true);
            responseJson = BackendRequestHelper.getInstance().doPostRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.HOSO_GET_BY_FILTER), tbdFindHosoFilter08);
            return responseJson;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            responseJson.setData(null);
            responseJson.setSuccess(false);
            responseJson.setMessage(ex.getMessage());
            return responseJson;
        }
    }

    @RequestMapping(value = "/dinhkem/download/{id}", method = RequestMethod.GET)
    public void downloadAttachment(
            @PathVariable(value = "id") String fiGuid, HttpServletResponse response) {
        try {
            String restUri = Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.ATTACHMENT_DOWNLOAD) + "/" + fiGuid;
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.execute(
                    restUri,
                    HttpMethod.GET,
                    (ClientHttpRequest requestCallback) -> {
                    },
                    responseExtractor -> {
                        response.setStatus(HttpStatus.OK.value());
                        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                        response.addHeader(
                                HttpHeaders.CONTENT_DISPOSITION,
                                responseExtractor.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION));
                        IOUtils.copy(responseExtractor.getBody(), response.getOutputStream());
                        return null;
                    });
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @RequestMapping(value = "/dinhkem/find", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson findAttachmentById(
            @RequestParam(value = "id") String id
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.ATTACHMENT_FIND_BY_ID) + "?id=" + id, null);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            returnJson.setData(null);
            returnJson.setSuccess(false);
            returnJson.setMessage(ex.getMessage());
            return returnJson;
        }
    }

    @RequestMapping(value = "/dinhkem/find/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson findListAttachmentByMaHoso(
            @PathVariable(value = "id") String id
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.ATTACHMENT_FIND_BY_MA_HS_GET) + "/" + id);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/giayphep/view", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getLicense(
            @RequestParam(value = "code") String code,
            @RequestParam(value = "type") String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.LICENSE_VIEW_GET) + "?code=" + code + "&type=" + type);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/giayphep", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getGiayVSTY(
            @RequestParam(name = "code", required = true) String fiMaHS,
            @RequestParam(name = "type", required = true) String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(
                    String.format("%s?code=%s&type=%s", Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.GIAYPHEP_GET), fiMaHS, type)
            );
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/giayphep/list", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getGiayCNKDByTaxCode(
    ) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(
                Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.GIAYPHEP_GET_BY_TAX_CODE) + "?fiTaxCode="
        );
        return json;
    }

    @RequestMapping(value = "/hoso/find", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHoSoByID(
            @RequestParam(name = "idHoSo") String idHoSo
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.HOSO_GET_BY_FILTER) + "?id=" + idHoSo);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/lichsu", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHistoryByHSCode(
            @RequestParam("fiHSCode") String fiHSCode,
            @RequestParam(required = false) Integer p,
            @RequestParam(required = false) Integer s
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.HISTORY_BY_HS_CODE) + "?fiHSCode=" + fiHSCode + "&p=" + p + "&s=" + s);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/templates", method = RequestMethod.GET)
    public void getTemplateExcelFile(
            @RequestParam("type") String type,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            String templatePath = null;
            String fileName = null;
            switch (type) {
                case "animal":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_dv.xlsx");
                    fileName = "mard_08_dv.xlsx";
                    break;
                case "animal_product":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_spdv.xlsx");
                    fileName = "mard_08_spdv.xlsx";
                    break;
                case "animal_20a":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_dv_20a.xlsx");
                    fileName = "mard_08_dv_20a.xlsx";
                    break;
                case "animal_product_20a":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_spdv_20a.xlsx");
                    fileName = "mard_08_spdv_20a.xlsx";
                    break;
                case "exporter":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_ctxk.xlsx");
                    fileName = "mard_08_ctxk.xlsx";
                    break;
                case "quaratine":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_ddclkd.xlsx");
                    fileName = "mard_08_ddclkd.xlsx";
                    break;
                case "prodmfr":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_nmsxcb.xlsx");
                    fileName = "mard_08_nmsxcb.xlsx";
                    break;
                case "prodmfr_20a":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_cssx.xlsx");
                    fileName = "mard_08_cssx.xlsx";
                    break;
                case "mfgfactory":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_nmsxtacn.xlsx");
                    fileName = "mard_08_nmsxtacn.xlsx";
                    break;
                case "buyer":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/08/mard_08_bbh.xlsx");
                    fileName = "mard_08_bbh.xlsx";
                    break;
            }
            if (!templatePath.isEmpty() && !fileName.isEmpty()) {
                File tempFile = new File(templatePath);
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.getOutputStream().write(loadFile(tempFile));
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }


    @RequestMapping(value = {"hoso/download/{mau}/{idHoSo}"}, method = RequestMethod.GET)
    public void getMauDon(
            @PathVariable("mau") String mau,
            @PathVariable("idHoSo") String idHoSo,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.HOSO_GET_BY_FILTER) + "?id=" + idHoSo);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso08 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso08.class);

            ResponseJson jsonCountry = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.COUNTRY_GET));
            if (jsonCountry == null || jsonCountry.getSuccess() == false || jsonCountry.getData() == null) {
                return;
            }
            Gson gson = new Gson();
            List<Country> countries = new ArrayList<>();
            ((List<Object>) jsonCountry.getData()).forEach(obj -> countries.add(gson.fromJson(gson.toJson(obj), Country.class)));

            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
//            String tempFoleder = "/Users/hung/blameo/LOGS";
            String fileName = new Date().getTime() + "-hoso-mard-08.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;

            switch (mau) {
                case "19_dv":
                    variables = genMau19And20(hoso, countries);
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/08/mau_19_dv.docx");
                    break;
                case "19_spdv":
                    variables = genMau19And20(hoso, countries);
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/08/mau_19_spdv.docx");
                    break;
                case "20":
                    variables = genMau19And20(hoso, countries);
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/08/mau_20.docx");
                    break;
                case "20a":
                    variables = genMau20A(hoso, countries);
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/08/mau_20a.docx");
                    break;
            }

            tempFile = new File(tempFoleder + fileName);
            docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            docx.fillTemplate(variables);
            // save filled .docx file
            docx.save(tempFile.getPath());
            fileName = hoso.getFiHSCode() + "-hoso.docx";
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.getOutputStream().write(loadFile(tempFile));
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            return;
        }
    }

    @RequestMapping(path = "gcn/download/{mau}/{fiHSCode}", method = RequestMethod.GET)
    public void getGCN(
            @PathVariable String mau,
            @PathVariable String fiHSCode,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(
                    String.format("%s?code=%s&type=%s", Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.GIAYPHEP_GET), fiHSCode, mau));
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
//            String tempFoleder = "/Users/hung/blameo/LOGS";
            String fileName = new Date().getTime() + "-gcn-08.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;

            switch (mau) {
                case "cnkd":
                    Tbdcvcnkd08 cnkd08 = GsonUtils.getInstance().transform(json.getData(), Tbdcvcnkd08.class);
                    variables = genKDNK(cnkd08);
                    if (cnkd08.getFiDispatchType() == 1 || cnkd08.getFiDispatchType() == 4) {
                        templatePath = request.getRealPath("/WEB-INF/downloads/mard/08/mau_kdnk_dv.docx");
                    } else if (cnkd08.getFiDispatchType() == 2 || cnkd08.getFiDispatchType() == 3
                            || cnkd08.getFiDispatchType() == 5) {
                        templatePath = request.getRealPath("/WEB-INF/downloads/mard/08/mau_kdnk_spdv.docx");
                    }
                    tempFile = new File(tempFoleder + fileName);
                    docx = new Docx(templatePath);
                    docx.setVariablePattern(new VariablePattern("#{", "}"));
                    docx.fillTemplate(variables);
                    // save filled .docx file
                    docx.save(tempFile.getPath());
                    fileName = cnkd08.getFiQuarantineNo() + "-kdnk.docx";
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getOutputStream().write(loadFile(tempFile));
                    break;
                case "vsty":
                    Tbdcvvsty08 vsty08 = GsonUtils.getInstance().transform(json.getData(), Tbdcvvsty08.class);
                    variables = genVSTY(vsty08);
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/08/mau_vsty.docx");
                    tempFile = new File(tempFoleder + fileName);
                    docx = new Docx(templatePath);
                    docx.setVariablePattern(new VariablePattern("#{", "}"));
                    docx.fillTemplate(variables);
                    // save filled .docx file
                    docx.save(tempFile.getPath());
                    fileName = vsty08.getFiDispatchNo() + "-vsty.docx";
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getOutputStream().write(loadFile(tempFile));
                    break;
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            return;
        }
    }

    private String optional(String option) {
        return option == null ? "" : option;
    }

    private String optionalWithPrefixAndSuffix(String option, String prefix, String suffix) {
        return option == null ? "" : prefix + option + suffix;
    }

    private String formatLocaleDate(Date date) {
        if (date == null) {
            return "ngày ...... tháng ...... năm ......";
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return String.format("ngày %02d tháng %02d năm %d",
                c.get(Calendar.DAY_OF_MONTH),
                1 + c.get(Calendar.MONTH),
                c.get(Calendar.YEAR));
    }

    SimpleDateFormat simleDate = new SimpleDateFormat("dd/MM/yyyy");

    private String formatSimpleDate(Date date) {
        if (date == null) {
            return ".../.../....";
        }
        return simleDate.format(date);
    }

    private String listToStringDelimiter(Collection<String> arrays, String delimiter) {
        StringBuilder sb = new StringBuilder("");
        for (String element : arrays) {
            if (StringUtils.isNotEmpty(element)) {
                sb.append(element);
                sb.append(delimiter);
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - delimiter.length());
        }
        return sb.toString();
    }

    private String listToStringComma(Collection<String> arrays) {
        return listToStringDelimiter(arrays, ", ");
    }

    private String listToParagraph(Collection<String> arrays) {
        return listToStringDelimiter(arrays, "\n");

    }

    private Variables genMau20A(Tbdhoso08 hoso, List<Country> countries) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);

        List<CmonUnit> listUoms = new ArrayList<>();
        ResponseJson jsonUOM = getUOMs("4", "8");
        if (jsonUOM != null && jsonUOM.getSuccess() == true && jsonUOM.getData() != null) {
            Gson gson = new Gson();
            ((List<Object>) jsonUOM.getData()).forEach(obj -> listUoms.add(gson.fromJson(gson.toJson(obj), CmonUnit.class)));
        }

        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{fiHSCode}", optional(hoso.getFiHSCode())));
        variables.addTextVariable(new TextVariable("#{FiSigningLocation}", optional(hoso.getFiSigningLocation())));
        variables.addTextVariable(new TextVariable("#{FiSignedDate}", formatLocaleDate(hoso.getFiSignedDate())));
        variables.addTextVariable(new TextVariable("#{FiSignedByTitle}", optional(hoso.getFiSignedByTitle())));
        variables.addTextVariable(new TextVariable("#{FiSignedBy}", optional(hoso.getFiSignedBy())));

        variables.addTextVariable(new TextVariable("#{fiSrcPortName}", optional(hoso.getFiSrcPortName())));
        variables.addTextVariable(new TextVariable("#{fiBuyerName}", optional(hoso.getFiBuyerName())));
        variables.addTextVariable(new TextVariable("#{fiBuyerIdentity}",
                optional(listToStringComma(Arrays.asList(
                        optional(hoso.getFiBuyerIdentityNumber()),
                        hoso.getFiBuyerIdentityDate() == null ? "" : "cấp ngày " + simleDate.format(hoso.getFiBuyerIdentityDate()),
                        hoso.getFiBuyerIdentityPlace()
                )))));
        variables.addTextVariable(new TextVariable("#{fiBuyerContact}",
                optional(listToStringComma(Arrays.asList(
                        optional(hoso.getFiBuyerAddress()),
                        optional(hoso.getFiBuyerTel()),
                        optional(hoso.getFiBuyerFax())
                )))));
        variables.addTextVariable(new TextVariable("#{fiDstPortName}", optional(hoso.getFiDstPortName())));
        variables.addTextVariable(new TextVariable("#{fiImportingDate}",
                String.format("từ %s đến %s", formatSimpleDate(hoso.getFiImportingDateFrom()), formatSimpleDate(hoso.getFiImportingDateTo()))));

        variables.addTextVariable(new TextVariable("#{fiIntendedPurpose}", optional(hoso.getFiIntendedPurpose())));
        variables.addTextVariable(new TextVariable("#{fiProvidedDocument}", optional(hoso.getFiProvidedDocument())));
        variables.addTextVariable(new TextVariable("#{fiStorageLocation}", optional(hoso.getFiStorageLocation())));

        variables.addTextVariable(new TextVariable("#{fiSamplingLocation}", optional(hoso.getFiSamplingLocation())));
        variables.addTextVariable(new TextVariable("#{fiSamplingDate}",
                String.format("từ %s đến %s", formatSimpleDate(hoso.getFiSamplingDateFrom()), formatSimpleDate(hoso.getFiSamplingDateTo()))));

        variables.addTextVariable(new TextVariable("#{fiContact}",
                optional(listToStringComma(Arrays.asList(
                        optional(hoso.getFiContactName()),
                        optional(hoso.getFiContactTel()),
                        optional(hoso.getFiContactEmail()),
                        optional(hoso.getFiContactAddress())
                )))));
        variables.addTextVariable(new TextVariable("#{fiContract}", ""));
        variables.addTextVariable(new TextVariable("#{fiInvoice}", ""));
        variables.addTextVariable(new TextVariable("#{fiPackingList}", ""));

        if (CollectionUtils.isEmpty(hoso.getLstDocument()) == false) {
            hoso.getLstDocument().forEach(doc -> {
                String key = null;
                switch (doc.getFiTypeDoc().intValue()) {
                    case 1:
                        key = "#{fiContract}";
                        break;
                    case 2:
                        key = "#{fiInvoice}";
                        break;
                    case 3:
                        key = "#{fiPackingList}";
                        break;
                }
                if (StringUtils.isNotEmpty(key)) {
                    variables.addTextVariable(new TextVariable(key,
                            optional(listToStringComma(Arrays.asList(
                                    optionalWithPrefixAndSuffix(doc.getFiNumber(), "Số ", ""),
                                    doc.getFiDate() == null ? "" : "ngày " + simleDate.format(doc.getFiDate())
                            )))));
                }
            });
        }
        List<String> goodsDescription = new ArrayList<>();
        List<String> goodsScienceName = new ArrayList<>();
        HashMap<String, Double> goodsPackage = new HashMap<>();
        Set<String> circulateNo = new HashSet<>();
        Set<String> goodsOrigin = new HashSet<>();
        List<String> manufacturer = new ArrayList<>();
        List<String> seller = new ArrayList<>();
        List<String> sellerContact = new ArrayList<>();
        AtomicDouble totalNW = new AtomicDouble(0d);
        AtomicDouble totalGW = new AtomicDouble(0d);
//
        AtomicReference<String> unitName = new AtomicReference<>("");
        AtomicReference<String> nwUnitName = new AtomicReference<>("");
        AtomicReference<String> gwUnitName = new AtomicReference<>("");
        hoso.getLstProduct().forEach(hh -> {
            circulateNo.add(hh.getFiCirculateNo());
            goodsOrigin.add(getCountryname(hh.getFiCountryOrigin(), countries));
            StringBuilder goodSB = new StringBuilder();
            goodSB.append(hh.getFiProductName());
            if (hoso.getFiHSType() == 5) {
                //SPDV
                goodSB.append(" (");
                goodSB.append(String.format("%s %s, %s %s",
                        nf.format(hh.getFiNumber()),
                        getUOMName(hh.getFiUnitCode(), listUoms),
                        nf.format(hh.getFiNetWeight()),
                        getUOMName(hh.getFiNWUnitCode(), listUoms)));
                goodSB.append(")");
                totalNW.addAndGet(hh.getFiNetWeight());
                totalGW.addAndGet(hh.getFiGrossWeight());
                goodsPackage.put(
                        getUOMName(hh.getFiUnitCode(), listUoms),
                        hh.getFiNumber() + goodsPackage.getOrDefault(getUOMName(hh.getFiUnitCode(), listUoms), 0d));
                nwUnitName.set(getUOMName(hh.getFiNWUnitCode(), listUoms));
                gwUnitName.set(getUOMName(hh.getFiGWUnitCode(), listUoms));
            } else {
                //DV
                goodSB.append(" (");
                goodSB.append(String.format("%.0f con", hh.getFiNumber()));
                goodSB.append(")");
                goodsPackage.put(
                        "Con",
                        hh.getFiNumber() + goodsPackage.getOrDefault("Con", 0d));
                unitName.set("Con");
                goodsScienceName.add(optionalWithPrefixAndSuffix(hh.getFiProductScienceName(), " - ", "") + "  ");
            }
            goodsDescription.add(optionalWithPrefixAndSuffix(goodSB.toString(), " - ", ""));
        });

        hoso.getLstExporter().forEach(exporter -> {
            seller.add(optionalWithPrefixAndSuffix(listToStringComma(Arrays.asList(
                    optional(exporter.getFiExporterName()),
                    optional(getCountryname(exporter.getFiCountryOrigin(), countries)))), " - ", ";"));
            sellerContact.add(optionalWithPrefixAndSuffix(listToStringComma(Arrays.asList(
                    optional(exporter.getFiExporterAddress()),
                    optional(exporter.getFiExporterTel()),
                    optional(exporter.getFiExporterFax()))), " - ", ";"));
        });

        if (CollectionUtils.isEmpty(hoso.getLstProdMfr()) == false) {
            hoso.getLstProdMfr().forEach(nmsx -> manufacturer.add(
                    optionalWithPrefixAndSuffix(listToStringComma(Arrays.asList(
                            optional(nmsx.getFiMfrName()),
                            optional(nmsx.getFiMfrAddress()),
                            optional(getCountryname(nmsx.getFiMfrCountryrigin(), countries))
                    )), " - ", ";")));
        }
        variables.addTextVariable(new TextVariable("#{fiCirculateNo}", listToStringComma(circulateNo)));
        variables.addTextVariable(new TextVariable("#{fiManufacturer}", listToParagraph(manufacturer)));
        variables.addTextVariable(new TextVariable("#{fiGoodsOrigin}", listToStringComma(goodsOrigin)));
        variables.addTextVariable(new TextVariable("#{fiSeller}", listToParagraph(seller)));
        variables.addTextVariable(new TextVariable("#{fiSellerContact}", listToParagraph(sellerContact)));
        variables.addTextVariable(new TextVariable("#{GoodsName}", listToParagraph(goodsDescription)));
        variables.addTextVariable(new TextVariable("#{GoodsScienceName}", optionalWithPrefixAndSuffix(listToParagraph(goodsScienceName), " \n", "")));

        List<String> quantityAndPackage = new ArrayList<>();
        goodsPackage.forEach((k, v) -> {
            if (hoso.getFiHSType() == 5) {
                quantityAndPackage.add(String.format("%s %s", nf.format(v), k));
            } else {
                quantityAndPackage.add(String.format("%.0f %s", v, k));
            }
        });
        variables.addTextVariable(new TextVariable("#{fiQuantityAndPackage}", listToStringDelimiter(quantityAndPackage, "; ")));
        variables.addTextVariable(new TextVariable("#{FiGoodsNetWeight}", StringUtils.isEmpty(nwUnitName.get()) ? ""
                : String.format("%s %s", nf.format(totalNW.get()), nwUnitName.get())));
        variables.addTextVariable(new TextVariable("#{FiGoodsGrossWeight}", StringUtils.isEmpty(gwUnitName.get()) ? ""
                : String.format("%s %s", nf.format(totalGW.get()), gwUnitName.get())));
        return variables;
    }


    private Variables genMau19And20(Tbdhoso08 hoso, List<Country> countries) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);

        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{fiHSCode}",
                hoso.getFiHSCode() == null ? "" : hoso.getFiHSCode()));
        variables.addTextVariable(new TextVariable("#{fiImporterName}",
                hoso.getFiImporterName() == null ? "" : hoso.getFiImporterName()));
        variables.addTextVariable(new TextVariable("#{fiImporterAddress}",
                hoso.getFiImporterAddress() == null ? "" : hoso.getFiImporterAddress()));
        variables.addTextVariable(new TextVariable("#{fiImporterTel}",
                hoso.getFiImporterTel() == null ? "" : hoso.getFiImporterTel()));
        variables.addTextVariable(new TextVariable("#{fiImporterFax}",
                hoso.getFiImporterFax() == null ? "" : hoso.getFiImporterFax()));
        variables.addTextVariable(new TextVariable("#{fiImporterEmail}",
                hoso.getFiImporterEmail() == null ? "" : hoso.getFiImporterEmail()));
        variables.addTextVariable(new TextVariable("#{fiProcessingDate}",
                hoso.getFiProcessingDate() == null ? "" : hoso.getFiProcessingDate()));
        variables.addTextVariable(new TextVariable("#{fiIntendedPurpose}",
                hoso.getFiIntendedPurpose() == null ? "" : hoso.getFiIntendedPurpose()));
        variables.addTextVariable(new TextVariable("#{fiProvidedDocument}",
                hoso.getFiProvidedDocument() == null ? "" : hoso.getFiProvidedDocument()));
        variables.addTextVariable(new TextVariable("#{fiSigningLocation}",
                hoso.getFiSigningLocation() == null ? "" : hoso.getFiSigningLocation()));
        variables.addTextVariable(new TextVariable("#{fiSignedDate}", hoso.getFiSignedDate() == null ? "" :
                String.format("ngày %02d tháng %02d năm %d",
                        hoso.getFiSignedDate().getDate(),
                        hoso.getFiSignedDate().getMonth() + 1, 1900 + hoso.getFiSignedDate().getYear())));
        variables.addTextVariable(new TextVariable("#{fiSignedBy}",
                hoso.getFiSignedBy() == null ? "" : hoso.getFiSignedBy()));
        variables.addTextVariable(new TextVariable("#{fiSignedByTitle}",
                hoso.getFiSignedByTitle() == null ? "" : hoso.getFiSignedByTitle()));

        TableVariable productTableVariable = new TableVariable();
        List<Variable> sttVars = new ArrayList<>();
        List<Variable> fiProductNameVars = new ArrayList<>();
        List<Variable> fiQtyMaleVars = new ArrayList<>();
        List<Variable> fiQtyFemaleVars = new ArrayList<>();
        List<Variable> fiNumberVars = new ArrayList<>();
        List<Variable> fiUnitNameVars = new ArrayList<>();
        List<Variable> fiPortNameVars = new ArrayList<>();
        List<Variable> fiCountryOriginVars = new ArrayList<>();

        if (!hoso.getLstProduct().isEmpty()) {
            int index = 0;
            for (Tbdhanghoa08 hanghoa : hoso.getLstProduct()) {
                index++;
                sttVars.add(new TextVariable("#{stt}", Integer.toString(index)));
                fiProductNameVars.add(new TextVariable("#{fiProductName}",
                        hanghoa.getFiProductName() == null ? "" : hanghoa.getFiProductName()));
                fiQtyMaleVars.add(new TextVariable("#{fiQtyMale}",
                        hanghoa.getFiQtyMale() == null ? "" : hanghoa.getFiQtyMale().toString()));
                fiQtyFemaleVars.add(new TextVariable("#{fiQtyFemale}",
                        hanghoa.getFiQtyFemale() == null ? "" : hanghoa.getFiQtyFemale().toString()));
                fiNumberVars.add(new TextVariable("#{fiNumber}",
                        hanghoa.getFiNumber() == 0 ? "" : String.format("%s", nf.format(hanghoa.getFiNumber()))));
                if (hoso.getFiHSType() == 1 || hoso.getFiHSType() == 4) {
                    fiUnitNameVars.add(new TextVariable("#{fiUnitName}", "(con)"));
                } else {
                    fiUnitNameVars.add(new TextVariable("#{fiUnitName}", "(Kilogram)"));
                }
                fiPortNameVars.add(new TextVariable("#{fiPortName}",
                        hanghoa.getFiPortName() == null ? "" : hanghoa.getFiPortName()));
                fiCountryOriginVars.add(new TextVariable("#{fiCountryOrigin}",
                        hanghoa.getFiCountryOrigin() == null ? "" : getCountryname(hanghoa.getFiCountryOrigin(), countries)));
            }
            productTableVariable.addVariable(sttVars);
            productTableVariable.addVariable(fiProductNameVars);
            productTableVariable.addVariable(fiQtyMaleVars);
            productTableVariable.addVariable(fiQtyFemaleVars);
            productTableVariable.addVariable(fiNumberVars);
            productTableVariable.addVariable(fiUnitNameVars);
            productTableVariable.addVariable(fiPortNameVars);
            productTableVariable.addVariable(fiCountryOriginVars);
        }
        variables.addTableVariable(productTableVariable);

        String lstExporter = "";
        if (!hoso.getLstExporter().isEmpty()) {
            for (Tbdctyxk08 ctyxk : hoso.getLstExporter()) {
                lstExporter += ctyxk.getFiExporterName() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstExporter}", lstExporter));

        String lstProdMfr = "";
        if (!hoso.getLstProdMfr().isEmpty()) {
            for (Tbdcssxsp08 prodMfr : hoso.getLstProdMfr()) {
                lstProdMfr += prodMfr.getFiMfrName() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstProdMfr}", lstProdMfr));

        String lstMfgFactory = "";
        if (!hoso.getLstMfgFactory().isEmpty()) {
            for (Tbdnmsx08 factory : hoso.getLstMfgFactory()) {
                lstMfgFactory += factory.getFiFactoryName() + " (" + factory.getFiFactoryAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstMfgFactory}", lstMfgFactory));

        String lstIsolatedLocation = "";
        if (!hoso.getLstIsolatedLocation().isEmpty()) {
            for (Tbdddclkd08 isoLoc : hoso.getLstIsolatedLocation()) {
                lstIsolatedLocation += isoLoc.getFiIsoLocName() + " (" + isoLoc.getFiIsoLocAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstIsolatedLocation}", lstIsolatedLocation));

        return variables;
    }

    private Variables genKDNK(Tbdcvcnkd08 cnkd) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);

        Variables variables = new Variables();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        variables.addTextVariable(new TextVariable("#{fiCompanyName}",
                StringUtils.defaultIfEmpty(getHosoByNSWFileCode(cnkd.getFiHSCode()).getFiImporterName(), "")));
        variables.addTextVariable(new TextVariable("#{fiQuarantineNo}", cnkd.getFiQuarantineNo() != null ?
                cnkd.getFiQuarantineNo() : ""));
        variables.addTextVariable(new TextVariable("#{fiSummary}", cnkd.getFiSummary() != null ?
                cnkd.getFiSummary() : ""));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmAddress}", cnkd.getFiSignConfirmAddress() != null ?
                cnkd.getFiSignConfirmAddress() : ""));
        variables.addTextVariable(new TextVariable("#{fiDispatchDate}", String.format("ngày %02d tháng %02d năm %d",
                cnkd.getFiSignConfirmDate().getDate(),
                cnkd.getFiSignConfirmDate().getMonth() + 1, 1900 + cnkd.getFiSignConfirmDate().getYear())));
        variables.addTextVariable(new TextVariable("#{fiPreamble}", cnkd.getFiPreamble() != null ?
                cnkd.getFiPreamble() : ""));
        variables.addTextVariable(new TextVariable("#{fiExecutionTime}", cnkd.getFiExecutionTime() != null ?
                cnkd.getFiExecutionTime() : ""));
        variables.addTextVariable(new TextVariable("#{fiPurpose}", cnkd.getFiPurpose() != null ?
                cnkd.getFiPurpose() : ""));
        variables.addTextVariable(new TextVariable("#{fiReportInfo}", cnkd.getFiReportInfo() != null ?
                cnkd.getFiReportInfo() : ""));
        variables.addTextVariable(new TextVariable("#{fiContent}", cnkd.getFiContent() != null ?
                cnkd.getFiContent() : ""));
        if (cnkd.getFiRecipient() != null) {
            String splitRecipient[] = cnkd.getFiRecipient().split(";#");
            String fiRecipient = "";
            for (int i = 0; i < splitRecipient.length; i++) {
                fiRecipient += "- " + splitRecipient[i].trim() + ";\n";
            }
            variables.addTextVariable(new TextVariable("#{fiRecipient}", fiRecipient));
        } else {
            variables.addTextVariable(new TextVariable("#{fiRecipient}", ""));
        }

        String signConfirmTitle = "";
        String signConfirmName = "";
        if (cnkd.getFiSignConfirmTitle() != null) {
            if (cnkd.getFiSignConfirmTitle().trim().toLowerCase().equals("cục trưởng")) {
                signConfirmTitle = cnkd.getFiSignConfirmTitle().toUpperCase();
                signConfirmName = "Đã ký\n" + cnkd.getFiSignConfirmName();
            } else {
                signConfirmTitle += "KT.CỤC TRƯỞNG\n" + cnkd.getFiSignConfirmTitle().toUpperCase();
                signConfirmName += "Đã ký\n" + cnkd.getFiSignConfirmName();
            }
        } else {
            signConfirmTitle += "KT.CỤC TRƯỞNG\n";
            signConfirmName += "Đã ký\n" + (cnkd.getFiSignConfirmName() != null ?
                    cnkd.getFiSignConfirmName() : "");
        }
        variables.addTextVariable(new TextVariable("#{fiSignConfirmTitle}", signConfirmTitle));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmName}", signConfirmName));

        TableVariable productTableVariable = new TableVariable();
        List<Variable> sttVars = new ArrayList<>();
        List<Variable> fiAnimalNameVars = new ArrayList<>();
        List<Variable> fiQtyMaleVars = new ArrayList<>();
        List<Variable> fiQtyFemaleVars = new ArrayList<>();
        List<Variable> fiNumberVars = new ArrayList<>();
        List<Variable> fiUniNameVars = new ArrayList<>();
        List<Variable> fiCountryOriginVars = new ArrayList<>();
        List<Variable> fiPortNameVars = new ArrayList<>();

        if (!cnkd.getLstProduct().isEmpty()) {
            int index = 0;
            for (Tbdcnkdhanghoa08 hanghoa : cnkd.getLstProduct()) {
                index++;
                sttVars.add(new TextVariable("#{stt}", Integer.toString(index)));
                fiAnimalNameVars.add(new TextVariable("#{fiProductName}",
                        hanghoa.getFiProductName() == null ? "" : hanghoa.getFiProductName()));
                fiQtyMaleVars.add(new TextVariable("#{fiQtyMale}",
                        hanghoa.getFiQtyMale() == null ? "" : Integer.toString(hanghoa.getFiQtyMale())));
                fiQtyFemaleVars.add(new TextVariable("#{fiQtyFemale}",
                        hanghoa.getFiQtyFemale() == null ? "" : Integer.toString(hanghoa.getFiQtyFemale())));
                fiNumberVars.add(new TextVariable("#{fiNumber}",
                        hanghoa.getFiNumberOrigin() == 0 ? "" : nf.format(hanghoa.getFiNumberOrigin()))
                );
                if (hanghoa.getFiUnitName() == null) {
                    fiUniNameVars.add(new TextVariable("#{fiUnitName}", ""));
                } else {
                    fiUniNameVars.add(new TextVariable("#{fiUnitName}",
                            (cnkd.getFiDispatchType() != 1 && cnkd.getFiDispatchType() != 4) ?
                                    String.format(" (%s)", hanghoa.getFiUnitName()) : ""));
                }
                fiCountryOriginVars.add(new TextVariable("#{fiCountryOriginName}",
                        hanghoa.getFiCountryOriginName() == null ? "" : hanghoa.getFiCountryOriginName()));
                fiPortNameVars.add(new TextVariable("#{fiPortName}",
                        hanghoa.getFiPortName() == null ? "" : hanghoa.getFiPortName()));
            }
        }
        productTableVariable.addVariable(sttVars);
        productTableVariable.addVariable(fiAnimalNameVars);
        productTableVariable.addVariable(fiQtyMaleVars);
        productTableVariable.addVariable(fiQtyFemaleVars);
        productTableVariable.addVariable(fiNumberVars);
        productTableVariable.addVariable(fiUniNameVars);
        productTableVariable.addVariable(fiCountryOriginVars);
        productTableVariable.addVariable(fiPortNameVars);
        variables.addTableVariable(productTableVariable);

        // add list exporter
        String exporterList = "";
        if (!cnkd.getLstCompany().isEmpty()) {
            for (Tbdcnkdctyxk08 ctyxk08 : cnkd.getLstCompany()) {
                exporterList += ctyxk08.getFiExporterName() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstCompany}", exporterList));

        // add list quarantine
        String quarantineList = "";
        if (!cnkd.getLstIsoLoc().isEmpty()) {
            for (Tbdcnkdddcl08 ddclkd08 : cnkd.getLstIsoLoc()) {
                quarantineList += ddclkd08.getFiIsoLocName() + " (" +
                        ddclkd08.getFiIsoLocAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstIsoLoc}", quarantineList));

        // add list processing
        String mfrList = "";
        if (!cnkd.getLstMfr().isEmpty()) {
            for (Tbdcnkdnmsx08 nmsx08 : cnkd.getLstMfr()) {
                mfrList += nmsx08.getFiFactoryName() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstMfr}", mfrList));

        return variables;
    }

    private Variables genVSTY(Tbdcvvsty08 vsty) {
        Variables variables = new Variables();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        variables.addTextVariable(new TextVariable("#{fiCompanyName}",
                StringUtils.defaultIfEmpty(getHosoByNSWFileCode(vsty.getFiHSCode()).getFiImporterName(), "")));

        variables.addTextVariable(new TextVariable("#{fiDispatchNo}", vsty.getFiDispatchNo() != null ?
                vsty.getFiDispatchNo() : ""));
        variables.addTextVariable(new TextVariable("#{fiSummary}", vsty.getFiSummary() != null ?
                vsty.getFiSummary() : ""));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmAddress}", vsty.getFiSignConfirmAddress() != null ?
                vsty.getFiSignConfirmAddress() : ""));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", String.format("ngày %02d tháng %02d năm %d",
                vsty.getFiSignConfirmDate().getDate(),
                vsty.getFiSignConfirmDate().getMonth() + 1, 1900 + vsty.getFiSignConfirmDate().getYear())));
        variables.addTextVariable(new TextVariable("#{fiPreamble}", vsty.getFiPreamble() != null ?
                vsty.getFiPreamble() : ""));
        variables.addTextVariable(new TextVariable("#{fiExecutionTime}", vsty.getFiExecutionTime() != null ?
                vsty.getFiExecutionTime() : ""));
        variables.addTextVariable(new TextVariable("#{fiPurpose}", vsty.getFiPurpose() != null ?
                vsty.getFiPurpose() : ""));
        variables.addTextVariable(new TextVariable("#{fiContent}", vsty.getFiContent() != null ?
                vsty.getFiContent() : ""));
        if (vsty.getFiRecipient() != null) {
            String splitRecipient[] = vsty.getFiRecipient().split(";#");
            String fiRecipient = "";
            for (int i = 0; i < splitRecipient.length; i++) {
                fiRecipient += "- " + splitRecipient[i].trim() + ";\n";
            }
            variables.addTextVariable(new TextVariable("#{fiRecipient}", fiRecipient));
        } else {
            variables.addTextVariable(new TextVariable("#{fiRecipient}", ""));
        }

        String signConfirmTitle = "";
        String signConfirmName = "";
        if (vsty.getFiSignConfirmTitle() != null) {
            if (vsty.getFiSignConfirmTitle().trim().toLowerCase().equals("cục trưởng")) {
                signConfirmTitle = vsty.getFiSignConfirmTitle().toUpperCase();
                signConfirmName = vsty.getFiSignConfirmName() != null ?
                        ("Đã ký\n" + vsty.getFiSignConfirmName()) : "";
            } else {
                signConfirmTitle += "KT.CỤC TRƯỞNG\n" + vsty.getFiSignConfirmTitle().toUpperCase();
                signConfirmName += "Đã ký\n" + (vsty.getFiSignConfirmName() != null ?
                        vsty.getFiSignConfirmName() : "");
            }
        } else {
            signConfirmTitle = "KT.CỤC TRƯỞNG";
            signConfirmName += "Đã ký\n" + (vsty.getFiSignConfirmName() != null ?
                    vsty.getFiSignConfirmName() : "");
        }
        variables.addTextVariable(new TextVariable("#{fiSignConfirmTitle}", signConfirmTitle));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmName}", signConfirmName));

        TableVariable productTableVariable = new TableVariable();
        List<Variable> sttVars = new ArrayList<>();
        List<Variable> fiAnimalNameVars = new ArrayList<>();
        List<Variable> fiQtyVars = new ArrayList<>();
        List<Variable> fiCountryOriginVars = new ArrayList<>();
        List<Variable> fiPortNameVars = new ArrayList<>();

        if (!vsty.getLstAnimal().isEmpty()) {
            int index = 0;
            for (Tbdvstydongvat08 hanghoa : vsty.getLstAnimal()) {
                index++;
                sttVars.add(new TextVariable("#{stt}", Integer.toString(index)));
                fiAnimalNameVars.add(new TextVariable("#{fiAnimalName}",
                        hanghoa.getFiAnimalName() == null ? "" : hanghoa.getFiAnimalName()));
                fiQtyVars.add(new TextVariable("#{fiAnimalQty}",
                        hanghoa.getFiQtyMale() == null ? "" :
                                Integer.toString(hanghoa.getFiQtyMale() + hanghoa.getFiQtyFemale())));
                fiCountryOriginVars.add(new TextVariable("#{fiCountryOrigin}",
                        hanghoa.getFiCountryOrigin() == null ? "" : hanghoa.getFiCountryOrigin()));
                fiPortNameVars.add(new TextVariable("#{fiPortName}",
                        hanghoa.getFiPortName() == null ? "" : hanghoa.getFiPortName()));
            }
        }
        productTableVariable.addVariable(sttVars);
        productTableVariable.addVariable(fiAnimalNameVars);
        productTableVariable.addVariable(fiQtyVars);
        productTableVariable.addVariable(fiCountryOriginVars);
        productTableVariable.addVariable(fiPortNameVars);
        variables.addTableVariable(productTableVariable);

        // add list exporter
        String exporterList = "";
        if (!vsty.getLstCompany().isEmpty()) {
            for (Tbdvstyctyxk08 ctyxk08 : vsty.getLstCompany()) {
                exporterList += ctyxk08.getFiExporterName() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstCompany}", exporterList));

        // add list quarantine
        String quarantineList = "";
        if (!vsty.getLstIsoLoc().isEmpty()) {
            for (Tbdvstyclkd08 ddclkd08 : vsty.getLstIsoLoc()) {
                quarantineList += ddclkd08.getFiIsoLocName() + " (" +
                        ddclkd08.getFiIsoLocAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{lstIsoLoc}", quarantineList));

        return variables;
    }

    private String getCountryname(String countrycode, List<Country> countries) {
        String result = "";
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCountrycode().equals(countrycode)) {
                result = countries.get(i).getCountryname();
                break;
            }
        }
        return result;
    }

    private Tbdhoso08 getHosoByNSWFileCode(String fiNSWFileCode){
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(
                Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.HOSO_GET_BY_FILTER) + "?nswFileCode=" + fiNSWFileCode);
        if (json == null || json.getSuccess() == false || json.getData() == null) {
//            StringUtils.defaultIfEmpty(getHosoByNSWFileCode(cnkd.getFiHSCode()).getFiImporterName(), "")
            return new Tbdhoso08();
        }
        return GsonUtils.getInstance().transform(json.getData(), Tbdhoso08.class);
    }

    private String getUOMName(String unitCode, List<CmonUnit> listUoms) {
        return listUoms.stream().filter(uom -> uom.getUnitcode().equals(unitCode)).findFirst().orElse(new CmonUnit()).getUnitname();
    }
}
