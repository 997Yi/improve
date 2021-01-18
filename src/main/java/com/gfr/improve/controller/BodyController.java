package com.gfr.improve.controller;

import com.gfr.improve.entity.Body;
import com.gfr.improve.service.BodyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Body)表控制层
 *
 * @author makejava
 * @since 2021-01-18 13:47:19
 */
@RestController
@RequestMapping("body")
public class BodyController {
    /**
     * 服务对象
     */
    @Resource
    private BodyService bodyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Body selectOne(String id) {
        return this.bodyService.queryById(id);
    }

}