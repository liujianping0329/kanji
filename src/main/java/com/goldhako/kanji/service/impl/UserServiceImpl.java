package com.goldhako.kanji.service.impl;

import com.goldhako.kanji.dao.UserDAO;
import com.goldhako.kanji.exception.KanjiException;
import com.goldhako.kanji.po.User;
import com.goldhako.kanji.po.UserExample;
import com.goldhako.kanji.query.UserQuery;
import com.goldhako.kanji.service.UserService;
import com.goldhako.kanji.vo.UserLoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserLoginVO login(String name, String password) {
        UserLoginVO userLoginVO=new UserLoginVO();
        UserExample userExample=new UserExample();
        userExample.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> users = userDAO.selectByExample(userExample);
        if(users.size()==0){
            throw new KanjiException("login err");
        }
        BeanUtils.copyProperties(users.get(0),userLoginVO);
        return userLoginVO;
    }

    @Override
    public Integer register(UserQuery userQuery) {
        User user=new User();
        BeanUtils.copyProperties(userQuery,user);
        return userDAO.insertSelective(user);
    }
}
