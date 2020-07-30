package com.customizeln

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

/**
 * @author: hs-johnny
 * @date: 2020/7/22
 * @description:
 */
private val IMG_WIDTH = 200f.dp2px
private val PADDING = 200f.dp2px
private val STROKE_WIDTH = 8f.dp2px

class AvatarView constructor(context: Context, attr: AttributeSet?): View(context, attr) {

    constructor(context: Context): this(context, null)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val xfm = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    private val bitmap = getBitmap()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        canvas.drawOval(PADDING - STROKE_WIDTH,PADDING - STROKE_WIDTH,
            PADDING + IMG_WIDTH + STROKE_WIDTH, PADDING + IMG_WIDTH + STROKE_WIDTH, paint)
        val count = canvas.saveLayer(PADDING,PADDING,
            PADDING + IMG_WIDTH, PADDING + IMG_WIDTH, paint)
        canvas.drawOval(PADDING,PADDING,
            PADDING + IMG_WIDTH, PADDING + IMG_WIDTH, paint )
        paint.xfermode = xfm
        canvas.drawBitmap(bitmap, PADDING,PADDING, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }

    private fun getBitmap(): Bitmap{
        val op: BitmapFactory.Options = BitmapFactory.Options()
        op.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.wuyanzu, op)
        op.inJustDecodeBounds = false
        op.inDensity = op.outWidth
        op.inTargetDensity = IMG_WIDTH.toInt()
        return BitmapFactory.decodeResource(resources, R.drawable.wuyanzu, op)
    }
}