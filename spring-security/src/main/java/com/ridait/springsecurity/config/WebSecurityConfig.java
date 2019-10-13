package com.ridait.springsecurity.config;

import com.ridait.springsecurity.security.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        /**
        ----------- In Memory UserDetailsManager -------------
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

        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        return manager;
    }
     **/

    @Bean
    public UserDetailsService userDetailsService(){
        JpaUserDetailsService service = new JpaUserDetailsService();
        return service;
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
