package com.ys.dao;

import com.ys.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询所有
    List<User> selectUserList();
    //通过ID查询
    User getUserById(int id);

    /**
     * 增删改需要提交事务
     */
    //插入用户
    int addUser(User user);
    //修改
    int updateUser(User user);
    //删除
    int deleteUser(int id);
}
