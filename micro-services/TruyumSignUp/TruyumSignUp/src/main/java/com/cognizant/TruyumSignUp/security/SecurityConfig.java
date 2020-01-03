package com.cognizant.TruyumSignUp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
		 * .and()
		 * .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
		 */
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        //LOGGER.info("Start");
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity.cors();
        httpSecurity.csrf().disable().httpBasic().and()
        	.sessionManagement()
        	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        	.and()
            .authorizeRequests()
			//.antMatchers("/authentication-service/tryum/authenticate").anonymous()
			.antMatchers("/signup-service/tryum/users").permitAll();
				 
        	
            
    }
    
    
}
