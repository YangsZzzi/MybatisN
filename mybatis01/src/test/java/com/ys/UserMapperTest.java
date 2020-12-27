package com.ys;

import com.ys.mapper.UserMapper;
import com.ys.utils.MybatisUtils;
import com.ys.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();

        UserMapper mapper= session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
}
