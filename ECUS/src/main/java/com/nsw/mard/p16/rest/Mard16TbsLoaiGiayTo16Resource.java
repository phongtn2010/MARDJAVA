package com.nsw.mard.p16.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p16.model.PageableDTO;
import com.nsw.mard.p16.model.TbdThuoc16;
import com.nsw.mard.p16.model.TbsLoaiGiayTo16;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mard/16/tbsLoaiGiayTo16")
public class Mard16TbsLoaiGiayTo16Resource extends Mard16CallBack {

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public ResponseEntity<List<TbsLoaiGiayTo16>> findAll(@RequestBody @Valid PageableDTO pageableDTO) {

        List<TbsLoaiGiayTo16> tbdThuoc16List = createRestTemplate(getURL("/mard/16/tbsLoaiGiayTo16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
        ObjectMapper mapper = new ObjectMapper();
        tbdThuoc16List = mapper.convertValue(tbdThuoc16List, new TypeReference<List<TbsLoaiGiayTo16>>() {});

        return ResponseEntity.ok().body(tbdThuoc16List);
    }
}
