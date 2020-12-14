package com.nsw.mic.p03.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p03.dto.PageableDTO;
import com.nsw.mic.p03.model.*;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mic.p03.dto.KetQuaXuLy03DTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/***
*
*
* @RestController
* @class Mic03TbdKetQuaXuLy03Resource
* Created by Nguyen Van Quang
* 11/12/2048 10:07:11
*
*/
@RestController
@RequestMapping("/mic/03/tbdKetQuaXuLy03")
public class Mic03TbdKetQuaXuLy03Api extends Mic03CallBack {

	/**
	* @param tbdKetQuaXuLy03 - Type: TbdKetQuaXuLy03
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy03> createTbdKetQuaXuLy03(@RequestBody @Valid TbdKetQuaXuLy03 tbdKetQuaXuLy03) {
		tbdKetQuaXuLy03 = createRestTemplate(getURL("/mic/03/tbdKetQuaXuLy03/create"), tbdKetQuaXuLy03, HttpMethod.POST, null, TbdKetQuaXuLy03.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy03);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> page(@RequestBody @Valid PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		com.nsw.mic.p03.model.Page<KetQuaXuLy03DTO> page = createRestTemplate(getURL("/mic/03/tbdKetQuaXuLy03/page"), pageableDTO, HttpMethod.POST, params, com.nsw.mic.p03.model.Page.class);
		ObjectMapper mapper = new ObjectMapper();
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(page);
		return ResponseEntity.ok().body(responseJson);

	}
	


}