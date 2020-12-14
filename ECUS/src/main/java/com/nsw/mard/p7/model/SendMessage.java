package com.nsw.mard.p7.model;

import lombok.Data;

@Data
public class SendMessage {
    private String type;
    private String fiReason;
    private String fiNSWFileCode;
    private String function;
}
