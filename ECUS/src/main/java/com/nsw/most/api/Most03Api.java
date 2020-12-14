/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nsw.api.BaseApi;
import com.nsw.common.model.SignData;
import com.nsw.common.model.TokhaiRequest;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.ExcelMapping;
import com.nsw.helper.ExcelReader;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.most.p03.model.*;
import com.nsw.most.constant.Most03Constant;
import com.nsw.util.Constants;
import com.nsw.util.FileNameUtils;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
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
@RequestMapping("/most/03")
public class Most03Api extends BaseApi {

    static final String TAG = "Most03Api";

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
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_STATUS));
                    break;
                case "DM_MPTD":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.DM_MAUPHUONGTIENDO));
                    break;
                case "DM_QUOCGIA":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getBackendCommonApiUrl(environment, Most03Constant.API.DM_QUOCGIA));
                    break;
                case "DM_LOAIHOSO":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.DM_LOAIHOSO));
                    break;
                case "DM_LOAIFILE":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.DM_LOAIFILE));
                    break;
                case "HS_LOAIPTDO":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_LOAIPHUONGTIENDO));
                    break;
                case "DM_DVHAIQUAN":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getBackendCommonApiUrl(environment, AppConstant.API.NSW_API_DSHQ));
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

        if (filter.getSoQuyetDinh() != null && "".equals(filter.getSoQuyetDinh().trim())) {
            filter.setSoQuyetDinh(null);
        }
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_SEARCH), filter);
        return json;
    }

    @RequestMapping(value = {"/tokhai"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getToKhai(@RequestBody TokhaiRequest data) {
        data.setMst(getUsername());
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getBackendCommonApiUrl(environment, AppConstant.API.NSW_API_TOKHAI), data);
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
            String url = Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_GETBYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
//            if (json != null && (LinkedHashMap) json.getData() != null) {
//                if (!getUsername().equals(((LinkedHashMap) json.getData()).get("fiNguoitao"))) {
//                    return null;
//                }
//            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/tt-giahan/", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getThongTinGiaHan(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_THONGTINGIAHAN);
            json = BackendRequestHelper.getInstance().doGetRequest(url + message.getFiIdHoso());
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

            json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_HISTORY), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/congvan", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson congVanHoSo(
            @RequestBody ResultFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
            return json;
        }
        json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_CONGVAN) + filterForm.getFiMaHoso());
        return json;
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
        json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_QUYETDINH) + filterForm.getFiMaHoso());
        return json;
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
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_GETBYID) + fiIdHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso3 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso3.class);
            // Kiểm tra xem có đc export lên cho hồ sơ này không?
            if (hoso == null || !getUsername().equals(hoso.getFiNguoitao())) {
                return;
            }
            String templatePath = request.getRealPath("/WEB-INF/downloads/most/bm_most_03.docx");
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-" + hoso.getFiMaHoso() + "-bm.docx";
            File tempFile = new File(tempFoleder + fileName);
            Docx docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            // preparing variables
            Variables variables = new Variables();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            //DecimalFormat df = new DecimalFormat("#0.###");
            variables.addTextVariable(new TextVariable("#{ngay}", "" + hoso.getFiNgaytao().getDate()));
            variables.addTextVariable(new TextVariable("#{thang}", "" + (1 + hoso.getFiNgaytao().getMonth())));
            variables.addTextVariable(new TextVariable("#{nam}", "" + (1900 + hoso.getFiNgaytao().getYear())));

            String keyName = "";
            if (hoso.getFiLoaiHoso() != null) {
                if (hoso.getFiLoaiHoso().equals(Most03Constant.HOSO_TYPE.TYPE_1)) {
                    keyName = Most03Constant.HOSO_TYPE.TYPE_1_STR;
                } else {
                    keyName = Most03Constant.HOSO_TYPE.TYPE_2_STR;
                }
            }
            variables.addTextVariable(new TextVariable("#{fiLoaiHoso}", keyName));

            keyName = "";
