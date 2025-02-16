package SpotifyBackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "albums")
@ToString @EqualsAndHashCode @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;

    public Long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
