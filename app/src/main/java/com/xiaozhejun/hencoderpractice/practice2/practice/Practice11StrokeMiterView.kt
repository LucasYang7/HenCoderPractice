package com.xiaozhejun.hencoderpractice.practice2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice11StrokeMiterView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var path = Path()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    init {
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE

        path.rLineTo(200f, 0f)
        path.rLineTo(-160f, 120f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()

        canvas.translate(100f, 100f)

        // https://hencoder.com/ui-1-2/
        // miter 参数是对于转角长度的限制，具体来讲，是指尖角的外缘端点和内部拐角的距离与线条宽度的比。
        // 用几何知识很容易得出这个比值的计算公式：如果外部拐角的大小为 θ ，那么这个比值就等于 1 / sin ( θ / 2 ) 。
        // 这个 miter limit 的默认值是 4，对应的是一个大约 29° 的锐角：
        // 默认情况下，大于这个角的尖角会被保留，而小于这个夹角的就会被「削成平头」
        // miter值越大，能保留的尖角角度就越小

        // MITER 值：1
        paint.strokeMiter = 1f
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        // MITER 值：2
        paint.strokeMiter = 2f
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        // MITER 值：5
        paint.strokeMiter = 5f
        canvas.drawPath(path, paint)

        canvas.restore()
    }
}
