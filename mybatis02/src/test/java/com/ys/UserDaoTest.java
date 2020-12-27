package com.ys;

import com.ys.dao.UserMapper;
import com.ys.pojo.User;
import com.ys.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void selectUserListTest(){
        SqlSession session = MybatisUtils.getsqlsession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUserList();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
    @Test
    public void getUserByIdTest(){
        SqlSession session = MybatisUtils.getsqlsession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }
    @Test
    public void addUserTest(){
        SqlSession session = MybatisUtils.getsqlsession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(new User(4,"哈哈","23333"));
        session.commit();
        session.close();
    }
    @Test
    public void updateUser(){
        SqlSession session = MybatisUtils.getsqlsession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"嘿嘿","0000"));
        session.commit();
        session.close();

    }
    @Test
    public void deleteUserTest(){
        SqlSession session = MybatisUtils.getsqlsession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        session.commit();
        session.close();
    }
}
