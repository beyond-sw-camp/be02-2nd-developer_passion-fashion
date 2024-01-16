package com.example.lonua.config;

<<<<<<< HEAD
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


=======

import com.example.lonua.product.model.request.PostRegisterProductReq;
import io.swagger.models.auth.In;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {

    @Bean
    public Docket newsApiAll() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("00. All Device API REST Service")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.lonua"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .useDefaultResponseMessages(false)
                .ignoredParameterTypes(BasicErrorController.class)
                .globalResponses(HttpMethod.GET,new ArrayList<Response>(){{
                    add(new ResponseBuilder().code("200").description("OK ( 요청 성공 )").build());
                    add(new ResponseBuilder().code("400").description("Bad Request ( 잘못된 요청입니다 )").build());
                    add(new ResponseBuilder().code("401").description("Unauthorized ( 인증되지 않았습니다 )").build());
                    add(new ResponseBuilder().code("403").description("Forbidden ( 접근 권한이 없습니다 ) ").build());
                    add(new ResponseBuilder().code("500").description("500 Server error ( 서버 에러 발생 )").build());
                }})
                .globalResponses(HttpMethod.POST,new ArrayList<Response>(){{
                    add(new ResponseBuilder().code("200").description("OK ( 요청 성공 )").build());
                    add(new ResponseBuilder().code("400").description("Bad Request ( 잘못된 요청입니다 )").build());
                    add(new ResponseBuilder().code("401").description("Unauthorized ( 인증되지 않았습니다 )").build());
                    add(new ResponseBuilder().code("403").description("Forbidden ( 접근 권한이 없습니다 ) ").build());
                    add(new ResponseBuilder().code("500").description("500 Server error ( 서버 에러 발생 )").build());
                }})

                .globalResponses(HttpMethod.PATCH,new ArrayList<Response>(){{
                    add(new ResponseBuilder().code("200").description("OK ( 요청 성공 )").build());
                    add(new ResponseBuilder().code("400").description("Bad Request ( 잘못된 요청입니다 )").build());
                    add(new ResponseBuilder().code("401").description("Unauthorized ( 인증되지 않았습니다 )").build());
                    add(new ResponseBuilder().code("403").description("Forbidden ( 접근 권한이 없습니다 ) ").build());
                    add(new ResponseBuilder().code("500").description("500 Server error ( 서버 에러 발생 )").build());
                }})
                .globalResponses(HttpMethod.DELETE,new ArrayList<Response>(){{
                    add(new ResponseBuilder().code("200").description("OK ( 요청 성공 )").build());
                    add(new ResponseBuilder().code("400").description("Bad Request ( 잘못된 요청입니다 )").build());
                    add(new ResponseBuilder().code("401").description("Unauthorized ( 인증되지 않았습니다 )").build());
                    add(new ResponseBuilder().code("403").description("Forbidden ( 접근 권한이 없습니다 ) ").build());
                    add(new ResponseBuilder().code("500").description("500 Server error ( 서버 에러 발생 )").build());
                }});
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("LONUA(쇼핑몰) API")
                .description("LONUA 쇼핑몰과 관련된 Swagger-UI 입니다.")
                .version("2.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("깃허브 주소", "https://github.com/beyond-sw-camp/be02-2nd-developer_passion-fashion", null))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", In.HEADER.toValue());
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
>>>>>>> develop
}
