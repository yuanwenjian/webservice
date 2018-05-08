package com.yuanwj.webservice.config;

import com.yuanwj.webservice.service.OrderService;
import com.yuanwj.webservice.service.ReportService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    @Resource
    private Bus bus;

    @Resource
    private OrderService orderService;

    @Resource
    private ReportService reportService;

    @Bean
    public ServletRegistrationBean cxfServletRegistration() {
        CXFServlet servlet = new CXFServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(
                servlet);
        registration.setOrder(4);
        registration.addUrlMappings("/yuanwj/*");
        return registration;
    }

    @Bean
    public Endpoint orderEndpoint(){
        Endpoint endpoint = new EndpointImpl(bus,orderService);
        endpoint.publish("/order");
        return endpoint;
    }

    @Bean
    public Endpoint reportEndPoint(){
        Endpoint endpoint = new EndpointImpl(bus,reportService);
        endpoint.publish("/report");
        return endpoint;
    }
}
