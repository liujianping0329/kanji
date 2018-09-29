package com.goldhako.kanji.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goldhako.kanji.dao.UserGeoDAO;
import com.goldhako.kanji.po.UserGeo;
import com.goldhako.kanji.po.UserGeoExample;
import com.goldhako.kanji.query.UserGeoListQuery;
import com.goldhako.kanji.query.UserGeoQuery;
import com.goldhako.kanji.service.UserGeoService;
import com.goldhako.kanji.vo.UserGeoListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public PageInfo<UserGeoListVO> listGeos(UserGeoListQuery userGeoListQuery) {
        UserGeoExample userGeoExample=new UserGeoExample();
        UserGeoExample.Criteria criteria = userGeoExample.createCriteria();
        if(userGeoListQuery.getId()!=null){
            criteria.andIdEqualTo(userGeoListQuery.getId());
        }
        if(userGeoListQuery.getLat()!=null){
            criteria.andLatEqualTo(userGeoListQuery.getLat());
        }
        if(userGeoListQuery.getLng()!=null){
            criteria.andLngEqualTo(userGeoListQuery.getLng());
        }
        if(userGeoListQuery.getUserId()!=null){
            criteria.andUserIdEqualTo(userGeoListQuery.getUserId());
        }
        userGeoExample.setOrderByClause(" update_at desc ");
        PageHelper.startPage(userGeoListQuery.getPageIndex(),userGeoListQuery.getPageSize());
        List<UserGeo> userGeos = userGeoDAO.selectByExample(userGeoExample);
        PageInfo pageInfo=new PageInfo(userGeos);
        pageInfo.setList(userGeos.stream().map(userGeo -> {
            UserGeoListVO userGeoListVO=new UserGeoListVO();
            BeanUtils.copyProperties(userGeo,userGeoListVO);
            return userGeoListVO;
        }).collect(Collectors.toList()));
        return pageInfo;
    }
}
