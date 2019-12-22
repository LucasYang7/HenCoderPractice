package com.xiaozhejun.hencoderpractice.practice1


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice11PieChartView : View {

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
        //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        val paint = Paint()
        val rect = RectF()
        rect.set(200f, 200f, 800f, 800f)
        paint.color = Color.BLUE
        canvas.drawArc(rect, 0f, 12f, true, paint)

        paint.color = Color.MAGENTA
        canvas.drawArc(rect, 15f, 12f, true, paint)

        paint.color = Color.GREEN
        canvas.drawArc(rect, 30f, 47f, true, paint)

        paint.color = Color.GRAY
        canvas.drawArc(rect, 80f, 97f, true, paint)

        rect.set(180f, 180f, 800f, 800f)
        paint.color = Color.RED
        canvas.drawArc(rect, 180f, 102f, true, paint)

        rect.set(200f, 200f, 800f, 800f)
        paint.color = Color.YELLOW
        canvas.drawArc(rect, 285f, 72f, true, paint)

        // 绘制折线
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 3f
        val linePath = Path()
        linePath.moveTo(780f, 400f)
        linePath.rLineTo(50f, -50f)
        linePath.rLineTo(70f, 0f)
        canvas.drawPath(linePath, paint)

        // 绘制文字
        val textPaint = Paint()
        textPaint.color = Color.WHITE
        textPaint.textSize = 25f
        canvas.drawText("Marshmallow", 905f, 350f, textPaint)
    }
}