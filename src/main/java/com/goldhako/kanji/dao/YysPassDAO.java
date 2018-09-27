package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.YysPass;
import com.goldhako.kanji.po.YysPassExample;
import org.springframework.stereotype.Repository;

/**
 * YysPassDAO继承基类
 */
@Repository
public interface YysPassDAO extends MyBatisBaseDao<YysPass, Integer, YysPassExample> {
}