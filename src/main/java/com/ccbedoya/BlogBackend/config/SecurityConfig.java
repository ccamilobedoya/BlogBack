package com.ccbedoya.BlogBackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment env;

    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(env.getProperty("credentials.user.user")).password(encoder.encode(env.getProperty("credentials.user.pass"))).roles("USER")
                .and()
                .withUser(env.getProperty("credentials.admin.user")).password(encoder.encode(env.getProperty("credentials.admin.pass"))).roles("ADMIN","USER");
    }

    protected void configure (HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
                .antMatchers("/swagger**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/post/like").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/**").hasRole("USER")
                .anyRequest().hasRole("ADMIN")
                .and().httpBasic()
                .and().csrf().disable();
    }
}
