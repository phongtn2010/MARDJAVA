package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QualityResult {
    private String fiNSWFileCode;

    private Integer fiEditStatus;

    private String fiRegistrationComfirmNo;

    private String fiQuanlityCerNo;

    private String fiDepartmentCode;

    private String fiDepartmentName;

    private String fiDepartmentAddress;

    private String fiDepartmentPhone;

    private String fiDepartmentFax;

    private String fiSellerStateCode;

    private String fiSellerStateName;

    private String fiSellerAddress;

    private String fiSellerPhone;

    private String fiSellerFax;

    private String fiPortOfDepartureName;

    private String fiBuyerName;

    private String fiBuyerAddress;

    private String fiBuyerPhone;

    private String fiBuyerFax;

    private String fiPortOfDestinationCode;

    private String fiPortOfDestinationName;

    private List<QualityResultGoods> fiGoodsList;

    private Date fiSignResultDate;

    private String fiSignResultName;

    private String fiSignResultAddress;

    private String fiLinkFile;

    private String fiParentDepartmentName;
}
