package com.goldhako.kanji.controller.mapperJoy;

import com.goldhako.kanji.query.UserGeoQuery;
import com.goldhako.kanji.query.UserQuery;
import com.goldhako.kanji.response.BaseResponse;
import com.goldhako.kanji.service.UserGeoService;
import com.goldhako.kanji.service.UserService;
import com.goldhako.kanji.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/userGeo")
public class UserGeoController {
    @Resource
    private HttpServletRequest request;

    @Autowired
    private UserGeoService userGeoService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public BaseResponse<Integer> insertGeo(@RequestBody UserGeoQuery userGeoQuery) {
        userGeoQuery.setUserId(((UserLoginVO)request.getSession().getAttribute("userInfo")).getId());
        return new BaseResponse<>(userGeoService.insertGeo(userGeoQuery));
    }

}
