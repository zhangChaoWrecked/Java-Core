package com.puzzle.collection.array;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class InsertInOrderMethodForArrayUsingBinarySearch { //利用二进制搜索法按顺序插入数组

    public static void main(String[] args) {
        insertInOrder(6);
        insertInOrder(17);
        insertInOrder(28);
        insertInOrder(-1);
        insertInOrder(19);
        insertInOrder(7);
        insertInOrder(12);

        System.out.println(Arrays.toString(array));

    }

    static int[] array = new int[20];
    static int target = -1;
    static int elements = 0;

    public static void insertInOrder(int n) {
        int pos = Arrays.binarySearch(array, 0, elements, n);
        if (pos < 0)
            pos = ~pos;
        if (pos < elements)
            System.arraycopy(array, pos, array, pos + 1, elements - pos);
        array[pos] = n;
        elements++;
    }
}
