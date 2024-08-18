package com.example.demo.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.entity.User;

import javax.sql.RowSet;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-08-10 23:53:50
 */
public interface UserService extends IService<User> {


    User findByUsername(String username);


    Boolean check(String pw, String password);

    User findById(Long userid);

}

