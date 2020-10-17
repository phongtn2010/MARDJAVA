package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class Attachment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fiNSWFileCode;

    private String fiFileName;
    private String fiFileByte;
}
