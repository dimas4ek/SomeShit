package com.dimas4ek.YoMaYo.config;

import com.dimas4ek.YoMaYo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //включение авторизации
                .authorizeRequests()
                    .antMatchers("/", "/registration", "/static/**").permitAll() //полный доступ для главного пути
                    .anyRequest().authenticated() //для остальных - авторизация
                    .and()
                //включение логина
                .formLogin()
                    .loginPage("/login")
                    .permitAll() //все могут логиниться
                    .and()
                //включение выхода
                .logout()
                    .permitAll(); //все могу выходить
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

}
