package SpotifyBackend;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
