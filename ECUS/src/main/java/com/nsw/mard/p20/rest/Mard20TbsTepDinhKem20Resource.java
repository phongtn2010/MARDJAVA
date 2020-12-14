package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbsTepDinhKem20;

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
* @class Mard20TbsTepDinhKem20Resource
* Created by Nguyen Van Quang
* 11/12/2020 10:08:202
*
*/
@RestController
@RequestMapping("/mard/20/tbsTepDinhKem20")
public class Mard20TbsTepDinhKem20Resource extends Mard20CallBack {

	/**
	* @param tbsTepDinhKem20 - Type: TbsTepDinhKem20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem20> createTbsTepDinhKem20(@RequestBody @Valid TbsTepDinhKem20 tbsTepDinhKem20) {
		tbsTepDinhKem20 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/create"), tbsTepDinhKem20, HttpMethod.POST, null, TbsTepDinhKem20.class);
		return ResponseEntity.ok().body(tbsTepDinhKem20);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @param tbsTepDinhKem20 - Type: TbsTepDinhKem20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{tepDinhKemId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem20> updateTbsTepDinhKem20(@PathVariable("tepDinhKemId") Long tepDinhKemId, @RequestBody @Valid TbsTepDinhKem20 tbsTepDinhKem20) {
		tbsTepDinhKem20 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/update/") + tepDinhKemId, tbsTepDinhKem20, HttpMethod.POST, null, TbsTepDinhKem20.class);
		return ResponseEntity.ok().body(tbsTepDinhKem20);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem20> deleteTbsTepDinhKem20(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem20 tbsTepDinhKem20 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/delete/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem20.class);
		return ResponseEntity.ok().body(tbsTepDinhKem20);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem20> getTbsTepDinhKem20(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem20 tbsTepDinhKem20 = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/get/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem20.class);
		return ResponseEntity.ok().body(tbsTepDinhKem20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTepDinhKem20>> findAllTbsTepDinhKem20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTepDinhKem20> tbsTepDinhKem20List = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem20List = mapper.convertValue(tbsTepDinhKem20List, new TypeReference<List<TbsTepDinhKem20>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem20List);
	}

	/**
	* @param loaiThuTuc - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByLoaiThuTuc", method = RequestMethod.GET)
	public ResponseEntity<List<TbsTepDinhKem20>> findByLoaiThuTucOrderByFiSortAsc(@RequestParam(name = "loaiThuTuc", required = false) String loaiThuTuc) {

		Map<String, Object> params = new HashMap<>();
		params.put("loaiThuTuc", loaiThuTuc);
		List<TbsTepDinhKem20> tbsTepDinhKem20List = createRestTemplate(getURL("/mard/18/tbsTepDinhKem18/findByLoaiThuTuc"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem20List = mapper.convertValue(tbsTepDinhKem20List, new TypeReference<List<TbsTepDinhKem20>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem20List);
	}


}
