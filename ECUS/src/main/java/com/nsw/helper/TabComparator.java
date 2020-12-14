/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import com.nsw.common.model.json.Tab;
import java.util.Comparator;

/**
 *
 * @author PhongNguyen
 */
public class TabComparator implements Comparator<Tab> {

    @Override
    public int compare(Tab o1, Tab o2) {
        return o1.getTabOrder().compareTo(o2.getTabOrder());
    }
    
}