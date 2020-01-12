package com.xiaozhejun.hencoderpractice.practice4.practice

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R


class Practice06SkewView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // sx 将画布在x轴方向上倾斜相应的角度,sx是倾斜角度的tan值,其实就是将y轴逆时针旋转相应的角度
        // sy 将画布在y轴方向上倾斜相应的角度,sy是倾斜角度的tan值,其实就是将x轴顺时针旋转相应的角度
        canvas.save()
        canvas.skew(0f, 0.5f)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        canvas.skew(-0.5f, 0f)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
