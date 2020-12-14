package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.TbsTepDinhKem18;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbsTepDinhKem19;

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
* @class Mard19TbsTepDinhKem19Resource
* Created by Nguyen Van Quang
* 11/12/2019 10:08:192
*
*/
@RestController
@RequestMapping("/mard/19/tbsTepDinhKem19")
public class Mard19TbsTepDinhKem19Resource extends Mard19CallBack {

	/**
	* @param tbsTepDinhKem19 - Type: TbsTepDinhKem19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem19> createTbsTepDinhKem19(@RequestBody @Valid TbsTepDinhKem19 tbsTepDinhKem19) {
		tbsTepDinhKem19 = createRestTemplate(getURL("/mard/19/tbsTepDinhKem19/create"), tbsTepDinhKem19, HttpMethod.POST, null, TbsTepDinhKem19.class);
		return ResponseEntity.ok().body(tbsTepDinhKem19);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @param tbsTepDinhKem19 - Type: TbsTepDinhKem19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{tepDinhKemId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem19> updateTbsTepDinhKem19(@PathVariable("tepDinhKemId") Long tepDinhKemId, @RequestBody @Valid TbsTepDinhKem19 tbsTepDinhKem19) {
		tbsTepDinhKem19 = createRestTemplate(getURL("/mard/19/tbsTepDinhKem19/update/") + tepDinhKemId, tbsTepDinhKem19, HttpMethod.POST, null, TbsTepDinhKem19.class);
		return ResponseEntity.ok().body(tbsTepDinhKem19);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem19> deleteTbsTepDinhKem19(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem19 tbsTepDinhKem19 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/delete/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem19.class);
		return ResponseEntity.ok().body(tbsTepDinhKem19);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem19> getTbsTepDinhKem19(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem19 tbsTepDinhKem19 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/get/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem19.class);
		return ResponseEntity.ok().body(tbsTepDinhKem19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTepDinhKem19>> findAllTbsTepDinhKem19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTepDinhKem19> tbsTepDinhKem19List = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem19List = mapper.convertValue(tbsTepDinhKem19List, new TypeReference<List<TbsTepDinhKem19>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem19List);
	}

	/**
	* @param loaiThuTuc - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByLoaiThuTuc", method = RequestMethod.GET)
	public ResponseEntity<List<TbsTepDinhKem18>> findByLoaiThuTucOrderByFiSortAsc(@RequestParam(name = "loaiThuTuc", required = false) String loaiThuTuc) {

		Map<String, Object> params = new HashMap<>();
		params.put("loaiThuTuc", loaiThuTuc);
		List<TbsTepDinhKem18> tbsTepDinhKem18List = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/findByLoaiThuTuc"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem18List = mapper.convertValue(tbsTepDinhKem18List, new TypeReference<List<TbsTepDinhKem18>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem18List);
	}


}
