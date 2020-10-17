package com.nsw.mic.p03.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mic.p03.model.TbsTepDinhKem03;
import com.nsw.mic.p03.model.TbsTinhThanhPho03;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Mic03Constant.ROOT_API)
public class Mic03CommonApi extends Mic03CallBack {

    public List<TbsTepDinhKem03> findByLoaiThuTucOrderByFiSortAsc(String loaiThuTuc) {

        Map<String, Object> params = new HashMap<>();
        params.put("loaiThuTuc", loaiThuTuc);
        List<TbsTepDinhKem03> tbsTepDinhKem03List = createRestTemplate(getURL("/mic/03/tbsTepDinhKem03/findByLoaiThuTuc"), null, HttpMethod.GET, params, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsTepDinhKem03List = mapper.convertValue(tbsTepDinhKem03List, new TypeReference<List<TbsTepDinhKem03>>() {});

        return tbsTepDinhKem03List;
    }

    public List<TbsTinhThanhPho03> getTbsTinhThanhPho03s() {

        List<TbsTinhThanhPho03> tbsTinhThanhPho03List = createRestTemplate(getURL("/mic/03/tbsTinhThanhPho03/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsTinhThanhPho03List = mapper.convertValue(tbsTinhThanhPho03List, new TypeReference<List<TbsTinhThanhPho03>>() {});

        return tbsTinhThanhPho03List;
    }
}
