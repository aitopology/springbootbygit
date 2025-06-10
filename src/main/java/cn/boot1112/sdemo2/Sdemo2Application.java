package cn.boot1112.sdemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.boot1112.sdemo2.Mapper")
public class Sdemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sdemo2Application.class, args);
    }

}
