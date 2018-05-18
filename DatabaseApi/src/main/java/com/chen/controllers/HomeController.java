package com.chen.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import com.chen.model.Test;
import com.chen.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("")
public class HomeController {
    @Autowired
    private TestService tService;

    @Get("")
    public String getHome() {
        return "index";
    }

    // http://localhost:8080/databaseapi/db
    @Get("db")
    public String getTest() {
        Test t = tService.getTest();
        String s = "No." + t.getId() + " is " + t.getMsg();
        return "@" + s;
    }
}
