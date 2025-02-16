package SpotifyBackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "songs")
@ToString @EqualsAndHashCode @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private int durationInSeconds;

    public Long getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
