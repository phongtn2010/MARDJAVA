package com.nsw.backend.mard.p09.service;

import com.nsw.backend.mard.p09.model.TbdB64Dinhkem09;
import com.nsw.backend.mard.p09.repositories.TbdB64Dinhkem09Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmbeddedAttachmentService09 {
    private final Tbdhoso09Service regProfileService;

    private final TbdB64Dinhkem09Repository embdAtchRepository;

    @Autowired
    public EmbeddedAttachmentService09(Tbdhoso09Service regProfileService, TbdB64Dinhkem09Repository embdAtchRepository) {
        this.regProfileService = regProfileService;
        this.embdAtchRepository = embdAtchRepository;
    }

    private TbdB64Dinhkem09 createAttachment(String fiNSWFileCode, String fileByte, String fileName, String parentTable) {
        String uuid = UUID.randomUUID().toString();
        String taxCode = getTaxCodeFromNSWFileCode(fiNSWFileCode);

        TbdB64Dinhkem09 embeddedAttachment = new TbdB64Dinhkem09();
        embeddedAttachment.setFiContent(fileByte);
        embeddedAttachment.setFiFileName(fileName);
        embeddedAttachment.setFiParentTable(parentTable);
        embeddedAttachment.setFiUuid(uuid);
        embeddedAttachment.setFiTaxCode(taxCode);

        return embdAtchRepository.save(embeddedAttachment);
    }

    public TbdB64Dinhkem09 createAttachment(String fiNSWFileCode, String fileByte, String fileName) {
        return createAttachment(fiNSWFileCode, fileByte, fileName, "");
    }

    public TbdB64Dinhkem09 createAttachment(String fiNSWFileCode, String fileByte) {
        return createAttachment(fiNSWFileCode, fileByte, "", "");
    }

    private String getTaxCodeFromNSWFileCode(String fiNSWFileCode) {
        return regProfileService.findByFiHSCode(fiNSWFileCode).getFiTaxCode();
    }

    public TbdB64Dinhkem09 findByFiIdAndFiTaxCode(long fiId, String fiTaxCode) {
        return embdAtchRepository.findByFiIdAndFiTaxCode(fiId, fiTaxCode).orElse(null);
    }
}
