package com.nextyu.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on 2017-05-08 10:50
 *
 * @author nextyu
 */
@RestController
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(ComputeController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;



    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer add(Integer a, Integer b) {
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        Integer result = a + b;
        logger.info("/add, host:" + localServiceInstance.getHost() + ", service_id:" + registration.getServiceId() + ", result:" + result);

        return result;
    }

}
