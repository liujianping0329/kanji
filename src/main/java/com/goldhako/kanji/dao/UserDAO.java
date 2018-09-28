package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.User;
import com.goldhako.kanji.po.UserExample;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, Integer, UserExample> {
}