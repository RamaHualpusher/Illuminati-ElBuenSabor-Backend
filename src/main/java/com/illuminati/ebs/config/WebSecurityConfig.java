package com.illuminati.ebs.config;

import com.illuminati.ebs.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.function.Supplier;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UsuarioService usuarioService;

    @Bean
    public UserDetailsService userDetailsService() {
        return (UserDetailsService) usuarioService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .authorize(new AntPathRequestMatcher("/admin/**"), hasAuthority("ADMIN"))
                                .authorize(new AntPathRequestMatcher("/cajero/**"), hasAuthority("CAJERO"))
                                .authorize(new AntPathRequestMatcher("/cocinero/**"), hasAuthority("COCINERO"))
                                .authorize(new AntPathRequestMatcher("/delivery/**"), hasAuthority("DELIVERY"))
                                .authorize(new AntPathRequestMatcher("/cliente/**"), hasAuthority("CLIENTE"))
                                .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .csrf().disable();
    }

    private AuthorizationManager<HttpServletRequest> hasAuthority(String authority) {
        return (authentication, request) ->
                authentication.filter(a -> a.getAuthorities().stream()
                                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority)))
                        .map(AuthorizationDecision::new)
                        .orElseGet(() -> new AuthorizationDecision(false));
    }
}
