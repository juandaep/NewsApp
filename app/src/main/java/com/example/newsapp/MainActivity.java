package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_list;
    List<String> desc_list = new ArrayList<>();
    List<Integer> image_list = new ArrayList<>();
    AdapterItem adapterItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_list = findViewById(R.id.list_rv);

        //Untuk menaruh data dari strings.xml ke variabel arraylist deskripsi_list
        desc_list = Arrays.asList(getResources().getStringArray(R.array.description));

        //Untuk menaruh data dari strings.xml ke variabel arrayList image_list
        TypedArray typedArray = getResources().obtainTypedArray(R.array.image);

        for (int i = 0; i < typedArray.length(); i++) {
            image_list.add(i, typedArray.getResourceId(i, 0));
        }

        //Untuk mengenalkan Adapter ke MainActivity
        adapterItem = new AdapterItem(MainActivity.this, desc_list, image_list);

        //Untuk membuat tampilan recyclerview vertical atas ke bawah
        LinearLayoutManager llm = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.VERTICAL,
                false
        );
        //Untuk menerapkan tampilan yang telah dibuat di atas
        rv_list.setLayoutManager(llm);

        //Untuk menerapkan adapter yang digunakan untuk si RecyclerView
        rv_list.setAdapter(adapterItem);

    }
}