package com.goldhako.kanji.controller.mapperJoy;

import com.goldhako.kanji.po.UserGeoArticle;
import com.goldhako.kanji.query.UserGeoArticleQuery;
import com.goldhako.kanji.query.UserGeoQuery;
import com.goldhako.kanji.response.BaseResponse;
import com.goldhako.kanji.service.UserGeoArticleService;
import com.goldhako.kanji.service.UserGeoService;
import com.goldhako.kanji.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/userGeo/article")
public class UserGeoArticleController {
    @Resource
    private HttpServletRequest request;

    @Autowired
    private UserGeoArticleService userGeoArticleService;

    @RequestMapping(value = "/upsert", method = RequestMethod.POST)
    public BaseResponse<Integer> upsertArticle(@RequestBody UserGeoArticleQuery userGeoArticleQuery) {
        if(userGeoArticleQuery.getUserId()==null){
            userGeoArticleQuery.setUserId(((UserLoginVO)request.getSession().getAttribute("userInfo")).getId());
        }
        return new BaseResponse<>(userGeoArticleService.upsertArticle(userGeoArticleQuery));
    }

}
