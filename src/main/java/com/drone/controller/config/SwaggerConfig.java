package com.drone.controller.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@Data
public class SwaggerConfig {


 @Bean
 public Docket api() {
  return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.drone.controller"))
      .paths(PathSelectors.any())
      .build()
      .directModelSubstitute(LocalDate.class, java.util.Date.class)
      .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
      .apiInfo(apiInfo());
 }

 private ApiInfo apiInfo() {
  return new ApiInfoBuilder()
      .title("Drones APIs")
      .description("Drones APIs description")
      .version("1.0.0")
      .contact(new Contact("Aya Yasser Esmail", null, "aya_yasser_h@hotmail.com"))
      .build();
 }
}
