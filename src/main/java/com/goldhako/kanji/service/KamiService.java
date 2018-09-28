package com.goldhako.kanji.service;

import com.github.pagehelper.PageInfo;
import com.goldhako.kanji.query.KamiListQuery;
import com.goldhako.kanji.query.KamiQuery;
import com.goldhako.kanji.vo.KamiListVO;

public interface KamiService {
    Integer upsertKami(KamiQuery kamiQuery);

    PageInfo<KamiListVO> ListKami(KamiListQuery kamiListQuery);
}
