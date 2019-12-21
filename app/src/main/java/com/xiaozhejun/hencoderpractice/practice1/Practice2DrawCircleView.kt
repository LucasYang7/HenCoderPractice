package com.xiaozhejun.hencoderpractice.practice1


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice2DrawCircleView : View {

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

        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        val paint = Paint()
        // 1.实心圆
        canvas.drawCircle(300f, 200f, 200f, paint)
        // 2.空心圆
        paint.style = Paint.Style.STROKE
        canvas.drawCircle(800f, 200f, 200f, paint)
        // 3.蓝色实心圆
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        canvas.drawCircle(300f, 700f, 200f, paint)
        // 4.线宽为 20 的空心圆
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        paint.color = Color.BLACK
        canvas.drawCircle(800f, 700f, 200f, paint)
    }
}