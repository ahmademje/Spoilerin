package com.example.spoilerin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListReviewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ReviewModel> reviews = new ArrayList<>();
    FloatingActionButton btn_addReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_review);

        recyclerView = findViewById(R.id.recyclerView);

        requestReview(getIntent().getStringExtra("idFilm"));

        ReviewAdapter reviewAdapter = new ReviewAdapter(this, reviews);
        recyclerView.setAdapter(reviewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btn_addReview = findViewById(R.id.btn_addReview);
        btn_addReview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListReviewActivity.this, AddCommentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void requestReview(String idFilm){
        final JSONArray[] reviewsArrray = {new JSONArray()};
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/" + idFilm + "/reviews?api_key=ae7dc40dc9096675acf09b3705a4f05c&language=en-US&page=1")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("cek", "got review");
                        try {
                            reviewsArrray[0] = response.getJSONArray("results");
                            for(int i=0; i<4; ++i) {
                                ReviewModel review = new ReviewModel();
                                review.setAuthor(reviewsArrray[0].getJSONObject(i).getString("author"));
                                review.setContent(reviewsArrray[0].getJSONObject(i).getString("content"));
                                reviews.add(review);
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
                        Log.d("cek", "failed got a Review");
                    }
                });
    }
}