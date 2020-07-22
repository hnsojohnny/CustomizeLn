package com.customizeln

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author: hs-johnny
 * @date: 2020/7/22
 * @description:
 */
val IMG_WIDTH = 200f.dp2px
class AvatarView constructor(context: Context, attr: AttributeSet): View(context, attr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {

    }
}