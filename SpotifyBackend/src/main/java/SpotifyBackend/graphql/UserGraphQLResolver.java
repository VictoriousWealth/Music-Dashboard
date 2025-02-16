package SpotifyBackend.graphql;

import SpotifyBackend.model.User;
import SpotifyBackend.repository.UserRepository;
import lombok.NonNull;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserGraphQLResolver {
    private final UserRepository userRepository;

    public UserGraphQLResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public Optional<User> getUser(@Argument @NonNull Long id) {
        return userRepository.findById(id);
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
