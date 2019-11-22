package cn.lys.motherland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.lys.motherland.mapper")//通用mapper包扫描，每个mapper接口就不需要再加@Mapper注解声明了
public class MymotherlandApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymotherlandApplication.class, args);
    }

}
