package com.weipch.controller;

import com.google.common.collect.Maps;
import com.weipch.result.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 方唐镜
 * @Create 2023-07-04-22:38
 * @Description
 */

@Api(tags = "登录接口")
@RestController
@RequestMapping("/admin/acl/index")
@CrossOrigin
public class IndexController {

    @ApiOperation("登录")
    @PostMapping("login")
    public ResponseResult<Map<String,String>> login() {
        //返回token值
        Map<String,String> map = Maps.newHashMap();
        map.put("token","token-admin");
        return ResponseResult.success(map);
    }


    @ApiOperation("获取登录信息")
    @GetMapping("info")
    public ResponseResult<Map<String,String>> info() {
        Map<String,String> map = Maps.newHashMap();
        map.put("name","admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return ResponseResult.success(map);
    }


    @ApiOperation("退出")
    @PostMapping("logout")
    public ResponseResult<Void> logout() {
        return ResponseResult.success(null);
    }

}
