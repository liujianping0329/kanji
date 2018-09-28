package com.goldhako.kanji.vo;

import lombok.Data;

@Data
public class KamiSkillVO {
    private Integer id;

    private Integer value;

    /**
     * 等级 1D 2C 3B 4A 5S
     */
    private Integer level;

    private Integer type;

    private String remark;
}
