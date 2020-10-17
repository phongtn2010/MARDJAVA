/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.receive;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product15C {
    @XmlElement(name = "ProductSort")
    private Long fiStt;
    
    @XmlElement(name = "Productcode")
    private Long fiIdHanghoa;
    
    @XmlElement(name = "ProductName")
    private String fiTenHh;
    
    @XmlElement(name = "Packings")
    private String fiQuycachDg;
    
    @XmlElement(name = "Quantity")
    private BigDecimal fiSoluong;
    
    @XmlElement(name = "QuantityUnitCode")
    private String fiDvSl;
    
    @XmlElement(name = "QuantityUnitName")
    private String fiTenSl;
    
    @XmlElement(name = "NetWeight")
    private BigDecimal fiKhoiluong;
    
    @XmlElement(name = "Purpose")
    private String fiMucdich;

    public Product15C() {
    }

    public Product15C(Long fiStt, Long fiIdHanghoa, String fiTenHh, String fiQuycachDg, BigDecimal fiSoluong, String fiDvSl, String fiTenSl, BigDecimal fiKhoiluong, String fiMucdich) {
        this.fiStt = fiStt;
        this.fiIdHanghoa = fiIdHanghoa;
        this.fiTenHh = fiTenHh;
        this.fiQuycachDg = fiQuycachDg;
        this.fiSoluong = fiSoluong;
        this.fiDvSl = fiDvSl;
        this.fiTenSl = fiTenSl;
        this.fiKhoiluong = fiKhoiluong;
        this.fiMucdich = fiMucdich;
    }

    public Long getFiStt() {
        return fiStt;
    }

    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiIdHanghoa() {
        return fiIdHanghoa;
    }

    public void setFiIdHanghoa(Long fiIdHanghoa) {
        this.fiIdHanghoa = fiIdHanghoa;
    }

    public String getFiTenHh() {
        return fiTenHh;
    }

    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public String getFiQuycachDg() {
        return fiQuycachDg;
    }

    public void setFiQuycachDg(String fiQuycachDg) {
        this.fiQuycachDg = fiQuycachDg;
    }

    public BigDecimal getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(BigDecimal fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public String getFiDvSl() {
        return fiDvSl;
    }

    public void setFiDvSl(String fiDvSl) {
        this.fiDvSl = fiDvSl;
    }

    public String getFiTenSl() {
        return fiTenSl;
    }

    public void setFiTenSl(String fiTenSl) {
        this.fiTenSl = fiTenSl;
    }

    public BigDecimal getFiKhoiluong() {
        return fiKhoiluong;
    }

    public void setFiKhoiluong(BigDecimal fiKhoiluong) {
        this.fiKhoiluong = fiKhoiluong;
    }

    public String getFiMucdich() {
        return fiMucdich;
    }

    public void setFiMucdich(String fiMucdich) {
        this.fiMucdich = fiMucdich;
    }
}
