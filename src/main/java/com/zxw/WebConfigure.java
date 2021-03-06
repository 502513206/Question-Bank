package com.zxw;

import com.zxw.utils.SpringContextHolder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zxw
 * @date 2020/8/19 17:43
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.zxw"})
@Configuration
//@ImportResource()
@Import(SpringContextHolder.class)
//@EnableCaching
//@EnableAsync
public class WebConfigure extends WebMvcConfigurationSupport {
    
}
