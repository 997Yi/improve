package com.gfr.improve.controller;

import com.gfr.improve.entity.User;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-01-18 13:48:30
 */
@Api("User")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    @ApiOperation(value = "queryAll", notes = "查询所有的用户信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page", value = "需要查询的页数", dataType = "int"),
                    @ApiImplicitParam(name = "limit", value = "每页查询的数据量", dataType = "int")
            }
    )
    @GetMapping("queryAll")
    public ResponseData queryAll(int page, int limit){
        return new ResponseData(ResponseCode.SUCCESS, userService.queryAllByLimit((page-1)*limit, limit), userService.queryUserNum());
    }
}