package com.goldhako.kanji.service.impl;

import com.goldhako.kanji.po.UserGeoArticle;
import com.goldhako.kanji.query.UserGeoArticleQuery;
import com.goldhako.kanji.service.UserGeoArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserGeoArticleServiceImpl implements UserGeoArticleService {



    @Override
    public Integer upsertArticle(UserGeoArticleQuery userGeoArticleQuery) {
        UserGeoArticle userGeoArticle=new UserGeoArticle();
        BeanUtils.copyProperties(userGeoArticleQuery,userGeoArticle);
        if(userGeoArticleQuery.getGeoId()==null){

        }
        return null;
    }
}
