package com.example.droidfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.droidfoodapp.helper.ManagementCart

class ActivityCart : AppCompatActivity() {
    private var adapter: RecyclerView.Adapter<*>? = null
    private lateinit var recyclerViewList: RecyclerView
    private lateinit var managementCart: ManagementCart
    private lateinit var totalFeeTxt: TextView
    private lateinit var taxTxt: TextView
    private lateinit var deliveryTxt: TextView
    private lateinit var totalTxt: TextView
    private lateinit var emptyTxt: TextView
    private var tax: Double = 0.0;
    private lateinit var scrollView: ScrollView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
    }
}