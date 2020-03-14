package com.xiaozhejun.hencoderpractice.practice4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R


class Practice08MatrixScaleView @JvmOverloads constructor(
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
        matrix.reset()
        matrix.preScale(
            1.5f,
            1.5f,
            point1.x.toFloat() + bitmap.width / 2,
            point1.y.toFloat() + bitmap.height / 2
        )
        canvas.save()
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        // 以(point2.x.toFloat() + bitmap.width / 2,point2.y.toFloat() + bitmap.height / 2)为中心点，
        // 进行缩放操作
        matrix.reset()
        matrix.preScale(
            0.5f,
            2.0f,
            point2.x.toFloat() + bitmap.width / 2,
            point2.y.toFloat() + bitmap.height / 2
        )
        canvas.save()
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
