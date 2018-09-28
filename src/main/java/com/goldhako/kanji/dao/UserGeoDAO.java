package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.UserGeo;
import com.goldhako.kanji.po.UserGeoExample;
import org.springframework.stereotype.Repository;

/**
 * UserGeoDAO继承基类
 */
@Repository
public interface UserGeoDAO extends MyBatisBaseDao<UserGeo, Integer, UserGeoExample> {
}