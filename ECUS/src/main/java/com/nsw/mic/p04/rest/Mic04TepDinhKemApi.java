package com.nsw.mic.p04.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p04.dto.TbdDinhKem04DTO;

import javax.validation.Valid;

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
* @class Mic04TbdDinhKem04Resource
* Created by Nguyen Van Quang
* 11/12/2048 10:05:04
*
*/
@RestController
@RequestMapping("/mic/04/tbdDinhKem04")
public class Mic04TepDinhKemApi extends Mic04CallBack {

	@Autowired
	private Mic04TbdKetQuaXuLy04Api fldMic04TbdKetQuaXuLy04Api;

	@Autowired
	private Mic04TbdHoSo04Api fldMic04TbdHoSo04Api;

	/**
	* @param tbdDinhKem04 - Type: TbdDinhKem04
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> createTbdDinhKem04(@RequestBody @Valid TbdDinhKem04DTO tbdDinhKem04) {

		tbdDinhKem04.setFiFileGroup(Mic04Constant.DOCUMENT_TYPE);
		tbdDinhKem04 = createRestTemplate(getURL("/mic/04/tbdDinhKem04/create"), tbdDinhKem04, HttpMethod.POST, null, TbdDinhKem04DTO.class);

		createHistory(fldMic04TbdKetQuaXuLy04Api, fldMic04TbdHoSo04Api, "Tạo mới tệp đính kèm: " + tbdDinhKem04.getFiFileName(), tbdDinhKem04.getFiIdHoSo());
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);

		return ResponseEntity.ok().body(responseJson);
	}

	/**
	 * @param fiId - Type: Long
	 * @return may can throw new Execption
	 */
	@RequestMapping(value = "/delete/{fiIdHoSo}/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> deleteTbdDinhKem04(@PathVariable("fiIdHoSo") Long fiIdHoSo, @PathVariable("fiId") Long fiId) {
		TbdDinhKem04DTO tbdDinhKem04 = createRestTemplate(getURL("/mic/04/tbdDinhKem04/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem04DTO.class);
		createHistory(fldMic04TbdKetQuaXuLy04Api, fldMic04TbdHoSo04Api, "Xóa tệp đính kèm: " + tbdDinhKem04.getFiFileName(), fiIdHoSo);
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(tbdDinhKem04);
		return ResponseEntity.ok().body(responseJson);
	}

}