package com.nsw.backend.mard.p25.dto;

import com.nsw.backend.mard.p25.model.TbdDinhkem25;
import com.nsw.backend.mard.p25.model.TbdHangHoaFile25;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
public class UploadBaoCao {
    String fiNSWFileCode;
    private List<TbdDinhkem25> fiAttachReport;
}
