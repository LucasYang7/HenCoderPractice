package com.xiaozhejun.hencoderpractice.practice1


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Practice5DrawOvalView : View {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawOval() 方法画椭圆
        val paint = Paint()
        paint.color = Color.BLUE
        val rectF = RectF()
        rectF.set(100f,100f,600f,400f)
        canvas.drawOval(rectF,paint)
    }
}