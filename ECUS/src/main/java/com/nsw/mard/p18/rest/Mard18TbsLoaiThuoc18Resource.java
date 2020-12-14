package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbsLoaiThuoc18;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/***
*
*
* @RestController
* @class Mard18TbsLoaiThuoc18Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:06
*
*/
@RestController
@RequestMapping("/mard/18/tbsLoaiThuoc18")
public class Mard18TbsLoaiThuoc18Resource extends Mard18CallBack {

	/**
	* @param tbsLoaiThuoc18 - Type: TbsLoaiThuoc18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc18> createTbsLoaiThuoc18(@RequestBody @Valid TbsLoaiThuoc18 tbsLoaiThuoc18) {
		tbsLoaiThuoc18 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/create"), tbsLoaiThuoc18, HttpMethod.POST, null, TbsLoaiThuoc18.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsLoaiThuoc18 - Type: TbsLoaiThuoc18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc18> updateTbsLoaiThuoc18(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsLoaiThuoc18 tbsLoaiThuoc18) {
		tbsLoaiThuoc18 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/update/") + fiId, tbsLoaiThuoc18, HttpMethod.POST, null, TbsLoaiThuoc18.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc18> deleteTbsLoaiThuoc18(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc18 tbsLoaiThuoc18 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/delete/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc18.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc18> getTbsLoaiThuoc18(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc18 tbsLoaiThuoc18 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc18.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsLoaiThuoc18>> findAllTbsLoaiThuoc18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsLoaiThuoc18> tbsLoaiThuoc18List = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsLoaiThuoc18List = mapper.convertValue(tbsLoaiThuoc18List, new TypeReference<List<TbsLoaiThuoc18>>() {});

		return ResponseEntity.ok().body(tbsLoaiThuoc18List);
	}


}
