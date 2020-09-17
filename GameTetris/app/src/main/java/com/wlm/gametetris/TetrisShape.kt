package com.wlm.gametetris

import kotlin.random.Random

class TetrisShape {
    companion object {
        //所有形状，共28种
        private val shapes = arrayOf(
                // 00 正方形1
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 0, 0)),
                // 01 长条1
                arrayOf(intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 0)),
                // 02 L形1
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 1, 1, 0)),
                // 03 反L形1
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 1, 1, 0)),
                // 04 Z形1
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 1, 1), intArrayOf(0, 0, 0, 0)),
                // 05 反Z形1
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 1, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 0, 0)),
                // 06 山形1
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 1, 1, 1), intArrayOf(0, 0, 0, 0)),

                // 07 正方形2
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 0, 0)),
                // 08 长条2
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(1, 1, 1, 1), intArrayOf(0, 0, 0, 0)),
                // 09 L形2
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 1), intArrayOf(0, 1, 0, 0), intArrayOf(0, 0, 0, 0)),
                // 10 反L形2
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 1, 1, 1), intArrayOf(0, 0, 0, 0)),
                // 11 Z形2
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 0, 0)),
                // 12 反Z形2
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 1, 0)),
                // 13 山形2
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 1), intArrayOf(0, 0, 1, 0)),

                // 14 正方形3
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 0, 0)),
                // 15 长条3
                arrayOf(intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 0)),
                // 16 L形3
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 1, 0)),
                // 17 反L形3
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 1, 0, 0)),
                // 18 Z形3
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 1, 1), intArrayOf(0, 0, 0, 0)),
                // 19 反Z形3
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 1, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 0, 0)),
                // 20 山形3
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 1), intArrayOf(0, 0, 1, 0)),

                // 21 正方形4
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 0, 0)),
                // 22 长条4
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(1, 1, 1, 1), intArrayOf(0, 0, 0, 0)),
                // 23 L形4
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 1), intArrayOf(0, 1, 1, 1), intArrayOf(0, 0, 0, 0)),
                // 24 反L形4
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 1), intArrayOf(0, 0, 0, 1), intArrayOf(0, 0, 0, 0)),
                // 25 Z形4
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 0, 0)),
                // 26 反Z形4
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 1, 0)),
                // 27 山形4
                arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 1, 0))
        )


    }


    var shape: Array<IntArray>
    var shapeIndex: Int
    var left = 3
    var right = 6
    var top = -4
    var bottom = -1

    init {
        shapeIndex = Random(28).nextInt()
        shape = shapes[shapeIndex].clone()
        if (shapeIndex == 13) {
            left = 2
            right = 5
        }
    }

    fun setLocation(left: Int, right: Int, top: Int, bottom: Int) {
        this.left = left
        this.right = right
        this.top = top
        this.bottom = bottom
    }
}