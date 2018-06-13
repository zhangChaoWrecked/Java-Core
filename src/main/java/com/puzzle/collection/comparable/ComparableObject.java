package com.puzzle.collection.comparable;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class ComparableObject implements Comparable<ComparableObject> {
    String prodName;

    int prodID;

    ComparableObject(String str, int id) {
        prodName = str;
        prodID = id;
    }

    public int compareTo(ComparableObject p2) {
        return prodName.compareToIgnoreCase(p2.prodName);
    }

    public boolean equals(Object p2) {
        return prodName.compareToIgnoreCase(((ComparableObject) p2).prodName) == 0;
    }


    public static void main(String args[]) {
        Set<ComparableObject> prodList = new TreeSet<ComparableObject>();

        prodList.add(new ComparableObject("A", 13546));
        prodList.add(new ComparableObject("B", 04762));
        prodList.add(new ComparableObject("C", 12221));
        prodList.add(new ComparableObject("D", 44387));

        for (ComparableObject p : prodList)
            System.out.printf("%-14s ID: %d\n", p.prodName, p.prodID);
    }
}
