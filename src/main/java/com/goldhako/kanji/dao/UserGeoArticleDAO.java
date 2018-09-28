package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.UserGeoArticle;
import com.goldhako.kanji.po.UserGeoArticleExample;
import org.springframework.stereotype.Repository;

/**
 * UserGeoArticleDAO继承基类
 */
@Repository
public interface UserGeoArticleDAO extends MyBatisBaseDao<UserGeoArticle, Integer, UserGeoArticleExample> {
}