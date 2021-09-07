package com.ptm.test

import android.graphics.Color

enum class ColorTheme(internal val colorMap: Map<BlockType, Int>) {
    Theme(
        mapOf(
            Pair(BlockType.Empty, Color.GRAY),
            Pair(BlockType.block1x1, Color.CYAN),
            Pair(BlockType.block1x2, Color.BLUE),
            Pair(BlockType.block1x3, Color.MAGENTA),
            Pair(BlockType.block2x1, Color.YELLOW),
            Pair(BlockType.block2x2, Color.GREEN),
            Pair(BlockType.block3x1, Color.BLUE),
            Pair(BlockType.block3x3, Color.RED),
            Pair(BlockType.block_ml1, Color.BLUE),
            Pair(BlockType.block_ml2, Color.BLUE),
            Pair(BlockType.block_ml3, Color.BLUE),
            Pair(BlockType.block_ml4, Color.BLUE),
            Pair(BlockType.block_L1, Color.BLUE),
            Pair(BlockType.block_L2, Color.BLUE),
            Pair(BlockType.block_L3, Color.BLUE),
            Pair(BlockType.block_L4, Color.BLUE)
        )
    );
}