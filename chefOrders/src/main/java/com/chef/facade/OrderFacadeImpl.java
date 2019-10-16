package com.chef.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderFacadeImpl implements OrderFacade {

    @Value("${vtex.api.listorders}")
    private String URL;


    @Autowired
    RestTemplate restTemplate;

    @Override
    public String orderReport() {

        String lista = restTemplate.getForObject(URL, String.class);

        return lista ;
    }
}
