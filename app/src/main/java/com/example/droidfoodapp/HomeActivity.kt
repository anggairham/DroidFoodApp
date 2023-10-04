package com.example.droidfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.droidfoodapp.adapter.CategoryAdapter
import com.example.droidfoodapp.adapter.RecommendedAdapter
import com.example.droidfoodapp.domain.CategoryDomain
import com.example.droidfoodapp.domain.RecommendedDomain

class HomeActivity : AppCompatActivity() {
    private var adapter: RecyclerView.Adapter<*>? = null
    private var adapter2: RecyclerView.Adapter<*>? = null
    private lateinit var recyclerViewCategoryList: RecyclerView
    private lateinit var recyclerViewRecommendedList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerViewCategory()
        recyclerViewRecommended()
    }

    private fun recyclerViewRecommended() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewRecommendedList = findViewById(R.id.view2)
        recyclerViewRecommendedList.layoutManager = linearLayoutManager

        val dataList = ArrayList<RecommendedDomain>()
        dataList.add(RecommendedDomain("Pepperoni Pizza","pizza1","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",13.0,5,20,1000));
        dataList.add(RecommendedDomain("Cheese Burger","burger","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",15.20,44,18,1500));
        dataList.add(RecommendedDomain("Vegetable Pizza","pizza1","slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",13.0,5,20,1000));

        adapter2 = RecommendedAdapter(dataList)
        recyclerViewRecommendedList.adapter = adapter2
    }

    private fun recyclerViewCategory() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCategoryList = findViewById(R.id.view1)
        recyclerViewCategoryList.layoutManager = linearLayoutManager

        val dataList = ArrayList<CategoryDomain>()
        dataList.add(CategoryDomain("Pizza", "cat_1"))
        dataList.add(CategoryDomain("Pizza", "cat_2"))
        dataList.add(CategoryDomain("Pizza", "cat_3"))
        dataList.add(CategoryDomain("Pizza", "cat_4"))
        dataList.add(CategoryDomain("Pizza", "cat_5"))

        adapter = CategoryAdapter(dataList)
        recyclerViewCategoryList.adapter = adapter
    }
}