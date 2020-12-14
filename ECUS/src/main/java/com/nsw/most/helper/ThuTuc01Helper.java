/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.helper;

import com.nsw.most.p01.model.Tbddinhkem1;
import com.nsw.most.p01.model.SearchFormLichsu01;
import com.nsw.most.p01.model.Tbdhoso1;
import com.nsw.most.p01.model.TbdkqdgHh1;
import com.nsw.most.p01.model.Tbdlichsu1;
import com.nsw.most.p01.model.TbdkqktHh1;
import com.nsw.most.p01.model.SearchForm;
import com.nsw.most.p01.model.SendMessage;
import com.nsw.common.model.TokhaiRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.common.model.DataPost;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.most.constant.ThuTuc01Constant;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.most.p01.model.Tbdhosocqxl1;
import com.nsw.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Phong84NV
 */
public class ThuTuc01Helper {

    private static final String CLASS_NAME = "ThuTuc01Helper";
    static final Logger logger = LoggerFactory.getLogger(ThuTuc01Helper.class);

    @Autowired
    RabbitMQService rabbitMQService;

    /**
     * Get danh muc
     *
     * @author PhongNV9
     * @since 30/03/2017
     * @return
     */
    public ResponseJson getDanhMuc(String restUri, RabbitMQInfo mqInfo) {
        ResponseJson result = new ResponseJson();
        try {
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(restUri, ResponseJson.class);
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return result;
    }

    /**
     * Search Ho so
     *
     * @author PhongNV9
     * @param mqInfo
     * @since 30/03/2017
     * @param restUri
     * @param searchForm
     * @return
     */
    public ResponseJson searchHoSo(String restUri, SearchForm searchForm, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<SearchForm> entity = new HttpEntity<>(searchForm, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
        } catch (Exception ex) {
            if (json == null) {
                json = new ResponseJson();
            }
            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Get danh muc QCVN
     *
     * @author QuangNV18
     * @param restUri
     * @since 04/04/2017
     * @return
     */
    public ResponseJson getQCVN(String restUri, RabbitMQInfo mqInfo) {
        ResponseJson result = new ResponseJson();
        try {
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(restUri, ResponseJson.class);
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo);
        }
        return result;
    }

    /**
     * *
     * Tao moi ho so
     *
     * @param restUri
     * @param hoso
     * @return
     */
    public ResponseJson createHoSo(String restUri, Tbdhoso1 hoso, RabbitMQInfo mqInfo) {
        ResponseJson json = null;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Tbdhoso1> entity = new HttpEntity<>(hoso, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
        } catch (Exception ex) {
            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * *
     * Cap nhat du lieu ho so
     *
     * @param restUri
     * @param hoso
     * @return
     */
    public ResponseJson updateHoSo(String restUri, Tbdhoso1 hoso, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Tbdhoso1> entity = new HttpEntity<>(hoso, headers);

            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.PUT, entity, ResponseJson.class);

            return jsonBody.getBody();

        } catch (Exception ex) {
            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Xoa ho so
     *
     * @param restUri
     * @param Id
     * @return
     */
    public ResponseJson deleteHoSo(String restUri, String Id, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(Id.toString(), headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", Id);

            restUri += "{id}";
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.DELETE, entity, ResponseJson.class, params);

            return jsonBody.getBody();
        } catch (Exception ex) {
            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Huy bo ho so khi da tiep nhan
     *
     * @param restUri
     * @param data
     * @return
     */
    public ResponseJson cancelHoSo(String restUri, DataPost data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            SendMessage sendData = new SendMessage();
            sendData.setFiIdHoso(Long.parseLong(data.getFiIdHoso().trim()));
            sendData.setReason(data.getFiContent().trim());
            sendData.setFiIdCqxl(Long.parseLong(data.getFiIdCqxl().trim()));
            sendData.setGetXmlNotSend(data.getFiGetMessage());
            sendData.setSignedXml(data.getFiSignedXml());
            sendData.setFunction(ThuTuc01Constant.MessageFunction.FUN_12);
            sendData.setType(ThuTuc01Constant.MessageType.TYPE_15);

            HttpEntity<SendMessage> entity = new HttpEntity<>(sendData, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (NumberFormatException | RestClientException ex) {

            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Huy bo ho so khi chua tiep nhan
     *
     * @param restUri
     * @param data
     * @return
     */
    public ResponseJson cancelHoSoChuaTiepNhan(String restUri, DataPost data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            SendMessage sendData = new SendMessage();
            sendData.setFiIdHoso(Long.parseLong(data.getFiIdHoso().trim()));
            sendData.setReason(data.getFiContent().trim());
            sendData.setFiIdCqxl(Long.parseLong(data.getFiIdCqxl().trim()));
            sendData.setGetXmlNotSend(data.getFiGetMessage());
            sendData.setSignedXml(data.getFiSignedXml());
            sendData.setFunction(ThuTuc01Constant.MessageFunction.FUN_03);
            sendData.setType(ThuTuc01Constant.MessageType.TYPE_17);

            HttpEntity<SendMessage> entity = new HttpEntity<>(sendData, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (NumberFormatException | RestClientException ex) {

            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Xin gia han ho so
     *
     * @param restUri
     * @param data
     * @return
     */
    public ResponseJson delayHoSo(String restUri, DataPost data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            SendMessage sendData = new SendMessage();
            sendData.setFiIdHoso(Long.parseLong(data.getFiIdHoso()));
            sendData.setReason(data.getFiContent());
            sendData.setDelayDateTo(data.getFiTime());
            sendData.setFiIdCqxl(Long.parseLong(data.getFiIdCqxl()));
            sendData.setGetXmlNotSend(data.getFiGetMessage());
            sendData.setSignedXml(data.getFiSignedXml());
            sendData.setFunction(ThuTuc01Constant.MessageFunction.FUN_09);
            sendData.setType(ThuTuc01Constant.MessageType.TYPE_13);

            HttpEntity<SendMessage> entity = new HttpEntity<>(sendData, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (NumberFormatException | RestClientException ex) {

            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Xin chinh sua ho so
     *
     * @param restUri
     * @param data
     * @return
     */
    public ResponseJson requestEditHoSo(String restUri, DataPost data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            SendMessage sendData = new SendMessage();
            sendData.setFiIdHoso(Long.parseLong(data.getFiIdHoso()));
            sendData.setReason(data.getFiContent());
            sendData.setFiIdCqxl(Long.parseLong(data.getFiIdCqxl()));
            sendData.setGetXmlNotSend(data.getFiGetMessage());
            sendData.setSignedXml(data.getFiSignedXml());
            sendData.setFunction(ThuTuc01Constant.MessageFunction.FUN_18);
            sendData.setType(ThuTuc01Constant.MessageType.TYPE_21);

            HttpEntity<SendMessage> entity = new HttpEntity<>(sendData, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (NumberFormatException | RestClientException ex) {
            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Lay thong tin ho so
     *
     * @param restUri
     * @param Id
     * @return
     */
    public Tbdhoso1 getHoSo(String restUri, Long Id, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        Tbdhoso1 hoso = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(Id.toString(), headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", Id.toString());

            restUri += "{id}";
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.GET, entity, ResponseJson.class, params);

            json = jsonBody.getBody();
            if (json.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(json.getData());
                hoso = mapper.readValue(jsonData, Tbdhoso1.class);
            } else {
                hoso = new Tbdhoso1();
            }
        } catch (RestClientException | IOException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            if (hoso == null) {
                hoso = new Tbdhoso1();
            }
        }

        return hoso;
    }

    /**
     * Lay thong tin to khai hai quan
     *
     * @param restUri
     * @param data
     * @return
     */
    public ResponseJson getToKhai(String restUri, TokhaiRequest data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<TokhaiRequest> entity = new HttpEntity<>(data, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (Exception ex) {

            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Lay thong tin lich su xu ly ho so
     *
     * @param restUri
     * @param data
     * @return
     */
    public ResponseJson getHistory(String restUri, SearchFormLichsu01 data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<SearchFormLichsu01> entity = new HttpEntity<>(data, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
            return json;
        } catch (Exception ex) {

            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Gui thong tin ho so
     *
     * @param restUri
     * @param data
     * @return
     */
    public ResponseJson sendHoSo(String restUri, SendMessage data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<SendMessage> entity = new HttpEntity<>(data, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (Exception ex) {
            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Lay thong tin ban ghi dinh kem
     *
     * @param restUri
     * @param Id
     * @return
     */
    public Tbddinhkem1 getFileInfo(String restUri, Long Id, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        Tbddinhkem1 fileInfo = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(Id.toString(), headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", Id.toString());

            restUri += "{id}";
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.GET, entity, ResponseJson.class, params);

            json = jsonBody.getBody();
            if (json.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(json.getData());
                fileInfo = mapper.readValue(jsonData, Tbddinhkem1.class);
            } else {
                fileInfo = new Tbddinhkem1();
            }
        } catch (RestClientException | IOException ex) {
            if (fileInfo == null) {
                fileInfo = new Tbddinhkem1();
            }

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return fileInfo;
    }

    /**
     * Lay thong tin GCN
     *
     * @param restUri
     * @param IdCqxl
     * @return
     */
    public TbdkqdgHh1 getGCN(String restUri, Long IdCqxl, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        TbdkqdgHh1 result = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(IdCqxl.toString(), headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", IdCqxl.toString());

            restUri += "{id}";
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.GET, entity, ResponseJson.class, params);

            json = jsonBody.getBody();
            if (json.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(json.getData());
                result = mapper.readValue(jsonData, TbdkqdgHh1.class);
            } else {
                result = new TbdkqdgHh1();
            }
        } catch (RestClientException | IOException ex) {
            if (result == null) {
                result = new TbdkqdgHh1();
            }

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return result;
    }

    /**
     * Lay thong tin KQKT
     *
     * @param restUri
     * @param IdCqxl
     * @param mqInfo
     * @return
     */
    public TbdkqktHh1 getKQKT(String restUri, Long IdCqxl, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        TbdkqktHh1 result = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(IdCqxl.toString(), headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", IdCqxl.toString());

            restUri += "{id}";
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.GET, entity, ResponseJson.class, params);

            json = jsonBody.getBody();
            if (json.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(json.getData());
                result = mapper.readValue(jsonData, TbdkqktHh1.class);
            } else {
                result = new TbdkqktHh1();
            }
        } catch (RestClientException | IOException ex) {
            if (result == null) {
                result = new TbdkqktHh1();
            }

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return result;
    }

    /**
     * Import Excel
     *
     * @param restUri
     * @param multipartfile
     * @return
     */
    public ResponseJson importExcel(String restUri, MultipartFile multipartfile, String tempFolder, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(
                    new MappingJackson2HttpMessageConverter());

            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();

            String fileName = multipartfile.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
            String code = uuid.toString();
            String filePath = tempFolder + code + "." + FilenameUtils.getExtension(fileName);

            Path path = Paths.get(filePath);
            Files.write(path, multipartfile.getBytes());

            File file = new File(filePath);
            parts.add("file", new FileSystemResource(file));
            parts.add("fileName", fileName);
            parts.add("ministry", ThuTuc01Constant.GOV.BKHCN_EN);
            parts.add("procedure", ThuTuc01Constant.GOV.P01);

            json = restTemplate.postForObject(restUri, parts, ResponseJson.class);
            json.setSuccess(true);
            file.delete();

        } catch (IOException | RestClientException ex) {
            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    public List<Tbdlichsu1> getTopLichSu(Long topRecord, Long fiIdCqxl, String restUri, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        List<Tbdlichsu1> obj = null;
        try {
            SearchFormLichsu01 searchForm = new SearchFormLichsu01();
            searchForm.setFiIdCqxl(fiIdCqxl);
            searchForm.setPageSize(2);

            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            ResponseEntity responseEntity = restTemplate.postForEntity(restUri, searchForm, ResponseJson.class);
            if (responseEntity != null) {
                json = (ResponseJson) responseEntity.getBody();
                if (json.isSuccess()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    String jsonData = mapper.writeValueAsString(json.getData());
                    obj = mapper.readValue(jsonData, new TypeReference<List<Tbdlichsu1>>() {
                    });
                }
            }
        } catch (RestClientException | IOException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return obj;
    }

    /**
     * *
     * Lay lich su theo cqxl va trang thai
     *
     * @param fiIdCqxl
     * @param fiTrangthai
     * @param restUri
     * @param mqInfo
     * @return
     */
    public List<Tbdlichsu1> findLichSuByCqxlAndTrangThai(Long fiIdCqxl, Long fiTrangthai, String restUri, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        List<Tbdlichsu1> obj = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            SearchFormLichsu01 searchForm = new SearchFormLichsu01();
            searchForm.setFiIdCqxl(fiIdCqxl);
            searchForm.setFiIdHoso(fiTrangthai);

            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            HttpEntity<SearchFormLichsu01> entity = new HttpEntity<>(searchForm, headers);

            ResponseEntity responseEntity = restTemplate.postForEntity(restUri, entity, ResponseJson.class);
            if (responseEntity != null) {
                json = (ResponseJson) responseEntity.getBody();
                if (json.isSuccess()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    String jsonData = mapper.writeValueAsString(json.getData());
                    obj = mapper.readValue(jsonData, new TypeReference<List<Tbdlichsu1>>() {
                    });
                }
            }
        } catch (RestClientException | IOException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return obj;
    }

    public List<Tbdhosocqxl1> findCqxl(Long ifIdHoSo, String restUri, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        List<Tbdhosocqxl1> obj = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            HttpEntity<Long> entity = new HttpEntity<>(ifIdHoSo, headers);

            ResponseEntity responseEntity = restTemplate.postForEntity(restUri, entity, ResponseJson.class);
            if (responseEntity != null) {
                json = (ResponseJson) responseEntity.getBody();
                if (json.isSuccess()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    String jsonData = mapper.writeValueAsString(json.getData());
                    obj = mapper.readValue(jsonData, new TypeReference<List<Tbdhosocqxl1>>() {
                    });
                }
            }
        } catch (RestClientException | IOException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return obj;
    }

    /**
     * Lay ban ghi dau tien lich su theo trang thai bat ky
     *
     * @param listItems
     * @param status
     * @return
     */
    public Tbdlichsu1 getHistoryByStatus(List<Tbdlichsu1> listItems, Long status) {
        int size = listItems.size();
        Tbdlichsu1 lichSu = null;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(listItems.get(i), status)) {
                lichSu = listItems.get(i);
                break;
            }
        }

        return lichSu;
    }

    /**
     * Lay ban ghi dau tien lich su theo trang thai bat ky
     *
     * @param listItems
     * @param status
     * @return
     */
    public Tbdlichsu1 getYCBSHistory(List<Tbdlichsu1> listItems, Long status) {
        int size = listItems.size();
        Tbdlichsu1 lichSu = null;
        for (int i = 0; i < size; i++) {
            lichSu = listItems.get(i);
            if (lichSu.getFiThoihan() != null) {
                break;
            }
        }

        return lichSu;
    }
}
