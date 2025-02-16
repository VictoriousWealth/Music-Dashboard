package SpotifyBackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "playback_history")
@ToString @EqualsAndHashCode @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
public class PlaybackHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(nullable = false)
    private LocalDateTime playedAt;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Song getSong() {
        return song;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlayedAt(LocalDateTime playedAt) {
        this.playedAt = playedAt;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
