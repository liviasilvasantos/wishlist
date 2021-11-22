package com.luizalabs.magalu.backend.teste.wishlistservice.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private ApiInfo apiInfo() {
		return new ApiInfo("API do desafio técnico", "Esta API foi desenvolvida para um desafio técnico",
				"Versão 1.0.0", "https://opensource.org/ToS",
				new Contact("Lívia Silva Santos", "https://www.linkedin.com/in/liviasilvasantos/",
						"liviasilvasantos@gmail"),
				"Apache License 2.0", "https://opensource.org/ToS", Collections.emptyList());
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.select() //
				.apis(RequestHandlerSelectors
						.basePackage("com.luizalabs.magalu.backend.teste.wishlistservice.controller"))
				.paths(PathSelectors.any())//
				.build()//
				.apiInfo(apiInfo()) //
				.useDefaultResponseMessages(false)//
				.globalResponses(HttpMethod.GET,
						Arrays.asList(new ResponseBuilder().code("500").description("Internal Server Error").build(),
								new ResponseBuilder().code("403").description("Forbidden!!!!!").build()));
	}

	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder()//
				.deepLinking(true)//
				.displayOperationId(false)//
				.defaultModelsExpandDepth(1)//
				.defaultModelExpandDepth(1)//
				.defaultModelRendering(ModelRendering.EXAMPLE)//
				.displayRequestDuration(false)//
				.docExpansion(DocExpansion.NONE)//
				.filter(false)//
				.maxDisplayedTags(null)//
				.operationsSorter(OperationsSorter.ALPHA)//
				.showExtensions(false)//
				.tagsSorter(TagsSorter.ALPHA)//
				.supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)//
				.validatorUrl(null)//
				.build();
	}

//    @Bean
//    public EmailAnnotationPlugin emailPlugin() {
//        return new EmailAnnotationPlugin();
//    }
}
