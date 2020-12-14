package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbsTrangThai17;

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
* @class Mard17TbsTrangThai17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:45
*
*/
@RestController
@RequestMapping("/mard/17/tbsTrangThai17")
public class Mard17TbsTrangThai17Resource extends Mard17CallBack {

	/**
	* @param tbsTrangThai17 - Type: TbsTrangThai17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai17> createTbsTrangThai17(@RequestBody @Valid TbsTrangThai17 tbsTrangThai17) {
		tbsTrangThai17 = createRestTemplate(getURL("/mard/17/tbsTrangThai17/create"), tbsTrangThai17, HttpMethod.POST, null, TbsTrangThai17.class);
		return ResponseEntity.ok().body(tbsTrangThai17);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsTrangThai17 - Type: TbsTrangThai17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai17> updateTbsTrangThai17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsTrangThai17 tbsTrangThai17) {
		tbsTrangThai17 = createRestTemplate(getURL("/mard/17/tbsTrangThai17/update/") + fiId, tbsTrangThai17, HttpMethod.POST, null, TbsTrangThai17.class);
		return ResponseEntity.ok().body(tbsTrangThai17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai17> deleteTbsTrangThai17(@PathVariable("fiId") Long fiId) {
		TbsTrangThai17 tbsTrangThai17 = createRestTemplate(getURL("/mard/17/tbsTrangThai17/delete/") + fiId, null, HttpMethod.GET, null, TbsTrangThai17.class);
		return ResponseEntity.ok().body(tbsTrangThai17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai17> getTbsTrangThai17(@PathVariable("fiId") Long fiId) {
		TbsTrangThai17 tbsTrangThai17 = createRestTemplate(getURL("/mard/17/tbsTrangThai17/get/") + fiId, null, HttpMethod.GET, null, TbsTrangThai17.class);
		return ResponseEntity.ok().body(tbsTrangThai17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTrangThai17>> findAllTbsTrangThai17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTrangThai17> tbsTrangThai17List = createRestTemplate(getURL("/mard/17/tbsTrangThai17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTrangThai17List = mapper.convertValue(tbsTrangThai17List, new TypeReference<List<TbsTrangThai17>>() {});

		return ResponseEntity.ok().body(tbsTrangThai17List);
	}


}
