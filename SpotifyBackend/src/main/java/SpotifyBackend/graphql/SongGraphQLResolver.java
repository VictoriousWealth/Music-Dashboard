package SpotifyBackend.graphql;

import SpotifyBackend.model.Song;
import SpotifyBackend.repository.SongRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class SongGraphQLResolver {
    private final SongRepository songRepository;

    public SongGraphQLResolver(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @QueryMapping
    public Optional<Song> getSong(@Argument @NotNull Long id) {
        return songRepository.findById(id);
    }

    @QueryMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}
