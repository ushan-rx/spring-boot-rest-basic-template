package org.example.springbootresttemplate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

//    this is an interface,so we have to implement the userdetailsservice
//    then provide that class to the provider to do authentication
    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public AuthenticationProvider authProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
//        set password encoder (no encoder in this case)
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

//        set bycrypt as encoder
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        customize security filter chain using http security object
        http.csrf(customizer -> customizer.disable()).
                    authorizeHttpRequests(request -> request.anyRequest().authenticated()).
                    formLogin(Customizer.withDefaults()).
                    httpBasic(Customizer.withDefaults()).
                    sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

//    public UserDetailsService userDetailsService(){
//
//        UserDetails user = User
//                            .withUsername("ushan")
//                            .password("1234")
//                            .roles("USER")
//                            .build();
//
//        UserDetails admin = User
//                .withUsername("kushan")
//                .password("1234")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}


