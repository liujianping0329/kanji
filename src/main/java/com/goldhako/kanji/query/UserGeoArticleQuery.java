package com.goldhako.kanji.query;

import lombok.Data;

@Data
public class UserGeoArticleQuery {
    private Integer id;

    private Integer geoId;

    private String pics;

    private String remark;

    private Integer userId;
}
