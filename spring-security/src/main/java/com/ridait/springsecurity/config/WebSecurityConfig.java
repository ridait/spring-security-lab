package com.ridait.springsecurity.config;

import com.ridait.springsecurity.security.MyInMemoryUserDetailsManager;
import com.ridait.springsecurity.security.PlainTextPasswordEncoder;
import com.ridait.springsecurity.security.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PlainTextPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(){
        MyInMemoryUserDetailsManager manager = new MyInMemoryUserDetailsManager();
        manager.createUser(new User("ridait","123456"));
        return manager;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().antMatchers("/secret").authenticated();
        http.authorizeRequests().anyRequest().permitAll();
    }
}
