package com.nsw.mic.p03.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p03.dto.FormGP03DTO;
import com.nsw.mic.p03.dto.TbdGiayPhep03DTO;
import com.nsw.mic.p03.dto.TbdYeuCauSuaGP03DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
* @class Mic03TbdGiayPhep03Resource
* Created by Nguyen Van Quang
* 11/12/2048 10:06:22
*
*/
@RestController
@RequestMapping(Mic03Constant.ROOT_API)
public class Mic03GiayPhepApi extends Mic03CallBack {

	@Autowired
	private Mic03CommonApi mic03TepDinhKemApi;

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/giayPhep/findByFiIdHoSo/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> findByFiIdHoSo(@PathVariable("fiIdHoSo") Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep03DTO> tbdGiayPhep03List = createRestTemplate(getURL("/mic/03/tbdGiayPhep03/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep03List = mapper.convertValue(tbdGiayPhep03List, new TypeReference<List<TbdGiayPhep03DTO>>() {});

		FormGP03DTO form = new FormGP03DTO();
		form.setDanhMucTepDinhKems(mic03TepDinhKemApi.findByLoaiThuTucOrderByFiSortAsc(Mic03Constant.DOCUMENT_TYPE));
		form.setTbdGiayPhep03DTO(tbdGiayPhep03List.get(0));
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(form);
		return ResponseEntity.ok().body(responseJson);
	}

	@RequestMapping(value = "/tbdYeuCauSuaGP03/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> createTbdYeuCauSuaGP03(@RequestBody TbdYeuCauSuaGP03DTO tbdYeuCauSuaGP03DTO) {

		Map<String, Object> params = new HashMap<>();
		tbdYeuCauSuaGP03DTO = createRestTemplate(getURL("/mic/03/tbdYeuCauSuaGP03/create"), tbdYeuCauSuaGP03DTO, HttpMethod.POST, params, TbdYeuCauSuaGP03DTO.class);
		ResponseJson responseJson = new ResponseJson();

		responseJson.setSuccess(true);
		responseJson.setData(tbdYeuCauSuaGP03DTO);
		return ResponseEntity.ok().body(responseJson);
	}



}