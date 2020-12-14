package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbsTrangThai18;

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
* @class Mard18TbsTrangThai18Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:45
*
*/
@RestController
@RequestMapping("/mard/18/tbsTrangThai18")
public class Mard18TbsTrangThai18Resource extends Mard18CallBack {

	/**
	* @param tbsTrangThai18 - Type: TbsTrangThai18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai18> createTbsTrangThai18(@RequestBody @Valid TbsTrangThai18 tbsTrangThai18) {
		tbsTrangThai18 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/create"), tbsTrangThai18, HttpMethod.POST, null, TbsTrangThai18.class);
		return ResponseEntity.ok().body(tbsTrangThai18);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsTrangThai18 - Type: TbsTrangThai18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai18> updateTbsTrangThai18(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsTrangThai18 tbsTrangThai18) {
		tbsTrangThai18 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/update/") + fiId, tbsTrangThai18, HttpMethod.POST, null, TbsTrangThai18.class);
		return ResponseEntity.ok().body(tbsTrangThai18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai18> deleteTbsTrangThai18(@PathVariable("fiId") Long fiId) {
		TbsTrangThai18 tbsTrangThai18 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/delete/") + fiId, null, HttpMethod.GET, null, TbsTrangThai18.class);
		return ResponseEntity.ok().body(tbsTrangThai18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai18> getTbsTrangThai18(@PathVariable("fiId") Long fiId) {
		TbsTrangThai18 tbsTrangThai18 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/get/") + fiId, null, HttpMethod.GET, null, TbsTrangThai18.class);
		return ResponseEntity.ok().body(tbsTrangThai18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTrangThai18>> findAllTbsTrangThai18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTrangThai18> tbsTrangThai18List = createRestTemplate(getURL("/mard/18/tbsTrangThai18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTrangThai18List = mapper.convertValue(tbsTrangThai18List, new TypeReference<List<TbsTrangThai18>>() {});

		return ResponseEntity.ok().body(tbsTrangThai18List);
	}


}
