/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

/**
 *
 * @author Nhan
 */
public class UploadSecretKey {
    private String frameId;
    private String maTaiLieu;
    private String tenTaiLieu;

    public UploadSecretKey() {
    }

    public UploadSecretKey(String frameId, String maTaiLieu, String tenTaiLieu) {
        this.frameId = frameId;
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
    }

    public String getFrameId() {
        return frameId;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu = tenTaiLieu;
    }

    
}
