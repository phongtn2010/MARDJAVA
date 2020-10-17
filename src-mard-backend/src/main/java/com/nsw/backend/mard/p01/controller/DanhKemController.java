package com.nsw.backend.mard.p01.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p01.repositories.TbdAttachmentFileRepository;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard/01/attachment")
public class DanhKemController extends BaseController {

    private final TbdAttachmentFileRepository fileRepository;

    @Autowired
    public DanhKemController(TbdAttachmentFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping("")
    public ResponseEntity<ResponseJson> getListByHSCode(
            @RequestParam Long id,
            @RequestParam String taxcode
    ) {
        return createSuccessResponse(fileRepository.findByFiIDAndFiTaxCode(id, taxcode), HttpStatus.OK);
    }

    @GetMapping("/fee")
    public ResponseEntity<ResponseJson> downloadById(
            @RequestParam Long id,
            @RequestParam String taxcode
    ) {
        return createSuccessResponse(fileRepository.findByFiIDAndFiTaxCode(id, taxcode), HttpStatus.OK);
    }
}
