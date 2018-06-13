package com.puzzle.collection.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class SortArrayWithCustomizedComparator {
    public static void main(String[] args) {
        String[] strings = {"Here", "are", "some", "sample", "strings", "to",
                "be", "sorted"};

        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int c = s2.length() - s1.length();
                if (c == 0)
                    c = s1.compareToIgnoreCase(s2);
                return c;
            }
        });

        for (String s : strings)
            System.out.print(s + " ");
    }
}
