package com.example.droidfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.droidfoodapp.domain.CategoryDomain

class HomeActivity : AppCompatActivity() {
    private var adapter: RecyclerView.Adapter<*>? = null
    private var adapter2: RecyclerView.Adapter<*>? = null
    private lateinit var recyclerViewCategoryList: RecyclerView
    private lateinit var recyclerViewPopularList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerViewCategoryList()
    }
    private fun recyclerViewCategoryList() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCategoryList = findViewById(R.id.view1)
        recyclerViewCategoryList.layoutManager = linearLayoutManager

        val categoryList = ArrayList<CategoryDomain>()
        categoryList.add(CategoryDomain("Pizza", "cat_1"))
        categoryList.add(CategoryDomain("Pizza", "cat_2"))
        categoryList.add(CategoryDomain("Pizza", "cat_3"))
        categoryList.add(CategoryDomain("Pizza", "cat_4"))
        categoryList.add(CategoryDomain("Pizza", "cat_5"))
    }
}