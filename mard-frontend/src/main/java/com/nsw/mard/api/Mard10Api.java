/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nsw.api.BaseApi;
import com.nsw.common.model.ResponseUpload;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.ExcelMapping;
import com.nsw.helper.ExcelReader;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard10Constant;
import com.nsw.mard.p10.model.FeeMessage;
import com.nsw.mard.p10.model.FilterForm;
import com.nsw.mard.p10.model.SendMessage;
import com.nsw.mard.p10.model.Tbddinhkem10;
import com.nsw.mard.p10.model.Tbdhanghoa10;
import com.nsw.mard.p10.model.Tbdhanghoa14a;
import com.nsw.mard.p10.model.Tbdhanghoa14b;
import com.nsw.mard.p10.model.Tbdhanghoa15a;
import com.nsw.mard.p10.model.Tbdhanghoa15b;
import com.nsw.mard.p10.model.Tbdhanghoa15c;
import com.nsw.mard.p10.model.Tbdhanghoa9a;
import com.nsw.mard.p10.model.Tbdhoso10;
import com.nsw.mard.p10.model.Tbdmau14a;
import com.nsw.mard.p10.model.Tbdmau14b;
import com.nsw.mard.p10.model.Tbdmau15a;
import com.nsw.mard.p10.model.Tbdmau15b;
import com.nsw.mard.p10.model.Tbdmau15c;
import com.nsw.mard.p10.model.Tbdmau9a;
import com.nsw.mard.p10.model.Tbdtbtt10;
import com.nsw.mard.p10.model.Tbdxinruths10;
import com.nsw.mard.p10.model.Tbdxinsuagcn10;
import com.nsw.util.FileNameUtils;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import java.io.File;
import java.net.URI;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpMethod;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 *
 * @author Hieu Tran Trung
 */
@RestController
@RequestMapping("/mard/10")
public class Mard10Api extends BaseApi {

    static final String TAG = "mard10Api";
    static final Logger logger = LoggerFactory.getLogger(Mard10Api.class);

    @Autowired
    Environment environment;

