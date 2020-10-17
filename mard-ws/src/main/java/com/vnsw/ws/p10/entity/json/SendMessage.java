package com.vnsw.ws.p10.entity.json;

public class SendMessage {

    private String type;
    private String function;
    private Long fiIdHoso;// Id hồ sơ
    private String fiMaHoso; //Ma ho so
    private String reason;// Content của lý do
    private String signedXml;//
    
    private Long cerType; // Loai giay chung nhan xin sua

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSignedXml() {
        return signedXml;
    }

    public void setSignedXml(String signedXml) {
        this.signedXml = signedXml;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Long getCerType() {
        return cerType;
    }

    public void setCerType(Long cerType) {
        this.cerType = cerType;
    }
}
