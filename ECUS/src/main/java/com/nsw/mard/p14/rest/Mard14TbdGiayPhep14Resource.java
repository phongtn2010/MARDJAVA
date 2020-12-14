package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbdGiayPhep14;

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
* @class Mard14TbdGiayPhep14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
@RestController
@RequestMapping("/mard/14/tbdGiayPhep14")
public class Mard14TbdGiayPhep14Resource extends Mard14CallBack {

	/**
	* @param tbdGiayPhep14 - Type: TbdGiayPhep14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdGiayPhep14> createTbdGiayPhep14(@RequestBody @Valid TbdGiayPhep14 tbdGiayPhep14) {
		tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/create"), tbdGiayPhep14, HttpMethod.POST, null, TbdGiayPhep14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdGiayPhep14 - Type: TbdGiayPhep14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdGiayPhep14> updateTbdGiayPhep14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGiayPhep14 tbdGiayPhep14) {
		tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/update/") + fiId, tbdGiayPhep14, HttpMethod.POST, null, TbdGiayPhep14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGiayPhep14> deleteTbdGiayPhep14(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep14 tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/delete/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGiayPhep14> getTbdGiayPhep14(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep14 tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/get/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdGiayPhep14>> findAllTbdGiayPhep14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGiayPhep14> tbdGiayPhep14List = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep14List = mapper.convertValue(tbdGiayPhep14List, new TypeReference<List<TbdGiayPhep14>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep14List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGiayPhep14>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep14> tbdGiayPhep14List = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep14List = mapper.convertValue(tbdGiayPhep14List, new TypeReference<List<TbdGiayPhep14>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep14List);
	}

	/**
	* @param fiDispatchNo - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiDispatchNo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGiayPhep14>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdGiayPhep14> tbdGiayPhep14List = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep14List = mapper.convertValue(tbdGiayPhep14List, new TypeReference<List<TbdGiayPhep14>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep14List);
	}


}