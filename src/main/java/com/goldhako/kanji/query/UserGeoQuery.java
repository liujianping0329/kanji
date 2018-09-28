package com.goldhako.kanji.query;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class UserGeoQuery {
    private BigDecimal lng;

    private BigDecimal lat;

    private Integer userId;
}
