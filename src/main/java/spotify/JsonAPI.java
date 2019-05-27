package spotify;


import com.google.gson.Gson;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public interface JsonAPI {
    String accessTocken ="BQCwc_cWND55UDFlX0jEqT4UrEixyhhXhJbUjDRq_jz4Xpv__Faud";
    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessTocken,

            })
    @GET("/v1/search?type=track" )
    Observable<SpotifySearchResponse> getSpotifySearchResponse(@Query("q") String songtitle);

//    @GET("audio-features/"id)
//    Observable<AudioList> getAudioList();


}
