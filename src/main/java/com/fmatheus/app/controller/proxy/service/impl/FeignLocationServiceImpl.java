package com.fmatheus.app.controller.proxy.service.impl;


import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeignLocationServiceImpl implements FeignLocationService {

    private final Decoder decoder;
    private final Encoder encoder;

    @Override
    public Object findByCep(String cep) {
        var url = String.format("https://viacep.com.br/ws/%s/json/", cep);
        var proxy = this.bulder(url);
        return proxy.findByCep();
    }


    private LocationRequestLineProxy bulder(String url) {
        return Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                //.options(new Request.Options())
                .encoder(this.encoder)
                .decoder(this.decoder)
                //.retryer()
                //.requestInterceptor(new BasicAuthRequestInterceptor())
                .target(LocationRequestLineProxy.class, url);
    }


}
