package com.nsw.backend.mard.p01.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p01.repositories.TbdUOMs01Repository;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/01/unit")
public class DonViTinh01Controller extends BaseController {

    private final TbdUOMs01Repository tbdUOMs01Repository;

    @Autowired
    public DonViTinh01Controller(TbdUOMs01Repository tbdUOMs01Repository) {
        this.tbdUOMs01Repository = tbdUOMs01Repository;
    }

    @GetMapping("")
    public ResponseEntity<ResponseJson> getDanhMucDVXL() {
        return createSuccessResponse(tbdUOMs01Repository.findAll(), HttpStatus.OK);
    }
}
