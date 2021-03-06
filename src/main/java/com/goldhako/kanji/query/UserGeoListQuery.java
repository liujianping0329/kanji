package com.goldhako.kanji.query;

import com.goldhako.kanji.bo.CommonPageBO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserGeoListQuery extends CommonPageBO {
    private Integer id;

    private BigDecimal lng;

    private BigDecimal lat;

    private Integer userId;
}
