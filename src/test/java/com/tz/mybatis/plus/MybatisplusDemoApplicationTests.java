package com.tz.mybatis.plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tz.mybatis.plus.domain.Student;
import com.tz.mybatis.plus.domain.User;
import com.tz.mybatis.plus.mapper.StudentMapper;
import com.tz.mybatis.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- UserMapper selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, 1);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.err.println(user);

        System.out.println(("----- StudentMapper selectAll method test ------"));
        List<Student> studentList = studentMapper.selectList(null);
        studentList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("小天");
        user.setAge(21);
        user.setEmail("test@qq.com");
        int insert = userMapper.insert(user);//如果没有设置id，那么会自动生成id
        System.out.println(insert);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(5L);
        user.setName("id:5,修改过后");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

}
