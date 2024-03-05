package com.springsecurity.springsecurity.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("pass")
                .password(passwordEncoder().encode("abc"))
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(
                        c -> c.disable()
                )
                .authorizeHttpRequests(
                        requests -> requests
                                .requestMatchers("/api").permitAll().requestMatchers("/")
                                .anonymous()
                                .requestMatchers(
                                        "/",
                                        "/public/**",
                                        "/static/**",
                                        "/index.html",
                                        "/.jsx",
                                        "./.pages",
                                        "../.components",
                                        "../.src",
                                        "/app/**")

                                .permitAll()
                                .requestMatchers(HttpMethod.GET, "/api").authenticated()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(
                        form -> form.loginPage("/").permitAll()
                                .loginProcessingUrl("/registerpage")
                                .defaultSuccessUrl("/registerpage", true)
                                .failureUrl("/login?error")
                )
                .logout(
                        form -> form.invalidateHttpSession(true).clearAuthentication(true)
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login?logout")
                                .deleteCookies("JSESSIONID")
                                .permitAll()
                );

        return http.build();

    }
}
