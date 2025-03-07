package SpotifyBackend.repository;

import SpotifyBackend.model.Album;
import SpotifyBackend.model.Playlist;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByArtistName(String artistName);
    @NotNull List<Album> findAll();
}
