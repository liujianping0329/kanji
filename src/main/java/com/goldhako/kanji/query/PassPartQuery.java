package com.goldhako.kanji.query;

import lombok.Data;

import java.util.List;

@Data
public class PassPartQuery {
    private Integer kamiId;
    private String kamiName;
    private List<PassPartItemQuery> passPartItemQueries;
}
