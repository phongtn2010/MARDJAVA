package com.nsw.backend.mard.p25.controller;


import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.model.TbdLichsu25;
import com.nsw.backend.mard.p25.service.TbdLichsu25Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/25/lichsu")
public class Tbdlichsu25Controller extends BaseController {
    private final TbdLichsu25Service hstService;

    @Autowired
    public Tbdlichsu25Controller(TbdLichsu25Service hstService) {
        this.hstService = hstService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseJson> getListByHSCode(@RequestParam String fiNSWFileCode,
                                                        @RequestParam(required = false) Integer p,
                                                        @RequestParam(required = false) Integer s) {
        if (p == null) {
            return createSuccessResponse(hstService.findByHSCode(fiNSWFileCode), HttpStatus.OK);
        } else {
            PageRequest pageRequest = new PageRequest(p, s);
            ResponseJson response = new ResponseJson();
            Page<TbdLichsu25> page = hstService.findByHSCodeAndPagable(fiNSWFileCode, pageRequest);
            response.setTotal(page.getTotalElements());
            response.setSuccess(true);
            response.setData(page.getContent());
            return ResponseEntity.ok(response);
        }
    }
}