package com.nsw.backend.tokhai.model;

public class TokhaiRequest {

    private String sotk;// Số tờ khai
    private String mahq;// Mã hải quan
    private String namdk;// Năm đăng ký
    private String mst;// Mã số thuế

    public String getSotk() {
        return sotk;
    }

    public void setSotk(String sotk) {
        this.sotk = sotk;
    }

    public String getMahq() {
        return mahq;
    }

    public void setMahq(String mahq) {
        this.mahq = mahq;
    }

    public String getNamdk() {
        return namdk;
    }

    public void setNamdk(String namdk) {
        this.namdk = namdk;
    }

    public String getMst() {
        return mst;
    }

    public void setMst(String mst) {
        this.mst = mst;
    }

}
