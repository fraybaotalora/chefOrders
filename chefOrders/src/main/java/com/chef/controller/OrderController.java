package com.chef.controller;


import com.chef.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "Response a order report saved in Database",response = String.class)
    @RequestMapping(value= "/orderReport",  method = RequestMethod.GET)
    @ResponseBody
    public String orderReport(){
        return orderService.orderReport();
    }

}
