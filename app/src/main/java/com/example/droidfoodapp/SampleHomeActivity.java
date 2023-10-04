package com.example.droidfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.droidfoodapp.Adapter.SampleCategoryAdapter;
import com.example.droidfoodapp.domain.SampleCategoryDomain;
import com.example.droidfoodapp.domain.SampleFoodDomain;

import java.util.ArrayList;

public class SampleHomeActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private  RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_home);

        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<SampleFoodDomain> dataList = new ArrayList<>();
        dataList.add(new SampleFoodDomain("Pepperoni Pizza","pizza1","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",13.0,5,20,1000));
        dataList.add(new SampleFoodDomain("Cheese Burger","burger","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",15.20,44,18,1500));
        dataList.add(new SampleFoodDomain("Vegetable Pizza","pizza1","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",13.0,5,20,1000));


//        adapter2= new SampleCategoryAdapter(dataList);
//        recyclerViewPopularList.setAdapter(adapter2);
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