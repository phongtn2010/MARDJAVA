package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbsLoaiCN19;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/***
 *
 *
 * @RestController
 * @class Mard19TbsLoaiCN19Resource
 * Created by Nguyen Van Quang
 * 21/12/2019 08:55:19
 *
 */
@RestController
@RequestMapping("/mard/19/tbsLoaiCN19")
public class Mard19TbsLoaiCN19Resource extends Mard19CallBack {

    /**
     * @param fiId - Type: Long
     * @return may can null
     */
    @RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
    public ResponseEntity<TbsLoaiCN19> getTbsLoaiCN19(@PathVariable("fiId") Long fiId) {
        TbsLoaiCN19 tbsLoaiCN19 = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiCN19.class);
        return ResponseEntity.ok().body(tbsLoaiCN19);
    }

    /**
     * @param pageableDTO - Type: PageableDTO
     * @return may can null
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiCN19>> findAllTbsLoaiCN19(@RequestBody @Valid PageableDTO pageableDTO) {

        List<TbsLoaiCN19> tbsLoaiCN19List = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiCN19List = mapper.convertValue(tbsLoaiCN19List, new TypeReference<List<TbsLoaiCN19>>() {});

        return ResponseEntity.ok().body(tbsLoaiCN19List);
    }


    @RequestMapping(value = "/findByFiDocumentType", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiCN19>> findByFiDocumentType(@RequestParam(name = "fiDocumentType")String fiDocumentType) {


        Map<String, Object> params = new HashMap<>();
        params.put("fiDocumentType", fiDocumentType);
        List<TbsLoaiCN19> tbsLoaiCN19List = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/findByFiDocumentType"), null, HttpMethod.POST, params, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiCN19List = mapper.convertValue(tbsLoaiCN19List, new TypeReference<List<TbsLoaiCN19>>() {});

        return ResponseEntity.ok().body(tbsLoaiCN19List);
    }
}
