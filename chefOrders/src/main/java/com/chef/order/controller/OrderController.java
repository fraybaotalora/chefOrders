package com.chef.order.controller;


import com.chef.order.model.Order;
import com.chef.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Api(value = "Order", description = "REST API for Order", tags = { "Order" })
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "Return order report")
    @RequestMapping(value= "/orderReport",  method = RequestMethod.GET)
    @ResponseBody
    public List<Order> orderReport(){
        return orderService.orderReport();
    }

}
