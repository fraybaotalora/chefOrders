package com.chef.order.service;

import com.chef.order.model.Order;
import com.chef.order.facade.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderFacade orderFacade;


    @Override
    public List<Order> orderReport() {
        return orderFacade.orderReport();


    }
}
