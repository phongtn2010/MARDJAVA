package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbsLoaiCN18;

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
 * @class Mard18TbsLoaiCN18Resource
 * Created by Nguyen Van Quang
 * 21/12/2018 08:55:19
 *
 */
@RestController
@RequestMapping("/mard/18/tbsLoaiCN18")
public class Mard18TbsLoaiCN18Resource extends Mard18CallBack {

    /**
     * @param fiId - Type: Long
     * @return may can null
     */
    @RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
    public ResponseEntity<TbsLoaiCN18> getTbsLoaiCN18(@PathVariable("fiId") Long fiId) {
        TbsLoaiCN18 tbsLoaiCN18 = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiCN18.class);
        return ResponseEntity.ok().body(tbsLoaiCN18);
    }

    /**
     * @param pageableDTO - Type: PageableDTO
     * @return may can null
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiCN18>> findAllTbsLoaiCN18(@RequestBody @Valid PageableDTO pageableDTO) {

        List<TbsLoaiCN18> tbsLoaiCN18List = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiCN18List = mapper.convertValue(tbsLoaiCN18List, new TypeReference<List<TbsLoaiCN18>>() {});

        return ResponseEntity.ok().body(tbsLoaiCN18List);
    }


    @RequestMapping(value = "/findByFiDocumentType", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiCN18>> findByFiDocumentType(@RequestParam(name = "fiDocumentType")String fiDocumentType) {


        Map<String, Object> params = new HashMap<>();
        params.put("fiDocumentType", fiDocumentType);
        List<TbsLoaiCN18> tbsLoaiCN18List = createRestTemplate(getURL("/mard/18/tbsLoaiCN18/findByFiDocumentType"), null, HttpMethod.POST, params, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiCN18List = mapper.convertValue(tbsLoaiCN18List, new TypeReference<List<TbsLoaiCN18>>() {});

        return ResponseEntity.ok().body(tbsLoaiCN18List);
    }
}
