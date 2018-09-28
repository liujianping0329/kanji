package com.goldhako.kanji.controller;

import com.github.pagehelper.PageInfo;
import com.goldhako.kanji.query.KamiListQuery;
import com.goldhako.kanji.query.KamiQuery;
import com.goldhako.kanji.query.PassQuery;
import com.goldhako.kanji.response.BaseResponse;
import com.goldhako.kanji.service.KamiService;
import com.goldhako.kanji.service.PassService;
import com.goldhako.kanji.vo.KamiListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/kami")
public class KamiController {
    @Resource
    private HttpServletRequest request;

    @Autowired
    private KamiService kamiService;

    @RequestMapping(value = "/upsert", method = RequestMethod.POST)
    public BaseResponse<Integer> upsertKami(@RequestBody KamiQuery kamiQuery) {
        return new BaseResponse<>(kamiService.upsertKami(kamiQuery));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public BaseResponse<PageInfo<KamiListVO>> ListKami(@RequestBody KamiListQuery kamiListQuery) {
        return new BaseResponse<>(kamiService.ListKami(kamiListQuery));
    }
}
