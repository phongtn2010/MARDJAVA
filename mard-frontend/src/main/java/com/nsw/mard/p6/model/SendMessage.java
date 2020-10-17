package com.nsw.mard.p6.model;

import lombok.Data;

@Data
public class SendMessage {
    private String type;
    private String fiReason;
    private String fiNSWFileCode;
    private String function;
}
