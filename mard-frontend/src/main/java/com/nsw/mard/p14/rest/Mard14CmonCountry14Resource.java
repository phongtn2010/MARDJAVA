package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.CmonCountry14;
import com.nsw.mard.p14.model.PageableDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mard/14/cmonCountry14")
public class Mard14CmonCountry14Resource extends Mard14CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonCountry14>> findAll() {

        List<CmonCountry14> cmonCountry14s = createRestTemplate(getURL("/mard/14/cmonCountry14/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonCountry14s = mapper.convertValue(cmonCountry14s, new TypeReference<List<CmonCountry14>>() {});

        return ResponseEntity.ok().body(cmonCountry14s);
    }
}
