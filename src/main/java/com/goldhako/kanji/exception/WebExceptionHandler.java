package com.goldhako.kanji.exception;

import com.goldhako.kanji.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(KanjiException.class)
    @ResponseBody
    public BaseResponse handleShlxddException(HttpServletResponse response, KanjiException e) {
        response.setStatus(HttpStatus.OK.value()); // 前端要求所有请求返回200，返回状态取json数据
        return new BaseResponse(e.getCode(),e.getMsg(),null);
    }

}
