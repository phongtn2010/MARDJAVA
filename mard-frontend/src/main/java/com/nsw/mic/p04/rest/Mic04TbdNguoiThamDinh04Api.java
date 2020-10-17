package com.nsw.mic.p04.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p04.dto.PageableDTO;
import com.nsw.mic.p04.dto.TbdNguoiThamDinh04DTO;

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
* @class Mic04TbdNguoiThamDinh04DTOResource
* Created by Nguyen Van Quang
* 11/12/2048 10:06:046
*
*/
@RestController
@RequestMapping("/mic/04/tbdNguoiThamDinh04")
public class Mic04TbdNguoiThamDinh04Api extends Mic04CallBack {

	@Autowired
	private Mic04TbdKetQuaXuLy04Api fldMic04TbdKetQuaXuLy04Api;

	@Autowired
	private Mic04TbdHoSo04Api fldMic04TbdHoSo04Api;

	/**
	* @param tbdThietBi04 - Type: TbdNguoiThamDinh04DTO
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> createTbdNguoiThamDinh04DTO(@RequestBody @Valid TbdNguoiThamDinh04DTO tbdThietBi04) {
		ResponseJson responseJson = new ResponseJson();
		if (!isValid(tbdThietBi04)) {
			responseJson.setData(tbdThietBi04);
			return ResponseEntity.badRequest().body(responseJson);
		}
		tbdThietBi04 = createRestTemplate(getURL("/mic/04/tbdThietBi04/create"), tbdThietBi04, HttpMethod.POST, null, TbdNguoiThamDinh04DTO.class);
		createHistory(fldMic04TbdKetQuaXuLy04Api, fldMic04TbdHoSo04Api, "Tạo mới thông tin thiết bị: " , tbdThietBi04.getFiIdHoSo());
		responseJson.setData(tbdThietBi04);
		responseJson.setSuccess(true);
		return ResponseEntity.ok().body(responseJson);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThietBi04 - Type: TbdNguoiThamDinh04DTO
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> updateTbdNguoiThamDinh04DTO(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdNguoiThamDinh04DTO tbdThietBi04) {
		ResponseJson responseJson = new ResponseJson();
		if (!isValid(tbdThietBi04)) {
			responseJson.setData(tbdThietBi04);
			return ResponseEntity.badRequest().body(responseJson);
		}
		tbdThietBi04 = createRestTemplate(getURL("/mic/04/tbdThietBi04/update/") + fiId, tbdThietBi04, HttpMethod.POST, null, TbdNguoiThamDinh04DTO.class);
		createHistory(fldMic04TbdKetQuaXuLy04Api, fldMic04TbdHoSo04Api,"Cập nhật thông tin thiết bị: ", tbdThietBi04.getFiIdHoSo());
		responseJson.setData(tbdThietBi04);
		responseJson.setSuccess(true);
		return ResponseEntity.ok().body(responseJson);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> deleteTbdNguoiThamDinh04DTO(@PathVariable("fiIdHoSo") Long fiIdHoSo, @PathVariable("fiId") Long fiId) {
		TbdNguoiThamDinh04DTO tbdThietBi04 = createRestTemplate(getURL("/mic/04/tbdThietBi04/delete/") + fiId, null, HttpMethod.DELETE, null, TbdNguoiThamDinh04DTO.class);
		createHistory(fldMic04TbdKetQuaXuLy04Api, fldMic04TbdHoSo04Api,"Xóa thông tin thiết bị: ", fiIdHoSo);

		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(tbdThietBi04);
		return ResponseEntity.ok().body(responseJson);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdNguoiThamDinh04DTO> getTbdNguoiThamDinh04DTO(@PathVariable("fiId") Long fiId) {
		TbdNguoiThamDinh04DTO tbdThietBi04 = createRestTemplate(getURL("/mic/04/tbdThietBi04/get/") + fiId, null, HttpMethod.GET, null, TbdNguoiThamDinh04DTO.class);
		return ResponseEntity.ok().body(tbdThietBi04);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdNguoiThamDinh04DTO>> findAllTbdNguoiThamDinh04DTO(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdNguoiThamDinh04DTO> tbdThietBi04List = createRestTemplate(getURL("/mic/04/tbdThietBi04/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThietBi04List = mapper.convertValue(tbdThietBi04List, new TypeReference<List<TbdNguoiThamDinh04DTO>>() {});

		return ResponseEntity.ok().body(tbdThietBi04List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdNguoiThamDinh04DTO>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdNguoiThamDinh04DTO> tbdThietBi04List = createRestTemplate(getURL("/mic/04/tbdThietBi04/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThietBi04List = mapper.convertValue(tbdThietBi04List, new TypeReference<List<TbdNguoiThamDinh04DTO>>() {});

		return ResponseEntity.ok().body(tbdThietBi04List);
	}


}