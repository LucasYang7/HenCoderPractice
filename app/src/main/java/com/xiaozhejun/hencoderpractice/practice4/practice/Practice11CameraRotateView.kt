package com.xiaozhejun.hencoderpractice.practice4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R


class Practice11CameraRotateView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)
    internal var camera = Camera()
    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        camera.save()
        camera.rotateX(30f)   // 旋转Camera三维空间
        camera.applyToCanvas(canvas) // 将旋转投影到Canvas
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        camera.restore()
        canvas.restore()

        canvas.save()
        camera.save()
        camera.rotateY(30f)
        camera.applyToCanvas(canvas)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        camera.restore()
        canvas.restore()
    }
}
