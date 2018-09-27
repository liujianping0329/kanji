package com.goldhako.kanji.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.goldhako.kanji.query.PassQuery;
import com.goldhako.kanji.response.BaseResponse;
import com.goldhako.kanji.service.CustomerService;
import com.goldhako.kanji.service.PassService;
import org.apache.tomcat.util.modeler.BaseModelMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/pass")
public class PassController {
    @Resource
    private HttpServletRequest request;

    @Autowired
    private PassService passService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public BaseResponse<Integer> insertPass(@RequestBody PassQuery passQuery) {
        return new BaseResponse<>(passService.insertPass());
    }


}
