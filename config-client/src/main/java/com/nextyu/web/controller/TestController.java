package com.nextyu.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on 2017-05-08 14:07
 *
 * @author nextyu
 */
@RestController
public class TestController {

    @Value("${from}")
    public String from;

    @RequestMapping("/from")
    public String from() {
        return from;
    }
}
