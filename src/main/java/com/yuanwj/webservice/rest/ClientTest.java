package com.yuanwj.webservice.rest;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(ClientTest.class);

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(String address){
        try {
            //address为wsdl文件如:http://localhost:8081/yuanwj/report?wsdl
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            Client client = dcf.createClient(address);
            Object object = client.invoke("saveReport","yuanwj");
            LOG.debug("返回结果为{}",object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
