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

public interface JsonAPI {
    String accessTocken1 ="BQDg1zSpswBd4V1vsv5DWA_NPBFvnLfEhXSHDOJLrAFFXpDHaRCIG5wTB1ktT2RstCdbGrveCpI0-yW1DTqDj9Pz3CfEA7y-joShrCQ8PtJ5lbs5S0Rpce8voR7hYKRwDB4dCn6q2sfsnLH1IjXBNRNAOX_wF8uvswJyw9pZKxwBu4SB5_4";
    String accessTocken2 = "BQCpZBsOf6xLXsrE-f3wLFA4zTZqVWpyQCdbFsq8LUn2XsaK-zMeI2mDk4lj0dupnHzX9u4L_13OfsIU93iqIzFlWNDm-xsumGQfu7vj3O1Fe_yfKUqtUirBoB7fLLGd4dhlHiiS2AxS07MSDEtXaqtAfYj8quQdeRc0X3b3Bs-8GcgPghI";
    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessTocken1,

            })
    @GET("/v1/search?" )
    Observable<SpotifySearchResponse> getSpotifySearchResponse(@Query("q") String songtitle, @Query ("type")  String type);

    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + accessTocken2,

    })
    @GET("/v1/audio-features/{id}")
   Observable<Audio> getAudio(@Path("id") String songId);


}
