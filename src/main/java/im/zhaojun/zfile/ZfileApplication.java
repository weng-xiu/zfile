package im.zhaojun.zfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * 启动类
 * @author zhaojun
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@ServletComponentScan(basePackages = {"im.zhaojun.zfile.core.filter", "im.zhaojun.zfile.module.storage.filter"})
@ComponentScan(basePackages = "im.zhaojun.zfile.*")
public class ZfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZfileApplication.class, args);
        System.out.println("ZFile 启动成功: http://localhost:8080/");
    }

}