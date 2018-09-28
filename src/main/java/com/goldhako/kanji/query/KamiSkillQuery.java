package com.goldhako.kanji.query;

import lombok.Data;

@Data
public class KamiSkillQuery {
    private Integer id;

    private Integer value;

    /**
     * 等级 1D 2C 3B 4A 5S
     */
    private Integer level;

    private Integer type;

    private String remark;
}
