package com.thespringproject.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	private static final String title = "API Title";
	private static final String description = "API Description";
	private static final String version = "1.0";
	private static String termsOfServiceUrl = "urn:tos"; //default from ApiInfo
	private static final String contactName = null;
	private static final String license = null;
	private static final String licenseUrl = null;
	
	
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			title,
			description,
			version,
			termsOfServiceUrl,
			contactName,
			license,
			licenseUrl);

	@Bean
	public Docket api () {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}

}
