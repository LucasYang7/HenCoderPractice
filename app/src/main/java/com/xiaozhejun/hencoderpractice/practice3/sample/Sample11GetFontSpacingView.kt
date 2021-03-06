package com.xiaozhejun.hencoderpractice.practice3.sample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Sample11GetFontSpacingView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello HenCoder"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    init {
        paint.textSize = 60f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val spacing = paint.fontSpacing

        canvas.drawText(text, 50f, 100f, paint)

        canvas.drawText(text, 50f, 100 + spacing, paint)

        canvas.drawText(text, 50f, 100 + spacing * 2, paint)
    }
}
