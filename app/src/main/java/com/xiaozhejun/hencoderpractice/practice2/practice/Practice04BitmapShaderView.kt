package com.xiaozhejun.hencoderpractice.practice2.practice

import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R


class Practice04BitmapShaderView : View {
    internal var paint = Paint(ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    init {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
        // 使用Bitmap中的每个像素点作为着色器的颜色值
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.batman)
        val bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = bitmapShader
    }

    protected override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 可以实现头像的圆形效果
        canvas.drawCircle(200f, 200f, 200f, paint)
    }
}