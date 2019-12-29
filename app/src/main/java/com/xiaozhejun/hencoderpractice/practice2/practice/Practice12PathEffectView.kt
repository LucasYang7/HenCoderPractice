package com.xiaozhejun.hencoderpractice.practice2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice12PathEffectView : View {
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
        paint.style = Paint.Style.STROKE

        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        val cornerPathEffect = CornerPathEffect(20f)
        paint.pathEffect = cornerPathEffect
        canvas.drawPath(path, paint)

        canvas.save()
        canvas.translate(500f, 0f)
        // 第二处：DiscretePathEffect
        val discretePathEffect = DiscretePathEffect(20f,5f)
        paint.pathEffect = discretePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 200f)
        // 第三处：DashPathEffect
        /**
         * 第一个参数 intervals 是一个数组，它指定了虚线的格式：数组中元素必须为偶数（最少是 2 个），
         * 按照「画线长度、空白长度、画线长度、空白长度」……的顺序排列，
         * 例如下面代码中的 20, 5, 10, 5 就表示虚线是按照「画 20 像素、空 5 像素、画 10 像素、空 5 像素」的模式来绘制；
         * 第二个参数 phase 是虚线数组intervals的偏移量。
         * */
        val intervals = floatArrayOf(20f, 5f, 10f, 5f)
        val dashPathEffect = DashPathEffect(intervals, 0f)
        paint.pathEffect = dashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 200f)
        // 第四处：PathDashPathEffect
        val dashPath = Path()
        dashPath.lineTo(20f, -30f)
        dashPath.lineTo(40f, 0f)
        dashPath.close()
        val pathDashPathEffect = PathDashPathEffect(
            dashPath, 50f, 0f, PathDashPathEffect.Style.MORPH
        )
        paint.pathEffect = pathDashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 400f)
        // 第五处：SumPathEffect
        val sumPathEffect = SumPathEffect(discretePathEffect,dashPathEffect)
        paint.pathEffect = sumPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 400f)
        // 第六处：ComposePathEffect  先应用虚线效果，再应用偏移效果
        val composePathEffect = ComposePathEffect(dashPathEffect,discretePathEffect)
        paint.pathEffect = composePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
    }
}
