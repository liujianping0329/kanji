package com.goldhako.kanji.controller.mapperJoy;

import com.goldhako.kanji.query.UserQuery;
import com.goldhako.kanji.response.BaseResponse;
import com.goldhako.kanji.service.CustomerService;
import com.goldhako.kanji.service.UserService;
import com.goldhako.kanji.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse<UserLoginVO> login(@RequestParam(value = "name")String name, @RequestParam(value = "password") String password) {
        return new BaseResponse<>(userService.login(name,password));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse<Integer> register(@RequestBody UserQuery userQuery) {
        return new BaseResponse(userService.register(userQuery));
    }


}
