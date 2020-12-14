package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.CmonUnit17;
import com.nsw.mard.p17.model.TbsLoaiTienTe17;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mard/17/tbsLoaiTienTe17")
public class Mard17TbsLoaiTienTe17Resource extends Mard17CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<TbsLoaiTienTe17>> findAll() {

        List<TbsLoaiTienTe17> tbsLoaiTienTe17List = createRestTemplate(getURL("/mard/17/tbsLoaiTienTe17/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiTienTe17List = mapper.convertValue(tbsLoaiTienTe17List, new TypeReference<List<TbsLoaiTienTe17>>() {});

        return ResponseEntity.ok().body(tbsLoaiTienTe17List);
    }
}
