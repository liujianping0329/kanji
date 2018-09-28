package com.goldhako.kanji.controller.passChoose;

import com.goldhako.kanji.query.PassQuery;
import com.goldhako.kanji.response.BaseResponse;
import com.goldhako.kanji.service.PassChooseService;
import com.goldhako.kanji.service.PassService;
import com.goldhako.kanji.vo.PassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/passChoose")
public class PassChooseController {
    @Resource
    private HttpServletRequest request;

    @Autowired
    private PassChooseService passChooseService;

    @RequestMapping(value = "/kami", method = RequestMethod.GET)
    public BaseResponse<List<PassVO>> kamiChoose(@RequestParam(value = "kamiId") Integer kamiId) {
        return new BaseResponse<>(passChooseService.kamiChoose(kamiId));
    }


}
