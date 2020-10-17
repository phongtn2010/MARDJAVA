package com.vnsw.ws.p11.service;

import java.nio.charset.Charset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p11.common.Constants11;
import com.vnsw.ws.p11.entity.db.Tbdhoso11;
import com.vnsw.ws.p11.entity.json.RegistrationConfirm;
import com.vnsw.ws.p11.envelop.Body11;
import com.vnsw.ws.p11.envelop.Content11;
import com.vnsw.ws.p11.envelop.Envelope11;
import com.vnsw.ws.p11.envelop.Error11;
import com.vnsw.ws.p11.envelop.Header11;
import com.vnsw.ws.p11.message.receive.PhytosanitaryCer;
import com.vnsw.ws.p11.message.receive.PhytosanitaryCerInfoRequest;
import com.vnsw.ws.p11.message.receive.PhytosanitaryFee;
import com.vnsw.ws.p11.message.receive.PhytosanitaryFeeResponse;
import com.vnsw.ws.p11.message.receive.PhytosanitaryProcess;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseCancel;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseEdit;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseEditCer;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResult;
import com.vnsw.ws.util.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * Xử lý bản tin của thủ tục 11 cua MARD
 */
@Service("receiveService11")
public class ReceiveService11Impl implements ReceiveService11 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService11Impl.class);

    private static final String CLASS_NAME = "ReceiveService11Impl";
    
    @Autowired
    private EnvelopXmlService11 convertXmlService;
    
    @Autowired
    private EnvelopeService11 envelopeService;
    
    @Autowired
    RabbitMQService rabbitMQService;
    
    @Autowired
    BackendService11 backendService;

    @Override
    public Envelope11 receive(String xml) {
        Envelope11 envelopReturn = null;
        Error11 error = null;
        String type = "00";
        String maHoso = "00";
        String errorMsg = null;
        if (xml == null || "".equals(xml)) {
            error = new Error11();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD11, type, error);
        } else {
            try {
                ValidateXSDHelper validator = new ValidateXSDHelper();
                Envelope11 envelop = (Envelope11) convertXmlService.xmlToEnvelope(xml);
                Header11 header;
                Content11 ct;
                String function;
                ResponseJson json;
                type = getType(envelop);
                function = getFunction(envelop);
                maHoso = envelop.getHeader().getSubject().getReference();
                header = envelopeService.createReceiveHeader(maHoso, Constants.MARD_PRO.MARD11, type,
                        Constants.FUNCTION.FUNC_SUCCESS);
                ct = envelop.getBody().getContent();
                // Validate xml
                errorMsg = validator.validateWithStringXML(xml, Constants.MARD_PRO.MARD11 + type + function + ".xsd");
                Long status = -1L;
                if (errorMsg == null) {
                    json = new ResponseJson(false, null, 0L, "");
                    switch (type) {
                        case Constants11.MARD11_TYPE.TYPE_12: // Trả kết quả thẩm định hồ sơ
                            PhytosanitaryResult phytosanitaryResult = ct.getPhytosanitaryResult();
                            if (phytosanitaryResult != null) {
                                if (Constants11.MARD11_FUNCTION.FUNCTION_05.equals(function)) { // Từ chối hồ sơ
                                    status = Constants11.HosoStatus.BI_TU_CHOI;
                                } else if (Constants11.MARD11_FUNCTION.FUNCTION_06.equals(function)) { // Yêu cầu sửa đổi bổ sung
                                    status = Constants11.HosoStatus.YEU_CAU_BO_SUNG;    
                                } 
                                // Cap nhat KQ tham dinh. Gom cap nhat trang thai ho so, them KQ tham dinh, lich su
                                phytosanitaryResult.setFiTrangthai(status);
                                json = backendService.updateKqtd(phytosanitaryResult);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_13: // Thông báo xác nhận đơn đăng ký kiểm dịch thực vật
                            Tbdhoso11 phytosanitary = ct.getTbdhoso11();
                            if(phytosanitary !=null){
                                RegistrationConfirm confirm = new RegistrationConfirm();
                                confirm.setFiMaHoso(maHoso);
                                confirm.setFiNgaykyBnn(phytosanitary.getFiNgaykyBnn());
                                confirm.setFiNguoikyBnn(phytosanitary.getFiNguoikyBnn());
                                confirm.setFiSoVaoso(phytosanitary.getFiSovaoso());
                                json = backendService.updateXacNhanDon(confirm);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_15: // Đồng ý/ Từ chối yêu cầu chỉnh sửa hồ sơ
                            PhytosanitaryResponseEdit phytosanitaryResponseEdit = ct.getPhytosanitaryResponseEdit();
                            if(phytosanitaryResponseEdit !=null){
                                if (Constants11.MARD11_FUNCTION.FUNCTION_09.equals(function)) { // Đồng ý yêu cầu xin sửa hồ sơ
                                    status = Constants11.HosoStatus.DONG_Y_YCCS;
                                } else if (Constants11.MARD11_FUNCTION.FUNCTION_10.equals(function)) { // Từ chối yêu cầu xin sửa hồ sơ
                                    status = Constants11.HosoStatus.TU_CHOI_YCCS;
                                }
                                phytosanitaryResponseEdit.setFiTrangthai(status);
                                json = backendService.updateKQXinSuaHS(phytosanitaryResponseEdit);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_17: // Đồng ý/ Từ chối yêu cầu xin rút hồ sơ
                            PhytosanitaryResponseCancel phytosanitaryResponseCancel = ct.getPhytosanitaryResponseCancel();
                            if(phytosanitaryResponseCancel !=null){
                                if (Constants11.MARD11_FUNCTION.FUNCTION_12.equals(function)) { // Đồng ý yêu cầu rút hồ sơ
                                    status = Constants11.HosoStatus.DONG_Y_YC_XIN_RUT;
                                } else if (Constants11.MARD11_FUNCTION.FUNCTION_13.equals(function)) { // Từ chối yêu cầu rut hồ sơ
                                    status = Constants11.HosoStatus.TU_CHOI_YC_XIN_RUT;
                                }
                                phytosanitaryResponseCancel.setFiTrangthai(status);
                                // Cap nhat lich su theo trang thai
                                json = backendService.updateKQXinRutHS(phytosanitaryResponseCancel);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_18: // Thông báo áp phí
                            PhytosanitaryFee phytosanitaryFee = ct.getPhytosanitaryFee();
                            if(phytosanitaryFee !=null){
                                // Cap nhat lich su theo trang thai
                                 json = backendService.tbApPhi(phytosanitaryFee);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_20: // Yêu cầu thanh toán bổ sung
                            PhytosanitaryFeeResponse phytosanitaryFeeResponse = ct.getPhytosanitaryFeeResponse();
                            if(phytosanitaryFeeResponse !=null){
                                // Cap nhat lich su theo trang thai
                                json = backendService.tbApPhiBoSung(phytosanitaryFeeResponse);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_21: // Thông báo Giấy Chứng nhận kiểm dịch thực vật
                            PhytosanitaryCer phytosanitaryCer = ct.getPhytosanitaryCer();
                            if(phytosanitaryCer !=null ){
                                // Cap nhat lich su theo trang thai
                                json = backendService.tbGiayCN(phytosanitaryCer);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_22: // Đề nghị cung cấp thông tin Giấy chứng nhận
                            PhytosanitaryCerInfoRequest phytosanitaryCerInfoRequest = ct.getPhytosanitaryCerInfoRequest();
                            if(phytosanitaryCerInfoRequest !=null ){
                                json = backendService.denghiguiGCN(phytosanitaryCerInfoRequest);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_25: // Thông báo từ chối yêu cầu sửa giấy CNKD
                            PhytosanitaryResponseEditCer phytosanitaryResponseEditCer = ct.getPhytosanitaryResponseEditCer();
                            if(phytosanitaryResponseEditCer !=null){
                                 json = backendService.updateKQXinSuaGCN(phytosanitaryResponseEditCer);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        case Constants11.MARD11_TYPE.TYPE_26: // Thông báo xử lý lô hàng
                            PhytosanitaryProcess phytosanitaryProcess = ct.getPhytosanitaryProcess();
                            if(phytosanitaryProcess !=null ){
                                json = backendService.lohangcanXL(phytosanitaryProcess);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD11, header, json);
                            break;
                        default:
                            error = new Error11();
                            error.setErrorCode(Constants.ERROR.ERR04_CODE);
                            error.setErrorName(Constants.ERROR.ERR04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD11, type, error);
                            break;
                    }
                } else {
                    error = new Error11();
                    error.setErrorCode(Constants.ERROR.ERR02_CODE);
                    error.setErrorName(errorMsg);
                    envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD11, type, error);
                }
            } catch (Exception ex) {
                error = new Error11();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(Constants.ERROR.ERR02);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD11, type, error);

                String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                        + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                        + Constants.MESSAGE_SEPARATOR + ex.toString();
                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            }
        }
        return envelopReturn;
    }

    /**
     * Goi ham POST, PUT de Them moi, cap nhat du lieu
     *
     * @param url
     * @param object
     * @param method
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes"})
    @Override
    public ResponseJson callResforEntity(String url, Object object, String method) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            //restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity responseEntity = null;
            if ("POST".equals(method)) {
                responseEntity = restTemplate.postForEntity(url, object, ResponseJson.class);
            } else if ("PUT".equals(method)) {
                restTemplate.put(url, object);
            } else if ("DELETE".equals(method)) {
                restTemplate.delete(url);
            }
            if (responseEntity != null) {
                ResponseJson responJson = (ResponseJson) responseEntity.getBody();
                return responJson;
            }
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }
    
    /**
     * Tạo Envelope11
     *
     * @param xml
     * @param header
     * @param json
     * @return
     */
    private Envelope11 createEnvelopReturn(String fiMaHoSo, String msgType, Header11 header, ResponseJson json) {
        Envelope11 envelop;
        if (json.isSuccess()) {
            Content11 content = new Content11();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body11 body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error11 error = new Error11();
            error.setErrorCode(Constants.ERROR.BNN11_CODE);
            String erroInfo = Constants.ERROR.BNN11;
            if(json.getMessage()!=null && !"".equals(json.getMessage())){
                erroInfo += ": " + json.getMessage();
            }
            error.setErrorName(erroInfo);
            envelop = envelopeService.createEnvelopeError(fiMaHoSo, Constants.MARD_PRO.MARD11, msgType, error);
        }
        return envelop;
    }

    /**
     * Lấy type
     *
     * @param envelop
     * @return
     */
    private String getType(Envelope11 envelop) {
        return envelop.getHeader().getSubject().getType();
    }

    /**
     * Lấy function
     *
     * @param envelop
     * @return
     */
    private String getFunction(Envelope11 envelop) {
        return envelop.getHeader().getSubject().getFunction();
    }
}
