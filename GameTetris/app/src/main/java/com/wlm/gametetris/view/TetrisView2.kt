package com.wlm.gametetris.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.wlm.gametetris.R
import com.wlm.gametetris.ext.measureSpace

class TetrisView2(context: Context) : View(context) {

    var blockWidth = context.resources.getDimension(R.dimen.dp20).toInt()
    var buttonTextSize = context.resources.getDimension(R.dimen.sp12)
    var gradeTextSize = context.resources.getDimension(R.dimen.sp16)

    //背景网格画笔
    private val bgPaint: Paint = Paint()
    private val gradeTextPaint: Paint = Paint()
    private val buttonTextPaint: Paint = Paint()

    init {
        bgPaint.style = Paint.Style.STROKE
        bgPaint.color = ContextCompat.getColor(context, R.color.dark_grey)
        bgPaint.strokeWidth = context.resources.getDimension(R.dimen.dp1)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width =
            measureSpace(widthMeasureSpec, context.resources.getDimension(R.dimen.dp340).toInt())
        val height =
            measureSpace(heightMeasureSpec, context.resources.getDimension(R.dimen.dp600).toInt())
        if (width / 17 < height / 27) {
            blockWidth = width / 17
        } else {
            blockWidth = height / 27
        }
        buttonTextSize = blockWidth * 0.7f
        gradeTextSize = blockWidth * 0.5f
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }
}