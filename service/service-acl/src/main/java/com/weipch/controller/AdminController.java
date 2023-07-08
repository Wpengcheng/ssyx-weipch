package com.weipch.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weipch.model.acl.Admin;
import com.weipch.result.ResponseResult;
import com.weipch.service.AdminService;
import com.weipch.service.RoleService;
import com.weipch.vo.acl.AdminQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/admin/acl/user")
@CrossOrigin
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private RoleService roleService;

    //为用户进行分配
//    url: `${api_name}/doAssign`,
//    method: 'post',
//    params: {
//        adminId,
//        roleId
//    }
    //参数有用户id 和 多个角色id
    @ApiOperation("为用户进行角色分配")
    @PostMapping("doAssign")
    public ResponseResult<Void> doAssign(@RequestParam Long adminId,
                                   @RequestParam Long[] roleId) {
        roleService.saveAdminRole(adminId,roleId);
        return ResponseResult.success(null);
    }


    //获取所有角色，和根据用户id查询用户分配角色列表
//    url: `${api_name}/toAssign/${adminId}`,
//    method: 'get'
    @ApiOperation("获取用户角色")
    @GetMapping("toAssign/{adminId}")
    public ResponseResult<Map<String,Object>> toAssign(@PathVariable Long adminId) {
        //返回map集合包含两部分数据：所有角色 和 为用户分配角色列表
       Map<String,Object> map  = roleService.getRoleByAdminId(adminId);
       return ResponseResult.success(map);
    }

    //1 用户列表
    @ApiOperation("用户列表")
    @GetMapping("{current}/{limit}")
    public ResponseResult<IPage<Admin>> list(@PathVariable Long current,
                               @PathVariable Long limit,
                               @RequestBody AdminQueryVo adminQueryVo) {
        Page<Admin> pageParam = new Page<Admin>(current,limit);
        IPage<Admin> pageModel = adminService.selectPageUser(pageParam,adminQueryVo);
        return ResponseResult.success(pageModel);
    }

    //2 id查询用户
//    url: `${api_name}/get/${id}`,
//    method: 'get'
    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public ResponseResult<Admin> get(@PathVariable Long id) {
        Admin admin = adminService.getById(id);
        return ResponseResult.success(admin);
    }

    //3 添加用户
//    url: `${api_name}/save`,
//    method: 'post',
//    data: user
//    @ApiOperation("添加用户")
//    @PostMapping("save")
//    public ResponseResult<Void> save(@RequestBody Admin admin) {
//        //获取输入的密码
//        String password = admin.getPassword();
//
//        //对输入密码进行加密 MD5
//        String passwordMD5 = MD5.encrypt(password);
//
//        //设置到admin对象里面
//        admin.setPassword(passwordMD5);
//
//        //调用方法添加
//        adminService.save(admin);
//        return ResponseResult.success(null);
//    }

    //4 修改用户
//    url: `${api_name}/update`,
//    method: 'put',
//    data: user
    @ApiOperation("修改用户")
    @PutMapping("update")
    public ResponseResult<Void> update(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return ResponseResult.success(null);
    }

    //5 id删除
//    url: `${api_name}/remove/${id}`,
//    method: 'delete'
    @ApiOperation("根据id删除用户")
    @DeleteMapping("remove/{id}")
    public ResponseResult<Void> remove(@PathVariable Long id) {
        adminService.removeById(id);
        return ResponseResult.success(null);
    }

    //6 批量删除
//    url: `${api_name}/batchRemove`,
//    method: 'delete',
//    data: ids
    // [1,2,3]
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public ResponseResult<Void> batchRemove(@RequestBody List<Long> idList) {
        adminService.removeByIds(idList);
        return ResponseResult.success(null);
    }

}
