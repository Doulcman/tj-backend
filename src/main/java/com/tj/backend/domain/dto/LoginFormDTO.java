package com.tj.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cloud
 * Date: 2024/4/15 19:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginFormDTO {
    private String username;
    private String password;
}
