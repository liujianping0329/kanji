package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.YysPassPartItem;
import com.goldhako.kanji.po.YysPassPartItemExample;
import org.springframework.stereotype.Repository;

/**
 * YysPassPartItemDAO继承基类
 */
@Repository
public interface YysPassPartItemDAO extends MyBatisBaseDao<YysPassPartItem, Integer, YysPassPartItemExample> {
}