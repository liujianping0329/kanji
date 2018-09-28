package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.YysKami;
import com.goldhako.kanji.po.YysKamiExample;
import org.springframework.stereotype.Repository;

/**
 * YysKamiDAO继承基类
 */
@Repository
public interface YysKamiDAO extends MyBatisBaseDao<YysKami, Integer, YysKamiExample> {
}