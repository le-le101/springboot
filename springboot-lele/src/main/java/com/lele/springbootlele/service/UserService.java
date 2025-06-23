package com.lele.springbootlele.service;

import com.lele.springbootlele.pojo.User;
import com.lele.springbootlele.pojo.dto.UserDto;
import com.lele.springbootlele.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service        // spring的bean
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(UserDto user) {
        // 调用数据访问类
        // 增加可以调用，修改可以调用，自动识别是否有id，有就是新增，没有就是修改
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        return userRepository.save(user1);
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在，参数异常");
        });

    }

    @Override
    public User edit(UserDto user) {
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        return userRepository.save(user2);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }
}
