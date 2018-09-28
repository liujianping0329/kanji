package com.goldhako.kanji.service.impl;

import com.github.pagehelper.PageInfo;
import com.goldhako.kanji.dao.UserGeoDAO;
import com.goldhako.kanji.po.UserGeo;
import com.goldhako.kanji.query.UserGeoListQuery;
import com.goldhako.kanji.query.UserGeoQuery;
import com.goldhako.kanji.service.UserGeoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGeoServiceImpl implements UserGeoService {

    @Autowired
    private UserGeoDAO userGeoDAO;

    @Override
    public Integer insertGeo(UserGeoQuery userGeoQuery) {
        UserGeo userGeo=new UserGeo();
        BeanUtils.copyProperties(userGeoQuery,userGeo);
        return userGeoDAO.insertSelective(userGeo);
    }

//    @Override
//    public PageInfo<UserGeoListVO> listGeos(UserGeoListQuery userGeoListQuery) {
//        UserGeo userGeo=new UserGeo();
//        BeanUtils.copyProperties(userGeoQuery,userGeo);
//        return userGeoDAO.insertSelective(userGeo);
//    }
}
