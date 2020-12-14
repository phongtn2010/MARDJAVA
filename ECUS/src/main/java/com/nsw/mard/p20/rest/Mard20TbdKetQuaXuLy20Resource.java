package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p20.model.KetQuaXuLy20DTO;
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
* @class Mard20TbdKetQuaXuLy20Resource
* Created by Nguyen Van Quang
* 11/12/2020 10:07:11
*
*/
@RestController
@RequestMapping("/mard/20/tbdKetQuaXuLy20")
public class Mard20TbdKetQuaXuLy20Resource extends Mard20CallBack {
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard20TbdKetQuaXuLy20Resource.class);

	/**
	* @param tbdKetQuaXuLy20 - Type: TbdKetQuaXuLy20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy20> createTbdKetQuaXuLy20(@RequestBody @Valid TbdKetQuaXuLy20 tbdKetQuaXuLy20) {
		tbdKetQuaXuLy20 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/create"), tbdKetQuaXuLy20, HttpMethod.POST, null, TbdKetQuaXuLy20.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy20);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdKetQuaXuLy20 - Type: TbdKetQuaXuLy20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy20> updateTbdKetQuaXuLy20(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdKetQuaXuLy20 tbdKetQuaXuLy20) {
		tbdKetQuaXuLy20 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/update/") + fiId, tbdKetQuaXuLy20, HttpMethod.POST, null, TbdKetQuaXuLy20.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy20> deleteTbdKetQuaXuLy20(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy20 tbdKetQuaXuLy20 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/delete/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy20.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy20> getTbdKetQuaXuLy20(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy20 tbdKetQuaXuLy20 = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/get/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy20.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdKetQuaXuLy20>> findAllTbdKetQuaXuLy20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdKetQuaXuLy20> tbdKetQuaXuLy20List = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdKetQuaXuLy20List = mapper.convertValue(tbdKetQuaXuLy20List, new TypeReference<List<TbdKetQuaXuLy20>>() {});

		return ResponseEntity.ok().body(tbdKetQuaXuLy20List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<Page<KetQuaXuLy20DTO>> page(@RequestBody @Valid PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		LOGGER.info("fiIdhoso: {}", fiIdHoSo);
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		com.nsw.mard.p20.model.Page<KetQuaXuLy20DTO> page = createRestTemplate(getURL("/mard/18/tbdKetQuaXuLy18/page"), pageableDTO, HttpMethod.POST, params, com.nsw.mard.p20.model.Page.class);
		ObjectMapper mapper = new ObjectMapper();
		try{
		List<KetQuaXuLy20DTO> ketQuaXuLy20DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<KetQuaXuLy20DTO>>() {});
		page.setContent(ketQuaXuLy20DTOList);

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
	@RequestMapping(value = "/findSoCongVanByMaThuTuc/{fiTaxCode}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> findSoCongVanByMaThuTuc(@PathVariable("fiTaxCode")String fiTaxCode) {
		List<String> ListCongVan = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findSoCongVanByMaThuTuc/") + fiTaxCode, null, HttpMethod.GET, null, List.class);
		return ResponseEntity.ok().body(ListCongVan);
	}
	


}
