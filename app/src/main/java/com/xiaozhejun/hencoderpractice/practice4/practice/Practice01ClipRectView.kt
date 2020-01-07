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
        // 保存当前画布的默认绘制范围
        canvas?.save()
        // 绘制的内容将控制在左上角(left + 10f,top + 10f)
        // 与右下角(top + bitmap.height - 10f,left + bitmap.width - 10f)之间
        canvas?.clipRect(
            left + 10f,
            top + 10f,
            top + bitmap.height - 10f,
            left + bitmap.width - 10f
        )
        canvas?.drawBitmap(bitmap, left, top, paint)
        // 抹去上面的clipRect操作，恢复画布save之前的默认绘制范围
        canvas?.restore()
    }
}