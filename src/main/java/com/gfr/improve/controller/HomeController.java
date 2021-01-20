package com.gfr.improve.controller;

import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.util.UpUtils;
import com.gfr.improve.entity.Plan;
import com.gfr.improve.service.CourseService;
import com.gfr.improve.service.PlanService;
import com.gfr.improve.service.UserPlanService;
import com.gfr.improve.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author
 */
@Controller
public class HomeController {

    @Resource
    UserService userService;

    @Resource
    PlanService planService;

    @Resource
    UserPlanService userPlanService;

    @Resource
    CourseService courseService;


    /**
     * 跳转到课程详情页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getCourseDetail")
    public String getCourseDetail() {
        return "courseDetail";
    }

    /**
     * 跳转到上传课程页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getUploadCourse")
    public String getUploadCourse() {
        return "uploadCourse";
    }

    /**
     * 返回跳转每日计划页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getPlanDetail")
    public String getPlanDetail(){
        return "planDetail";
    }

    /**
     * 返回跳转用户-每日计划页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getUserPlanDetail")
    public String getUserPlanDetail(){
        return "userPlanDetail";
    }


    /**
     * 返回跳转修改每日计划页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getModPlan")
    public String getModPlan(String planId, HttpServletRequest request){
        HttpSession session = request.getSession();

        Plan plan = planService.queryById(planId);

        session.setAttribute("plan", plan);
        session.setAttribute("course", courseService.queryById(plan.getCourseId()));
        session.setAttribute("courses", courseService.queryAllByLimit(1, 1000).getData());

        return "modPlan";
    }

    /**
     * 返回跳转修改用户-计划页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getModUserPlan")
    public String getModPlan(String userId, String planId, HttpServletRequest request){
        HttpSession session = request.getSession();

        //查询当前映射的用户信息 计划信息 和所有的计划信息
        Plan plan = planService.queryById(planId);
        session.setAttribute("plan", plan);
        session.setAttribute("user", userService.queryById(userId));
        session.setAttribute("course", courseService.queryById(plan.getCourseId()));
        session.setAttribute("user_plan", userPlanService.queryById(userId, planId));
        //将带有名字的计划表存入
        session.setAttribute("plans", planService.queryAllPlanWithName());

        return "modUserPlan";
    }

    /**
     * 返回跳转添加每日计划页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getAddPlan")
    public String getAddPlan(HttpServletRequest request){
        HttpSession session = request.getSession();
        //将所有的数据存入
        session.setAttribute("courses", courseService.queryAllByLimit(1, 1000).getData());
        return "addPlan";
    }

    /**
     * 返回跳转添加每日计划页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getAddUserPlan")
    public String getAddUserPlan(HttpServletRequest request){
        HttpSession session = request.getSession();
        //将所有的数据存入
        session.setAttribute("users", userService.queryAllByLimit(0, 1000));
        //将带有名字的计划表存入
        session.setAttribute("plans", planService.queryAllPlanWithName());
        return "addUserPlan";
    }


    @ApiIgnore
    @RequestMapping("getBodyList")
    public String getBodyList(){
        return "bodyList";
    }


    @ApiIgnore
    @RequestMapping("getUserList")
    public String getUserList(){
        return "userList";
    }

    /**
     * 实现上传功能
     * @param file
     * @param request
     * @return
     */
    @ApiOperation(value = "upfile", notes = "实现上传功能")
    @RequestMapping("upfile")
    @ResponseBody
    public ResponseData upfile(MultipartFile file, HttpServletRequest request) {
        //field	设定文件域的字段名	string	默认值：file 自动传给后台
        //实现文件上传 成功以后返回地址
        String url = UpUtils.upfile(file, request);
        if (url != null) {
            return new ResponseData(ResponseCode.SUCCESS, url);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    /**
     * 返回添加用户页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getAddUser")
    public String getAddUser(){
        return "addUser";
    }


    /**
     * 返回添加身体信息页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("getAddBody")
    public String getAddBody(){
        return "addBody";
    }

}
