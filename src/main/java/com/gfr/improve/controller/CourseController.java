package com.gfr.improve.controller;

import com.gfr.improve.entity.Course;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.CourseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2021-01-18 13:47:48
 */
@RestController
@RequestMapping("course")
public class CourseController {


    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public ResponseData selectOne(@PathVariable("id") String id) {
        Course course = courseService.queryById(id);
        if(course != null){
            return new ResponseData(ResponseCode.SUCCESS, course);
        }
        return new ResponseData(ResponseCode.FAILED);
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "queryAllByLimit",notes = "分页查询")
    @GetMapping("queryAllByLimit")
    public ResponseData queryAllByLimit(Integer page,Integer limit){
        return courseService.queryAllByLimit(page,limit);
    }


    /**
     * 根据id删除数据
     */
    @ApiOperation(value = "deleteCourse",notes = "根据id删除数据")
    @ApiImplicitParam(name="cid",value = "需要删除的数据id",type = "string")
    @DeleteMapping("deleteCourse")
    public ResponseData deleteCourse(@RequestBody Course course){
        return courseService.deleteById(course.getCId());
    }

    /**
     * 根据前台修改的数据进行修改
     */
    @ApiOperation(value = "updateCourse",notes = "根据前台修改的数据进行修改")
    @PatchMapping("updateCourse")
    public ResponseData updateCourse(@RequestBody Course course){
        return courseService.update(course);
    }

    /**
     * 模糊查询
     * @param value
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "queryByLike",notes = "模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "模糊查询的关键字"),
            @ApiImplicitParam(name = "page", value = "查询后需要显示的页数"),
            @ApiImplicitParam(name = "limit", value = "每页显示的数据")
    })
    @GetMapping("queryByLike")
    public ResponseData queryByLike(String value,Integer page,Integer limit){
        return courseService.queryByLike(value,page,limit);
    }

    /**
     * 删除多行数据
     * @param courses
     * @return
     */
    @ApiOperation(value = "deleteCourseList",notes = "删除多行数据")
    @DeleteMapping("deleteCourseList")
    public ResponseData deleteCourseList(@RequestBody String courses){
        return courseService.deleteCourseList(courses);
    }

    /**
     * 增加课程
     * @param course
     * @return
     */
    @ApiOperation(value = "insertCourse",notes = "插入课程")
    @PostMapping("insertCourse")
    public ResponseData insertCourse(@RequestBody Course course){
        return courseService.insert(course);
    }

}