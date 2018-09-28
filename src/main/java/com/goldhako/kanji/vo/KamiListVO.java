package com.goldhako.kanji.vo;

import lombok.Data;

import java.util.List;

@Data
public class KamiListVO {
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

    private List<KamiSkillVO> kamiSkillVOS;
}
