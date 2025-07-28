package com.app.todoapp.apiDocumentation;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    //General info
    @Bean
    public OpenAPI customConfig(){
        return new OpenAPI().info(new Info()
                                  .title("To-Do WebApp API")
                                  .version("1.0")
                                  .description("Spring Boot To-Do backend with Swagger-UI & OpenAPI 3")
                                  .contact(new Contact()
                                    .name("Ankit Kumar")
                                    .url("www.linkedin.com/in/ankit-kumar-b52324246")
                                    .email("akbagheltdl@gmail.com")));

    }

    //Grouped API for task endpoints
 /*    @Bean
    public GroupedOpenApi taskApiGroup(){
        return GroupedOpenApi.builder()
            .group("Task APIs")
            .packagesToScan("com.app.todo")
            .pathsToMatch("/tasks/api/**")
            .build();
    }  */

    //Grouped API for public (all other endpoints, optional)
    @Bean
    public GroupedOpenApi publicApiGroup(){
        return GroupedOpenApi.builder()
            .group("Public APIs")
            .pathsToMatch("/tasks/api/**")
            .build();
    }
}
