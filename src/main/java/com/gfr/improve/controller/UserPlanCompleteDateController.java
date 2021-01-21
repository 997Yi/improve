package com.gfr.improve.controller;

import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.UserPlanCompleteDateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("UserPlanCompleteDate")
@RestController
@RequestMapping("userPlanCompleteDate")
public class UserPlanCompleteDateController {

    @Resource
    private UserPlanCompleteDateService userPlanCompleteDateService;

    @ApiOperation(value = "queryDate",notes = "查询打卡日期")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "userId",value = "用户id"),
                    @ApiImplicitParam(name = "year",value = "年份"),
                    @ApiImplicitParam(name = "month",value = "月份")
            }
    )
    @GetMapping("queryDate")
    public ResponseData queryDate(String userId, Integer year, Integer month){
        return userPlanCompleteDateService.queryDate(userId, year, month);
    }
    
}
