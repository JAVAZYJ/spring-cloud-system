package com.example.spring.cloud.client.service.impl;

import com.example.spring.cloud.client.entity.User;
import com.example.spring.cloud.client.mapper.UserMapper;
import com.example.spring.cloud.client.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YiJieZhu
 * @since 2019-06-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
