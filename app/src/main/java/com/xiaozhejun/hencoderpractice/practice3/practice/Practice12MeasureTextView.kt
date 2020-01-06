package com.xiaozhejun.hencoderpractice.practice3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice12MeasureTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    internal var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text1 = "三个月内你胖了"
    internal var text2 = "4.5"
    internal var text3 = "公斤"

    init {
        paint1.textSize = 60f
        paint2.textSize = 120f
        paint2.color = Color.parseColor("#E91E63")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.measureText 测量出文字宽度，让文字可以相邻绘制

        val paintWidth1 = paint1.measureText(text1)
        val paintWidth2 = paint2.measureText(text2)
        canvas.drawText(text1, 50f, 200f, paint1)
        canvas.drawText(text2, 50f + paintWidth1, 200f, paint2)
        canvas.drawText(text3, 50f + paintWidth1 + paintWidth2, 200f, paint1)
    }
}