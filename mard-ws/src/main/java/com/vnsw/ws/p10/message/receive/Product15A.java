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
public class Product15A {
    @XmlElement(name = "ProductSort")
    private Long fiStt;
    
    @XmlElement(name = "Productcode")
    private Long fiIdHanghoa;
    
    @XmlElement(name = "ProductName")
    private String fiTenHh;
    
    @XmlElement(name = "Age")
    private String fiTuoi;
    
    @XmlElement(name = "Male")
    private BigDecimal fiTinhbiet;
    
    @XmlElement(name = "Quantity")
    private BigDecimal fiSoluong;
    
    @XmlElement(name = "QuantityUnitCode")
    private String fiDvSl;
    
    @XmlElement(name = "QuantityUnitName")
    private String fiTenSl;
    
    @XmlElement(name = "Purpose")
    private String fiMucdich;

    public Product15A() {
    }

    public Product15A(Long fiStt, Long fiIdHanghoa, String fiTenHh, String fiTuoi, BigDecimal fiTinhbiet, BigDecimal fiSoluong, String fiDvSl, String fiTenSl, String fiMucdich) {
        this.fiStt = fiStt;
        this.fiIdHanghoa = fiIdHanghoa;
        this.fiTenHh = fiTenHh;
        this.fiTuoi = fiTuoi;
        this.fiTinhbiet = fiTinhbiet;
        this.fiSoluong = fiSoluong;
        this.fiDvSl = fiDvSl;
        this.fiTenSl = fiTenSl;
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

    public String getFiTuoi() {
        return fiTuoi;
    }

    public void setFiTuoi(String fiTuoi) {
        this.fiTuoi = fiTuoi;
    }

    public BigDecimal getFiTinhbiet() {
        return fiTinhbiet;
    }

    public void setFiTinhbiet(BigDecimal fiTinhbiet) {
        this.fiTinhbiet = fiTinhbiet;
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

    public String getFiMucdich() {
        return fiMucdich;
    }

    public void setFiMucdich(String fiMucdich) {
        this.fiMucdich = fiMucdich;
    }
}
