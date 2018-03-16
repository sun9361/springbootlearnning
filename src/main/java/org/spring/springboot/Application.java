package org.spring.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@MapperScan("org.spring.springboot.dao")

@SpringBootApplication
@EnableTransactionManagement 
// mapper 接口类扫描包配置
public class Application extends SpringBootServletInitializer{
	 @Autowired  
	    private RestTemplateBuilder builder;  
	  
	        // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例  
	    @Bean  
	    public RestTemplate restTemplate() {  
	        return builder.build();  
	    }  
	    @Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(Application.class);
		}

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
    }
}
