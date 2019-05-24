package spotify;


import com.google.gson.Gson;
import io.reactivex.Observable;
import retrofit2.Call;
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

public interface JsonAPI {
    String accessTocken ="BQDFvYhpFcpHohuyTpdQoAV__9zNxTfRmae24ZLUng-I-HC3t87ZrdhyHUfOloNgv_hWIhyBG2p_8VjGt02p0u_J_vmwfOkzG-ywaiJTC43Z08i8m12viXsl4fCio4cYAoyO2_8V_ufCuiQOrpI-vqqqS3H9aIsXWwhEcHwWZgbvuWNocvg";
    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessTocken,

            })
    @GET ("/v1/search?type=track" )
    Observable<TracksList> getTracksList(@Query("q") String songtitle);

//    @GET("audio-features/"id)
//    Observable<AudioList> getAudioList();


}
