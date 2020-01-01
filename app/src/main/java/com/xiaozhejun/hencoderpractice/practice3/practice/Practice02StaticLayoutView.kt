package com.xiaozhejun.hencoderpractice.practice3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

class Practice02StaticLayoutView : View {
    internal var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello\nHenCoder"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    init {
        textPaint.textSize = 60f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        canvas.drawText(text, 50f, 100f, textPaint)

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        val staticLayout = StaticLayout(
            text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL,
            1f, 0f, true
        )
        canvas.save()
        // 移动画布
        canvas.translate(50f, 100f)
        staticLayout.draw(canvas)
        canvas.restore()
    }
}