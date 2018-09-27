package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.YysPassPart;
import com.goldhako.kanji.po.YysPassPartExample;
import org.springframework.stereotype.Repository;

/**
 * YysPassPartDAO继承基类
 */
@Repository
public interface YysPassPartDAO extends MyBatisBaseDao<YysPassPart, Integer, YysPassPartExample> {
}