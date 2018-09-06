package showtracker.example.com.showtracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import showtracker.example.com.showtracker.adapter.MoviesAdapter;
import showtracker.example.com.showtracker.model.TvMazeApiResponse;
import showtracker.example.com.showtracker.network.ShowTrackerApiService;

public class ShowTrackerActivity extends AppCompatActivity {

    private static final String TAG = ShowTrackerActivity.class.getSimpleName();
    public static final String BASE_URL = "http://api.tvmaze.com/";
    // actual url- http://api.tvmaze.com/shows
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tracker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        connectAndGetApiData();
    }

    // This method create an instance of Retrofit &  set the base url
    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ShowTrackerApiService movieApiService = retrofit.create(ShowTrackerApiService.class);

        Call<List<TvMazeApiResponse>> call = movieApiService.getShows();
        call.enqueue(new Callback<List<TvMazeApiResponse>>() {
            @Override
            public void onResponse(Call<List<TvMazeApiResponse>> call, Response<List<TvMazeApiResponse>> response) {
                List<TvMazeApiResponse> tvMazeApiResponses = response.body();
                response.body();
                recyclerView.setAdapter(new MoviesAdapter(tvMazeApiResponses, R.layout.list_item_movie, getApplicationContext()));
                Log.d(TAG, "Number of movie: " + tvMazeApiResponses.size());
            }

            @Override
            public void onFailure(Call<List<TvMazeApiResponse>> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
