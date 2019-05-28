package spotify;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonClient {
    private final JsonAPI api;
    public JsonClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
       api = retrofit.create(JsonAPI.class);
    }
    Observable<SpotifySearchResponse> getSpotifySearchResponse(String songtitle){
        return api.getSpotifySearchResponse(songtitle, "track");
    }}
