package com.chef.auth.controller;

import com.chef.auth.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@Api(value = "Auth", description = "REST API for Auth", tags = { "Auth" })
public class AuthController {

    @RequestMapping( value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "Login of a user")
    @ResponseStatus(HttpStatus.OK)
    private void login(@RequestBody User user){
        System.out.println(user.getPassword() + "-----------" + user.getUser());
    }

}
