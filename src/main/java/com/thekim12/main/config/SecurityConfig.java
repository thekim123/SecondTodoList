package com.thekim12.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.thekim12.main.model.user.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
public class SecurityConfig{
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf().disable()
				.authorizeHttpRequests(authorize->authorize.antMatchers("/list/**")
						.authenticated()
						.anyRequest().permitAll())
				.formLogin()
				.loginPage("/auth/login")
				.loginProcessingUrl("/auth/login")
				.defaultSuccessUrl("/")
			.and()
				.build();
	}
}