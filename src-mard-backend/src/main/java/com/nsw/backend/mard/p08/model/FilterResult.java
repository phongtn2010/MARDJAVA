/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<Tbdhoso08> data;
    private Long total;
    private int size;
    private int page;
}
