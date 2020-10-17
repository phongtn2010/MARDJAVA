/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p9.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p9.bo.UpdateStatusBO;
import com.vnsw.ws.p9.common.Constants09;
import com.vnsw.ws.p9.envelop.Header;
import com.vnsw.ws.p9.message.ResponseWrapper;
import com.vnsw.ws.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.Charset;


//call sang BE cua HQ
@Service("backendService09")
public class BackendService09Impl implements BackendService09 {

    private static final String CLASS_NAME = "BackendServiceImpl";

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    ReceiveService09 receiveService;

    /**
     * Lay du lieu tu Backend theo Uri
     *
     * @param restUri
     * @return
     */
    @Override
    public ResponseJson getDataFromRestUri(String restUri) {
        ResponseJson responJson = null;
        try {
            URI REST_URL = new URI(restUri);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity responseEntity = restTemplate.getForEntity(REST_URL, ResponseJson.class);
            responJson = (ResponseJson) responseEntity.getBody();
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }

        return responJson;
    }

    @Override
    public ResponseJson updateHoSoStatus(Header header, String fiMaHoso, Long fiTrangthai, String fiLydo) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_STATUS_HOSO;
            UpdateStatusBO obj = new UpdateStatusBO();
            obj.setFiMaHoso(fiMaHoso);
            obj.setFiTrangthai(fiTrangthai);
            obj.setFiLydo(fiLydo);
            ResponseWrapper responseWrapper = new ResponseWrapper(header, obj);
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKqtd(ResponseWrapper result) {
        ResponseJson responJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_KQTD;
            responJson = receiveService.callResforEntity(restUri, result, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            responJson.setSuccess(false);
            responJson.setMessage(ex.getMessage());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateXacNhanDonDangKy(ResponseWrapper xacNhanDon) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_XAC_NHAN_DON_DANG_KY;
            responJson = receiveService.callResforEntity(restUri, xacNhanDon, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKetQuaXinSuaHS(ResponseWrapper phanHoiYCSuaHS) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_KETQUA_XIN_SUA_HS;
            responJson = receiveService.callResforEntity(restUri, phanHoiYCSuaHS, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKetQuaXinRutHS(ResponseWrapper phanHoiYCXinRutHS) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_KETQUA_XIN_RUT_HS;
            responJson = receiveService.callResforEntity(restUri, phanHoiYCXinRutHS, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateGiayCNKD(ResponseWrapper giayCNKD) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_GIAY_CNKD;
            responJson = receiveService.callResforEntity(restUri, giayCNKD, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateGiayVanChuyen(ResponseWrapper giayVanChuyen) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_GIAY_VAN_CHUYEN;
            responJson = receiveService.callResforEntity(restUri, giayVanChuyen, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateGiayXNCL(ResponseWrapper giayXNCL) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_GIAY_XNCL;
            responJson = receiveService.callResforEntity(restUri, giayXNCL, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson thongBaoApPhi(ResponseWrapper thongBaoApPhi) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_THONGBAO_APPHI;
            responJson = receiveService.callResforEntity(restUri, thongBaoApPhi, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson thongbaoApphiBoxung(ResponseWrapper thongBaoApPhiBoXung) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_THONGBAO_APPHI_BOSUNG;
            responJson = receiveService.callResforEntity(restUri, thongBaoApPhiBoXung, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson xacnhanPhi(ResponseWrapper xacNhanPhi) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_XACNHAN_PHI;
            responJson = receiveService.callResforEntity(restUri, xacNhanPhi, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson nhanCongvanXNCLKhongdat(ResponseWrapper congVanXNCLKhongDat) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_NHAN_CV_XNCL_KHONGDAT;
            responJson = receiveService.callResforEntity(restUri, congVanXNCLKhongDat, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson thongBaoKhongCapCNKD(ResponseWrapper thongBaoKhongCapGCNKD) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_TB_KHONGCAP_CNKD;
            responJson = receiveService.callResforEntity(restUri, thongBaoKhongCapGCNKD, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson phanHoiYeucauSuaGCN(ResponseWrapper value) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_PHANHOI_SUA_GCN;
            responJson = receiveService.callResforEntity(restUri, value, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson xinSuaGCN(String fiMaHoso, Long fiTrangthai, String fiLydo, Long loaiGCN, String maGCN) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_UPDATE_STATUS_HOSO;
            UpdateStatusBO obj = new UpdateStatusBO();
            obj.setFiMaHoso(fiMaHoso);
            obj.setFiTrangthai(fiTrangthai);
            obj.setFiLydo(fiLydo);
            obj.setFiLoaiGCN(loaiGCN);
            obj.setFiMaGCN(maGCN);
            responJson = receiveService.callResforEntity(restUri, obj, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

}
