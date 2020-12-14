package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.CmonUnit17;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mard/17/cmonUnit17")
public class Mard17CmonUnit17Resource extends Mard17CallBack {
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonUnit17>> findAll() {
        List<CmonUnit17> cmonUnit17List = createRestTemplate(getURL("/mard/17/cmonUnit17/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonUnit17List = mapper.convertValue(cmonUnit17List, new TypeReference<List<CmonUnit17>>() {});
        return ResponseEntity.ok().body(cmonUnit17List);
    }
}
