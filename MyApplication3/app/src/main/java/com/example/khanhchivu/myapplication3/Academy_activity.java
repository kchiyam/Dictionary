package com.example.khanhchivu.myapplication3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Academy_activity extends AppCompatActivity {

    RecyclerView recycleview;
    RecyclerView.LayoutManager layoutManager;
    AcademyAdapter academyAdapter;
    List<String> titleList;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview);
        recycleview= (RecyclerView) findViewById(R.id.recycler_view);

        titleList = new ArrayList<>();
        titleList.add("Sport");
        titleList.add("Education");
        titleList.add("Engineer");
        titleList.add("Law");
        titleList.add("Economic");

        academyAdapter = new AcademyAdapter(this, titleList);
        recycleview.setAdapter(academyAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycleview.setLayoutManager(linearLayoutManager);

    }
}
