package com.example.spoilerin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class ListMovieActivity extends AppCompatActivity {
    ArrayList<MovieModel> moviesList = new ArrayList<>();
    RecyclerView recyclerView;
    private String API_URL = "https://api.themoviedb.org/3/movie/popular?api_key=ae7dc40dc9096675acf09b3705a4f05c&language=en-US&page=1";

    static Integer[] drawaleArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_list_movie);
        AndroidNetworking.initialize(getApplicationContext());

        recyclerView = (RecyclerView) findViewById(R.id.rv_listMoives);
        getData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        MovieAdapter adapter = new MovieAdapter(getApplicationContext(), moviesList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int itemPosition) {
                MovieModel movie = moviesList.get(itemPosition);
                Intent intent =  new Intent(ListMovieActivity.this, MovieDetailActivity.class);
                intent.putExtra("movie", (Serializable) movie);
                startActivity(intent);
                Toast.makeText(ListMovieActivity.this, "Tittle dipilih = " + movie.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        final JSONArray[] movies = {new JSONArray()};
        AndroidNetworking.get(API_URL)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            movies[0] = response.getJSONArray("results");
                            for(int i=0; i<4; ++i) {
                                MovieModel movie = new MovieModel();
                                movie.setId(movies[0].getJSONObject(i).getString("id"));
                                movie.setTitle(movies[0].getJSONObject(i).getString("title"));
                                movie.setOverview(movies[0].getJSONObject(i).getString("overview"));
                                movie.setPosterPath(movies[0].getJSONObject(i).getString("poster_path"));
                                moviesList.add(movie);
                            }
                            //movies = response.getJSONArray("results");
                        } catch (JSONException e) {
                            Log.d("cek", "Exception = " + e.getMessage());
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("cek", anError.getErrorDetail());
                        Log.d("cek", String.valueOf(anError.getErrorCode()));
                        Log.d("cek", anError.getResponse().message().toString());
                    }
                });
    }

}