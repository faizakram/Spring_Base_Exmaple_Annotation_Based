package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.util.common.CommonConstants;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = { CommonConstants.BASE_PACKAGE })
public class WebMvcConfig {

		// CommonsMultipartResolver
		//@Bean
		/*public CommonsMultipartResolver multipartResolver() {
			CommonsMultipartResolver resolver = new CommonsMultipartResolver();
			//resolver.setMaxInMemorySize(50000000);
			resolver.setDefaultEncoding("utf-8");
			return resolver;
		}*/
	
}