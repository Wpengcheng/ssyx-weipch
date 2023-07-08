package com.weipch.controller;


import com.weipch.model.acl.Permission;
import com.weipch.result.ResponseResult;
import com.weipch.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/acl/permission")
@Api(tags = "菜单管理")
@CrossOrigin //跨域
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    //查询所有菜单
//    url: `${api_name}`,
//    method: 'get'
    @ApiOperation("查询所有菜单")
    @GetMapping
    public ResponseResult<List<Permission>> list() {
        List<Permission> list = permissionService.queryAllPermission();
        return ResponseResult.success(list);
    }

    //添加菜单
//    url: `${api_name}/save`,
//    method: "post",
//    data: permission
    @ApiOperation("添加菜单")
    @PostMapping("save")
    public ResponseResult<Void> save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return ResponseResult.success(null);
    }

    //修改菜单
//    url: `${api_name}/update`,
//    method: "put",
//    data: permission
    @ApiOperation("修改菜单")
    @PutMapping("update")
    public ResponseResult<Void> update(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return ResponseResult.success(null);
    }

    //递归删除菜单
//    url: `${api_name}/remove/${id}`,
//    method: "delete"
    @ApiOperation("递归删除菜单")
    @DeleteMapping("remove/{id}")
    public ResponseResult<Void> remove(@PathVariable Long id) {
        permissionService.removeChildById(id);
        return ResponseResult.success(null);
    }
}
