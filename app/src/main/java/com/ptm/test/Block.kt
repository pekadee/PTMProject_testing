package com.ptm.test

import android.os.Parcel
import android.os.Parcelable
import java.lang.RuntimeException

enum class BlockType(internal val patterns: Array<Array<IntArray>>) {
    // Empty block for empty grid cells
    Empty(arrayOf(arrayOf(intArrayOf(1)))),
    block1x1(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0)
    ))),
    block1x2(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 1),
        intArrayOf(0, 0, 0)
    ))),
    block1x3(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 0, 0)
    ))),
    block2x1(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0)
    ))),
    block3x1(arrayOf(arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0)
    ))),
    block2x2(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 1),
        intArrayOf(0, 1, 1)
    ))),
    block_ml1(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 1)
    ))),
    block_ml2(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(0, 1, 1)
    ))),
    block_ml3(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 1),
        intArrayOf(0, 1, 0)
    ))),
    block_ml4(arrayOf(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 1),
        intArrayOf(0, 0, 1)
    ))),
    block3x3(arrayOf(arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1)
    ))),
    block_L1(arrayOf(arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(1, 0, 0),
        intArrayOf(1, 1, 1)
    ))),
    block_L2(arrayOf(arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(0, 0, 1),
        intArrayOf(1, 1, 1)
    ))),
    block_L3(arrayOf(arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 0),
        intArrayOf(1, 0, 0)
    ))),
    block_L4(arrayOf(arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(0, 0, 1),
        intArrayOf(0, 0, 1)
    )));

    fun next(): BlockType = if (ordinal + 1 < values().size) values()[ordinal + 1] else block1x1

    companion object {
        fun random(): BlockType {
            val result = values().random()
            return if (result == Empty) block1x1 else result
        }
    }
}