package com.nextyu.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created on 2017-05-08 11:18
 *
 * @author nextyu
 */
@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
