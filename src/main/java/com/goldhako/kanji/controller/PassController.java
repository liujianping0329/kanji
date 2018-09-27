package com.goldhako.kanji.controller;

import com.goldhako.kanji.query.PassQuery;
import com.goldhako.kanji.response.BaseResponse;
import com.goldhako.kanji.service.PassService;
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

    @RequestMapping(value = "/upsert", method = RequestMethod.POST)
    public BaseResponse<Integer> upsertPass(@RequestBody PassQuery passQuery) {
        return new BaseResponse<>(passService.upsertPass(passQuery));
    }


}
