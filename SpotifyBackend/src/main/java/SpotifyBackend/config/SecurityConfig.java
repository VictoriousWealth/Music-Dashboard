package SpotifyBackend.config;

import SpotifyBackend.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = authenticationManager();

        http
                // header writing on responses
                .headers(headers -> headers
                                .frameOptions(frame -> frame.deny())  // Prevent Clickjacking
                                .xssProtection(xss -> xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK))  // Prevent XSS attacks
                                .contentTypeOptions(withDefaults())  // Prevent MIME sniffing (file that's a .jpeg, but hacker tricks the browser to run as a .jscript)
//                                .contentSecurityPolicy(csp -> csp.policyDirectives(
//                                        "script-src 'self'; " +
//                                                "connect-src 'self' http://localhost:8080/graphql ws://localhost:8080/graphql"
//                                ))
                                .httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true).maxAgeInSeconds(31536000))  // Force HTTPS
                )

                // resource access management
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/graphql/**", "/graphiql/**").permitAll()  // Allow GraphQL queries
                        .requestMatchers("/api/**").permitAll() // Allow all api call endpoints
                        .requestMatchers("/login").permitAll() // Allow all api call endpoints
                        .requestMatchers("/logout").permitAll() // Allow all api call endpoints
                        .anyRequest().authenticated())

                // since its api we will disable csrf token (used to prevent csrf attacks) as it is not needed and rely on other methods such as JWT, OAuth
                .csrf(csrf -> csrf.disable())  // Disable CSRF for GraphQL APIs
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // logout logistics
                .logout(logout -> logout
                        .logoutUrl("/api/logout")
                        .logoutSuccessHandler(
                                (request, response, authentication) -> {
                                    response.setStatus(HttpServletResponse.SC_OK);
                                    response.getWriter().write("{\"message\": \"Successfully logged out\"}");
                                    response.getWriter().flush();
                                })
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")



                )
                .formLogin(withDefaults())
//                .formLogin(login -> login
//                        .loginProcessingUrl("/login")
//                        .usernameParameter("username")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/login?error=true")
//                        .loginPage("/login")
//                )
                // TODO to add CustomJWTFilter before CustomUsernameAndPasswordAuthenticationFilter
                .addFilterBefore(new CustomUsernameAndPasswordAuthenticationFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)


        ;

        return http.build();
    }

    // it returns an authenticated user object if successful via delegating authentication of a user to one or more authentication providers, which actually do the processes
    // it looks for the first in order that successfully authenticates the user credentials and then stops
    // if no provider authenticates the request then it throws an exception
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(List.of(new CustomUsernameAndPasswordAuthenticationProvider(passwordEncoder(), userRepository)));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
