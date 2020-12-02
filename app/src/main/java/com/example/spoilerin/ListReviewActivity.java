package com.example.spoilerin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListReviewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String users[], reviews[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_review);

        recyclerView = findViewById(R.id.recyclerView);

        users = getResources().getStringArray(R.array.users);
        reviews = getResources().getStringArray(R.array.review);

        ReviewAdapter reviewAdapter = new ReviewAdapter(this, users, reviews);
        recyclerView.setAdapter(reviewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}