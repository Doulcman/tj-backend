package com.tj.backend.controller;

import com.tj.backend.domain.dto.LoginFormDTO;
import com.tj.backend.domain.dto.RegisterFormDTO;
import com.tj.backend.domain.dto.Result;
import com.tj.backend.domain.po.User;
import com.tj.backend.domain.vo.UserLoginVo;
import com.tj.backend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cloud
 * Date: 2024/4/15 18:36
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public Result register(@RequestBody RegisterFormDTO user) {
        return userService.register(user);
    }
}
