package com.gfr.improve.service;

import com.gfr.improve.entity.Course;
import com.gfr.improve.result.ResponseData;

import java.util.List;

/**
 * (Course)表服务接口
 *
 * @author makejava
 * @since 2021-01-18 13:47:47
 */
public interface CourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    Course queryById(String cId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    ResponseData queryAllByLimit(Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    ResponseData insert(Course course);

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    ResponseData update(Course course);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    ResponseData deleteById(String cId);

    /**
     * 模糊查询
     * @param value
     * @param page
     * @param limit
     * @return
     */
    ResponseData queryByLike(String value, Integer page, Integer limit);

    /**
     * 删除课程
     * @param courses
     * @return
     */
    ResponseData deleteCourseList(String courses);
}