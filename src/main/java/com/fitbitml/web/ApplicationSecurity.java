package com.fitbitml.web;


import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableOAuth2Sso
/*
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "https://api.fitbit.com/oauth2/token/", "https://api.fitbit.com/oauth2/token/*", "/callback", "/auth", "/webjars/**", "/error**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

}
*/