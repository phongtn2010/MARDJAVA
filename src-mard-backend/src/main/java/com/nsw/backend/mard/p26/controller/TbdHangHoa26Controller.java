package com.nsw.backend.mard.p26.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.service.TbdHangHoa25Service;
import com.nsw.backend.mard.p25.service.TbdHoso25Service;
import com.nsw.backend.mard.p26.model.TbdHanghoa26;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mard/26/hanghoa")
public class TbdHangHoa26Controller extends BaseController {
    private final TbdHangHoa25Service tbdHangHoa25Service;
    private final TbdHoso25Service tbdHoso25Service;

    public TbdHangHoa26Controller(TbdHangHoa25Service tbdHangHoa25Service, TbdHoso25Service tbdHoso25Service) {
        this.tbdHangHoa25Service = tbdHangHoa25Service;
        this.tbdHoso25Service = tbdHoso25Service;
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public ResponseEntity<ResponseJson> getListByFilter(@RequestParam(name = "taxCode") String taxcode) {


        return createSuccessResponse(getListHangHoaMienKiem(taxcode), HttpStatus.OK);
    }
    private List<TbdHanghoa26> getListHangHoaMienKiem(String taxCode){
        List<TbdHanghoa26> lstHangHoaMienKiem = new ArrayList<>();
        List<TbdHanghoa25> lstHangHoaTACN = tbdHangHoa25Service.findByFiTaxCodeAndFiTrangThaiHangHoa(taxCode,44);
        if(!lstHangHoaTACN.isEmpty()&&null!=lstHangHoaTACN){
            lstHangHoaTACN.forEach(tbdHanghoa25->{
                TbdHanghoa26 tbdHanghoa26 = new TbdHanghoa26();
                BeanUtils.copyProperties(tbdHanghoa25,tbdHanghoa26);
                lstHangHoaMienKiem.add(tbdHanghoa26);
            });
        }
        lstHangHoaMienKiem.forEach(tbdHanghoa26->{
            TbdHoso25 result = tbdHoso25Service.findById(tbdHanghoa26.getFiIdHS());
            if(result!=null){
                tbdHanghoa26.setFiNSWFileCode(result.getFiNSWFileCode());
            }
        });
        return lstHangHoaMienKiem;
    }
}
