package com.goldhako.kanji.vo;

import lombok.Data;

import java.util.List;

@Data
public class PassPartVO {
    private Integer id;

    private Integer kamiId;

    private List<PassPartItemVO> passPartItemVOS;
}
