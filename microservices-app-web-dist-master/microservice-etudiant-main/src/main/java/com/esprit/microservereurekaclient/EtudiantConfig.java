package com.esprit.microservereurekaclient;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class EtudiantConfig implements WebMvcConfigurer {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for multiple endpoints
        registry.addMapping("/update")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("OPTIONS", "PUT")
                .allowCredentials(true);

        // Add more mappings if needed
        registry.addMapping("/another-endpoint")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST")
                .allowCredentials(true);
    }
}
