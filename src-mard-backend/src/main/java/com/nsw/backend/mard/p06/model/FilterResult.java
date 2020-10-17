/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p06.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<TbdHoso06> data;
    private Integer total;
    private int size;
    private int page;
}
