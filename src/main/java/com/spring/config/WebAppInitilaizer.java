package com.spring.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.spring.util.common.CommonConstants;

public class WebAppInitilaizer implements WebApplicationInitializer {
	public static final Integer MAX_UPLOAD_SIZE = 31 * 1024 * 1024;
	public static final String TMP_FOLDER = "/temp";
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext config = new AnnotationConfigWebApplicationContext();
		ContextLoaderListener context = new ContextLoaderListener(config);
		config.register(WebMvcConfig.class);
		servletContext.addListener(context);
		ServletRegistration.Dynamic servlet= servletContext.addServlet(CommonConstants.DISPATCHER_TXT, new DispatcherServlet(config));
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
        		MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE,
        		MAX_UPLOAD_SIZE);
		servlet.setMultipartConfig(multipartConfigElement);
		servlet.setLoadOnStartup(1);
		servlet.addMapping(CommonConstants.SLASH_TXT);
		servlet.setAsyncSupported(true);
		servlet.setInitParameter(CommonConstants.DISPATCH_OPTIONS_REQUEST_TXT, CommonConstants.BOOLEAN_TXT_TRUE);
	}

}
