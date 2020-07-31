package com.customizeln

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @author: hs-johnny
 * @date: 2020/7/30
 * @description:
 */

private val IMG_WIDTH = 600f.dp2px
private val PADDING = 200f.dp2px

class TurnUpImgView constructor(context: Context, attr: AttributeSet?) : View(context, attr){

    constructor(context: Context): this(context, null)
    private val bitmap = getImg()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val camera = Camera()
    init {
        camera.setLocation(0f, 0f, -20 * resources.displayMetrics.density)
        camera.rotateX(45f)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.save()
        canvas.translate(PADDING + IMG_WIDTH/2, PADDING + IMG_WIDTH/2)
        canvas.rotate(-30f)
        canvas.clipRect(-IMG_WIDTH, -IMG_WIDTH, IMG_WIDTH, 0f)
        canvas.rotate(30f)
        canvas.translate(-(PADDING + IMG_WIDTH/2), -(PADDING + IMG_WIDTH/2))
        canvas.drawBitmap(bitmap, PADDING, PADDING, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(PADDING + IMG_WIDTH/2, PADDING + IMG_WIDTH/2)
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(-IMG_WIDTH, 0f, IMG_WIDTH, IMG_WIDTH)
        canvas.rotate(30f)
        canvas.translate(-(PADDING + IMG_WIDTH/2), -(PADDING + IMG_WIDTH/2))
        canvas.drawBitmap(bitmap, PADDING, PADDING, paint)
        canvas.restore()
    }

    private fun getImg(): Bitmap{
        val options =  BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.lion, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = IMG_WIDTH.toInt()
        return BitmapFactory.decodeResource(resources, R.drawable.lion, options)
    }
}