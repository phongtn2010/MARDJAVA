package com.nsw.backend.mard.p25.controller;

import com.google.common.cache.LoadingCache;
import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p25.model.FilterForm;
import com.nsw.backend.mard.p25.model.FilterHangHoa;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.service.TbdHangHoa25Service;
import com.nsw.backend.mard.p25.service.TbdHoso25Service;
import com.nsw.backend.util.ResponseJson;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mard/25/hanghoa")
public class TbdHangHoa25Controller extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(TbdHangHoa25Controller.class);
    private static final String TAG = "Tbdhoso25Controller";

    @Autowired
    private TbdHangHoa25Service hangHoa25Service;


    @RequestMapping(value = "/find/{idHoSo}")
    public ResponseEntity<ResponseJson> manualRollback(@PathVariable Integer idHoSo) {
//        hangHoa25Service.getSignPendingProfiles().cleanUp();
         return createSuccessResponse(hangHoa25Service.findByFiIdHS(idHoSo), HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<ResponseJson> getListByFilter(@RequestBody FilterHangHoa filterHangHoa) {
       // hangHoa25Service.getSignPendingProfiles().cleanUp();
        return createSuccessResponse(hangHoa25Service.searchHangHoa(filterHangHoa), HttpStatus.OK);
    }

}
