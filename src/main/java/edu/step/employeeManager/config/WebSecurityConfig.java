package edu.step.employeeManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // TODO: Implementarea unui filtru care primeste cererea HTTP, extrage tokenul si valideaza
    // daca utilizatorul exista - OK
    // TODO: de creat un serviciu, capabil sa incarce informatia despre utilizator
    // class JwtUserDetailsService implements UserDetailsService {
    // TODO: de creat o clasa capabila sa proceseze exceptiile
    // daca nu exista - aruncam exceptie si nu permitem trecerea
    // TODO: de configurat rolurile utilizatorilor care au dreptul la anumite operatii


    // Ce are spring: User, UserDetail, Role

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.csrf().disable()
               .authorizeRequests().antMatchers("/**").permitAll()
               .anyRequest().authenticated()
               .and()
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // authenticate
    }
}
