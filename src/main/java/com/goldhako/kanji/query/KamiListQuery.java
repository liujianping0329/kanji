package com.goldhako.kanji.query;

import com.goldhako.kanji.bo.CommonPageBO;
import lombok.Data;

@Data
public class KamiListQuery extends CommonPageBO {
    private String name;
    private String nameLike;
    private Integer level;

    private Integer type;
}
