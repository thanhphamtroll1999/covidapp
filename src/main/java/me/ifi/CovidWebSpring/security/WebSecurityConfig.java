package me.ifi.CovidWebSpring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    //Ma hoa password
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService) // cung cap userservice cho security
                .passwordEncoder(passwordEncoder());  //cung cap password encoder
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
                .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                .and()
                .formLogin() // Cho phép người dùng xác thực bằng form login
                .defaultSuccessUrl("/patients")
                .permitAll() // Tất cả đều được truy cập vào địa chỉ này
                .and()
                .logout() // Cho phép logout
                .permitAll();

    }
}
