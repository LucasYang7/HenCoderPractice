package com.xiaozhejun.hencoderpractice.practice4.sample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R


class Sample07MatrixTranslateView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)
    internal var matrix = Matrix()

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        matrix.reset()
        matrix.postTranslate(-100f, -100f)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        matrix.reset()
        matrix.postTranslate(200f, 0f)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
