package com.nsw.mard.p16.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p16.model.PageableDTO;
import com.nsw.mard.p16.model.TbdToKhaiKyThuat16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mard/16/tbdToKhaiKyThuat16")
public class Mard16TbdToKhaiKyThuat16Reource extends Mard16CallBack {

    @Autowired
    private Mard16TbdKetQuaXuLy16Resource fldMard16TbdKetQuaXuLy16Resource;

    @Autowired
    private Mard16TbdHoSo16Resource fldMard16TbdHoSo16Resource;

    /**
     * @return may can null
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<TbdToKhaiKyThuat16> createTbdToKhaiKyThuat16(@RequestBody @Valid TbdToKhaiKyThuat16 tbdToKhaiKyThuat16) {
        if (!isValid(tbdToKhaiKyThuat16)) {
            return ResponseEntity.badRequest().body(tbdToKhaiKyThuat16);
        }
        tbdToKhaiKyThuat16 = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/create"), tbdToKhaiKyThuat16, HttpMethod.POST, null, TbdToKhaiKyThuat16.class);
        createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource, "Tạo mới thông tin tờ khai kỹ thuật: " + tbdToKhaiKyThuat16.getFiNameOfGoodsDeclaration(), tbdToKhaiKyThuat16.getFiIdHoSo());
        return ResponseEntity.ok().body(tbdToKhaiKyThuat16);
    }

    /**
     * @param fiId - Type: Long
     * @return may can null
     */
    @RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
    public ResponseEntity<TbdToKhaiKyThuat16> updateTbdToKhaiKyThuat16(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdToKhaiKyThuat16 tbdToKhaiKyThuat16) {
        if (!isValid(tbdToKhaiKyThuat16)) {
            return ResponseEntity.badRequest().body(tbdToKhaiKyThuat16);
        }
        tbdToKhaiKyThuat16 = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/update/") + fiId, tbdToKhaiKyThuat16, HttpMethod.POST, null, TbdToKhaiKyThuat16.class);
        createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource,"Cập nhật thông tin tờ khai kỹ thuật: " + tbdToKhaiKyThuat16.getFiNameOfGoodsDeclaration(), tbdToKhaiKyThuat16.getFiIdHoSo());
        return ResponseEntity.ok().body(tbdToKhaiKyThuat16);
    }

    /**
     * @param fiId - Type: Long
     * @return may can throw new Execption
     */
    @RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
    public ResponseEntity<TbdToKhaiKyThuat16> deleteTbdToKhaiKyThuat16(@PathVariable("fiId") Long fiId) {
        TbdToKhaiKyThuat16 tbdToKhaiKyThuat16 = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/delete/") + fiId, null, HttpMethod.DELETE, null, TbdToKhaiKyThuat16.class);
        createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource,"Xóa thông tin tờ khai kỹ thuật: " + tbdToKhaiKyThuat16.getFiNameOfGoodsDeclaration() , tbdToKhaiKyThuat16.getFiIdHoSo());
        return ResponseEntity.ok().body(tbdToKhaiKyThuat16);
    }

    /**
     * @param fiId - Type: Long
     * @return may can null
     */
    @RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
    public ResponseEntity<TbdToKhaiKyThuat16> getTbdToKhaiKyThuat16(@PathVariable("fiId") Long fiId) {
        TbdToKhaiKyThuat16 TbdToKhaiKyThuat16 = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/get/") + fiId, null, HttpMethod.GET, null, TbdToKhaiKyThuat16.class);
        return ResponseEntity.ok().body(TbdToKhaiKyThuat16);
    }

    /**
     * @param pageableDTO - Type: PageableDTO
     * @return may can null
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public ResponseEntity<List<TbdToKhaiKyThuat16>> findAllTbdToKhaiKyThuat16(@RequestBody @Valid PageableDTO pageableDTO) {

        List<TbdToKhaiKyThuat16> TbdToKhaiKyThuat16List = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        TbdToKhaiKyThuat16List = mapper.convertValue(TbdToKhaiKyThuat16List, new TypeReference<List<TbdToKhaiKyThuat16>>() {});

        return ResponseEntity.ok().body(TbdToKhaiKyThuat16List);
    }

    /**
     * @param fiIdHoSo - Type: Long
     * @return can return null or throw exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
    public ResponseEntity<List<TbdToKhaiKyThuat16>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

        Map<String, Object> params = new HashMap<>();
        params.put("fiIdHoSo", fiIdHoSo);
        List<TbdToKhaiKyThuat16> TbdToKhaiKyThuat16List = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
        ObjectMapper mapper = new ObjectMapper();
        TbdToKhaiKyThuat16List = mapper.convertValue(TbdToKhaiKyThuat16List, new TypeReference<List<TbdToKhaiKyThuat16>>() {});

        return ResponseEntity.ok().body(TbdToKhaiKyThuat16List);
    }
}
