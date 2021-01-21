package com.gfr.improve.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gfr.improve.entity.Plan;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.PlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Plan)表控制层
 *
 * @author makejava
 * @since 2021-01-19 10:12:17
 */

@Api("每日计划controller")
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


    @ApiOperation(value = "queryAll", notes = "查询所有的每日计划")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", required = true),
            @ApiImplicitParam(name = "limit", dataType = "integer", required = true)
    })
    @ResponseBody
    @GetMapping("queryAll")
    public ResponseData queryAll(Integer page, Integer limit){
        return planService.queryAllByLimit(page, limit);
    }


    @ApiOperation(value = "queryByLike", notes = "根据条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", dataType = "string", required = true),
            @ApiImplicitParam(name = "page", dataType = "integer", required = true),
            @ApiImplicitParam(name = "limit", dataType = "integer", required = true)
    })
    @ResponseBody
    @GetMapping("queryByLike")
    public ResponseData queryByLike(String condition, Integer page, Integer limit){
        return planService.queryByConditions(condition, page, limit);
    }


    @ApiOperation(value = "modPlan", notes = "修改plan数据")
    @PutMapping("modPlan")
    @ResponseBody
    public ResponseData modPlan(@RequestBody Plan plan){
        if(planService.update(plan)){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }

    @ApiOperation(value = "delPlan", notes = "删除集合中的id对应的计划")
    @ApiImplicitParam(name = "planId", dataType = "list", required = true)
    @DeleteMapping("delPlan")
    @ResponseBody
    public ResponseData delPlan(@RequestBody List<String> planId){
        if(planService.deleteById(planId)){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }

    @ApiOperation(value = "addPlan", notes = "添加计划")
    @PostMapping("addPlan")
    @ResponseBody
    public ResponseData addPlan(@RequestBody Plan plan){
        if(planService.insert(plan)){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }



    @ApiOperation(value = "listNewPlan", notes = "查询当天开始的计划")
    @GetMapping("listNew")
    @ResponseBody
    public ResponseData listNewPlan(){
        return planService.queryNewPlan();
    }


}