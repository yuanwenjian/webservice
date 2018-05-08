package com.yuanwj.webservice.service.impl;

import com.yuanwj.webservice.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService(name = "report",targetNamespace = "http://impl.service.webservice.yuanwj.com")
@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Override
    public String saveReport(String report) {
        LOG.debug("report=========================={}",report);
        return report;
    }
}
