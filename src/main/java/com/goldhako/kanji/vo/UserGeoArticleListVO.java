package com.goldhako.kanji.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserGeoArticleListVO {
    private Integer id;

    private Integer geoId;

    private String pics;

    private String remark;

    private Integer userId;

    private Date createAt;

    private Date updateAt;

    private UserGeoListVO userGeoListVO;
}
