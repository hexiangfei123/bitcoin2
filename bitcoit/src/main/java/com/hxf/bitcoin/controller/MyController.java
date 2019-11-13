package com.hxf.bitcoin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clocks")
@CrossOrigin
public class MyController {
    public String ll(){
        return "sss";
    }
}
