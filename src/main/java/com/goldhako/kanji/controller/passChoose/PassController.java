package com.goldhako.kanji.controller.passChoose;

import com.goldhako.kanji.query.PassQuery;
import com.goldhako.kanji.response.BaseResponse;
import com.goldhako.kanji.service.PassService;
import com.goldhako.kanji.vo.PassVO;
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

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public BaseResponse<PassVO> getPassInfo(@RequestParam(value = "id") Integer id) {
        return new BaseResponse<>(passService.getPassInfo(id));
    }


}
