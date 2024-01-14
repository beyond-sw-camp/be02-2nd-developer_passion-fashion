package com.example.lonua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage("com.example.lonua")
                                //.or(RequestHandlerSelectors.basePackage("com.example.demo.product"))
                )
                .paths(PathSelectors.any()) ///?
                .build()
                .apiInfo(apiInfo("LOUNA", "v1.0"));
    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "스프링 문서화 수업 별거 없음",
                version,
                "https://github.com/hyungdoyou/be02-pre-personalproject-lonua.git",
                new Contact("블로그 주소", "https://blog.naver.com/ghdalswl77", "ghdalswl77@naver.com"),
                "Licenses",
                "http://www.alittlevanilla.kro.kr/",
                new ArrayList<>());
    }


}
