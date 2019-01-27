package com.example.shortcoursebms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class SwaggerConfig {


    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors
//                        .basePackage("com.example.shortcoursebms.controllers.restcontrollers"))

                        .any())
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {

        Collection<VendorExtension> vendorExtensions = new ArrayList<>();
        Contact contact = new Contact("My Name", "My URL", "My Email");
        return new ApiInfo(

                "String title",
                "String description",
                "String version",
                "String termsOfServiceUrl",
                contact,
                "String license",
                "String licenseUrl",
                vendorExtensions
        );
    }

}
