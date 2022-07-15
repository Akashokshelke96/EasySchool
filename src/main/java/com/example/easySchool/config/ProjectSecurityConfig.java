package com.example.easySchool.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Configuration;
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

    private boolean invalidateHttpSession = true;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/login").permitAll()
//                .antMatchers("/contact/**", "/holidays/**").hasAuthority("Admin");
//        http.authorizeRequests().anyRequest().permitAll()
//                .and().formLogin()
//                .and().httpBasic();

        http.csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/dashboard").authenticated()
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/holidays/**").permitAll()
                .mvcMatchers("/contact").authenticated()
                .mvcMatchers("/courses").authenticated()
                .mvcMatchers("/about").permitAll()
                .mvcMatchers("/login").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{//configuring multiple user and password using :inMemoryAuthentication
        auth.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("54321").roles("USER","ADMIN")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());

    }


}
