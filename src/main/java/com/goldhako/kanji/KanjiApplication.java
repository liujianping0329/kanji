package com.goldhako.kanji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.goldhako.kanji.dao")
public class KanjiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KanjiApplication.class, args);
    }
}
