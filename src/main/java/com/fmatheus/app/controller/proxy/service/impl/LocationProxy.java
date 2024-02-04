package com.fmatheus.app.controller.proxy.service.impl;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "location", url = "https://viacep.com.br/ws/")
public interface LocationProxy {


    @GetMapping("{cep}/json")
    Object findByCepFeign(@PathVariable String cep);

}
