package com.coll.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.coll.dbconfig.DBConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		System.out.println("---- getRootConfig Classes ----");
		return new Class[] {WebResolver.class,DBConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("---- getServletConfigClasses  ----");
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		System.out.println("---- getServletMappings ----");
		return new String[] {"/"};
	}
}
