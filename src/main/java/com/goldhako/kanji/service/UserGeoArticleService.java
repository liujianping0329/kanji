package com.goldhako.kanji.service;

import com.github.pagehelper.PageInfo;
import com.goldhako.kanji.query.UserGeoArticleListQuery;
import com.goldhako.kanji.query.UserGeoArticleQuery;
import com.goldhako.kanji.vo.UserGeoArticleListVO;

import java.util.List;

public interface UserGeoArticleService {
    Integer upsertArticle(UserGeoArticleQuery userGeoArticleQuery);

    PageInfo<UserGeoArticleListVO> listArticles(UserGeoArticleListQuery userGeoArticleListQuery);
}
