package com.nsw.backend.mard.p25.client;



import lombok.Data;

import javax.xml.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Data
public class TCCDGuiKQKT {

    String fiNSWFileCode;

    String fiAssignID;

    String fiAssignName;

    Integer fiMaHangHoa;

    String fiTenHangHoa;

    Integer fiKetQuaDanhGia;

    String fiSoGCN;

    Date fiNgayCap;

    String fiMaFileGCN;
    String fiNameFileGCN;
    String fiLinkFileGCN;

    List<AttachmentResult> fiDanhSachDinhKem;

}
