package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.CmonUnit18;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mard/18/cmonUnit18")
public class Mard18CmonUnit18Resource extends Mard18CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonUnit18>> findAll() {

        List<CmonUnit18> cmonUnit18List = createRestTemplate(getURL("/mard/18/cmonUnit18/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonUnit18List = mapper.convertValue(cmonUnit18List, new TypeReference<List<CmonUnit18>>() {});

        return ResponseEntity.ok().body(cmonUnit18List);
    }
}
