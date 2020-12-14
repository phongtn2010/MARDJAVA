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
import com.nsw.mard.p10.model.Tbdhoso10;
import com.nsw.mard.p10.model.Tbdtbtt10;
import com.nsw.mard.p10.model.Tbdxinruths10;
import com.nsw.mard.p10.model.Tbdxinsuagcn10;
import com.nsw.util.FileNameUtils;
import com.nsw.util.GsonUtils;
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
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 *
 * @author phongnv
 */
@RestController
@RequestMapping("/mard/10")
public class Mard10Api extends BaseApi {

    static final String TAG = "mard10Api";
    static final Logger logger = LoggerFactory.getLogger(Mard10Api.class);

    @Autowired
    Environment environment;

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
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.danhmuc_quocgia));
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
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_sendAll), message);
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
            message.setFiNguoitao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdhoso10_sendPayFee), message);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
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
        try {
            if (fiIdHoso != null && !isOwner(fiIdHoso)) {
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
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdtbtt10_create), tbdtbtt10);
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
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdtbapphi10_tbphi) + fiMaHoso);
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
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdkqtd10_kqtd) + fiMaHoso);
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
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdxinruths10_ruths) + fiMaHoso);
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
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdycsuahs10_suahs) + fiMaHoso);
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
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.tbdlohangxl10_lohang) + fiMaHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/kqxinsuagcn/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqXinSuaGcnHoso(
            @PathVariable String fiMaHoso
    ) {
        if (fiMaHoso == null || !isOwner(fiMaHoso)) {
            return null;
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
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard10Constant.getInstance().getApiUrl(environment, Mard10Constant.API.quarantine_document) + id);
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
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
            String fileName = new Date().getTime() + "-export-mard-02.docx";
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
                HashMap<String, Long> soLuongMap = new HashMap<>();
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
                    if (tbdhanghoa10.getFiSoluong() != null && tbdhanghoa10.getFiSoluong() > 0) {
                        key = tbdhanghoa10.getFiTendvSl() != null ? tbdhanghoa10.getFiTendvSl() : tbdhanghoa10.getFiMdvSl();
                        if (!soLuongMap.containsKey(key)) {
                            soLuongMap.put(key, tbdhanghoa10.getFiSoluong());
                        } else {
                            soLuongMap.put(key, soLuongMap.get(key) + tbdhanghoa10.getFiSoluong());
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
                for (Map.Entry<String, Long> entry : soLuongMap.entrySet()) {
                    soLuong += (("".equals(soLuong) ? "" : ", ") + entry.getValue() + " (" + entry.getKey() + ")");
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
            
            if (hoso.getFiTgkd() != null) {
                String[] words = hoso.getFiTgkd().split("\\/");
                if (words != null) {
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
            return json;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
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
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    private boolean isOwner(Object fiHoso) {
        return true;
    }
}
