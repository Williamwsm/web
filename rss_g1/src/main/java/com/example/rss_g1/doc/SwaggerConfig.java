package com.example.rss_g1.doc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.rss_g1.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }
    private ApiInfo buildApiInfo(){
        return  new ApiInfoBuilder()
                .title("API Person")
                .description("REST API Person para gerenciamento de pessoas")
                .version("1.0.0")
                .contact(new Contact("Will","https://github.com/Williamwsm/web/tree/main/rss_g1/src/main/java/com/example/rss_g1", null))
                .build();

    }
}
