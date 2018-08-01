package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.util.common.CommonConstants;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { CommonConstants.BASE_PACKAGE })
@PropertySource({ CommonConstants.ERROR_PROPERTIES})
public class WebMvcConfig {

	
	
}
