package com.tj.backend.service;

import com.tj.backend.domain.dto.LoginFormDTO;
import com.tj.backend.domain.dto.RegisterFormDTO;
import com.tj.backend.domain.dto.Result;
import com.tj.backend.domain.po.User;
import com.tj.backend.domain.vo.UserLoginVo;

/**
 * @author cloud
 * Date: 2024/4/15 18:36
 */
public interface UserService {
    Result login(LoginFormDTO user);

    Result register(RegisterFormDTO user);
}
