package com.example.searchengine.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket produceApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.searchengine.controller"))
                .paths(paths()).build();
    }

    // describe APIs
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Search Engine Rest APIs")
                .description("This page lists all the rest apis for Search Engine App.")
                .version("1.0-SNAPSHOT").build();
    }

    // only select APIs that matches the given Predicates
    private Predicate<String> paths() {
        // Match all paths except /error
        return Predicates.and(PathSelectors.regex("/api.*"),
                Predicates.not(PathSelectors.regex("/error.*")));
    }
}
