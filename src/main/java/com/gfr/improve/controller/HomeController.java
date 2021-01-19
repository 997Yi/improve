package com.gfr.improve.controller;

import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.util.UpUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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

    //跳转到上传课程页面
    @ApiIgnore
    @RequestMapping("getUserList")
    public String getUserListCourse() {
        return "userList";
    }

    //实现上传功能
    @ApiOperation(value = "upfile", notes = "实现上传功能")
    @RequestMapping("upfile")
    @ResponseBody
    public ResponseData upfile(MultipartFile file, HttpServletRequest request) {
        //field	设定文件域的字段名	string	默认值：file 自动传给后台
        //实现文件上传 成功以后返回地址
        String url = UpUtils.upfile(file, request);
        if (url != null) {
            return new ResponseData(ResponseCode.SUCCESS, url);
        } else
            return new ResponseData(ResponseCode.FAILED);
    }
}
