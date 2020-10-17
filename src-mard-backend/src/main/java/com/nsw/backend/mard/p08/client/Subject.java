package com.nsw.backend.mard.p08.client;

import lombok.Data;

@Data
public class Subject {
    private String documentType;
    private String type;
    private String function;
    private String reference;
    private String documentYear;
    private String preReference;
    private String preDocumentYear;
    private String sendDate;
}
