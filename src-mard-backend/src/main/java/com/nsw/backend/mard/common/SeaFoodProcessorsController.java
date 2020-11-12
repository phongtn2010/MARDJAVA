package com.nsw.backend.mard.common;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.dic.repositories.CmonSeafoodprocessorsRepository;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mard/cssx")
public class SeaFoodProcessorsController extends BaseController {
    @Autowired
    private CmonSeafoodprocessorsRepository repository;
    // tạo mới hồ sơ
    @PostMapping("/")
    public ResponseEntity<ResponseJson> createHoso() {
        try {

            return createSuccessResponse(null, HttpStatus.OK);
        } catch (Exception ex) {
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
    @GetMapping("/find/")
    public ResponseEntity<ResponseJson> getDS() {
        try {
            return createSuccessResponse(repository.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
}
