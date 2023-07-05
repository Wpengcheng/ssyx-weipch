package com.weipch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weipch.mapper.AdminRoleMapper;
import com.weipch.model.acl.AdminRole;
import com.weipch.service.AdminRoleService;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
}
