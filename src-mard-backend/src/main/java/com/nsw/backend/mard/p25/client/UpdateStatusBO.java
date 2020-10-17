/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p25.client;

import lombok.Data;

@Data

public class UpdateStatusBO {
    private String fiMaHoso;
    private Long fiTrangthai;
    private String fiLydo;
    private Long fiLoaiGCN;

    public UpdateStatusBO() {
    }

    public UpdateStatusBO(String fiMaHoso, Long fiTrangthai, String fiLydo, Long fiLoaiGCN) {
        this.fiMaHoso = fiMaHoso;
        this.fiTrangthai = fiTrangthai;
        this.fiLydo = fiLydo;
        this.fiLoaiGCN = fiLoaiGCN;
    }
}
