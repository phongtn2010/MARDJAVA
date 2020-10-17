package com.nsw.mic.p03.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p03.dto.TbdDinhKem03DTO;

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
* @class Mic03TbdDinhKem03Resource
* Created by Nguyen Van Quang
* 11/12/2048 10:05:03
*
*/
@RestController
@RequestMapping("/mic/03/tbdDinhKem03")
public class Mic03TepDinhKemApi extends Mic03CallBack {

	@Autowired
	private Mic03TbdKetQuaXuLy03Api fldMic03TbdKetQuaXuLy03Api;

	@Autowired
	private Mic03TbdHoSo03Api fldMic03TbdHoSo03Api;

	/**
	* @param tbdDinhKem03 - Type: TbdDinhKem03
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> createTbdDinhKem03(@RequestBody @Valid TbdDinhKem03DTO tbdDinhKem03) {

		tbdDinhKem03.setFiFileGroup(Mic03Constant.DOCUMENT_TYPE);
		tbdDinhKem03 = createRestTemplate(getURL("/mic/03/tbdDinhKem03/create"), tbdDinhKem03, HttpMethod.POST, null, TbdDinhKem03DTO.class);

		createHistory(fldMic03TbdKetQuaXuLy03Api, fldMic03TbdHoSo03Api, "Tạo mới tệp đính kèm: " + tbdDinhKem03.getFiFileName(), tbdDinhKem03.getFiIdHoSo());
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);

		return ResponseEntity.ok().body(responseJson);
	}

	/**
	 * @param fiId - Type: Long
	 * @return may can throw new Execption
	 */
	@RequestMapping(value = "/delete/{fiIdHoSo}/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> deleteTbdDinhKem03(@PathVariable("fiIdHoSo") Long fiIdHoSo, @PathVariable("fiId") Long fiId) {
		TbdDinhKem03DTO tbdDinhKem03 = createRestTemplate(getURL("/mic/03/tbdDinhKem03/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem03DTO.class);
		createHistory(fldMic03TbdKetQuaXuLy03Api, fldMic03TbdHoSo03Api, "Xóa tệp đính kèm: " + tbdDinhKem03.getFiFileName(), fiIdHoSo);
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(tbdDinhKem03);
		return ResponseEntity.ok().body(responseJson);
	}

}