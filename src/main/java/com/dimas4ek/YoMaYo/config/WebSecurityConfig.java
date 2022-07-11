package com.dimas4ek.YoMaYo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //включение авторизации
                .authorizeRequests()
                    .antMatchers("/").permitAll() //полный доступ для главного пути
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

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        //создание в памяти менеджера, который обслуживает учетную запись
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("u")
                        .password("1")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}
