package com.nsw.mic.p04.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p04.dto.FormGP04DTO;
import com.nsw.mic.p04.dto.TbdGiayPhep04DTO;
import com.nsw.mic.p04.dto.TbdYeuCauSuaGP04DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nsw.mic.p03.rest.Mic03CommonApi;
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
* @class Mic04TbdGiayPhep04Resource
* Created by Nguyen Van Quang
* 11/12/2048 10:06:22
*
*/
@RestController
@RequestMapping(Mic04Constant.ROOT_API)
public class Mic04GiayPhepApi extends Mic04CallBack {

	@Autowired
	private Mic03CommonApi mic03CommonApi;

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/giayPhep/findByFiIdHoSo/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> findByFiIdHoSo(@PathVariable("fiIdHoSo") Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep04DTO> tbdGiayPhep04List = createRestTemplate(getURL("/mic/04/tbdGiayPhep04/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep04List = mapper.convertValue(tbdGiayPhep04List, new TypeReference<List<TbdGiayPhep04DTO>>() {});

		FormGP04DTO form = new FormGP04DTO();
		form.setDanhMucTepDinhKems(mic03CommonApi.findByLoaiThuTucOrderByFiSortAsc(Mic04Constant.DOCUMENT_TYPE));
		form.setTbdGiayPhep04DTO(tbdGiayPhep04List.get(0));
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(form);
		return ResponseEntity.ok().body(responseJson);
	}

	@RequestMapping(value = "/tbdYeuCauSuaGP04/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> createTbdYeuCauSuaGP04(@RequestBody TbdYeuCauSuaGP04DTO tbdYeuCauSuaGP04DTO) {

		Map<String, Object> params = new HashMap<>();
		tbdYeuCauSuaGP04DTO = createRestTemplate(getURL("/mic/04/tbdYeuCauSuaGP04/create"), tbdYeuCauSuaGP04DTO, HttpMethod.POST, params, TbdYeuCauSuaGP04DTO.class);
		ResponseJson responseJson = new ResponseJson();

		responseJson.setSuccess(true);
		responseJson.setData(tbdYeuCauSuaGP04DTO);
		return ResponseEntity.ok().body(responseJson);
	}



}