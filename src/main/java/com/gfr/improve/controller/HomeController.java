package com.gfr.improve.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    //    跳转到课程详情页面
    @ApiIgnore
    @RequestMapping("getCourseDetail")
    public String getCourseDetail() {
        return "courseDetail";
    }

    //跳转到上传课程页面
    @ApiIgnore
    @RequestMapping("getUploadCourse")
    public String getUploadCourse() {
        return "uploadCourse";
    }

}
