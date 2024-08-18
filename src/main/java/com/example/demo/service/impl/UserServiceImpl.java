package com.example.demo.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-08-10 23:53:50
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = this.getOne(queryWrapper);
        if(user == null || user.getStatus() ==0){
            System.out.println("username not exist or user is not valid");
            return null;
        }

        return user;
    }

    @Override
    public Boolean check(String pw, String password) {
        String md5p = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!StringUtils.equals(md5p, pw)){
            return false;
        }
        return true;

    }

    @Override
    public User findById(Long userid) {
        return userMapper.selectById(userid);
    }

}

