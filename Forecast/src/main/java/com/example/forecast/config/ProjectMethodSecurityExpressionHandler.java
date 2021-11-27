package com.example.forecast.config;

import com.example.forecast.services.ForecastService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class ProjectMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    private final ForecastService forecastService;

    public ProjectMethodSecurityExpressionHandler(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        OwnerSecurityExpressionRoot root = new OwnerSecurityExpressionRoot(authentication);

        root.setForecastService(forecastService);
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(new AuthenticationTrustResolverImpl());
        root.setRoleHierarchy(getRoleHierarchy());

        return root;
    }
}
