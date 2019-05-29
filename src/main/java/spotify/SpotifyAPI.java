package spotify;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpotifyAPI {
    String accessToken ="BQB-6hjcQd8d417oifEaMTIL5Mk6tZGtu2YpKdRLFUvb800NYv05qqDwIaBGTSvYVVb56mNxiaY8gNMMXRIPEwO5B2r1BlI7mC9fXqoYyP7raMu-Ln6cMG26RLqLWh6GWGxhuDc_cxQrGBNU2sKXEW08eYCCMNH4RgvOsc3wSZIzMJMAzDw";
    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessToken,
            })
    @GET("/v1/search?" )
    Observable<SpotifySearchResponse> getSpotifySearchResponse(@Query("q") String songtitle, @Query ("type")  String type);

    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessToken,
    })
    @GET("/v1/audio-features/{id}")
   Observable<Audio> getAudio(@Path("id") String songId);
}
