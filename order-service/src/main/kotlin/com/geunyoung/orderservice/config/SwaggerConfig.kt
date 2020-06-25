package com.geunyoung.orderservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun apiDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.geunyoung.orderservice"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
    }

    private val apiInfo: ApiInfo
        get() = ApiInfo(
                "Saga Pattern Implementation using Axon and Spring Boot",
                "App to demonstrate Saga Pattern using Axon and Spring Boot",
                "1.0.0",
                "Terms of Service",
                Contact("BaekGeunYoung", "github.com/BaekGeunYoung", "dvmflstm@gmail.com"),
                "",
                "",
                listOf())
}