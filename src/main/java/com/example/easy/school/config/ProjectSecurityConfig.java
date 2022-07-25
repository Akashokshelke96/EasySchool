package com.example.easy.school.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().ignoringAntMatchers("/saveMsg").ignoringAntMatchers("/public/**").and()
                .authorizeRequests()
                .mvcMatchers("/dashboard").authenticated()
                .mvcMatchers("/displayMessages").hasRole("ADMIN")
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/holidays/**").permitAll()
                .mvcMatchers("/contact").permitAll()
                .mvcMatchers("/saveMsg").permitAll()
                .mvcMatchers("/courses").permitAll()
                .mvcMatchers("/about").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/public/**").permitAll()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("54321").roles("ADMIN")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}