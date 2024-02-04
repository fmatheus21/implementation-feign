package com.fmatheus.app.controller.rule;


import com.fmatheus.app.controller.proxy.service.impl.FeignLocationService;
import com.fmatheus.app.controller.proxy.service.impl.LocationProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RequiredArgsConstructor
@Component
public class LocationRule {

    private final LocationProxy proxy;
    private final FeignLocationService locationService;

    public Object findCepRestTemplate(String cep) {
        log.info("Inciando o metodo de implementacao RestTemplate");
        var template = new RestTemplate();
        var url = String.format("https://viacep.com.br/ws/%s/json/", cep);
        return template.getForEntity(url, Object.class);
    }

    public Object findByCepFeign(String cep) {
        log.info("Inciando o metodo de implementacao Feign");
        return this.proxy.findByCepFeign(cep);
    }

    public Object findByCepFeignRequestLine(String cep) {
        log.info("Inciando o metodo de implementacao Feign Request Line");
        return this.locationService.findByCep(cep);
    }


}
