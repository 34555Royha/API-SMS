package com.sms.demo.Configuration.API;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.*;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api(){
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        securitySchemes.add(new BasicAuth("BasicAuth"));
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.sms.demo.RestController"))
                    .paths(PathSelectors.any())
                    // .paths(PathSelectors.ant("/api/v1/**"))
                    .build()
                    .securitySchemes(securitySchemes)
                    .apiInfo(apiInfo());
                    
    }
    private ApiInfo apiInfo(){
        List<VendorExtension> vendorExtensions = new ArrayList<>();
        Contact contact = new springfox.documentation.service.Contact("Tem Chhannat", "", "yanrithy1235@gmail.com");
        
        ApiInfo apiInformatioon = new ApiInfo("Developer: Mr.Rithy", "Hanchey Resort Api Documentation", "Versoin 1.swagger-ui.swagger-ui", "Term of Service",
         contact, "License: Copy Righted", "http://www.hanchey", vendorExtensions);

         return apiInformatioon;
    }
}
