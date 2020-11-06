package com.nsw.backend.mard.p25.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.service.*;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/25")
public class Common25Controller extends BaseController {
    private final TbsDonViXuLy25Service tbsDonViXuLy25Service;

    private final TbdChiTieuDG25Service tbdChiTieuDG25Service;

    private final TbdHosoTccd25Service tbdHosoTccd25Service;
    private final TbdHangHoaFile25Service tbdHangHoaFile25Service;

    public Common25Controller(TbsDonViXuLy25Service tbsDonViXuLy25Service, TbdChiTieuDG25Service tbdChiTieuDG25Service, TbdHosoTccd25Service tbdHosoTccd25Service, TbdHangHoaFile25Service tbdHangHoaFile25Service) {
        this.tbsDonViXuLy25Service = tbsDonViXuLy25Service;
        this.tbdChiTieuDG25Service = tbdChiTieuDG25Service;
        this.tbdHosoTccd25Service = tbdHosoTccd25Service;
        this.tbdHangHoaFile25Service = tbdHangHoaFile25Service;
    }

    @GetMapping("/chitieu/{fiNSWFileCode}")
    public ResponseEntity<ResponseJson> getByCatNo(@PathVariable String fiNSWFileCode) {
        return createSuccessResponse(tbdChiTieuDG25Service.findByFiNSWFileCode(fiNSWFileCode), HttpStatus.OK);
    }

    @GetMapping("/filekqpt/{fiIdHangHoa}")
    public ResponseEntity<ResponseJson> getListFileKQPT(@PathVariable Integer fiIdHangHoa) {
        return createSuccessResponse(tbdHangHoaFile25Service.findByFiIDHangHoa(fiIdHangHoa), HttpStatus.OK);
    }

    @GetMapping("/filegcn/{fiIdHangHoa}")
    public ResponseEntity<ResponseJson> getFileGCN(@PathVariable Integer fiIdHangHoa) {
        return createSuccessResponse(tbdHosoTccd25Service.findByFiIdHangHoa(fiIdHangHoa), HttpStatus.OK);
    }
}
