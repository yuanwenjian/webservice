package com.yuanwj.webservice.service;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

//@WebService(serviceName = "order",targetNamespace = "http://service.webservice.yuanwj.com")
//@Component
public interface OrderService {

    String saveOrder(String param);
}
