package com.goldhako.kanji.query;

import lombok.Data;

import java.util.List;

@Data
public class PassQuery {
    private Integer id;
    private String name;
    private List<PassPartQuery> passPartQueries;
}
