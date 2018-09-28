package com.goldhako.kanji.service;

import com.goldhako.kanji.vo.PassVO;

import java.util.List;

public interface PassChooseService {
    List<PassVO> kamiChoose(Integer kamiId);
}
