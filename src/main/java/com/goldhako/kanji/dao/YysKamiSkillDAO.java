package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.YysKamiSkill;
import com.goldhako.kanji.po.YysKamiSkillExample;
import org.springframework.stereotype.Repository;

/**
 * YysKamiSkillDAO继承基类
 */
@Repository
public interface YysKamiSkillDAO extends MyBatisBaseDao<YysKamiSkill, Integer, YysKamiSkillExample> {
}