package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbdGPThuoc14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/***
*
*
* @RestController
* @class Mard14TbdGPThuoc14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
@RestController
@RequestMapping("/mard/14/tbdGPThuoc14")
public class Mard14TbdGPThuoc14Resource extends Mard14CallBack {

	/**
	* @param tbdGPThuoc14 - Type: TbdGPThuoc14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdGPThuoc14> createTbdGPThuoc14(@RequestBody @Valid TbdGPThuoc14 tbdGPThuoc14) {
		tbdGPThuoc14 = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/create"), tbdGPThuoc14, HttpMethod.POST, null, TbdGPThuoc14.class);
		return ResponseEntity.ok().body(tbdGPThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdGPThuoc14 - Type: TbdGPThuoc14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdGPThuoc14> updateTbdGPThuoc14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGPThuoc14 tbdGPThuoc14) {
		tbdGPThuoc14 = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/update/") + fiId, tbdGPThuoc14, HttpMethod.POST, null, TbdGPThuoc14.class);
		return ResponseEntity.ok().body(tbdGPThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGPThuoc14> deleteTbdGPThuoc14(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc14 tbdGPThuoc14 = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/delete/") + fiId, null, HttpMethod.GET, null, TbdGPThuoc14.class);
		return ResponseEntity.ok().body(tbdGPThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGPThuoc14> getTbdGPThuoc14(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc14 tbdGPThuoc14 = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/get/") + fiId, null, HttpMethod.GET, null, TbdGPThuoc14.class);
		return ResponseEntity.ok().body(tbdGPThuoc14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdGPThuoc14>> findAllTbdGPThuoc14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGPThuoc14> tbdGPThuoc14List = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGPThuoc14List = mapper.convertValue(tbdGPThuoc14List, new TypeReference<List<TbdGPThuoc14>>() {});

		return ResponseEntity.ok().body(tbdGPThuoc14List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGPThuoc14>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGPThuoc14> tbdGPThuoc14List = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGPThuoc14List = mapper.convertValue(tbdGPThuoc14List, new TypeReference<List<TbdGPThuoc14>>() {});

		return ResponseEntity.ok().body(tbdGPThuoc14List);
	}


}