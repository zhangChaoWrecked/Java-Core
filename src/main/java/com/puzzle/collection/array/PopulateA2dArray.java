package com.puzzle.collection.array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class PopulateA2dArray {               //填充二维数组 使用随机字母
    public static void main(String[] args) {
        char array[][] = new char[5][5];
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int x = rnd.nextInt(5); // 0 to 4
                switch (x) {
                    case 0: {
                        array[i][j] = 'a';
                        break;
                    }
                    case 1: {
                        array[i][j] = 'b';
                        break;
                    }
                    case 2: {
                        array[i][j] = 'c';
                        break;
                    }
                    case 3: {
                        array[i][j] = 'd';
                        break;
                    }
                    case 4: {
                        array[i][j] = 'e';
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
    }
}
