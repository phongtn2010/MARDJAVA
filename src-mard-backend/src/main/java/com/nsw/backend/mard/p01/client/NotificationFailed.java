package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class NotificationFailed implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;
    private String fiDispatchContent;
    private String fiFileName;
    private String fiDispatchFile;
    private String fiCreaterName;
    private String fiLinkFile;
}