//            if (hoso.getFiLoaiPtd() != null) {
//                if (hoso.getFiLoaiPtd().equals(Most03Constant.PHUONG_TIEN_DO_TYPE.TYPE_1)) {
//                    keyName = Most03Constant.PHUONG_TIEN_DO_TYPE.TYPE_1_STR;
//                } else {
//                    keyName = Most03Constant.PHUONG_TIEN_DO_TYPE.TYPE_2_STR;
//                }
//            }

            variables.addTextVariable(new TextVariable("#{fiMaHoso}", hoso.getFiMaHoso()));
            variables.addTextVariable(new TextVariable("#{fiLoaiPtd}", keyName));
            variables.addTextVariable(new TextVariable("#{fiTenCoso}", hoso.getFiTenCoso() == null ? "" : hoso.getFiTenCoso()));
            variables.addTextVariable(new TextVariable("#{fiMstDn}", hoso.getFiMstDn() == null ? "" : hoso.getFiMstDn()));
            variables.addTextVariable(new TextVariable("#{fiDiachiTsc}", hoso.getFiDiachiTsc() == null ? "" : hoso.getFiDiachiTsc()));
            variables.addTextVariable(new TextVariable("#{fiDiachiVpgg}", hoso.getFiDiachiVpgg() == null ? "" : hoso.getFiDiachiVpgg()));
            variables.addTextVariable(new TextVariable("#{fiSdt}", hoso.getFiSdt() == null ? "" : hoso.getFiSdt()));
            variables.addTextVariable(new TextVariable("#{fiFax}", hoso.getFiFax() == null ? "" : hoso.getFiFax()));
            variables.addTextVariable(new TextVariable("#{fiEmail}", hoso.getFiEmail() == null ? "" : hoso.getFiEmail()));
            variables.addTextVariable(new TextVariable("#{fiSoDkkd}", hoso.getFiSoDkkd() == null ? "" : hoso.getFiSoDkkd()));
            variables.addTextVariable(new TextVariable("#{fiNgaycap}", hoso.getFiNgaycap() == null ? "" : dateFormat.format(hoso.getFiNgaycap())));
            variables.addTextVariable(new TextVariable("#{fiCqCap}", hoso.getFiCqCap() == null ? "" : hoso.getFiCqCap()));
            variables.addTextVariable(new TextVariable("#{fiDnMienTnm}", hoso.getFiDnMienTnm() == null ? "" : hoso.getFiDnMienTnm()));
            variables.addTextVariable(new TextVariable("#{fiLydoDnMien}", hoso.getFiLydoDnMien() == null ? "" : hoso.getFiLydoDnMien()));
            variables.addTextVariable(new TextVariable("#{fiNguoiDaidien}", hoso.getFiNguoiDaidien() == null ? "" : hoso.getFiNguoiDaidien()));
            variables.addTextVariable(new TextVariable("#{fiChucvuNguoidaidien}", hoso.getFiChucvuNguoidaidien() == null ? "" : hoso.getFiChucvuNguoidaidien()));

            TableVariable toKhaiTableVariable = new TableVariable();
            List<Variable> sttColumnVariables = new ArrayList<Variable>();
            List<Variable> soTkColumnVariables = new ArrayList<Variable>();
            List<Variable> ngayDkColumnVariables = new ArrayList<Variable>();
            List<Variable> maHqColumnVariables = new ArrayList<Variable>();
            int i = 0;
            List<Tbdtokhaihq3> lstToKhai = hoso.getToKhaiHQs();
            if (lstToKhai == null || lstToKhai.isEmpty()) {
                sttColumnVariables.add(new TextVariable("#{stt}", ""));
                soTkColumnVariables.add(new TextVariable("#{fiSoTk}", ""));
                ngayDkColumnVariables.add(new TextVariable("#{fiNgayDk}", ""));
                maHqColumnVariables.add(new TextVariable("#{fiMaHq}", ""));
            } else {
                for (Tbdtokhaihq3 toKhai : lstToKhai) {
                    i++;
                    sttColumnVariables.add(new TextVariable("#{stt}", String.valueOf(i)));
                    soTkColumnVariables.add(new TextVariable("#{fiSoTk}", toKhai.getFiSoTk()));
                    ngayDkColumnVariables.add(new TextVariable("#{fiNgayDk}", dateFormat.format(toKhai.getFiNgayDk())));
                    maHqColumnVariables.add(new TextVariable("#{fiMaHq}", toKhai.getFiMaHq()));
                }
            }

            toKhaiTableVariable.addVariable(sttColumnVariables);
            toKhaiTableVariable.addVariable(soTkColumnVariables);
            toKhaiTableVariable.addVariable(ngayDkColumnVariables);
            toKhaiTableVariable.addVariable(maHqColumnVariables);
            variables.addTableVariable(toKhaiTableVariable);

            TableVariable hanghoaTableVariable = new TableVariable();
            i = 0;
            List<Variable> sttClmnVariables = new ArrayList<Variable>();
            List<Variable> tenHHColumnVariables = new ArrayList<Variable>();
            List<Variable> soTKColumnVariables = new ArrayList<Variable>();
            List<Variable> maHSColumnVariables = new ArrayList<Variable>();
            List<Variable> kieuColumnVariables = new ArrayList<Variable>();

            List<Variable> thongTinNSXVariables = new ArrayList<Variable>();
            List<Variable> dacTinhKTVariables = new ArrayList<Variable>();

            //List<Variable> soSXColumnVariables = new ArrayList<Variable>();
            List<Variable> ghiChuColumnVariables = new ArrayList<Variable>();

            List<Tbdhanghoa3> lstHanghoa = hoso.getHangHoas();
            List<Variable> thongTinNhaSX;
            List<Variable> thongTinDacTKT;
            //List<Variable> thongtinFileDinhKem = new ArrayList<Variable>();

            if (lstHanghoa == null || lstHanghoa.isEmpty()) {
                sttClmnVariables.add(new TextVariable("#{b.stt}", ""));
                tenHHColumnVariables.add(new TextVariable("#{b.fiTenHh}", ""));
                soTKColumnVariables.add(new TextVariable("#{b.fiSotk}", ""));
                maHSColumnVariables.add(new TextVariable("#{b.fiMaHs}", ""));
                kieuColumnVariables.add(new TextVariable("#{b.fiKieu}", ""));

                thongTinNhaSX = new ArrayList<Variable>();
                thongTinNhaSX.add(new TextVariable("#{b.thongTinNhaSX}", ""));
                thongTinNhaSX.add(new TextVariable("#{b.thongTinNhaSX}", ""));
                thongTinNSXVariables.add(new BulletListVariable("#{b.thongTinNhaSX}", thongTinNhaSX));

                thongTinDacTKT = new ArrayList<Variable>();
                thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", ""));
                thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", ""));
                thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", ""));
                thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", ""));
                dacTinhKTVariables.add(new BulletListVariable("#{b.thongTinDacTinhKT}", thongTinDacTKT));

//                soSXColumnVariables.add(new TextVariable("#{b.fiSoSx}", ""));
                ghiChuColumnVariables.add(new TextVariable("#{b.fiGhiChu}", ""));
            } else {

                for (Tbdhanghoa3 hangHoa : lstHanghoa) {
                    i++;
                    sttClmnVariables.add(new TextVariable("#{b.stt}", String.valueOf(i)));
                    tenHHColumnVariables.add(new TextVariable("#{b.fiTenHh}", hangHoa.getFiTenHh() == null ? "" : hangHoa.getFiTenHh()));
                    soTKColumnVariables.add(new TextVariable("#{b.fiSotk}", hangHoa.getFiSotk() == null ? "" : hangHoa.getFiSotk()));
                    maHSColumnVariables.add(new TextVariable("#{b.fiMaHs}", hangHoa.getFiMaHs() == null ? "" : hangHoa.getFiMaHs()));
                    kieuColumnVariables.add(new TextVariable("#{b.fiKieu}", hangHoa.getFiKieu() == null ? "" : hangHoa.getFiKieu()));

                    thongTinNhaSX = new ArrayList<Variable>();
                    thongTinNhaSX.add(new TextVariable("#{b.thongTinNhaSX}", hangHoa.getFiTenNsx() == null ? "" : hangHoa.getFiTenNsx()));
                    thongTinNhaSX.add(new TextVariable("#{b.thongTinNhaSX}", hangHoa.getFiTenQg() == null ? "" : hangHoa.getFiTenQg()));
                    thongTinNSXVariables.add(new BulletListVariable("#{b.thongTinNhaSX}", thongTinNhaSX));

                    thongTinDacTKT = new ArrayList<Variable>();
                    thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", hangHoa.getFiKyhieu() == null ? "" : "- " + hangHoa.getFiKyhieu()));
                    thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", hangHoa.getFiPhamvido() == null ? "" : "- " + hangHoa.getFiPhamvido()));
                    thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", hangHoa.getFiCapCx() == null ? "" : "- " + hangHoa.getFiCapCx()));
                    thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", hangHoa.getFiDactinhKt() == null ? "" : "- " + hangHoa.getFiDactinhKt()));
                    dacTinhKTVariables.add(new BulletListVariable("#{b.thongTinDacTinhKT}", thongTinDacTKT));

                    //soSXColumnVariables.add(new TextVariable("#{b.fiSoSx}", hangHoa.getFiSoSx() == null ? "" : hangHoa.getFiSoSx()));
                    ghiChuColumnVariables.add(new TextVariable("#{b.fiGhiChu}", hangHoa.getFiGhiChu() == null ? "" : hangHoa.getFiGhiChu()));
                }
            }
            hanghoaTableVariable.addVariable(sttClmnVariables);
            hanghoaTableVariable.addVariable(tenHHColumnVariables);
            hanghoaTableVariable.addVariable(soTKColumnVariables);
            hanghoaTableVariable.addVariable(maHSColumnVariables);
            hanghoaTableVariable.addVariable(kieuColumnVariables);
            hanghoaTableVariable.addVariable(thongTinNSXVariables);
            hanghoaTableVariable.addVariable(dacTinhKTVariables);
