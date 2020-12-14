package com.nsw.mard.p25.model;

import lombok.Data;

import java.util.List;

@Data
public class UploadBaoCao {
    String fiNSWFileCode;
    private List<TbdDinhkem25> fiAttachReport;
}
