package com.customizeln.view

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import com.customizeln.dp2px
import kotlin.random.Random

/**
 * create： hansh
 * data： 2020/8/17
 * description：
 */
private val CORNER_RADIUS = 4f.dp2px
private const val X_PADDING = 16
private const val Y_PADDING = 8
private val colorList = arrayOf(Color.CYAN, Color.GREEN, Color.RED, Color.YELLOW, Color.GRAY)
private val textSizeList = arrayOf(20f.dp2px, 30f.dp2px, 40f.dp2px, 50f.dp2px, 60f.dp2px)

class TagKeyView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    constructor(context: Context): this(context, null)
    private var currentColor = 0
    private var currentTextSize = 0

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
    }

    init {
        currentColor = Random.nextInt(colorList.size)
        currentTextSize = Random.nextInt(textSizeList.size)
        setTextColor(Color.WHITE)
        paint.color = colorList[currentColor]
        paint.style = Paint.Style.FILL
        textSize = textSizeList[currentTextSize]
        setPadding(X_PADDING, Y_PADDING, X_PADDING, Y_PADDING)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        canvas.drawRoundRect(0f, 0f, width.toFloat(), height.toFloat(), CORNER_RADIUS, CORNER_RADIUS, paint)
        super.onDraw(canvas)
    }
}