package com.xiaozhejun.hencoderpractice.practice1


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Practice3DrawRectView : View {

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

        //        练习内容：使用 canvas.drawRect() 方法画矩形
        val paint = Paint()
        // 实心矩形
        paint.style = Paint.Style.FILL
        canvas.drawRect(100f, 100f, 200f, 200f, paint)

        // 空心矩形
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        val rect = RectF()
        rect.set(400f, 400f, 500f, 500f)
        canvas.drawRect(rect, paint)
    }
}
