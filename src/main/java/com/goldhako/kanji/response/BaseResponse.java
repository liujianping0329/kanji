package com.goldhako.kanji.response;



import java.io.Serializable;

/**
 * Created by user on 2017/6/11.
 */
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public String code;

    public String msg;

    public T data;


    public BaseResponse() {
    }

    ;

    /**
     * 通用返回
     *
     * @param code
     * @param msg
     * @param data
     */
    public BaseResponse(String code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(ResponseEnum responseEnum, T data) {
        super();
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
        this.data = data;
    }

    /**
     * 返回正常数据
     *
     * @param data
     */
    public BaseResponse(T data) {
        super();
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getMsg();
        this.data = data;
    }
}
