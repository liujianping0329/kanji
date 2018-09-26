package com.goldhako.kanji.controller;

import com.goldhako.kanji.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/userShop")
public class UserShopController {
    @Resource
    private HttpServletRequest request;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Integer login() {
        return customerService.findAll().size();
    }


}
