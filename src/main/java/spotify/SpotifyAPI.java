package spotify;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpotifyAPI {
    String accessToken ="BQCYRmYXRUTTs5PwRzvA2hvtdEHuX7RYTxLFui2FcbzM1qPyq0bKoRK4yDsOuvF_hKtln-cQW4U3HwKGJErQNF88ydkNu42tYey9lu82K-xLSBiVuP8Mc3gb0tbTi_XePN-AmYWcuxOFTl5ExCxQ3r001F0gcx8-Wlcg19skcWrIc3vTotI";
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
