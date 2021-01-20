package com.gfr.improve.controller;

import com.gfr.improve.service.UserPlanCompleteDateService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("UserPlanCompleteDate")
@RestController
@RequestMapping("userPlanCompleteDate")
public class UserPlanCompleteDateController {

    @Resource
    private UserPlanCompleteDateService userPlanCompleteDateService;

    
}
