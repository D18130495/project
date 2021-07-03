package com.shun.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.shun.eduservice.mapper")
public class EduConfig {

}
