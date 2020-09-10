package com.wlm.gametetris.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.wlm.gametetris.R
import com.wlm.gametetris.ext.measureSpace

class TetrisView : View {

    var blockWidth = context.resources.getDimension(R.dimen.dp20)

    //背景网格画笔
    private val bgPaint: Paint = Paint()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {
        bgPaint.color = ContextCompat.getColor(context, R.color.dark_grey)
        bgPaint.strokeWidth = context.resources.getDimension(R.dimen.dp2)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width =
            measureSpace(widthMeasureSpec, context.resources.getDimension(R.dimen.dp250).toInt())
        val height =
            measureSpace(heightMeasureSpec, context.resources.getDimension(R.dimen.dp510).toInt())
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val xNum = (width / blockWidth).toInt()
        val yNum = (height / blockWidth).toInt()
        val startX = (width - xNum * blockWidth) / 2
        val startY = (height - yNum * blockWidth) / 2
        for (i in 0 until yNum) {
            for (j in 0 until xNum) {
                canvas?.drawRoundRect(
                    startX + j * blockWidth, startY + i * blockWidth,
                    startX + (j + 1) * blockWidth, startY + (i + 1) * blockWidth,
                    context.resources.getDimension(R.dimen.dp2),
                    context.resources.getDimension(R.dimen.dp2),
                    bgPaint
                )
            }
        }
    }
}