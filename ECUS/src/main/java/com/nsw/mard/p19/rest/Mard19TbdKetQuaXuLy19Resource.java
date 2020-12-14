package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p19.model.KetQuaXuLy19DTO;
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
* @class Mard19TbdKetQuaXuLy19Resource
* Created by Nguyen Van Quang
* 11/12/2019 10:07:11
*
*/
@RestController
@RequestMapping("/mard/19/tbdKetQuaXuLy19")
public class Mard19TbdKetQuaXuLy19Resource extends Mard19CallBack {
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard19TbdKetQuaXuLy19Resource.class);

	/**
	* @param tbdKetQuaXuLy19 - Type: TbdKetQuaXuLy19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy19> createTbdKetQuaXuLy19(@RequestBody @Valid TbdKetQuaXuLy19 tbdKetQuaXuLy19) {
		tbdKetQuaXuLy19 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/create"), tbdKetQuaXuLy19, HttpMethod.POST, null, TbdKetQuaXuLy19.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy19);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdKetQuaXuLy19 - Type: TbdKetQuaXuLy19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy19> updateTbdKetQuaXuLy19(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdKetQuaXuLy19 tbdKetQuaXuLy19) {
		tbdKetQuaXuLy19 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/update/") + fiId, tbdKetQuaXuLy19, HttpMethod.POST, null, TbdKetQuaXuLy19.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy19> deleteTbdKetQuaXuLy19(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy19 tbdKetQuaXuLy19 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/delete/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy19.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy19> getTbdKetQuaXuLy19(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy19 tbdKetQuaXuLy19 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/get/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy19.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdKetQuaXuLy19>> findAllTbdKetQuaXuLy19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdKetQuaXuLy19> tbdKetQuaXuLy19List = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdKetQuaXuLy19List = mapper.convertValue(tbdKetQuaXuLy19List, new TypeReference<List<TbdKetQuaXuLy19>>() {});

		return ResponseEntity.ok().body(tbdKetQuaXuLy19List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<Page<KetQuaXuLy19DTO>> page(@RequestBody @Valid PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		LOGGER.info("fiIdhoso: {}", fiIdHoSo);
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		com.nsw.mard.p19.model.Page<KetQuaXuLy19DTO> page = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/page"), pageableDTO, HttpMethod.POST, params, com.nsw.mard.p19.model.Page.class);
		ObjectMapper mapper = new ObjectMapper();
		try{
		List<KetQuaXuLy19DTO> ketQuaXuLy19DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<KetQuaXuLy19DTO>>() {});
		page.setContent(ketQuaXuLy19DTOList);

		}

		catch (IllegalArgumentException IArgEx){
			LOGGER.error("Args ex: {}" , IArgEx.toString());
			LOGGER.error("Args ex" +IArgEx.getMessage(), IArgEx);
			IArgEx.printStackTrace();
		}
		catch (Exception ex){
			LOGGER.error("Ex: {}", ex.toString());
			LOGGER.error("Ex" +ex.getMessage(), ex);
			ex.printStackTrace();
		}
		return ResponseEntity.ok().body(page);

	}
	


}
