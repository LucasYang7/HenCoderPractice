package com.xiaozhejun.hencoderpractice.practice4.sample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R


class Sample05RotateView @JvmOverloads constructor(
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

        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height

        canvas.save()
        canvas.rotate(
            180f,
            (point1.x + bitmapWidth / 2).toFloat(),
            (point1.y + bitmapHeight / 2).toFloat()
        )
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        canvas.rotate(
            45f,
            (point2.x + bitmapWidth / 2).toFloat(),
            (point2.y + bitmapHeight / 2).toFloat()
        )
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
