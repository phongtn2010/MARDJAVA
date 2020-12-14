package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbsLoaiCN17;

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
 * @class Mard17TbsLoaiCN17Resource
 * Created by Nguyen Van Quang
 * 21/12/2018 08:55:19
 *
 */
@RestController
@RequestMapping("/mard/17/tbsLoaiCN17")
public class Mard17TbsLoaiCN17Resource extends Mard17CallBack {

    /**
     * @param fiId - Type: Long
     * @return may can null
     */
    @RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
    public ResponseEntity<TbsLoaiCN17> getTbsLoaiCN17(@PathVariable("fiId") Long fiId) {
        TbsLoaiCN17 tbsLoaiCN17 = createRestTemplate(getURL("/mard/17/tbsLoaiCN17/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiCN17.class);
        return ResponseEntity.ok().body(tbsLoaiCN17);
    }

    /**
     * @param pageableDTO - Type: PageableDTO
     * @return may can null
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiCN17>> findAllTbsLoaiCN17(@RequestBody @Valid PageableDTO pageableDTO) {

        List<TbsLoaiCN17> tbsLoaiCN17List = createRestTemplate(getURL("/mard/17/tbsLoaiCN17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiCN17List = mapper.convertValue(tbsLoaiCN17List, new TypeReference<List<TbsLoaiCN17>>() {});

        return ResponseEntity.ok().body(tbsLoaiCN17List);
    }


    @RequestMapping(value = "/findByFiDocumentType", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiCN17>> findByFiDocumentType(@RequestParam(name = "fiDocumentType")String fiDocumentType) {


        Map<String, Object> params = new HashMap<>();
        params.put("fiDocumentType", fiDocumentType);
        List<TbsLoaiCN17> tbsLoaiCN17List = createRestTemplate(getURL("/mard/17/tbsLoaiCN17/findByFiDocumentType"), null, HttpMethod.POST, params, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsLoaiCN17List = mapper.convertValue(tbsLoaiCN17List, new TypeReference<List<TbsLoaiCN17>>() {});

        return ResponseEntity.ok().body(tbsLoaiCN17List);
    }
}
