package com.helsing.leetcode.note.structure.array;

import com.helsing.leetcode.editor.cn.*;
import com.helsing.leetcode.note.algorithm.*;

/**
 * 数组
 *
 * @author HelSing
 * @date 2022/3/3
 */
public class Struct_Array {

    public static void main(String[] args) {

    }

    public void algorithm() {
        // 1. 前缀和
        PreSum.main(null);
        // 2. 差分数组
        DiffArray.main(null);
        // 3. 双指针
        TwoPointers.main(null);
        // 4. 二分查找技巧
        BinaryFind.main(null);
        // 5. 滑动窗口算法技巧
        SlideWindow.main(null);
    }

    public void etc() {
        // 二维数组旋转
        Q0048_RotateImage.main(null);

        // 螺旋矩阵
        Q0054_SpiralMatrix.main(null);
        Q0059_SpiralMatrixIi.main(null);

        // 田忌赛马
        Q0870_AdvantageShuffle.main(null);

        // 权重数组
        Q0528_RandomPickWithWeight.main(null);

        // 有序数组去重
        Q0026_RemoveDuplicatesFromSortedArray.main(null);
        Q0283_MoveZeroes.main(null);
    }
}
