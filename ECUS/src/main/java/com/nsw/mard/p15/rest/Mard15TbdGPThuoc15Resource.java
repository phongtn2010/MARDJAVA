package com.nsw.mard.p15.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p15.model.PageableDTO;
import com.nsw.mard.p15.model.TbdGPThuoc15;

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
* @class Mard15TbdGPThuoc15Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
@RestController
@RequestMapping("/mard/15/tbdGPThuoc15")
public class Mard15TbdGPThuoc15Resource extends Mard15CallBack {

	/**
	* @param tbdGPThuoc15 - Type: TbdGPThuoc15
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdGPThuoc15> createTbdGPThuoc15(@RequestBody @Valid TbdGPThuoc15 tbdGPThuoc15) {
		tbdGPThuoc15 = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/create"), tbdGPThuoc15, HttpMethod.POST, null, TbdGPThuoc15.class);
		return ResponseEntity.ok().body(tbdGPThuoc15);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdGPThuoc15 - Type: TbdGPThuoc15
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdGPThuoc15> updateTbdGPThuoc15(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGPThuoc15 tbdGPThuoc15) {
		tbdGPThuoc15 = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/update/") + fiId, tbdGPThuoc15, HttpMethod.POST, null, TbdGPThuoc15.class);
		return ResponseEntity.ok().body(tbdGPThuoc15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGPThuoc15> deleteTbdGPThuoc15(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc15 tbdGPThuoc15 = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/delete/") + fiId, null, HttpMethod.GET, null, TbdGPThuoc15.class);
		return ResponseEntity.ok().body(tbdGPThuoc15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdGPThuoc15> getTbdGPThuoc15(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc15 tbdGPThuoc15 = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/get/") + fiId, null, HttpMethod.GET, null, TbdGPThuoc15.class);
		return ResponseEntity.ok().body(tbdGPThuoc15);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdGPThuoc15>> findAllTbdGPThuoc15(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGPThuoc15> tbdGPThuoc15List = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGPThuoc15List = mapper.convertValue(tbdGPThuoc15List, new TypeReference<List<TbdGPThuoc15>>() {});

		return ResponseEntity.ok().body(tbdGPThuoc15List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdGPThuoc15>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGPThuoc15> tbdGPThuoc15List = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGPThuoc15List = mapper.convertValue(tbdGPThuoc15List, new TypeReference<List<TbdGPThuoc15>>() {});

		return ResponseEntity.ok().body(tbdGPThuoc15List);
	}


}