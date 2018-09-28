package com.goldhako.kanji.vo;

import lombok.Data;

import java.util.List;

@Data
public class PassVO {
    private Integer id;

    private String name;
    private List<PassPartVO> passPartVOS;

    public int getCountByItemKamiId(Integer kamiId){
        int count=0;
        for (PassPartVO passPartVO : passPartVOS) {
            for (PassPartItemVO passPartItemVO : passPartVO.getPassPartItemVOS()) {
                if(passPartItemVO.getKamiId().equals(kamiId)){
                    count+=passPartItemVO.getAmount();
                }
            }
        }
        return count;
    }
}
