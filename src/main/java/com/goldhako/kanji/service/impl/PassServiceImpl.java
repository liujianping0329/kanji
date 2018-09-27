package com.goldhako.kanji.service.impl;

import com.goldhako.kanji.dao.YysPassDAO;
import com.goldhako.kanji.dao.YysPassPartDAO;
import com.goldhako.kanji.dao.YysPassPartItemDAO;
import com.goldhako.kanji.po.*;
import com.goldhako.kanji.query.PassQuery;
import com.goldhako.kanji.service.PassService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassServiceImpl implements PassService {

    @Autowired
    private YysPassDAO yysPassDAO;

    @Autowired
    private YysPassPartDAO yysPassPartDAO;

    @Autowired
    private YysPassPartItemDAO yysPassPartItemDAO;

    @Override
    public Integer upsertPass(PassQuery passQuery) {
        YysPass yysPass=new YysPass();
        BeanUtils.copyProperties(passQuery,yysPass);
        if(yysPass.getId()!=null){
            yysPassDAO.updateByPrimaryKeySelective(yysPass);
        }else{
            yysPassDAO.insertSelective(yysPass);
        }

        if(passQuery.getPassPartQueries()!=null){
            YysPassPartExample yysPassPartExample=new YysPassPartExample();
            yysPassPartExample.createCriteria().andPassIdEqualTo(yysPass.getId());
            List<YysPassPart> yysPassParts = yysPassPartDAO.selectByExample(yysPassPartExample);
            List<Integer> passPartIds=yysPassParts.stream().map(YysPassPart::getId).collect(Collectors.toList());

            if(passPartIds.size()!=0){
                YysPassPartItemExample yysPassPartItemExample=new YysPassPartItemExample();
                yysPassPartItemExample.createCriteria().andPassPartIdIn(passPartIds);

                yysPassPartDAO.deleteByExample(yysPassPartExample);
                yysPassPartItemDAO.deleteByExample(yysPassPartItemExample);
            }

        }

        passQuery.getPassPartQueries().forEach(passPartQuery -> {
            YysPassPart yysPassPart=new YysPassPart();
            BeanUtils.copyProperties(passPartQuery,yysPassPart);
            yysPassPart.setPassId(yysPass.getId());
            yysPassPartDAO.insertSelective(yysPassPart);
            passPartQuery.getPassPartItemQueries().forEach(passPartItemQuery -> {
                YysPassPartItem yysPassPartItem=new YysPassPartItem();
                BeanUtils.copyProperties(passPartItemQuery,yysPassPartItem);
                yysPassPartItem.setPassPartId(yysPassPart.getId());
                yysPassPartItemDAO.insertSelective(yysPassPartItem);
            });
        });
        return passQuery.getPassPartQueries().size();
    }
}
