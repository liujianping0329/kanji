package com.goldhako.kanji.service;

import com.goldhako.kanji.query.PassQuery;

public interface PassService {
    Integer upsertPass(PassQuery passQuery);
}
