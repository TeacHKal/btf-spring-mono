package com.teachkal.btf.spring.mono.auth.security;

import com.teachkal.btf.spring.mono.auth.jwt.JwtConfig;
import com.teachkal.btf.spring.mono.auth.jwt.JwtTokenVerifier;
import com.teachkal.btf.spring.mono.auth.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.teachkal.btf.spring.mono.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AppUserService appUserService;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder, AppUserService appUserService, JwtConfig jwtConfig, SecretKey secretKey) {
        this.passwordEncoder = passwordEncoder;
        this.appUserService = appUserService;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated();

        //  # Bottom commented antMatchers are there just for a reference,
        //  # I like more annotating controllers, since it look more clearly
        //.antMatchers("example/api/*").hasRole(ADMIN.name())
        //.antMatchers(HttpMethod.PUT, "example/api/*").hasAnyRole(ADMIN.name(), MODERATOR.name())
        //.antMatchers(HttpMethod.PUT, "example/api/*").hasAnyAuthority(AppUserPermission.ORDER_UPDATE.name())
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService((UserDetailsService) appUserService);
        System.out.println("TTTTTTTTTTTTTTT");
        return provider;
    }

}
