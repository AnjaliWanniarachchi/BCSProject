package com.bcs.project.stpauls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static com.bcs.project.stpauls.constants.Constants.FRONT_END_URL;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin(FRONT_END_URL); // Allow your Angular app's origin
        config.addAllowedHeader("*");                    // Allow all headers
        config.addAllowedMethod("*");                    // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
        config.setAllowCredentials(true);                // Allow credentials (e.g., cookies, Authorization header)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Apply configuration to all endpoints
        System.out.println("CORS Filter initialized with allowed origin:" + FRONT_END_URL);
        return new CorsFilter(source);
    }
}
