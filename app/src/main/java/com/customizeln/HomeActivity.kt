package com.customizeln

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: hs-johnny
 * @date: 2020/7/29
 * @description:
 */
class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        val intent = Intent()
        rv.adapter = HomeAdapter(object : HomeAdapter.OnItemListener {
            override fun onClick(position: Int) {
                intent.setClass(this@HomeActivity, when (position){
                    0 -> PieActivity::class.java
                    1- >
                    else ->
                })
            }
        })
    }
}