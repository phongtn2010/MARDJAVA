/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p11.common.Constants11;
import com.vnsw.ws.p11.entity.json.RegistrationConfirm;
import com.vnsw.ws.p11.bo.UpdateStatusBO;
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
import java.net.URI;
import java.nio.charset.Charset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("backendService11")
public class BackendService11Impl implements BackendService11 {

    private static final String CLASS_NAME = "BackendServiceImpl";

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    ReceiveService11 receiveService;

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
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_UPDATE_STATUS_HOSO;
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
    public ResponseJson xinSuaGCN(String fiMaHoso, Long fiTrangthai, String fiLydo) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_UPDATE_STATUS_HOSO;
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
    public ResponseJson updateLichSuSend(String fiMaHoso, Long fiTrangthai) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_UPDATE_LICHSU;
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
    public ResponseJson updateKqtd(PhytosanitaryResult  result) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_UPDATE_KQTD;
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
    public ResponseJson updateXacNhanDon(RegistrationConfirm confirm) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_UPDATE_XAC_ND;
            responJson = receiveService.callResforEntity(restUri, confirm, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKQXinRutHS(PhytosanitaryResponseCancel phytosanitaryResponseCancel) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_KQ_XIN_RUT_HS;
            responJson = receiveService.callResforEntity(restUri, phytosanitaryResponseCancel, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKQXinSuaHS(PhytosanitaryResponseEdit phytosanitaryResponseEdit) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_KQ_XIN_SUA_HS;
            responJson = receiveService.callResforEntity(restUri, phytosanitaryResponseEdit, Constants.RES_METHOD.POST);
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
     * @param phytosanitaryFee
     * @return
     */
    @Override
    public ResponseJson tbApPhi(PhytosanitaryFee phytosanitaryFee) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_TB_AP_PHI;
            responJson = receiveService.callResforEntity(restUri, phytosanitaryFee, Constants.RES_METHOD.POST);
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
     * @param phytosanitaryFeeResponse
     * @return
     */
    @Override
    public ResponseJson tbApPhiBoSung(PhytosanitaryFeeResponse phytosanitaryFeeResponse) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_TB_AP_PHI_BS;
            responJson = receiveService.callResforEntity(restUri, phytosanitaryFeeResponse, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }
    
     /**
     * Thong bao giay chung nhan kiem dich thuc vat
     *
     * @param phytosanitaryCer
     * @return
     */
    @Override
    public ResponseJson tbGiayCN(PhytosanitaryCer phytosanitaryCer) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_TB_GCN;
            responJson = receiveService.callResforEntity(restUri, phytosanitaryCer, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }
    
    /**
     * De nghi cung cap thong tin giay chung nhan
     *
     * @param phytosanitaryCerInfoRequest
     * @return
     */
    @Override
    public ResponseJson denghiguiGCN(PhytosanitaryCerInfoRequest phytosanitaryCerInfoRequest) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_DE_NGHI_GUI_GCN;
            responJson = receiveService.callResforEntity(restUri, phytosanitaryCerInfoRequest, Constants.RES_METHOD.POST);
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
     * @param phytosanitaryProcess
     * @return
     */
    @Override
    public ResponseJson lohangcanXL(PhytosanitaryProcess phytosanitaryProcess) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_TB_LOHANG_CAN_XL;
            responJson = receiveService.callResforEntity(restUri, phytosanitaryProcess, Constants.RES_METHOD.POST);
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
     * @param phytosanitaryResponseEditCer
     * @return
    */
    @Override
    public ResponseJson updateKQXinSuaGCN(PhytosanitaryResponseEditCer phytosanitaryResponseEditCer) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URI_KQ_XIN_SUA_GCN;
            responJson = receiveService.callResforEntity(restUri, phytosanitaryResponseEditCer, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

}
