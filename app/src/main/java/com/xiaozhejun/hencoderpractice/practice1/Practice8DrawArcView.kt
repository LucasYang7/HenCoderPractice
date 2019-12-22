package com.xiaozhejun.hencoderpractice.practice1


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Practice8DrawArcView : View {

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

        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        val rectF = RectF()
        rectF.set(200f, 200f, 800f, 600f)
        val paint = Paint()
        // 实心扇形（useCenter为true时会带有半径）
        paint.style = Paint.Style.FILL
        canvas.drawArc(rectF, 0f, 45f, true, paint)
        // 空心扇形
        paint.style = Paint.Style.STROKE
        canvas.drawArc(rectF, 90f, 45f, true, paint)
        // 实心圆弧
        paint.style = Paint.Style.FILL
        canvas.drawArc(rectF, 180f, 45f, false, paint)
        // 空心圆弧
        paint.style = Paint.Style.STROKE
        canvas.drawArc(rectF, 270f, 45f, false, paint)
    }
}