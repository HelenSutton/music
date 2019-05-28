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
    String accessTocken ="BQCvDLi_LJRME89BP-Dh84OUjWzSMIymmbP5dVWmsthyUOxtTR0K3LjJEh43yO-y1t8VIYZgu4e_AqCSWAo1O2yZMJMupCqlispfKDgjyTCj5g-i4SreESbp2bTVtYZ_1YDe1I4eX43GTgqcU7ZZjXbxIGtBN3zypMaxxfM62Zb9fXs5Qsg";
    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessTocken,

            })
    @GET("/v1/search?" )
    Observable<SpotifySearchResponse> getSpotifySearchResponse(@Query("q") String songtitle, @Query ("type")  String type);

//    @GET("audio-features/"id)
//    Observable<AudioList> getAudioList();


}
