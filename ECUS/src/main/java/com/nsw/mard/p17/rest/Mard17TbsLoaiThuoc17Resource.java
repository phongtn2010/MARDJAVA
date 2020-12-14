package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbsLoaiThuoc17;

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
* @class Mard17TbsLoaiThuoc17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:06
*
*/
@RestController
@RequestMapping("/mard/17/tbsLoaiThuoc17")
public class Mard17TbsLoaiThuoc17Resource extends Mard17CallBack {

	/**
	* @param tbsLoaiThuoc17 - Type: TbsLoaiThuoc17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc17> createTbsLoaiThuoc17(@RequestBody @Valid TbsLoaiThuoc17 tbsLoaiThuoc17) {
		tbsLoaiThuoc17 = createRestTemplate(getURL("/mard/17/tbsLoaiThuoc17/create"), tbsLoaiThuoc17, HttpMethod.POST, null, TbsLoaiThuoc17.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsLoaiThuoc17 - Type: TbsLoaiThuoc17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsLoaiThuoc17> updateTbsLoaiThuoc17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsLoaiThuoc17 tbsLoaiThuoc17) {
		tbsLoaiThuoc17 = createRestTemplate(getURL("/mard/17/tbsLoaiThuoc17/update/") + fiId, tbsLoaiThuoc17, HttpMethod.POST, null, TbsLoaiThuoc17.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc17> deleteTbsLoaiThuoc17(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc17 tbsLoaiThuoc17 = createRestTemplate(getURL("/mard/17/tbsLoaiThuoc17/delete/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc17.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsLoaiThuoc17> getTbsLoaiThuoc17(@PathVariable("fiId") Long fiId) {
		TbsLoaiThuoc17 tbsLoaiThuoc17 = createRestTemplate(getURL("/mard/17/tbsLoaiThuoc17/get/") + fiId, null, HttpMethod.GET, null, TbsLoaiThuoc17.class);
		return ResponseEntity.ok().body(tbsLoaiThuoc17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsLoaiThuoc17>> findAllTbsLoaiThuoc17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsLoaiThuoc17> tbsLoaiThuoc17List = createRestTemplate(getURL("/mard/17/tbsLoaiThuoc17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsLoaiThuoc17List = mapper.convertValue(tbsLoaiThuoc17List, new TypeReference<List<TbsLoaiThuoc17>>() {});

		return ResponseEntity.ok().body(tbsLoaiThuoc17List);
	}


}
