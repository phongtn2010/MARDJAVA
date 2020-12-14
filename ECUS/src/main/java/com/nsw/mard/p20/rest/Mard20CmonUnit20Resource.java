package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.CmonUnit20;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mard/20/cmonUnit20")
public class Mard20CmonUnit20Resource extends Mard20CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<CmonUnit20>> findAll() {

        List<CmonUnit20> cmonUnit20List = createRestTemplate(getURL("/mard/18/cmonUnit18/findAll"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        cmonUnit20List = mapper.convertValue(cmonUnit20List, new TypeReference<List<CmonUnit20>>() {});

        return ResponseEntity.ok().body(cmonUnit20List);
    }
   /* @RequestMapping(value = "/addDVT", method = RequestMethod.POST)
    public ResponseEntity<CmonUnit20> addDVT(@RequestBody @Valid CmonUnit20 cmonUnit20) {
        cmonUnit20 = createRestTemplate(getURL());


    }*/
}
