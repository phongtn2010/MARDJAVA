package com.nsw.mard.p25.model;

import lombok.Data;

@Data
public class ResponeUploadFile {
    String ItemId;
    String UrlFile;

    public ResponeUploadFile(String itemId, String urlFile) {
        ItemId = itemId;
        UrlFile = urlFile;
    }
}
