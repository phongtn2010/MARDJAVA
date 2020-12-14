package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.CmonCountry18;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mard/18/cmonCountry18")
public class Mard18CmonCountry18Resource extends Mard18CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonCountry18>> findAll() {

        List<CmonCountry18> cmonCountry18s = createRestTemplate(getURL("/mard/18/cmonCountry18/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonCountry18s = mapper.convertValue(cmonCountry18s, new TypeReference<List<CmonCountry18>>() {});

        return ResponseEntity.ok().body(cmonCountry18s);
    }
}
