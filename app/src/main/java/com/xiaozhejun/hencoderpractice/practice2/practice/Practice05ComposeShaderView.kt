package com.xiaozhejun.hencoderpractice.practice2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R

class Practice05ComposeShaderView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context,  attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null) // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
        val bitmap1 = BitmapFactory.decodeResource(context.resources, R.drawable.batman)
        val bitmapShader1 = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val bitmap2 = BitmapFactory.decodeResource(context.resources, R.drawable.batman_logo)
        val bitmapShader2 = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        // 注意:bitmapShader1是dst,bitmapShader2是src,PorterDuff.Mode.DST_IN是保留两者相交的dst部分
        val composeShader = ComposeShader(bitmapShader1, bitmapShader2, PorterDuff.Mode.DST_IN)
        paint.shader = composeShader
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(200f, 200f, 200f, paint)
    }
}
