package com.goldhako.kanji.query;

import lombok.Data;

import java.util.List;

@Data
public class KamiQuery {
    private Integer id;

    private String name;

    /**
     * 等级
     */
    private Integer level;

    private Integer type;

    /**
     * 备注
     */
    private String remark;

    private List<KamiSkillQuery> kamiSkillQueries;
}
