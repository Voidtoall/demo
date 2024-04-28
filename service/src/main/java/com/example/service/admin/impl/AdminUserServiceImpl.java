package com.example.service.admin.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.admin.AdminUserMapper;
import com.example.domain.AdminUser;
import com.example.service.admin.IAdminUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyh
 * @since 2024-04-26 ��:��:��
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

}
