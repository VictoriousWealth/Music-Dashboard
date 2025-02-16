package SpotifyBackend.graphql;

import SpotifyBackend.model.Playlist;
import SpotifyBackend.repository.PlaylistRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PlaylistGraphQLResolver {
    private final PlaylistRepository playlistRepository;

    public PlaylistGraphQLResolver(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @QueryMapping public Optional<Playlist> getPlaylist(@Argument Long id) {

        return playlistRepository.findById(id);
    }

    @QueryMapping public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }
}
