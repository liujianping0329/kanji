package com.goldhako.kanji.vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class UserGeoListVO {
    private Integer id;

    private BigDecimal lng;

    private BigDecimal lat;

    private Integer userId;
}
