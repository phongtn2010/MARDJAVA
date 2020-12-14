package com.nsw.mard.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard06Constant;
import com.nsw.mard.p6.model.*;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mard/06")
public class Mard06Api extends BaseApi {
    static final String TAG = "mard06Api";

    @RequestMapping(value = "/danhmuc/quocgia", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getCountry(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.COUNTRY_GET));
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
    ResponseJson getDanhmucTinhthanh() {
        ResponseJson responseJson = new ResponseJson();
        try {
            responseJson = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.PROVINCE_GET));
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

    @RequestMapping(value = "/danhmuc/cuakhau", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getPort(
            @RequestParam(name = "countryCode", required = false) String countryCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.PORT_GET) + "?countryCode=" + countryCode);
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
            @RequestParam(name = "unitTypeId", required = true) String unitTypeId,
            @RequestParam(name = "systemId", required = true) String systemId
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.UOMS_GET) + "?unitTypeId=" + unitTypeId + "&systemId=" + systemId);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.LIST_STATUS_HOSO_GET) + "?systemId=" + systemId);
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
            @RequestParam(name = "systemId") String systemId
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.ATTACHMENT_TYPE_GET) + "?systemId=" + systemId);
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
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_GET_BY_FILTER), filter);
        return json;
    }

    @RequestMapping(value = "/hoso/find", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHoSoByID(
            @RequestParam(name = "idHoSo") String idHoSo
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_GET_BY_FILTER) + "?id=" + idHoSo);
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

    @RequestMapping(value = "/dinhkem/download/{id}", method = RequestMethod.GET)
    public void downloadAttachment(
            @PathVariable(value = "id") String fiGuid, HttpServletResponse response) {
        try {
            String restUri = Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.ATTACHMENT_DOWNLOAD) + "/" + fiGuid;
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


    @RequestMapping(value = "/giayphep/view", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getLicense(
            @RequestParam(value = "code") String code,
            @RequestParam(value = "type") String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.LICENSE_VIEW_GET) + "?code=" + code + "&type=" + type);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HISTORY_BY_HS_CODE) + "?fiHSCode=" + fiHSCode + "&p=" + p + "&s=" + s);
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
                case "product":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_hanghoa.xlsx");
                    fileName = "mard_06_hanghoa.xlsx";
                    break;
                case "exporter":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_ctxk.xlsx");
                    fileName = "mard_06_ctxk.xlsx";
                    break;
                case "processing":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_cssx.xlsx");
                    fileName = "mard_06_cssx.xlsx";
                    break;
                case "location_quarantine":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_ddclkd.xlsx");
                    fileName = "mard_06_ddclkd.xlsx";
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
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_GET_BY_FILTER) + "?id=" + idHoSo);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            TbdHoso06 hoso = GsonUtils.getInstance().transform(json.getData(), TbdHoso06.class);

            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-hoso-mard-06.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;

            variables = genMau02(hoso);
            templatePath = request.getRealPath("/WEB-INF/downloads/mard/06/mau_02.docx");
            tempFile = new File(tempFoleder + fileName);
            docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            docx.fillTemplate(variables);
            // save filled .docx file
            docx.save(tempFile.getPath());
            fileName = hoso.getFiNSWFileCode() + "-hoso.docx";
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

    @RequestMapping(path = "gcn/download/{mau}/{fiNSWFileCode}", method = RequestMethod.GET)
    public void getGCN(
            @PathVariable String mau,
            @PathVariable String fiNSWFileCode,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.LICENSE_VIEW_GET) + "?code=" + fiNSWFileCode + "&type=" + mau);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            TbdCongvan06 congvan06 = GsonUtils.getInstance().transform(json.getData(), TbdCongvan06.class);

            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-vsty-06.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;

            switch (mau) {
                case "kdnk":
                    variables = genCongvan(congvan06);
                    if (congvan06.getFiProductType() == 1) {
                        templatePath = request.getRealPath("/WEB-INF/downloads/mard/06/mau_kdnk.docx");
                    } else {
                        templatePath = request.getRealPath("/WEB-INF/downloads/mard/06/mau_kdnk_spdv.docx");
                    }
                    tempFile = new File(tempFoleder + fileName);
                    docx = new Docx(templatePath);
                    docx.setVariablePattern(new VariablePattern("#{", "}"));
                    docx.fillTemplate(variables);
                    // save filled .docx file
                    docx.save(tempFile.getPath());
                    fileName = congvan06.getFiDispatchNo() + "-kdnk.docx";
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getOutputStream().write(loadFile(tempFile));
                    break;
                case "vsty":
                    variables = genCongvan(congvan06);
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/06/mau_vsty.docx");
                    tempFile = new File(tempFoleder + fileName);
                    docx = new Docx(templatePath);
                    docx.setVariablePattern(new VariablePattern("#{", "}"));
                    docx.fillTemplate(variables);
                    // save filled .docx file
                    docx.save(tempFile.getPath());
                    fileName = congvan06.getFiDispatchNo() + "-vsty.docx";
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

    private Variables genMau02(TbdHoso06 hoso) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);
        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{fiNSWFileCode}", hoso.getFiNSWFileCode() == null ?
                "" : hoso.getFiNSWFileCode()));
        variables.addTextVariable(new TextVariable("#{fiImporterName}", hoso.getFiImporterName() == null ?
                "" : hoso.getFiImporterName()));
        variables.addTextVariable(new TextVariable("#{fiImporterAddress}", hoso.getFiImporterAddress() == null ?
                "" : hoso.getFiImporterAddress()));
        variables.addTextVariable(new TextVariable("#{fiImporterTel}", hoso.getFiImporterTel() == null ?
                "" : hoso.getFiImporterTel()));
        variables.addTextVariable(new TextVariable("#{fiImporterFax}", hoso.getFiImporterFax() == null ?
                "" : hoso.getFiImporterFax()));
        variables.addTextVariable(new TextVariable("#{fiImporterEmail}", hoso.getFiImporterEmail() == null ?
                "" : hoso.getFiImporterEmail()));
        variables.addTextVariable(new TextVariable("#{fiBordergateName}", hoso.getFiBordergateName() == null ?
                "" : hoso.getFiBordergateName()));
        variables.addTextVariable(new TextVariable("#{fiTimeQuarantine}", hoso.getFiTimeQuarantine() == null ?
                "" : hoso.getFiTimeQuarantine()));
        variables.addTextVariable(new TextVariable("#{fiPurpose}", hoso.getFiPurpose() == null ?
                "" : hoso.getFiPurpose()));
        variables.addTextVariable(new TextVariable("#{fiRelatedDocuments}", hoso.getFiRelatedDocuments() == null ?
                "" : hoso.getFiRelatedDocuments()));
        variables.addTextVariable(new TextVariable("#{fiSignPosition}", hoso.getFiSignPosition() == null ?
                "" : hoso.getFiSignPosition().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{fiSignName}", hoso.getFiSignName() == null ?
                "" : hoso.getFiSignName()));
        variables.addTextVariable(new TextVariable("#{fiSignAddress}", hoso.getFiSignAddress() == null ?
                "" : hoso.getFiSignAddress()));
        variables.addTextVariable(new TextVariable("#{fiSignDate}", String.format("ngày %02d tháng %02d năm %d",
                hoso.getFiSignDate().getDate(),
                hoso.getFiSignDate().getMonth() + 1, 1900 + hoso.getFiSignDate().getYear())));

        // add list product
        TableVariable productTableVariable = new TableVariable();
        List<Variable> sttVars = new ArrayList<>();
        List<Variable> fiProductBusinessNameVars = new ArrayList<>();
        List<Variable> fiProductScienceNameVar = new ArrayList<>();
        List<Variable> fiSizeOrTypeVar = new ArrayList<>();
        List<Variable> fiQuantityVar = new ArrayList<>();
        List<Variable> fiPackageUnitNameVar = new ArrayList<>();
        List<Variable> fiOriginCountryNameVar = new ArrayList<>();

        if (!hoso.getFiProductList().isEmpty()) {
            int index = 0;
            for (TbdHanghoa06 hanghoa06 : hoso.getFiProductList()) {
                index++;
                sttVars.add(new TextVariable("#{stt}", Integer.toString(index)));
                fiProductBusinessNameVars.add(new TextVariable("#{fiProductBusinessName}",
                        hanghoa06.getFiProductBusinessName() == null ? "" : hanghoa06.getFiProductBusinessName()));
                fiProductScienceNameVar.add(new TextVariable("#{fiProductScienceName}",
                        hanghoa06.getFiProductScienceName() == null ? "" : hanghoa06.getFiProductScienceName()));
                fiSizeOrTypeVar.add(new TextVariable("#{fiSizeOrType}",
                        hanghoa06.getFiSizeOrType() == null ? "" : hanghoa06.getFiSizeOrType()));
                fiQuantityVar.add(new TextVariable("#{fiQuantity}",
                        hanghoa06.getFiQuantity() == null ? "" :
                                nf.format(hanghoa06.getFiQuantity())));
                fiPackageUnitNameVar.add(new TextVariable("#{fiPackageUnitName}",
                        hanghoa06.getFiPackageUnitName() == null ? "" : hanghoa06.getFiPackageUnitName()));
                fiOriginCountryNameVar.add(new TextVariable("#{fiOriginCountryName}",
                        hanghoa06.getFiOriginCountryName() == null ? "" : hanghoa06.getFiOriginCountryName()));
            }
        }
        productTableVariable.addVariable(sttVars);
        productTableVariable.addVariable(fiProductBusinessNameVars);
        productTableVariable.addVariable(fiProductScienceNameVar);
        productTableVariable.addVariable(fiSizeOrTypeVar);
        productTableVariable.addVariable(fiQuantityVar);
        productTableVariable.addVariable(fiPackageUnitNameVar);
        productTableVariable.addVariable(fiOriginCountryNameVar);
        variables.addTableVariable(productTableVariable);

        // add list exporter
        String exporterList = "";
        if (!hoso.getFiExporterCountryList().isEmpty()) {
            for(TbdCtyxk06 ctyxk06 : hoso.getFiExporterCountryList()) {
                exporterList += ctyxk06.getFiExporterCountryName() + " (" + ctyxk06.getFiExporterCountryAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiExporterList}", exporterList));

        // add list processing
        String processingList = "";
        String processingApproveNumnerList = "";
        if (!hoso.getFiProcessingList().isEmpty()) {
            for (TbdCssx06 cssx06 : hoso.getFiProcessingList()) {
                processingList += cssx06.getFiProcessingName() + " - " + cssx06.getFiProcessingAddress()
                         + (cssx06.getFiProcessingApprovalNumber() == null ? "" :
                        " (" + cssx06.getFiProcessingApprovalNumber() + ")") + "; ";
                processingApproveNumnerList += cssx06.getFiProcessingApprovalNumber() == null ?
                        "" : cssx06.getFiProcessingApprovalNumber() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiProcessingList}", processingList));
        variables.addTextVariable(new TextVariable("#{fiProcessingApproveNumberList}", processingApproveNumnerList));

        // add list quarantine
        String quarantineList = "";
        if (!hoso.getFiLocationQuarantineList().isEmpty()) {
            for (TbdDdclkd06 ddclkd06: hoso.getFiLocationQuarantineList()) {
                quarantineList += ddclkd06.getFiLocationQuarantineName() + " (" +
                        ddclkd06.getFiLocationQuarantineAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiLocationQuarantineList}", quarantineList));

        return variables;
    }

    private Variables genCongvan(TbdCongvan06 congvan06) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);
        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{fiCompanyName}",
                StringUtils.defaultIfEmpty(getHosoByNSWFileCode(congvan06.getFiNSWFileCode()).getFiImporterName(), "")));
        variables.addTextVariable(new TextVariable("#{fiDispatchNo}", congvan06.getFiDispatchNo() != null ?
                congvan06.getFiDispatchNo() : ""));
        variables.addTextVariable(new TextVariable("#{fiSummary}", congvan06.getFiSummary() != null ?
                congvan06.getFiSummary() : ""));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmAddress}", congvan06.getFiSignConfirmAddress() != null ?
                congvan06.getFiSignConfirmAddress() : ""));
        variables.addTextVariable(new TextVariable("#{fiDispatchDate}", String.format("ngày %02d tháng %02d năm %d",
                congvan06.getFiDispatchDate().getDate(),
                congvan06.getFiDispatchDate().getMonth() + 1, 1900 + congvan06.getFiDispatchDate().getYear())));
        variables.addTextVariable(new TextVariable("#{fiPreamble}", congvan06.getFiPreamble() != null ?
                congvan06.getFiPreamble() : ""));
        variables.addTextVariable(new TextVariable("#{fiBordergateName}", congvan06.getFiBordergateName() != null ?
                congvan06.getFiBordergateName() : ""));
        variables.addTextVariable(new TextVariable("#{fiTimeQuarantine}", congvan06.getFiTimeQuarantine() != null ?
                congvan06.getFiTimeQuarantine() : ""));
        variables.addTextVariable(new TextVariable("#{fiPurpose}", congvan06.getFiPurpose() != null ?
                congvan06.getFiPurpose() : ""));
        variables.addTextVariable(new TextVariable("#{fiResponseContent}", congvan06.getFiResponseContent() != null ?
                congvan06.getFiResponseContent() : ""));
        if (congvan06.getFiRecipient() != null) {
            String splitRecipient[] = congvan06.getFiRecipient().split(",");
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
        if (congvan06.getFiSignPosition() != null) {
            if (congvan06.getFiSignPosition().trim().toLowerCase().equals("cục trưởng")) {
                signConfirmTitle = congvan06.getFiSignPosition().toUpperCase();
                signConfirmName = congvan06.getFiSignConfirmName();
            } else {
                signConfirmTitle += "KT.CỤC TRƯỞNG\n" + congvan06.getFiSignPosition().toUpperCase();
                signConfirmName += "Đã ký\n" + congvan06.getFiSignConfirmName();
            }
        } else {
            signConfirmTitle += "KT.CỤC TRƯỞNG\n";
            signConfirmName += "Đã ký\n" + (congvan06.getFiSignConfirmName() != null ?
                    congvan06.getFiSignConfirmName() : "");
        }
        variables.addTextVariable(new TextVariable("#{fiSignPosition}", signConfirmTitle));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmName}", signConfirmName));

        TableVariable productTableVariable = new TableVariable();
        List<Variable> sttVars = new ArrayList<>();
        List<Variable> fiProductBusinessNameVars = new ArrayList<>();
        List<Variable> fiProductScienceNameVars = new ArrayList<>();
        List<Variable> fiSizeOrTypeVars = new ArrayList<>();
        List<Variable> fiQuantityVars = new ArrayList<>();
        List<Variable> fiCountryOriginVars = new ArrayList<>();
        List<Variable> fiBordergateNameVars = new ArrayList<>();
        List<Variable> fiPackageUnitNameVars = new ArrayList<>();

        String fiCountryOriginList = "";
        if (!congvan06.getFiProductList().isEmpty()) {
            int index = 0;
            for (TbdHanghoa06 hanghoa06: congvan06.getFiProductList()) {
                index++;
                sttVars.add(new TextVariable("#{stt}", Integer.toString(index)));
                fiProductBusinessNameVars.add(new TextVariable("#{fiProductBusinessName}",
                        hanghoa06.getFiProductBusinessName() == null ? "" : hanghoa06.getFiProductBusinessName()));
                fiProductScienceNameVars.add(new TextVariable("#{fiProductScienceName}",
                        hanghoa06.getFiProductScienceName() == null ? "" : hanghoa06.getFiProductScienceName()));
                fiSizeOrTypeVars.add(new TextVariable("#{fiSizeOrType}",
                        hanghoa06.getFiSizeOrType() == null ? "" : hanghoa06.getFiSizeOrType()));
                fiQuantityVars.add(new TextVariable("#{fiQuantity}",
                        hanghoa06.getFiQuantity() == null ? "" :
                                nf.format(hanghoa06.getFiQuantity())));
                fiPackageUnitNameVars.add(new TextVariable("#{fiPackageUnitName}",
                        hanghoa06.getFiPackageUnitName() == null ? "" : hanghoa06.getFiPackageUnitName()));
                fiCountryOriginVars.add(new TextVariable("#{fiOriginCountryName}",
                        hanghoa06.getFiOriginCountryName() == null ? "" : hanghoa06.getFiOriginCountryName()));
                fiBordergateNameVars.add(new TextVariable("#{fiBordergate}",
                        congvan06.getFiBordergateName() == null ? "" : congvan06.getFiBordergateName()));
                fiCountryOriginList += hanghoa06.getFiOriginCountryName() + "; ";
            }
        }
        productTableVariable.addVariable(sttVars);
        productTableVariable.addVariable(fiProductBusinessNameVars);
        productTableVariable.addVariable(fiProductScienceNameVars);
        productTableVariable.addVariable(fiSizeOrTypeVars);
        productTableVariable.addVariable(fiQuantityVars);
        productTableVariable.addVariable(fiPackageUnitNameVars);
        productTableVariable.addVariable(fiCountryOriginVars);
        productTableVariable.addVariable(fiBordergateNameVars);
        variables.addTableVariable(productTableVariable);
        variables.addTextVariable(new TextVariable("#{fiCountryOriginList}", fiCountryOriginList));

        // add list exporter
        String exporterList = "";
        if (!congvan06.getFiExporterCountryList().isEmpty()) {
            for(TbdCtyxk06 ctyxk06 : congvan06.getFiExporterCountryList()) {
                exporterList += ctyxk06.getFiExporterCountryName() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiExporterList}", exporterList));

        // add list processing
        String processingList = "";
        String processingApproveNumnerList = "";
        if (!congvan06.getFiProcessingList().isEmpty()) {
            for (TbdCssx06 cssx06 : congvan06.getFiProcessingList()) {
                processingList += cssx06.getFiProcessingName() + "; ";
                processingApproveNumnerList += cssx06.getFiProcessingApprovalNumber() == null ?
                        "" : cssx06.getFiProcessingApprovalNumber() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiProcessingList}", processingList));
        variables.addTextVariable(new TextVariable("#{fiProcessingApproveNumberList}", processingApproveNumnerList));

        // add list quarantine
        String quarantineList = "";
        if (!congvan06.getFiLocationQuarantineList().isEmpty()) {
            for (TbdDdclkd06 ddclkd06: congvan06.getFiLocationQuarantineList()) {
                quarantineList += ddclkd06.getFiLocationQuarantineName() + " (" +
                        ddclkd06.getFiLocationQuarantineAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiLocationQuarantineList}", quarantineList));

        return variables;
    }

    private TbdHoso06 getHosoByNSWFileCode(String fiNSWFileCode){
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(
                Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_GET_BY_FILTER) + "?nswFileCode=" + fiNSWFileCode);
        if (json == null || json.getSuccess() == false || json.getData() == null) {
//            StringUtils.defaultIfEmpty(getHosoByNSWFileCode(cnkd.getFiHSCode()).getFiImporterName(), "")
            return new TbdHoso06();
        }
        return GsonUtils.getInstance().transform(json.getData(), TbdHoso06.class);
    }
}
