package com.java_backend.Finance_Tracker_Java_Springboot.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // Basic OpenAPI configuration
    @Bean
    public OpenAPI personalFinanceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Personal Finance Tracker API")
                        .description("API for tracking income, expenses, and savings")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository")
                        .url("https://github.com/your-repo"));
    }
}

