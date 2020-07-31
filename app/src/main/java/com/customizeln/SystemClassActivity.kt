package com.customizeln

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * @author: hs-johnny
 * @date: 2020/7/31
 * @description:
 */
class SystemClassActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_class)
        val intent = Intent()
        findViewById<TextView>(R.id.custom_tv).setOnClickListener {
            intent.setClass(this@SystemClassActivity, CustomHomeActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.anim_tv).setOnClickListener {
            intent.setClass(this@SystemClassActivity, AnimHomeActivity::class.java)
            startActivity(intent)
        }
    }
}