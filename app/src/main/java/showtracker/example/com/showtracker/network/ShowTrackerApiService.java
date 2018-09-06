package showtracker.example.com.showtracker.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import showtracker.example.com.showtracker.model.TvMazeApiResponse;

/**
 * Created by deepak.mandhani on 26/03/18.
 */

public interface ShowTrackerApiService {

    @GET("shows")
    Call<List<TvMazeApiResponse>> getShows();
}
