package com.nsw.sbv.p01.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nsw.sbv.p01.model.TbsTepDinhKem1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@PropertySource("classpath:sbv_api.properties")
public class SBV01TbsTepDinhKem1BackendUtil {

    @Autowired
    private SBV01CallBackUtil callBackUtil;

    /**
     * @param tepDinhKemId - Type: Long
     * @return may can null
     */
    public TbsTepDinhKem1 getTbsTepDinhKem1(Long tepDinhKemId) {

        Object body = callBackUtil.createRestTemplate(callBackUtil.getURL("com.nsw.sbv.p01.tbsTepDinhKem1.get") + "/" + tepDinhKemId, null, HttpMethod.GET, null);
        return callBackUtil.readJsonStringToObject(body.toString(), TbsTepDinhKem1.class);
    }

    /**
     * @param loaiThuTuc - Type: String
     * @return can return null or throw exception
     * @throws IOException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     * @throws JsonParseException
     */

    public List<TbsTepDinhKem1> findByLoaiThuTuc(String loaiThuTuc) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {

        Map<String, Object> params = new HashMap<>();
        params.put("loaiThuTuc", loaiThuTuc);
        Object responseJson = callBackUtil.createRestTemplate(callBackUtil.getURL("com.nsw.sbv.p01.tbsTepDinhKem1.findByLoaiThuTuc"), null, HttpMethod.GET, params);
        return callBackUtil.readJsonStringToList(responseJson, TbsTepDinhKem1.class);
    }

    public List<TbsTepDinhKem1> findByLoaiThuTucAndLoaiTep(String loaiThuTuc, String loaiTep) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {

        Map<String, Object> params = new HashMap<>();
        params.put("loaiThuTuc", loaiThuTuc);
        params.put("loaiTep", loaiThuTuc);
        Object responseJson = callBackUtil.createRestTemplate(callBackUtil.getURL("com.nsw.sbv.p01.tbsTepDinhKem1.findByLoaiThuTucAndLoaiTep"), null, HttpMethod.GET, params);
        return callBackUtil.readJsonStringToList(responseJson, TbsTepDinhKem1.class);
    }


}
