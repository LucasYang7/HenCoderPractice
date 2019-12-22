package com.xiaozhejun.hencoderpractice.practice1


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Practice10HistogramView : View {

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

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        val textPaint = Paint()
        textPaint.color = Color.WHITE
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = 30f
        val paint = Paint()
        paint.color = Color.WHITE
        canvas.drawLine(0f,100f,0f,600f,paint)
        canvas.drawLine(0f,600f,1000f,600f,paint)
        paint.color = Color.GREEN
        paint.style = Paint.Style.FILL
        val rect = RectF()
        rect.set(100f, 500f, 200f, 600f)
        canvas.drawRect(rect, paint)
        canvas.drawText("Froyo", 100f, 650f, textPaint)

        rect.set(250f, 300f, 350f, 600f)
        canvas.drawRect(rect, paint)
        canvas.drawText("GB", 250f, 650f, textPaint)

        rect.set(400f, 200f, 500f, 600f)
        canvas.drawRect(rect, paint)
        canvas.drawText("ICS", 400f, 650f, textPaint)

        rect.set(550f, 300f, 650f, 600f)
        canvas.drawRect(rect, paint)
        canvas.drawText("JB", 550f, 650f, textPaint)

        rect.set(700f, 200f, 800f, 600f)
        canvas.drawRect(rect, paint)
        canvas.drawText("KitKat", 700f, 650f, textPaint)

        rect.set(850f, 500f, 950f, 600f)
        canvas.drawRect(rect, paint)
        canvas.drawText("L", 850f, 650f, textPaint)
    }
}