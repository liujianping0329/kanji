package com.goldhako.kanji.service.impl;

import com.goldhako.kanji.dao.YysPassPartItemDAO;
import com.goldhako.kanji.po.YysPassPartItem;
import com.goldhako.kanji.po.YysPassPartItemExample;
import com.goldhako.kanji.service.PassChooseService;
import com.goldhako.kanji.service.PassService;
import com.goldhako.kanji.vo.PassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PassChooseServiceImpl implements PassChooseService {

    @Autowired
    private YysPassPartItemDAO yysPassPartItemDAO;

    @Autowired
    private PassService passService;

    @Override
    public List<PassVO> kamiChoose(Integer kamiId) {
        YysPassPartItemExample yysPassPartItemExample=new YysPassPartItemExample();
        yysPassPartItemExample.createCriteria().andKamiIdEqualTo(kamiId);
        List<YysPassPartItem> yysPassPartItems = yysPassPartItemDAO.selectByExample(yysPassPartItemExample);
        Set<Integer> passPartItemIds = yysPassPartItems.stream().map(YysPassPartItem::getId).collect(Collectors.toSet());
        List<PassVO> passVOS = new ArrayList<>(
                passPartItemIds.stream().map(partItemId -> passService.getPassByPartItemId(partItemId)).collect(Collectors.toSet())
        );
        passVOS.sort((PassVO v1,PassVO v2)->{
            if(v1.getCountByItemKamiId(kamiId)>v2.getCountByItemKamiId(kamiId))return -1;
            else return 1;
        });
        return passVOS;
    }
}
