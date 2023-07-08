package com.weipch.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weipch.model.acl.Role;
import com.weipch.vo.acl.RoleQueryVo;

import java.util.Map;

public interface RoleService extends IService<Role> {

    Page<Role> selectRolePage(Long current,Long limit, RoleQueryVo roleQueryVo);

    Map<String, Object> getRoleByAdminId(Long adminId);

    void saveAdminRole(Long adminId, Long[] roleIds);
}
