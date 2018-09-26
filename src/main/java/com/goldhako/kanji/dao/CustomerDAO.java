package com.goldhako.kanji.dao;

import com.goldhako.kanji.po.Customer;
import com.goldhako.kanji.po.CustomerExample;

/**
 * CustomerDAO继承基类
 */
public interface CustomerDAO extends MyBatisBaseDao<Customer, Integer, CustomerExample> {
}