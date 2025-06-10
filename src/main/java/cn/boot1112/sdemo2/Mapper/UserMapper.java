package cn.boot1112.sdemo2.Mapper;


import cn.boot1112.sdemo2.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository//告诉SpringBoot这是一个持久层bean
public interface UserMapper {

    /*
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findbyusername(String username);
    //添加用户
    int addUser(User user);
}
