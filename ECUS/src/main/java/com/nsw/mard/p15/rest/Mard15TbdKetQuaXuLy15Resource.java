package com.nsw.mard.p15.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p15.model.KetQuaXuLy15DTO;
import com.nsw.mard.p15.model.TbdKetQuaXuLy15;
import com.nsw.mard.p15.model.Page;
import com.nsw.mard.p15.model.PageableDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
* @class Mard15TbdKetQuaXuLy15Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:11
*
*/
@RestController
@RequestMapping("/mard/15/tbdKetQuaXuLy15")
public class Mard15TbdKetQuaXuLy15Resource extends Mard15CallBack {

	/**
	* @param tbdKetQuaXuLy15 - Type: TbdKetQuaXuLy15
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy15> createTbdKetQuaXuLy15(@RequestBody @Valid TbdKetQuaXuLy15 tbdKetQuaXuLy15) {
		tbdKetQuaXuLy15 = createRestTemplate(getURL("/mard/15/tbdKetQuaXuLy15/create"), tbdKetQuaXuLy15, HttpMethod.POST, null, TbdKetQuaXuLy15.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy15);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdKetQuaXuLy15 - Type: TbdKetQuaXuLy15
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy15> updateTbdKetQuaXuLy15(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdKetQuaXuLy15 tbdKetQuaXuLy15) {
		tbdKetQuaXuLy15 = createRestTemplate(getURL("/mard/15/tbdKetQuaXuLy15/update/") + fiId, tbdKetQuaXuLy15, HttpMethod.POST, null, TbdKetQuaXuLy15.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy15> deleteTbdKetQuaXuLy15(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy15 tbdKetQuaXuLy15 = createRestTemplate(getURL("/mard/15/tbdKetQuaXuLy15/delete/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy15.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy15> getTbdKetQuaXuLy15(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy15 tbdKetQuaXuLy15 = createRestTemplate(getURL("/mard/15/tbdKetQuaXuLy15/get/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy15.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy15);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdKetQuaXuLy15>> findAllTbdKetQuaXuLy15(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdKetQuaXuLy15> tbdKetQuaXuLy15List = createRestTemplate(getURL("/mard/15/tbdKetQuaXuLy15/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdKetQuaXuLy15List = mapper.convertValue(tbdKetQuaXuLy15List, new TypeReference<List<TbdKetQuaXuLy15>>() {});

		return ResponseEntity.ok().body(tbdKetQuaXuLy15List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<Page<KetQuaXuLy15DTO>> page(@RequestBody PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		Page<KetQuaXuLy15DTO> page = createRestTemplate(getURL("/mard/15/tbdKetQuaXuLy15/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<KetQuaXuLy15DTO> ketQuaXuLy15DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<KetQuaXuLy15DTO>>() {});
		page.setContent(ketQuaXuLy15DTOList);
		return ResponseEntity.ok().body(page);
	}
	


}