package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbsLoaiCN20;

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
 * @class Mard20TbsLoaiCN20Resource
 * Created by Nguyen Van Quang
 * 21/12/2020 08:55:19
 *
 */
@RestController
@RequestMapping("/mard/20/tbsLoaiCN20")
public class Mard20TbsLoaiCN20Resource extends Mard20CallBack {

    /**
     * @param fiId - Type: Long
     * @return may can null
     */
    @RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
    public ResponseEntity<TbsLoaiCN20> getTbsLoaiCN20(@PathVariable("fiId") Long fiId) {
        TbsLoaiCN20 tbsLoaiCN20 = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiCN20.class);
        return ResponseEntity.ok().body(tbsLoaiCN20);
    }

    /**
     * @param pageableDTO - Type: PageableDTO
     * @return may can null
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiCN20>> findAllTbsLoaiCN20(@RequestBody @Valid PageableDTO pageableDTO) {

        List<TbsLoaiCN20> tbsLoaiCN20List = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiCN20List = mapper.convertValue(tbsLoaiCN20List, new TypeReference<List<TbsLoaiCN20>>() {});

        return ResponseEntity.ok().body(tbsLoaiCN20List);
    }


    @RequestMapping(value = "/findByFiDocumentType", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiCN20>> findByFiDocumentType(@RequestParam(name = "fiDocumentType")String fiDocumentType) {


        Map<String, Object> params = new HashMap<>();
        params.put("fiDocumentType", fiDocumentType);
        List<TbsLoaiCN20> tbsLoaiCN20List = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/findByFiDocumentType"), null, HttpMethod.POST, params, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiCN20List = mapper.convertValue(tbsLoaiCN20List, new TypeReference<List<TbsLoaiCN20>>() {});

        return ResponseEntity.ok().body(tbsLoaiCN20List);
    }
}
