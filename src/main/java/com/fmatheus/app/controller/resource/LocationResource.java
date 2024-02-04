package com.fmatheus.app.controller.resource;


import com.fmatheus.app.controller.rule.LocationRule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/location")
public class LocationResource {

    private final LocationRule rule;


    @GetMapping("/rest-template/cep/{cep}")
    public Object findCepRestTemplate(@PathVariable String cep) {
        return this.rule.findCepRestTemplate(cep);
    }

    @GetMapping("/feign/cep/{cep}")
    public Object findByCepFeign(@PathVariable String cep) {
        return this.rule.findByCepFeign(cep);
    }

    @GetMapping("/feign-request-line/cep/{cep}")
    public Object findByCepFeignRequestLine(@PathVariable String cep) {
        return this.rule.findByCepFeignRequestLine(cep);
    }


}
