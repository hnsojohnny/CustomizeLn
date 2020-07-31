package com.customizeln.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.customizeln.R
import com.customizeln.dp2px

/**
 * @author: hs-johnny
 * @date: 2020/7/29
 * @description:
 */
private val RADIUS = 300f.dp2px
private val STROKE_WIDTH = 30f.dp2px
private val TEXT_WIDTH = 5f.dp2px
private val TEXT_SIZE = 160f.dp2px

class PieAndTextView constructor(context: Context, attr: AttributeSet?): View(context, attr){

    constructor(context: Context): this(context, null)
    private val text = "agagag"
    private val bouns = Rect()

    val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        textSize = TEXT_SIZE
        style = Paint.Style.STROKE
        strokeWidth = STROKE_WIDTH
        strokeCap = Paint.Cap.ROUND
        color = ContextCompat.getColor(getContext(),
            R.color.colorAccent
        )
    }

    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = STROKE_WIDTH
        style = Paint.Style.STROKE
        color = ContextCompat.getColor(getContext(),
            R.color.gray
        )
    }

    lateinit var rectF: RectF

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rectF = RectF(width/2 - RADIUS, height/2 - RADIUS, width/2 + RADIUS,height/2 + RADIUS)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width/2f, height/2f, RADIUS, paint)
        canvas.drawArc(rectF, -90f, 240f, false, textPaint)
        textPaint.style = Paint.Style.FILL
        textPaint.getTextBounds(text, 0, text.length, bouns)
        val fontMetrics: Paint.FontMetrics = textPaint.fontMetrics
        val des = (fontMetrics.descent - fontMetrics.ascent)/2 + fontMetrics.ascent
        canvas.drawText(text, 0, text.length, width/2f, height/2f + bouns.height()/2, textPaint)
        canvas.drawText(text, 0, text.length, width/2f, height/2f - des, textPaint)
    }
}