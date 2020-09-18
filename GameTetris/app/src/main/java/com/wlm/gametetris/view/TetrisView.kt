package com.wlm.gametetris.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.wlm.gametetris.R
import com.wlm.gametetris.TetrisShape
import com.wlm.gametetris.ext.measureSpace

class TetrisView : View {

    var blockWidth = context.resources.getDimension(R.dimen.dp24)

    private val blockArray = Array(20) {IntArray(10) { 0 }}


    //背景网格画笔
    private val bgPaint: Paint = Paint()
    private val blockPaint: Paint = Paint()

    private var curShape = TetrisShape()
    private var nextShape = TetrisShape()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {
        bgPaint.style = Paint.Style.STROKE
        bgPaint.color = ContextCompat.getColor(context, R.color.dark_grey)
        bgPaint.strokeWidth = context.resources.getDimension(R.dimen.dp1)

        blockPaint.style = Paint.Style.FILL
        blockPaint.color = ContextCompat.getColor(context, R.color.green)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width =
            measureSpace(widthMeasureSpec, context.resources.getDimension(R.dimen.dp240).toInt())
        val height =
            measureSpace(heightMeasureSpec, context.resources.getDimension(R.dimen.dp480).toInt())

        blockWidth = if (width * 2 <= height) {
            width.toFloat() / 10
        } else {
            height.toFloat() / 20
        }
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        blockArray.forEachIndexed { i, intArray ->
            intArray.forEachIndexed { j, num ->
                canvas?.drawRoundRect(j * blockWidth, i * blockWidth,
                    (j + 1) * blockWidth, (i + 1) * blockWidth,
                    context.resources.getDimension(R.dimen.dp3),
                    context.resources.getDimension(R.dimen.dp3),
                    bgPaint
                )
                if (num == 1) {
                    canvas?.drawRoundRect(j * blockWidth, i * blockWidth,
                        (j + 1) * blockWidth, (i + 1) * blockWidth,
                        context.resources.getDimension(R.dimen.dp3),
                        context.resources.getDimension(R.dimen.dp3),
                        blockPaint
                    )
                }
            }
        }

    }
}