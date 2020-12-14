package com.nsw.mard.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard01Constant;
import com.nsw.mard.p1.model.*;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mard/01")
public class Mard01Api extends BaseApi {
    private static final String CNKD_13A = "13a";
    private static final String CNKD_13B = "13b";
    private static final String CNKD_CN = "cn";
    private static final String CNKD_HKC = "hkc";
    private static final String CNKD_HKP = "hkp";
    private static final String CNKD_M = "m";
    private static final String CV_ALL = "all";
    static final String TAG = "mard01Api";

    @RequestMapping(value = "/danhmuc/quocgia", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getCountry(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.COUNTRY_GET));
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.PORT_GET) + "?countryCode=" + countryCode);
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
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.HOSO_GET_BY_FILTER), filter);
        return json;
    }

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHosoById(@RequestParam("id") String id) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.HOSO_GET_BY_FILTER) + "?id=" + id);
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

    @RequestMapping(value = "/danhmuc/dvxl", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDvxl(
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.DANHMUC_DONVIXULY));
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

    @RequestMapping(value = "/download-tbkdyxck", method = RequestMethod.GET)
    public void download(
            HttpServletResponse response,
            @RequestParam String fiNSWFileCode,
            @RequestParam(name = "mode", required = false) String mode) {
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.THONGBAO_KHONGDAT_YCXK) + "?content=1&fiNSWFileCode=" + fiNSWFileCode);

            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            ThongBaoKhongDatYCXK thongBaoKhongDatYCXK = GsonUtils.getInstance().transform(json.getData(), ThongBaoKhongDatYCXK.class);
            if ("view".equals(mode)) {
                response.setContentType(getMimeType(thongBaoKhongDatYCXK.getFiFileName().split("\\.")[thongBaoKhongDatYCXK.getFiFileName().split("\\.").length - 1]));
                response.setHeader("Content-Disposition", "inline; filename=" + thongBaoKhongDatYCXK.getFiFileName());
            } else {
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment; filename=" + thongBaoKhongDatYCXK.getFiFileName());
            }
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            byte[] data = Base64.decodeBase64(thongBaoKhongDatYCXK.getFiDispatchFile());
            response.getOutputStream().write(data);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    @RequestMapping(value = "/dinhkem/download/{fiIdDinhkem}", method = RequestMethod.GET)
    public void downloadDinhkem(
            HttpServletResponse response,
            @PathVariable("fiIdDinhkem") Long fiIdDinhkem,
            @RequestParam(name = "mode", required = false) String mode) {
        try {
            String url = String.format("%s?id=%s&taxcode=%s", Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.DOWNLOAD_DINHKEM), fiIdDinhkem, "");
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(url);

            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            AttachmentEmbed attachmentEmbed = GsonUtils.getInstance().transform(json.getData(), AttachmentEmbed.class);
            if ("view".equals(mode)) {
                response.setContentType(getMimeType(attachmentEmbed.getFiFileName().split("\\.")[attachmentEmbed.getFiFileName().split("\\.").length - 1]));
                response.setHeader("Content-Disposition", "inline; filename=" + attachmentEmbed.getFiFileName());
            } else {
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment; filename=" + attachmentEmbed.getFiFileName());
            }
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            byte[] data = Base64.decodeBase64(attachmentEmbed.getFiContent());
            response.getOutputStream().write(data);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    @RequestMapping(value = "/attachment/fee/{fiIdDinhkem}", method = RequestMethod.GET)
    public void downloadFeeAttachment(
            HttpServletResponse response,
            @PathVariable("fiIdDinhkem") Long fiIdDinhkem) {
        try {
            String url = String.format("%s?id=%s&taxcode=%s", Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.DOWNLOAD_DINHKEM_FEE), fiIdDinhkem, "");
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(url);

            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            AttachmentEmbed attachmentEmbed = GsonUtils.getInstance().transform(json.getData(), AttachmentEmbed.class);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + attachmentEmbed.getFiFileName());
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            byte[] data = Base64.decodeBase64(attachmentEmbed.getFiContent());
            response.getOutputStream().write(data);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    @RequestMapping(value = "/danhmuc/trangthai", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDanhmucTrangthai(
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.DANHMUC_TRANGTHAI));
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

    @RequestMapping(value = "/giayphep/thongbao-khongdat", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getTbKdYcxk(
            @RequestParam String fiNSWFileCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.THONGBAO_KHONGDAT_YCXK) + "?fiNSWFileCode=" + fiNSWFileCode);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.DANHMUC_FILE_DINHKEM) + "?systemId=" + systemId);
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
    ResponseJson getProvinces(
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.PROVINCE_GET));
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

    @RequestMapping(value = "/unit", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getUOMs(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.UOMS_GET));
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

    @RequestMapping(value = "/apphi", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getTBAP(
            @RequestParam(name = "fiNSWFileCode") String fiNSWFileCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.HOSO_APPHI) + "?fiNSWFileCode=" + fiNSWFileCode);
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
    ResponseJson getLichsu(
            @RequestParam(name = "fiHSCode") String fiNSWFileCode,
            @RequestParam(required = false) Integer p,
            @RequestParam(required = false) Integer s
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.HOSO_LICHSU) + "?fiNSWFileCode=" + fiNSWFileCode + "&p=" + p + "&s=" + s);
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
    ResponseJson getGiayphep(
            @RequestParam(name = "fiNSWFileCode") String fiNSWFileCode,
            @RequestParam(name = "type") String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard01Constant.getInstance().getApiUrl(environment, Mard01Constant.API.HOSO_GIAYPHEP) + "?code=" + fiNSWFileCode + "&type=" + type);
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
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/01/mard_01_dv.xlsx");
                    fileName = "mard_01_dv.xlsx";
                    break;
                case "animal_product":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/01/mard_01_spdv.xlsx");
                    fileName = "mard_01_spdv.xlsx";
                    break;
                case "test":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/01/mard_01_test.xlsx");
                    fileName = "mard_01_test.xlsx";
                    break;
                case "vaccine":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/01/mard_01_vaccine.xlsx");
                    fileName = "mard_01_vaccine.xlsx";
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

    @RequestMapping(value = "/hoso/download/{idHoso}", method = RequestMethod.GET)
    public void downloadHoso(
            @PathVariable String idHoso,
            HttpServletResponse response,
            HttpServletRequest request) {
        try {
            ResponseJson hosoJson = getHosoById(idHoso);
            if (hosoJson == null || hosoJson.getSuccess() == false || hosoJson.getData() == null) {
                return;
            }
            Tbdhoso01 hoso = GsonUtils.getInstance().transform(hosoJson.getData(), Tbdhoso01.class);
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (hoso == null) {
                return;
            }
            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
//            String tempFoleder = "/Users/hung/blameo/LOGS";
            String fileName = new Date().getTime() + "-mard-01-hoso.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;
            if (hoso.getFiObjectType() == 1){
                templatePath = request.getRealPath("/WEB-INF/downloads/mard/01/mard_01_don_dky_dv.docx");
            } else {
                templatePath = request.getRealPath("/WEB-INF/downloads/mard/01/mard_01_don_dky_spdv.docx");
            }


            variables = genHoso(hoso);
            if (templatePath != null && !templatePath.isEmpty()) {
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
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }


    Variables genHoso(Tbdhoso01 hoso) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();
        String space = ".....";

        variables.addTextVariable(new TextVariable("#{fiNSWFileCode}", hoso.getFiNSWFileCode()));
        variables.addTextVariable(new TextVariable("#{fiKinhGui}", hoso.getFiDepartmentNameVni()));
        variables.addTextVariable(new TextVariable("#{fiChuHang}", hoso.getFiExporterNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDiaChi}", hoso.getFiExporterAdressVni()));
        variables.addTextVariable(new TextVariable("#{fiCMND}", hoso.getFiIdentityNumber() == null ? space : hoso.getFiIdentityNumber()));

        if (hoso.getFiIdentityIssueDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiCapNgay}", sdf.format(hoso.getFiIdentityIssueDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiCapNgay}", space));
        }

        variables.addTextVariable(new TextVariable("#{fiCapTai}", hoso.getFiIdentityIssueAdress() == null ? space : hoso.getFiIdentityIssueAdress()));
        variables.addTextVariable(new TextVariable("#{fiPhone}", hoso.getFiExporterTel() == null ? space : hoso.getFiExporterTel()));
        variables.addTextVariable(new TextVariable("#{fiFax}", hoso.getFiExporterFax() == null ? space : hoso.getFiExporterFax()));
        variables.addTextVariable(new TextVariable("#{fiEmail}", hoso.getFiExporterEmail() == null ? space : hoso.getFiExporterEmail()));


        //--start bind DV

        if (hoso.getFiObjectType() == 1) {


            TableVariable tableDV = new TableVariable();
            List<Variable> columnLoaiDV = new ArrayList<>();
            List<Variable> columnGiong = new ArrayList<>();
            List<Variable> columnTuoi = new ArrayList<>();
            List<Variable> columnDuc = new ArrayList<>();
            List<Variable> columnCai = new ArrayList<>();
            List<Variable> columnMDSD = new ArrayList<>();
            long sumMale = 0;
            long sumFemale = 0;

            if (hoso.getFiAnimalList() != null && !hoso.getFiAnimalList().isEmpty()) {

                for (TbdAnimal01 animal01 : hoso.getFiAnimalList()) {
                    columnLoaiDV.add(new TextVariable("#{fiLoaiDV}", animal01.getFiAnimalTypeVni() == null ? "" : animal01.getFiAnimalTypeVni()));
                    columnGiong.add(new TextVariable("#{fiGiong}", animal01.getFiBreedVni() == null ? "" : animal01.getFiBreedVni()));
                    columnTuoi.add(new TextVariable("#{fiTuoi}", animal01.getFiAge() == null ? "" : animal01.getFiAge()));
                    if (animal01.getFiSex() == 1) {
                        sumMale += animal01.getFiNumber();
                        columnDuc.add(new TextVariable("#{fiDuc}", animal01.getFiNumber() == null ? "" : animal01.getFiNumber().toString()));
                        columnCai.add(new TextVariable("#{fiCai}", ""));
                    } else {
                        sumFemale += animal01.getFiNumber();
                        columnCai.add(new TextVariable("#{fiCai}", animal01.getFiNumber() == null ? "" : animal01.getFiNumber().toString()));
                        columnDuc.add(new TextVariable("#{fiDuc}", ""));
                    }


                    columnMDSD.add(new TextVariable("#{fiMucDichSuDung}", animal01.getFiPurposeVni() == null ? "" : animal01.getFiPurposeVni()));
                }
            }

            variables.addTableVariable(tableDV);

            tableDV.addVariable(columnLoaiDV);
            tableDV.addVariable(columnGiong);
            tableDV.addVariable(columnTuoi);
            tableDV.addVariable(columnDuc);
            tableDV.addVariable(columnCai);
            tableDV.addVariable(columnMDSD);


            variables.addTextVariable(new TextVariable("#{fiTongDuc}", sumMale + ""));
            variables.addTextVariable(new TextVariable("#{fiTongCai}", sumFemale + ""));

            variables.addTextVariable(new TextVariable("#{fiNoiXuatPhat}", hoso.getFiDeparturePlaceOfAnimalVni() == null ? space : hoso.getFiDeparturePlaceOfAnimalVni()));
            variables.addTextVariable(new TextVariable("#{fiTongSo}", hoso.getFiTotalAnimalByCharVni() == null ? space : hoso.getFiTotalAnimalByCharVni()));
            variables.addTextVariable(new TextVariable("#{fiTinhTrangSucKhoe}", hoso.getFiAnimalHealthStatus() == null ? space : hoso.getFiAnimalHealthStatus()));
            variables.addTextVariable(new TextVariable("#{fiAnToanVoiBenh}", hoso.getFiDiseaseSafeName() == null ? space : hoso.getFiDiseaseSafeName()));


            variables.addTextVariable(new TextVariable("#{fiSoQuyetDinh}", hoso.getFiDecisionNo() == null ? space : hoso.getFiDecisionNo()));
            if (hoso.getFiDecisionDate() != null) {
                variables.addTextVariable(new TextVariable("#{fiNgayQuyetDinh}", sdf.format(hoso.getFiDecisionDate())));
            } else {
                variables.addTextVariable(new TextVariable("#{fiNgayQuyetDinh}", space));
            }

            variables.addTextVariable(new TextVariable("#{fiCuaCoQuanQuyetDinh}", hoso.getFiDecisionDepartment() == null ? space : hoso.getFiDecisionDepartment()));

            TableVariable vaccins = new TableVariable();

            List<Variable> contentVaccin = new ArrayList<>();
            TableVariable tests = new TableVariable();

            List<Variable> testCotent = new ArrayList<>();

            if (hoso.getFiTestList() != null) {
                int index = 0;

                for (TbdTest01 test : hoso.getFiTestList()) {
                    index++;
                    String testDate = "";
                    if (test.getFiTestDate() != null) testDate = sdf.format(test.getFiTestDate());
                    testCotent.add(new TextVariable("#{fiTest}", String.format(
                            "%d/ %s Kết quả xét nghiệm số %s ngày %s",
                            index,
                            test.getFiTestName(),
                            test.getFiTestNumber(),
                            testDate)));
                }
            }


            if (hoso.getFiVaccinList() != null) {
                int index = 0;
                for (TbdVaccin01 vaccin01 : hoso.getFiVaccinList()) {
                    index++;
                    String date = "";
                    if (vaccin01.getFiVaccinationAgainstDate() != null)
                        date = sdf.format(vaccin01.getFiVaccinationAgainstDate());
                    contentVaccin.add(new TextVariable("#{fiVaccin}", String.format(
                            "%d/ %s tiêm phòng ngày %s",
                            index,
                            vaccin01.getFiVaccinationAgainstName(),
                            date)));
                }
            }

            vaccins.addVariable(contentVaccin);
            tests.addVariable(testCotent);

            variables.addTableVariable(vaccins);
            variables.addTableVariable(tests);

            //---done DV
        } else {

            //---start SPDV

            TableVariable tableSPDV = new TableVariable();
            List<Variable> clTenHang = new ArrayList<>();
            List<Variable> clCachDongGoi = new ArrayList<>();
            List<Variable> clSoLuong = new ArrayList<>();
            List<Variable> clKhoiLuong = new ArrayList<>();
            List<Variable> clMucDichSD = new ArrayList<>();
            List<Variable> clNgaySX = new ArrayList<>();
            List<Variable> clSoDinhDanh = new ArrayList<>();
            long sumSL = 0;
            double sumKL = 0;

            if (hoso.getFiAnimalProductList() != null && !hoso.getFiAnimalProductList().isEmpty()) {

                for (TbdAnimalProduct01 product : hoso.getFiAnimalProductList()) {
                    sumSL += product.getFiNumber();
                    sumKL += product.getFiNetWeight();
                    clTenHang.add(new TextVariable("#{fiTenHang}", product.getFiProductNameVni() == null ? "" : product.getFiProductNameVni()));
                    clCachDongGoi.add(new TextVariable("#{fiQuyCachDongGoi}", product.getFiPackageTypeVni() == null ? "" : product.getFiPackageTypeVni()));
                    clSoLuong.add(new TextVariable("#{fiSoLuongHH}", product.getFiNumber().toString()));
                    clKhoiLuong.add(new TextVariable("#{fiKhoiLuongHH}", product.getFiNetWeight().toString()));
                    clMucDichSD.add(new TextVariable("#{fiMucDichSDHH}", product.getFiPurposeVni() == null ? "" : product.getFiPurposeVni()));
                    if (product.getFiFromDateProduct() != null && product.getFiToDateProduct() != null) {
                        clNgaySX.add(new TextVariable("#{fiNgaySX}", String.format("%s - %s", sdf.format(product.getFiFromDateProduct()), sdf.format(product.getFiToDateProduct()))));
                    } else {
                        clNgaySX.add(new TextVariable("#{fiNgaySX}", ""));
                    }
                    clSoDinhDanh.add(new TextVariable("#{fiSoDinhDanh}", product.getFiLotIdentificationNo() == null ? "" : product.getFiLotIdentificationNo()));
                }
            }

            variables.addTableVariable(tableSPDV);

            tableSPDV.addVariable(clTenHang);
            tableSPDV.addVariable(clCachDongGoi);
            tableSPDV.addVariable(clSoLuong);
            tableSPDV.addVariable(clKhoiLuong);
            tableSPDV.addVariable(clMucDichSD);
            tableSPDV.addVariable(clNgaySX);
            tableSPDV.addVariable(clSoDinhDanh);

            variables.addTextVariable(new TextVariable("#{fiTongSLHH}", sumSL + ""));
            variables.addTextVariable(new TextVariable("#{fiTongKLHH}", String.format("%.02f", sumKL)));
            variables.addTextVariable(new TextVariable("#{fiTongSoHH}", hoso.getFiTotalAnimalProductByCharVni() == null ? space : hoso.getFiTotalAnimalProductByCharVni()));
            variables.addTextVariable(new TextVariable("#{fiKetQuaXetNghiemHH}", hoso.getFiAnimalProductTestNo() == null ? space : hoso.getFiAnimalProductTestNo()));

            if (hoso.getFiAnimalProductTestDate() != null) {
                variables.addTextVariable(new TextVariable("#{fiNgayXetNghiemHH}", sdf.format(hoso.getFiAnimalProductTestDate())));
            } else {
                variables.addTextVariable(new TextVariable("#{fiNgayXetNghiemHH}", space));
            }


            variables.addTextVariable(new TextVariable("#{fiCoQuanXetNghiemHH}", hoso.getFiAnimalProductTestDepartment() == null ? space : hoso.getFiAnimalProductTestDepartment()));


            variables.addTextVariable(new TextVariable("#{fiTenDiaChiCoSoSX}", hoso.getFiProcessingNameAddressVni() == null ? space : hoso.getFiProcessingNameAddressVni()));
            variables.addTextVariable(new TextVariable("#{fiPhoneCSSX}", hoso.getFiProcessingTel() == null ? space : hoso.getFiProcessingTel()));
            variables.addTextVariable(new TextVariable("#{fiFaxCSSX}", hoso.getFiProcessingFax() == null ? space : hoso.getFiProcessingFax()));

        }
        //--end spdv

        //-- start tt khac
        variables.addTextVariable(new TextVariable("#{fiTenDiaChiToChucNhapKhau}", hoso.getFiImporteNameAddressVni() == null ? space : hoso.getFiImporteNameAddressVni()));
        variables.addTextVariable(new TextVariable("#{fiPhoneCQNK}", hoso.getFiImporterTel() == null ? space : hoso.getFiImporterTel()));
        variables.addTextVariable(new TextVariable("#{fiFaxCQNK}", hoso.getFiImporterFax() == null ? space : hoso.getFiImporterFax()));
        variables.addTextVariable(new TextVariable("#{fiEmailCQNK}", hoso.getFiImporterEmail() == null ? space : hoso.getFiImporterEmail()));
        variables.addTextVariable(new TextVariable("#{fiCuaKhauXuat}", hoso.getFiBordergateNameVni() == null ? space : hoso.getFiBordergateNameVni()));
        if (hoso.getFiExpectingDateFrom() != null) {
            variables.addTextVariable(new TextVariable("#{fiTimeDenCuaKhauXuat}", sdf.format(hoso.getFiExpectingDateFrom())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiTimeDenCuaKhauXuat}", space));
        }

        variables.addTextVariable(new TextVariable("#{fiPhuongTienVanChuyen}", hoso.getFiMeansTransportNameVni() == null ? space : hoso.getFiMeansTransportNameVni()));
        variables.addTextVariable(new TextVariable("#{fiNuocNK}", hoso.getFiImporterCountryNameVni() == null ? space : hoso.getFiImporterCountryNameVni()));
        variables.addTextVariable(new TextVariable("#{fiNuocQuaCanh}", hoso.getFiTransitCountryNameVni() == null ? space : hoso.getFiTransitCountryNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDieuKienBaoQuan}", hoso.getFiConditionsTransport() == null ? space : hoso.getFiConditionsTransport()));
        variables.addTextVariable(new TextVariable("#{fiCacVatDungLQ}", hoso.getFiOtherTransport() == null ? space : hoso.getFiOtherTransport()));
        variables.addTextVariable(new TextVariable("#{fiHoSoGiayLQ}", hoso.getFiTransportAttrachFile() == null ? space : hoso.getFiTransportAttrachFile()));
        variables.addTextVariable(new TextVariable("#{fiDiaDiemCachLyKD}", hoso.getFiLocationQuarantineVni() == null ? space : hoso.getFiLocationQuarantineVni()));
        variables.addTextVariable(new TextVariable("#{fiDangKyTai}", hoso.getFiSignAddress() == null ? space : hoso.getFiSignAddress()));
        variables.addTextVariable(new TextVariable("#{fiNguoiKy}", hoso.getFiSignName() == null ? space : hoso.getFiSignName()));


        variables.addTextVariable(new TextVariable("#{fiDiaDiemKD}", hoso.getFiCheckPlace() == null ? space : hoso.getFiCheckPlace()));
        if (hoso.getFiCheckTime() != null) {
            variables.addTextVariable(new TextVariable("#{fiNgayKD}", sdf.format(hoso.getFiCheckTime())));
            variables.addTextVariable(new TextVariable("#{fiGioKD}", String.format("%02d giờ %02d", hoso.getFiCheckTime().getHours(), hoso.getFiCheckTime().getMinutes())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiNgayKD}", "............." ));
            variables.addTextVariable(new TextVariable("#{fiGioKD}", ".....giờ....."));
        }


        variables.addTextVariable(new TextVariable("#{fiSoDK}", hoso.getFiRegistrationNo() == null ? space : hoso.getFiRegistrationNo()));

        if (hoso.getFiRegistrationDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiNgayTN}", sdf.format(hoso.getFiRegistrationDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiNgayTN}", "........."));
        }

        variables.addTextVariable(new TextVariable("#{fiKiemDichVien}", hoso.getFiCreaterName() == null ? "" : hoso.getFiCreaterName()));


        if (hoso.getFiTimeQuarantine() != null) {
            variables.addTextVariable(new TextVariable("#{fiThoiGianKiemDich}", sdf.format(hoso.getFiTimeQuarantine())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiThoiGianKiemDich}", space));
        }


        variables.addTextVariable(new TextVariable("#{fiNgayDangKy}", String.format("ngày %02d tháng %02d năm %d", hoso.getFiSignDate().getDate(), hoso.getFiSignDate().getMonth() + 1, 1900 + hoso.getFiSignDate().getYear())));

        return variables;
    }


    @RequestMapping(value = "/gcn/download/{gcn}/{fiNSWFileCode}", method = RequestMethod.GET)
    public void downloadGCN(
            @PathVariable String gcn,
            @PathVariable String fiNSWFileCode,
            HttpServletResponse response,
            HttpServletRequest request) {
        try {
            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
//            String tempFoleder = "/Users/hungtran/Documents/Project/NSW/LOGS/";
            String fileName = "";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;
            switch (gcn) {
                case CNKD_13A:
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/01/13a.docx");
                    fileName = new Date().getTime() + "-mard-01-13a.docx";
                    ResponseJson gvcJSON = getGiayphep(fiNSWFileCode, CNKD_13A);

                    if (gvcJSON == null || !gvcJSON.getSuccess() || gvcJSON.getData() == null) {
                        return;
                    }

                    Tbdcnkd13a01 gp = GsonUtils.getInstance().transform(gvcJSON.getData(), Tbdcnkd13a01.class);

                    variables = gen13A(gp);
                    if (templatePath != null && !templatePath.isEmpty()) {
                        tempFile = new File(tempFoleder + fileName);
                        docx = new Docx(templatePath);
                        docx.setVariablePattern(new VariablePattern("#{", "}"));
                        docx.fillTemplate(variables);
                        // save filled .docx file
                        docx.save(tempFile.getPath());
                        fileName = gp.getFiNSWFileCode() + "-13a.docx";
                        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getOutputStream().write(loadFile(tempFile));
                    }

                    break;

                case CNKD_13B:
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/01/13b.docx");
                    fileName = new Date().getTime() + "-mard-01-13b.docx";
                    ResponseJson gvcJSON13b = getGiayphep(fiNSWFileCode, CNKD_13B);

                    if (gvcJSON13b == null || !gvcJSON13b.getSuccess() || gvcJSON13b.getData() == null) {
                        return;
                    }

                    Tbdcnkd13b01 gp13b = GsonUtils.getInstance().transform(gvcJSON13b.getData(), Tbdcnkd13b01.class);

                    variables = gen13B(gp13b);
                    if (templatePath != null && !templatePath.isEmpty()) {
                        tempFile = new File(tempFoleder + fileName);
                        docx = new Docx(templatePath);
                        docx.setVariablePattern(new VariablePattern("#{", "}"));
                        docx.fillTemplate(variables);
                        // save filled .docx file
                        docx.save(tempFile.getPath());
                        fileName = gp13b.getFiNSWFileCode() + "-13b.docx";
                        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getOutputStream().write(loadFile(tempFile));
                    }

                    break;

                case CNKD_M:
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/01/malay.docx");
                    fileName = new Date().getTime() + "-mard-01-13b.docx";
                    ResponseJson gvcJSONMalay = getGiayphep(fiNSWFileCode, CNKD_M);

                    if (gvcJSONMalay == null || !gvcJSONMalay.getSuccess() || gvcJSONMalay.getData() == null) {
                        return;
                    }

                    TbdcnkdM01 gpM = GsonUtils.getInstance().transform(gvcJSONMalay.getData(), TbdcnkdM01.class);

                    variables = genM(gpM);
                    if (templatePath != null && !templatePath.isEmpty()) {
                        tempFile = new File(tempFoleder + fileName);
                        docx = new Docx(templatePath);
                        docx.setVariablePattern(new VariablePattern("#{", "}"));
                        docx.fillTemplate(variables);
                        // save filled .docx file
                        docx.save(tempFile.getPath());
                        fileName = gpM.getFiNSWFileCode() + "-malay.docx";
                        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getOutputStream().write(loadFile(tempFile));
                    }

                    break;

                case CNKD_CN:
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/01/china.docx");
                    fileName = new Date().getTime() + "-mard-01-cn.docx";
                    ResponseJson gpChina = getGiayphep(fiNSWFileCode, CNKD_CN);

                    if (gpChina == null || !gpChina.getSuccess() || gpChina.getData() == null) {
                        return;
                    }

                    TbdcnkdChina01 gpc = GsonUtils.getInstance().transform(gpChina.getData(), TbdcnkdChina01.class);

                    variables = genChina(gpc);
                    if (templatePath != null && !templatePath.isEmpty()) {
                        tempFile = new File(tempFoleder + fileName);
                        docx = new Docx(templatePath);
                        docx.setVariablePattern(new VariablePattern("#{", "}"));
                        docx.fillTemplate(variables);
                        // save filled .docx file
                        docx.save(tempFile.getPath());
                        fileName = gpc.getFiNSWFileCode() + "-tq.docx";
                        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getOutputStream().write(loadFile(tempFile));
                    }

                    break;

                case CNKD_HKC:
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/01/hkc.docx");
                    fileName = new Date().getTime() + "-mard-01-hkp.docx";
                    ResponseJson jsonHKC = getGiayphep(fiNSWFileCode, CNKD_HKC);

                    if (jsonHKC == null || !jsonHKC.getSuccess() || jsonHKC.getData() == null) {
                        return;
                    }

                    TbdcnkdHKC01 hkc = GsonUtils.getInstance().transform(jsonHKC.getData(), TbdcnkdHKC01.class);

                    variables = genHKC(hkc);
                    if (templatePath != null && !templatePath.isEmpty()) {
                        tempFile = new File(tempFoleder + fileName);
                        docx = new Docx(templatePath);
                        docx.setVariablePattern(new VariablePattern("#{", "}"));
                        docx.fillTemplate(variables);
                        // save filled .docx file
                        docx.save(tempFile.getPath());
                        fileName = hkc.getFiNSWFileCode() + "-hkc.docx";
                        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getOutputStream().write(loadFile(tempFile));
                    }

                    break;
                case CNKD_HKP:
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/01/hkp.docx");
                    fileName = new Date().getTime() + "-mard-01-hkp.docx";
                    ResponseJson jsonHKP = getGiayphep(fiNSWFileCode, CNKD_HKP);

                    if (jsonHKP == null || !jsonHKP.getSuccess() || jsonHKP.getData() == null) {
                        return;
                    }

                    TbdcnkdHKP01 hkp = GsonUtils.getInstance().transform(jsonHKP.getData(), TbdcnkdHKP01.class);

                    variables = genHKP(hkp);
                    if (templatePath != null && !templatePath.isEmpty()) {
                        tempFile = new File(tempFoleder + fileName);
                        docx = new Docx(templatePath);
                        docx.setVariablePattern(new VariablePattern("#{", "}"));
                        docx.fillTemplate(variables);
                        // save filled .docx file
                        docx.save(tempFile.getPath());
                        fileName = hkp.getFiNSWFileCode() + "-hkp.docx";
                        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getOutputStream().write(loadFile(tempFile));
                    }

                    break;
            }




        } catch (Exception ex) {
            ex.printStackTrace();
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }


    Variables gen13A(Tbdcnkd13a01 gp){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();
        String space = ".....";

        variables.addTextVariable(new TextVariable("#{fiHealthCertificateForm}", gp.getFiHealthCertificateForm() == null ? "13A" : gp.getFiHealthCertificateForm()));

        variables.addTextVariable(new TextVariable("#{fiDepartmentParentNameVni}", gp.getFiDepartmentParentNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDepartmentParentName}", gp.getFiDepartmentParentName()));

        variables.addTextVariable(new TextVariable("#{fiDepartmentChildNameVni}", gp.getFiDepartmentChildNameVni() == null ? "" : gp.getFiDepartmentChildNameVni()));
        variables.addTextVariable(new TextVariable("#{DepartmentChildName}", gp.getFiDepartmentChildName() == null ? "" : gp.getFiDepartmentChildName()));

        variables.addTextVariable(new TextVariable("#{fiHealthCertificateNo}", gp.getFiHealthCertificateNo() == null ? "" : gp.getFiHealthCertificateNo()));
        variables.addTextVariable(new TextVariable("#{fiExporterNameVni}", gp.getFiExporterNameVni() == null ? "" : gp.getFiExporterNameVni()));
        variables.addTextVariable(new TextVariable("#{ExporterAdressVni}", gp.getFiExporterAdressVni() == null ? "" : gp.getFiExporterAdressVni()));
        variables.addTextVariable(new TextVariable("#{fiExporterName}", gp.getFiExporterName() == null ? "" : gp.getFiExporterName()));
        variables.addTextVariable(new TextVariable("#{ExporterAdress}", gp.getFiExporterAdress() == null ? "" : gp.getFiExporterAdress()));
        variables.addTextVariable(new TextVariable("#{fiExporterTel}", gp.getFiExporterTel() == null ? "" : gp.getFiExporterTel()));
        variables.addTextVariable(new TextVariable("#{fiExporterFax}", gp.getFiExporterFax() == null ? "" : gp.getFiExporterFax()));
        variables.addTextVariable(new TextVariable("#{fiExporterEmail}", gp.getFiExporterEmail() == null ? space : gp.getFiExporterEmail()));
        variables.addTextVariable(new TextVariable("#{fiDeparturePlaceVni}", gp.getFiDeparturePlaceVni() == null ? space : gp.getFiDeparturePlaceVni()));
        variables.addTextVariable(new TextVariable("#{fiDeparturePlace}", gp.getFiDeparturePlace() == null ? space : gp.getFiDeparturePlace()));
        variables.addTextVariable(new TextVariable("#{fiTotalVni}", gp.getFiTotalVni() == null ? space : gp.getFiTotalVni()));
        variables.addTextVariable(new TextVariable("#{fiTotal}", gp.getFiTotal() == null ? space : gp.getFiTotal()));
        variables.addTextVariable(new TextVariable("#{fiDestinationCountryNameVni}", gp.getFiDestinationCountryNameVni() == null ? space : gp.getFiDestinationCountryNameVni()));
        variables.addTextVariable(new TextVariable("#{fiMeansTransportVni}", gp.getFiMeansTransportVni() == null ? space : gp.getFiMeansTransportVni()));
        variables.addTextVariable(new TextVariable("#{fiDestinationCountryName}", gp.getFiDestinationCountryName() == null ? space : gp.getFiDestinationCountryName()));
        variables.addTextVariable(new TextVariable("#{fiMeansTransport}", gp.getFiMeansTransport() == null ? space : gp.getFiMeansTransport()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeNameAddressVni}", gp.getFiConsigneeNameAddressVni() == null ? space : gp.getFiConsigneeNameAddressVni()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeNameAddress}", gp.getFiConsigneeNameAddress() == null ? space : gp.getFiConsigneeNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiHealthCertificate}", gp.getFiHealthCertificate() == null ? space : gp.getFiHealthCertificate()));

        if (gp.getFiHealthCertificateEndDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", sdf.format(gp.getFiHealthCertificateEndDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", space));
        }


        variables.addTextVariable(new TextVariable("#{fiExpertName}", gp.getFiExpertName() == null ? space : gp.getFiExpertName()));
        variables.addTextVariable(new TextVariable("#{fiSignResultPlaceVni}", gp.getFiSignResultPlaceVni() == null ? space : gp.getFiSignResultPlaceVni()));

        if (gp.getFiSignResultDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", sdf.format(gp.getFiSignResultDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", space));
        }

        variables.addTextVariable(new TextVariable("#{fiSignResultPlace}", gp.getFiSignResultPlace() == null ? space : gp.getFiSignResultPlace()));
        variables.addTextVariable(new TextVariable("#{fiSignResultName}", gp.getFiSignResultName() == null ? space : gp.getFiSignResultName()));


        TableVariable tableVariable = new TableVariable();
        List<Variable> typeAnimalVariable = new ArrayList<>();
        List<Variable> officialMarkVariable = new ArrayList<>();
        List<Variable> breedVariable = new ArrayList<>();
        List<Variable> sexVariable = new ArrayList<>();
        List<Variable> ageVariable = new ArrayList<>();

        if (gp.getFiAnimalList() != null){
            for (Tbddongvat13a01 tbddongvat13a01: gp.getFiAnimalList()) {
                typeAnimalVariable.add(new TextVariable("#{fiAnimalTypeVni}", tbddongvat13a01.getFiAnimalTypeVni() == null ? "" : tbddongvat13a01.getFiAnimalTypeVni() + "/" + tbddongvat13a01.getFiAnimalType()));
                officialMarkVariable.add(new TextVariable("#{fiOfficialMark}", tbddongvat13a01.getFiOfficialMark() == null ? "" : tbddongvat13a01.getFiOfficialMark()));
                breedVariable.add(new TextVariable("#{fiBreedVni}", tbddongvat13a01.getFiBreedVni() == null ? "" : tbddongvat13a01.getFiBreedVni() + "/" + tbddongvat13a01.getFiBreed()));
                sexVariable.add(new TextVariable("#{fiSex}", tbddongvat13a01.getFiSex() == 1 ? "Đực/Male" : "Cái/Female" ));
                ageVariable.add(new TextVariable("#{fiAge}", tbddongvat13a01.getFiAge() == null ? "" : tbddongvat13a01.getFiAge()));
            }
        }


        tableVariable.addVariable(typeAnimalVariable);
        tableVariable.addVariable(officialMarkVariable);
        tableVariable.addVariable(breedVariable);
        tableVariable.addVariable(sexVariable);
        tableVariable.addVariable(ageVariable);

        variables.addTableVariable(tableVariable);


        return variables;
    }

    Variables gen13B(Tbdcnkd13b01 gp){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();
        String space = ".....";

        variables.addTextVariable(new TextVariable("#{fiHealthCertificateForm}", gp.getFiHealthCertificateForm() == null ? "13B" : gp.getFiHealthCertificateForm()));

        variables.addTextVariable(new TextVariable("#{fiDepartmentParentNameVni}", gp.getFiDepartmentParentNameVni() == null ? "CỤC THÚ Y" : gp.getFiDepartmentParentNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDepartmentParentName}", gp.getFiDepartmentParentName() == null ? "DEPARTMENT OF ANIMAL HEALTH" : gp.getFiDepartmentParentName()));

        variables.addTextVariable(new TextVariable("#{fiDepartmentChildNameVni}", gp.getFiDepartmentChildNameVni() == null ? "" : gp.getFiDepartmentChildNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDepartmentChildName}", gp.getFiDepartmentChildName() == null ? "" : gp.getFiDepartmentChildName()));

        variables.addTextVariable(new TextVariable("#{fiHealthCertificateNo}", gp.getFiHealthCertificateNo() == null ? "" : gp.getFiHealthCertificateNo()));
        variables.addTextVariable(new TextVariable("#{fiExporterNameVni}", gp.getFiExporterNameVni() == null ? "" : gp.getFiExporterNameVni()));
        variables.addTextVariable(new TextVariable("#{fiExporterAdressVni}", gp.getFiExporterAdressVni() == null ? "" : gp.getFiExporterAdressVni()));
        variables.addTextVariable(new TextVariable("#{fiExporterName}", gp.getFiExporterName() == null ? "" : gp.getFiExporterName()));
        variables.addTextVariable(new TextVariable("#{fiExporterAdress}", gp.getFiExporterAdress() == null ? "" : gp.getFiExporterAdress()));
        variables.addTextVariable(new TextVariable("#{fiExporterTel}", gp.getFiExporterTel() == null ? "" : gp.getFiExporterTel()));
        variables.addTextVariable(new TextVariable("#{fiExporterFax}", gp.getFiExporterFax() == null ? "" : gp.getFiExporterFax()));
        variables.addTextVariable(new TextVariable("#{fiExporterEmail}", gp.getFiExporterEmail() == null ? space : gp.getFiExporterEmail()));

        variables.addTextVariable(new TextVariable("#{fiMeansTransportVni}", gp.getFiMeansTransportVni() == null ? space : gp.getFiMeansTransportVni()));
        variables.addTextVariable(new TextVariable("#{fiMeansTransport}", gp.getFiMeansTransport() == null ? space : gp.getFiMeansTransport()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeNameAddressVni}", gp.getFiConsigneeNameAddressVni() == null ? space : gp.getFiConsigneeNameAddressVni()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeNameAddress}", gp.getFiConsigneeNameAddress() == null ? space : gp.getFiConsigneeNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiHealthCertificate}", gp.getFiHealthCertificate() == null ? space : gp.getFiHealthCertificate()));

        if (gp.getFiHealthCertificateEndDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", sdf.format(gp.getFiHealthCertificateEndDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", space));
        }


        variables.addTextVariable(new TextVariable("#{fiExpertName}", gp.getFiExpertName() == null ? space : gp.getFiExpertName()));
        variables.addTextVariable(new TextVariable("#{fiSignResultPlaceVni}", gp.getFiSignResultPlaceVni() == null ? space : gp.getFiSignResultPlaceVni()));

        if (gp.getFiSignResultDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", sdf.format(gp.getFiSignResultDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", space));
        }

        variables.addTextVariable(new TextVariable("#{fiSignResultPlace}", gp.getFiSignResultPlace() == null ? space : gp.getFiSignResultPlace()));
        variables.addTextVariable(new TextVariable("#{fiSignResultName}", gp.getFiSignResultName() == null ? space : gp.getFiSignResultName()));

        String productNameVni = "";
        String productName = "";
        String packageTypeVni = "";
        String packageType = "";
        String numberVni = "";
        String number = "";
        String netWeightVni = "";
        String netWeight = "";
        double totalNW = 0;

        if (gp.getFiAnimalProductList() != null){
            for (Tbdspdv13b01 spdv: gp.getFiAnimalProductList()) {
                productNameVni += String.format("%s, ", spdv.getFiProductNameVni());
                productName += String.format("%s, ", spdv.getFiProductName());
                packageTypeVni += String.format("%s, ", spdv.getFiPackageTypeVni());
                packageType += String.format("%s, ", spdv.getFiPackageType());
                numberVni += String.format("%d (%s), ", spdv.getFiNumber(), spdv.getFiUnitVni());
                number += String.format("%d (%s), ", spdv.getFiNumber(), spdv.getFiUnit());
                netWeightVni += String.format("%.02f(kg), ", spdv.getFiNetWeight());
                netWeight += String.format("%.02f(kg), ", spdv.getFiNetWeight());
                totalNW += spdv.getFiNetWeight();
            }
            if (gp.getFiAnimalProductList().size() > 0) {
                productNameVni = productNameVni.substring(0, productNameVni.length() - 2);
                productName = productName.substring(0, productName.length() - 2);
                packageTypeVni = packageTypeVni.substring(0, packageTypeVni.length() - 2);
                packageType = packageType.substring(0, packageType.length() - 2);
                numberVni = numberVni.substring(0, numberVni.length() - 2);
                number = number.substring(0, number.length() - 2);
                netWeightVni = netWeightVni.substring(0, netWeightVni.length() - 2);
                netWeight = netWeight.substring(0, netWeight.length() - 2);
            }
        }

        variables.addTextVariable(new TextVariable("#{fiProductNameVni}", productNameVni));
        variables.addTextVariable(new TextVariable("#{fiProductName}", productName));
        variables.addTextVariable(new TextVariable("#{fiPackageTypeVni}", packageTypeVni));
        variables.addTextVariable(new TextVariable("#{fiPackageType}", packageType));
        variables.addTextVariable(new TextVariable("#{fiNumberVni}", numberVni));
        variables.addTextVariable(new TextVariable("#{fiNumber}", number));
        variables.addTextVariable(new TextVariable("#{fiNetWeightVni}", String.format("%.02f(kg)", totalNW)));
        variables.addTextVariable(new TextVariable("#{fiNetWeight}", String.format("%.02f(kg)", totalNW)));


        variables.addTextVariable(new TextVariable("#{fiProcessingNameAddressVni}", gp.getFiProcessingNameAddressVni() == null ? space : gp.getFiProcessingNameAddressVni()));
        variables.addTextVariable(new TextVariable("#{fiProcessingNameAddress}", gp.getFiProcessingNameAddress() == null ? space : gp.getFiProcessingNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiProcessingTel}", gp.getFiProcessingTel() == null ? space : gp.getFiProcessingTel()));
        variables.addTextVariable(new TextVariable("#{fiProcessingFax}", gp.getFiProcessingFax() == null ? space : gp.getFiProcessingFax()));


        return variables;
    }

    Variables genM(TbdcnkdM01 gp){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();
        String space = ".....";


        variables.addTextVariable(new TextVariable("#{fiDepartmentNameVni}", gp.getFiDepartmentNameVni() == null ? "" : gp.getFiDepartmentNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDepartmentName}", gp.getFiDepartmentName() == null ? "" : gp.getFiDepartmentName()));

        variables.addTextVariable(new TextVariable("#{fiHealthCertificateNoVni}", gp.getFiHealthCertificateNoVni() == null ? "" : gp.getFiHealthCertificateNoVni()));
        variables.addTextVariable(new TextVariable("#{fiConsignerName}", gp.getFiConsignerName() == null ? "" : gp.getFiConsignerName()));
        variables.addTextVariable(new TextVariable("#{fiConsignerAdress}", gp.getFiConsignerAdress() == null ? "" : gp.getFiConsignerAdress()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeNameAddress}", gp.getFiConsigneeNameAddress() == null ? "" : gp.getFiConsigneeNameAddress()));

        variables.addTextVariable(new TextVariable("#{fiSlaughterHouseNameAddress}", gp.getFiSlaughterHouseNameAddress() == null ? "" : gp.getFiSlaughterHouseNameAddress()));
        if (gp.getFiSignResultDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiSignResultDateVni}", "Ngày " + gp.getFiSignResultDate().getDate() + " tháng " + (gp.getFiSignResultDate().getMonth() + 1)
             + " năm " + (1900 + gp.getFiSignResultDate().getYear()) ));
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", sdf.format(gp.getFiSignResultDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignResultDateVni}", "Ngày     tháng      "));
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", ""));
        }

        if (gp.getFiHealthCertificateEndDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", sdf.format(gp.getFiHealthCertificateEndDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", ""));
        }


        variables.addTextVariable(new TextVariable("#{fiSignResultName}", gp.getFiSignResultName() == null ? "" : gp.getFiSignResultName()));


        if (gp.getFiHealthCertificateEndDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", sdf.format(gp.getFiHealthCertificateEndDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", space));
        }


        String productNameVni = "";
        String productName = "";
        String packageTypeVni = "";
        String packageType = "";
        double totalNetWeight = 0;

        if (gp.getFiAnimalProductList() != null){
            for (TbdAnimailProductM01 spdv: gp.getFiAnimalProductList()) {
                productNameVni += String.format("%s, ", spdv.getFiCommodity());
                productName += String.format("%d(%s), ", spdv.getFiQuantity(), spdv.getFiUnit());
                packageTypeVni += String.format("%s, ", spdv.getFiMarkNo());
                totalNetWeight += spdv.getFiNetWeight();
                packageType = spdv.getFiNetWeightUnitName();
            }
            if (gp.getFiAnimalProductList().size() > 0) {
                productNameVni = productNameVni.substring(0, productNameVni.length() - 2);
                productName = productName.substring(0, productName.length() - 2);
                packageTypeVni = packageTypeVni.substring(0, packageTypeVni.length() - 2);
            }
        }

        variables.addTextVariable(new TextVariable("#{fiCommodity}", productNameVni));
        variables.addTextVariable(new TextVariable("#{fiQuantity}", productName));
        variables.addTextVariable(new TextVariable("#{fiMarkNo}", packageTypeVni));
        variables.addTextVariable(new TextVariable("#{fiNetWeight}", String.format("%1$,.2f (kg)", totalNetWeight)));


        return variables;
    }

    Variables genChina(TbdcnkdChina01 gp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{fiDepartmentNameVni}", gp.getFiDepartmentNameVni() == null ? "" : gp.getFiDepartmentNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDepartmentName}", gp.getFiDepartmentName() == null ? "" : gp.getFiDepartmentName()));
        variables.addTextVariable(new TextVariable("#{fiHealthCertificateNoVni}", gp.getFiHealthCertificateNoVni() == null ? "" : gp.getFiHealthCertificateNoVni()));
        variables.addTextVariable(new TextVariable("#{fiAnimalQuarantineOrganizationName}", gp.getFiAnimalQuarantineOrganizationName() == null ? "" : gp.getFiAnimalQuarantineOrganizationName()));
        variables.addTextVariable(new TextVariable("#{fiExportName}", gp.getFiExportName() == null ? "" : gp.getFiExportName()));
        variables.addTextVariable(new TextVariable("#{fiExportAdress}", gp.getFiExportAdress() == null ? "" : gp.getFiExportAdress()));
        variables.addTextVariable(new TextVariable("#{fiExporterEmail}", gp.getFiExporterEmail() == null ? "" : gp.getFiExporterEmail()));
        variables.addTextVariable(new TextVariable("#{fiExporterTel}", gp.getFiExporterTel() == null ? "" : gp.getFiExporterTel()));
        variables.addTextVariable(new TextVariable("#{fiExporterFax}", gp.getFiExporterFax() == null ? "" : gp.getFiExporterFax()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeNameAddress}", gp.getFiConsigneeNameAddress() == null ? "" : gp.getFiConsigneeNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeTel}", gp.getFiConsigneeTel() == null ? "" : gp.getFiConsigneeTel()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeFax}", gp.getFiConsigneeFax() == null ? "" : gp.getFiConsigneeFax()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeEmail}", gp.getFiConsigneeEmail() == null ? "" : gp.getFiConsigneeEmail()));
        variables.addTextVariable(new TextVariable("#{fiProcessingNameAddress}", gp.getFiProcessingNameAddress() == null ? "" : gp.getFiProcessingNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiProcessingNumberRegistration}", gp.getFiProcessingNumberRegistration() == null ? "" : gp.getFiProcessingNumberRegistration()));

        String txt1 = "";
        String txt2 = "";
        String txt3 = "";
        String txt4 = "";
        String txt5 = "";
        String txt6 = "";

        double totalNetWeight = 0;

        if (gp.getFiAnimalProductList() != null){
            for (TbdAnimailProductCN01 spdv: gp.getFiAnimalProductList()) {
                txt1 += String.format("%s, ", spdv.getFiTypeProduct());
                txt2 += String.format("%s, ", spdv.getFiBactchNumber());
                txt3 += String.format("%s, ", spdv.getFiPackageType());
                txt4 += String.format("%d(%s), ", spdv.getFiNumberPackage(), spdv.getFiUnit());
                totalNetWeight += spdv.getFiNetWeight();
//                txt5 += String.format("%.02f(%s), ", spdv.getFiNetWeight(), spdv.getFiNetWeightUnitName());
                txt5 = spdv.getFiNetWeightUnitName();
                txt6 += String.format("%s, ", spdv.getFiHSCode());
            }
            if (gp.getFiAnimalProductList().size() > 0) {
                txt1 = txt1.substring(0, txt1.length() - 2);
                txt2 = txt2.substring(0, txt2.length() - 2);
                txt3 = txt3.substring(0, txt3.length() - 2);
                txt4 = txt4.substring(0, txt4.length() - 2);
//                txt5 = txt5.substring(0, txt5.length() - 2);
                txt6 = txt6.substring(0, txt6.length() - 2);
            }
        }

        variables.addTextVariable(new TextVariable("#{fiTypeProduct}", txt1));
        variables.addTextVariable(new TextVariable("#{fiBactchNumber}", txt2));
        variables.addTextVariable(new TextVariable("#{fiPackageType}", txt3));
        variables.addTextVariable(new TextVariable("#{fiNumberPackage}", txt4));
        variables.addTextVariable(new TextVariable("#{fiNetWeight}", String.format("%1$,.2f (kg)", totalNetWeight)));
        variables.addTextVariable(new TextVariable("#{fiHSCode}", txt6));


        variables.addTextVariable(new TextVariable("#{fiProcessingNameAddress}", gp.getFiProcessingNameAddress() == null ? "" : gp.getFiProcessingNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiProcessingNumberRegistration}", gp.getFiProcessingNumberRegistration() == null ? "" : gp.getFiProcessingNumberRegistration()));
        variables.addTextVariable(new TextVariable("#{fiProcessingTel}", gp.getFiProcessingTel() == null ? "" : gp.getFiProcessingTel()));
        variables.addTextVariable(new TextVariable("#{fiProcessingFax}", gp.getFiProcessingFax() == null ? "" : gp.getFiProcessingFax()));
        if (gp.getFiDateProduct() != null) {
            variables.addTextVariable(new TextVariable("#{fiDateProduct}", sdf.format(gp.getFiDateProduct())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiDateProduct}", ""));
        }

        if (gp.getFiDateExpiry() != null) {
            variables.addTextVariable(new TextVariable("#{fiDateExpiry}", sdf.format(gp.getFiDateExpiry())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiDateExpiry}", ""));
        }

        if (gp.getFiDateDeparture() != null) {
            variables.addTextVariable(new TextVariable("#{fiDateDeparture}", sdf.format(gp.getFiDateDeparture())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiDateDeparture}", ""));
        }

        if (gp.getFiHealthCertificateEndDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", sdf.format(gp.getFiHealthCertificateEndDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", ""));
        }

        if (gp.getFiSignResultDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", sdf.format(gp.getFiSignResultDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", ""));
        }


        variables.addTextVariable(new TextVariable("#{fiPortShipmentName}", gp.getFiPortShipmentName() == null ? "" : gp.getFiPortShipmentName()));
        variables.addTextVariable(new TextVariable("#{fiEntryPointName}", gp.getFiEntryPointName() == null ? "" : gp.getFiEntryPointName()));
        variables.addTextVariable(new TextVariable("#{fiContaine}", gp.getFiContaine() == null ? "" : gp.getFiContaine()));
        variables.addTextVariable(new TextVariable("#{fiExpertName}", gp.getFiExpertName() == null ? "" : gp.getFiExpertName()));
        variables.addTextVariable(new TextVariable("#{fiSignResultPlace}", gp.getFiSignResultPlace() == null ? "" : gp.getFiSignResultPlace()));
        variables.addTextVariable(new TextVariable("#{fiSignResultName}", gp.getFiSignResultName() == null ? "" : gp.getFiSignResultName()));

        return variables;
    }

    Variables genHKC(TbdcnkdHKC01 gp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{fiHealthCertificateNo}", gp.getFiHealthCertificateNo() == null ? "" : gp.getFiHealthCertificateNo()));
        variables.addTextVariable(new TextVariable("#{fiDepartmentNameVni}", gp.getFiDepartmentNameVni() == null ? "" : gp.getFiDepartmentNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDepartmentName}", gp.getFiDepartmentName() == null ? "" : gp.getFiDepartmentName()));
        variables.addTextVariable(new TextVariable("#{fiExportName}", gp.getFiExportName() == null ? "" : gp.getFiExportName()));
        variables.addTextVariable(new TextVariable("#{fiExportAdress}", gp.getFiExportAdress() == null ? "" : gp.getFiExportAdress()));
        variables.addTextVariable(new TextVariable("#{fiExporterTel}", gp.getFiExporterTel() == null ? "" : gp.getFiExporterTel()));
        variables.addTextVariable(new TextVariable("#{fiExporterFax}", gp.getFiExporterFax() == null ? "" : gp.getFiExporterFax()));
        variables.addTextVariable(new TextVariable("#{fiExporterEmail}", gp.getFiExporterEmail() == null ? "" : gp.getFiExporterEmail()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeNameAddress}", gp.getFiConsigneeNameAddress() == null ? "" : gp.getFiConsigneeNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeTel}", gp.getFiConsigneeTel() == null ? "" : gp.getFiConsigneeTel()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeFax}", gp.getFiConsigneeFax() == null ? "" : gp.getFiConsigneeFax()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeEmail}", gp.getFiConsigneeEmail() == null ? "" : gp.getFiConsigneeEmail()));


        String txt1 = "";
        String txt2 = "";
        String txt3 = "";
        String txt4 = "";
        double totalNetWeight = 0;

        if (gp.getFiAnimalProductList() != null){
            for (TbdAnimailProductHKC01 spdv: gp.getFiAnimalProductList()) {
                txt1 += String.format("%s, ", spdv.getFiTypeProduct());
                txt2 += String.format("%s, ", spdv.getFiPackageType());
                txt3 += String.format("%d(%s), ", spdv.getFiNumberPackage(), spdv.getFiUnit());

                totalNetWeight += spdv.getFiNetWeight();
                txt4 = spdv.getFiNetWeightUnitName();
            }
            if (gp.getFiAnimalProductList().size() > 0) {
                txt1 = txt1.substring(0, txt1.length() - 2);
                txt2 = txt2.substring(0, txt2.length() - 2);
                txt3 = txt3.substring(0, txt3.length() - 2);
            }
        }

        variables.addTextVariable(new TextVariable("#{fiTypeProduct}", txt1));
        variables.addTextVariable(new TextVariable("#{fiPackageType}", txt2));
        variables.addTextVariable(new TextVariable("#{fiNumberPackage}", txt3));
        variables.addTextVariable(new TextVariable("#{fiNetWeight}", String.format("%1$,.2f (kg)", totalNetWeight)));


        variables.addTextVariable(new TextVariable("#{fiSlaughterHouseNameAddress}", gp.getFiSlaughterHouseNameAddress() == null ? "" : gp.getFiSlaughterHouseNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiSlaughterHouseTel}", gp.getFiSlaughterHouseTel() == null ? "" : gp.getFiSlaughterHouseTel()));
        variables.addTextVariable(new TextVariable("#{fiSlaughterHouseFax}", gp.getFiSlaughterHouseFax() == null ? "" : gp.getFiSlaughterHouseFax()));

        variables.addTextVariable(new TextVariable("#{fiProcessingNameAddress}", gp.getFiProcessingNameAddress() == null ? "" : gp.getFiProcessingNameAddress()));
        variables.addTextVariable(new TextVariable("#{fiProcessingTel}", gp.getFiProcessingTel() == null ? "" : gp.getFiProcessingTel()));
        variables.addTextVariable(new TextVariable("#{fiProcessingFax}", gp.getFiProcessingFax() == null ? "" : gp.getFiProcessingFax()));


        if (gp.getFiDateSlaughter() != null) {
            variables.addTextVariable(new TextVariable("#{fiDateSlaughter}", sdf.format(gp.getFiDateSlaughter())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiDateSlaughter}", ""));
        }
        if (gp.getFiDateHeatProcessing() != null) {
            variables.addTextVariable(new TextVariable("#{fiDateHeatProcessing}", sdf.format(gp.getFiDateHeatProcessing())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiDateHeatProcessing}", ""));
        }

        if (gp.getFiDateExpiry() != null) {
            variables.addTextVariable(new TextVariable("#{fiDateExpiry}", sdf.format(gp.getFiDateExpiry())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiDateExpiry}", ""));
        }

        if (gp.getFiSignResultDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", sdf.format(gp.getFiSignResultDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", ""));
        }

        if (gp.getFiDateDeparture() != null) {
            variables.addTextVariable(new TextVariable("#{fiDateDeparture}", sdf.format(gp.getFiDateDeparture())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiDateDeparture}", ""));
        }

        if (gp.getFiHealthCertificateEndDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", sdf.format(gp.getFiHealthCertificateEndDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", ""));
        }

        if (gp.getFiDateSProcessing() != null) {
            variables.addTextVariable(new TextVariable("#{fiDateSProcessing}", sdf.format(gp.getFiDateSProcessing())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiDateSProcessing}", ""));
        }

        variables.addTextVariable(new TextVariable("#{fiPortShipmentName}", gp.getFiPortShipmentName() == null ? "" : gp.getFiPortShipmentName()));
        variables.addTextVariable(new TextVariable("#{fiMeansTransportName}", gp.getFiMeansTransportName() == null ? "" : gp.getFiMeansTransportName()));
        variables.addTextVariable(new TextVariable("#{fiEntryPointName}", gp.getFiEntryPointName() == null ? "" : gp.getFiEntryPointName()));
        variables.addTextVariable(new TextVariable("#{fiContaine}", gp.getFiContaine() == null ? "" : gp.getFiContaine()));

        variables.addTextVariable(new TextVariable("#{fiExpertName}", gp.getFiExpertName() == null ? "" : gp.getFiExpertName()));
        variables.addTextVariable(new TextVariable("#{fiSignResultPlace}", gp.getFiSignResultPlace() == null ? "" : gp.getFiSignResultPlace()));
        variables.addTextVariable(new TextVariable("#{fiSignResultName}", gp.getFiSignResultName() == null ? "" : gp.getFiSignResultName()));

        return variables;
    }

    Variables genHKP(TbdcnkdHKP01 gp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();
        variables.addTextVariable(new TextVariable("#{fiDepartmentNameVni}", gp.getFiDepartmentNameVni() == null ? "" : gp.getFiDepartmentNameVni()));
        variables.addTextVariable(new TextVariable("#{fiDepartmentName}", gp.getFiDepartmentName() == null ? "" : gp.getFiDepartmentName()));

        variables.addTextVariable(new TextVariable("#{fiHealthCertificateNoVni}", gp.getFiHealthCertificateNoVni() == null ? "" : gp.getFiHealthCertificateNoVni()));
        variables.addTextVariable(new TextVariable("#{fiConsignerName}", gp.getFiConsignerName() == null ? "" : gp.getFiConsignerName()));
        variables.addTextVariable(new TextVariable("#{fiConsignerAdress}", gp.getFiConsignerAdress() == null ? "" : gp.getFiConsignerAdress()));
        variables.addTextVariable(new TextVariable("#{fiConsigneeNameAddress}", gp.getFiConsigneeNameAddress() == null ? "" : gp.getFiConsigneeNameAddress()));

        variables.addTextVariable(new TextVariable("#{fiSlaughterHouseNameAddress}", gp.getFiSlaughterHouseNameAddress() == null ? "" : gp.getFiSlaughterHouseNameAddress()));

        if (gp.getFiSignResultDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiSignResultDateVni}", "Ngày " + gp.getFiSignResultDate().getDate() +
                    " tháng " + (gp.getFiSignResultDate().getMonth() + 1) +
                    " năm " + (1900 + gp.getFiSignResultDate().getYear())));
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", sdf.format(gp.getFiSignResultDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignResultDateVni}", "Ngày     tháng      "));
            variables.addTextVariable(new TextVariable("#{fiSignResultDate}", ""));
        }

        if (gp.getFiHealthCertificateEndDate() != null) {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", sdf.format(gp.getFiHealthCertificateEndDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiHealthCertificateEndDate}", ""));
        }


        variables.addTextVariable(new TextVariable("#{fiSignResultName}", gp.getFiSignResultName() == null ? "" : gp.getFiSignResultName()));


        String productNameVni = "";
        String productName = "";
        String packageTypeVni = "";
        String packageType = "";
        String txt1 = "";
        double totalNetweight = 0;

        Date fromDate = null;
        Date toDate = null;


        if (gp.getFiAnimalProductList() != null){
            if (gp.getFiAnimalProductList().size() > 0) {
                fromDate = gp.getFiAnimalProductList().get(0).getFiFromDateProduct();
                toDate = gp.getFiAnimalProductList().get(0).getFiToDateProduct();
            }

            for (TbdAnimailProductHKP01 spdv: gp.getFiAnimalProductList()) {
                productNameVni += String.format("%s, ", spdv.getFiCommodity());
                productName += String.format("%d(%s), ", spdv.getFiQuantity(), spdv.getFiUnit());
                packageTypeVni += String.format("%s, ", spdv.getFiMarkNo());
//                packageType += String.format("%.02f(%s), ", spdv.getFiNetWeight(),spdv.getFiNetWeightUnitName());
                packageType = spdv.getFiNetWeightUnitName();
                totalNetweight += spdv.getFiNetWeight();
                txt1 += String.format("%s, ", spdv.getFiLotIndetificationNo());
                if (spdv.getFiFromDateProduct().getTime() < fromDate.getTime()) {
                    fromDate = spdv.getFiFromDateProduct();
                }

                if (spdv.getFiToDateProduct().getTime() > toDate.getTime()) {
                    toDate = spdv.getFiToDateProduct();
                }
            }
            if (gp.getFiAnimalProductList().size() > 0) {
                productNameVni = productNameVni.substring(0, productNameVni.length() - 2);
                productName = productName.substring(0, productName.length() - 2);
                packageTypeVni = packageTypeVni.substring(0, packageTypeVni.length() - 2);
                txt1 = txt1.substring(0, txt1.length() - 2);
            }
        }

        variables.addTextVariable(new TextVariable("#{fiCommodity}", productNameVni));
        variables.addTextVariable(new TextVariable("#{fiQuantity}", productName));
        variables.addTextVariable(new TextVariable("#{fiMarkNo}", packageTypeVni));
        variables.addTextVariable(new TextVariable("#{fiNetWeight}", String.format("%1$,.2f (kg)", totalNetweight)));

        if (fromDate != null) {
            variables.addTextVariable(new TextVariable("#{fiFromDateProduct}", sdf.format(fromDate)));
        } else {
            variables.addTextVariable(new TextVariable("#{fiFromDateProduct}", ""));
        }

        if (toDate != null) {
            variables.addTextVariable(new TextVariable("#{fiToDateProduct}", sdf.format(toDate)));
        } else {
            variables.addTextVariable(new TextVariable("#{fiToDateProduct}", ""));
        }

        variables.addTextVariable(new TextVariable("#{fiLotIndetificationNo}", txt1));

        return variables;
    }

}
