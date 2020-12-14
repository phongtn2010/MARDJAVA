package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbsTrangThai14;

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
* @class Mard14TbsTrangThai14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:45
*
*/
@RestController
@RequestMapping("/mard/14/tbsTrangThai14")
public class Mard14TbsTrangThai14Resource extends Mard14CallBack {

	/**
	* @param tbsTrangThai14 - Type: TbsTrangThai14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai14> createTbsTrangThai14(@RequestBody @Valid TbsTrangThai14 tbsTrangThai14) {
		tbsTrangThai14 = createRestTemplate(getURL("/mard/14/tbsTrangThai14/create"), tbsTrangThai14, HttpMethod.POST, null, TbsTrangThai14.class);
		return ResponseEntity.ok().body(tbsTrangThai14);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsTrangThai14 - Type: TbsTrangThai14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai14> updateTbsTrangThai14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsTrangThai14 tbsTrangThai14) {
		tbsTrangThai14 = createRestTemplate(getURL("/mard/14/tbsTrangThai14/update/") + fiId, tbsTrangThai14, HttpMethod.POST, null, TbsTrangThai14.class);
		return ResponseEntity.ok().body(tbsTrangThai14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai14> deleteTbsTrangThai14(@PathVariable("fiId") Long fiId) {
		TbsTrangThai14 tbsTrangThai14 = createRestTemplate(getURL("/mard/14/tbsTrangThai14/delete/") + fiId, null, HttpMethod.GET, null, TbsTrangThai14.class);
		return ResponseEntity.ok().body(tbsTrangThai14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai14> getTbsTrangThai14(@PathVariable("fiId") Long fiId) {
		TbsTrangThai14 tbsTrangThai14 = createRestTemplate(getURL("/mard/14/tbsTrangThai14/get/") + fiId, null, HttpMethod.GET, null, TbsTrangThai14.class);
		return ResponseEntity.ok().body(tbsTrangThai14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTrangThai14>> findAllTbsTrangThai14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTrangThai14> tbsTrangThai14List = createRestTemplate(getURL("/mard/14/tbsTrangThai14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTrangThai14List = mapper.convertValue(tbsTrangThai14List, new TypeReference<List<TbsTrangThai14>>() {});

		return ResponseEntity.ok().body(tbsTrangThai14List);
	}


}