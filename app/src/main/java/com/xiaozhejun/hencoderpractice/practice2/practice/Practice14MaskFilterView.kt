package com.xiaozhejun.hencoderpractice.practice2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.xiaozhejun.hencoderpractice.R


class Practice14MaskFilterView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL 内外都模糊绘制
        paint.maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.NORMAL)
        canvas.drawBitmap(bitmap, 100f, 50f, paint)

        // 第二个：INNER  内部模糊，外部不绘制
        paint.maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.INNER)
        canvas.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), 50f, paint)

        // 第三个：OUTER 内部不绘制，外部模糊
        paint.maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.OUTER)
        canvas.drawBitmap(bitmap, 100f, (bitmap.height + 100).toFloat(), paint)

        // 第四个：SOLID 内部正常绘制，外部模糊
        paint.maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.SOLID)
        canvas.drawBitmap(
            bitmap,
            (bitmap.width + 200).toFloat(),
            (bitmap.height + 100).toFloat(),
            paint
        )
    }
}
