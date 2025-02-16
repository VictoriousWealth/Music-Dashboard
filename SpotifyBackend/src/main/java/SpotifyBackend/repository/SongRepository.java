package SpotifyBackend.repository;

import SpotifyBackend.model.Song;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByGenre(String genre);
    List<Song> findByArtistName(String artistName);
    List<Song> findByAlbumName(String albumName);
    @NotNull List<Song> findAll();
}
