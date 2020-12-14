package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.CmonCountry20;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mard/20/cmonCountry20")
public class Mard20CmonCountry20Resource extends Mard20CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonCountry20>> findAll() {

        List<CmonCountry20> cmonCountry20s = createRestTemplate(getURL("/mard/18/cmonCountry18/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonCountry20s = mapper.convertValue(cmonCountry20s, new TypeReference<List<CmonCountry20>>() {});

        return ResponseEntity.ok().body(cmonCountry20s);
    }
}
