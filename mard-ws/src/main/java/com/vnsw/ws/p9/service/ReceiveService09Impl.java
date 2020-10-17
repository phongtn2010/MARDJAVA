package com.vnsw.ws.p9.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p9.common.Constants09;
import com.vnsw.ws.p9.envelop.Error;
import com.vnsw.ws.p9.envelop.*;
import com.vnsw.ws.p9.message.ResponseWrapper;
import com.vnsw.ws.p9.message.receive.*;
import com.vnsw.ws.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Xử lý bản tin của thủ tục 09 cua MARD
 */
@Service("receive09Service")
public class ReceiveService09Impl implements ReceiveService09 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService09Impl.class);

    private static final String CLASS_NAME = "ReceiveEndpoint09Impl";
    
    @Autowired
    private EnvelopXmlService09 convertXmlService;
    
    @Autowired
    private EnvelopeService09 envelopeService;
    
    @Autowired
    RabbitMQService rabbitMQService;
    
    @Autowired
    BackendService09 backendService;

    @Override
    public Envelope09 receive(String xml) {
        Envelope09 envelopReturn = null;
        Error error = null;
        String type = "00";
        String maHoso = "00";
        String errorMsg = null;

        logger.debug("Receive " + this.getClass().getSimpleName() + ": " + xml);

        if (xml == null || "".equals(xml)) {
            error = new Error();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD09, type, error);
        } else {
            try {
                Envelope09 envelop = (Envelope09) convertXmlService.xmlToEnvelope(xml);
                Header header;
                Content ct;
                String function;
                Subject subject;
                ResponseJson json;
                type = getType(envelop);
                function = getFunction(envelop);
                maHoso = envelop.getHeader().getSubject().getReference();
                subject = envelop.getHeader().getSubject();
                header = envelopeService.createReceiveHeader(maHoso, Constants.MARD_PRO.MARD09, type,
                        Constants.FUNCTION.FUNC_SUCCESS);
                ct = envelop.getBody().getContent();
                // Validate xml
                ValidateXSDHelper validator = new ValidateXSDHelper();
                errorMsg = validator.validateWithStringXML(xml, "p09/" + Constants.MARD_PRO.MARD09 + type + function + ".xsd");
                Long status = -1L;

                if (errorMsg == null) {
                    json = new ResponseJson(false, null, 0L, "");
                    switch (type) {
                        case Constants09.MARD09_TYPE.TYPE_11: // Trả kết quả thẩm định hồ sơ
                            KetQuaThamDinh ketQuaThamDinh = ct.getKetQuaThamDinh();
                            if (ketQuaThamDinh != null) {
                                if (Constants09.MARD09_FUNCTION.FUNCTION_29.equals(function)) { // Đã tiếp nhận hồ sơ
                                    status = Constants09.HosoStatus.DA_TIEP_NHAN;
                                } else if (Constants09.MARD09_FUNCTION.FUNCTION_05.equals(function)) { // Từ chối hồ sơ
                                    status = Constants09.HosoStatus.TU_CHOI_HO_SO;
                                } else if (Constants09.MARD09_FUNCTION.FUNCTION_06.equals(function)) { // Yêu cầu sửa đổi bổ sung
                                    status = Constants09.HosoStatus.YEU_CAU_BO_SUNG;
                                }
                                json = backendService.updateKqtd(new ResponseWrapper(envelop.getHeader(), ketQuaThamDinh));
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_12:// Xác nhận Đơn đăng ký
                            XacNhanDon xacNhanDon = ct.getXacNhanDon();
                            if (xacNhanDon != null) {
                                json = backendService.updateXacNhanDonDangKy(new ResponseWrapper(envelop.getHeader(), xacNhanDon));
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_14://Phan hoi yeu cau xin sua ho so
                            PhanHoiYCSuaHS phanHoiYCSuaHS = ct.getPhanHoiYCSuaHS();
                            if (phanHoiYCSuaHS != null) {
                                if (Constants09.MARD09_FUNCTION.FUNCTION_09.equals(function)) {
                                    status = Constants09.HosoStatus.DONG_Y_YCS;
                                } else if (Constants09.MARD09_FUNCTION.FUNCTION_10.equals(function)) {
                                    status = Constants09.HosoStatus.TU_CHOI_YCS;
                                }
                                json = backendService.updateKetQuaXinSuaHS(new ResponseWrapper(envelop.getHeader(), phanHoiYCSuaHS));
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_17://Phan hoi yeu cau xin sua ho so
                            PhanHoiYCXinRutHS phanHoiYCXinRutHS = ct.getPhanHoiYCXinRutHS();
                            if (phanHoiYCXinRutHS != null) {
                                if (Constants09.MARD09_FUNCTION.FUNCTION_12.equals(function)) {
                                    status = Constants09.HosoStatus.DONG_Y_YCR;
                                } else if (Constants09.MARD09_FUNCTION.FUNCTION_13.equals(function)) {
                                    status = Constants09.HosoStatus.TU_CHOI_YCR;
                                }
                                json = backendService.updateKetQuaXinRutHS(new ResponseWrapper(envelop.getHeader(), phanHoiYCXinRutHS));
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_18:
                            GiayCNKD giayCNKD = ct.getGiayCNKD();

                            if (giayCNKD != null) {
                                if (Constants09.MARD09_FUNCTION.FUNCTION_14.equals(function)) {
                                    status = Constants09.HosoStatus.DA_CAP_CNKD;
                                } else if (Constants09.MARD09_FUNCTION.FUNCTION_15.equals(function)) {
                                    status = Constants09.HosoStatus.DA_CAP_CNKD;
                                }
                                json = backendService.updateGiayCNKD(new ResponseWrapper(envelop.getHeader(), giayCNKD));
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_25:
                            GiayVanChuyen giayVanChuyen = ct.getGiayVanChuyen();

                            if (giayVanChuyen != null) {
                                json = backendService.updateGiayVanChuyen(new ResponseWrapper(envelop.getHeader(), giayVanChuyen));
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_19:
                            GiayXNCL giayXNCL = ct.getGiayXNCL();

                            if (giayXNCL != null) {
                                if (Constants09.MARD09_FUNCTION.FUNCTION_16.equals(function)) {
                                    status = Constants09.HosoStatus.XNCL_DAT;
                                } else if (Constants09.MARD09_FUNCTION.FUNCTION_17.equals(function)) {
                                    status = Constants09.HosoStatus.XNCL_DAT;
                                }
                                json = backendService.updateGiayXNCL(new ResponseWrapper(envelop.getHeader(), giayXNCL));
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_20:
                            ThongBaoApPhi thongBaoApPhi = ct.getThongBaoApPhi();
                            json = backendService.thongBaoApPhi(new ResponseWrapper(envelop.getHeader(), thongBaoApPhi));
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_21:
                            XacNhanPhi xacNhanPhi = ct.getXacNhanPhi();
                            json = backendService.xacnhanPhi(new ResponseWrapper(envelop.getHeader(), xacNhanPhi));
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_22:
                            ThongBaoApPhiBoXung thongBaoApPhiBoXung = ct.getThongBaoApPhiBoXung();
                            json = backendService.thongbaoApphiBoxung(new ResponseWrapper(envelop.getHeader(), thongBaoApPhiBoXung));
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09,  header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_24:
                            PhanHoiYCSuaGCN phanHoiYCSuaGCN = ct.getPhanHoiYCSuaGCN();
                            json = backendService.phanHoiYeucauSuaGCN(new ResponseWrapper(envelop.getHeader(), phanHoiYCSuaGCN));
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_26:
                            CongVanXNCLKhongDat congVanXNCLKhongDat = ct.getCongVanXNCLKhongDat();
                            json = backendService.nhanCongvanXNCLKhongdat(new ResponseWrapper(envelop.getHeader(), congVanXNCLKhongDat));
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        case Constants09.MARD09_TYPE.TYPE_28:
                            ThongBaoKhongCapGCNKD thongBaoKhongCapGCNKD = ct.getThongBaoKhongCapGCNKD();
                            json = backendService.thongBaoKhongCapCNKD(new ResponseWrapper(envelop.getHeader(), thongBaoKhongCapGCNKD));
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD09, header, json);
                            break;

                        default:
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.ERR04_CODE);
                            error.setErrorName(Constants.ERROR.ERR04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD09, type, error);
                            break;
                    }
                } else {
                    error = new Error();
                    error.setErrorCode(Constants.ERROR.ERR02_CODE);
                    error.setErrorName(errorMsg);
                    envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD09, type, error);
                }
            } catch (Exception ex) {
                logger.debug("error:", ex);
                error = new Error();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(Constants.ERROR.ERR02);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD09, type, error);

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
     * @param header
     * @param json
     * @return
     */
    private Envelope09 createEnvelopReturn(String fiMaHoSo, String msgType, Header header, ResponseJson json) {
        Envelope09 envelop;
        if (json.isSuccess()) {
            Content content = new Content();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error error = new Error();
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
    private String getType(Envelope09 envelop) {
        return envelop.getHeader().getSubject().getType();
    }

    /**
     * Lấy function
     *
     * @param envelop
     * @return
     */
    private String getFunction(Envelope09 envelop) {
        return envelop.getHeader().getSubject().getFunction();
    }
}
