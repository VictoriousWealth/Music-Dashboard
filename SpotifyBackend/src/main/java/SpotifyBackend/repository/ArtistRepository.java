package SpotifyBackend.repository;

import SpotifyBackend.model.Artist;
import SpotifyBackend.model.Playlist;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByName(String name);
    @NotNull List<Artist> findAll();

}
