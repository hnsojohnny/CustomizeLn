package com.customizeln.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.customizeln.dp2px

/**
 * @author: hs-johnny
 * @date: 2020/7/31
 * @description:
 */
val strs = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k", "l", "m", "n",
    "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
class StringView (context: Context, attr: AttributeSet?) : View(context, attr) {

    constructor(context: Context): this(context, null)

    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 40f.dp2px
        textAlign = Paint.Align.CENTER
    }
    val fontMetrics = paint.fontMetrics

    var m = "a"
    set(value) {
        field = value
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val des = (-fontMetrics.top) - (fontMetrics.bottom - fontMetrics.top)/2
        canvas.drawText(m, width/2f, height/2 + des, paint)
    }
}