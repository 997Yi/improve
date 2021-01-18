package com.gfr.improve.controller;

import com.gfr.improve.entity.Plan;
import com.gfr.improve.service.PlanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Plan)表控制层
 *
 * @author makejava
 * @since 2021-01-18 13:48:11
 */
@RestController
@RequestMapping("plan")
public class PlanController {
    /**
     * 服务对象
     */
    @Resource
    private PlanService planService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Plan selectOne(String id) {
        return this.planService.queryById(id);
    }

}