package com.customizeln.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeln.R
import com.customizeln.dp2px

/**
 * @author: hs-johnny
 * @date: 2020/7/30
 * @description:
 */

private val IMG_WIDTH = 600f.dp2px
private val PADDING = 200f.dp2px

class AnimTurnUpImgView constructor(context: Context, attr: AttributeSet?) : View(context, attr){

    constructor(context: Context): this(context, null)
    private val bitmap = getImg()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val camera = Camera()

    private var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    private var bottomFlip = 0f
        set(value) {
            field = value
            invalidate()
        }

    private var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        camera.setLocation(0f, 0f, -20 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.save()
        canvas.translate(PADDING + IMG_WIDTH /2, PADDING + IMG_WIDTH /2)
        canvas.rotate(-flipRotation)
        canvas.save()
        camera.rotateX(topFlip)
        camera.applyToCanvas(canvas)
        canvas.restore()
        canvas.clipRect(-IMG_WIDTH, -IMG_WIDTH,
            IMG_WIDTH, 0f)
        canvas.rotate(flipRotation)
        canvas.translate(-(PADDING + IMG_WIDTH /2), -(PADDING + IMG_WIDTH /2))
        canvas.drawBitmap(bitmap,
            PADDING,
            PADDING, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(PADDING + IMG_WIDTH /2, PADDING + IMG_WIDTH /2)
        canvas.rotate(-flipRotation)
        canvas.save()
        camera.rotateX(bottomFlip)
        camera.applyToCanvas(canvas)
        canvas.restore()
        canvas.clipRect(-IMG_WIDTH, 0f,
            IMG_WIDTH,
            IMG_WIDTH
        )
        canvas.rotate(flipRotation)
        canvas.translate(-(PADDING + IMG_WIDTH /2), -(PADDING + IMG_WIDTH /2))
        canvas.drawBitmap(bitmap,
            PADDING,
            PADDING, paint)
        canvas.restore()
    }

    private fun getImg(): Bitmap{
        val options =  BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources,
            R.drawable.lion, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = IMG_WIDTH.toInt()
        return BitmapFactory.decodeResource(resources,
            R.drawable.lion, options)
    }
}