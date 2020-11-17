/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.model;

import java.util.List;

/**
 *
 * @author QUANGNV18
 */
public class UriCollection {

    public String Code;//Ma thu tuc
    public List<UriItem> Items;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }
    
    public List<UriItem> getItems() {
        return Items;
    }

    public void setItems(List<UriItem> Items) {
        this.Items = Items;
    }
}
