package com.tj.backend.mapper;

import com.tj.backend.domain.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author cloud
 * Date: 2024/4/15 18:40
 */
@Mapper
@Component
public interface UserMapper {
    @Insert("INSERT INTO user_table(username, password) VALUES(#{username}, #{password})")
    int insert(User user);

    @Select("SELECT * FROM user_table WHERE username = #{username}")
    User selectByUsername(String username);
}
