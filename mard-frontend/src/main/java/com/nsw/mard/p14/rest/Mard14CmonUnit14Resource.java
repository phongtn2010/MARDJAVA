package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.CmonUnit14;
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
@RequestMapping("/mard/14/cmonUnit14")
public class Mard14CmonUnit14Resource extends Mard14CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonUnit14>> findAll() {

        List<CmonUnit14> cmonUnit14List = createRestTemplate(getURL("/mard/14/cmonUnit14/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonUnit14List = mapper.convertValue(cmonUnit14List, new TypeReference<List<CmonUnit14>>() {});

        return ResponseEntity.ok().body(cmonUnit14List);
    }
}
