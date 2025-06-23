package com.lele.springbootlele.service;

import com.lele.springbootlele.pojo.User;
import com.lele.springbootlele.pojo.dto.UserDto;

// 搞一个接口对程序的拓展性有好处
public interface IUserService {
    /**
     * 插入用户-
     *
     * @param user 参数
     * @return User类
     */
    User add(UserDto user);

    /**
     * 查询用户根据userId
     * @param userId 参数id
     * @return User类
     */
    User getUser(Integer userId);

    /**
     * 修改用户
     * @param user 修改的用户对象
     * @return User类
     */
    User edit(UserDto user);

    /**
     * 根据id删除用户
     *
     * @param userId 参数id
     */
    void delete(Integer userId);
}
