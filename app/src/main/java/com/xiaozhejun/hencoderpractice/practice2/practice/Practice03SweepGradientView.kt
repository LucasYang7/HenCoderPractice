package com.xiaozhejun.hencoderpractice.practice2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View


class Practice03SweepGradientView : View {
    internal var paint = Paint(ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    init {
        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
        val sweepGradient = SweepGradient(300f,300f,
            Color.parseColor("#E91E63"),Color.parseColor("#2196F3"))
        paint.shader = sweepGradient
    }

    protected override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(300f, 300f, 200f, paint)
    }
}
