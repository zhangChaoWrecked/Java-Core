package com.puzzle.collection.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class ComparingStrinIgnoreCase {
    public static void main(String[] args) {
        String[] sa = new String[] { "a", "c", "d" };
        AlphabeticComparator comp = new AlphabeticComparator();
        Arrays.sort(sa, comp);
        int index = Arrays.binarySearch(sa, sa[10], comp);
        System.out.println("Index = " + index);
    }
}

class AlphabeticComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        return s1.toLowerCase().compareTo(s2.toLowerCase());
    }
}

