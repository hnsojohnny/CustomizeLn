package com.example.coustomdemo

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.customizeln.dp2px
import kotlin.math.cos
import kotlin.math.sin

private val RADUIAS = 200f.dp2px
private const val DEFAULT_ANGLE = 120
private val SMALL_WIDTH = 5f.dp2px
private val SMALL_HEIGHT = 20f.dp2px
private val POINT_LENGHT = (RADUIAS - SMALL_HEIGHT * 1.5).toInt()
private const val ANGLE = (360 - DEFAULT_ANGLE) / 20
private const val START_ANGLE = 90 + DEFAULT_ANGLE/2

class YBPView constructor(context: Context, attr: AttributeSet?) : View(context, attr){

    constructor(context: Context): this(context, null)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path: Path = Path()
    private val dash = Path()
    private lateinit var pathEffect: PathDashPathEffect
    private val pathMeasure = PathMeasure()

    init {
        paint.strokeWidth = 4f.dp2px
        paint.style = Paint.Style.STROKE
        dash.addRect(0f,0f, SMALL_WIDTH, SMALL_HEIGHT, Path.Direction.CCW)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.addArc(width/2 - RADUIAS, height/2 - RADUIAS, width/2+ RADUIAS, height/2 + RADUIAS,
            90 + DEFAULT_ANGLE/2f, 360 - DEFAULT_ANGLE.toFloat())
        pathMeasure.setPath(path, false)
        pathEffect = PathDashPathEffect(dash, (pathMeasure.length - SMALL_WIDTH) /20, 0f, PathDashPathEffect.Style.ROTATE)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null
        canvas.drawLine(width/2f, height/2f, width/2f + POINT_LENGHT * cos(Math.toRadians(
            START_ANGLE + 5 * ANGLE.toDouble())).toFloat(),
            height/2f+ POINT_LENGHT * sin(Math.toRadians(START_ANGLE + 5 * ANGLE.toDouble())).toFloat(), paint)
    }
}