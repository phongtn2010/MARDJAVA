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
public class Product9A {
   
    @XmlElement(name = "ProductSort")
    private Long fiStt;
    
    @XmlElement(name = "Productcode")
    private Long fiIdHanghoa;
    
    @XmlElement(name = "ProductName")
    private String fiTenhang;
    
    @XmlElement(name = "Quantity")
    private BigDecimal fiSoluong;
    
    @XmlElement(name = "QuantityUnitCode")
    private String fiMaSl;
    
    @XmlElement(name = "QuantityUnitName")
    private String fiTenSl;
    
    @XmlElement(name = "NetWeight")
    private BigDecimal fiKhoiluong;

    public Product9A() {
    }

    public Product9A(Long fiStt, Long fiIdHanghoa, String fiTenhang, BigDecimal fiSoluong, String fiMaSl, String fiTenSl, BigDecimal fiKhoiluong) {
        this.fiStt = fiStt;
        this.fiIdHanghoa = fiIdHanghoa;
        this.fiTenhang = fiTenhang;
        this.fiSoluong = fiSoluong;
        this.fiMaSl = fiMaSl;
        this.fiTenSl = fiTenSl;
        this.fiKhoiluong = fiKhoiluong;
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

    public String getFiTenhang() {
        return fiTenhang;
    }

    public void setFiTenhang(String fiTenhang) {
        this.fiTenhang = fiTenhang;
    }

    public BigDecimal getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(BigDecimal fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public String getFiMaSl() {
        return fiMaSl;
    }

    public void setFiMaSl(String fiMaSl) {
        this.fiMaSl = fiMaSl;
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
}
