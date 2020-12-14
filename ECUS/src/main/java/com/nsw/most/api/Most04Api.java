/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.ExcelMapping;
import com.nsw.helper.ExcelReader;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import static com.nsw.most.api.Most03Api.TAG;
import com.nsw.most.constant.Most03Constant;
import com.nsw.most.p04.model.*;
import com.nsw.most.constant.Most04Constant;
import com.nsw.most.constant.ThuTuc02Constant;
import com.nsw.most.p03.model.Tbddinhkem3;
import com.nsw.most.p03.model.Tbdhanghoa3;
import com.nsw.most.p03.model.Tbdhoso3;
import com.nsw.most.p03.model.Tbdlichsu3;
import com.nsw.most.p03.model.Tbdtokhaihq3;
import com.nsw.util.DateTimeUtils;
import com.nsw.util.FileNameUtils;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.BulletListVariable;
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 *
 * @author QUANGNV18
 */
@RestController
@RequestMapping("/most/04")
public class Most04Api extends BaseApi {

    static final String TAG = "Most04Api";
    private static final int BUFFER_SIZE = 4096;

    @Autowired
    Environment environment;

    FileServiceHelper fileHelper = new FileServiceHelper();

    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;
        try {
            switch (key) {
                case "HS_STATUS":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_STATUS));
                    break;
                case "DM_NHOMHH":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.DM_NHOMHH));
                    break;
                case "DM_QUOCGIA":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most04Constant.getInstance().getBackendCommonApiUrl(environment, Most04Constant.API.DM_QUOCGIA));
                    break;
                case "DM_LOAIFILE":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.DM_LOAIFILE));
                    break;
                default:
                    break;
            }
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    @RequestMapping(value = "/hoso/search", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        if (filter.getNguoiTao() != null && "".equals(filter.getNguoiTao().trim())) {
            filter.setNguoiTao(null);
        }

        if (filter.getSoGiayPhep() != null && "".equals(filter.getSoGiayPhep().trim())) {
            filter.setSoGiayPhep(null);
        }
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_SEARCH), filter);
        return json;
    }

    @RequestMapping(value = "/hoso/t/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHoso(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_GETBYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/bosungtailieu", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson boSungtaiLieu(
            @RequestBody AddFileForm message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            if (!isOwner(message.getFiIdHoso())) {
                return json;
            }

            json = BackendRequestHelper.getInstance().doPostRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_BOSUNGTAILIEU), message);
            if (json.isSuccess()) {
                SendMessage sendMsg = new SendMessage();
                sendMsg.setFunction(Most04Constant.MSG_FUNC.FUNC_15);
                sendMsg.setType(Most04Constant.MSG_TYPE.TYPE_18);
                sendMsg.setFiIdHoso(message.getFiIdHoso());
                json = BackendRequestHelper.getInstance().doPostRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_SEND), sendMsg);
            }

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/lichsu", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson lichSuXuLyHoSo(
            @RequestBody HistoryFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            if (!isOwner(filterForm.getFiIdHoso())) {
                return json;
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_HISTORY), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/dinhkemls/{idlichsu}", method = RequestMethod.GET)
    public @ResponseBody
    void getDinhkemFromLichsu(
            HttpServletResponse response,
            HttpServletRequest request,
            @PathVariable("idlichsu") Long idlichsu
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.GET_HISTORY);
            json = BackendRequestHelper.getInstance().doGetRequest(url + idlichsu);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonData = mapper.writeValueAsString(json.getData());
            Tbdlichsu4 lichsu = mapper.readValue(jsonData, Tbdlichsu4.class);
            downloadFile(response, lichsu.getFiFileName(), lichsu.getFiFileName(), lichsu.getFiFileName(), lichsu.getFiFilePath());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

    }

    @RequestMapping(value = "/hoso/quyetdinh", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson quyetDinhHoSo(
            @RequestBody ResultFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
            return json;
        }
        json = BackendRequestHelper.getInstance().doGetRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_GIAYPHEP) + filterForm.getFiMaHoso());
        return json;
    }

    @RequestMapping(value = "/hoso/gcn/{fiIdHoso}", method = RequestMethod.GET)
    public void exportGiayChungNhan(
            HttpServletResponse response,
            HttpServletRequest request,
            @PathVariable("fiIdHoso") Long fiIdHoso) {
        try {
            if (fiIdHoso == null) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_GETBYID) + fiIdHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso4 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso4.class);
            // Kiểm tra xem có đc export lên cho hồ sơ này không?
            if (hoso == null || !getUsername().equals(hoso.getFiNguoitao())) {
                return;
            }
            // Lấy thông tin giấy phép
            json = BackendRequestHelper.getInstance().doGetRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_GIAYPHEP) + hoso.getFiMaHoso());
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdgiayphep4 giayPhepHoSo = GsonUtils.getInstance().transform(json.getData(), Tbdgiayphep4.class);
            if (giayPhepHoSo == null) {
                return;
            }

            String templatePath = request.getRealPath("/WEB-INF/downloads/most/bm_most_04.docx");
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-" + hoso.getFiMaHoso() + "-giaychungnhan.docx";
            File tempFile = new File(tempFoleder + fileName);
            Docx docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            // preparing variables
            Variables variables = new Variables();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            variables.addTextVariable(new TextVariable("#{fiSoGp}", giayPhepHoSo.getFiSoGp() == null ? "" : giayPhepHoSo.getFiSoGp()));
            variables.addTextVariable(new TextVariable("#{fiTenDn}", giayPhepHoSo.getFiTenDn() == null ? hoso.getFiTenDn() : giayPhepHoSo.getFiTenDn()));
            variables.addTextVariable(new TextVariable("#{fiDiachiDn}", giayPhepHoSo.getFiDiachiDn() == null ? hoso.getFiTenDn() : giayPhepHoSo.getFiDiachiDn()));
            variables.addTextVariable(new TextVariable("#{fiDtDn}", giayPhepHoSo.getFiDtDn() == null ? hoso.getFiTenDn() : giayPhepHoSo.getFiDtDn()));
            variables.addTextVariable(new TextVariable("#{fiFaxDn}", giayPhepHoSo.getFiFaxDn() == null ? hoso.getFiTenDn() : giayPhepHoSo.getFiFaxDn()));

            Date dNgayHetHan = giayPhepHoSo.getFiNgayHhan();
            String sNgayHetHan = "";
            if (dNgayHetHan != null) {
                sNgayHetHan = dateFormat.format(dNgayHetHan);
            }

            variables.addTextVariable(new TextVariable("#{fiNgayHetHanText}", sNgayHetHan));

            int i;
            TableVariable hanghoaTableVariable = new TableVariable();
            i = 0;
            List<Variable> sttClmnVariables = new ArrayList<Variable>();
            List<Variable> tenHHColumnVariables = new ArrayList<Variable>();
            List<Variable> loaiHangHoaColumnVariables = new ArrayList<Variable>();

            List<Tbdhanghoa4> lstHanghoa = giayPhepHoSo.getHangHoas();

            if (lstHanghoa == null || lstHanghoa.isEmpty()) {
                sttClmnVariables.add(new TextVariable("#{b.stt}", ""));
                tenHHColumnVariables.add(new TextVariable("#{b.fiTenHh}", ""));
                loaiHangHoaColumnVariables.add(new TextVariable("#{b.fiTenNhomHh}", ""));
            } else {
                for (Tbdhanghoa4 hangHoa : lstHanghoa) {
                    i++;
                    sttClmnVariables.add(new TextVariable("#{b.stt}", String.valueOf(i)));
                    tenHHColumnVariables.add(new TextVariable("#{b.fiTenHh}", hangHoa.getFiTenHh() == null ? "" : hangHoa.getFiTenHh()));
                    loaiHangHoaColumnVariables.add(new TextVariable("#{b.fiTenNhomHh}", hangHoa.getFiTenNhomHh() == null ? "" : hangHoa.getFiTenNhomHh()));
                }
            }
            hanghoaTableVariable.addVariable(sttClmnVariables);
            hanghoaTableVariable.addVariable(tenHHColumnVariables);
            hanghoaTableVariable.addVariable(loaiHangHoaColumnVariables);
            variables.addTableVariable(hanghoaTableVariable);

            // fill template
            docx.fillTemplate(variables);
            // save filled .docx file
            docx.save(tempFile.getPath());
            fileName = hoso.getFiMaHoso() + ".docx";
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.getOutputStream().write(loadFile(tempFile));
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    @RequestMapping(value = "/gcnfile/{iddinhkem}", method = RequestMethod.GET)
    public void downloadGiayChungNhan(
            HttpServletResponse response,
            HttpServletRequest request,
            @PathVariable("iddinhkem") Long iddinhkem) {
        try {
            if (iddinhkem == null) {
                return;
            }
            ResponseJson json;
            String url = getFullUri(environment.getProperty(Most04Constant.API.GET_DINHKEM_BYID));
            json = BackendRequestHelper.getInstance().doGetRequest(url + iddinhkem);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String jsonData = mapper.writeValueAsString(json.getData());
            Tbddinhkem4 gcn = mapper.readValue(jsonData, Tbddinhkem4.class);

            downloadFile(response, gcn.getFiFileName(), gcn.getFiTenTep(), gcn.getFiFileName(), gcn.getFiFilePath());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    private void downloadFile(HttpServletResponse response, String fileCode,
            String fileName, String fileCodeDb, String filePathDb) throws IOException {
        String name = fileName;
        String path = filePathDb;
        String mimeType = "";
        RabbitMQInfo mqInfo = getRabbitMQ();
        if (name == null) {
            name = fileCode;
        }

        if (fileCodeDb.equals(fileCode)) {
            String uri = getFullUri(environment.getProperty(ThuTuc02Constant.API.DƠNLOADFILE));
            byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

            Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
            Files.write(savePath, fileByte);

            File downloadFile = savePath.toFile();

            mimeType = URLConnection.guessContentTypeFromName(name);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + name + "\""));
            response.setContentLength((int) downloadFile.length());

            try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }

            downloadFile.delete();
        }
    }

    @RequestMapping(value = "/hoso/bieumau/{fiIdHoso}", method = RequestMethod.GET)
    public void exportHoso(
            HttpServletResponse response,
            HttpServletRequest request,
            @PathVariable("fiIdHoso") Long fiIdHoso) {
        try {
            if (fiIdHoso == null) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Most04Constant.getInstance().getApiUrl(environment, Most04Constant.API.HS_GETBYID) + fiIdHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso4 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso4.class);
            // Kiểm tra xem có đc export lên cho hồ sơ này không?
            if (hoso == null || !getUsername().equals(hoso.getFiNguoitao())) {
                return;
            }
            String templatePath = request.getRealPath("/WEB-INF/downloads/most/bm_hs_most_04.docx");
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-" + hoso.getFiMaHoso() + "-bm.docx";
            File tempFile = new File(tempFoleder + fileName);
            Docx docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            // preparing variables
            Variables variables = new Variables();
            //SimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            //DecimalFormat df = new DecimalFormat("#0.###");
            variables.addTextVariable(new TextVariable("#{ngay}", "" + hoso.getFiNgaytao().getDate()));
            variables.addTextVariable(new TextVariable("#{thang}", "" + (1 + hoso.getFiNgaytao().getMonth())));
            variables.addTextVariable(new TextVariable("#{nam}", "" + (1900 + hoso.getFiNgaytao().getYear())));
            //String mail = hoso.getFiEmailDn();
            //String keyName;

            variables.addTextVariable(new TextVariable("#{fiTenDn}", hoso.getFiTenDn()));

            variables.addTextVariable(new TextVariable("#{fiDiachiDn}", hoso.getFiDiachiDn() == null ? "" : hoso.getFiDiachiDn()));
            variables.addTextVariable(new TextVariable("#{fiMstDn}", hoso.getFiMstDn() == null ? "" : hoso.getFiMstDn()));
            variables.addTextVariable(new TextVariable("#{fiDtDn}", hoso.getFiDtDn() == null ? "" : hoso.getFiDtDn()));
            variables.addTextVariable(new TextVariable("#{fiWebsiteDn}", hoso.getFiWebsiteDn() == null ? "         " : hoso.getFiWebsiteDn()));
            variables.addTextVariable(new TextVariable("#{fiEmailDn}", hoso.getFiEmailDn() == null ? "" : hoso.getFiEmailDn()));
            variables.addTextVariable(new TextVariable("#{fiFaxDn}", hoso.getFiFaxDn() == null ? "" : hoso.getFiFaxDn()));

            int i;

            TableVariable hanghoaTableVariable = new TableVariable();
            i = 0;
            List<Variable> sttClmnVariables = new ArrayList<Variable>();
            List<Variable> tenHHColumnVariables = new ArrayList<Variable>();
            List<Variable> soDKColumnVariables = new ArrayList<Variable>();
            List<Variable> soHieuTCColumnVariables = new ArrayList<Variable>();
            List<Variable> thHamLgColumnVariables = new ArrayList<Variable>();

            List<Variable> NuocNKVariables = new ArrayList<Variable>();

            List<Tbdhanghoa4> lstHanghoa = hoso.getHangHoas();
            //List<Variable> thongtinFileDinhKem = new ArrayList<Variable>();

            if (lstHanghoa == null || lstHanghoa.isEmpty()) {
                sttClmnVariables.add(new TextVariable("#{stt}", ""));
                tenHHColumnVariables.add(new TextVariable("#{fiTenHh}", ""));
                soDKColumnVariables.add(new TextVariable("#{fiSoDk}", ""));
                soHieuTCColumnVariables.add(new TextVariable("#{fiSoHieuTc}", ""));
                thHamLgColumnVariables.add(new TextVariable("#{fiTpHlHchat}", ""));
                NuocNKVariables.add(new TextVariable("#{fiTenQgNk}", ""));
            } else {

                for (Tbdhanghoa4 hangHoa : lstHanghoa) {
                    i++;
                    sttClmnVariables.add(new TextVariable("#{stt}", String.valueOf(i)));
                    tenHHColumnVariables.add(new TextVariable("#{fiTenHh}", hangHoa.getFiTenHh() == null ? "" : hangHoa.getFiTenHh()));
                    soDKColumnVariables.add(new TextVariable("#{fiSoDk}", hangHoa.getFiSoDk() == null ? "" : hangHoa.getFiSoDk()));
                    soHieuTCColumnVariables.add(new TextVariable("#{fiSoHieuTc}", hangHoa.getFiSoHieuTc() == null ? "" : hangHoa.getFiSoHieuTc()));
                    thHamLgColumnVariables.add(new TextVariable("#{fiTpHlHchat}", hangHoa.getFiTpHlHchat() == null ? "" : hangHoa.getFiTpHlHchat().toString()));
                    NuocNKVariables.add(new TextVariable("#{fiTenQgNk}", hangHoa.getFiTenQgNk() == null ? "" : hangHoa.getFiTenQgNk()));
                }
            }
            hanghoaTableVariable.addVariable(sttClmnVariables);
            hanghoaTableVariable.addVariable(tenHHColumnVariables);
            hanghoaTableVariable.addVariable(soDKColumnVariables);
            hanghoaTableVariable.addVariable(soHieuTCColumnVariables);
            hanghoaTableVariable.addVariable(thHamLgColumnVariables);
            hanghoaTableVariable.addVariable(NuocNKVariables);

            //Fill file dinh kem
            List<Tbddinhkem4> lstFiles = hoso.getTepDinhKems();
            TableVariable fileDinhKemTableVariable = new TableVariable();
            List<Variable> tenLoaiFileColumnVariables = new ArrayList<Variable>();

            if (lstFiles == null || lstFiles.isEmpty()) {
                tenLoaiFileColumnVariables.add(new TextVariable("#{loaifile}", " "));

            } else {
                for (Tbddinhkem4 dinhKem : lstFiles) {
                    tenLoaiFileColumnVariables.add(new TextVariable("#{loaifile}", dinhKem.getFiTenLoaiDk()));
                }
            }

            fileDinhKemTableVariable.addVariable(tenLoaiFileColumnVariables);
            variables.addTableVariable(hanghoaTableVariable);
            variables.addTableVariable(fileDinhKemTableVariable);
            // fill template
            docx.fillTemplate(variables);
            // save filled .docx file
            docx.save(tempFile.getPath());
            fileName = hoso.getFiMaHoso() + ".docx";
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.getOutputStream().write(loadFile(tempFile));
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    private boolean isOwner(Object fiHoso) {
        return true;
    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND) + restUri;
    }
}
