package com.example.droidfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.droidfoodapp.adapter.SampleCategoryAdapter;
import com.example.droidfoodapp.adapter.SampleRecommendedAdapter;
import com.example.droidfoodapp.domain.SampleCategoryDomain;
import com.example.droidfoodapp.domain.SampleFoodDomain;

import java.util.ArrayList;

public class SampleHomeActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private  RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn= findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SampleHomeActivity.this, SampleHomeActivity.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SampleHomeActivity.this, SampleCartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<SampleFoodDomain> dataList = new ArrayList<>();
        dataList.add(new SampleFoodDomain("Pepperoni Pizza","pizza1","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",13.0,5,20,1000));
        dataList.add(new SampleFoodDomain("Cheese Burger","burger","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",15.20,44,18,1500));
        dataList.add(new SampleFoodDomain("Vegetable Pizza","pizza3","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",13.0,5,20,1000));


        adapter2= new SampleRecommendedAdapter(dataList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<SampleCategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new SampleCategoryDomain("Pizza","cat_1"));
        categoryList.add(new SampleCategoryDomain("Pizza","cat_2"));
        categoryList.add(new SampleCategoryDomain("Pizza","cat_3"));
        categoryList.add(new SampleCategoryDomain("Pizza","cat_4"));
        categoryList.add(new SampleCategoryDomain("Pizza","cat_5"));

        adapter= new SampleCategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}