package com.bezkoder.spring.swagger.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

  @Value("${bezkoder.openapi.dev-url}")
  private String devUrl;


  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");


    Contact contact = new Contact();
    contact.setEmail("mkc@gmail.com");
    contact.setName("BKL");
    contact.setUrl("https://www.google.com");

    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
        .title("Shivanshu's Tutorial")
        .version("heavy VErsion 2.3")
        .contact(contact)
        .description("Maje Maje Mein Bna Diya").termsOfService("https://www.google.com")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(devServer));
  }
}
