package com.example.spoilerin;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMovieActivity extends AppCompatActivity {
    ArrayList<MovieModel> arrayList;
    RecyclerView recyclerView;


    static Integer[]  drawaleArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_list_movie);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        addData();

        MovieAdapter adapter = new MovieAdapter(getApplicationContext(), arrayList);
        recyclerView.setAdapter(adapter);
    }

    private  void addData(){

    }
}
