package com.rivers.user.config;

import com.rivers.core.oath.common.AuthExceptionEntryPoint;
import com.rivers.core.oath.common.CustomAccessDeniedHandler;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author riversking
 */
@Configuration
@EnableResourceServer
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Aspect
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/actuator/**", "/user/login","/user/info").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }

    /**
     * why add  resourceId
     * <p>
     * https://stackoverflow.com/questions/28703847/how-do-you-set-a-resource-id-for-a-token
     *
     * @param resources resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(new AuthExceptionEntryPoint())
                .accessDeniedHandler(new CustomAccessDeniedHandler());
    }
}