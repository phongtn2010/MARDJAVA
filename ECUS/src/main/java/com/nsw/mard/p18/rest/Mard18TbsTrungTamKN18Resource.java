package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbsTrungTamKN18;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/***
 *
 *
 * @RestController
 * @class Mard18TbsTrungTamKN18Resource
 * Created by Nguyen Van Quang
 * 11/12/2018 10:08:45
 *
 */
@RestController
@RequestMapping("/mard/18/tbsTrungTamKN18")
public class Mard18TbsTrungTamKN18Resource extends Mard18CallBack {

    /**
     * @param tbsTrungTamKN18 - Type: TbsTrungTamKN18
     * @return may can null
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<TbsTrungTamKN18> createTbsTrungTamKN18(@RequestBody @Valid TbsTrungTamKN18 tbsTrungTamKN18) {
        tbsTrungTamKN18 = createRestTemplate(getURL("/mard/18/tbsTrungTamKN18/create"), tbsTrungTamKN18, HttpMethod.POST, null, TbsTrungTamKN18.class);
        return ResponseEntity.ok().body(tbsTrungTamKN18);
    }

    /**
     * @param fiId - Type: Long
     * @param tbsTrungTamKN18 - Type: TbsTrungTamKN18
     * @return may can null
     */
    @RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
    public ResponseEntity<TbsTrungTamKN18> updateTbsTrungTamKN18(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsTrungTamKN18 tbsTrungTamKN18) {
        tbsTrungTamKN18 = createRestTemplate(getURL("/mard/18/tbsTrungTamKN18/update/") + fiId, tbsTrungTamKN18, HttpMethod.POST, null, TbsTrungTamKN18.class);
        return ResponseEntity.ok().body(tbsTrungTamKN18);
    }

    /**
     * @param fiId - Type: Long
     * @return may can throw new Execption
     */
    @RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
    public ResponseEntity<TbsTrungTamKN18> deleteTbsTrungTamKN18(@PathVariable("fiId") Long fiId) {
        TbsTrungTamKN18 tbsTrungTamKN18 = createRestTemplate(getURL("/mard/18/tbsTrungTamKN18/delete/") + fiId, null, HttpMethod.GET, null, TbsTrungTamKN18.class);
        return ResponseEntity.ok().body(tbsTrungTamKN18);
    }

    /**
     * @param fiId - Type: Long
     * @return may can null
     */
    @RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
    public ResponseEntity<TbsTrungTamKN18> getTbsTrungTamKN18(@PathVariable("fiId") Long fiId) {
        TbsTrungTamKN18 tbsTrungTamKN18 = createRestTemplate(getURL("/mard/18/tbsTrungTamKN18/get/") + fiId, null, HttpMethod.GET, null, TbsTrungTamKN18.class);
        return ResponseEntity.ok().body(tbsTrungTamKN18);
    }

    /**
     * @param pageableDTO - Type: PageableDTO
     * @return may can null
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAllByPost", method = RequestMethod.POST)
    public ResponseEntity<List<TbsTrungTamKN18>> findAllTbsTrungTamKN18(@RequestBody @Valid PageableDTO pageableDTO) {

        List<TbsTrungTamKN18> tbsTrungTamKN18List = createRestTemplate(getURL("/mard/18/tbsTrungTamKN18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsTrungTamKN18List = mapper.convertValue(tbsTrungTamKN18List, new TypeReference<List<TbsTrungTamKN18>>() {});

        return ResponseEntity.ok().body(tbsTrungTamKN18List);
    }
    @RequestMapping(value = "/findAllByGet", method = RequestMethod.GET)
    public ResponseEntity<List<TbsTrungTamKN18>> findAllByGet() {

        List<TbsTrungTamKN18> tbsTrungTamKN18List = createRestTemplate(getURL("/mard/18/tbsTrungTamKN18/findAllByGet"), null, HttpMethod.GET, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbsTrungTamKN18List = mapper.convertValue(tbsTrungTamKN18List, new TypeReference<List<TbsTrungTamKN18>>() {});

        return ResponseEntity.ok().body(tbsTrungTamKN18List);
    }
}
