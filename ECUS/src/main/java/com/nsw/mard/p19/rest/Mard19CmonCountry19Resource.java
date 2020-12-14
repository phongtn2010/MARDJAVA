package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.CmonCountry19;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mard/19/cmonCountry19")
public class Mard19CmonCountry19Resource extends Mard19CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonCountry19>> findAll() {

        List<CmonCountry19> cmonCountry19s = createRestTemplate(getURL("/mard/18/cmonCountry18/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonCountry19s = mapper.convertValue(cmonCountry19s, new TypeReference<List<CmonCountry19>>() {});

        return ResponseEntity.ok().body(cmonCountry19s);
    }
}
