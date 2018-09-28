package com.goldhako.kanji.service.impl;

import com.goldhako.kanji.dao.YysPassPartItemDAO;
import com.goldhako.kanji.po.YysPassPartItem;
import com.goldhako.kanji.po.YysPassPartItemExample;
import com.goldhako.kanji.service.PassChooseService;
import com.goldhako.kanji.vo.PassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassChooseServiceImpl implements PassChooseService {

    @Autowired
    private YysPassPartItemDAO yysPassPartItemDAO;

    @Override
    public List<PassVO> kamiChoose(Integer kamiId) {
        YysPassPartItemExample yysPassPartItemExample=new YysPassPartItemExample();
        yysPassPartItemExample.createCriteria().andKamiIdEqualTo(kamiId);
        List<YysPassPartItem> yysPassPartItems = yysPassPartItemDAO.selectByExample(yysPassPartItemExample);

        return null;
    }
}
