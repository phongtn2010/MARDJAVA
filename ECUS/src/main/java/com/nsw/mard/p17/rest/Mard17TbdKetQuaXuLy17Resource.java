package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p17.model.KetQuaXuLy17DTO;
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
* @class Mard17TbdKetQuaXuLy17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:11
*
*/
@RestController
@RequestMapping("/mard/17/tbdKetQuaXuLy17")
public class Mard17TbdKetQuaXuLy17Resource extends Mard17CallBack {
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard17TbdKetQuaXuLy17Resource.class);

	/**
	* @param tbdKetQuaXuLy17 - Type: TbdKetQuaXuLy17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy17> createTbdKetQuaXuLy17(@RequestBody @Valid TbdKetQuaXuLy17 tbdKetQuaXuLy17) {
		tbdKetQuaXuLy17 = createRestTemplate(getURL("/mard/17/tbdKetQuaXuLy17/create"), tbdKetQuaXuLy17, HttpMethod.POST, null, TbdKetQuaXuLy17.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy17);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdKetQuaXuLy17 - Type: TbdKetQuaXuLy17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy17> updateTbdKetQuaXuLy17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdKetQuaXuLy17 tbdKetQuaXuLy17) {
		tbdKetQuaXuLy17 = createRestTemplate(getURL("/mard/17/tbdKetQuaXuLy17/update/") + fiId, tbdKetQuaXuLy17, HttpMethod.POST, null, TbdKetQuaXuLy17.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy17> deleteTbdKetQuaXuLy17(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy17 tbdKetQuaXuLy17 = createRestTemplate(getURL("/mard/17/tbdKetQuaXuLy17/delete/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy17.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy17> getTbdKetQuaXuLy17(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy17 tbdKetQuaXuLy17 = createRestTemplate(getURL("/mard/17/tbdKetQuaXuLy17/get/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy17.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdKetQuaXuLy17>> findAllTbdKetQuaXuLy17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdKetQuaXuLy17> tbdKetQuaXuLy17List = createRestTemplate(getURL("/mard/17/tbdKetQuaXuLy17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdKetQuaXuLy17List = mapper.convertValue(tbdKetQuaXuLy17List, new TypeReference<List<TbdKetQuaXuLy17>>() {});

		return ResponseEntity.ok().body(tbdKetQuaXuLy17List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<Page<KetQuaXuLy17DTO>> page(@RequestBody @Valid PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		LOGGER.info("fiIdhoso: {}", fiIdHoSo);
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		com.nsw.mard.p17.model.Page<KetQuaXuLy17DTO> page = createRestTemplate(getURL("/mard/17/tbdKetQuaXuLy17/page"), pageableDTO, HttpMethod.POST, params, com.nsw.mard.p17.model.Page.class);
		ObjectMapper mapper = new ObjectMapper();
		try{
		List<KetQuaXuLy17DTO> ketQuaXuLy17DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<KetQuaXuLy17DTO>>() {});
		page.setContent(ketQuaXuLy17DTOList);

		}

		catch (IllegalArgumentException IArgEx){
			LOGGER.error(IArgEx.getMessage(), IArgEx);
			LOGGER.error("Args ex: {}" , IArgEx.toString());
			IArgEx.printStackTrace();
		}
		catch (Exception ex){
			LOGGER.error("Ex: {}", ex.toString());
			LOGGER.error(ex.getMessage(), ex);
			ex.printStackTrace();
		}
		return ResponseEntity.ok().body(page);

	}
	


}
