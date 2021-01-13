package com.example.spoilerin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCommentActivity extends AppCompatActivity {

    EditText etUser, etReview;
    Button btnAddReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        etUser = findViewById(R.id.et_addComAct_user);
        etReview = findViewById(R.id.et_reviews);
        btnAddReview = findViewById(R.id.btn_addComAct_inputReview);

        btnAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}