package com.example.lonua.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ExampleBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.schema.Example;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.validation.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        List<Example> collection = new ArrayList<>();
        Example example = new Example(BaseRes.builder().build());
        collection.add(example);

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage("com.example.lonua")
                                //.or(RequestHandlerSelectors.basePackage("com.example.demo.product"))
                )
                .paths(PathSelectors.any())

                .build()
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET,new ArrayList<Response>(){{
                    add(new ResponseBuilder().code("500").description("500 Server error").build());
                    add(new ResponseBuilder().code("403").description("Forbidden!!!!!").build());
                }})
                .globalResponses(HttpMethod.POST,new ArrayList<Response>(){{
                    add(new ResponseBuilder().code("500").description("500 Server error").build());
                    add(new ResponseBuilder().code("403").description("Forbidden!!!!!").build());
                }})

                .globalResponses(HttpMethod.PATCH,new ArrayList<Response>(){{
                    add(new ResponseBuilder().code("500").description("500 Server error").build());
                    add(new ResponseBuilder().code("403").description("Forbidden!!!!!").build());
                }})

                .globalResponses(HttpMethod.DELETE,new ArrayList<Response>(){{
                    add(new ResponseBuilder().code("500").description("500 Server error").build());
                    add(new ResponseBuilder().code("403").description("Forbidden!!!!!").build());
                }})
//
                .apiInfo(apiInfo("LOUNA", "v1.0"));
    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "패션 쇼핑몰 LONUA",
                version,
                "https://github.com/hyungdoyou/be02-pre-personalproject-lonua.git",
                new Contact("블로그 주소", "https://blog.naver.com/ghdalswl77", "ghdalswl77@naver.com"),
                "Licenses",
                "http://www.alittlevanilla.kro.kr/",
                new ArrayList<>());
    }


}
