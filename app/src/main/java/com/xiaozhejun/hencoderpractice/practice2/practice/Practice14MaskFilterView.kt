package com.xiaozhejun.hencoderpractice.practice2.practice

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
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

        // 第一个：NORMAL
        canvas.drawBitmap(bitmap, 100f, 50f, paint)

        // 第二个：INNER
        canvas.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), 50f, paint)

        // 第三个：OUTER
        canvas.drawBitmap(bitmap, 100f, (bitmap.height + 100).toFloat(), paint)

        // 第四个：SOLID
        canvas.drawBitmap(
            bitmap,
            (bitmap.width + 200).toFloat(),
            (bitmap.height + 100).toFloat(),
            paint
        )
    }
}
