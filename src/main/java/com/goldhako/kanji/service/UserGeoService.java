package com.goldhako.kanji.service;

import com.github.pagehelper.PageInfo;
import com.goldhako.kanji.query.UserGeoListQuery;
import com.goldhako.kanji.query.UserGeoQuery;
import com.goldhako.kanji.vo.UserGeoListVO;

public interface UserGeoService {
    Integer insertGeo(UserGeoQuery userGeoQuery);

    PageInfo<UserGeoListVO> listGeos(UserGeoListQuery userGeoListQuery);
}
