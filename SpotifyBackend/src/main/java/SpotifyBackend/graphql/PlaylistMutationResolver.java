package SpotifyBackend.graphql;


import SpotifyBackend.model.Playlist;
import SpotifyBackend.model.User;
import SpotifyBackend.repository.PlaylistRepository;
import SpotifyBackend.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PlaylistMutationResolver {
    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;

    public PlaylistMutationResolver(PlaylistRepository playlistRepository, UserRepository userRepository) {
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
    }

    @MutationMapping
    public Playlist createPlaylist(@Argument Long userId,
                                   @Argument String name) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User ID not found");
        }

        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setUser(user.get());

        return playlistRepository.save(playlist);
    }
}
