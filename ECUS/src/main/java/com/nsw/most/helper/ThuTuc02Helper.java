/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.common.model.DataPost;
import com.nsw.common.model.TokhaiRequest;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.constant.ThuTuc02Constant;
import com.nsw.most.p02.model.SearchForm02;
import com.nsw.most.p02.model.SearchFormLichsu02;
import com.nsw.most.p02.model.SendMessage02;
import com.nsw.most.p02.model.Tbdhoso2;
import com.nsw.most.p02.model.TbdkqktHh2;
import com.nsw.most.p02.model.Tbdlichsu2;
import com.nsw.service.RabbitMQService;
import com.nsw.util.LogUtil;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 *
 * @author Nhan
 */
public class ThuTuc02Helper {

    private static final String CLASS_NAME = "ThuTuc02Helper";
    static final Logger logger = LoggerFactory.getLogger(ThuTuc02Helper.class);

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
            LogUtil.addLog(ex);
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
     * @since 30/03/2017
     * @param restUri
     * @param searchForm
     * @return
     */
    public ResponseJson searchHoSo(String restUri, SearchForm02 searchForm, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<SearchForm02> entity = new HttpEntity<>(searchForm, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
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
     * Tao moi ho so
     *
     * @param restUri
     * @param hoso
     * @return
     */
    public ResponseJson createHoSo(String restUri, Tbdhoso2 hoso, RabbitMQInfo mqInfo) {
        ResponseJson json = null;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Tbdhoso2> entity = new HttpEntity<>(hoso, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
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
     * Cap nhat du lieu ho so
     *
     * @param restUri
     * @param hoso
     * @return
     */
    public ResponseJson updateHoSo(String restUri, Tbdhoso2 hoso, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Tbdhoso2> entity = new HttpEntity<>(hoso, headers);

            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.PUT, entity, ResponseJson.class);

            return jsonBody.getBody();

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            
                json = new ResponseJson();

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

            restUri += Id;
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.DELETE, entity, ResponseJson.class, params);

            return jsonBody.getBody();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            
                json = new ResponseJson();
            

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
    public Tbdhoso2 getHoSo(String restUri, Long Id, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        Tbdhoso2 hoso = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(Id.toString(), headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", Id.toString());

            restUri += Id;
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.GET, entity, ResponseJson.class, params);

            json = jsonBody.getBody();
            if (json.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(json.getData());
                hoso = mapper.readValue(jsonData, Tbdhoso2.class);
            } else {
                hoso = new Tbdhoso2();
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            if (hoso == null) {
                hoso = new Tbdhoso2();
            }
            LogUtil.addLog(ex);
        }

        return hoso;
    }
    
    /**
     * Gui thong tin ho so
     *
     * @param restUri
     * @param data
     * @return
     */
    public ResponseJson sendHoSo(String restUri, SendMessage02 data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<SendMessage02> entity = new HttpEntity<>(data, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (Exception ex) {
            
                json = new ResponseJson();
            

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
        }

        return json;
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
            json = new ResponseJson();

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
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
    public ResponseJson getHistory(String restUri, SearchFormLichsu02 data, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<SearchFormLichsu02> entity = new HttpEntity<>(data, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
            return json;
        } catch (Exception ex) {

            
                json = new ResponseJson();
            

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
        }

        return json;
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
            parts.add("ministry", ThuTuc02Constant.GOV.BKHCN_EN);
            parts.add("procedure", ThuTuc02Constant.GOV.P02);

            json = restTemplate.postForObject(restUri, parts, ResponseJson.class);
            json.setSuccess(true);
            file.delete();

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
            LogUtil.addLog(ex);
        }

        return json;
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
    public List<Tbdlichsu2> findLichSuByHosoidAndTrangThai(Long fiIdHoso, Long fiTrangthai, String restUri, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        List<Tbdlichsu2> obj = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            SearchFormLichsu02 searchForm = new SearchFormLichsu02();
            searchForm.setFiIdHoso(fiIdHoso);
            searchForm.setFiTrangthai(fiTrangthai);

            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            HttpEntity<SearchFormLichsu02> entity = new HttpEntity<>(searchForm, headers);

            ResponseEntity responseEntity = restTemplate.postForEntity(restUri, entity, ResponseJson.class);
            if (responseEntity != null) {
                json = (ResponseJson) responseEntity.getBody();
                if (json.isSuccess()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    String jsonData = mapper.writeValueAsString(json.getData());
                    obj = mapper.readValue(jsonData, new TypeReference<List<Tbdlichsu2>>() {
                    });
                }
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
        }

        return obj;
    }
    
    /**
     * Lay thong tin KQKT
     *
     * @param restUri
     * @param IdHoso
     * @return
     */
    public TbdkqktHh2 getKQKT(String restUri, Long IdHoso, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        TbdkqktHh2 result = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(IdHoso.toString(), headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", IdHoso.toString());

            restUri += IdHoso;
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.GET, entity, ResponseJson.class, params);

            json = jsonBody.getBody();
            if (json.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(json.getData());
                result = mapper.readValue(jsonData, TbdkqktHh2.class);
            } else {
                result = new TbdkqktHh2();
            }
        } catch (Exception ex) {
            if (result == null) {
                result = new TbdkqktHh2();
            }

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
        }

        return result;
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

            SendMessage02 sendData = new SendMessage02();
            sendData.setFiIdHoso(Long.parseLong(data.getFiIdHoso().trim()));
            sendData.setReason(data.getFiContent().trim());
            sendData.setGetXmlNotSend(data.getFiGetMessage());
            sendData.setSignedXml(data.getFiSignedXml());
            sendData.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_03);
            sendData.setType(ThuTuc02Constant.KHCN02_TYPE.TYPE_17);

            HttpEntity<SendMessage02> entity = new HttpEntity<>(sendData, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (Exception ex) {

            json = new ResponseJson();
            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
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

            SendMessage02 sendData = new SendMessage02();
            sendData.setFiIdHoso(Long.parseLong(data.getFiIdHoso().trim()));
            sendData.setReason(data.getFiContent().trim());
            sendData.setGetXmlNotSend(data.getFiGetMessage());
            sendData.setSignedXml(data.getFiSignedXml());
            sendData.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_12);
            sendData.setType(ThuTuc02Constant.KHCN02_TYPE.TYPE_15);

            HttpEntity<SendMessage02> entity = new HttpEntity<>(sendData, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (Exception ex) {

            
                json = new ResponseJson();

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
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

            SendMessage02 sendData = new SendMessage02();
            sendData.setFiIdHoso(Long.parseLong(data.getFiIdHoso()));
            sendData.setReason(data.getFiContent());
            sendData.setDelayDateTo(data.getFiTime());
            sendData.setGetXmlNotSend(data.getFiGetMessage());
            sendData.setSignedXml(data.getFiSignedXml());
            sendData.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_08);
            sendData.setType(ThuTuc02Constant.KHCN02_TYPE.TYPE_14);

            HttpEntity<SendMessage02> entity = new HttpEntity<>(sendData, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (Exception ex) {

                json = new ResponseJson();

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
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

            SendMessage02 sendData = new SendMessage02();
            sendData.setFiIdHoso(Long.parseLong(data.getFiIdHoso()));
            sendData.setReason(data.getFiContent());
            sendData.setGetXmlNotSend(data.getFiGetMessage());
            sendData.setSignedXml(data.getFiSignedXml());
            sendData.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_09);
            sendData.setType(ThuTuc02Constant.KHCN02_TYPE.TYPE_13);

            HttpEntity<SendMessage02> entity = new HttpEntity<>(sendData, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            return json;
        } catch (Exception ex) {
            
                json = new ResponseJson();
            

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
        }

        return json;
    }
    
    /**
     * *
     * Lay lich su theo id hoso 
     *
     * @param fiTrangthai
     * @param restUri
     * @param mqInfo
     * @return
     */
    public List<Tbdlichsu2> findLichSuByIdHoso(Long fiIdHoso, Long fiTrangthai, String restUri, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        List<Tbdlichsu2> obj = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            SearchFormLichsu02 searchForm = new SearchFormLichsu02();
            searchForm.setFiIdHoso(fiIdHoso);

            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            HttpEntity<SearchFormLichsu02> entity = new HttpEntity<>(searchForm, headers);

            ResponseEntity responseEntity = restTemplate.postForEntity(restUri, entity, ResponseJson.class);
            if (responseEntity != null) {
                json = (ResponseJson) responseEntity.getBody();
                if (json.isSuccess()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    String jsonData = mapper.writeValueAsString(json.getData());
                    obj = mapper.readValue(jsonData, new TypeReference<List<Tbdlichsu2>>() {
                    });
                }
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
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
    public Tbdlichsu2 getYCBSHistory(List<Tbdlichsu2> listItems, Long status) {
        int size = listItems.size();
        Tbdlichsu2 lichSu = null;
        for (int i = 0; i < size; i++) {
            lichSu = listItems.get(i);
            if (lichSu.getFiThoihan() != null) {
                break;
            }
        }

        return lichSu;
    }

}
