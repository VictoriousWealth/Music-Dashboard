package SpotifyBackend.graphql;

import SpotifyBackend.model.User;
import SpotifyBackend.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutationResolver {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserMutationResolver(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @MutationMapping
    public User createUser(@Argument String username,
                           @Argument String email,
                           @Argument String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
}
