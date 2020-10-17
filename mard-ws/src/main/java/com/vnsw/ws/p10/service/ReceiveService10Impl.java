package com.vnsw.ws.p10.service;

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
import com.vnsw.ws.p10.common.Constants10;
import com.vnsw.ws.p10.entity.db.Tbdhoso10;
import com.vnsw.ws.p10.entity.json.RegistrationConfirm;
import com.vnsw.ws.p10.envelop.Body10;
import com.vnsw.ws.p10.envelop.Content10;
import com.vnsw.ws.p10.envelop.Envelope10;
import com.vnsw.ws.p10.envelop.Error10;
import com.vnsw.ws.p10.envelop.Header10;
import com.vnsw.ws.p10.message.receive.AnimalIsolationList;
import com.vnsw.ws.p10.message.receive.AnimalProcessed;
import com.vnsw.ws.p10.message.receive.AnimalProductsIsolationList;
import com.vnsw.ws.p10.message.receive.AnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.FoodAnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.ProcessVSTYList;
import com.vnsw.ws.p10.message.receive.ProductAnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.QuarantineCancelResponse;
import com.vnsw.ws.p10.message.receive.QuarantineCerEditResponse;
import com.vnsw.ws.p10.message.receive.QuarantineCerEditResponseList;
import com.vnsw.ws.p10.message.receive.QuarantineEditResponse;
import com.vnsw.ws.p10.message.receive.QuarantineFee;
import com.vnsw.ws.p10.message.receive.QuarantineFeeResponse;
import com.vnsw.ws.p10.message.receive.QuarantineResult;
import com.vnsw.ws.p10.message.receive.RegistrationList;
import com.vnsw.ws.util.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Xử lý bản tin của thủ tục 10 cua MARD
 */
