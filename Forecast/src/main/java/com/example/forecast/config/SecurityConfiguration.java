package com.example.forecast.config;

import com.example.forecast.services.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Autowired
    private ProjectMethodSecurityExpressionHandler projectMethodSecurityExpressionHandler;

    @Bean
    public ProjectMethodSecurityExpressionHandler createExpressionHandler(ForecastService forecastService) {
        return new ProjectMethodSecurityExpressionHandler(forecastService);
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return projectMethodSecurityExpressionHandler;
    }

}
