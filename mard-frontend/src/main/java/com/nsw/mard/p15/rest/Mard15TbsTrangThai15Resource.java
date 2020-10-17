package com.nsw.mard.p15.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p15.model.PageableDTO;
import com.nsw.mard.p15.model.TbsTrangThai15;

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
* @class Mard15TbsTrangThai15Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:45
*
*/
@RestController
@RequestMapping("/mard/15/tbsTrangThai15")
public class Mard15TbsTrangThai15Resource extends Mard15CallBack {

	/**
	* @param tbsTrangThai15 - Type: TbsTrangThai15
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai15> createTbsTrangThai15(@RequestBody @Valid TbsTrangThai15 tbsTrangThai15) {
		tbsTrangThai15 = createRestTemplate(getURL("/mard/15/tbsTrangThai15/create"), tbsTrangThai15, HttpMethod.POST, null, TbsTrangThai15.class);
		return ResponseEntity.ok().body(tbsTrangThai15);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsTrangThai15 - Type: TbsTrangThai15
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai15> updateTbsTrangThai15(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsTrangThai15 tbsTrangThai15) {
		tbsTrangThai15 = createRestTemplate(getURL("/mard/15/tbsTrangThai15/update/") + fiId, tbsTrangThai15, HttpMethod.POST, null, TbsTrangThai15.class);
		return ResponseEntity.ok().body(tbsTrangThai15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai15> deleteTbsTrangThai15(@PathVariable("fiId") Long fiId) {
		TbsTrangThai15 tbsTrangThai15 = createRestTemplate(getURL("/mard/15/tbsTrangThai15/delete/") + fiId, null, HttpMethod.GET, null, TbsTrangThai15.class);
		return ResponseEntity.ok().body(tbsTrangThai15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai15> getTbsTrangThai15(@PathVariable("fiId") Long fiId) {
		TbsTrangThai15 tbsTrangThai15 = createRestTemplate(getURL("/mard/15/tbsTrangThai15/get/") + fiId, null, HttpMethod.GET, null, TbsTrangThai15.class);
		return ResponseEntity.ok().body(tbsTrangThai15);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTrangThai15>> findAllTbsTrangThai15(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTrangThai15> tbsTrangThai15List = createRestTemplate(getURL("/mard/15/tbsTrangThai15/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTrangThai15List = mapper.convertValue(tbsTrangThai15List, new TypeReference<List<TbsTrangThai15>>() {});

		return ResponseEntity.ok().body(tbsTrangThai15List);
	}


}
