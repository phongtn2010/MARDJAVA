package com.nsw.backend.mard.p26.dto;

import com.nsw.backend.mard.p06.model.TbdCvCssx06;
import com.nsw.backend.mard.p06.model.TbdCvCtyxk06;
import com.nsw.backend.mard.p06.model.TbdCvDdclkd06;
import com.nsw.backend.mard.p06.model.TbdCvHanghoa06;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class VeterinaryHygiene implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer fiIdCV;
    private Integer fiIdHS;

    private Integer fiProductType;

    private String fiNSWFileCode;

    @Size(max = 50)
    private String fiDispatchNo;

    private Integer fiDispatchType;

    @NotNull
    private Date fiDispatchDate;

    @Size(max = 250)
    private String fiSummary;

    @Size(max = 2000)
    private String fiPreamble;

    @Size(max = 500)
    private String fiBordergateName;

    private String fiTimeQuarantine;

    @Size(max = 255)
    private String fiPurpose;

    @Size(max = 5000)
    private String fiResponseContent;

    @Size(max = 250)
    private String fiRecipient;

    @Size(max = 100)
    private String fiSignPosition;

    @Size(max = 100)
    private String fiSignConfirmName;

    @Size(max = 100)
    private String fiSignConfirmAddress;

    @Size(max = 500)
    private String fiReasonEdit;

    @Size(max = 5000)
    private String fiLinkFile;

    // Danh sách đính kèm
    private List<TbdCvHanghoa06> fiProductList;

    private List<TbdCvCtyxk06> fiExporterCountryList;

    private List<TbdCvCssx06> fiProcessingList;

    private List<TbdCvDdclkd06> fiLocationQuarantineList;

    public VeterinaryHygiene() {
        super();
        fiProductList = new ArrayList<>();
        fiExporterCountryList = new ArrayList<>();
        fiProcessingList = new ArrayList<>();
        fiDispatchDate = new Date();
    }
}

