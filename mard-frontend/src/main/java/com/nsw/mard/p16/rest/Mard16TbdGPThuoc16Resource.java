package com.nsw.mard.p16.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p16.model.PageableDTO;
import com.nsw.mard.p16.model.TbdGPThuoc16;

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
* @class Mard16TbdGPThuoc16Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
@RestController
@RequestMapping("/mard/16/tbdGPThuoc16")
public class Mard16TbdGPThuoc16Resource extends Mard16CallBack {

	/**
	* @param tbdGPThuoc16 - Type: TbdGPThuoc16
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdGPThuoc16> createTbdGPThuoc16(@RequestBody @Valid TbdGPThuoc16 tbdGPThuoc16) {
		tbdGPThuoc16 = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/create"), tbdGPThuoc16, HttpMethod.POST, null, TbdGPThuoc16.class);
		return ResponseEntity.ok().body(tbdGPThuoc16);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdGPThuoc16 - Type: TbdGPThuoc16
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdGPThuoc16> updateTbdGPThuoc16(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGPThuoc16 tbdGPThuoc16) {
		tbdGPThuoc16 = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/update/") + fiId, tbdGPThuoc16, HttpMethod.POST, null, TbdGPThuoc16.class);
		return ResponseEntity.ok().body(tbdGPThuoc16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGPThuoc16> deleteTbdGPThuoc16(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc16 tbdGPThuoc16 = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/delete/") + fiId, null, HttpMethod.GET, null, TbdGPThuoc16.class);
		return ResponseEntity.ok().body(tbdGPThuoc16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGPThuoc16> getTbdGPThuoc16(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc16 tbdGPThuoc16 = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/get/") + fiId, null, HttpMethod.GET, null, TbdGPThuoc16.class);
		return ResponseEntity.ok().body(tbdGPThuoc16);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdGPThuoc16>> findAllTbdGPThuoc16(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGPThuoc16> tbdGPThuoc16List = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGPThuoc16List = mapper.convertValue(tbdGPThuoc16List, new TypeReference<List<TbdGPThuoc16>>() {});

		return ResponseEntity.ok().body(tbdGPThuoc16List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGPThuoc16>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGPThuoc16> tbdGPThuoc16List = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGPThuoc16List = mapper.convertValue(tbdGPThuoc16List, new TypeReference<List<TbdGPThuoc16>>() {});

		return ResponseEntity.ok().body(tbdGPThuoc16List);
	}


}