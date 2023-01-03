package uz.pdp.ucell_task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails user = User
                .withUsername("user")
                .passwordEncoder(s -> passwordEncoder().encode("ucell123"))
                .roles("USER")
                .build();

        UserDetails moder = User
                .withUsername("moder")
                .passwordEncoder(s -> passwordEncoder().encode("ucell123"))
                .roles("MODERATOR")
                .build();


        UserDetails admin = User
                .withUsername("admin")
                .passwordEncoder(s -> passwordEncoder().encode("ucell123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, moder, admin);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        userDetailsService();
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(auth ->
                        auth
                                .antMatchers("/auth/**")
                                .permitAll()
                                .antMatchers(HttpMethod.GET, "/publications/**")
                                .hasAnyRole("USER", "MODERATOR", "ADMIN")
                                .antMatchers(HttpMethod.POST, "/publications")
                                .hasAnyRole("MODERATOR", "ADMIN")
                                .antMatchers(HttpMethod.PUT, "/publications")
                                .hasAnyRole("MODERATOR", "ADMIN")
                                .antMatchers("/**")
                                .hasAnyRole("ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }
}
