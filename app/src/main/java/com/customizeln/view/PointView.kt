package com.customizeln.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.customizeln.dp2px

/**
 * @author: hs-johnny
 * @date: 2020/7/31
 * @description:
 */
class PointView (context: Context, attr: AttributeSet?) : View(context, attr) {

    constructor(context: Context): this(context, null)

    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 20f.dp2px
        strokeCap = Paint.Cap.ROUND
    }
    var pointF = PointF()
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPoint(pointF.x, pointF.y, paint)
    }
}