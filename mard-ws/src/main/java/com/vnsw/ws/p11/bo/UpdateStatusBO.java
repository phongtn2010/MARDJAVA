/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.bo;

public class UpdateStatusBO {
    private String fiMaHoso ;
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

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public Long getFiLoaiGCN() {
        return fiLoaiGCN;
    }

    public void setFiLoaiGCN(Long fiLoaiGCN) {
        this.fiLoaiGCN = fiLoaiGCN;
    }
    
}
