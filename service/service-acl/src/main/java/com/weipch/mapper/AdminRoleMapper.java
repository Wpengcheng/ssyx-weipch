package com.weipch.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.weipch.model.acl.AdminRole;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
}
