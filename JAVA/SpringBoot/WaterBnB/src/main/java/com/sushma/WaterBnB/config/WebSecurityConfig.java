package com.sushma.WaterBnB.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
            authorizeRequests()
                .antMatchers("/static/**", "/home", "/registration", "/search", "/pools/*", "/get").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/guest/signin")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}
