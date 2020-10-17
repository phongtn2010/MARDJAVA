package com.nsw.mic.p03.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p03.dto.PageableDTO;
import com.nsw.mic.p03.dto.TbdThietBi03DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
* @class Mic03TbdThietBi03DTOResource
* Created by Nguyen Van Quang
* 11/12/2048 10:06:036
*
*/
@RestController
@RequestMapping("/mic/03/tbdThietBi03")
public class Mic03TbdThietBi03Api extends Mic03CallBack {

	@Autowired
	private Mic03TbdKetQuaXuLy03Api fldMic03TbdKetQuaXuLy03Api;

	@Autowired
	private Mic03TbdHoSo03Api fldMic03TbdHoSo03Api;

	/**
	* @param tbdThietBi03 - Type: TbdThietBi03DTO
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> createTbdThietBi03DTO(@RequestBody @Valid TbdThietBi03DTO tbdThietBi03) {
		ResponseJson responseJson = new ResponseJson();
		if (!isValid(tbdThietBi03)) {
			responseJson.setData(tbdThietBi03);
			return ResponseEntity.badRequest().body(responseJson);
		}
		tbdThietBi03 = createRestTemplate(getURL("/mic/03/tbdThietBi03/create"), tbdThietBi03, HttpMethod.POST, null, TbdThietBi03DTO.class);
		createHistory(fldMic03TbdKetQuaXuLy03Api, fldMic03TbdHoSo03Api, "Tạo mới thông tin thiết bị: " + tbdThietBi03.getFiTenGoc(), tbdThietBi03.getFiIdHoSo());
		responseJson.setData(tbdThietBi03);
		responseJson.setSuccess(true);
		return ResponseEntity.ok().body(responseJson);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThietBi03 - Type: TbdThietBi03DTO
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> updateTbdThietBi03DTO(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThietBi03DTO tbdThietBi03) {
		ResponseJson responseJson = new ResponseJson();
		if (!isValid(tbdThietBi03)) {
			responseJson.setData(tbdThietBi03);
			return ResponseEntity.badRequest().body(responseJson);
		}
		tbdThietBi03 = createRestTemplate(getURL("/mic/03/tbdThietBi03/update/") + fiId, tbdThietBi03, HttpMethod.POST, null, TbdThietBi03DTO.class);
		createHistory(fldMic03TbdKetQuaXuLy03Api, fldMic03TbdHoSo03Api,"Cập nhật thông tin thiết bị: " + tbdThietBi03.getFiTenGoc(), tbdThietBi03.getFiIdHoSo());
		responseJson.setData(tbdThietBi03);
		responseJson.setSuccess(true);
		return ResponseEntity.ok().body(responseJson);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> deleteTbdThietBi03DTO(@PathVariable("fiIdHoSo") Long fiIdHoSo, @PathVariable("fiId") Long fiId) {
		TbdThietBi03DTO tbdThietBi03 = createRestTemplate(getURL("/mic/03/tbdThietBi03/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThietBi03DTO.class);
		createHistory(fldMic03TbdKetQuaXuLy03Api, fldMic03TbdHoSo03Api,"Xóa thông tin thiết bị: " + tbdThietBi03.getFiTenGoc(), fiIdHoSo);

		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(tbdThietBi03);
		return ResponseEntity.ok().body(responseJson);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThietBi03DTO> getTbdThietBi03DTO(@PathVariable("fiId") Long fiId) {
		TbdThietBi03DTO tbdThietBi03 = createRestTemplate(getURL("/mic/03/tbdThietBi03/get/") + fiId, null, HttpMethod.GET, null, TbdThietBi03DTO.class);
		return ResponseEntity.ok().body(tbdThietBi03);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThietBi03DTO>> findAllTbdThietBi03DTO(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThietBi03DTO> tbdThietBi03List = createRestTemplate(getURL("/mic/03/tbdThietBi03/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThietBi03List = mapper.convertValue(tbdThietBi03List, new TypeReference<List<TbdThietBi03DTO>>() {});

		return ResponseEntity.ok().body(tbdThietBi03List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThietBi03DTO>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThietBi03DTO> tbdThietBi03List = createRestTemplate(getURL("/mic/03/tbdThietBi03/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThietBi03List = mapper.convertValue(tbdThietBi03List, new TypeReference<List<TbdThietBi03DTO>>() {});

		return ResponseEntity.ok().body(tbdThietBi03List);
	}


}