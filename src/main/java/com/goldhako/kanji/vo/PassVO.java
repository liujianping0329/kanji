package com.goldhako.kanji.vo;

import lombok.Data;

import java.util.List;

@Data
public class PassVO {
    private Integer id;

    private String name;
    private List<PassPartVO> passPartVOS;
}
