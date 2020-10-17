package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbsMucDich14;

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
* @class Mard14TbsMucDich14Resource
* Created by Nguyen Van Quang
* 21/12/2018 08:55:19
*
*/
@RestController
@RequestMapping("/mard/14/tbsMucDich14")
public class Mard14TbsMucDich14Resource extends Mard14CallBack {

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsMucDich14> getTbsMucDich14(@PathVariable("fiId") Long fiId) {
		TbsMucDich14 tbsMucDich14 = createRestTemplate(getURL("/mard/14/tbsMucDich14/get/") + fiId, null, HttpMethod.GET, null, TbsMucDich14.class);
		return ResponseEntity.ok().body(tbsMucDich14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsMucDich14>> findAllTbsMucDich14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsMucDich14> tbsMucDich14List = createRestTemplate(getURL("/mard/14/tbsMucDich14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsMucDich14List = mapper.convertValue(tbsMucDich14List, new TypeReference<List<TbsMucDich14>>() {});

		return ResponseEntity.ok().body(tbsMucDich14List);
	}


	@RequestMapping(value = "/findByFiDocumentType", method = RequestMethod.POST)
	public ResponseEntity<List<TbsMucDich14>> findByFiDocumentType(@RequestParam(name = "fiDocumentType")String fiDocumentType) {


		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		List<TbsMucDich14> tbsMucDich14List = createRestTemplate(getURL("/mard/14/tbsMucDich14/findByFiDocumentType"), null, HttpMethod.POST, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsMucDich14List = mapper.convertValue(tbsMucDich14List, new TypeReference<List<TbsMucDich14>>() {});

		return ResponseEntity.ok().body(tbsMucDich14List);
	}
}