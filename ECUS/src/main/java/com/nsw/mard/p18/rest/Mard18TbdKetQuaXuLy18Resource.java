package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p18.model.KetQuaXuLy18DTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/***
*
*
* @RestController
* @class Mard18TbdKetQuaXuLy18Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:11
*
*/
@RestController
@RequestMapping("/mard/18/tbdKetQuaXuLy18")
public class Mard18TbdKetQuaXuLy18Resource extends Mard18CallBack {
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard18TbdKetQuaXuLy18Resource.class);

	/**
	* @param tbdKetQuaXuLy18 - Type: TbdKetQuaXuLy18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy18> createTbdKetQuaXuLy18(@RequestBody @Valid TbdKetQuaXuLy18 tbdKetQuaXuLy18) {
		tbdKetQuaXuLy18 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/create"), tbdKetQuaXuLy18, HttpMethod.POST, null, TbdKetQuaXuLy18.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy18);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdKetQuaXuLy18 - Type: TbdKetQuaXuLy18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy18> updateTbdKetQuaXuLy18(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdKetQuaXuLy18 tbdKetQuaXuLy18) {
		tbdKetQuaXuLy18 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/update/") + fiId, tbdKetQuaXuLy18, HttpMethod.POST, null, TbdKetQuaXuLy18.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy18> deleteTbdKetQuaXuLy18(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy18 tbdKetQuaXuLy18 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/delete/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy18.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy18> getTbdKetQuaXuLy18(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy18 tbdKetQuaXuLy18 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/get/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy18.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdKetQuaXuLy18>> findAllTbdKetQuaXuLy18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdKetQuaXuLy18> tbdKetQuaXuLy18List = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdKetQuaXuLy18List = mapper.convertValue(tbdKetQuaXuLy18List, new TypeReference<List<TbdKetQuaXuLy18>>() {});

		return ResponseEntity.ok().body(tbdKetQuaXuLy18List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<Page<KetQuaXuLy18DTO>> page(@RequestBody @Valid PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		LOGGER.info("fiIdhoso: {}", fiIdHoSo);
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		com.nsw.mard.p18.model.Page<KetQuaXuLy18DTO> page = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/page"), pageableDTO, HttpMethod.POST, params, com.nsw.mard.p18.model.Page.class);
		ObjectMapper mapper = new ObjectMapper();
		try{
		List<KetQuaXuLy18DTO> ketQuaXuLy18DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<KetQuaXuLy18DTO>>() {});
		page.setContent(ketQuaXuLy18DTOList);

		}

		catch (IllegalArgumentException IArgEx){
			LOGGER.error("Args ex: {}" , IArgEx.toString());
			LOGGER.error("Args ex" + IArgEx.getMessage(),IArgEx);
			IArgEx.printStackTrace();
		}
		catch (Exception ex){
			LOGGER.error("Ex: {}", ex.toString());
			LOGGER.error("Ex: " + ex.getMessage(),ex);
			ex.printStackTrace();
		}
		return ResponseEntity.ok().body(page);

	}
	


}
