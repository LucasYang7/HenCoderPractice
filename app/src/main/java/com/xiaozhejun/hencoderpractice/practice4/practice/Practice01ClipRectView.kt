package com.xiaozhejun.hencoderpractice.practice4.practice

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R

class Practice01ClipRectView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val left = (width - bitmap.width) / 2.0f
        val top = (height - bitmap.height) / 2.0f
        canvas?.drawBitmap(bitmap, left, top, paint)
    }
}