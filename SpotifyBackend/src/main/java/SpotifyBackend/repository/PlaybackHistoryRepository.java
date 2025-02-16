package SpotifyBackend.repository;

import SpotifyBackend.model.PlaybackHistory;
import SpotifyBackend.model.Playlist;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlaybackHistoryRepository extends JpaRepository<PlaybackHistory, Long> {
    List<PlaybackHistory> findByUserId(Long userId);
    @NotNull List<PlaybackHistory> findAll();
}
