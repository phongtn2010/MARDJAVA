/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import com.nsw.common.model.json.Tab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PhongNguyen
 */
public class AppHelper {

    public static List<Tab> GetMenusForUser(List<Tab> menuData, String nswUrl) {
        List<Tab> menusList = new ArrayList<>();
        int sizeOfList = menuData.size();
        Tab aTab = null;
        for (int i = 0; i < sizeOfList; i++) {
            aTab = menuData.get(i);
            if (aTab.getParentId() == null) {
                menusList.add(aTab);
            }
        }
        Collections.sort(menusList, new TabComparator());
        setTabUrl(menusList, nswUrl);
        return menusList;
    }

    public static void setTabUrl(List<Tab> tabs, String nswUrl) {
        Tab tab = null;
        int sizeOfList = tabs.size();
        for (int j = 0; j < sizeOfList; j++) {
            tab = tabs.get(j);
            if (tab.getMenuType() != null) {
                if (tab.getMenuType() == 0L) {
                    tab.setTabPath(nswUrl + tab.getTabPath());
                }
            }
            
            if (tab.getChildren() != null) {
                setTabUrl(tab.getChildren(), nswUrl);
            }

        }
    }
}
