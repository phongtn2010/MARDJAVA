/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.helper;

/**
 *
 * @author Phong84NV
 */
public class RabbitMQInfo {
    private String host;
    private String virtualHost;
    private String userName;
    private String password;
    private String exchangeName;
    private String queueName;
    private String routingKey;
    private String port;

    public RabbitMQInfo(){
        
    }
    
    public RabbitMQInfo(String _host, String _virtualHost, String _userName, String _password, 
            String _exchangeName, String _queueName, String _routingKey, String _port){
        this.host = _host;
        this.virtualHost = _virtualHost;
        this.userName = _userName;
        this.password = _password;
        this.exchangeName = _exchangeName;
        this.queueName = _queueName;
        this.routingKey = _routingKey;
        this.port = _port;
    }
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    } 

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
}
