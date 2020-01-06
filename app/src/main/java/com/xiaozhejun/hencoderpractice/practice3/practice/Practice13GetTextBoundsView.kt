package com.xiaozhejun.hencoderpractice.practice3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Practice13GetTextBoundsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 10
) : View(context, attrs, defStyleAttr) {
    private var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var text1 = "A"
    private var text2 = "a"
    private var text3 = "J"
    private var text4 = "j"
    private var text5 = "Â"
    private var text6 = "â"
    internal var top = 200
    internal var bottom = 400

    init {
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(50f, top.toFloat(), (width - 50).toFloat(), bottom.toFloat(), paint1)

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        var middle = (top + bottom) / 2
        val textBounds = Rect()
        // bounds中存储这文字的显示区域
        paint2.getTextBounds(text1, 0, text1.length, textBounds)
        canvas.drawText(
            text1,
            textBounds.left + 100f,
            -(textBounds.top + textBounds.bottom) / 2.0f + middle,
            paint2
        )

        paint2.getTextBounds(text2, 0, text1.length, textBounds)
        canvas.drawText(
            text2, textBounds.left + 200f,
            -(textBounds.top + textBounds.bottom) / 2.0f + middle, paint2
        )

        paint2.getTextBounds(text3, 0, text1.length, textBounds)
        canvas.drawText(
            text3, textBounds.left + 300f,
            -(textBounds.top + textBounds.bottom) / 2.0f + middle, paint2
        )

        paint2.getTextBounds(text4, 0, text1.length, textBounds)
        canvas.drawText(
            text4, textBounds.left + 400f,
            -(textBounds.top + textBounds.bottom) / 2.0f + middle, paint2
        )

        paint2.getTextBounds(text5, 0, text1.length, textBounds)
        canvas.drawText(
            text5, textBounds.left + 500f,
            -(textBounds.top + textBounds.bottom) / 2.0f + middle, paint2
        )

        paint2.getTextBounds(text6, 0, text1.length, textBounds)
        canvas.drawText(
            text6, textBounds.left + 600f,
            -(textBounds.top + textBounds.bottom) / 2.0f + middle, paint2
        )
    }
}