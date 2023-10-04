package com.example.droidfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.droidfoodapp.domain.SampleCategoryDomain;

import java.util.ArrayList;

public class SampleHomeActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private  RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_home);

        recyclerViewCategoryList();
    }

    private void recyclerViewCategoryList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<SampleCategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new SampleCategoryDomain("Pizza","cat_1"));
        categoryList.add(new SampleCategoryDomain("Pizza","cat_2"));
        categoryList.add(new SampleCategoryDomain("Pizza","cat_3"));
        categoryList.add(new SampleCategoryDomain("Pizza","cat_4"));
        categoryList.add(new SampleCategoryDomain("Pizza","cat_5"));
    }
}