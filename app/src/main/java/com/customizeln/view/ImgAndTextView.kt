package com.customizeln.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.customizeln.R
import com.customizeln.dp2px

/**
 * @author: hs-johnny
 * @date: 2020/7/29
 * @description:
 */
private val TEXT_SIZE = 36f.dp2px
private val PADDING = 120f.dp2px
private const val IMG_WIDTH = 200

class ImgAndTextView constructor(context: Context, attr: AttributeSet?): View(context, attr){

    constructor(context: Context): this(context, null)

    private val text = "由中国科学院深海科学与工程研究所海洋哺乳动物与海洋生物声学研究室组织的“2020年南海深潜及远海鲸类科考航次”28日完成全部科考任务，顺利返回三亚。" +
            "考察共目击到深潜和远海鲸类动物31群次、11个物种，其中深潜鲸类14群次、7种，分别为抹香鲸、柯氏喙鲸、短肢领航鲸、瑞氏海豚（又叫花鲸）、伪虎鲸、小虎鲸和瓜头鲸；" +
            "其它远海鲸类物种4种，分别为热带斑海豚、弗氏海豚、长吻飞旋海豚和条纹海豚。本航次历时21天，航程3000多公里，考察区域集中在南海北部西沙群岛和中沙群岛的陆坡、海山及海槽水域。" +
            "考察采用目视考察和被动声学监测相结合的方法，并辅以环境DNA收集，旨在以“2019年南海深潜及远海鲸类科考航次”为基础，进一步对考察海域的鲸类物种多样性、种群现状及分布模式等进行调查。" +
            "相较去年，此次科考新发现并记录到小虎鲸、伪虎鲸、长吻飞旋海豚、瓜头鲸等4个鲸类物种，表明考察海域具有较为丰富的鲸类物种多样性"
    private val paint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = TEXT_SIZE
    }
    private val fontMetrics = paint.fontMetrics
    private val bitmap = getAvator()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(bitmap, (width - bitmap.width).toFloat(),
            PADDING, paint)
        drawText(canvas)
    }

    fun getAvator(): Bitmap{
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources,
            R.drawable.avator, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = IMG_WIDTH
        return BitmapFactory.decodeResource(resources,
            R.drawable.avator, options)
    }

    private fun drawText(canvas: Canvas){
        var start = 0
        var des = -fontMetrics.top
        var count: Int
        while (start < text.length){
            count = if (des > PADDING && des - paint.fontSpacing < bitmap.height + PADDING){
                paint.breakText(text, start, text.length, true, (width - bitmap.width).toFloat(), floatArrayOf(0f))
            }else {
                paint.breakText(text, start, text.length, true, width.toFloat(), floatArrayOf(0f))
            }
            canvas.drawText(text, start, start + count, 0f, des, paint)
            start += count
            des += paint.fontSpacing
        }
    }
}