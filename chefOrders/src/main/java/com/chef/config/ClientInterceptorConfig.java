package com.chef.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;

import java.io.IOException;


@PropertySource("classpath:/application.properties")
public class ClientInterceptorConfig implements ClientHttpRequestInterceptor{


    @Value ("${vtex.api.apptoken.name}")
    private  String tokenName;
    @Value ("${vtex.api.apptoken.value}")
    private  String tokenValue;
    @Value ("${vtex.api.appkey.name}")
    private  String keyName;
    @Value ("${vtex.api.appkey.value}")
    private  String keyValue;

    Logger logger = LoggerFactory.getLogger(ClientInterceptorConfig.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        httpRequest.getHeaders().add(tokenName,tokenValue);
        httpRequest.getHeaders().add(keyName,keyValue);
        httpRequest.getHeaders().add("Content-Type","application/json");
        logger.info("\n-----------------------------------");
        logger.info(httpRequest.getHeaders().toString());
        logger.info(httpRequest.getURI().toString());
        logger.info(httpRequest.getMethod().toString());
        logger.info("-----------------------------------\n");

         return clientHttpRequestExecution.execute(httpRequest, body);

    }


}
