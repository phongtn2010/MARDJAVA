package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbsTrangThai19;

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
* @class Mard19TbsTrangThai19Resource
* Created by Nguyen Van Quang
* 11/12/2019 10:08:45
*
*/
@RestController
@RequestMapping("/mard/19/tbsTrangThai19")
public class Mard19TbsTrangThai19Resource extends Mard19CallBack {

	/**
	* @param tbsTrangThai19 - Type: TbsTrangThai19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai19> createTbsTrangThai19(@RequestBody @Valid TbsTrangThai19 tbsTrangThai19) {
		tbsTrangThai19 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/create"), tbsTrangThai19, HttpMethod.POST, null, TbsTrangThai19.class);
		return ResponseEntity.ok().body(tbsTrangThai19);
	}

	/**
	* @param fiId - Type: Long
	* @param tbsTrangThai19 - Type: TbsTrangThai19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTrangThai19> updateTbsTrangThai19(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbsTrangThai19 tbsTrangThai19) {
		tbsTrangThai19 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/update/") + fiId, tbsTrangThai19, HttpMethod.POST, null, TbsTrangThai19.class);
		return ResponseEntity.ok().body(tbsTrangThai19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai19> deleteTbsTrangThai19(@PathVariable("fiId") Long fiId) {
		TbsTrangThai19 tbsTrangThai19 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/delete/") + fiId, null, HttpMethod.GET, null, TbsTrangThai19.class);
		return ResponseEntity.ok().body(tbsTrangThai19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTrangThai19> getTbsTrangThai19(@PathVariable("fiId") Long fiId) {
		TbsTrangThai19 tbsTrangThai19 = createRestTemplate(getURL("/mard/18/tbsTrangThai18/get/") + fiId, null, HttpMethod.GET, null, TbsTrangThai19.class);
		return ResponseEntity.ok().body(tbsTrangThai19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTrangThai19>> findAllTbsTrangThai19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTrangThai19> tbsTrangThai19List = createRestTemplate(getURL("/mard/18/tbsTrangThai18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTrangThai19List = mapper.convertValue(tbsTrangThai19List, new TypeReference<List<TbsTrangThai19>>() {});

		return ResponseEntity.ok().body(tbsTrangThai19List);
	}
}
