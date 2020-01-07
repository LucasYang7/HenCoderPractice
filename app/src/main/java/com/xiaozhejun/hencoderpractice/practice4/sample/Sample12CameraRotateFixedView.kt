package com.xiaozhejun.hencoderpractice.practice4.sample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R

class Sample12CameraRotateFixedView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)
    internal var camera = Camera()
    internal var matrix = Matrix()

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        val center1X = point1.x + bitmapWidth / 2
        val center1Y = point1.y + bitmapHeight / 2
        val center2X = point2.x + bitmapWidth / 2
        val center2Y = point2.y + bitmapHeight / 2

        camera.save()
        matrix.reset()
        camera.rotateX(30f)
        camera.getMatrix(matrix)
        camera.restore()
        matrix.preTranslate((-center1X).toFloat(), (-center1Y).toFloat())
        matrix.postTranslate(center1X.toFloat(), center1Y.toFloat())
        canvas.save()
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        camera.save()
        matrix.reset()
        camera.rotateY(30f)
        camera.getMatrix(matrix)
        camera.restore()
        matrix.preTranslate((-center2X).toFloat(), (-center2Y).toFloat())
        matrix.postTranslate(center2X.toFloat(), center2Y.toFloat())
        canvas.save()
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
