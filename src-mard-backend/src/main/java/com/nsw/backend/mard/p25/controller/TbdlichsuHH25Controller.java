package com.nsw.backend.mard.p25.controller;


import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.model.TbdLichSuHH25;
import com.nsw.backend.mard.p25.service.TbdLichSuHH25Service;
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
@RequestMapping("/mard/25/lichsu/hanghoa")
public class TbdlichsuHH25Controller extends BaseController {
    private final TbdLichSuHH25Service hstService;

    @Autowired
    public TbdlichsuHH25Controller(TbdLichSuHH25Service hstService) {
        this.hstService = hstService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseJson> getListByfiIdProduct(@RequestParam Integer fiIdProduct,
                                                        @RequestParam(required = false) Integer p,
                                                        @RequestParam(required = false) Integer s) {
        if (p == null) {
            return createSuccessResponse(hstService.findByfiIDHangHoa(fiIdProduct), HttpStatus.OK);
        } else {
            PageRequest pageRequest = new PageRequest(p, s);
            ResponseJson response = new ResponseJson();
            Page<TbdLichSuHH25> page = hstService.findByfiIDHangHoaAndPagable(fiIdProduct, pageRequest);
            response.setTotal(page.getTotalElements());
            response.setSuccess(true);
            response.setData(page.getContent());
            return ResponseEntity.ok(response);
        }
    }
}

