package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbdGPThuoc17;

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
* @class Mard17TbdGPThuoc17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
@RestController
@RequestMapping("/mard/17/tbdGPThuoc17")
public class Mard17TbdGPThuoc17Resource extends Mard17CallBack {

	/**
	* @param tbdGPThuoc17 - Type: TbdGPThuoc17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdGPThuoc17> createTbdGPThuoc17(@RequestBody @Valid TbdGPThuoc17 tbdGPThuoc17) {
		tbdGPThuoc17 = createRestTemplate(getURL("/mard/17/tbdGPThuoc17/create"), tbdGPThuoc17, HttpMethod.POST, null, TbdGPThuoc17.class);
		return ResponseEntity.ok().body(tbdGPThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdGPThuoc17 - Type: TbdGPThuoc17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdGPThuoc17> updateTbdGPThuoc17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGPThuoc17 tbdGPThuoc17) {
		tbdGPThuoc17 = createRestTemplate(getURL("/mard/17/tbdGPThuoc17/update/") + fiId, tbdGPThuoc17, HttpMethod.POST, null, TbdGPThuoc17.class);
		return ResponseEntity.ok().body(tbdGPThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGPThuoc17> deleteTbdGPThuoc17(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc17 tbdGPThuoc17 = createRestTemplate(getURL("/mard/17/tbdGPThuoc17/delete/") + fiId, null, HttpMethod.GET, null, TbdGPThuoc17.class);
		return ResponseEntity.ok().body(tbdGPThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGPThuoc17> getTbdGPThuoc17(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc17 tbdGPThuoc17 = createRestTemplate(getURL("/mard/17/tbdGPThuoc17/get/") + fiId, null, HttpMethod.GET, null, TbdGPThuoc17.class);
		return ResponseEntity.ok().body(tbdGPThuoc17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdGPThuoc17>> findAllTbdGPThuoc17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGPThuoc17> tbdGPThuoc17List = createRestTemplate(getURL("/mard/17/tbdGPThuoc17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGPThuoc17List = mapper.convertValue(tbdGPThuoc17List, new TypeReference<List<TbdGPThuoc17>>() {});

		return ResponseEntity.ok().body(tbdGPThuoc17List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGPThuoc17>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGPThuoc17> tbdGPThuoc17List = createRestTemplate(getURL("/mard/17/tbdGPThuoc17/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGPThuoc17List = mapper.convertValue(tbdGPThuoc17List, new TypeReference<List<TbdGPThuoc17>>() {});
		return ResponseEntity.ok().body(tbdGPThuoc17List);
	}


}
