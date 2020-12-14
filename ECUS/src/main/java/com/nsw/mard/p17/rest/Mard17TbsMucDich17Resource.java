package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbsMucDich17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/***
*
*
* @RestController
* @class Mard17TbsMucDich17Resource
* Created by Nguyen Van Quang
* 21/12/2018 08:55:19
*
*/
@RestController
@RequestMapping("/mard/17/tbsMucDich17")
public class Mard17TbsMucDich17Resource extends Mard17CallBack {

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsMucDich17> getTbsMucDich17(@PathVariable("fiId") Long fiId) {
		TbsMucDich17 tbsMucDich17 = createRestTemplate(getURL("/mard/17/tbsMucDich17/get/") + fiId, null, HttpMethod.GET, null, TbsMucDich17.class);
		return ResponseEntity.ok().body(tbsMucDich17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsMucDich17>> findAllTbsMucDich17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsMucDich17> tbsMucDich17List = createRestTemplate(getURL("/mard/17/tbsMucDich17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsMucDich17List = mapper.convertValue(tbsMucDich17List, new TypeReference<List<TbsMucDich17>>() {});

		return ResponseEntity.ok().body(tbsMucDich17List);
	}


	@RequestMapping(value = "/findByFiDocumentType", method = RequestMethod.POST)
	public ResponseEntity<List<TbsMucDich17>> findByFiDocumentType(@RequestParam(name = "fiDocumentType")String fiDocumentType) {


		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		List<TbsMucDich17> tbsMucDich17List = createRestTemplate(getURL("/mard/17/tbsMucDich17/findByFiDocumentType"), null, HttpMethod.POST, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsMucDich17List = mapper.convertValue(tbsMucDich17List, new TypeReference<List<TbsMucDich17>>() {});

		return ResponseEntity.ok().body(tbsMucDich17List);
	}
}