@Service("receive10Service")
public class ReceiveService10Impl implements ReceiveService10 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService10Impl.class);

    private static final String CLASS_NAME = "ReceiveEndpoint01Impl";
    
    @Autowired
    private EnvelopXmlService10 convertXmlService;
    
    @Autowired
    private EnvelopeService10 envelopeService;
    
    @Autowired
    RabbitMQService rabbitMQService;
    
    @Autowired
    BackendService10 backendService;

    @Override
    public Envelope10 receive(String xml) {
        Envelope10 envelopReturn = null;
        Error10 error = null;
        String type = "00";
        String maHoso = "00";
        String errorMsg = null;
        if (xml == null || "".equals(xml)) {
            error = new Error10();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD10, type, error);
        } else {
            try {
                ValidateXSDHelper validator = new ValidateXSDHelper();
                Envelope10 envelop = (Envelope10) convertXmlService.xmlToEnvelope(xml);
                Header10 header;
                Content10 ct;
                String function;
                ResponseJson json;
                type = getType(envelop);
                function = getFunction(envelop);
                maHoso = envelop.getHeader().getSubject().getReference();
                header = envelopeService.createReceiveHeader(maHoso, Constants.MARD_PRO.MARD10, type,
                        Constants.FUNCTION.FUNC_SUCCESS);
                ct = envelop.getBody().getContent();
                // Validate xml
                errorMsg = validator.validateWithStringXML(xml, Constants.MARD_PRO.MARD10 + type + function + ".xsd");
                Long status = -1L;
                if (errorMsg == null) {
                    json = new ResponseJson(false, null, 0L, "");
                    switch (type) {
                        case Constants10.MARD10_TYPE.TYPE_12: // Trả kết quả thẩm định hồ sơ
                            QuarantineResult quarantineResult = ct.getQuarantineResult();
                            if (quarantineResult != null) {
                                if (Constants10.MARD10_FUNCTION.FUNCTION_05.equals(function)) { // Đã tiếp nhận hồ sơ
                                    status = Constants10.HosoStatus.DA_TIEP_NHAN;
                                } else if (Constants10.MARD10_FUNCTION.FUNCTION_06.equals(function)) { // Từ chối hồ sơ
                                    status = Constants10.HosoStatus.BI_TU_CHOI;    
                                } else if (Constants10.MARD10_FUNCTION.FUNCTION_07.equals(function)) { // Yêu cầu sửa đổi bổ sung
                                    status = Constants10.HosoStatus.YEU_CAU_BO_SUNG;
                                }
                                // Cap nhat KQ tham dinh. Gom cap nhat trang thai ho so, them KQ tham dinh, lich su
                                quarantineResult.setFiTrangthai(status);
                                json = backendService.updateKqtd(quarantineResult);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_13: // Xác nhận Đơn khai báo kiểm dịch
                            RegistrationList registrationList = ct.getRegistrationList();
                            if(registrationList !=null && registrationList.getRegistration() !=null && 
                                    registrationList.getRegistration() .size() > 0){
                                List<RegistrationConfirm> lstConfirm = new ArrayList<>();
                                RegistrationConfirm confirm;
                                // Duyet tung don
                                for(Tbdhoso10 hoso10 : registrationList.getRegistration()){
                                    confirm = new RegistrationConfirm();
                                    confirm.setFiMaHoso(hoso10.getFiMaHoso());
                                    confirm.setFiSoVaoso(hoso10.getFiSoVaoso());
                                    confirm.setFiXnDdkd(hoso10.getFiXnDdkd());
                                    confirm.setFiXnNgayky(hoso10.getFiXnNgayky());
                                    confirm.setFiXnNguoiky(hoso10.getFiXnNguoiky());
                                    confirm.setFiXnNoiky(hoso10.getFiXnNoiky());
                                    confirm.setFiXnTgkd(hoso10.getFiXnTgkd());
                                    lstConfirm.add(confirm);
                                }
                                json = backendService.updateXacNhanDon(lstConfirm);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_15: // Đồng ý/ Từ chối yêu cầu xin rút hồ sơ
                            QuarantineCancelResponse quarantineCancelResponse = ct.getQuarantineCancelResponse();
                            if(quarantineCancelResponse !=null){
                                if (Constants10.MARD10_FUNCTION.FUNCTION_10.equals(function)) { // Đồng ý yêu cầu xin rút hồ sơ
                                    status = Constants10.HosoStatus.DONG_Y_YC_XIN_RUT;
                                } else if (Constants10.MARD10_FUNCTION.FUNCTION_11.equals(function)) { // Từ chối yêu cầu xin rút hồ sơ
                                    status = Constants10.HosoStatus.TU_CHOI_YC_XIN_RUT;
                                }
                                quarantineCancelResponse.setFiTrangthai(status);
                                json = backendService.updateKQXinRutHS(quarantineCancelResponse);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_17: // Đồng ý/ Từ chối yêu cầu xin sửa hồ sơ
                            QuarantineEditResponse quarantineEditResponse = ct.getQuarantineEditResponse();
                            if(quarantineEditResponse !=null){
                                if (Constants10.MARD10_FUNCTION.FUNCTION_13.equals(function)) { // Đồng ý yêu cầu sửa hồ sơ
                                    status = Constants10.HosoStatus.DONG_Y_YCCS;
                                } else if (Constants10.MARD10_FUNCTION.FUNCTION_14.equals(function)) { // Từ chối yêu cầu sửa hồ sơ
                                    status = Constants10.HosoStatus.TU_CHOI_YCCS;
                                }
                                quarantineEditResponse.setFiTrangthai(status);
                                // Cap nhat lich su theo trang thai
                                json = backendService.updateKQXinSuaHS(quarantineEditResponse);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_18: // Thông báo áp phí
                            QuarantineFee quarantineFee = ct.getQuarantineFee();
                            if(quarantineFee !=null){
                                // Cap nhat lich su theo trang thai
                                 json = backendService.tbApPhi(quarantineFee);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_20: // Yêu cầu thanh toán bổ sung
                            QuarantineFeeResponse quarantineFeeResponse = ct.getQuarantineFeeResponse();
                            if(quarantineFeeResponse !=null){
                                // Cap nhat lich su theo trang thai
                                json = backendService.tbApPhiBoSung(quarantineFeeResponse);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_21: // Lô hàng cần xử lý
                            AnimalProcessed animalProcessed = ct.getAnimalProcessed();
                            if(animalProcessed !=null ){
                                // Cap nhat lich su theo trang thai
                                json = backendService.lohangcanXL(animalProcessed);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_22: // Quyết định xử lý vệ sinh thú y (mẫu 9)
                            ProcessVSTYList processVSTYList = ct.getProcessVSTYList();
                            if(processVSTYList !=null && processVSTYList.getProcessVSTY() !=null 
                                    && processVSTYList.getProcessVSTY().size() > 0){
                                json = backendService.XLMau9(processVSTYList);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_23: // Giấy chứng nhận vận chuyển động vật nhập khẩu về nơi cách ly kiểm dịch (mẫu 14a)
                            AnimalIsolationList animalIsolationList = ct.getAnimalIsolationList();
                            if(animalIsolationList !=null && animalIsolationList.getAnimalIsolation()!=null 
                                    && animalIsolationList.getAnimalIsolation().size() > 0){
                                 json = backendService.XLMau14A(animalIsolationList);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_24: // Giấy chứng nhận vận chuyển Sản phẩm động vật nhập khẩu về nơi cách ly kiểm dịch (mẫu 14b)
                            AnimalProductsIsolationList animalProductsIsolationList = ct.getAnimalProductsIsolationList();
                            if(animalProductsIsolationList !=null && animalProductsIsolationList.getAnimalProductsIsolation() !=null 
                                    && animalProductsIsolationList.getAnimalProductsIsolation().size() > 0){
                                json = backendService.XLMau14B(animalProductsIsolationList);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_25: // Giấy chứng nhận Kiểm dịch động vật nhập khẩu (mẫu 15a)
                            AnimalQuarantineList animalQuarantineList = ct.getAnimalQuarantineList();
                            if(animalQuarantineList !=null && animalQuarantineList.getAnimalQuarantine() !=null 
                                    && animalQuarantineList.getAnimalQuarantine().size() > 0){
                                json = backendService.XLMau15A(animalQuarantineList);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_26: // Giấy chứng nhận Kiểm dịch sản phẩm động vật nhập khẩu không làm thực phẩm (mẫu 15b)
                            ProductAnimalQuarantineList productAnimalQuarantineList = ct.getProductAnimalQuarantineList();
                            if(productAnimalQuarantineList !=null && productAnimalQuarantineList.getProductAnimalQuarantine() !=null 
                                    && productAnimalQuarantineList.getProductAnimalQuarantine().size() > 0){
                                json = backendService.XLMau15B(productAnimalQuarantineList);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_27: // Giấy chứng nhận kiểm dịch và vệ sinh ATTP Sản phẩm động vật nhập khẩu dùng làm thực phẩm (mẫu15c)
                            FoodAnimalQuarantineList foodAnimalQuarantineList = ct.getFoodAnimalQuarantineList();
                            if(foodAnimalQuarantineList !=null && foodAnimalQuarantineList.getFoodAnimalQuarantine() !=null 
                                    && foodAnimalQuarantineList.getFoodAnimalQuarantine().size() > 0){
                                json = backendService.XLMau15C(foodAnimalQuarantineList);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        case Constants10.MARD10_TYPE.TYPE_29: // Từ chối yêu cầu sửa Giấy chứng nhận
                            QuarantineCerEditResponseList quarantineCerEditResponseList = ct.getQuarantineCerEditResponseList();
                            if(quarantineCerEditResponseList !=null){
                                List<QuarantineCerEditResponse> listItem = quarantineCerEditResponseList.getQuarantineCerEditResponse();
                                // Cap nhat trang thai ho so, lich su
                                //TODO: fix tam de demo, can sua lai khi truyen sang backend
                                if(listItem != null) {
                                    for(QuarantineCerEditResponse qCertItem : listItem) {
                                        json = backendService.updateKQXinSuaGCN(qCertItem);
                                    }
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD10, header, json);
                            break;
                        default:
                            error = new Error10();
                            error.setErrorCode(Constants.ERROR.ERR04_CODE);
                            error.setErrorName(Constants.ERROR.ERR04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD10, type, error);
                            break;
                    }
                } else {
                    error = new Error10();
                    error.setErrorCode(Constants.ERROR.ERR02_CODE);
                    error.setErrorName(errorMsg);
                    envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD10, type, error);
                }
            } catch (Exception ex) {
                error = new Error10();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(Constants.ERROR.ERR02);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD10, type, error);

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
     * Tạo Envelope10
     *
     * @param xml
     * @param header
     * @param json
     * @return
     */
    private Envelope10 createEnvelopReturn(String fiMaHoSo, String msgType, Header10 header, ResponseJson json) {
        Envelope10 envelop;
        if (json.isSuccess()) {
            Content10 content = new Content10();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body10 body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error10 error = new Error10();
            error.setErrorCode(Constants.ERROR.BNN10_CODE);
            String erroInfo = Constants.ERROR.BNN10;
            if(json.getMessage()!=null && !"".equals(json.getMessage())){
                erroInfo += ": " + json.getMessage();
            }
            error.setErrorName(erroInfo);
            envelop = envelopeService.createEnvelopeError(fiMaHoSo, Constants.MARD_PRO.MARD10, msgType, error);
        }
        return envelop;
    }

    /**
     * Lấy type
     *
     * @param envelop
     * @return
     */
    private String getType(Envelope10 envelop) {
        return envelop.getHeader().getSubject().getType();
    }

    /**
     * Lấy function
     *
     * @param envelop
     * @return
     */
    private String getFunction(Envelope10 envelop) {
        return envelop.getHeader().getSubject().getFunction();
    }
}
