package com.customizeln

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coustomdemo.Pie
import com.example.coustomdemo.YBPView

class MainActivity : AppCompatActivity() {

    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        index = intent.action?.toInt()!!
        setView()
    }

    private fun setView(){
        val view = when(index){
            0 -> YBPView(this)
            1 -> Pie(this)
            2 -> AvatarView(this)
            3 -> PieAndTextView(this)
            4 -> ImgAndTextView(this)
            5 -> TurnUpImgView(this)
            else -> null
        }
        view?.apply {
            setContentView(this)
        }
    }
}