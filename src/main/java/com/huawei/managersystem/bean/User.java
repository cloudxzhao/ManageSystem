package com.huawei.managersystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @className: User
 * @author: Jaara
 * @date: 2023/1/30
 * description：
 **/
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
}
