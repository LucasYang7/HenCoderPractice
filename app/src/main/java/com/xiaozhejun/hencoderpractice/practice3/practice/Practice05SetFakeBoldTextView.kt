package com.xiaozhejun.hencoderpractice.practice3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice05SetFakeBoldTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello HenCoder"

    init {
        paint.textSize = 60f

        // 使用 Paint.setFakeBoldText() 来加粗文字
        paint.isFakeBoldText = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText(text, 50f, 100f, paint)
    }
}