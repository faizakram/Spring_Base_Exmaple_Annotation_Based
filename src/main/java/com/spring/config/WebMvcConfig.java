package com.spring.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.util.common.CommonConstants;

@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages = { CommonConstants.BASE_PACKAGE })
public class WebMvcConfig {

	public static final Integer MAX_UPLOAD_SIZE = 31 * 1024 * 1024;
	public static final String UTF_8 = "UTF-8";
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
		resolver.setDefaultEncoding(UTF_8);
		return resolver;
	}
	@Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsynchThread-");
        executor.initialize();
        return executor;
    }

}
