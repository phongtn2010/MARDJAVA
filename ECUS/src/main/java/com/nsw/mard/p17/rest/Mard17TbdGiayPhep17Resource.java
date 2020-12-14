package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbdGiayPhep17;

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
* @class Mard17TbdGiayPhep17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
@RestController
@RequestMapping("/mard/17/tbdGiayPhep17")
public class Mard17TbdGiayPhep17Resource extends Mard17CallBack {

	/**
	* @param tbdGiayPhep17 - Type: TbdGiayPhep17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdGiayPhep17> createTbdGiayPhep17(@RequestBody @Valid TbdGiayPhep17 tbdGiayPhep17) {
		tbdGiayPhep17 = createRestTemplate(getURL("/mard/17/tbdGiayPhep17/create"), tbdGiayPhep17, HttpMethod.POST, null, TbdGiayPhep17.class);
		return ResponseEntity.ok().body(tbdGiayPhep17);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdGiayPhep17 - Type: TbdGiayPhep17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdGiayPhep17> updateTbdGiayPhep17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGiayPhep17 tbdGiayPhep17) {
		tbdGiayPhep17 = createRestTemplate(getURL("/mard/17/tbdGiayPhep17/update/") + fiId, tbdGiayPhep17, HttpMethod.POST, null, TbdGiayPhep17.class);
		return ResponseEntity.ok().body(tbdGiayPhep17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGiayPhep17> deleteTbdGiayPhep17(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep17 tbdGiayPhep17 = createRestTemplate(getURL("/mard/17/tbdGiayPhep17/delete/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep17.class);
		return ResponseEntity.ok().body(tbdGiayPhep17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGiayPhep17> getTbdGiayPhep17(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep17 tbdGiayPhep17 = createRestTemplate(getURL("/mard/17/tbdGiayPhep17/get/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep17.class);
		return ResponseEntity.ok().body(tbdGiayPhep17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdGiayPhep17>> findAllTbdGiayPhep17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGiayPhep17> tbdGiayPhep17List = createRestTemplate(getURL("/mard/17/tbdGiayPhep17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep17List = mapper.convertValue(tbdGiayPhep17List, new TypeReference<List<TbdGiayPhep17>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep17List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGiayPhep17>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep17> tbdGiayPhep17List = createRestTemplate(getURL("/mard/17/tbdGiayPhep17/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep17List = mapper.convertValue(tbdGiayPhep17List, new TypeReference<List<TbdGiayPhep17>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep17List);
	}

	/**
	* @param fiDispatchNo - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiDispatchNo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGiayPhep17>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdGiayPhep17> tbdGiayPhep17List = createRestTemplate(getURL("/mard/17/tbdGiayPhep17/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep17List = mapper.convertValue(tbdGiayPhep17List, new TypeReference<List<TbdGiayPhep17>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep17List);
	}


}
