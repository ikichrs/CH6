package com.binar.challenge4.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI bioskopOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Bioskop Open API")
                        .description("Open API Aplikasi Bioskop"));
    }
}
