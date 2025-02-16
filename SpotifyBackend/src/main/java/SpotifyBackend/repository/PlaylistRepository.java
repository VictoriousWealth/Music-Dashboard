package SpotifyBackend.repository;

import SpotifyBackend.model.Playlist;
import jakarta.annotation.Nonnull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByUserId(Long userId);
    @NotNull List<Playlist> findAll();
}
