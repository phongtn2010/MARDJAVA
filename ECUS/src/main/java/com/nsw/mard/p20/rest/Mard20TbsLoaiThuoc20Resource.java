package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbsLoaiThuoc20;

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
* @class Mard20TbsLoaiThuoc20Resource
* Created by Nguyen Van Quang
* 11/12/2020 10:08:06
*
*/
@RestController
@RequestMapping("/mard/20/tbsLoaiThuoc20")
public class Mard20TbsLoaiThuoc20Resource extends Mard20CallBack {

	/**
	* @param tbsLoaiThuoc20 - Type: TbsLoaiThuoc20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc20> createTbsLoaiThuoc20(@RequestBody @Valid TbsLoaiThuoc20 tbsLoaiThuoc20) {
		tbsLoaiThuoc20 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/create"), tbsLoaiThuoc20, HttpMethod.POST, null, TbsLoaiThuoc20.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsLoaiThuoc20 - Type: TbsLoaiThuoc20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc20> updateTbsLoaiThuoc20(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsLoaiThuoc20 tbsLoaiThuoc20) {
		tbsLoaiThuoc20 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/update/") + fiId, tbsLoaiThuoc20, HttpMethod.POST, null, TbsLoaiThuoc20.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc20> deleteTbsLoaiThuoc20(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc20 tbsLoaiThuoc20 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/delete/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc20.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc20> getTbsLoaiThuoc20(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc20 tbsLoaiThuoc20 = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc20.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsLoaiThuoc20>> findAllTbsLoaiThuoc20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsLoaiThuoc20> tbsLoaiThuoc20List = createRestTemplate(getURL("/mard/18/tbsLoaiThuoc18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsLoaiThuoc20List = mapper.convertValue(tbsLoaiThuoc20List, new TypeReference<List<TbsLoaiThuoc20>>() {});

		return ResponseEntity.ok().body(tbsLoaiThuoc20List);
	}


}
