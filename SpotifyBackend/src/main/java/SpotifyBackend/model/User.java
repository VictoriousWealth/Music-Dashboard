package SpotifyBackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> playlists;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaybackHistory> playbackHistory;

    public String getPassword() {
        return password;
    }

    public List<PlaybackHistory> getPlaybackHistory() {
        return playbackHistory;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void setPlaybackHistory(List<PlaybackHistory> playbackHistory) {
        this.playbackHistory = playbackHistory;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
