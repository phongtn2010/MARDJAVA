package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.CmonUnit19;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mard/19/cmonUnit19")
public class Mard19CmonUnit19Resource extends Mard19CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonUnit19>> findAll() {

        List<CmonUnit19> cmonUnit19List = createRestTemplate(getURL("/mard/18/cmonUnit18/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonUnit19List = mapper.convertValue(cmonUnit19List, new TypeReference<List<CmonUnit19>>() {});

        return ResponseEntity.ok().body(cmonUnit19List);
    }
}
