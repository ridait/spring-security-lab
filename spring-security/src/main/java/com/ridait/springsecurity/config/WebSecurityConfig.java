package com.ridait.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsManager userDetailsManager(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails ridait = User.withUsername("ridait")
                .password("123456")
                .authorities("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("nimda")
                .authorities("ADMIN")
                .build();
        manager.createUser(ridait);
        manager.createUser(admin);
        return manager;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .defaultSuccessUrl("/secret");
        http.authorizeRequests().mvcMatchers("/admin").access("hasAuthority('ADMIN')");
        http.authorizeRequests().mvcMatchers("/user").access("hasAuthority('USER')");
        http.authorizeRequests().mvcMatchers("/main").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
