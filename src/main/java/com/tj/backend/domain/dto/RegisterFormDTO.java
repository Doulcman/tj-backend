package com.tj.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cloud
 * Date: 2024/4/15 19:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterFormDTO {
    private String username;
    private String password;
    private String checkPassword;
}
