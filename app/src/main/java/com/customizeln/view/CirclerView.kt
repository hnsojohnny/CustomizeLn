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
class CirclerView (context: Context, attr: AttributeSet?): View(context, attr){

    constructor(context: Context): this(context, null)

    private var raduis = 30f.dp2px
    set(value) {
        field = value
        invalidate()
    }

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(width/2f, height/2f, raduis, paint)
    }
}