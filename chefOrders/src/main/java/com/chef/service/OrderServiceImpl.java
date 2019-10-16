package com.chef.service;

import com.chef.facade.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderFacade orderFacade;


    @Override
    public String orderReport() {
        return orderFacade.orderReport();
    }
}
