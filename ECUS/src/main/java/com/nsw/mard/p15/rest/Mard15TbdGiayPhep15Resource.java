package com.nsw.mard.p15.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p15.model.PageableDTO;
import com.nsw.mard.p15.model.TbdGiayPhep15;

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
* @class Mard15TbdGiayPhep15Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
@RestController
@RequestMapping("/mard/15/tbdGiayPhep15")
public class Mard15TbdGiayPhep15Resource extends Mard15CallBack {

	/**
	* @param tbdGiayPhep15 - Type: TbdGiayPhep15
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdGiayPhep15> createTbdGiayPhep15(@RequestBody @Valid TbdGiayPhep15 tbdGiayPhep15) {
		tbdGiayPhep15 = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/create"), tbdGiayPhep15, HttpMethod.POST, null, TbdGiayPhep15.class);
		return ResponseEntity.ok().body(tbdGiayPhep15);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdGiayPhep15 - Type: TbdGiayPhep15
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdGiayPhep15> updateTbdGiayPhep15(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGiayPhep15 tbdGiayPhep15) {
		tbdGiayPhep15 = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/update/") + fiId, tbdGiayPhep15, HttpMethod.POST, null, TbdGiayPhep15.class);
		return ResponseEntity.ok().body(tbdGiayPhep15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGiayPhep15> deleteTbdGiayPhep15(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep15 tbdGiayPhep15 = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/delete/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep15.class);
		return ResponseEntity.ok().body(tbdGiayPhep15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGiayPhep15> getTbdGiayPhep15(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep15 tbdGiayPhep15 = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/get/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep15.class);
		return ResponseEntity.ok().body(tbdGiayPhep15);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdGiayPhep15>> findAllTbdGiayPhep15(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGiayPhep15> tbdGiayPhep15List = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep15List = mapper.convertValue(tbdGiayPhep15List, new TypeReference<List<TbdGiayPhep15>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep15List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGiayPhep15>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep15> tbdGiayPhep15List = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep15List = mapper.convertValue(tbdGiayPhep15List, new TypeReference<List<TbdGiayPhep15>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep15List);
	}

	/**
	* @param fiDispatchNo - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiDispatchNo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGiayPhep15>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdGiayPhep15> tbdGiayPhep15List = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep15List = mapper.convertValue(tbdGiayPhep15List, new TypeReference<List<TbdGiayPhep15>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep15List);
	}


}