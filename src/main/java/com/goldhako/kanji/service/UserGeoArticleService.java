package com.goldhako.kanji.service;

import com.goldhako.kanji.query.UserGeoArticleQuery;

public interface UserGeoArticleService {
    Integer upsertArticle(UserGeoArticleQuery userGeoArticleQuery);
}
