package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbsLoaiThuoc19;

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
* @class Mard19TbsLoaiThuoc19Resource
* Created by Nguyen Van Quang
* 11/12/2019 10:08:06
*
*/
@RestController
@RequestMapping("/mard/19/tbsLoaiThuoc19")
public class Mard19TbsLoaiThuoc19Resource extends Mard19CallBack {

	/**
	* @param tbsLoaiThuoc19 - Type: TbsLoaiThuoc19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc19> createTbsLoaiThuoc19(@RequestBody @Valid TbsLoaiThuoc19 tbsLoaiThuoc19) {
		tbsLoaiThuoc19 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/create"), tbsLoaiThuoc19, HttpMethod.POST, null, TbsLoaiThuoc19.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsLoaiThuoc19 - Type: TbsLoaiThuoc19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc19> updateTbsLoaiThuoc19(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsLoaiThuoc19 tbsLoaiThuoc19) {
		tbsLoaiThuoc19 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/update/") + fiId, tbsLoaiThuoc19, HttpMethod.POST, null, TbsLoaiThuoc19.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc19> deleteTbsLoaiThuoc19(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc19 tbsLoaiThuoc19 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/delete/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc19.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc19> getTbsLoaiThuoc19(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc19 tbsLoaiThuoc19 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc19.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsLoaiThuoc19>> findAllTbsLoaiThuoc19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsLoaiThuoc19> tbsLoaiThuoc19List = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsLoaiThuoc19List = mapper.convertValue(tbsLoaiThuoc19List, new TypeReference<List<TbsLoaiThuoc19>>() {});

		return ResponseEntity.ok().body(tbsLoaiThuoc19List);
	}


}
