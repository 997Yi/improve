package com.gfr.improve.service.impl;

import com.gfr.improve.dao.CourseDao;
import com.gfr.improve.entity.Course;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Course)表服务实现类
 *
 * @author makejava
 * @since 2021-01-18 13:47:47
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    @Override
    public Course queryById(String cId) {
        return this.courseDao.queryById(cId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public ResponseData queryAllByLimit(Integer offset, Integer limit) {
        if (offset != null && limit != null) {
            offset = (offset - 1) * limit;
        } else {
            offset = 0;
            limit = 10;
        }
        Integer count = courseDao.count();
        List<Course> courses = courseDao.queryAllByLimit(offset, limit);
        return new ResponseData("0", "success", courses, count);
    }

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Transactional
    @Override
    public ResponseData insert(Course course) {
        boolean isSussecc = false;
        try {
            if (courseDao.insert(course) > 0)
                isSussecc = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (isSussecc)
                return new ResponseData(ResponseCode.SUCCESS, "success");
            else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return new ResponseData(ResponseCode.FAILED, "failed");
            }
        }
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Transactional
    @Override
    public ResponseData update(Course course) {
        boolean isSussecc = false;
        try {
            if (courseDao.update(course) > 0)
                isSussecc = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (isSussecc)
                return new ResponseData(ResponseCode.SUCCESS, "success");
            else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return new ResponseData(ResponseCode.FAILED, "failed");
            }
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    @Transactional
    @Override
    public ResponseData deleteById(String cId) {
        boolean isSussecc = false;
        try {
            if (courseDao.deleteById(cId) > 0)
                isSussecc = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (isSussecc)
                return new ResponseData(ResponseCode.SUCCESS, "success");
            else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return new ResponseData(ResponseCode.FAILED, "failed");
            }
        }
    }

    /**
     * 模糊查询并分页返回
     *
     * @param value
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public ResponseData queryByLike(String value, Integer offset, Integer limit) {
        if (offset != null && limit != null) {
            offset = (offset - 1) * limit;
        } else {
            offset = 0;
            limit = 10;
        }
        List<Course> courseList = null;
        Integer count = null;
        if (value != null) {
            courseList = courseDao.queryByLike(value, offset, limit);
            count = courseDao.countByLike(value);
        } else {
            courseList = courseDao.queryAllByLimit(offset, limit);
            count = courseDao.count();
        }
        return new ResponseData("0", "success", courseList, count);
    }

    /**
     * 删除多行数据
     *
     * @param courses
     * @return
     */
    @Transactional
    @Override
    public ResponseData deleteCourseList(String courses) {
        boolean isSussecc = true;
        try {
            courses = courses.substring(1, courses.length() - 2);
            String[] split = courses.split("@");
            for (String s : split) {
                if (courseDao.deleteById(s) <= 0) {
                    isSussecc = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (isSussecc)
                return new ResponseData(ResponseCode.SUCCESS, "success");
            else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return new ResponseData(ResponseCode.FAILED, "failed");
            }
        }
    }
}