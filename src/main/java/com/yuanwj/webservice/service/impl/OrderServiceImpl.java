package com.yuanwj.webservice.service.impl;

import com.yuanwj.webservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService(serviceName = "order",targetNamespace = "http://impl.service.webservice.yuanwj.com")
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public String saveOrder(String param) {
        LOG.debug("test========================================{}",param);
        return "success";
    }
}
