package com.puzzle.collection.array;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class FindMedianOf2DArrays {
    public static void main(String[] args) {
        int[][] array2d = {{21, 14, 13, 12, 15}, {4, 25, 23, 22, 9},
                {4, 7, 8, 98, 24}};
        int[] list = new int[array2d.length * array2d[0].length];

        int listPos = 0;
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d.length; j++) {
                list[listPos++] = array2d[i][j];
            }
        }
        Arrays.sort(list);
        System.out.println(median(list));

    }

    public static double median(int[] m) {
        int middle = m.length / 2;
        if (m.length % 2 == 1) {
            return m[middle];
        } else {
            return (m[middle - 1] + m[middle]) / 2.0;
        }
    }
}
