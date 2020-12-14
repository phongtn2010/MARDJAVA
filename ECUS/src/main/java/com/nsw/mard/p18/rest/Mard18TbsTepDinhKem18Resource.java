package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbsTepDinhKem18;

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
* @class Mard18TbsTepDinhKem18Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:182
*
*/
@RestController
@RequestMapping("/mard/18/tbsTepDinhKem18")
public class Mard18TbsTepDinhKem18Resource extends Mard18CallBack {

	/**
	* @param tbsTepDinhKem18 - Type: TbsTepDinhKem18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem18> createTbsTepDinhKem18(@RequestBody @Valid TbsTepDinhKem18 tbsTepDinhKem18) {
		tbsTepDinhKem18 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/create"), tbsTepDinhKem18, HttpMethod.POST, null, TbsTepDinhKem18.class);
		return ResponseEntity.ok().body(tbsTepDinhKem18);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @param tbsTepDinhKem18 - Type: TbsTepDinhKem18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{tepDinhKemId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem18> updateTbsTepDinhKem18(@PathVariable("tepDinhKemId") Long tepDinhKemId, @RequestBody @Valid TbsTepDinhKem18 tbsTepDinhKem18) {
		tbsTepDinhKem18 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/update/") + tepDinhKemId, tbsTepDinhKem18, HttpMethod.POST, null, TbsTepDinhKem18.class);
		return ResponseEntity.ok().body(tbsTepDinhKem18);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem18> deleteTbsTepDinhKem18(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem18 tbsTepDinhKem18 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/delete/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem18.class);
		return ResponseEntity.ok().body(tbsTepDinhKem18);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem18> getTbsTepDinhKem18(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem18 tbsTepDinhKem18 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/get/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem18.class);
		return ResponseEntity.ok().body(tbsTepDinhKem18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTepDinhKem18>> findAllTbsTepDinhKem18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTepDinhKem18> tbsTepDinhKem18List = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem18List = mapper.convertValue(tbsTepDinhKem18List, new TypeReference<List<TbsTepDinhKem18>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem18List);
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
