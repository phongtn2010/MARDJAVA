/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p25.client;

import lombok.Data;

import java.util.Date;

@Data
public class KetQuaThamDinh {
    private String fiRegistrationComfirmNo;
    private String fiReceiveNo;
    private String fiReason;

    private Date fiResultDate;

    private String fiDepartment;
    private String fiCreaterName;
}
