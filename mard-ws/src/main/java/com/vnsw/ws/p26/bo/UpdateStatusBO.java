package com.vnsw.ws.p26.bo;

public class UpdateStatusBO {
    private String fiMaHoso ;
    private Long fiTrangthai;
    private String fiLydo;
    private Long fiLoaiGCN;
    private String fiMaGCN;

    public UpdateStatusBO() {
    }

    public UpdateStatusBO(String fiMaHoso, Long fiTrangthai, String fiLydo, Long fiLoaiGCN, String fiMaGCN) {
        this.fiMaHoso = fiMaHoso;
        this.fiTrangthai = fiTrangthai;
        this.fiLydo = fiLydo;
        this.fiLoaiGCN = fiLoaiGCN;
        this.fiMaGCN = fiMaGCN;
    }

    public String getFiMaGCN() {
        return fiMaGCN;
    }

    public void setFiMaGCN(String fiMaGCN) {
        this.fiMaGCN = fiMaGCN;
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
