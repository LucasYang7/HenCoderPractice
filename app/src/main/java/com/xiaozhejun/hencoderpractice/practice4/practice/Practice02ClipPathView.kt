package com.xiaozhejun.hencoderpractice.practice4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R


class Practice02ClipPathView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var paint = Paint()
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 200)
    private var point2 = Point(600, 200)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val circlePath1 = Path().apply {
            addCircle(
                point1.x + bitmap.width.toFloat(),
                point1.y + bitmap.height.toFloat(),
                0.8f * bitmap.width.toFloat(),
                Path.Direction.CW
            )
        }

        canvas.save()
        canvas.clipPath(circlePath1)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        val circlePath2 = Path().apply {
            addCircle(
                point2.x + bitmap.width.toFloat(),
                point2.y + bitmap.height.toFloat(),
                0.8f * bitmap.width.toFloat(),
                Path.Direction.CW
            )
            fillType = Path.FillType.INVERSE_WINDING
        }

        canvas.save()
        canvas.clipPath(circlePath2)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