//            hanghoaTableVariable.addVariable(soSXColumnVariables);
            hanghoaTableVariable.addVariable(ghiChuColumnVariables);
            variables.addTableVariable(hanghoaTableVariable);

            //Fill file dinh kem
            List<Tbddinhkem3> lstFiles = hoso.getTepDinhKems();
            TableVariable fileDinhKemTableVariable = new TableVariable();
            List<Variable> tenLoaiFileColumnVariables = new ArrayList<Variable>();
            List<Variable> tenFileColumnVariables = new ArrayList<Variable>();

            if (lstFiles == null || lstFiles.isEmpty()) {
                tenLoaiFileColumnVariables.add(new TextVariable("#{loaifile}", ""));
                tenFileColumnVariables.add(new TextVariable("#{tenfile}", ""));
            } else {
                for (Tbddinhkem3 dinhKem : lstFiles) {
                    tenLoaiFileColumnVariables.add(new TextVariable("#{loaifile}", dinhKem.getFiTenLoai()));
                    tenFileColumnVariables.add(new TextVariable("#{tenfile}", dinhKem.getFiTenTep()));
                }
            }

            fileDinhKemTableVariable.addVariable(tenLoaiFileColumnVariables);
            fileDinhKemTableVariable.addVariable(tenFileColumnVariables);
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
//        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_OWNER) + fiHoso + "/" + getUsername());
//        return json != null && Boolean.parseBoolean(json.getData().toString());
        return true;
    }

}
