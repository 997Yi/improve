package com.gfr.improve.controller;

import com.gfr.improve.entity.Course;
import com.gfr.improve.entity.Plan;
import com.gfr.improve.entity.User;
import com.gfr.improve.entity.UserPlan;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.CourseService;
import com.gfr.improve.service.PlanService;
import com.gfr.improve.service.UserPlanService;
import com.gfr.improve.service.UserService;
import com.gfr.improve.util.DateUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * (UserPlan)表控制层
 *
 * @author makejava
 * @since 2021-01-19 19:24:43
 */
@RestController
@RequestMapping("userPlan")
public class UserPlanController {
    /**
     * 服务对象
     */
    @Resource
    private UserPlanService userPlanService;

    @Resource
    private UserService userService;

    @Resource
    private CourseService courseService;

    @Resource
    private PlanService planService;

    /**
     * 通过主键查询单条数据
     *
     * @param userId 主键
     * @param planId 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserPlan selectOne(String userId, String planId) {
        return this.userPlanService.queryById(userId, planId);
    }



    @ApiOperation(value = "queryAll", notes = "查询所有的用户-计划")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", required = true),
            @ApiImplicitParam(name = "limit", dataType = "integer", required = true)
    })
    @ResponseBody
    @GetMapping("queryAll")
    public ResponseData queryAll(Integer page, Integer limit){
        return userPlanService.queryAllByLimit(page, limit);
    }


    @ApiOperation(value = "delUserPlan", notes = "删除集合中用户-计划")
    @DeleteMapping("del")
    @ResponseBody
    public ResponseData delUserPlan(@RequestBody List<UserPlan> userPlanList){
        if(userPlanService.delete(userPlanList)){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
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
        return userPlanService.queryByConditions(condition, page, limit);
    }



    @ApiOperation(value = "modUserPlan", notes = "修改user_plan数据")
    @PutMapping("mod")
    @ResponseBody
    public ResponseData modUserPlan(@RequestBody UserPlan userPlan){
        if(userPlanService.update(userPlan)){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }


    @ApiOperation(value = "addUserPlan", notes = "添加用户-计划")
    @PostMapping("add")
    @ResponseBody
    public ResponseData addUserPlan(@RequestBody UserPlan userPlan){
        if(userPlanService.insert(userPlan)){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }

    @ApiOperation(value = "queryInfo", notes = "查询用户-计划对应的详细信息，例如用户名称和课程名称")
    @GetMapping("queryInfo/{userId}/{planId}")
    @ResponseBody
    public ResponseData queryInfo(@PathVariable("userId") String userId, @PathVariable("planId") String planId){
        Map<String, Object> resMap = new HashMap<>();

        User user = userService.queryById(userId);
        Course course = courseService.queryById(planService.queryById(planId).getCourseId());

        if(user == null || course == null){
            return new ResponseData(ResponseCode.FAILED);
        }else{
            resMap.put("user", user);
            resMap.put("course", course);

            return new ResponseData(ResponseCode.SUCCESS, resMap);
        }
    }



    @ApiOperation(value = "queryInfo", notes = "查询用户-计划对应的详细信息，例如用户名称和课程名称")
    @GetMapping("queryInfo/{userId}")
    @ResponseBody
    public ResponseData queryInfo(@PathVariable("userId") String userId){
        if(userId != null){
            List<Map<String, Object>> resList = new LinkedList<>();
            Map<String, Object> map;

            List<UserPlan> userPlanList = userPlanService.queryByUserId(userId);
            for(UserPlan userPlan : userPlanList){
                //对每一个用户-计划进行遍历
                map = new HashMap<>();

                //判断当前任务是否完成，并且将完成信息存入
                map.put("finish", DateUtil.checkTime(userPlan.getChecktime()));

                Plan plan = planService.queryById(userPlan.getPlanId());
                map.put("plan", plan);
                map.put("course", courseService.queryById(plan.getCourseId()));

                resList.add(map);
            }

            return new ResponseData(ResponseCode.SUCCESS, resList);
        }
        return new ResponseData(ResponseCode.FAILED);
    }

}