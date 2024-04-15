package com.tj.backend.service.impl;

import com.tj.backend.domain.dto.LoginFormDTO;
import com.tj.backend.domain.dto.RegisterFormDTO;
import com.tj.backend.domain.dto.Result;
import com.tj.backend.domain.po.User;
import com.tj.backend.domain.vo.UserLoginVo;
import com.tj.backend.mapper.UserMapper;
import com.tj.backend.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @author cloud
 * Date: 2024/4/15 18:36
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(LoginFormDTO user) {
        String username = user.getUsername();
        if (StringUtils.isEmpty(username)) {
            return Result.fail("用户名为空");
        }
        String password = user.getPassword();
        if (StringUtils.isEmpty(password)) {
            return Result.fail("密码为空");
        }
        User user1 = userMapper.selectByUsername(username);
        if (user1 == null) {
            return Result.fail("用户不存在");
        }
        if (username.equals(user1.getUsername()) && password.equals(user1.getPassword())) {
            return Result.ok(new UserLoginVo(username));
        }
        return Result.fail("密码错误");
    }

    @Override
    public Result register(RegisterFormDTO user) {
        String username = user.getUsername();
        if (StringUtils.isEmpty(username)) {
            return Result.fail("用户名为空");
        }
        String password = user.getPassword();
        if (StringUtils.isEmpty(password)) {
            return Result.fail("密码为空");
        }
        String checkPassword = user.getCheckPassword();
        if (StringUtils.isEmpty(checkPassword)) {
            return Result.fail("确认密码为空");
        }
        if (!password.equals(checkPassword)) {
            return Result.fail("密码与确认密码不同");
        }

        User user2 = userMapper.selectByUsername(username);
        if (user2 != null) {
            return Result.fail("用户已存在");
        }
        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(password);
        int insert = userMapper.insert(user1);
        if (insert > 0) {
            return Result.ok();
        }
        return Result.fail("注册失败");
    }
}
