/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.ExcelMapping;
import com.nsw.helper.ExcelReader;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard11Constant;
import com.nsw.mard.p10.model.Tbdhanghoa14a;
import com.nsw.mard.p11.model.*;
import com.nsw.util.FileNameUtils;
import com.nsw.util.GsonUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 *
 * @author hiep
 */
@RestController
@RequestMapping("/mard/11")
public class Mard11Api extends BaseApi {

    static final String TAG = "Mard11Api";
    static final Logger logger = LoggerFactory.getLogger(Mard11Api.class);

    @Autowired
    Environment environment;
    
     @RequestMapping(value = "/hoso/mau-gcn/{fiIdHoso}", method = RequestMethod.GET)
    public void getMauGCN(
            @PathVariable("fiIdHoso") Long fiIdHoso,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            if (fiIdHoso == null || fiIdHoso.intValue() <= 0) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_get) + fiIdHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso11 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso11.class);
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (hoso == null) {
                return;
            }
            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-gcn-mard-11.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables;
            switch (hoso.getGcn11().getFiLoaiCt().intValue()) {
                case 1:
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_11_1.docx");
                    break;
                case 2:
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_11_2.docx");
                    break;
                default:
                    break;
            }
            if(templatePath != null && !templatePath.isEmpty()){
                variables = genMau(hoso.getGcn11());
                tempFile = new File(tempFoleder + fileName);
                docx = new Docx(templatePath);
                docx.setVariablePattern(new VariablePattern("#{", "}"));
                docx.fillTemplate(variables);
                // save filled .docx file
                docx.save(tempFile.getPath());
                fileName = hoso.getFiMaHoso() + "-GCN.docx";
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.getOutputStream().write(loadFile(tempFile));
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

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
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_status));
                    break;
                case "DINHKEM":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_dinhkem));
                    break;
                case "SOLUONG":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_unit) + Mard11Constant.UNIT_TYPE.SOLUONG + "/" + Mard11Constant.UNIT_SYSTEMID);
                    break;
                case "TRONGLUONG":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_unit) + Mard11Constant.UNIT_TYPE.TRONGLUONG + "/" + Mard11Constant.UNIT_SYSTEMID);
                    break;
                case "THETICH":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_unit) + Mard11Constant.UNIT_TYPE.THETICH + "/" + Mard11Constant.UNIT_SYSTEMID);
                    break;
                case "QUOCGIA":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_quocgia));
                    break;
                case "TINHTHANH":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_tinhthanh));
                    break;
                case "CUAKHAU":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_cuakhau) + id);
                    break;
                case "DVKD":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_donvixuly) + id);
                    break;
                case "DONGGOI":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_donggoi) + id);
                    break;
                case "CHUYENCHO":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.danhmuc_chuyencho) + id);
                    break;
                default:
                    break;
            }
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        filter.setFiNguoitao(null);
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_search), filter);
        return json;
    }

    @RequestMapping(value = "/hoso/t/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHoso(
            @PathVariable Long fiIdHoso
    ) {
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_get) + fiIdHoso);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    @RequestMapping(value = "/hoso/tbphi/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson tbPhiHoso(
            @PathVariable String fiMaHoso
    ) {
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            return null;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdtbapphi11_tbphi) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/kqtd/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqtdHoso(
            @PathVariable String fiMaHoso
    ) {
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            return null;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdkqtd11_kqtd) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/lohangxl/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson loHangXlHoso(
            @PathVariable String fiMaHoso
    ) {
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            return null;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdtbxllh11_lohang) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/ycgcn/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson ycgcnHoso(
            @PathVariable String fiMaHoso
    ) {
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            return null;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdyccttgcn11_ycgcn) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/kqxinsua/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqXinSuaHoso(
            @PathVariable String fiMaHoso
    ) {
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            return null;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdycsuahs11_suahs) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/kqxinrut/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqXinRutHoso(
            @PathVariable String fiMaHoso
    ) {
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            return null;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdxinruths11_ruths) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/tcsuagcn/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqXinSuaGcnHoso(
            @PathVariable String fiMaHoso
    ) {
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            return null;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdtcsuagcn11_tcsuagcn) + fiMaHoso);
        return json;
    }

    /**
     * Sửa giấy chứng nhận
     *
     * @param tbdtcsuagcn11
     * @return
     */
    @RequestMapping(value = "/hoso/yc-gcn", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson gcnHoso(
            @RequestBody Tbdtcsuagcn11 tbdtcsuagcn11
    ) {
        try {

            if (tbdtcsuagcn11 == null || !isOwner(tbdtcsuagcn11.getFiIdHoso())) {
                return null;
            }
            tbdtcsuagcn11.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdtcsuagcn11_create), tbdtcsuagcn11);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    /**
     * Xin hủy hồ sơ
     *
     * @param tbdxinruths11
     * @return
     */
    @RequestMapping(value = "/hoso/yc-huy", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson cancelHoso(
            @RequestBody Tbdxinruths11 tbdxinruths11
    ) {
        try {
            if (tbdxinruths11 == null || !isOwner(tbdxinruths11.getFiIdHoso())) {
                return null;
            }
            tbdxinruths11.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_cancel), tbdxinruths11);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    @RequestMapping(value = "/hoso/gcn/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendGCN(
            @RequestBody Tbdgcn11 tbdgcn11
    ) {
        try {
            if (tbdgcn11 == null || !isOwner(tbdgcn11.getFiIdHoso())) {
                return null;
            }
//            if(tbdgcn11.getTbdhhgcn11() != null && !tbdgcn11.getTbdhhgcn11().isEmpty()){
//                for (Tbdhhgcn11 tbdhhgcn11 : tbdgcn11.getTbdhhgcn11()) {
//                }
//            }
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdgcn11_send), tbdgcn11);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    /**
     * Tất cả các nghiệp vụ xử lý hồ sơ - Gửi hồ sơ đi - Gửi lại ... Sau khi gọi
     * hàm lưu hồ sơ, lưu dữ liệu sẽ tiếp tục gọi hàm này để gửi đi
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/hoso/xuly", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson processHoso(
            @RequestBody SendMessage message
    ) {
        try {
            if (message == null || !isOwner(message.getFiIdHoso())) {
                return null;
            }
            message.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_sendAll), message);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    @RequestMapping(value = "/hoso/fee", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson feeHoso(
            @RequestBody FeeMessage message
    ) {
        try {
            if (message == null || !isOwner(message.getFiIdHoso())) {
                return null;
            }
            message.setFiNguoinop(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_sendPayFee), message);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    /**
     * Tải tệp biểu mẫu
     *
     * @param response
     * @param request
     * @param fiIdHoso
     */
    @RequestMapping(value = "/hoso/bieumau/{fiIdHoso}", method = RequestMethod.GET)
    public void exportHoso(
            HttpServletResponse response,
            HttpServletRequest request,
            @PathVariable("fiIdHoso") Long fiIdHoso) {
        try {
            if (fiIdHoso == null) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_get) + fiIdHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso11 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso11.class);
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (hoso == null || !getUsername().equals(hoso.getFiNguoitao())) {
                return;
            }
            String templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_11.docx");
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-export-mard-11.docx";
            File tempFile = new File(tempFoleder + fileName);
            Docx docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            // preparing variables
            Variables variables = new Variables();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            variables.addTextVariable(new TextVariable("#{ngay}", "" + hoso.getFiNgaytao().getDate()));
            variables.addTextVariable(new TextVariable("#{thang}", "" + (1 + hoso.getFiNgaytao().getMonth())));
            variables.addTextVariable(new TextVariable("#{nam}", "" + (1900 + hoso.getFiNgaytao().getYear())));
            variables.addTextVariable(new TextVariable("#{fiTendvXl}", hoso.getFiTendvXl() == null ? "" : hoso.getFiTendvXl()));
            variables.addTextVariable(new TextVariable("#{fiDtDangky}", hoso.getFiDtDangky() == null ? "" : hoso.getFiDtDangky()));
            variables.addTextVariable(new TextVariable("#{fiDiachi}", hoso.getFiDiachi() == null ? "" : hoso.getFiDiachi()));
            variables.addTextVariable(new TextVariable("#{fiSodt}", hoso.getFiSodt() == null ? "" : hoso.getFiSodt()));
            variables.addTextVariable(new TextVariable("#{fiEmail}", hoso.getFiEmail() == null ? "" : hoso.getFiEmail()));
            variables.addTextVariable(new TextVariable("#{fiSocmnd}", hoso.getFiSocmnd() == null ? "" : hoso.getFiSocmnd()));
            variables.addTextVariable(new TextVariable("#{fiNgaycmnd}", hoso.getFiNgaycmnd() == null ? "" : sdf.format(hoso.getFiNgaycmnd())));
            variables.addTextVariable(new TextVariable("#{fiNoicmnd}", hoso.getFiNoicmnd() == null ? "" : hoso.getFiNoicmnd()));
            List<Tbdhanghoa11> lstHanghoa11 = hoso.getLstHanghoa11();
            if (lstHanghoa11 == null || lstHanghoa11.isEmpty()) {
                variables.addTextVariable(new TextVariable("#{fiTenHh}", ""));
                variables.addTextVariable(new TextVariable("#{fiTenKh}", ""));
                variables.addTextVariable(new TextVariable("#{fiCososx}", ""));
                variables.addTextVariable(new TextVariable("#{fiMaCososx}", ""));
                variables.addTextVariable(new TextVariable("#{fiDiachiCssx}", ""));
                variables.addTextVariable(new TextVariable("#{fiSoluong}", ""));
                variables.addTextVariable(new TextVariable("#{fiKlTinh}", ""));
                variables.addTextVariable(new TextVariable("#{fiKlBi}", ""));
                variables.addTextVariable(new TextVariable("#{fiSohd}", ""));
            } else {
                String fiTenHh = "";
                String fiTenKh = "";
                String fiCososx = "";
                String fiMaCososx = "";
                String fiDiachiCssx = "";
                String fiSoluong = "";
                HashMap<String, BigDecimal> fiSoluongMap = new HashMap<>();
                String fiKlTinh = "";
                HashMap<String, BigDecimal> fiKlTinhMap = new HashMap<>();
                String fiKlBi = "";
                HashMap<String, BigDecimal> fiKlBiMap = new HashMap<>();
                String fiSohd = "";
                String key;
                for (Tbdhanghoa11 tbdhanghoa11 : lstHanghoa11) {
                    fiTenHh += (("".equals(fiTenHh) ? "" : ", ") + tbdhanghoa11.getFiTenHh());
                    fiTenKh += (("".equals(fiTenKh) ? "" : ", ") + tbdhanghoa11.getFiTenKh());
                    if (!(", " + fiCososx + ", ").contains(", " + tbdhanghoa11.getFiCososx() + ", ")) {
                        fiCososx += (("".equals(fiCososx) ? "" : ", ") + tbdhanghoa11.getFiCososx());
                    }
                    if (!(", " + fiMaCososx + ", ").contains(", " + tbdhanghoa11.getFiMaCososx() + ", ")) {
                        fiMaCososx += (("".equals(fiMaCososx) ? "" : ", ") + tbdhanghoa11.getFiMaCososx());
                    }
                    if (!(", " + fiDiachiCssx + ", ").contains(", " + tbdhanghoa11.getFiDiachiCssx() + ", ")) {
                        fiDiachiCssx += (("".equals(fiDiachiCssx) ? "" : ", ") + tbdhanghoa11.getFiDiachiCssx());
                    }
                    if (tbdhanghoa11.getFiSohd() != null && !(", " + fiSohd + ", ").contains(", " + tbdhanghoa11.getFiSohd() + ", ")) {
                        fiSohd += (("".equals(fiSohd) ? "" : ", ") + tbdhanghoa11.getFiSohd());
                    }
                    if (tbdhanghoa11.getFiSoluong() != null && tbdhanghoa11.getFiSoluong().floatValue() > 0) {
                        key = tbdhanghoa11.getFiTendvSl() != null ? tbdhanghoa11.getFiTendvSl() : tbdhanghoa11.getFiMadvSl();
                        if (!fiSoluongMap.containsKey(key)) {
                            fiSoluongMap.put(key, tbdhanghoa11.getFiSoluong());
                        } else {
                            fiSoluongMap.put(key, fiSoluongMap.get(key).add(tbdhanghoa11.getFiSoluong()));
                        }
                    }
                    if (tbdhanghoa11.getFiKlTinh() != null && tbdhanghoa11.getFiKlTinh().intValue() > 0) {
                        key = tbdhanghoa11.getFiTendvKlt() != null ? tbdhanghoa11.getFiTendvKlt() : tbdhanghoa11.getFiMadvKlt();
                        if (!fiKlTinhMap.containsKey(key)) {
                            fiKlTinhMap.put(key, tbdhanghoa11.getFiKlTinh());
                        } else {
                            fiKlTinhMap.put(key, (fiKlTinhMap.get(key).add(tbdhanghoa11.getFiKlTinh())));
                        }
                    }
                    if (tbdhanghoa11.getFiKlBi() != null && tbdhanghoa11.getFiKlBi().intValue() > 0) {
                        key = tbdhanghoa11.getFiTendvBi() != null ? tbdhanghoa11.getFiTendvBi() : tbdhanghoa11.getFiMadvBi();
                        if (!fiKlBiMap.containsKey(key)) {
                            fiKlBiMap.put(key, tbdhanghoa11.getFiKlBi());
                        } else {
                            fiKlBiMap.put(key, (fiKlBiMap.get(key).add(tbdhanghoa11.getFiKlBi())));
                        }
                    }
                }
                for (Map.Entry<String, BigDecimal> entry : fiSoluongMap.entrySet()) {
                    fiSoluong += (("".equals(fiSoluong) ? "" : ", ") + entry.getValue() + " (" + entry.getKey() + ")");
                }
                for (Map.Entry<String, BigDecimal> entry : fiKlTinhMap.entrySet()) {
                    fiKlTinh += (("".equals(fiKlTinh) ? "" : ", ") + entry.getValue() + " (" + entry.getKey() + ")");
                }
                for (Map.Entry<String, BigDecimal> entry : fiKlBiMap.entrySet()) {
                    fiKlBi += (("".equals(fiKlBi) ? "" : ", ") + entry.getValue() + " (" + entry.getKey() + ")");
                }
                variables.addTextVariable(new TextVariable("#{fiTenHh}", fiTenHh));
                variables.addTextVariable(new TextVariable("#{fiTenKh}", fiTenKh));
                variables.addTextVariable(new TextVariable("#{fiCososx}", fiCososx));
                variables.addTextVariable(new TextVariable("#{fiMaCososx}", fiMaCososx));
                variables.addTextVariable(new TextVariable("#{fiDiachiCssx}", fiDiachiCssx));
                variables.addTextVariable(new TextVariable("#{fiSoluong}", fiSoluong));
                variables.addTextVariable(new TextVariable("#{fiKlTinh}", fiKlTinh));
                variables.addTextVariable(new TextVariable("#{fiKlBi}", fiKlBi));
                variables.addTextVariable(new TextVariable("#{fiSohd}", fiSohd));
            }
            variables.addTextVariable(new TextVariable("#{fiPtCc}", hoso.getFiPtCc() == null ? "" : hoso.getFiPtCc()));
            variables.addTextVariable(new TextVariable("#{fiDtXk}", hoso.getFiDtXk() != null ? hoso.getFiDtXk() : ""));
            variables.addTextVariable(new TextVariable("#{fiDiachidtxk}", hoso.getFiDiachidtxk() != null ? hoso.getFiDiachidtxk() : ""));
            variables.addTextVariable(new TextVariable("#{fiTenckXk}", hoso.getFiTenckXk() == null ? hoso.getFiMackXk() : hoso.getFiTenckXk()));
            variables.addTextVariable(new TextVariable("#{fiDtNk}", hoso.getFiDtNk() == null ? "" : hoso.getFiDtNk()));
            variables.addTextVariable(new TextVariable("#{fiDiachidtnk}", hoso.getFiDiachidtnk() == null ? "" : hoso.getFiDiachidtnk()));
            variables.addTextVariable(new TextVariable("#{fiTenckNk}", hoso.getFiTenckNk() != null ? hoso.getFiTenckNk() : hoso.getFiMackNk()));
            variables.addTextVariable(new TextVariable("#{fiTenqgNk}", hoso.getFiTenqgNk() == null ? hoso.getFiMaqgNk() : hoso.getFiTenqgNk()));
            variables.addTextVariable(new TextVariable("#{fiMucdichsd}", hoso.getFiMucdichsd() == null ? "" : hoso.getFiMucdichsd()));
            variables.addTextVariable(new TextVariable("#{fiDiadiemdk}", hoso.getFiDiadiemdk() == null ? "" : hoso.getFiDiadiemdk()));
            variables.addTextVariable(new TextVariable("#{fiThoigiandk}", hoso.getFiThoigiandk() == null ? "" : sdf.format(hoso.getFiThoigiandk())));
            variables.addTextVariable(new TextVariable("#{fiDdTgGs}", hoso.getFiDdTgGs() == null ? "" : hoso.getFiDdTgGs()));
            variables.addTextVariable(new TextVariable("#{fiSobangcn}", hoso.getFiSobangcn() == null ? "" : hoso.getFiSobangcn()));
            variables.addTextVariable(new TextVariable("#{fiNguoiky}", hoso.getFiNguoiky() == null ? "" : hoso.getFiNguoiky()));
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
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    /**
     * Kiểm tra backend để lấy thông tin, sau đó download tệp từ server file
     *
     * @param response
     * @param fiIdDinhkem
     * @param mode
     */
    @RequestMapping(value = "/download/{fiIdDinhkem}", method = RequestMethod.GET)
    public void download(
            HttpServletResponse response,
            @PathVariable("fiIdDinhkem") Long fiIdDinhkem,
            @RequestParam(name = "mode", required = false) String mode) {
        try {
            if (fiIdDinhkem == null || fiIdDinhkem.intValue() <= 0) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbddinhkem11_get) + fiIdDinhkem);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbddinhkem11 tbddinhkem11 = GsonUtils.getInstance().transform(json.getData(), Tbddinhkem11.class);
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (tbddinhkem11.getFiIdDt() != null && tbddinhkem11.getFiIdDt().intValue() > 0 && !isOwner(tbddinhkem11.getFiIdDt())) {
                return;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbddinhkem11_download) + fiIdDinhkem);
            if (json != null && json.getSuccess()) {
                String fileName = json.getMessage();
                if ("view".equals(mode)) {
                    response.setContentType(getMimeType(fileName.split("\\.")[fileName.split("\\.").length - 1]));
                    response.setHeader("Content-Disposition", "inline; filename=" + fileName);
                } else {
                    response.setContentType("application/octet-stream");
                    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                }
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                byte[] data = Base64.decodeBase64(((String) json.getData()));
                response.getOutputStream().write(data);
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    /**
     * Đẩy tệp đính kèm lên server file sau đó lưu bản ghi ở backend
     *
     * @param file
     * @param fiTenLoai
     * @param fiTenTep
     * @param fiIdHoso
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "fiTenLoai", required = false) String fiTenLoai,
            @RequestParam(value = "fiTenTep", required = false) String fiTenTep,
            @RequestParam(value = "fiIdHoso", required = false) Long fiIdHoso
    ) {
        try {
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (fiIdHoso != null && fiIdHoso > 0 && !isOwner(fiIdHoso)) {
                return null;
            }
            String folderUpload = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = FileNameUtils.toSafeFileName(file.getOriginalFilename(), 100);
            File uploadFile = new File(folderUpload + fileName);
            file.transferTo(uploadFile);
            Tbddinhkem11 tbddinhkem11 = new Tbddinhkem11();

            tbddinhkem11.setFiTenLoai(fiTenLoai);
            tbddinhkem11.setFiHoatdong(1l);
            tbddinhkem11.setFiNgaytao(new Date());
            tbddinhkem11.setFiNguoitao(getUsername());
            tbddinhkem11.setFiTenTep(fiTenTep);
            tbddinhkem11.setFiDuongDan(fileName);
            tbddinhkem11.setFiIdDt(fiIdHoso == null ? 0l : fiIdHoso);
            tbddinhkem11.setFiMaDt(1l);
            tbddinhkem11.setFiNoiDung(encodeFileToBase64Binary(uploadFile));
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbddinhkem11_create), tbddinhkem11);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    @RequestMapping(value = "/hoso/tbapphi/", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getThongBaoApPhi(
            @RequestBody SendMessage message
    ) {
        try {
            if (message == null || !isOwner(message.getFiMaHoso())) {
                return null;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdtbapphi11_get) + message.getFiMaHoso());

            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    private boolean isOwner(Object fiHoso) {
        return true;
        //ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard11Constant.getInstance().getApiUrl(environment, Mard11Constant.API.tbdhoso11_owner) + fiHoso + "/" + getUsername());
        //return json != null && Boolean.parseBoolean(json.getData().toString());
    }

    private Variables genMau(Tbdgcn11 gcn11) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        Variables variables = new Variables();
        variables.addTextVariable(new TextVariable("#{fiDiachiXk}", gcn11.getFiDiachiXk() == null ? "" : gcn11.getFiDiachiXk()));
        variables.addTextVariable(new TextVariable("#{fiNguoiXk}", gcn11.getFiNguoiXk() == null ? "" : gcn11.getFiNguoiXk()));
        variables.addTextVariable(new TextVariable("#{fiTenNn}", gcn11.getFiTenNn() == null ? "" : gcn11.getFiTenNn()));
        variables.addTextVariable(new TextVariable("#{fiSoGcn}", gcn11.getFiSoGcn() == null ? "" : gcn11.getFiSoGcn()));
        variables.addTextVariable(new TextVariable("#{fiDiachiXk}", gcn11.getFiDiachiXk() == null ? "" : gcn11.getFiDiachiXk()));
        variables.addTextVariable(new TextVariable("#{fiDiachiNsx}", gcn11.getFiDiachiNsx() == null ? "" : gcn11.getFiDiachiNsx()));
        variables.addTextVariable(new TextVariable("#{fiDiachiNn}", gcn11.getFiDiachiNn() == null ? "" : gcn11.getFiDiachiNn()));
        variables.addTextVariable(new TextVariable("#{fiCkNhap}", gcn11.getFiCkNhap() == null ? "" : gcn11.getFiCkNhap()));
        variables.addTextVariable(new TextVariable("#{fiTennuocQc}", gcn11.getFiTennuocQc() == null ? "" : gcn11.getFiTennuocQc()));
        variables.addTextVariable(new TextVariable("#{fiSoluong}", gcn11.getFiSoluong() == null ? "" : gcn11.getFiSoluong().toString()));
        variables.addTextVariable(new TextVariable("#{fiTenbaobi}", gcn11.getFiTenbaobi() == null ? "" : gcn11.getFiTenbaobi()));
        variables.addTextVariable(new TextVariable("#{fiMakyhieu}", gcn11.getFiMakyhieu() == null ? "" : gcn11.getFiMakyhieu()));
        variables.addTextVariable(new TextVariable("#{fiKbbs}", gcn11.getFiKbbs() == null ? "" : gcn11.getFiKbbs()));
        variables.addTextVariable(new TextVariable("#{fiNg}", gcn11.getFiNgay() == null ? "" : gcn11.getFiNgay()));
        variables.addTextVariable(new TextVariable("#{fiTenthuoc}", gcn11.getFiTenthuoc() == null ? "" : gcn11.getFiTenthuoc()));
        variables.addTextVariable(new TextVariable("#{fiTgNd}", gcn11.getFiTgNd() == null ? "" : gcn11.getFiTgNd()));
        variables.addTextVariable(new TextVariable("#{fiTenPpxl}", gcn11.getFiTenPpxl() == null ? "" : gcn11.getFiTenPpxl()));
        variables.addTextVariable(new TextVariable("#{fiNongdo}", gcn11.getFiNongdo() == null ? "" : gcn11.getFiNongdo()));
        variables.addTextVariable(new TextVariable("#{fiTtThem}", gcn11.getFiTtThem() == null ? "" : gcn11.getFiTtThem()));
        variables.addTextVariable(new TextVariable("#{fiNoicapgiay}", gcn11.getFiNoicapgiay() == null ? "" : gcn11.getFiNoicapgiay()));
        variables.addTextVariable(new TextVariable("#{fiChucvuCb}", gcn11.getFiChucvuCb() == null ? "" : gcn11.getFiChucvuCb()));
        variables.addTextVariable(new TextVariable("#{fiTenCb}", gcn11.getFiTenCb() == null ? "" : gcn11.getFiTenCb()));
        variables.addTextVariable(new TextVariable("#{fiNgaycap}", gcn11.getFiNgaycap() == null ? "" : gcn11.getFiNgaycap()));

        variables.addTextVariable(new TextVariable("#{fiTunuoc}", gcn11.getFiTunuoc() == null ? "" : gcn11.getFiTunuoc()));
        variables.addTextVariable(new TextVariable("#{fiSocnkdtv}", gcn11.getFiSocnkdtv() == null ? "" : gcn11.getFiSocnkdtv()));
        Long allow = 1l;
        variables.addTextVariable(new TextVariable("#{fiBangoc}", allow.equals(gcn11.getFiBangoc() )  ? "X" : ""));
        variables.addTextVariable(new TextVariable("#{fiBansao}", allow.equals(gcn11.getFiBansao() )  ? "X" : ""));
        variables.addTextVariable(new TextVariable("#{fiDadonggoi}", allow.equals(gcn11.getFiDadonggoi() )  ? "X" : ""));
        variables.addTextVariable(new TextVariable("#{fiDagoilai}", allow.equals(gcn11.getFiDagoilai() )  ? "X" : ""));
        variables.addTextVariable(new TextVariable("#{fiGiunguyengoc}", allow.equals(gcn11.getFiGiunguyengoc() )  ? "X" : ""));
        variables.addTextVariable(new TextVariable("#{fiBaobimoi}", allow.equals(gcn11.getFiBaobimoi() )  ? "X" : ""));
        variables.addTextVariable(new TextVariable("#{fiTrencsGoc}", allow.equals(gcn11.getFiTrencsGoc() )  ? "X" : ""));
        variables.addTextVariable(new TextVariable("#{fiKtBosung}", allow.equals(gcn11.getFiKtBosung() )  ? "X" : ""));
        variables.addTextVariable(new TextVariable("#{fiC}", (gcn11.getFiHtcc() == null ? "" : gcn11.getFiTenHtcc()) + " " + (gcn11.getFiPtcc()== null ? "" : gcn11.getFiPtcc()) + " "  + gcn11.getFiSohieuPt() == null ? "" : gcn11.getFiSohieuPt()));
        
        
        TableVariable tableVariable = new TableVariable();
        List<Variable> sttColumnVariables = new ArrayList<>();
        List<Variable> tenhhColumnVariables = new ArrayList<>();
        List<Variable> tenkhColumnVariables = new ArrayList<>();
        List<Variable> slColumnVariables = new ArrayList<>();
        List<Variable> tslColumnVariables = new ArrayList<>();
        List<Variable> klColumnVariables = new ArrayList<>();
        List<Variable> tklColumnVariables = new ArrayList<>();
        
        String hh = "";
        String tkh = "";
        if(gcn11.getTbdhhgcn11() != null && gcn11.getTbdhhgcn11().size() > 0){
            int tt = gcn11.getTbdhhgcn11().size() > 3 ? 3 : gcn11.getTbdhhgcn11().size();
            for(int i = 0; i < tt; i++){
                Tbdhhgcn11 tbdhhgcn11 = gcn11.getTbdhhgcn11().get(i);
                tkh += ((tbdhhgcn11.getFiTenKh() == null ? "" :tbdhhgcn11.getFiTenKh() ) + "\n;");
                hh += (tbdhhgcn11.getFiTenHh() + ": " +
                            (tbdhhgcn11.getFiKhoiluong() == null ? "" : tbdhhgcn11.getFiKhoiluong().toString() + " ") + 
                            (tbdhhgcn11.getFiTendvKl() == null ? "" : tbdhhgcn11.getFiTendvKl().toString()+ ", ") + 
                            (tbdhhgcn11.getFiSoluong() == null ? "" : tbdhhgcn11.getFiSoluong().toString() + " ") + 
                            (tbdhhgcn11.getFiTendvSl() == null ? "" : tbdhhgcn11.getFiTendvSl().toString())
                        ) + "\n;";
            }
        }
        variables.addTextVariable(new TextVariable("#{hh}", hh));
        variables.addTextVariable(new TextVariable("#{tkh}", tkh));
        
        if(gcn11.getTbdhhgcn11() != null && gcn11.getTbdhhgcn11().size() > 3){
            for (Tbdhhgcn11 tbdhhgcn11 : gcn11.getTbdhhgcn11()) {
                sttColumnVariables.add(new TextVariable("#{tb_fiStt}", tbdhhgcn11.getFiStt() == null ? "" : tbdhhgcn11.getFiStt().toString() ));
                tenhhColumnVariables.add(new TextVariable("#{tb_fiTenHh}", tbdhhgcn11.getFiTenHh() == null ? "" : tbdhhgcn11.getFiTenHh().toString() ));
                tenkhColumnVariables.add(new TextVariable("#{tb_fiTenKh}", tbdhhgcn11.getFiTenKh() == null ? "" : tbdhhgcn11.getFiTenKh().toString()  ));
                slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", tbdhhgcn11.getFiSoluong() == null ? "" : tbdhhgcn11.getFiSoluong().toString()  ));
                tslColumnVariables.add(new TextVariable("#{tb_fiTendvSl}", tbdhhgcn11.getFiTendvSl() == null ? "" : tbdhhgcn11.getFiTendvSl().toString() ));
                klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", tbdhhgcn11.getFiKhoiluong() == null ? "" : tbdhhgcn11.getFiKhoiluong().toString() ));
                tklColumnVariables.add(new TextVariable("#{tb_fiTendvKl}", tbdhhgcn11.getFiTendvKl() == null ? "" : tbdhhgcn11.getFiTendvKl().toString() ));
            }
        }
        else{
            sttColumnVariables.add(new TextVariable("#{tb_fiStt}", "" ));
            tenhhColumnVariables.add(new TextVariable("#{tb_fiTenHh}", "" ));
            tenkhColumnVariables.add(new TextVariable("#{tb_fiTenKh}", ""  ));
            slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", ""  ));
            tslColumnVariables.add(new TextVariable("#{tb_fiTendvSl}", "" ));
            klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", "" ));
            tklColumnVariables.add(new TextVariable("#{tb_fiTendvKl}", "" ));
        }
        tableVariable.addVariable(sttColumnVariables);
        tableVariable.addVariable(tenhhColumnVariables);
        tableVariable.addVariable(tenkhColumnVariables);
        tableVariable.addVariable(slColumnVariables);
        tableVariable.addVariable(tslColumnVariables);
        tableVariable.addVariable(klColumnVariables);
        tableVariable.addVariable(tklColumnVariables);
        
        variables.addTableVariable(tableVariable);
        return variables;
    }

}
