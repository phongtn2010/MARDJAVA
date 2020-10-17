package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbsLoaiThuoc14;

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
* @class Mard14TbsLoaiThuoc14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:06
*
*/
@RestController
@RequestMapping("/mard/14/tbsLoaiThuoc14")
public class Mard14TbsLoaiThuoc14Resource extends Mard14CallBack {

	/**
	* @param tbsLoaiThuoc14 - Type: TbsLoaiThuoc14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc14> createTbsLoaiThuoc14(@RequestBody @Valid TbsLoaiThuoc14 tbsLoaiThuoc14) {
		tbsLoaiThuoc14 = createRestTemplate(getURL("/mard/14/tbsLoaiThuoc14/create"), tbsLoaiThuoc14, HttpMethod.POST, null, TbsLoaiThuoc14.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsLoaiThuoc14 - Type: TbsLoaiThuoc14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc14> updateTbsLoaiThuoc14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsLoaiThuoc14 tbsLoaiThuoc14) {
		tbsLoaiThuoc14 = createRestTemplate(getURL("/mard/14/tbsLoaiThuoc14/update/") + fiId, tbsLoaiThuoc14, HttpMethod.POST, null, TbsLoaiThuoc14.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc14> deleteTbsLoaiThuoc14(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc14 tbsLoaiThuoc14 = createRestTemplate(getURL("/mard/14/tbsLoaiThuoc14/delete/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc14.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc14> getTbsLoaiThuoc14(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc14 tbsLoaiThuoc14 = createRestTemplate(getURL("/mard/14/tbsLoaiThuoc14/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc14.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsLoaiThuoc14>> findAllTbsLoaiThuoc14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsLoaiThuoc14> tbsLoaiThuoc14List = createRestTemplate(getURL("/mard/14/tbsLoaiThuoc14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsLoaiThuoc14List = mapper.convertValue(tbsLoaiThuoc14List, new TypeReference<List<TbsLoaiThuoc14>>() {});

		return ResponseEntity.ok().body(tbsLoaiThuoc14List);
	}


}