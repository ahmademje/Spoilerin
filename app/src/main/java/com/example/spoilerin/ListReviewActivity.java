package com.example.spoilerin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListReviewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String users[], reviews[];
    FloatingActionButton btn_addReview;

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

        btn_addReview = findViewById(R.id.btn_addReview);
        btn_addReview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListReviewActivity.this, AddCommentActivity.class);
                startActivity(intent);
            }
        });
    }
}