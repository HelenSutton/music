package spotify;


import com.google.gson.Gson;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public interface SpotifyAPI {
    String accessTocken1 ="BQBDAKArqEnyuGp7UzUNDe7HWsyG_fIZOES52db3dpGYn6BSRwXQ6wmj__DNzatNYjrcL9hVDI3VxpBSVrjO_ShR7qMfSNWO2rVp058yiIO91yEfMq4mN944qbpOcgCEnCNt3sQAuMeAyInNXNG2uM2xhDxsgjrkzvpn7_8CYjrr_D_F4gA";
    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessTocken1,
            })
    @GET("/v1/search?" )
    Observable<SpotifySearchResponse> getSpotifySearchResponse(@Query("q") String songtitle, @Query ("type")  String type);

    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessTocken1,
    })
    @GET("/v1/audio-features/{id}")
   Observable<Audio> getAudio(@Path("id") String songId);


}
