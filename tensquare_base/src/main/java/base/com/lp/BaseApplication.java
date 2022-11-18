package base.com.lp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author lipeng
 * @Date 2022/11/15 14:41
 * @Version 1.0
 */
@SpringBootApplication
@Slf4j
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
        log.info("项目初始化完成");
    }
}
