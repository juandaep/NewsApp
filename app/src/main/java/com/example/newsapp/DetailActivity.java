package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Introduce component

        TextView tv_detail = findViewById(R.id.tv_detail);
        ImageView iv_detail = findViewById(R.id.iv_detail);

        // get intent for start the activity
        Intent i = getIntent();

        // get data to detailactivity
        tv_detail.setText(i.getStringExtra("text"));
        iv_detail.setImageResource(i.getIntExtra("image", 0));

    }
}
