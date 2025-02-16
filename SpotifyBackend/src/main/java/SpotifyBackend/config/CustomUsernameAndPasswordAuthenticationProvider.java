package SpotifyBackend.config;

import SpotifyBackend.model.User;
import SpotifyBackend.repository.UserRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class CustomUsernameAndPasswordAuthenticationProvider implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public CustomUsernameAndPasswordAuthenticationProvider(
             PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        if (userRepository.findByUsername(username).isEmpty()) {
            System.out.println("User with username " + username + " not found");
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }

        User user = userRepository.findByUsername(username).get();

        // Verify password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.printf("User with username <%s> attempted to sign in with invalid password <%s>", username, password);
            throw new RuntimeException("Invalid credentials");
        }

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword()) //TODO encode passwords in the database and updates code as such
                .roles("USER")
                .build();

        // Create an authenticated token
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}