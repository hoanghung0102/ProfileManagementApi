package com.hoanghung.profilemanage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by hxhung on 8/24/2017.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Authentication : User --> Roles
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hoanghung").password("123456!A").roles("USER")
                .and()
                .withUser("admin").password("123456!A").roles("USER", "ADMIN");
    }

    // Authorization: Role --> Access
    protected void configure(HttpSecurity httpSercury) throws Exception {
        httpSercury.httpBasic().and().authorizeRequests()
                .antMatchers("/profile-management/**").hasRole("USER")
                .antMatchers("/**").hasRole("ADMIN")
                .and()
                .csrf().disable().headers().frameOptions().disable(); // disable for customize error page auto to HTTP 403
    }
}
