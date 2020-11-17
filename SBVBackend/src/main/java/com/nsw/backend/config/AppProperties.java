/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.config;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author QUANGNV18
 */
@Component
@PropertySource("classpath:uri.properties")
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private List<Most> most = new ArrayList<>();

    public static class Most {

        private String code;
        
        private String ws;

        private List<Item> items;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getWs() {
            return ws;
        }

        public void setWs(String ws) {
            this.ws = ws;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }        
    }

    public static class Item {
        private String url;
        private List<String> msg;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getMsg() {
            return msg;
        }

        public void setMsg(List<String> msg) {
            this.msg = msg;
        }        
    }

    public List<Most> getMost() {
        return this.most;
    }
    
    public String getUrl(String documentType, String msg) {
        String url = null;
        for (Most m : this.most) {
            if(m.getCode().equals(documentType)) {
                url = m.getWs();
                for (Item e : m.getItems()) {
                    int i = e.getMsg().indexOf(msg);
                    if(i >= 0) {
                        url += e.getUrl();
                        break;
                    }
                }
            }
        }
        return url;
    }
}
