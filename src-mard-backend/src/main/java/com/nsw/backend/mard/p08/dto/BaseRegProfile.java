package com.nsw.backend.mard.p08.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BaseRegProfile {
    protected Long fiIdHS;
    protected String fiNSWFileCode;
    protected Long fiHSStatus;
    protected boolean fiActive = true;
    protected String fiTaxCode;
    protected Date fiHSCreatedDate;
    protected String fiRegistrationNo;
    protected Long fiHSType;

    protected Long fiProductType;
    protected Long fiRegistrationType;

    protected String fiNameOfRegistration;
    protected String fiAddressOfRegistration;
    protected String fiTel;
    protected String fiFax;
    protected String fiEmail;

    protected String fiSignerRole;
    protected String fiSignName;
    protected String fiSignAddress;
    protected Date fiSignDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RegProfile19A fiAnimalRegistration;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RegProfile19B fiProductRegistration;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RegProfile20 fiBoneMealRegistration;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RegProfile20A fiQualityRegistration;

    protected List<AttachmentFile> fiAttachmentList;

    private BaseRegProfile() {
        fiAttachmentList = new ArrayList<>();
    }

    public static BaseRegProfile parse(Tbdhoso08 rootHS) {
        BaseRegProfile parseResult = new BaseRegProfile();
        BeanUtils.copyProperties(rootHS, parseResult);

        parseResult.setFiNSWFileCode(rootHS.getFiHSCode());
//        parseResult.setFiProductType(parseResult.getFiHSType() > 3 ? parseResult.getFiHSType() - 3 : parseResult.getFiHSType());
//        parseResult.setFiRegistrationType((parseResult.getFiHSType() > 3 ? 2L : 1L));
        parseResult.setFiProductType(rootHS.getFiHSType());
        parseResult.setFiNameOfRegistration(rootHS.getFiImporterName());
        parseResult.setFiAddressOfRegistration(rootHS.getFiImporterAddress());
        parseResult.setFiTel(rootHS.getFiImporterTel());
        parseResult.setFiFax(rootHS.getFiImporterFax());
        parseResult.setFiEmail(rootHS.getFiImporterEmail());
        parseResult.setFiSignerRole(rootHS.getFiSignedByTitle());
        parseResult.setFiSignDate(rootHS.getFiSignedDate());
        parseResult.setFiSignAddress(rootHS.getFiSigningLocation());
        parseResult.setFiSignName(rootHS.getFiSignedBy());

        rootHS.getLstAtch().forEach(atch -> {
            AttachmentFile af = new AttachmentFile();
            af.setFiAttachmentId(atch.getFiGuid());
            af.setFiAttachmentTypeCode(atch.getFiMaLoai().intValue());
            af.setFiNameOfAttachment(atch.getFiTenTep());
            af.setFiLinkFile(atch.getFiDuongDan());
            parseResult.getFiAttachmentList().add(af);
        });

        if (rootHS.getFiHSType() == 1L) {
            parseResult.setFiAnimalRegistration(RegProfile19A.parse(rootHS));
        } else if (rootHS.getFiHSType() == 2L) {
            parseResult.setFiProductRegistration(RegProfile19B.parse(rootHS));
        } else if (rootHS.getFiHSType() == 3L) {
            parseResult.setFiBoneMealRegistration(RegProfile20.parse(rootHS));
        } else if (rootHS.getFiHSType() == 4L || rootHS.getFiHSType() == 5L) {
            parseResult.setFiQualityRegistration(RegProfile20A.parse(rootHS));
        }
        return parseResult;
    }
}
