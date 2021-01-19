package com.gfr.improve.controller;

import com.gfr.improve.entity.Plan;
import com.gfr.improve.service.CourseService;
import com.gfr.improve.service.PlanService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    PlanService planService;

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
        session.setAttribute("courses", courseService.queryAllByLimit(1, 1000));

        return "modPlan";
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
        session.setAttribute("courses", courseService.queryAllByLimit(1, 1000));
        return "addPlan";
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

}
