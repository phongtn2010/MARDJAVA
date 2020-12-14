package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.CmonCountry17;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mard/17/cmonCountry17")
public class Mard17CmonCountry17Resource extends Mard17CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonCountry17>> findAll() {

        List<CmonCountry17> cmonCountry17s = createRestTemplate(getURL("/mard/17/cmonCountry17/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonCountry17s = mapper.convertValue(cmonCountry17s, new TypeReference<List<CmonCountry17>>() {});

        return ResponseEntity.ok().body(cmonCountry17s);
    }
}
