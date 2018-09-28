package com.goldhako.kanji.service;

import com.goldhako.kanji.query.PassQuery;
import com.goldhako.kanji.vo.PassVO;

public interface PassService {
    Integer upsertPass(PassQuery passQuery);

    PassVO getPassInfo(Integer id);
}
