/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p10.common.Constants10;
import com.vnsw.ws.p10.entity.json.RegistrationConfirm;
import com.vnsw.ws.p10.message.receive.AnimalIsolationList;
import com.vnsw.ws.p10.message.receive.AnimalProcessed;
import com.vnsw.ws.p10.message.receive.AnimalProductsIsolationList;
import com.vnsw.ws.p10.message.receive.AnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.FoodAnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.ProcessVSTYList;
import com.vnsw.ws.p10.message.receive.ProductAnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.QuarantineCancelResponse;
import com.vnsw.ws.p10.message.receive.QuarantineCerEditResponse;
import com.vnsw.ws.p10.message.receive.QuarantineEditResponse;
import com.vnsw.ws.p10.message.receive.QuarantineFee;
import com.vnsw.ws.p10.message.receive.QuarantineFeeResponse;
import com.vnsw.ws.p10.message.receive.QuarantineResult;
import com.vnsw.ws.p10.bo.UpdateStatusBO;
import com.vnsw.ws.util.Constants;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("backendService10")
public class BackendService10Impl implements BackendService10 {

    private static final String CLASS_NAME = "BackendServiceImpl";

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    ReceiveService10 receiveService;

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
    public ResponseJson updateHoSoStatus(String fiMaHoso, Long fiTrangthai, String fiLydo) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_UPDATE_STATUS_HOSO;
            UpdateStatusBO obj = new UpdateStatusBO();
            obj.setFiMaHoso(fiMaHoso);
            obj.setFiTrangthai(fiTrangthai);
            obj.setFiLydo(fiLydo);
            responJson = receiveService.callResforEntity(restUri, obj, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }
    
    @Override
    public ResponseJson xinSuaGCN(String fiMaHoso, Long fiTrangthai, String fiLydo, Long loaiGCN) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_UPDATE_STATUS_HOSO;
            UpdateStatusBO obj = new UpdateStatusBO();
            obj.setFiMaHoso(fiMaHoso);
            obj.setFiTrangthai(fiTrangthai);
            obj.setFiLydo(fiLydo);
            obj.setFiLoaiGCN(loaiGCN);
            responJson = receiveService.callResforEntity(restUri, obj, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateLichSuSend(String fiMaHoso, Long fiTrangthai) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_UPDATE_LICHSU;
            UpdateStatusBO obj = new UpdateStatusBO();
            obj.setFiMaHoso(fiMaHoso);
            obj.setFiTrangthai(fiTrangthai);
            responJson = receiveService.callResforEntity(restUri, obj, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKqtd(QuarantineResult result) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_UPDATE_KQTD;
            responJson = receiveService.callResforEntity(restUri, result, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateXacNhanDon(List<RegistrationConfirm> lstConfirm) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_UPDATE_XAC_ND;
            responJson = receiveService.callResforEntity(restUri, lstConfirm, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKQXinRutHS(QuarantineCancelResponse response) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_KQ_XIN_RUT_HS;
            responJson = receiveService.callResforEntity(restUri, response, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKQXinSuaHS(QuarantineEditResponse response) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_KQ_XIN_SUA_HS;
            responJson = receiveService.callResforEntity(restUri, response, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * Cap nhat thong bao ap phi
     *
     * @param feeNotice
     * @return
     */
    @Override
    public ResponseJson tbApPhi(QuarantineFee feeNotice) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_TB_AP_PHI;
            responJson = receiveService.callResforEntity(restUri, feeNotice, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * Cap nhat thong bao ap phi bo sung
     *
     * @param feeResponse
     * @return
     */
    @Override
    public ResponseJson tbApPhiBoSung(QuarantineFeeResponse feeResponse) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_TB_AP_PHI_BS;
            responJson = receiveService.callResforEntity(restUri, feeResponse, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * Thong bao lo hang can xu ly
     * @param animalProcessed
     * @return
     */
    @Override
    public ResponseJson lohangcanXL(AnimalProcessed animalProcessed) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_TB_LOHANG_CAN_XL;
            responJson = receiveService.callResforEntity(restUri, animalProcessed, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * Xử lý vệ sinh thú y mẫu 09
     * @param processVSTYList
     * @return
     */
    @Override
    public ResponseJson XLMau9(ProcessVSTYList processVSTYList) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_XL_MAU_9;
            responJson = receiveService.callResforEntity(restUri, processVSTYList, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * Xử lý cách ly ĐVNK theo mẫu 14A
     * @param animalIsolationList
     * @return
     */
    @Override
    public ResponseJson XLMau14A(AnimalIsolationList animalIsolationList) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_XL_MAU_14A;
            responJson = receiveService.callResforEntity(restUri, animalIsolationList, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * Xử lý cách ly ĐVNK theo mẫu 14B
     * @param animalProductsIsolationList
     * @return
     */
    @Override
    public ResponseJson XLMau14B(AnimalProductsIsolationList animalProductsIsolationList) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_XL_MAU_14B;
            responJson = receiveService.callResforEntity(restUri, animalProductsIsolationList, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * Xử lý cách ly ĐVNK theo mẫu 15A
     * @param animalQuarantineList
     * @return
     */
    @Override
    public ResponseJson XLMau15A(AnimalQuarantineList animalQuarantineList) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_XL_MAU_15A;
            responJson = receiveService.callResforEntity(restUri, animalQuarantineList, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * GCN SPĐV koTP 15b
     * @param productAnimalQuarantineList
     * @return
     */
    @Override
    public ResponseJson XLMau15B(ProductAnimalQuarantineList productAnimalQuarantineList) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_XL_MAU_15B;
            responJson = receiveService.callResforEntity(restUri, productAnimalQuarantineList, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    /**
     * GCN SPĐVLamTP 15c
     * @param foodAnimalQuarantineList
     * @return
     */
    @Override
    public ResponseJson XLMau15C(FoodAnimalQuarantineList foodAnimalQuarantineList) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_XL_MAU_15C;
            responJson = receiveService.callResforEntity(restUri, foodAnimalQuarantineList, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }
    
    /**
     * Cập nhật KQ xin sửa giấy chứng nhận
     * @param response
     * @return
    */
    @Override
    public ResponseJson updateKQXinSuaGCN(QuarantineCerEditResponse response) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URI_KQ_XIN_SUA_GCN;
            responJson = receiveService.callResforEntity(restUri, response, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

}
