package com.goldhako.kanji.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goldhako.kanji.dao.UserGeoArticleDAO;
import com.goldhako.kanji.exception.KanjiException;
import com.goldhako.kanji.po.UserGeoArticle;
import com.goldhako.kanji.po.UserGeoArticleExample;
import com.goldhako.kanji.query.UserGeoArticleListQuery;
import com.goldhako.kanji.query.UserGeoArticleQuery;
import com.goldhako.kanji.query.UserGeoListQuery;
import com.goldhako.kanji.service.UserGeoArticleService;
import com.goldhako.kanji.service.UserGeoService;
import com.goldhako.kanji.vo.UserGeoArticleListVO;
import com.goldhako.kanji.vo.UserGeoListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGeoArticleServiceImpl implements UserGeoArticleService {

    @Autowired
    private UserGeoService userGeoService;

    @Autowired
    private UserGeoArticleDAO userGeoArticleDAO;

    @Override
    public Integer upsertArticle(UserGeoArticleQuery userGeoArticleQuery) {
        UserGeoArticle userGeoArticle=new UserGeoArticle();
        BeanUtils.copyProperties(userGeoArticleQuery,userGeoArticle);
        if(userGeoArticleQuery.getGeoId()==null){
            UserGeoListQuery userGeoListQuery=new UserGeoListQuery();
            userGeoListQuery.setUserId(userGeoArticleQuery.getUserId());
            List<UserGeoListVO> userGeoListVOS = userGeoService.listGeos(userGeoListQuery).getList();
            if(userGeoListVOS.size()==0){
                throw new KanjiException("geo cannot find");
            }
            userGeoArticle.setGeoId(userGeoListVOS.get(0).getId());
        }
        if(userGeoArticle.getId()!=null){
            userGeoArticleDAO.updateByPrimaryKeySelective(userGeoArticle);
        }else{
            userGeoArticleDAO.insertSelective(userGeoArticle);
        }
        return userGeoArticle.getId();
    }

    @Override
    public PageInfo<UserGeoArticleListVO> listArticles(UserGeoArticleListQuery userGeoArticleListQuery) {
        UserGeoArticleExample userGeoArticleExample=new UserGeoArticleExample();
        UserGeoArticleExample.Criteria criteria = userGeoArticleExample.createCriteria();
        if(userGeoArticleListQuery.getUserId()!=null){
            criteria.andUserIdEqualTo(userGeoArticleListQuery.getUserId());
        }
        userGeoArticleExample.setOrderByClause(" update_at desc ");
        PageHelper.startPage(userGeoArticleListQuery.getPageIndex(),userGeoArticleListQuery.getPageSize());
        List<UserGeoArticle> userGeoArticles = userGeoArticleDAO.selectByExample(userGeoArticleExample);
        PageInfo pageInfo=new PageInfo(userGeoArticles);
        pageInfo.setList(userGeoArticles.stream().map(userGeoArticle -> {
            UserGeoArticleListVO userGeoArticleListVO=new UserGeoArticleListVO();
            BeanUtils.copyProperties(userGeoArticle,userGeoArticleListVO);
            UserGeoListQuery userGeoListQuery=new UserGeoListQuery();
            userGeoListQuery.setId(userGeoArticle.getGeoId());
            userGeoArticleListVO.setUserGeoListVO(userGeoService.listGeos(userGeoListQuery).getList().get(0));
            return userGeoArticleListVO;
        }).collect(Collectors.toList()));
        return pageInfo;
    }
}