    @RequestMapping(value = "/hoso/mau-gcn/{mau}/{fiIdHoso}", method = RequestMethod.GET)
    public void getMauGCN(
            @PathVariable("mau") String mau,
            @PathVariable("fiIdHoso") Long fiIdHoso,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            if (fiIdHoso == null || fiIdHoso.intValue() <= 0) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_get) + fiIdHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso10 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso10.class);
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (hoso == null || !getUsername().equals(hoso.getFiNguoitao())) {
                return;
            }
            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-gcn-mard-10.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;
            switch (mau) {
                case "9a":
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_10_9a.docx");
                    Tbdmau9a m9a = hoso.getTbdmau9a();
                    variables = genMau9a(m9a);
                    break;
                case "14a":
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_10_14a.docx");
                    Tbdmau14a m14a = hoso.getTbdmau14a();
                    variables = genMau14a(m14a);
                    break;
                case "14b":
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_10_14b.docx");
                    Tbdmau14b m14b = hoso.getTbdmau14b();
                    variables = genMau14b(m14b);
                    break;
                case "15a":
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_10_15a.docx");
                    Tbdmau15a m15a = hoso.getTbdmau15a();
                    variables = genMau15a(m15a);
                    break;
                case "15b":
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_10_15b.docx");
                    Tbdmau15b m15b = hoso.getTbdmau15b();
                    variables = genMau15b(m15b);
                    break;
                case "15c":
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_10_15c.docx");
                    Tbdmau15c m15c = hoso.getTbdmau15c();
                    variables = genMau15c(m15c);
                    break;
                default:
                    break;
            }
            if (templatePath != null && !templatePath.isEmpty()) {
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
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            logger.error(ex.getLocalizedMessage());
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
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_status));
                    break;
                case "DINHKEM":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.danhmuc_dinhkem));
                    break;
                case "SOLUONG":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.danhmuc_unit) + Mard10Constant.UNIT_TYPE.SOLUONG + "/" + Mard10Constant.UNIT_SYSTEMID);
                    break;
                case "TRONGLUONG":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.danhmuc_unit) + Mard10Constant.UNIT_TYPE.TRONGLUONG + "/" + Mard10Constant.UNIT_SYSTEMID);
                    break;
                case "QUOCGIA":
                    //json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.danhmuc_quocgia));
                    json = BackendRequestHelper.getInstance().doGetRequest(environment.getRequiredProperty(Mard10Constant.API.BACKEND_COMMON) + "/dic/state/");
                    break;
                case "CUAKHAU":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.danhmuc_cuakhau) + id);
                    break;
                case "DVKD":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.danhmuc_donvixuly) + id);
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

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        filter.setFiNguoitao(getUsername());
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_search), filter);
        return json;
    }

    @RequestMapping(value = "/hoso/t/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHoso(
            @PathVariable Long fiIdHoso
    ) {
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_get) + fiIdHoso);
            if (json != null && (LinkedHashMap) json.getData() != null) {
                if (!getUsername().equals(((LinkedHashMap) json.getData()).get("fiNguoitao"))) {
                    if (!getUsername().equals(((LinkedHashMap) json.getData()).get("fiNguoiCn"))) {
                        return null;
                    }
                }
            }
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    @RequestMapping(value = "/hoso/taomoi", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createHoso(
            @RequestBody Tbdhoso10 tbdhoso10
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            // Kiểm tra dữ liệu đầu vào
            // Bắt đầu gọi backend để thêm mới
            if (tbdhoso10 != null) {
                tbdhoso10.setFiNguoitao(getUsername());

                if (tbdhoso10.getLstHanghoa10() != null && !tbdhoso10.getLstHanghoa10().isEmpty()) {
                    for (Tbdhanghoa10 tbdhanghoa10 : tbdhoso10.getLstHanghoa10()) {
                        if (tbdhanghoa10.getFiNguoitao() == null) {
                            tbdhanghoa10.setFiNguoitao(getUsername());
                        }
                    }
                }
                if (tbdhoso10.getLstDinhkem10() != null && !tbdhoso10.getLstDinhkem10().isEmpty()) {
                    for (Tbddinhkem10 tbddinhkem10 : tbdhoso10.getLstDinhkem10()) {
                        if (tbddinhkem10.getFiNguoitao() == null) {
                            tbddinhkem10.setFiNguoitao(getUsername());
                        }
                    }
                }
            }
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_create), tbdhoso10);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            returnJson.setData(ex.getLocalizedMessage());
            returnJson.setSuccess(false);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            logger.error(ex.getLocalizedMessage());
        }
        returnJson.setData(null);
        returnJson.setSuccess(false);
        return returnJson;
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
        ResponseJson returnJson = new ResponseJson();
        try {
            if (message == null || !isOwner(message.getFiIdHoso())) {
                returnJson.setSuccess(false);
                return returnJson;
            }
            message.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_sendAll), message);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        returnJson.setSuccess(false);
        return returnJson;
    }

    @RequestMapping(value = "/hoso/fee", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson feeHoso(
            @RequestBody FeeMessage message
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            if (message == null || !isOwner(message.getFiIdHoso())) {
                returnJson.setSuccess(false);
                return returnJson;
            }
            message.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_sendPayFee), message);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        returnJson.setSuccess(false);
        return returnJson;
    }

    /**
     * Lưu hồ sơ bình thường
     *
     * @param tbdhoso10
     * @return
     */
    @RequestMapping(value = "/hoso/capnhap", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateHoso(
            @RequestBody Tbdhoso10 tbdhoso10
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            if (tbdhoso10 == null || !isOwner(tbdhoso10.getFiIdHoso())) {
                returnJson.setSuccess(false);
                return returnJson;
            }
            tbdhoso10.setFiNguoiCn(getUsername());
            if (tbdhoso10.getLstHanghoa10() != null && !tbdhoso10.getLstHanghoa10().isEmpty()) {
                for (Tbdhanghoa10 tbdhanghoa10 : tbdhoso10.getLstHanghoa10()) {
                    if (tbdhanghoa10.getFiIdHh() != null && tbdhanghoa10.getFiIdHh().intValue() > 0) {
                        tbdhanghoa10.setFiNguoiCn(getUsername());
                    }
                    if (tbdhanghoa10.getFiNguoitao() == null) {
                        tbdhanghoa10.setFiNguoitao(getUsername());
                    }
                }
            }
            if (tbdhoso10.getLstDinhkem10() != null && !tbdhoso10.getLstDinhkem10().isEmpty()) {
                for (Tbddinhkem10 tbddinhkem10 : tbdhoso10.getLstDinhkem10()) {
                    if (tbddinhkem10.getFiIdDinhkem() != null && tbddinhkem10.getFiIdDinhkem().intValue() > 0) {
                        tbddinhkem10.setFiNguoiCn(getUsername());
                    }
                    if (tbddinhkem10.getFiNguoitao() == null) {
                        tbddinhkem10.setFiNguoitao(getUsername());
                    }
                }
            }

            ResponseJson json = BackendRequestHelper.getInstance().doCustomRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_create), HttpMethod.PUT, tbdhoso10, new HashMap<>());
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        returnJson.setSuccess(false);
        return returnJson;
    }

    /**
     * Lưu hồ sơ cho trường hợp yêu cầu chỉnh sửa
     *
     * @param tbdhoso10
     * @return
     */
    @RequestMapping(value = "/hoso/yc-capnhap", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson requestUpdateHoso(
            @RequestBody Tbdhoso10 tbdhoso10
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            if (tbdhoso10 == null || !isOwner(tbdhoso10.getFiIdHoso())) {
                returnJson.setSuccess(false);
                return returnJson;
            }
            tbdhoso10.setFiNguoiCn(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_requestUpdate), tbdhoso10);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        returnJson.setSuccess(false);
        return returnJson;
    }

    /**
     * Xin hủy hồ sơ
     *
     * @param tbdxinruths10
     * @return
     */
    @RequestMapping(value = "/hoso/yc-huy", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson cancelHoso(
            @RequestBody Tbdxinruths10 tbdxinruths10
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            if (tbdxinruths10 == null || !isOwner(tbdxinruths10.getFiIdHoso())) {
                returnJson.setSuccess(false);
                return returnJson;
            }
            tbdxinruths10.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_cancel), tbdxinruths10);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        returnJson.setSuccess(false);
        return null;
    }

    /**
     * Thông báo thanh toán phí
     *
     * @param file
     * @param fiSotienCk
     * @param fiNdSotien
     * @param fiNguoinop
     * @param fiNgaynop
     * @param fiSohoadon
     * @param fiChuthich
     * @param fiMaLoai
     * @param fiIdHoso
     * @param fiMaHoso
     * @return
     */
    @RequestMapping(value = "/hoso/tb-thanhtoan", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson paymentHoso(
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam(name = "fiSotienCk", required = false) BigDecimal fiSotienCk,
            @RequestParam(name = "fiNdSotien", required = false) String fiNdSotien,
            @RequestParam(name = "fiNguoinop", required = false) String fiNguoinop,
            @RequestParam(name = "fiNgaynop", required = false) Date fiNgaynop,
            @RequestParam(name = "fiSohoadon", required = false) String fiSohoadon,
            @RequestParam(name = "fiChuthich", required = false) String fiChuthich,
            @RequestParam(name = "fiMaLoai", required = false) Long fiMaLoai,
            @RequestParam(name = "fiIdHoso", required = false) Long fiIdHoso,
            @RequestParam(name = "fiMaHoso", required = false) String fiMaHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            if (fiIdHoso != null && !isOwner(fiIdHoso)) {
                returnJson.setSuccess(false);
                return null;
            }
            Tbdtbtt10 tbdtbtt10 = new Tbdtbtt10();
            tbdtbtt10.setFiSotienCk(fiSotienCk);
            tbdtbtt10.setFiNdSotien(fiNdSotien);
            tbdtbtt10.setFiNguoinop(fiNguoinop);
            tbdtbtt10.setFiNgaynop(fiNgaynop);
            tbdtbtt10.setFiSohoadon(fiSohoadon);
            tbdtbtt10.setFiChuthich(fiChuthich);
            tbdtbtt10.setFiIdHoso(fiIdHoso);
            tbdtbtt10.setFiMaHoso(fiMaHoso);
            tbdtbtt10.setFiNguoitao(getUsername());
            if (file != null && file.getSize() > 0) {
                String folederUpload = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
                String fileName = FileNameUtils.toSafeFileName(file.getOriginalFilename(), 100);
                File uploadFile = new File(folederUpload + fileName);
                file.transferTo(uploadFile);
                Tbddinhkem10 tbddinhkem10 = new Tbddinhkem10();
                tbddinhkem10.setFiMaLoai(fiMaLoai);
                tbddinhkem10.setFiTenLoai(fiMaLoai.toString());
                tbddinhkem10.setFiHoatdong(1l);
                tbddinhkem10.setFiNgaytao(new Date());
                tbddinhkem10.setFiNguoitao(getUsername());
                tbddinhkem10.setFiTenTep(fileName);
                tbddinhkem10.setFiDuongDan(fileName);
                tbddinhkem10.setFiIdDt(0l);
                tbddinhkem10.setFiMaDt(1l);
                tbddinhkem10.setFiNoiDung(encodeFileToBase64Binary(uploadFile));
                tbdtbtt10.setDinhkem10(tbddinhkem10);
            }
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdtbtt10_create), tbdtbtt10);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        returnJson.setSuccess(false);
        return returnJson;
    }

    /**
     * Sửa giấy chứng nhận
     *
     * @param tbdxinsuagcn10
     * @return
     */
    @RequestMapping(value = "/hoso/yc-gcn", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson gcnHoso(
            @RequestBody Tbdxinsuagcn10 tbdxinsuagcn10
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {

            if (tbdxinsuagcn10 == null || !isOwner(tbdxinsuagcn10.getFiIdHoso())) {
                returnJson.setSuccess(false);
                return returnJson;
            }
            tbdxinsuagcn10.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdxinsuagcn10_create), tbdxinsuagcn10);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        returnJson.setSuccess(false);
        return returnJson;
    }

    /**
     * Hủy hồ sơ chưa gửi
     *
     * @param fiIdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/xoa/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson deleteHoso(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        if (fiIdHoso == null || !isOwner(fiIdHoso)) {
            returnJson.setSuccess(false);
            return returnJson;
        }
        HashMap map = new HashMap();
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_delete) + "/" + fiIdHoso + "/" + getUsername(), map);
        return json;
    }

    @RequestMapping(value = "/hoso/tbphi/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson tbPhiHoso(
            @PathVariable String fiMaHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            returnJson.setSuccess(false);
            return returnJson;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdtbapphi10_tbphi) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/kqtd/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqtdHoso(
            @PathVariable String fiMaHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            returnJson.setSuccess(false);
            return returnJson;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdkqtd10_kqtd) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/kqxinrut/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqXinRutHoso(
            @PathVariable String fiMaHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            returnJson.setSuccess(false);
            return returnJson;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdxinruths10_ruths) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/kqxinsua/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqXinSuaHoso(
            @PathVariable String fiMaHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            returnJson.setSuccess(false);
            return returnJson;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdycsuahs10_suahs) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/lohangxl/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson loHangXlHoso(
            @PathVariable String fiMaHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            returnJson.setSuccess(false);
            return returnJson;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdlohangxl10_lohang) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/kqxinsuagcn/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqXinSuaGcnHoso(
            @PathVariable String fiMaHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            returnJson.setSuccess(false);
            return returnJson;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdxinsuagcn10_xinsuagcn) + fiMaHoso);
        return json;
    }

    /**
     * Lấy văn bản với thông tin hàng hóa
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/quarantine/{id}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getQuarantineDoc(
            @PathVariable String id
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.quarantine_document) + id);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        returnJson.setSuccess(false);
        return returnJson;
    }

    /**
     * Lấy danh mục văn bản
     *
     * @return
     */
    @RequestMapping(value = "/quarantine", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getQuarantine() {
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.quarantine_get) + getUsername());
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    /**
     * Lấy danh sách hàng hóa
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/goods/{id}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getGoods(
            @PathVariable String id
    ) {
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.quarantine_goods) + id);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    /**
     * Lay thong tin mau da cap phep
     *
     * @param type
     * @return
     */
    @RequestMapping(value = "/gcn/{type}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getGcn(
            @PathVariable String type
    ) {
        try {
            ResponseJson json = null;
            switch (type) {
                case "14a":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.gcn_mau14a) + getUsername());
                    break;
                case "14b":
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.gcn_mau14b) + getUsername());
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
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_get) + fiIdHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso10 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso10.class);
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (hoso == null || !getUsername().equals(hoso.getFiNguoitao())) {
                return;
            }
            String templatePath = request.getRealPath("/WEB-INF/downloads/mard/mard_10.docx");
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-export-mard-10.docx";
            File tempFile = new File(tempFoleder + fileName);
            Docx docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            // preparing variables
            Variables variables = new Variables();
            // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat df = new DecimalFormat("#0.###");
            variables.addTextVariable(new TextVariable("#{ngay}", "" + hoso.getFiNgaytao().getDate()));
            variables.addTextVariable(new TextVariable("#{thang}", "" + (1 + hoso.getFiNgaytao().getMonth())));
            variables.addTextVariable(new TextVariable("#{nam}", "" + (1900 + hoso.getFiNgaytao().getYear())));
            variables.addTextVariable(new TextVariable("#{fiTenDvkd}", hoso.getFiTenDvkd() == null ? "" : hoso.getFiTenDvkd()));
            variables.addTextVariable(new TextVariable("#{fiTenCty}", hoso.getFiTenCty() == null ? "" : hoso.getFiTenCty()));
            variables.addTextVariable(new TextVariable("#{fiDiachiCty}", hoso.getFiDiachiCty() == null ? "" : hoso.getFiDiachiCty()));
            variables.addTextVariable(new TextVariable("#{fiSdtCty}", hoso.getFiSdtCty() == null ? "" : hoso.getFiSdtCty()));
            variables.addTextVariable(new TextVariable("#{fiFaxCty}", hoso.getFiFaxCty() == null ? "" : hoso.getFiFaxCty()));
            variables.addTextVariable(new TextVariable("#{fiEmailCty}", hoso.getFiEmailCty() == null ? "" : hoso.getFiEmailCty()));
            variables.addTextVariable(new TextVariable("#{fiNguoiky}", hoso.getFiNguoiky() == null ? "" : hoso.getFiNguoiky()));
            variables.addTextVariable(new TextVariable("#{fiXnNguoiky}", "" + hoso.getFiXnNguoiky() == null ? "" : hoso.getFiXnNguoiky()));
            
            if(hoso.getFiXnNgayky() != null) {
                variables.addTextVariable(new TextVariable("#{ngayxn}", ("" + hoso.getFiXnNgayky().getDate())));
                variables.addTextVariable(new TextVariable("#{thangxn}", ("" + (1 + hoso.getFiXnNgayky().getMonth()))));
                variables.addTextVariable(new TextVariable("#{namxn}", ("" + (1900 + hoso.getFiXnNgayky().getYear()))));
            } else {
                variables.addTextVariable(new TextVariable("#{ngayxn}", "..."));
                variables.addTextVariable(new TextVariable("#{thangxn}", "..."));
                variables.addTextVariable(new TextVariable("#{namxn}", "..."));
            }            
            
            List<Tbdhanghoa10> lstHanghoa10 = hoso.getLstHanghoa10();
            if (lstHanghoa10 == null || lstHanghoa10.isEmpty()) {
                variables.addTextVariable(new TextVariable("#{tenHang}", ""));
                variables.addTextVariable(new TextVariable("#{noiSanXuat}", ""));
                variables.addTextVariable(new TextVariable("#{soLuong}", ""));
                variables.addTextVariable(new TextVariable("#{trongLuongBi}", ""));
                variables.addTextVariable(new TextVariable("#{trongLuongTinh}", ""));
                variables.addTextVariable(new TextVariable("#{loaiBaoBi}", ""));
                variables.addTextVariable(new TextVariable("#{soHopDong}", ""));
            } else {
                String tenHang = "";
                String noiSanXuat = "";
                String soLuong = "";
                HashMap<String, BigDecimal> soLuongMap = new HashMap<>();
                String trongLuongTinh = "";
                HashMap<String, BigDecimal> trongLuongTinhMap = new HashMap<>();
                String trongLuongBi = "";
                HashMap<String, BigDecimal> trongLuongBiMap = new HashMap<>();
                String loaiBaoBi = "";
                String soHopDong = "";
                String key;
                for (Tbdhanghoa10 tbdhanghoa10 : lstHanghoa10) {
                    tenHang += (("".equals(tenHang) ? "" : ", ") + tbdhanghoa10.getFiTenHh()
                            + (tbdhanghoa10.getFiTlTinh() != null && tbdhanghoa10.getFiTlTinh().floatValue() > 0.0f
                            ? " (" + df.format(tbdhanghoa10.getFiTlTinh()) + (tbdhanghoa10.getFiTentlTinh() != null ? tbdhanghoa10.getFiTentlTinh() : tbdhanghoa10.getFiMaTlTinh()) + ")" : ""));
                    if (!(", " + noiSanXuat + ", ").contains(", " + tbdhanghoa10.getFiNoiSx() + ", ")) {
                        noiSanXuat += (("".equals(noiSanXuat) ? "" : ", ") + tbdhanghoa10.getFiNoiSx());
                    }
                    if (tbdhanghoa10.getFiLoaiBb() != null && !(", " + loaiBaoBi + ", ").contains(", " + tbdhanghoa10.getFiLoaiBb() + ", ")) {
                        loaiBaoBi += (("".equals(loaiBaoBi) ? "" : ", ") + tbdhanghoa10.getFiLoaiBb());
                    }
                    if (tbdhanghoa10.getFiSoHd() != null && !(", " + soHopDong + ", ").contains(", " + tbdhanghoa10.getFiSoHd() + ", ")) {
                        soHopDong += (("".equals(soHopDong) ? "" : ", ") + tbdhanghoa10.getFiSoHd());
                    }
                    if (tbdhanghoa10.getFiSoluong() != null && tbdhanghoa10.getFiSoluong().floatValue() > 0) {
                        key = tbdhanghoa10.getFiTendvSl() != null ? tbdhanghoa10.getFiTendvSl() : tbdhanghoa10.getFiMdvSl();
                        if (!soLuongMap.containsKey(key)) {
                            soLuongMap.put(key, tbdhanghoa10.getFiSoluong());
                        } else {
                            soLuongMap.put(key, soLuongMap.get(key).add(tbdhanghoa10.getFiSoluong()));
                        }
                    }
                    if (tbdhanghoa10.getFiTlTinh() != null && tbdhanghoa10.getFiTlTinh().floatValue() > 0.0f) {
                        key = tbdhanghoa10.getFiTentlTinh() != null ? tbdhanghoa10.getFiTentlTinh() : tbdhanghoa10.getFiMaTlTinh();
                        if (!trongLuongTinhMap.containsKey(key)) {
                            trongLuongTinhMap.put(key, tbdhanghoa10.getFiTlTinh());
                        } else {
                            trongLuongTinhMap.put(key, trongLuongTinhMap.get(key).add(tbdhanghoa10.getFiTlTinh()));
                        }
                    }
                    if (tbdhanghoa10.getFiTlBi() != null && tbdhanghoa10.getFiTlBi().floatValue() > 0) {
                        key = tbdhanghoa10.getFiTenTlBi() != null ? tbdhanghoa10.getFiTenTlBi() : tbdhanghoa10.getFiMaTlBi();
                        if (!trongLuongBiMap.containsKey(key)) {
                            trongLuongBiMap.put(key, tbdhanghoa10.getFiTlBi());
                        } else {
                            trongLuongBiMap.put(key, trongLuongBiMap.get(key).add(tbdhanghoa10.getFiTlBi()));
                        }
                    }
                }
                for (Map.Entry<String, BigDecimal> entry : soLuongMap.entrySet()) {
                    soLuong += (("".equals(soLuong) ? "" : ", ") + df.format(entry.getValue()) + " (" + entry.getKey() + ")");
                }
                for (Map.Entry<String, BigDecimal> entry : trongLuongTinhMap.entrySet()) {
                    trongLuongTinh += (("".equals(trongLuongTinh) ? "" : ", ") + df.format(entry.getValue()) + " (" + entry.getKey() + ")");
                }
                for (Map.Entry<String, BigDecimal> entry : trongLuongBiMap.entrySet()) {
                    trongLuongBi += (("".equals(trongLuongBi) ? "" : ", ") + df.format(entry.getValue()) + " (" + entry.getKey() + ")");
                }
                variables.addTextVariable(new TextVariable("#{tenHang}", tenHang));
                variables.addTextVariable(new TextVariable("#{noiSanXuat}", noiSanXuat));
                variables.addTextVariable(new TextVariable("#{soLuong}", soLuong));
                variables.addTextVariable(new TextVariable("#{trongLuongBi}", trongLuongBi));
                variables.addTextVariable(new TextVariable("#{trongLuongTinh}", trongLuongTinh));
                variables.addTextVariable(new TextVariable("#{loaiBaoBi}", loaiBaoBi));
                variables.addTextVariable(new TextVariable("#{soHopDong}", soHopDong));
            }
            variables.addTextVariable(new TextVariable("#{fiMaHoso}", hoso.getFiMaHoso() == null ? "" : hoso.getFiMaHoso()));
            variables.addTextVariable(new TextVariable("#{fiTenDtxk}", hoso.getFiTenDtxk() == null ? "" : hoso.getFiTenDtxk()));
            variables.addTextVariable(new TextVariable("#{fiTenQgxk}", hoso.getFiTenQgxk() != null ? hoso.getFiTenQgxk() : hoso.getFiMaQgxk()));
            variables.addTextVariable(new TextVariable("#{fiTenCkxk}", hoso.getFiTenCkxk() != null ? hoso.getFiTenCkxk() : hoso.getFiMaCkxk()));
            variables.addTextVariable(new TextVariable("#{fiTenDtnk}", hoso.getFiTenDtnk() == null ? "" : hoso.getFiTenDtnk()));
            variables.addTextVariable(new TextVariable("#{fiTenQgnk}", hoso.getFiTenQgnk() == null ? "" : hoso.getFiTenQgnk()));
            variables.addTextVariable(new TextVariable("#{fiPtvt}", hoso.getFiPtvt() == null ? "" : hoso.getFiPtvt()));
            variables.addTextVariable(new TextVariable("#{fiTenCknk}", hoso.getFiTenCknk() != null ? hoso.getFiTenCknk() : hoso.getFiMaCknk()));
            variables.addTextVariable(new TextVariable("#{fiMucdichSd}", hoso.getFiMucdichSd() == null ? "" : hoso.getFiMucdichSd()));
            variables.addTextVariable(new TextVariable("#{fiVbCtkd}", hoso.getFiVbCtkd() == null ? "" : hoso.getFiVbCtkd()));
            variables.addTextVariable(new TextVariable("#{fiDdkd}", hoso.getFiDdkd() == null ? "" : hoso.getFiDdkd()));
            variables.addTextVariable(new TextVariable("#{fiTgkd}", hoso.getFiTgkd() == null ? "" : hoso.getFiTgkd()));
            variables.addTextVariable(new TextVariable("#{fiXnDdkd}", hoso.getFiXnDdkd()== null ? "" : hoso.getFiXnDdkd()));            

            if (hoso.getFiTgkd() != null) {
                String[] words = hoso.getFiTgkd().split("\\/");
                if (words.length != 3) {
                    variables.addTextVariable(new TextVariable("#{ngaykd}", "...."));
                    variables.addTextVariable(new TextVariable("#{thangkd}", "...."));
                    variables.addTextVariable(new TextVariable("#{namkd}", "...."));
                } else {
                    variables.addTextVariable(new TextVariable("#{ngaykd}", "" + words[0]));
                    variables.addTextVariable(new TextVariable("#{thangkd}", "" + words[1]));
                    variables.addTextVariable(new TextVariable("#{namkd}", "" + words[2]));
                }
            } else {
                variables.addTextVariable(new TextVariable("#{ngaykd}", "...."));
                variables.addTextVariable(new TextVariable("#{thangkd}", "...."));
                variables.addTextVariable(new TextVariable("#{namkd}", "...."));
            }

            variables.addTextVariable(new TextVariable("#{fiDdgs}", hoso.getFiDdgs() == null ? "" : hoso.getFiDdgs()));
            variables.addTextVariable(new TextVariable("#{fiTggs}", hoso.getFiTggs() == null ? "" : hoso.getFiTggs()));
            variables.addTextVariable(new TextVariable("#{fiSobanGcn}", hoso.getFiSobanGcn() == null ? "" : hoso.getFiSobanGcn()));
            variables.addTextVariable(new TextVariable("#{fiSoVaoso}", hoso.getFiSoVaoso() == null ? "" : hoso.getFiSoVaoso()));
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
            logger.error(ex.getLocalizedMessage());
        }
    }

    /**
     * Lấy dữ liệu từ file excel và kiểm tra
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/hoso/excel", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson importHoso(
            @RequestParam("file") MultipartFile file
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            String folederUpload = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = FileNameUtils.toSafeFileName(file.getOriginalFilename(), 100);
            File uploadFile = new File(folederUpload + fileName);
            file.transferTo(uploadFile);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<ExcelMapping>>() {
            }.getType();
            List<ExcelMapping> response = gson.fromJson(Mard10Constant.JSON_IMPORT, listType);
            FileInputStream excelFile = new FileInputStream(uploadFile);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Tbdhoso10 hoso = new Tbdhoso10();
            List<Tbdhanghoa10> lstHanghoa10 = new ArrayList<>();
            for (ExcelMapping em : response) {
                switch (em.getReader()) {
                    case "hoso":
                        hoso = ExcelReader.readRandom(workbook.getSheetAt(em.getSheetIndex()), hoso, em);
                        break;
                    case "hanghoa":
                        lstHanghoa10 = ExcelReader.readTable(workbook.getSheetAt(em.getSheetIndex()), Tbdhanghoa10.class, em);
                        break;
                    default:
                        break;
                }
            }
            hoso.setLstHanghoa10(lstHanghoa10);
            hoso.setFiNgaytao(new Date());
            hoso.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_validate), hoso);
            excelFile.close();
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            logger.error(ex.getLocalizedMessage());
        }
        returnJson.setSuccess(false);
        return returnJson;
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
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbddinhkem10_get) + fiIdDinhkem);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbddinhkem10 tbddinhkem10 = GsonUtils.getInstance().transform(json.getData(), Tbddinhkem10.class);
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (tbddinhkem10.getFiIdDt() != null && tbddinhkem10.getFiIdDt().intValue() > 0 && !isOwner(tbddinhkem10.getFiIdDt())) {
                return;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbddinhkem10_download) + fiIdDinhkem);
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
                byte[] data = Base64.decodeBase64(((String) json.getData()));//.getBytes();
                response.getOutputStream().write(data);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    /**
     * fake file cua thu tuc 14a, 14b
     *
     * @param fiMaLoai
     * @param fiTenLoai
     * @param fiId14a
     * @param fiId14b
     * @param fiTenTep
     * @param fiIdHoso
     * @return
     */
    @RequestMapping(value = "/upload-14", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson upload14(
            @RequestParam(value = "fiMaLoai", required = false) Long fiMaLoai,
            @RequestParam(value = "fiTenLoai", required = false) String fiTenLoai,
            @RequestParam(value = "fiTenTep", required = false) String fiTenTep,
            @RequestParam(value = "fiId14a", required = false) Long fiId14a,
            @RequestParam(value = "fiId14b", required = false) Long fiId14b,
            @RequestParam(value = "fiIdHoso", required = false) Long fiIdHoso
    ) {
        try {
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (fiIdHoso != null && fiIdHoso > 0 && !isOwner(fiIdHoso)) {
                return null;
            }
            String url = environment.getRequiredProperty(AppConstant.Common.FILESERVICES) + AppConstant.URL_UPLOAD;
            URI uploadURL = new URI(url);
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            String folderUpload = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + ".txt";
            File uploadFile = new File(folderUpload + fileName);
            FileUtils.writeStringToFile(uploadFile, fileName);
            parts.add("file", new FileSystemResource(uploadFile));
            parts.add("fileName", fileName);
            parts.add("ministry", Mard10Constant.FileServices.MINISTRY);
            parts.add("procedure", Mard10Constant.FileServices.PROCEDURE);
            // Goi Service upload file
            ResponseUpload res = BackendRequestHelper.getInstance().doFormPostRequest(uploadURL, parts, ResponseUpload.class);
            if (res != null && (res.getErrorCode() == null || res.getErrorCode().isEmpty())) {
                // Luu file o backend
                Tbddinhkem10 tbddinhkem10 = new Tbddinhkem10();
                tbddinhkem10.setFiMaLoai(fiMaLoai);
                tbddinhkem10.setFiTenLoai(fiTenLoai);
                tbddinhkem10.setFiHoatdong(1l);
                tbddinhkem10.setFiNgaytao(new Date());
                tbddinhkem10.setFiNguoitao(getUsername());
                tbddinhkem10.setFiGuiId(FilenameUtils.removeExtension(res.getFileName()));
                tbddinhkem10.setFiTenTep(fiTenTep);
                tbddinhkem10.setFiDuongDan(res.getFilePath() + "/" + res.getFileName());
                tbddinhkem10.setFiIdDt(fiIdHoso == null ? 0l : fiIdHoso);
                tbddinhkem10.setFiMaDt(1l);
                tbddinhkem10.setFiNoiDung(encodeFileToBase64Binary(uploadFile));
                ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbddinhkem10_create), tbddinhkem10);
                return json;
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    /**
     * Đẩy tệp đính kèm lên server file sau đó lưu bản ghi ở backend
     *
     * @param file
     * @param fiMaLoai
     * @param fiTenLoai
     * @param fiTenTep
     * @param fiIdHoso
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "fiMaLoai", required = false) Long fiMaLoai,
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
            Tbddinhkem10 tbddinhkem10 = new Tbddinhkem10();

            tbddinhkem10.setFiMaLoai(fiMaLoai);
            tbddinhkem10.setFiTenLoai(fiTenLoai);
            tbddinhkem10.setFiHoatdong(1l);
            tbddinhkem10.setFiNgaytao(new Date());
            tbddinhkem10.setFiNguoitao(getUsername());
            tbddinhkem10.setFiTenTep(fiTenTep);
            tbddinhkem10.setFiDuongDan(fileName);
            tbddinhkem10.setFiIdDt(fiIdHoso == null ? 0l : fiIdHoso);
            tbddinhkem10.setFiMaDt(1l);
            tbddinhkem10.setFiNoiDung(encodeFileToBase64Binary(uploadFile));
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbddinhkem10_create), tbddinhkem10);
            return json;
            //}
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    private boolean isOwner(Object fiHoso) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_owner) + fiHoso + "/" + getUsername());
        return json != null && Boolean.parseBoolean(json.getData().toString());
    }

    private Variables genMau9a(Tbdmau9a m9a) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();
        variables.addTextVariable(new TextVariable("#{fiTenCqkddv}", m9a.getFiTenCqkddv() == null ? "" : m9a.getFiTenCqkddv()));
        variables.addTextVariable(new TextVariable("#{fiSocvDi}", m9a.getFiSocvDi() == null ? "" : m9a.getFiSocvDi()));
        variables.addTextVariable(new TextVariable("#{ngayBb}", m9a.getFiNgayBb() == null ? "" : "ngày " + m9a.getFiNgayBb().getDay() + " tháng " + (m9a.getFiNgayBb().getMonth() + 1) + " năm " + (m9a.getFiNgayBb().getYear() + 1900)));
        variables.addTextVariable(new TextVariable("#{FITENCQKDDV}", m9a.getFiTenCqkddv() == null ? "" : m9a.getFiTenCqkddv()));
        variables.addTextVariable(new TextVariable("#{fiCancuQd}", m9a.getFiCancuQd() == null ? "" : m9a.getFiCancuQd()));
        variables.addTextVariable(new TextVariable("#{fiNgayQd}", m9a.getFiNgayQd() == null ? "" : sdf.format(m9a.getFiNgayQd())));
        variables.addTextVariable(new TextVariable("#{fiDonviQd}", m9a.getFiDonviQd() == null ? "" : m9a.getFiDonviQd()));
        variables.addTextVariable(new TextVariable("#{foSoBb}", m9a.getFoSoBb() == null ? "" : m9a.getFoSoBb()));
        variables.addTextVariable(new TextVariable("#{fiNgayBb}", m9a.getFiNgayBb() == null ? "" : sdf.format(m9a.getFiNgayBb())));
        variables.addTextVariable(new TextVariable("#{fiDonviBb}", m9a.getFiDonviBb() == null ? "" : m9a.getFiDonviBb()));
        variables.addTextVariable(new TextVariable("#{fiTenCh}", m9a.getFiTenCh() == null ? "" : m9a.getFiTenCh()));
        variables.addTextVariable(new TextVariable("#{fiDiachiCh}", m9a.getFiDiachiCh() == null ? "" : m9a.getFiDiachiCh()));
        variables.addTextVariable(new TextVariable("#{fiDienthoaiCh}", m9a.getFiDienthoaiCh() == null ? "" : m9a.getFiDienthoaiCh()));
        variables.addTextVariable(new TextVariable("#{fiFaxCh}", m9a.getFiFaxCh() == null ? "" : m9a.getFiFaxCh()));
        variables.addTextVariable(new TextVariable("#{fiEmailCh}", m9a.getFiEmailCh() == null ? "" : m9a.getFiEmailCh()));
        variables.addTextVariable(new TextVariable("#{fiCmndCh}", m9a.getFiCmndCh() == null ? "" : m9a.getFiCmndCh()));
        variables.addTextVariable(new TextVariable("#{fiNgaycapCmnd}", m9a.getFiNgaycapCmnd() == null ? "" : sdf.format(m9a.getFiNgaycapCmnd())));
        variables.addTextVariable(new TextVariable("#{fiNoicapCmnd}", m9a.getFiNoicapCmnd() == null ? "" : m9a.getFiNoicapCmnd()));
        variables.addTextVariable(new TextVariable("#{fiDieu2}", m9a.getFiDieu2() == null ? "" : m9a.getFiDieu2()));
        variables.addTextVariable(new TextVariable("#{fiDieu3}", m9a.getFiDieu3() == null ? "" : m9a.getFiDieu3()));
        variables.addTextVariable(new TextVariable("#{fiDieu4}", m9a.getFiDieu4() == null ? "" : m9a.getFiDieu4()));
        variables.addTextVariable(new TextVariable("#{fiDieu5}", m9a.getFiDieu5() == null ? "" : m9a.getFiDieu5()));
        variables.addTextVariable(new TextVariable("#{fiDieu7}", m9a.getFiDieu7() == null ? "" : m9a.getFiDieu7()));
        variables.addTextVariable(new TextVariable("#{fiNoinhan}", m9a.getFiNoinhan() == null ? "" : m9a.getFiNoinhan()));
        variables.addTextVariable(new TextVariable("#{fiNguoiky}", m9a.getFiNguoiky() == null ? "" : m9a.getFiNguoiky()));
        variables.addTextVariable(new TextVariable("#{fiSoTokhai}", m9a.getFiSoTokhai() == null ? "" : m9a.getFiSoTokhai()));
        variables.addTextVariable(new TextVariable("#{fiSoVandon}", m9a.getFiSoVandon() == null ? "" : m9a.getFiSoVandon()));
        TableVariable tableVariable = new TableVariable();
        List<Variable> sttColumnVariables = new ArrayList<>();
        List<Variable> nameColumnVariables = new ArrayList<>();
        List<Variable> slColumnVariables = new ArrayList<>();
        List<Variable> klColumnVariables = new ArrayList<>();
        if (m9a.getLstHanghoa9a() != null && !m9a.getLstHanghoa9a().isEmpty()) {
            for (Tbdhanghoa9a tbdhanghoa9a : m9a.getLstHanghoa9a()) {
                sttColumnVariables.add(new TextVariable("#{tb_fiStt}", tbdhanghoa9a.getFiStt() == null ? "" : tbdhanghoa9a.getFiStt().toString()));
                nameColumnVariables.add(new TextVariable("#{tb_fiTenhang}", tbdhanghoa9a.getFiTenhang() == null ? "" : tbdhanghoa9a.getFiTenhang()));
                slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", tbdhanghoa9a.getFiSoluong() == null ? "" : tbdhanghoa9a.getFiSoluong().toString()));
                klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", tbdhanghoa9a.getFiKhoiluong() == null ? "" : tbdhanghoa9a.getFiKhoiluong().toString()));
            }
        } else {
            sttColumnVariables.add(new TextVariable("#{tb_fiStt}", ""));
            nameColumnVariables.add(new TextVariable("#{tb_fiTenhang}", ""));
            slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", ""));
            klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", ""));
        }
        tableVariable.addVariable(sttColumnVariables);
        tableVariable.addVariable(nameColumnVariables);
        tableVariable.addVariable(slColumnVariables);
        tableVariable.addVariable(klColumnVariables);
        variables.addTableVariable(tableVariable);
        return variables;
    }

    private Variables genMau14a(Tbdmau14a m14a) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();
        variables.addTextVariable(new TextVariable("#{fiTenCqkddv}", m14a.getFiTenCqkddv() == null ? "" : m14a.getFiTenCqkddv()));
        variables.addTextVariable(new TextVariable("#{fiSocv}", m14a.getFiSocv() == null ? "" : m14a.getFiSocv()));
        variables.addTextVariable(new TextVariable("#{fiTenCh}", m14a.getFiTenCh() == null ? "" : m14a.getFiTenCh()));
        variables.addTextVariable(new TextVariable("#{fiDiachiCh}", m14a.getFiDiachiCh() == null ? "" : m14a.getFiDiachiCh()));
        variables.addTextVariable(new TextVariable("#{fiCmndCh}", m14a.getFiCmndCh() == null ? "" : m14a.getFiCmndCh()));
        variables.addTextVariable(new TextVariable("#{fiNgaycapCmnd}", m14a.getFiNgaycapCmnd() == null ? "" : sdf.format(m14a.getFiNgaycapCmnd())));
        variables.addTextVariable(new TextVariable("#{fiNoicapCmnd}", m14a.getFiNoicapCmnd() == null ? "" : m14a.getFiNoicapCmnd()));
        variables.addTextVariable(new TextVariable("#{fiDtCh}", m14a.getFiDtCh() == null ? "" : m14a.getFiDtCh()));
        variables.addTextVariable(new TextVariable("#{fiFaxCh}", m14a.getFiFaxCh() == null ? "" : m14a.getFiFaxCh()));
        variables.addTextVariable(new TextVariable("#{fiEmailCh}", m14a.getFiEmailCh() == null ? "" : m14a.getFiEmailCh()));
        variables.addTextVariable(new TextVariable("#{fiNdTongso}", m14a.getFiNdTongso() == null ? "" : m14a.getFiNdTongso()));
        variables.addTextVariable(new TextVariable("#{fiDtXk}", m14a.getFiDtXk() == null ? "" : m14a.getFiDtXk()));
        variables.addTextVariable(new TextVariable("#{fiTenqgXk}", m14a.getFiTenqgXk() == null ? "" : m14a.getFiTenqgXk()));
        variables.addTextVariable(new TextVariable("#{fiTenqgQc}", m14a.getFiTenqgQc() == null ? "" : m14a.getFiTenqgQc()));
        variables.addTextVariable(new TextVariable("#{fiTenckNc}", m14a.getFiTenckNc() == null ? "" : m14a.getFiTenckNc()));
        variables.addTextVariable(new TextVariable("#{fiTgNk}", m14a.getFiTgNk() == null ? "" : sdf.format(m14a.getFiTgNk())));
        variables.addTextVariable(new TextVariable("#{fiVdLq}", m14a.getFiVdLq() == null ? "" : m14a.getFiVdLq()));
        variables.addTextVariable(new TextVariable("#{fiHosoLq}", m14a.getFiHosoLq() == null ? "" : m14a.getFiHosoLq()));
        variables.addTextVariable(new TextVariable("#{fiPtVc}", m14a.getFiPtVc() == null ? "" : m14a.getFiPtVc()));
        variables.addTextVariable(new TextVariable("#{fiBienks}", m14a.getFiBienks() == null ? "" : m14a.getFiBienks()));
        variables.addTextVariable(new TextVariable("#{fiPptdkt}", m14a.getFiPptdkt() == null ? "" : m14a.getFiPptdkt()));
        variables.addTextVariable(new TextVariable("#{fiNongdo}", m14a.getFiNongdo() == null ? "" : m14a.getFiNongdo()));
        variables.addTextVariable(new TextVariable("#{fiCachlyTn}", m14a.getFiCachlyTn() == null ? "" : sdf.format(m14a.getFiCachlyTn())));
        variables.addTextVariable(new TextVariable("#{fiNoicachly}", m14a.getFiNoicachly() == null ? "" : m14a.getFiNoicachly()));
        variables.addTextVariable(new TextVariable("#{fiLtCachly}", m14a.getFiLtCachly() == null ? "" : m14a.getFiLtCachly()));
        variables.addTextVariable(new TextVariable("#{fiCachlyDn}", m14a.getFiCachlyDn() == null ? "" : sdf.format(m14a.getFiCachlyDn())));
        variables.addTextVariable(new TextVariable("#{fiNoiky}", m14a.getFiNoiky() == null ? "" : m14a.getFiNoiky()));
        variables.addTextVariable(new TextVariable("#{fiNgayky}", m14a.getFiNgayky() == null ? "" : sdf.format(m14a.getFiNgayky())));
        variables.addTextVariable(new TextVariable("#{fiKddv}", m14a.getFiKddv() == null ? "" : m14a.getFiKddv()));
        variables.addTextVariable(new TextVariable("#{fiNguoiky}", m14a.getFiNguoiky() == null ? "" : m14a.getFiNguoiky()));
        variables.addTextVariable(new TextVariable("#{fiSoTokhai}", m14a.getFiSotokhai() == null ? "" : m14a.getFiSotokhai()));
        variables.addTextVariable(new TextVariable("#{fiSoVandon}", m14a.getFiSovandon() == null ? "" : m14a.getFiSovandon()));
        //30-11-2017 Bo sung so luong bang so
        variables.addTextVariable(new TextVariable("#{fiTongSl}", m14a.getFiTongSl() == null ? "" : m14a.getFiTongSl().toString()));

        TableVariable tableVariable = new TableVariable();
        List<Variable> tenColumnVariables = new ArrayList<>();
        List<Variable> tColumnVariables = new ArrayList<>();
        List<Variable> tb1ColumnVariables = new ArrayList<>();
        List<Variable> tbColumnVariables = new ArrayList<>();
        List<Variable> slColumnVariables = new ArrayList<>();
        List<Variable> tslColumnVariables = new ArrayList<>();
        List<Variable> mdColumnVariables = new ArrayList<>();
        if (m14a.getLstHanghoa14a() != null && !m14a.getLstHanghoa14a().isEmpty()) {
            for (Tbdhanghoa14a tbdhanghoa14a : m14a.getLstHanghoa14a()) {
                tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", tbdhanghoa14a.getFiTenHh() == null ? "" : tbdhanghoa14a.getFiTenHh()));
                tColumnVariables.add(new TextVariable("#{tb_fiTuoi}", tbdhanghoa14a.getFiTuoi() == null ? "" : tbdhanghoa14a.getFiTuoi()));
                tb1ColumnVariables.add(new TextVariable("#{tb_fiTinhbiet1}", tbdhanghoa14a.getFiTinhbiet() == null ? "" : tbdhanghoa14a.getFiTinhbiet().toString()));
                //tbColumnVariables.add(new TextVariable("#{tb_fiTinhbiet}", tbdhanghoa14a.getFiTinhbiet()== null ? ""  : tbdhanghoa14a.getFiTinhbiet().toString() ));
                tbColumnVariables.add(new TextVariable("#{tb_fiTinhbiet}", ""));
                slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", tbdhanghoa14a.getFiSoluong() == null ? "" : tbdhanghoa14a.getFiSoluong().toString()));
                tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", tbdhanghoa14a.getFiTenSl() == null ? "" : tbdhanghoa14a.getFiTenSl()));
                mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", tbdhanghoa14a.getFiMucdich() == null ? "" : tbdhanghoa14a.getFiMucdich()));
            }
        } else {
            tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", ""));
            tColumnVariables.add(new TextVariable("#{tb_fiTuoi}", ""));
            slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", ""));
            tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", ""));
            mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", ""));
            tb1ColumnVariables.add(new TextVariable("#{tb_fiTinhbiet1}", ""));
            tbColumnVariables.add(new TextVariable("#{tb_fiTinhbiet}", ""));
        }
        tableVariable.addVariable(tenColumnVariables);
        tableVariable.addVariable(tColumnVariables);
        tableVariable.addVariable(slColumnVariables);
        tableVariable.addVariable(tslColumnVariables);
        tableVariable.addVariable(mdColumnVariables);
        tableVariable.addVariable(tb1ColumnVariables);
        tableVariable.addVariable(tbColumnVariables);
        variables.addTableVariable(tableVariable);
        return variables;
    }

    private Variables genMau14b(Tbdmau14b m14b) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();
        variables.addTextVariable(new TextVariable("#{fiTenCqkddv}", m14b.getFiTenCqkddv() == null ? "" : m14b.getFiTenCqkddv()));
        variables.addTextVariable(new TextVariable("#{fiSocv}", m14b.getFiSocv() == null ? "" : m14b.getFiSocv()));
        variables.addTextVariable(new TextVariable("#{fiTenCh}", m14b.getFiTenCh() == null ? "" : m14b.getFiTenCh()));
        variables.addTextVariable(new TextVariable("#{fiDiachiCh}", m14b.getFiDiachiCh() == null ? "" : m14b.getFiDiachiCh()));
        variables.addTextVariable(new TextVariable("#{fiCmnd}", m14b.getFiCmnd() == null ? "" : m14b.getFiCmnd()));
        variables.addTextVariable(new TextVariable("#{fiNgaycapCmnd}", m14b.getFiNgaycapCmnd() == null ? "" : sdf.format(m14b.getFiNgaycapCmnd())));
        variables.addTextVariable(new TextVariable("#{fiNoicapCmnd}", m14b.getFiNoicapCmnd() == null ? "" : m14b.getFiNoicapCmnd()));
        variables.addTextVariable(new TextVariable("#{fiDtCh}", m14b.getFiDtCh() == null ? "" : m14b.getFiDtCh()));
        variables.addTextVariable(new TextVariable("#{fiFaxCh}", m14b.getFiFaxCh() == null ? "" : m14b.getFiFaxCh()));
        variables.addTextVariable(new TextVariable("#{fiEmailCh}", m14b.getFiEmailCh() == null ? "" : m14b.getFiEmailCh()));
        variables.addTextVariable(new TextVariable("#{fiNdTongso}", m14b.getFiNdTongso() == null ? "" : m14b.getFiNdTongso()));
        variables.addTextVariable(new TextVariable("#{fiDtXk}", m14b.getFiDtXk() == null ? "" : m14b.getFiDtXk()));
        variables.addTextVariable(new TextVariable("#{fiTenqgXk}", m14b.getFiTenqgXk() == null ? "" : m14b.getFiTenqgXk()));
        variables.addTextVariable(new TextVariable("#{fiQgQc}", m14b.getFiQgQc() == null ? "" : m14b.getFiQgQc()));
        variables.addTextVariable(new TextVariable("#{fiTenckNhap}", m14b.getFiTenckNhap() == null ? "" : m14b.getFiTenckNhap()));
        variables.addTextVariable(new TextVariable("#{fiTgNhap}", m14b.getFiTgNhap() == null ? "" : sdf.format(m14b.getFiTgNhap())));
        variables.addTextVariable(new TextVariable("#{fiHosoLq}", m14b.getFiHosoLq() == null ? "" : m14b.getFiHosoLq()));
        variables.addTextVariable(new TextVariable("#{fiPtVc}", m14b.getFiPtVc() == null ? "" : m14b.getFiPtVc()));
        variables.addTextVariable(new TextVariable("#{fiBienks}", m14b.getFiBienks() == null ? "" : m14b.getFiBienks()));
        variables.addTextVariable(new TextVariable("#{fiPptdkt}", m14b.getFiPptdkt() == null ? "" : m14b.getFiPptdkt()));
        variables.addTextVariable(new TextVariable("#{fiNongdo}", m14b.getFiNongdo() == null ? "" : m14b.getFiNongdo()));
        variables.addTextVariable(new TextVariable("#{fiCachlyTn}", m14b.getFiCachlyTn() == null ? "" : sdf.format(m14b.getFiCachlyTn())));
        variables.addTextVariable(new TextVariable("#{fiNoiCachly}", m14b.getFiNoiCachly() == null ? "" : m14b.getFiNoiCachly()));
        variables.addTextVariable(new TextVariable("#{fiLtCachly}", m14b.getFiLtCachly() == null ? "" : m14b.getFiLtCachly()));
        variables.addTextVariable(new TextVariable("#{fiCachlyDn}", m14b.getFiCachlyDn() == null ? "" : sdf.format(m14b.getFiCachlyDn())));
        variables.addTextVariable(new TextVariable("#{fiNoiky}", m14b.getFiNoiky() == null ? "" : m14b.getFiNoiky()));
        variables.addTextVariable(new TextVariable("#{fiNgayky}", m14b.getFiNgayky() == null ? "" : sdf.format(m14b.getFiNgayky())));
        variables.addTextVariable(new TextVariable("#{fiKddv}", m14b.getFiKddv() == null ? "" : m14b.getFiKddv()));
        variables.addTextVariable(new TextVariable("#{fiNguoiky}", m14b.getFiNguoiky() == null ? "" : m14b.getFiNguoiky()));
        variables.addTextVariable(new TextVariable("#{fiSoTokhai}", m14b.getFiSotokhai() == null ? "" : m14b.getFiSotokhai()));
        variables.addTextVariable(new TextVariable("#{fiSoVandon}", m14b.getFiSovandon() == null ? "" : m14b.getFiSovandon()));
        //30-11-2017 Bo sung so luong, trong luong bang so
        variables.addTextVariable(new TextVariable("#{fiTongSl}", m14b.getFiTongSl() == null ? "" : m14b.getFiTongSl().toString()));
        variables.addTextVariable(new TextVariable("#{fiTongTl}", m14b.getFiTongTl() == null ? "" : m14b.getFiTongTl().toString()));

        TableVariable tableVariable = new TableVariable();
        List<Variable> tenColumnVariables = new ArrayList<>();
        List<Variable> qcColumnVariables = new ArrayList<>();
        List<Variable> slColumnVariables = new ArrayList<>();
        List<Variable> tslColumnVariables = new ArrayList<>();
        List<Variable> klColumnVariables = new ArrayList<>();
        List<Variable> mdColumnVariables = new ArrayList<>();
        if (m14b.getLstHanghoa14b() != null && !m14b.getLstHanghoa14b().isEmpty()) {
            for (Tbdhanghoa14b tbdhanghoa14b : m14b.getLstHanghoa14b()) {
                tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", tbdhanghoa14b.getFiTenHh() == null ? "" : tbdhanghoa14b.getFiTenHh()));
                qcColumnVariables.add(new TextVariable("#{tb_fiQuycachDg}", tbdhanghoa14b.getFiQuycachDg() == null ? "" : tbdhanghoa14b.getFiQuycachDg()));
                slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", tbdhanghoa14b.getFiSoluong() == null ? "" : tbdhanghoa14b.getFiSoluong().toString()));
                tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", tbdhanghoa14b.getFiTenSl() == null ? "" : tbdhanghoa14b.getFiTenSl()));
                klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", tbdhanghoa14b.getFiKhoiluong() == null ? "" : tbdhanghoa14b.getFiKhoiluong().toString()));
                mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", tbdhanghoa14b.getFiMucdich() == null ? "" : tbdhanghoa14b.getFiMucdich()));
            }
        } else {
            tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", ""));
            qcColumnVariables.add(new TextVariable("#{tb_fiQuycachDg}", ""));
            slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", ""));
            tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", ""));
            klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", ""));
            mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", ""));
        }
        tableVariable.addVariable(tenColumnVariables);
        tableVariable.addVariable(qcColumnVariables);
        tableVariable.addVariable(slColumnVariables);
        tableVariable.addVariable(klColumnVariables);
        tableVariable.addVariable(tslColumnVariables);
        tableVariable.addVariable(mdColumnVariables);
        variables.addTableVariable(tableVariable);
        return variables;
    }

    private Variables genMau15a(Tbdmau15a m15a) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();
        variables.addTextVariable(new TextVariable("#{fiTenCqkddv}", m15a.getFiTenCqkddv() == null ? "" : m15a.getFiTenCqkddv()));
        variables.addTextVariable(new TextVariable("#{fiSocv}", m15a.getFiSocv() == null ? "" : m15a.getFiSocv()));
        variables.addTextVariable(new TextVariable("#{fiTenCh}", m15a.getFiTenCh() == null ? "" : m15a.getFiTenCh()));
        variables.addTextVariable(new TextVariable("#{fiDiachiCh}", m15a.getFiDiachiCh() == null ? "" : m15a.getFiDiachiCh()));
        variables.addTextVariable(new TextVariable("#{fiCmnd}", m15a.getFiCmnd() == null ? "" : m15a.getFiCmnd()));
        variables.addTextVariable(new TextVariable("#{fiNgaycapCmnd}", m15a.getFiNgaycapCmnd() == null ? "" : sdf.format(m15a.getFiNgaycapCmnd())));
        variables.addTextVariable(new TextVariable("#{fiNoicapCmnd}", m15a.getFiNoicapCmnd() == null ? "" : m15a.getFiNoicapCmnd()));
        variables.addTextVariable(new TextVariable("#{fiDienthoaiCh}", m15a.getFiDienthoaiCh() == null ? "" : m15a.getFiDienthoaiCh()));
        variables.addTextVariable(new TextVariable("#{fiFaxCh}", m15a.getFiFaxCh() == null ? "" : m15a.getFiFaxCh()));
        variables.addTextVariable(new TextVariable("#{fiEmailCh}", m15a.getFiEmailCh() == null ? "" : m15a.getFiEmailCh()));
        variables.addTextVariable(new TextVariable("#{fiTongSl}", m15a.getFiTongSl() == null ? "" : m15a.getFiTongSl().toString()));
        variables.addTextVariable(new TextVariable("#{fiNdTongsl}", m15a.getFiNdTongsl() == null ? "" : m15a.getFiNdTongsl()));
        variables.addTextVariable(new TextVariable("#{fiDtXk}", m15a.getFiDtXk() == null ? "" : m15a.getFiDtXk()));
        variables.addTextVariable(new TextVariable("#{fiTenqgXk}", m15a.getFiTenqgXk() == null ? "" : m15a.getFiTenqgXk()));
        variables.addTextVariable(new TextVariable("#{fiQgQc}", m15a.getFiQgQc() == null ? "" : m15a.getFiQgQc()));
        variables.addTextVariable(new TextVariable("#{fiNoiden}", m15a.getFiNoiden() == null ? "" : m15a.getFiNoiden()));
        variables.addTextVariable(new TextVariable("#{fiVdLq}", m15a.getFiVdLq() == null ? "" : m15a.getFiVdLq()));
        variables.addTextVariable(new TextVariable("#{fiHsLq}", m15a.getFiHsLq() == null ? "" : m15a.getFiHsLq()));
        variables.addTextVariable(new TextVariable("#{fiPtVc}", m15a.getFiPtVc() == null ? "" : m15a.getFiPtVc()));
        variables.addTextVariable(new TextVariable("#{fiPptdkt}", m15a.getFiPptdkt() == null ? "" : m15a.getFiPptdkt()));
        variables.addTextVariable(new TextVariable("#{fiNongdo}", m15a.getFiNongdo() == null ? "" : m15a.getFiNongdo()));
        variables.addTextVariable(new TextVariable("#{fiGiatriDn}", m15a.getFiGiatriDn() == null ? "" : sdf.format(m15a.getFiGiatriDn())));
        variables.addTextVariable(new TextVariable("#{fiBenhMd}", m15a.getFiBenhMd() == null ? "" : m15a.getFiBenhMd()));
        variables.addTextVariable(new TextVariable("#{fiNoiky}", m15a.getFiNoiky() == null ? "" : m15a.getFiNoiky()));
        variables.addTextVariable(new TextVariable("#{fiNgayky}", m15a.getFiNgayky() == null ? "" : sdf.format(m15a.getFiNgayky())));
        variables.addTextVariable(new TextVariable("#{fiKddv}", m15a.getFiKddv() == null ? "" : m15a.getFiKddv()));
        variables.addTextVariable(new TextVariable("#{fiNguoiky}", m15a.getFiNguoiky() == null ? "" : m15a.getFiNguoiky()));
        variables.addTextVariable(new TextVariable("#{fiSoTokhai}", m15a.getFiSotokhai() == null ? "" : m15a.getFiSotokhai()));
        variables.addTextVariable(new TextVariable("#{fiSoVandon}", m15a.getFiSovandon() == null ? "" : m15a.getFiSovandon()));

        //30-11-2017 Bo sung so luong, trong luong bang so
        variables.addTextVariable(new TextVariable("#{fiTongSl}", m15a.getFiTongSl() == null ? "" : m15a.getFiTongSl().toString()));

        TableVariable tableVariable = new TableVariable();
        List<Variable> tenColumnVariables = new ArrayList<>();
        List<Variable> tColumnVariables = new ArrayList<>();
        List<Variable> tb1ColumnVariables = new ArrayList<>();
        List<Variable> tbColumnVariables = new ArrayList<>();
        List<Variable> slColumnVariables = new ArrayList<>();
        List<Variable> tslColumnVariables = new ArrayList<>();
        List<Variable> mdColumnVariables = new ArrayList<>();
        if (m15a.getLstHanghoa15a() != null && !m15a.getLstHanghoa15a().isEmpty()) {
            for (Tbdhanghoa15a tbdhanghoa15a : m15a.getLstHanghoa15a()) {
                tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", tbdhanghoa15a.getFiTenHh() == null ? "" : tbdhanghoa15a.getFiTenHh()));
                tColumnVariables.add(new TextVariable("#{tb_fiTuoi}", tbdhanghoa15a.getFiTuoi() == null ? "" : tbdhanghoa15a.getFiTuoi()));
                tb1ColumnVariables.add(new TextVariable("#{tb_fiTinhbiet1}", tbdhanghoa15a.getFiTinhbiet() == null ? "" : tbdhanghoa15a.getFiTinhbiet().toString()));
                //tbColumnVariables.add(new TextVariable("#{tb_fiTinhbiet}", tbdhanghoa15a.getFiTinhbiet()== null ? ""  : tbdhanghoa15a.getFiTinhbiet().toString() ));
                tbColumnVariables.add(new TextVariable("#{tb_fiTinhbiet}", ""));
                slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", tbdhanghoa15a.getFiSoluong() == null ? "" : tbdhanghoa15a.getFiSoluong().toString()));
                tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", tbdhanghoa15a.getFiTenSl() == null ? "" : tbdhanghoa15a.getFiTenSl()));
                mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", tbdhanghoa15a.getFiMucdich() == null ? "" : tbdhanghoa15a.getFiMucdich()));
            }
        } else {
            tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", ""));
            tColumnVariables.add(new TextVariable("#{tb_fiTuoi}", ""));
            slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", ""));
            tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", ""));
            mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", ""));
            tb1ColumnVariables.add(new TextVariable("#{tb_fiTinhbiet1}", ""));
            tbColumnVariables.add(new TextVariable("#{tb_fiTinhbiet}", ""));
        }
        tableVariable.addVariable(tenColumnVariables);
        tableVariable.addVariable(tColumnVariables);
        tableVariable.addVariable(slColumnVariables);
        tableVariable.addVariable(tslColumnVariables);
        tableVariable.addVariable(mdColumnVariables);
        tableVariable.addVariable(tb1ColumnVariables);
        tableVariable.addVariable(tbColumnVariables);
        variables.addTableVariable(tableVariable);
        return variables;
    }

    private Variables genMau15b(Tbdmau15b m15b) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();
        variables.addTextVariable(new TextVariable("#{fiTenCqkddv}", m15b.getFiTenCqkddv() == null ? "" : m15b.getFiTenCqkddv()));
        variables.addTextVariable(new TextVariable("#{fiSocv}", m15b.getFiSocv() == null ? "" : m15b.getFiSocv()));
        variables.addTextVariable(new TextVariable("#{fiTenCh}", m15b.getFiTenCh() == null ? "" : m15b.getFiTenCh()));
        variables.addTextVariable(new TextVariable("#{fiDiachiCh}", m15b.getFiDiachiCh() == null ? "" : m15b.getFiDiachiCh()));
        variables.addTextVariable(new TextVariable("#{fiDtCh}", m15b.getFiDtCh() == null ? "" : m15b.getFiDtCh()));
        variables.addTextVariable(new TextVariable("#{fiFaxCh}", m15b.getFiFaxCh() == null ? "" : m15b.getFiFaxCh()));
        variables.addTextVariable(new TextVariable("#{fiEmailCh}", m15b.getFiEmailCh() == null ? "" : m15b.getFiEmailCh()));
        variables.addTextVariable(new TextVariable("#{fiTongSl}", m15b.getFiTongSl() == null ? "" : m15b.getFiTongSl().toString()));
        variables.addTextVariable(new TextVariable("#{fiNdTongso}", m15b.getFiNdTongso() == null ? "" : m15b.getFiNdTongso()));
        variables.addTextVariable(new TextVariable("#{fiDtXk}", m15b.getFiDtXk() == null ? "" : m15b.getFiDtXk()));
        variables.addTextVariable(new TextVariable("#{fiNoiSx}", m15b.getFiNoiSx() == null ? "" : m15b.getFiNoiSx()));
        variables.addTextVariable(new TextVariable("#{fiTenqgXk}", m15b.getFiTenqgXk() == null ? "" : m15b.getFiTenqgXk()));
        variables.addTextVariable(new TextVariable("#{fiQgQc}", m15b.getFiQgQc() == null ? "" : m15b.getFiQgQc()));
        variables.addTextVariable(new TextVariable("#{fiTenckNhap}", m15b.getFiTenckNhap() == null ? "" : m15b.getFiTenckNhap()));
        variables.addTextVariable(new TextVariable("#{fiTgNhap}", m15b.getFiTgNhap() == null ? "" : sdf.format(m15b.getFiTgNhap())));
        variables.addTextVariable(new TextVariable("#{fiNoichuyen}", m15b.getFiNoichuyen() == null ? "" : m15b.getFiNoichuyen()));
        variables.addTextVariable(new TextVariable("#{fiVdLq}", m15b.getFiVdLq() == null ? "" : m15b.getFiVdLq()));
        variables.addTextVariable(new TextVariable("#{fiHosoLq}", m15b.getFiHosoLq() == null ? "" : m15b.getFiHosoLq()));
        variables.addTextVariable(new TextVariable("#{fiPtVc}", m15b.getFiPtVc() == null ? "" : m15b.getFiPtVc()));
        variables.addTextVariable(new TextVariable("#{fiPptdkt}", m15b.getFiPptdkt() == null ? "" : m15b.getFiPptdkt()));
        variables.addTextVariable(new TextVariable("#{fiNongdo}", m15b.getFiNongdo() == null ? "" : m15b.getFiNongdo()));
        variables.addTextVariable(new TextVariable("#{fiCachlyDn}", m15b.getFiCachlyDn() == null ? "" : sdf.format(m15b.getFiCachlyDn())));
        variables.addTextVariable(new TextVariable("#{fiPtvccv}", m15b.getFiPtvccv() == null ? "" : m15b.getFiPtvccv()));
        variables.addTextVariable(new TextVariable("#{fiNongdovc}", m15b.getFiNongdovc() == null ? "" : sdf.format(m15b.getFiNongdovc())));
        variables.addTextVariable(new TextVariable("#{fiNoiky}", m15b.getFiNoiky() == null ? "" : m15b.getFiNoiky()));
        variables.addTextVariable(new TextVariable("#{fiNgayky}", m15b.getFiNgayky() == null ? "" : sdf.format(m15b.getFiNgayky())));
        variables.addTextVariable(new TextVariable("#{fiKddv}", m15b.getFiKddv() == null ? "" : m15b.getFiKddv()));
        variables.addTextVariable(new TextVariable("#{fiNguoiky}", m15b.getFiNguoiky() == null ? "" : m15b.getFiNguoiky()));
        variables.addTextVariable(new TextVariable("#{fiSoTokhai}", m15b.getFiSotokhai() == null ? "" : m15b.getFiSotokhai()));
        variables.addTextVariable(new TextVariable("#{fiSoVandon}", m15b.getFiSovandon() == null ? "" : m15b.getFiSovandon()));

        //30-11-2017 Bo sung so luong, trong luong bang so
        variables.addTextVariable(new TextVariable("#{fiTongSl}", m15b.getFiTongSl() == null ? "" : m15b.getFiTongSl().toString()));
        variables.addTextVariable(new TextVariable("#{fiTongTl}", m15b.getFiTongTl() == null ? "" : m15b.getFiTongTl().toString()));

        TableVariable tableVariable = new TableVariable();
        List<Variable> tenColumnVariables = new ArrayList<>();
        List<Variable> qcColumnVariables = new ArrayList<>();
        List<Variable> klColumnVariables = new ArrayList<>();
        List<Variable> slColumnVariables = new ArrayList<>();
        List<Variable> tslColumnVariables = new ArrayList<>();
        List<Variable> mdColumnVariables = new ArrayList<>();
        if (m15b.getLstHanghoa15b() != null && !m15b.getLstHanghoa15b().isEmpty()) {
            for (Tbdhanghoa15b tbdhanghoa15b : m15b.getLstHanghoa15b()) {
                tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", tbdhanghoa15b.getFiTenHh() == null ? "" : tbdhanghoa15b.getFiTenHh()));
                qcColumnVariables.add(new TextVariable("#{tb_fiQuycachDg}", tbdhanghoa15b.getFiQuycachDg() == null ? "" : tbdhanghoa15b.getFiQuycachDg()));
                klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", tbdhanghoa15b.getFiKhoiluong() == null ? "" : tbdhanghoa15b.getFiKhoiluong().toString()));
                slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", tbdhanghoa15b.getFiSoluong() == null ? "" : tbdhanghoa15b.getFiSoluong().toString()));
                tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", tbdhanghoa15b.getFiTenSl() == null ? "" : tbdhanghoa15b.getFiTenSl()));
                mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", tbdhanghoa15b.getFiMucdich() == null ? "" : tbdhanghoa15b.getFiMucdich()));
            }
        } else {
            tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", ""));
            qcColumnVariables.add(new TextVariable("#{tb_fiQuycachDg}", ""));
            klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", ""));
            slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", ""));
            tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", ""));
            mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", ""));
        }
        tableVariable.addVariable(tenColumnVariables);
        tableVariable.addVariable(qcColumnVariables);
        tableVariable.addVariable(klColumnVariables);
        tableVariable.addVariable(slColumnVariables);
        tableVariable.addVariable(tslColumnVariables);
        tableVariable.addVariable(mdColumnVariables);

        variables.addTableVariable(tableVariable);
        return variables;
    }

    private Variables genMau15c(Tbdmau15c m15c) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Variables variables = new Variables();
        variables.addTextVariable(new TextVariable("#{fiTenCqkddv}", m15c.getFiTenCqkddv() == null ? "" : m15c.getFiTenCqkddv()));
        variables.addTextVariable(new TextVariable("#{fiSocv}", m15c.getFiSocv() == null ? "" : m15c.getFiSocv()));
        variables.addTextVariable(new TextVariable("#{fiTenCh}", m15c.getFiTenCh() == null ? "" : m15c.getFiTenCh()));
        variables.addTextVariable(new TextVariable("#{fiDiachiCh}", m15c.getFiDiachiCh() == null ? "" : m15c.getFiDiachiCh()));
        variables.addTextVariable(new TextVariable("#{fiDtCh}", m15c.getFiDtCh() == null ? "" : m15c.getFiDtCh()));
        variables.addTextVariable(new TextVariable("#{fiFaxCh}", m15c.getFiFaxCh() == null ? "" : m15c.getFiFaxCh()));
        variables.addTextVariable(new TextVariable("#{fiEmailCh}", m15c.getFiEmailCh() == null ? "" : m15c.getFiEmailCh()));
        variables.addTextVariable(new TextVariable("#{fiTongSl}", m15c.getFiTongSl() == null ? "" : m15c.getFiTongSl().toString()));
        variables.addTextVariable(new TextVariable("#{fiNdTongso}", m15c.getFiNdTongso() == null ? "" : m15c.getFiNdTongso()));
        variables.addTextVariable(new TextVariable("#{fiDtXk}", m15c.getFiDtXk() == null ? "" : m15c.getFiDtXk()));
        variables.addTextVariable(new TextVariable("#{fiNoiSx}", m15c.getFiNoiSx() == null ? "" : m15c.getFiNoiSx()));
        variables.addTextVariable(new TextVariable("#{fiTenqgXk}", m15c.getFiTenqgXk() == null ? "" : m15c.getFiTenqgXk()));
        variables.addTextVariable(new TextVariable("#{fiQgQc}", m15c.getFiQgQc() == null ? "" : m15c.getFiQgQc()));
        variables.addTextVariable(new TextVariable("#{fiTenckNhap}", m15c.getFiTenckNhap() == null ? "" : m15c.getFiTenckNhap()));
        variables.addTextVariable(new TextVariable("#{fiTgNhap}", m15c.getFiTgNhap() == null ? "" : sdf.format(m15c.getFiTgNhap())));
        variables.addTextVariable(new TextVariable("#{fiNoiDen}", m15c.getFiNoiDen() == null ? "" : m15c.getFiNoiDen()));
        variables.addTextVariable(new TextVariable("#{fiVdLq}", m15c.getFiVdLq() == null ? "" : m15c.getFiVdLq()));
        variables.addTextVariable(new TextVariable("#{fiHosoLq}", m15c.getFiHosoLq() == null ? "" : m15c.getFiHosoLq()));
        variables.addTextVariable(new TextVariable("#{fiPtVc}", m15c.getFiPtVc() == null ? "" : m15c.getFiPtVc()));
        variables.addTextVariable(new TextVariable("#{fiPptdkt}", m15c.getFiPptdkt() == null ? "" : m15c.getFiPptdkt()));
        variables.addTextVariable(new TextVariable("#{fiNongdo}", m15c.getFiNongdo() == null ? "" : m15c.getFiNongdo()));
        variables.addTextVariable(new TextVariable("#{fiCachlyDn}", m15c.getFiCachlyDn() == null ? "" : sdf.format(m15c.getFiCachlyDn())));
        variables.addTextVariable(new TextVariable("#{fiNoiky}", m15c.getFiNoiky() == null ? "" : m15c.getFiNoiky()));
        variables.addTextVariable(new TextVariable("#{fiNgayky}", m15c.getFiNgayky() == null ? "" : sdf.format(m15c.getFiNgayky())));
        variables.addTextVariable(new TextVariable("#{fiKddv}", m15c.getFiKddv() == null ? "" : m15c.getFiKddv()));
        variables.addTextVariable(new TextVariable("#{fiNguoiky}", m15c.getFiNguoiky() == null ? "" : m15c.getFiNguoiky()));
        variables.addTextVariable(new TextVariable("#{fiSoTokhai}", m15c.getFiSotokhai() == null ? "" : m15c.getFiSotokhai()));
        variables.addTextVariable(new TextVariable("#{fiSoVandon}", m15c.getFiSovandon() == null ? "" : m15c.getFiSovandon()));

        //30-11-2017 Bo sung so luong, trong luong bang so
        variables.addTextVariable(new TextVariable("#{fiTongSl}", m15c.getFiTongSl() == null ? "" : m15c.getFiTongSl().toString()));
        variables.addTextVariable(new TextVariable("#{fiTongTl}", m15c.getFiTongTl() == null ? "" : m15c.getFiTongTl().toString()));

        TableVariable tableVariable = new TableVariable();
        List<Variable> tenColumnVariables = new ArrayList<>();
        List<Variable> qcColumnVariables = new ArrayList<>();
        List<Variable> klColumnVariables = new ArrayList<>();
        List<Variable> slColumnVariables = new ArrayList<>();
        List<Variable> tslColumnVariables = new ArrayList<>();
        List<Variable> mdColumnVariables = new ArrayList<>();
        if (m15c.getLstHanghoa15c() != null && !m15c.getLstHanghoa15c().isEmpty()) {
            for (Tbdhanghoa15c tbdhanghoa15c : m15c.getLstHanghoa15c()) {
                tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", tbdhanghoa15c.getFiTenHh() == null ? "" : tbdhanghoa15c.getFiTenHh()));
                qcColumnVariables.add(new TextVariable("#{tb_fiQuycachDg}", tbdhanghoa15c.getFiQuycachDg() == null ? "" : tbdhanghoa15c.getFiQuycachDg()));
                klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", tbdhanghoa15c.getFiKhoiluong() == null ? "" : tbdhanghoa15c.getFiKhoiluong().toString()));
                slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", tbdhanghoa15c.getFiSoluong() == null ? "" : tbdhanghoa15c.getFiSoluong().toString()));
                tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", tbdhanghoa15c.getFiTenSl() == null ? "" : tbdhanghoa15c.getFiTenSl()));
                mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", tbdhanghoa15c.getFiMucdich() == null ? "" : tbdhanghoa15c.getFiMucdich()));
            }
        } else {
            tenColumnVariables.add(new TextVariable("#{tb_fiTenHh}", ""));
            qcColumnVariables.add(new TextVariable("#{tb_fiQuycachDg}", ""));
            klColumnVariables.add(new TextVariable("#{tb_fiKhoiluong}", ""));
            slColumnVariables.add(new TextVariable("#{tb_fiSoluong}", ""));
            tslColumnVariables.add(new TextVariable("#{tb_fiTenSl}", ""));
            mdColumnVariables.add(new TextVariable("#{tb_fiMucdich}", ""));
        }
        tableVariable.addVariable(tenColumnVariables);
        tableVariable.addVariable(qcColumnVariables);
        tableVariable.addVariable(klColumnVariables);
        tableVariable.addVariable(slColumnVariables);
        tableVariable.addVariable(tslColumnVariables);
        tableVariable.addVariable(mdColumnVariables);

        variables.addTableVariable(tableVariable);
        return variables;
    }
}
