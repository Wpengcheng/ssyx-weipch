package com.weipch.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weipch.model.acl.Role;
import com.weipch.result.ResponseResult;
import com.weipch.service.RoleService;
import com.weipch.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "角色接口")
@RestController
@RequestMapping("/admin/acl/role")
@CrossOrigin //跨域
public class RoleController {

    //注入service
    @Resource
    private RoleService roleService;

    @ApiOperation("角色条件分页查询")
    @GetMapping("{current}/{limit}")
    public ResponseResult<Page<Role>> pageList(@PathVariable Long current,
                                                @PathVariable Long limit,
                                                RoleQueryVo roleQueryVo) {
        Page<Role> pageModel = roleService.selectRolePage(current,limit,roleQueryVo);
        return ResponseResult.success(pageModel);
    }

    @ApiOperation("根据id查询角色")
    @GetMapping("get/{id}")
    public ResponseResult<Role> get(@PathVariable Long id) {
        Role role = roleService.getById(id);
        return ResponseResult.success(role);
    }

    @ApiOperation("添加角色")
    @PostMapping("save")
    public ResponseResult<Void> save(@RequestBody Role role) {
        boolean is_success = roleService.save(role);
        if(is_success) {
            return ResponseResult.success(null);
        } else {
            return ResponseResult.error(null);
        }
    }

    @ApiOperation("修改角色")
    @PutMapping("update")
    public ResponseResult<Void> update(@RequestBody Role role) {
        roleService.updateById(role);
        return ResponseResult.success(null);
    }

    @ApiOperation("根据id删除角色")
    @DeleteMapping("remove/{id}")
    public ResponseResult<Void> remove(@PathVariable Long id) {
        roleService.removeById(id);
        return ResponseResult.success(null);
    }

    @ApiOperation("批量删除角色")
    @DeleteMapping("batchRemove")
    public ResponseResult<Void> batchRemove(@RequestBody List<Long> idList) {
        roleService.removeByIds(idList);
        return ResponseResult.success(null);
    }

}
