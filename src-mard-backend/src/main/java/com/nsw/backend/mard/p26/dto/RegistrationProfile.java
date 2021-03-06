/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p26.dto;

import com.nsw.backend.mard.p26.model.TbdHoso26;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO class for entity stored in table "TbdHoso26" - Hồ sơ Đăng ký
 */
@Data
public class RegistrationProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer fiIdHS;

    private String fiNSWFileCode;

    private Integer fiHSType = 1;

    private Integer fiProductType;

    @Size(max = 13)
    private String fiTaxCode;

    @Size(max = 50)
    private String fiRegistrationNo;

    @Size(max = 200)
    private String fiImporterName;

    @Size(max = 250)
    private String fiImporterAddress;

    @Size(max = 15)
    private String fiImporterTel;

    @Size(max = 15)
    private String fiImporterFax;

    @Size(max = 250)
    private String fiImporterEmail;

    @Size(max = 500)
    private String fiBordergateName;

    @Size(max = 500)
    private String fiPurpose;

    @Size(max = 255)
    private String fiRelatedDocuments;

    private Date fiTimeQuarantineFrom;

    private Date fiTimeQuarantineTo;

    private String fiTimeQuarantine;

    @Size(max = 250)
    private String fiSignAddress;

    private Date fiSignDate;

    @Size(max = 250)
    private String fiSignName;

    @Size(max = 250)
    private String fiSignPosition;

    //Danh sách thông tin kèm theo
    private List<RegistrationProduct> fiProductList;

    private List<RegistrationExporterCountry> fiExporterCountryList;

    private List<RegistrationProcessing> fiProcessingList;

    private List<RegistrationLocationQuarantine> fiLocationQuarantineList;

    // Dinh kem
    private List<AttachmentFile> fiAttachmentList;

    private RegistrationProfile() {
        super();
    }

    private void clrLst() {
        fiProductList = new ArrayList<>();
        fiExporterCountryList = new ArrayList<>();
        fiProcessingList = new ArrayList<>();
        fiLocationQuarantineList = new ArrayList<>();
        fiAttachmentList = new ArrayList<>();
    }

    public static RegistrationProfile parse(TbdHoso26 regProfile) {
        RegistrationProfile dto = new RegistrationProfile();
        BeanUtils.copyProperties(regProfile, dto);
        dto.clrLst();
        dto.setFiProductType(regProfile.getFiHSType());

        regProfile.getFiProductList().forEach(product -> {
            RegistrationProduct dtoProduct = new RegistrationProduct();
            BeanUtils.copyProperties(product, dtoProduct);
//            dtoProduct.setFiOriginCountryName(CmonHelper.instance().findCountryByCode(product.getFiOriginCountryCode()).getCountryname());
//            dtoProduct.setFiPackageUnitName(CmonHelper.instance().findUomByCode(product.getFiPackageUnitCode()).getUnitname());
            dto.getFiProductList().add(dtoProduct);
        });
        return dto;
    }

}
