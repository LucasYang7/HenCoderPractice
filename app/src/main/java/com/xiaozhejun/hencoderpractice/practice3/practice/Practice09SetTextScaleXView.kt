package com.xiaozhejun.hencoderpractice.practice3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice09SetTextScaleXView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello HenCoder"

    init {
        paint.textSize = 60f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 Paint.setTextScaleX() 来改变文字宽度
        paint.textScaleX = 1.0f
        canvas.drawText(text, 50f, 100f, paint)

        paint.textScaleX = 0.5f
        canvas.drawText(text, 50f, 200f, paint)

        paint.textScaleX = 1.2f
        canvas.drawText(text, 50f, 300f, paint)
    }
}
