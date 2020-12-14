package com.nsw.mard.p16.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p16.model.PageableDTO;
import com.nsw.mard.p16.model.TbdGiayPhep16;

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
* @class Mard16TbdGiayPhep16Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
@RestController
@RequestMapping("/mard/16/tbdGiayPhep16")
public class Mard16TbdGiayPhep16Resource extends Mard16CallBack {

	/**
	* @param tbdGiayPhep16 - Type: TbdGiayPhep16
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdGiayPhep16> createTbdGiayPhep16(@RequestBody @Valid TbdGiayPhep16 tbdGiayPhep16) {
		tbdGiayPhep16 = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/create"), tbdGiayPhep16, HttpMethod.POST, null, TbdGiayPhep16.class);
		return ResponseEntity.ok().body(tbdGiayPhep16);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdGiayPhep16 - Type: TbdGiayPhep16
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdGiayPhep16> updateTbdGiayPhep16(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGiayPhep16 tbdGiayPhep16) {
		tbdGiayPhep16 = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/update/") + fiId, tbdGiayPhep16, HttpMethod.POST, null, TbdGiayPhep16.class);
		return ResponseEntity.ok().body(tbdGiayPhep16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGiayPhep16> deleteTbdGiayPhep16(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep16 tbdGiayPhep16 = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/delete/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep16.class);
		return ResponseEntity.ok().body(tbdGiayPhep16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGiayPhep16> getTbdGiayPhep16(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep16 tbdGiayPhep16 = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/get/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep16.class);
		return ResponseEntity.ok().body(tbdGiayPhep16);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdGiayPhep16>> findAllTbdGiayPhep16(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGiayPhep16> tbdGiayPhep16List = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep16List = mapper.convertValue(tbdGiayPhep16List, new TypeReference<List<TbdGiayPhep16>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep16List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGiayPhep16>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep16> tbdGiayPhep16List = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep16List = mapper.convertValue(tbdGiayPhep16List, new TypeReference<List<TbdGiayPhep16>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep16List);
	}

	/**
	* @param fiDispatchNo - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiDispatchNo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGiayPhep16>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdGiayPhep16> tbdGiayPhep16List = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep16List = mapper.convertValue(tbdGiayPhep16List, new TypeReference<List<TbdGiayPhep16>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep16List);
	}


}