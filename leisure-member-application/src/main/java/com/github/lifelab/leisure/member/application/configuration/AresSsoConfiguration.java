package com.github.lifelab.leisure.member.application.configuration;

import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.filter.XxlSsoWebFilter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Cathay-ins.com.cn Inc.
 * Copyright (c) 2014-2018 All Rights Reserved.
 *
 * @author fanchengbo
 * @version 1.0.0 2019/5/7 16:54
 **/
@Configuration
public class AresSsoConfiguration implements DisposableBean {

	@Value("${xxl.sso.server}")
	private String xxlSsoServer;

	@Value("${xxl.sso.logout.path}")
	private String xxlSsoLogoutPath;

	@Value("${xxl.sso.excluded.paths}")
	private String xxlSsoExcludedPaths;


	@Bean
	public FilterRegistrationBean xxlSsoFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setName("XxlSsoWebFilter");
		registration.setOrder(1);
		//过滤应用程序中所有资源,当前应用程序根下的所有文件包括多级子目录下的所有文件
		registration.addUrlPatterns("/*");
		registration.setFilter(new XxlSsoWebFilter());
		registration.addInitParameter(Conf.SSO_SERVER, xxlSsoServer);
		registration.addInitParameter(Conf.SSO_LOGOUT_PATH, xxlSsoLogoutPath);
		registration.addInitParameter(Conf.SSO_EXCLUDED_PATHS, xxlSsoExcludedPaths);
		return registration;
	}

	@Override
	public void destroy() throws Exception {

		// xxl-sso, redis close
//        Coffe.close();
//        LocalCacheUtils.remove();
	}
}
