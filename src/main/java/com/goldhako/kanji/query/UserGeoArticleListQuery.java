package com.goldhako.kanji.query;

import com.goldhako.kanji.bo.CommonPageBO;
import lombok.Data;

@Data
public class UserGeoArticleListQuery extends CommonPageBO {
    private Integer userId;
}
