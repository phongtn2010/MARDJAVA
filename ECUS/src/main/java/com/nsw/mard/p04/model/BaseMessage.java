package com.nsw.mard.p04.model;

public class BaseMessage
{
    private String type;
    private String function;
    private Long fiIdHoso;
    private String fiMaHoso;
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public String getFunction() {
        return this.function;
    }
    
    public void setFunction(final String function) {
        this.function = function;
    }
    
    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }
    
    public void setFiIdHoso(final Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }
    
    public String getFiMaHoso() {
        return this.fiMaHoso;
    }
    
    public void setFiMaHoso(final String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }
}