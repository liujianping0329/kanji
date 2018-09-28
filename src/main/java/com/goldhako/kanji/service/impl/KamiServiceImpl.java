package com.goldhako.kanji.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goldhako.kanji.dao.YysKamiDAO;
import com.goldhako.kanji.dao.YysKamiSkillDAO;
import com.goldhako.kanji.po.YysKami;
import com.goldhako.kanji.po.YysKamiExample;
import com.goldhako.kanji.po.YysKamiSkill;
import com.goldhako.kanji.po.YysKamiSkillExample;
import com.goldhako.kanji.query.KamiListQuery;
import com.goldhako.kanji.query.KamiQuery;
import com.goldhako.kanji.service.KamiService;
import com.goldhako.kanji.vo.KamiListVO;
import com.goldhako.kanji.vo.KamiSkillVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KamiServiceImpl implements KamiService {

    @Autowired
    private YysKamiDAO yysKamiDAO;

    @Autowired
    private YysKamiSkillDAO yysKamiSkillDAO;

    @Override
    public Integer upsertKami(KamiQuery kamiQuery) {
        YysKami yysKami=new YysKami();
        BeanUtils.copyProperties(kamiQuery,yysKami);
        if(yysKami.getId()!=null){
            yysKamiDAO.updateByPrimaryKeySelective(yysKami);
        }else{
            yysKamiDAO.insertSelective(yysKami);
        }

        if(kamiQuery.getKamiSkillQueries()!=null){
            YysKamiSkillExample yysKamiSkillExample=new YysKamiSkillExample();
            yysKamiSkillExample.createCriteria().andKamiIdEqualTo(yysKami.getId());
            yysKamiSkillDAO.deleteByExample(yysKamiSkillExample);
        }
        kamiQuery.getKamiSkillQueries().forEach(kamiSkillQuery -> {
            YysKamiSkill yysKamiSkill=new YysKamiSkill();
            BeanUtils.copyProperties(kamiSkillQuery,yysKamiSkill);
            yysKamiSkill.setKamiId(yysKami.getId());
            yysKamiSkillDAO.insertSelective(yysKamiSkill);
        });
        return kamiQuery.getKamiSkillQueries().size();
    }

    @Override
    public PageInfo<KamiListVO> ListKami(KamiListQuery kamiListQuery) {
        YysKamiExample yysKamiExample=new YysKamiExample();
        YysKamiExample.Criteria criteria = yysKamiExample.createCriteria();
        if(kamiListQuery.getLevel()!=null){
            criteria.andLevelEqualTo(kamiListQuery.getLevel());
        }
        if(kamiListQuery.getName()!=null){
            criteria.andNameEqualTo(kamiListQuery.getName());
        }
        if(kamiListQuery.getNameLike()!=null){
            criteria.andNameLike("%"+kamiListQuery.getNameLike()+"%");
        }
        if(kamiListQuery.getType()!=null){
            criteria.andTypeEqualTo(kamiListQuery.getType());
        }
        yysKamiExample.setOrderByClause(" update_at desc ");
        PageHelper.startPage(kamiListQuery.getPageIndex(),kamiListQuery.getPageSize());
        List<YysKami> yysKamis = yysKamiDAO.selectByExample(yysKamiExample);
        PageInfo pageInfo=new PageInfo(yysKamis);
        pageInfo.setList(yysKamis.stream().map(yysKami -> {
            KamiListVO kamiListVO=new KamiListVO();
            BeanUtils.copyProperties(yysKami,kamiListVO);
            YysKamiSkillExample yysKamiSkillExample=new YysKamiSkillExample();
            yysKamiSkillExample.createCriteria().andKamiIdEqualTo(yysKami.getId());
            List<YysKamiSkill> yysKamiSkills = yysKamiSkillDAO.selectByExample(yysKamiSkillExample);
            kamiListVO.setKamiSkillVOS(yysKamiSkills.stream().map(yysKamiSkill -> {
                KamiSkillVO kamiSkillVO=new KamiSkillVO();
                BeanUtils.copyProperties(yysKamiSkill,kamiSkillVO);
                return kamiSkillVO;
            }).collect(Collectors.toList()));
            return kamiListVO;
        }).collect(Collectors.toList()));
        return pageInfo;
    }


}
