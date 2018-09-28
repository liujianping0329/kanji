package com.goldhako.kanji.service;

import com.goldhako.kanji.query.UserQuery;
import com.goldhako.kanji.vo.UserLoginVO;

public interface UserService {
    UserLoginVO login(String name, String password);

    Integer register(UserQuery userQuery);
}
