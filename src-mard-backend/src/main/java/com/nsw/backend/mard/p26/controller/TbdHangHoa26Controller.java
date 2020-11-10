package com.nsw.backend.mard.p26.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.model.FilterForm;
import com.nsw.backend.mard.p25.service.TbdHangHoa25Service;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mard/26/hanghoa")
public class TbdHangHoa26Controller extends BaseController {
    private final TbdHangHoa25Service tbdHangHoa25Service;

    public TbdHangHoa26Controller(TbdHangHoa25Service tbdHangHoa25Service) {
        this.tbdHangHoa25Service = tbdHangHoa25Service;
    }

    @PostMapping("/getlist")
    public ResponseEntity<ResponseJson> getListByFilter(@RequestParam String taxcode) {
        return createSuccessResponse(tbdHangHoa25Service.findByFiTaxCodeAndFiTrangThaiHangHoa(taxcode,44), HttpStatus.OK);
    }
}
