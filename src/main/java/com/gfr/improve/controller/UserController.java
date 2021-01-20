package com.gfr.improve.controller;

import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import com.gfr.improve.entity.User;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
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
        return new ResponseData("0", "操作成功", userService.queryAllByLimit((page-1)*limit, limit), userService.queryUserNum());
    }

    @ApiOperation(value = "deleteById", notes = "删除对应id的用户")
    @ApiImplicitParam(name = "userId", value = "需要删除的用户id")
    @DeleteMapping("deleteById/{userId}")
    public ResponseData deleteById(@PathVariable("userId") String userId){
        return new ResponseData(ResponseCode.SUCCESS, userService.deleteById(userId));
    }

    @ApiOperation(value = "queryByLike",notes = "模糊查询")
    @ApiImplicitParam(name = "value",value = "类型,标题")
    @GetMapping("queryByLike")
    public  ResponseData queryByLike(String value,Integer page,Integer limit){
        return userService.queryByLike(value, page, limit);
    }

    @ApiOperation(value = "updateUser", notes = "更新用户")
    @ApiImplicitParam(name = "user", value = "用户")
    @PatchMapping("updateUser")
    public  ResponseData updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ApiOperation(value = "deleteUsers", notes = "批量删除用户")
    @ApiImplicitParam(name = "userIdList", value = "用户ID")
    @DeleteMapping("deleteUsers")
    public ResponseData deleteUsers(@RequestBody List<String> userIdList){
        return userService.deleteUsers(userIdList);
    }

    @ApiOperation(value = "addUser", notes = "添加用户")
    @ApiImplicitParam(name = "user", value = "用户")
    @PostMapping("addUser")
    public  ResponseData addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}