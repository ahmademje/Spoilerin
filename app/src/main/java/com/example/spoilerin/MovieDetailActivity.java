package com.example.spoilerin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity  extends AppCompatActivity {
    ImageView iv_gambarFilm;
    TextView tv_judulFilm, tv_detailFilm;
    MovieModel movie;
    Button btmReview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        iv_gambarFilm = findViewById(R.id.iv_detailActivity_gambarFilm);
        tv_judulFilm = findViewById(R.id.tv_detailActivity_judulFilm);
        tv_detailFilm = findViewById(R.id.tv_detailActivity_detailFilm);
        btmReview = findViewById(R.id.btn_detailActivity_review);

        movie = (MovieModel) getIntent().getSerializableExtra("movie");

        tv_judulFilm.setText(movie.getTitle());
        tv_detailFilm.setText(movie.getOverview());
        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/original" + movie.getPosterPath())
                .into(iv_gambarFilm);

        btmReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToReviewFilmbyId(movie.getId());
            }
        });
    }

    private void redirectToReviewFilmbyId(String idFilm){
        Intent intent = new Intent(MovieDetailActivity.this, ListReviewActivity.class);
        intent.putExtra("idFilm", idFilm);
        startActivity(intent);
    }
}
