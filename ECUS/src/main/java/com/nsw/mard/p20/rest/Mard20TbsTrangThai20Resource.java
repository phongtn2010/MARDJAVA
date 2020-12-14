package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbsTrangThai20;

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
* @class Mard20TbsTrangThai20Resource
* Created by Nguyen Van Quang
* 11/12/2020 10:08:45
*
*/
@RestController
@RequestMapping("/mard/20/tbsTrangThai20")
public class Mard20TbsTrangThai20Resource extends Mard20CallBack {

	/**
	* @param tbsTrangThai20 - Type: TbsTrangThai20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai20> createTbsTrangThai20(@RequestBody @Valid TbsTrangThai20 tbsTrangThai20) {
		tbsTrangThai20 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/create"), tbsTrangThai20, HttpMethod.POST, null, TbsTrangThai20.class);
		return ResponseEntity.ok().body(tbsTrangThai20);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsTrangThai20 - Type: TbsTrangThai20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai20> updateTbsTrangThai20(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsTrangThai20 tbsTrangThai20) {
		tbsTrangThai20 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/update/") + fiId, tbsTrangThai20, HttpMethod.POST, null, TbsTrangThai20.class);
		return ResponseEntity.ok().body(tbsTrangThai20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai20> deleteTbsTrangThai20(@PathVariable("fiId") Long fiId) {
		TbsTrangThai20 tbsTrangThai20 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/delete/") + fiId, null, HttpMethod.GET, null, TbsTrangThai20.class);
		return ResponseEntity.ok().body(tbsTrangThai20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai20> getTbsTrangThai20(@PathVariable("fiId") Long fiId) {
		TbsTrangThai20 tbsTrangThai20 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/get/") + fiId, null, HttpMethod.GET, null, TbsTrangThai20.class);
		return ResponseEntity.ok().body(tbsTrangThai20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTrangThai20>> findAllTbsTrangThai20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTrangThai20> tbsTrangThai20List = createRestTemplate(getURL("/mard/18/tbsTrangThai18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTrangThai20List = mapper.convertValue(tbsTrangThai20List, new TypeReference<List<TbsTrangThai20>>() {});

		return ResponseEntity.ok().body(tbsTrangThai20List);
	}


}
