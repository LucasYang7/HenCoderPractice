package com.xiaozhejun.hencoderpractice.practice1


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice9DrawPathView : View {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas )

        //        练习内容：使用 canvas.drawPath() 方法画心形
        val paint = Paint()
        paint.color = Color.RED
        val path = Path()
        val rect = RectF()
        rect.set(200f,200f,400f,400f)
        path.addArc(rect,-225f,225f)
        rect.set(400f,200f,600f,400f)
        path.arcTo(rect,-180f,225f,false)
        path.lineTo(400f,542f)
        canvas.drawPath(path,paint)
    }
}