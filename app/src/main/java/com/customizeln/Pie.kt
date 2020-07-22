package com.example.coustomdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.customizeln.dp2px
import kotlin.math.cos
import kotlin.math.sin

val translate = 20f.dp2px

class Pie(context: Context, attributeSet: AttributeSet) : View(context, attributeSet){

    val angleList = arrayListOf(60, 120, 40, 80, 60)
    val colorList = arrayListOf(Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW,  Color.CYAN)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var angleTotal = 0
        for ((index, angle) in angleList.withIndex()){
            paint.color = colorList[index]
            if (index == 3){
                canvas.save()
                canvas.translate(translate * cos(Math.toRadians(angleTotal + angle/2.toDouble()).toFloat()),
                    translate * sin(Math.toRadians(angleTotal + angle/2.toDouble()).toFloat()))
            }
            canvas.drawArc(width/2 - RADUIAS, height/2 - RADUIAS, width/2 + RADUIAS, height/2 + RADUIAS,
                angleTotal.toFloat(), angle.toFloat(), true, paint)
            angleTotal += angle
            if (index == 3){
                canvas.restore()
            }
        }
    }
}