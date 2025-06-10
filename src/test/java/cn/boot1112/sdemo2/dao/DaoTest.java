package cn.boot1112.sdemo2.dao;


import cn.boot1112.sdemo2.Mapper.UserMapper;
import cn.boot1112.sdemo2.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    @Autowired
    private DataSource dataSource;
    @Test
    public void getconnection() throws SQLException {
        System.err.println(dataSource.getConnection());
    }

    @Autowired
    UserMapper userMapper;
    @Test
    public void findbyusername() {
        String  username = "zs";
        User user = userMapper.findbyusername(username);
        System.err.println(user);
        System.err.println(user.getUsername());
        System.err.println(user.getPassword());
    }

    //add  user
    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("123");
        int result = userMapper.addUser(user);
        System.err.println(result);
    }
}
