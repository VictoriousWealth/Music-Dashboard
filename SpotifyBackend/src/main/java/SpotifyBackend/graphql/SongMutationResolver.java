package SpotifyBackend.graphql;

import SpotifyBackend.model.Album;
import SpotifyBackend.model.Artist;
import SpotifyBackend.model.Song;
import SpotifyBackend.repository.AlbumRepository;
import SpotifyBackend.repository.ArtistRepository;
import SpotifyBackend.repository.SongRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SongMutationResolver {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public SongMutationResolver(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @MutationMapping
    public Song createSong(@Argument String title,
                           @Argument Long artistId,
                           @Argument Long albumId,
                           @Argument String genre,
                           @Argument int durationInSeconds) {

        Optional<Artist> artist = artistRepository.findById(artistId);
        Optional<Album> album = albumRepository.findById(albumId);

        if (artist.isEmpty() || album.isEmpty()) {
            throw new IllegalArgumentException("Invalid artist or album ID");
        }

        Song song = new Song();
        song.setTitle(title);
        song.setArtist(artist.get());
        song.setAlbum(album.get());
        song.setGenre(genre);
        song.setDurationInSeconds(durationInSeconds);
        
        return songRepository.save(song);
    }
}
