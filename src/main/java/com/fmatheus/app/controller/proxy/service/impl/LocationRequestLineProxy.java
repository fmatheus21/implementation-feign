package com.fmatheus.app.controller.proxy.service.impl;


import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "location-line")
public interface LocationRequestLineProxy {

    @RequestLine(value = "GET")
    Object findByCep();

}
