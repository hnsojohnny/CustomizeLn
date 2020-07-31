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
class AnimHomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = AnimHomeAdapter(object : AnimHomeAdapter.OnItemListener {
            override fun onClick(position: Int) {
                Intent(this@AnimHomeActivity, AnimViewDetailActivity::class.java).apply {
                    action = position.toString()
                    startActivity(this)
                }
            }
        })
    }
}